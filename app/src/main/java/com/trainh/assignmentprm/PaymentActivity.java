package com.trainh.assignmentprm;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.trainh.assignmentprm.database.Database;
import com.trainh.assignmentprm.entities.Product;

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


//            String selectQuery = "SELECT * FROM cartable";
//            Database database = DatabaseManager.getInstance().openDatabase();
//            Cursor cursor = database.rawQuery(selectQuery, null);
//
//    if (cursor.moveToNext()) {
//                do {
//                    Product product = new product();
//                    product.setId(Integer.parseInt(cursor.getString(0)));
//
//                    product.setName(cursor.getString(1));
//                    product.setPrice(cursor.getString(2));
//                    product.setQuantity(cursor.getString(3));
//                    product.setMealtotal((Double.parseDouble(cursor.getString(3)) * Double.parseDouble(cursor.getString(4)) + ""));
//
//                    Product.add(product);
//
//                } while (cursor.moveToNext());
//            }
//
//            double totalPrices = 0;

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
        Button btnexit = dialog.findViewById(R.id.btnExit);
        btnexit.setOnClickListener(new View.OnClickListener() {
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