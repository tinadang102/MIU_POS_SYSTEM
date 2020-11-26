package miu.com.pos_miu_application.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import miu.com.pos_miu_application.R;

public class custom_product extends AppCompatActivity {
    TextView txtTenCustom,txtMoTaCustom,txtPriceCustom,txtSizeCustom;
    ImageView imgHinhCustom;
    Button SizeXS,SizeS,SizeM,SizeL,SizeXL,SizeXXL,ColorRed,ColorYellow,ColorBlue,ColorBlack,btnGiamCustom,btnAddCustom,btnCloseCustom,btnTangCustom;
    EditText edtSLCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_product);
        addControls();
        addEvent();
    }
    View.OnClickListener myView= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.SizeS:
                    SizeXS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeS.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    SizeM.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.SizeL:
                    SizeXS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeM.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeL.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    SizeXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.SizeM:
                    SizeXS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeM.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    SizeL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.SizeXL:
                    SizeXS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeM.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXL.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    SizeXXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.SizeXXL:
                    SizeXS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeM.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXXL.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                case R.id.SizeXS:
                    SizeXS.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    SizeS.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeM.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    SizeXXL.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.ColorBlack:
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    ColorYellow.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorRed.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.ColorYellow:
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorYellow.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    ColorRed.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.ColorRed:
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorYellow.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorRed.setBackgroundColor(getResources().getColor(R.color.btnChoose));
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnNon));
                case R.id.ColorBlue:
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorYellow.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorRed.setBackgroundColor(getResources().getColor(R.color.btnNon));
                    ColorBlack.setBackgroundColor(getResources().getColor(R.color.btnChoose));

            }
        }
    };
    private void addEvent() {
        SizeXS.setOnClickListener(myView);
        SizeS.setOnClickListener(myView);
        SizeM.setOnClickListener(myView);
        SizeL.setOnClickListener(myView);
        SizeXL.setOnClickListener(myView);
        SizeXXL.setOnClickListener(myView);
        ColorBlack.setOnClickListener(myView);
        ColorBlue.setOnClickListener(myView);
        ColorRed.setOnClickListener(myView);
        ColorYellow.setOnClickListener(myView);

    }

    private void addControls() {
        txtTenCustom=findViewById(R.id.txtTenCustom);
        txtMoTaCustom=findViewById(R.id.txtMoTaCustom);
        txtPriceCustom=findViewById(R.id.txtPriceCustom);
        txtSizeCustom=findViewById(R.id.txtSizeCustom);
        imgHinhCustom=findViewById(R.id.imgHinhCustom);
        btnTangCustom=findViewById(R.id.btnTangCustom);
        btnGiamCustom=findViewById(R.id.btnGiamCustom);
        SizeXS=findViewById(R.id.SizeXS);
        SizeS=findViewById(R.id.SizeS);
        SizeM=findViewById(R.id.SizeM);
        SizeL=findViewById(R.id.SizeL);
        SizeXL=findViewById(R.id.SizeXL);
        SizeXXL=findViewById(R.id.SizeXXL);
        ColorRed=findViewById(R.id.ColorRed);
        ColorYellow=findViewById(R.id.ColorYellow);
        ColorBlue=findViewById(R.id.ColorBlue);
        ColorBlack=findViewById(R.id.ColorBlack);
        btnAddCustom=findViewById(R.id.btnAddCustom);
        btnCloseCustom=findViewById(R.id.btnCloseCustom);
        edtSLCustom=findViewById(R.id.edtSLCustom);
    }
}