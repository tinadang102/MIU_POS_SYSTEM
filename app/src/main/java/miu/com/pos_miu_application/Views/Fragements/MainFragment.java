package miu.com.pos_miu_application.Views.Fragements;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import miu.com.pos_miu_application.Adapters.OrderDetailAdapter;
import miu.com.pos_miu_application.Adapters.ProductAdapter;
import miu.com.pos_miu_application.Models.Product;
import miu.com.pos_miu_application.R;
import miu.com.pos_miu_application.Views.Activities.addCustomer;
import miu.com.pos_miu_application.Views.Activities.delivery;


public class MainFragment extends Fragment {
    ImageView imgAddCus,imgHinhCustom;
    TextView txtSelection,txtTenCustom,txtGiaCustom;
    EditText edtCusName,edtTotal, edtPay, edtDiscount,edtReceive,edtReturn;
    Spinner spnFilter;
    GridView gvProducts;
    ListView lstOrder;
    OrderDetailAdapter orderDetailAdapter;
    ProductAdapter productAdapter;
    Button btnSaveMain, btnReset,btnPBCash,btnPBCard,btnWallet,btnAddCustom,btnCloseCustom;
    RadioButton rdOrder, rdShipment;
    ArrayList<Product>ds;
    ArrayList<Product>ds2;
    Intent intent;
    double Total=0;
    String arr[]={
            "All products",
            "Category",
            "Top  products"};
    Product product;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        addViews(view);
        addData();
        try{
            ShowListProduct();
            ShowItemOrder();
            SpinnerFilter();
            TinhTien();

        }catch (Exception ex){}
        addEvents();

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==0 && resultCode==1){
            edtCusName.setHint("");
            edtCusName.setText(data.getStringExtra("ten"));
        }
    }

    private void addEvents() {
        gvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Product sp= productAdapter.getItem(position);
                final Dialog dialog= new Dialog(getContext());
                dialog.setContentView(R.layout.activity_custom_product);

                txtTenCustom= dialog.findViewById(R.id.txtTenCustom);
                txtGiaCustom=dialog.findViewById(R.id.txtPriceCustom);
                imgHinhCustom=dialog.findViewById(R.id.imgHinhCustom);
                btnAddCustom=dialog.findViewById(R.id.btnAddCustom);
                btnCloseCustom=dialog.findViewById(R.id.btnCloseCustom);
                imgHinhCustom.setImageResource(sp.getImage());
                txtTenCustom.setText(sp.getName());
                txtGiaCustom.setText("$"+sp.getPrice());
                dialog.show();
                btnCloseCustom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnAddCustom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ds2.add(productAdapter.getItem(position));
                        orderDetailAdapter = new OrderDetailAdapter(getContext(),R.layout.fragment_main, ds2);
                        lstOrder.setAdapter(orderDetailAdapter);
                        TinhTien();
                        Toast.makeText(getActivity(),"Save successfully!",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
        imgAddCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), addCustomer.class);
                intent.putExtra("n","Add customer");
                startActivityForResult(intent,0);
            }
        });
        btnSaveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdShipment.isChecked()){
                    Intent intent= new Intent(getActivity(), delivery.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getActivity(),"Save successfully!",Toast.LENGTH_SHORT).show();
                Reset();
            }
        });
        btnWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWallet.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                btnPBCard.setBackgroundColor(getResources().getColor(R.color.btnNon));
                btnPBCash.setBackgroundColor(getResources().getColor(R.color.btnNon));
            }
        });
        btnPBCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWallet.setBackgroundColor(getResources().getColor(R.color.btnNon));
                btnPBCard.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                btnPBCash.setBackgroundColor(getResources().getColor(R.color.btnNon));
            }
        });
        btnPBCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWallet.setBackgroundColor(getResources().getColor(R.color.btnNon));
                btnPBCard.setBackgroundColor(getResources().getColor(R.color.btnNon));
                btnPBCash.setBackgroundColor(getResources().getColor(R.color.btnChoose));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
            }
        });
    }
    private  void Reset(){
        lstOrder.setAdapter(null);
        edtTotal.setText("");
        edtDiscount.setText("");
        edtPay.setText("");
        edtReceive.setText("");
        edtReturn.setText("");
        edtCusName.setText("");
    }
    private void TinhTien(){
        for(int i=0;i<ds2.size();i++){
            Total= Total + ds2.get(i).getPrice();
        }
        edtTotal.setText(Total+"");
        edtDiscount.setText(""+0);
        edtPay.setText(Double.parseDouble(edtTotal.getText().toString())-Double.parseDouble(edtDiscount.getText().toString())+"");

    }
    private void addViews(View view) {
        imgAddCus=view.findViewById(R.id.imgAddCus);
        txtSelection=view.findViewById(R.id.txtSelection);
        spnFilter=view.findViewById(R.id.spnFilter);
        gvProducts=view.findViewById(R.id.gvProducts);
        lstOrder=view.findViewById(R.id.lstOrder);
        btnSaveMain=view.findViewById(R.id.btnSaveMain);
        btnReset=view.findViewById(R.id.btnReset);
        rdShipment=view.findViewById(R.id.rdShipment);
        rdOrder=view.findViewById(R.id.rdOrder);
        btnPBCash=view.findViewById(R.id.btnPBCash);
        btnPBCard=view.findViewById(R.id.btnPBCard);
        btnWallet=view.findViewById(R.id.btnWallet);
        edtCusName=view.findViewById(R.id.edtCusName);
        edtTotal=view.findViewById(R.id.edtTotal);
        edtDiscount=view.findViewById(R.id.editDiscount);
        edtPay=view.findViewById(R.id.edtPay);
        edtReceive=view.findViewById(R.id.edtReceive);
        edtReturn=view.findViewById(R.id.edtReturn);
    }
    private void addData() {
        ds=new ArrayList<Product>();
        ds.add(new Product("Higher Love",195.00,R.drawable.p1));
        ds.add(new Product("Frost Printed Hoodie",119.95,R.drawable.p2));
        ds.add(new Product("Revolution 5 EXT",64.95,R.drawable.p3));
        ds.add(new Product("Striped Turtleneck Sweater",69.45,R.drawable.p4));
        ds.add(new Product("Dora 05",130.00,R.drawable.p6));
        ds.add(new Product("Frost Printed Hoodie",39.45,R.drawable.p5));
        ds.add(new Product("Rory Classic Sneaker",78.00,R.drawable.p7));
        ds.add(new Product("Deon",234.95,R.drawable.p8));
        ds.add(new Product("Shearling Boyfriend Pants",275.00,R.drawable.p9));
        ds.add(new Product("Down Shorts",225.00,R.drawable.p10));
        ds.add(new Product("Down Shorts 2",225.00,R.drawable.p11));


        ds.add(new Product("Higher Love",195.00,R.drawable.p1));
        ds.add(new Product("Frost Printed Hoodie",119.95,R.drawable.p2));
        ds.add(new Product("Revolution 5 EXT",64.95,R.drawable.p3));
        ds.add(new Product("Striped Turtleneck Sweater",69.45,R.drawable.p4));
        ds.add(new Product("Dora 05",130.00,R.drawable.p6));
        ds.add(new Product("Frost Printed Hoodie",39.45,R.drawable.p5));
        ds.add(new Product("Rory Classic Sneaker",78.00,R.drawable.p7));
        ds.add(new Product("Deon",234.95,R.drawable.p8));
        ds.add(new Product("Shearling Boyfriend Pants",275.00,R.drawable.p9));
        ds.add(new Product("Down Shorts",225.00,R.drawable.p10));
        ds.add(new Product("Down Shorts 2",225.00,R.drawable.p11));
    }

    private void ShowItemOrder() {
        ds2=new ArrayList<Product>();
        ds2.add(new Product("Higher Love",195.00,R.drawable.p1));
        ds2.add(new Product("Frost Printed Hoodie",119.95,R.drawable.p2));
        orderDetailAdapter = new OrderDetailAdapter(getContext(),R.layout.fragment_main, ds2);
        lstOrder.setAdapter(orderDetailAdapter);

    }

    private void ShowListProduct() {

        productAdapter= new ProductAdapter(getContext(),R.layout.fragment_main, ds);
        gvProducts.setAdapter(productAdapter);
    }

    private void SpinnerFilter() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnFilter.setAdapter(adapter);
        spnFilter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtSelection.setText(arr[position]);
            }
        });
    }

}
