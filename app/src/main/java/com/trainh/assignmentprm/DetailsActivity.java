package com.trainh.assignmentprm;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.trainh.assignmentprm.adapter.CartAdapter;
import com.trainh.assignmentprm.adapter.ProductAdapter;
import com.trainh.assignmentprm.database.Database;
import com.trainh.assignmentprm.entities.Product;

import java.text.DecimalFormat;

public class DetailsActivity extends AppCompatActivity {

    ImageView ivProduct;
    TextView tvName;
    TextView tvPrice;
    TextView tvDescription;
    Button bntSMS;
    Button btnAddToCart;
    Database database;

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

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectQuery = "SELECT * FROM restaurants";
                Database database = Database.getInstance().openDatabase();
                Cursor dataProduct = database.getDate(selectQuery, null);

                if (dataProduct.moveToNext()) {
                    do {
                        Product product = new Product();
                        product.setId(Integer.parseInt(dataProduct.getString(0)));
                        product.setName(dataProduct.getString(1));
                        product.setPrice(dataProduct.getFloat(2));
                        product.setImage(dataProduct.getInt(3));
                        product.setQuantity(dataProduct.getInt(4));

                        Product.add(product);

                    } while (dataProduct.moveToNext());
                }

                database.close();
                DatabaseManager.getInstance().closeDatabase();

                ProductAdapter = new ProductAdapter(DetailsActivity.this, R.layout.activity_cart, Product);
                listview.setAdapter(ProductAdapter);
                ProductAdapter.notifyDataSetChanged();
            }
            }
        });



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