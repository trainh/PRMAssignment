package com.trainh.assignmentprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.trainh.assignmentprm.adapter.CartAdapter;
import com.trainh.assignmentprm.adapter.ProductAdapter;
import com.trainh.assignmentprm.database.Database;
import com.trainh.assignmentprm.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.SelectedProduct{

    Database database;
    CartAdapter cartAdapter;
    RecyclerView rvCart;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        database = new Database(getApplicationContext());
        rvCart = (RecyclerView) findViewById(R.id.rvCart);

        LinearLayoutManager linearLayoutManagerCart = new LinearLayoutManager(this);
        linearLayoutManagerCart.setOrientation(LinearLayoutManager.VERTICAL);

        rvCart.setLayoutManager(linearLayoutManagerCart);
        productList = getProductComputer();
        cartAdapter = new CartAdapter(productList, this);
        rvCart.setAdapter(cartAdapter);
    }
    private List<Product> getProductComputer() {
        List<Product> products = new ArrayList<Product>();
        Cursor dataProduct = database.GetData("SELECT product.id, product.image, product.name, product.price, cart.quantity FROM cart INNER JOIN product ON cart.idProduct = product.id");
        while (dataProduct.moveToNext()) {
            Product product = new Product(dataProduct.getInt(0), dataProduct.getInt(1), dataProduct.getString(2), dataProduct.getDouble(3), dataProduct.getInt(4));
            Log.d("product", dataProduct.getString(2));
            products.add(product);
        }
        return products;
    }

    @Override
    public void selectedProduct(Product product) {
//        Log.d("product", product.getName());
//        Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("data", product);
//        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}