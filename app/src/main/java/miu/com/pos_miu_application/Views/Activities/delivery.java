package miu.com.pos_miu_application.Views.Activities;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import miu.com.pos_miu_application.R;

public class delivery extends AppCompatActivity {
    Button btnSaveDelivery, btnCloseDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCloseDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSaveDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(delivery.this,"Save successfully!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void addControls() {
        btnSaveDelivery=findViewById(R.id.btnSaveDelivery);
        btnCloseDelivery=findViewById(R.id.btnCloseDelivery);
    }
}