package com.trainh.assignmentprm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

//    Database database;
//    TextView tvUsername;
//    List<Product> productComputer;
//    List<Product> productKeyboard;
//    RecyclerView rvComputer;
//    RecyclerView rvKeyboard;
//    ProductAdapter productAdapterComputer;
//    ProductAdapter productAdapterKeyboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button btndathang = findViewById(R.id.btndathang);
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dathang();
            }
        });
    }

    private void dathang(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.oder_dialog);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        Button btncontinues = dialog.findViewById(R.id.tieptuc);
        btncontinues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        Button exit = dialog.findViewById(R.id.btnExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
//        private List<Product> getProductComputer() {
//        List<Product> products = new ArrayList<Product>();
//        Cursor dataProduct = database.GetData("SELECT * FROM product WHERE type = 'Máy tính'");
//        while (dataProduct.moveToNext()) {
//            Product product = new Product(dataProduct.getInt(0), dataProduct.getInt(1), dataProduct.getString(2), dataProduct.getDouble(3), dataProduct.getString(4), dataProduct.getString(5));
//            Log.d("product", dataProduct.getString(2));
//            products.add(product);
//        }
//        return products;
//    }
//
//    private List<Product> getProductKeyboard() {
//        List<Product> products = new ArrayList<Product>();
//        Cursor dataProduct = database.GetData("SELECT * FROM product WHERE type = 'Bàn phím'");
//        while (dataProduct.moveToNext()) {
//            Product product = new Product(dataProduct.getInt(0), dataProduct.getInt(1), dataProduct.getString(2), dataProduct.getDouble(3), dataProduct.getString(4), dataProduct.getString(5));
//            Log.d("product", dataProduct.getString(2));
//            products.add(product);
//        }
//        return products;
//    }
//
//    @Override
//    public void selectedProduct(Product product) {
//        Log.d("selected product", product.getName());
//    }
}