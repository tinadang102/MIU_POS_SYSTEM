package miu.com.pos_miu_application.views.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import miu.com.pos_miu_application.R;
import miu.com.pos_miu_application.views.Models.Product;

public class item_product extends BaseAdapter {
    private List<Product> lst;
    private LayoutInflater layoutInflater;
    private Context context;
    public item_product(Context aContext,List<Product> lst){
        this.context=aContext;
        this.lst=lst;
        layoutInflater=LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}