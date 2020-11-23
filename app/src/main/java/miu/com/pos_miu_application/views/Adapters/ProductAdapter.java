package miu.com.pos_miu_application.views.Adapters;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import miu.com.pos_miu_application.R;
import miu.com.pos_miu_application.views.Models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> objects) {
        super(context, resource, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_product,null);

        ImageView imgProduct=v.findViewById(R.id.imgProductDetail);
        TextView txtName=v.findViewById(R.id.txtName);
        TextView txtPrice=v.findViewById(R.id.txtPriceDetail);

        Product sp=getItem(position);
        imgProduct.setImageResource(sp.getImage());
        txtName.setText(sp.getName());
//        txtPrice.setText(""+sp.getPrice());
        return v;
    }
}
