package miu.com.pos_miu_application.Views.Activities;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import miu.com.pos_miu_application.R;

public class addCustomer extends FragmentActivity {
    Button btnSave,btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addCustomer.this,"Save successfully!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        btnSave= findViewById(R.id.btnSaveDelivery);
        btnClose=findViewById(R.id.btnCloseDelivery);
    }
}