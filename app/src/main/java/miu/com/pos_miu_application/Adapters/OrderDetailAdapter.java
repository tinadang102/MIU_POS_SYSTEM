package miu.com.pos_miu_application.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import miu.com.pos_miu_application.Models.Product;
import miu.com.pos_miu_application.R;

public class OrderDetailAdapter extends ArrayAdapter<Product> {
    public OrderDetailAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_orderdetail,null);
        ImageView imgProduct=v.findViewById(R.id.imgProductDetail);
        TextView txtName=v.findViewById(R.id.txtNameDetail);
        TextView txtPrice=v.findViewById(R.id.txtPriceDetail);

        Product sp = getItem(position);
        imgProduct.setImageResource(sp.getImage());
        txtName.setText(sp.getName());
        txtPrice.setText(String.format("$"+sp.getPrice()));
        return v;
    }
//    Context context;
//    int resource;
//    ArrayList<Product> ds;
//    public OrderDetail(@NonNull Context context, int resource,ArrayList<Product> ds){
//        super(context,resource, ds);
//        this.context = context;
//        this.resource = resource;
//        this.ds=ds;
//    }
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent){
//        View v = convertView;
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        v=inflater.inflate(R.layout.activity_item_orderdetail,null);
//
//        ImageView imgProduct=v.findViewById(R.id.imgProductDetail);
//        TextView txtName=v.findViewById(R.id.txtNameDetail);
//        TextView txtPrice=v.findViewById(R.id.txtPriceDetail);
//
//        Product sp = getItem(position);
//        imgProduct.setImageResource(sp.getImage());
//        txtName.setText(sp.getName());
//        txtPrice.setText(String.format("$"+sp.getPrice()));
//        return v;
//    }
}