package miu.com.pos_miu_application.views.Fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import  miu.com.pos_miu_application.views.Activities.addCustomer;
import  miu.com.pos_miu_application.views.Activities.delivery;
import miu.com.pos_miu_application.R;
import miu.com.pos_miu_application.views.Adapters.ProductAdapter;
import miu.com.pos_miu_application.views.Adapters.OrderDetailAdapter;
import miu.com.pos_miu_application.views.Models.Product;

public class MainFragment extends Fragment {
    ImageView imgAddCus;
    TextView txtSelection;
    Spinner spnFilter;
    GridView gvProducts;
    ListView lstOrder;
    OrderDetailAdapter orderDetailAdapter;
    ProductAdapter productAdapter;
    Button btnSaveMain, btnReset,btnPBCash,btnPBCard,btnWallet;
    RadioButton rdOrder, rdShipment;
    ArrayList<Product>ds = new ArrayList<>();
    String arr[]={
            "All products",
            "Category",
            "Top  products"};

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

        }catch (Exception ex){}
        addEvents();
        return view;
    }

    private void addEvents() {
        imgAddCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), addCustomer.class);
                startActivity(intent);
            }
        });
        btnSaveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdShipment.isChecked()){
                    Intent intent= new Intent(getActivity(),delivery.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getActivity(),"Save successfully!",Toast.LENGTH_SHORT).show();
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
    }

    private void addData() {
        ds.add(new Product("Barbara High-Waist Super Skinny Ankle in Higher Love",195.00,R.drawable.p1));
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
        orderDetailAdapter = new OrderDetailAdapter(getContext(),R.layout.fragment_main, ds);
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
