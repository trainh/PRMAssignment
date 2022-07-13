package com.trainh.assignmentprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.trainh.assignmentprm.entities.Product;

import java.text.DecimalFormat;

public class DetailsActivity extends AppCompatActivity {

    ImageView ivProduct;
    TextView tvName;
    TextView tvPrice;
    TextView tvDescription;
    Button bntSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        DecimalFormat formatter = new DecimalFormat("#,###,###");

        ivProduct = (ImageView) findViewById(R.id.imgProduct);
        tvName = (TextView) findViewById(R.id.tvdName);
        tvPrice = (TextView) findViewById(R.id.tvdPrice);
        tvDescription = (TextView) findViewById(R.id.tvdDescription);
        bntSMS = (Button) findViewById(R.id.bntSMS);

        Intent intent =getIntent();
        if(intent.getExtras() != null){
            Product product = (Product) intent.getSerializableExtra("data");
            ivProduct.setImageResource(product.getImage());
            tvName.setText(product.getName());
            tvPrice.setText(formatter.format(product.getPrice()) + " vnd");
            tvDescription.setText(String.valueOf(product.getDescription()));
        }



        bntSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "0374192404";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
            }
        });
    }

    public static void getSmsDetails(String phoneNumber, String SMSBody) {}
}