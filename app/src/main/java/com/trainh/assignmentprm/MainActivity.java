package com.trainh.assignmentprm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trainh.assignmentprm.adapter.ProductAdapter;
import com.trainh.assignmentprm.database.Database;
import com.trainh.assignmentprm.entities.Account;
import com.trainh.assignmentprm.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database database;
    EditText edUsername;
    EditText edPassword;
    Button btLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(getApplicationContext());


        edUsername = (EditText) findViewById(R.id.etUsername);
        edPassword = (EditText) findViewById(R.id.etPassword);
        btLogin = (Button) findViewById(R.id.btLogin);


        edUsername.setText("hoangtrai");
        edPassword.setText("1");

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = checkLogin();
                if (username != null) {
                    SharedPreferences settings = getApplicationContext().getSharedPreferences("username", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("username", username);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        database.createAccount(new Account("hoangtrai", "1"));
        database.createProduct(new Product(R.drawable.nitro5, "Laptop Gaming Acer Nitro 5 AN515 45 R6EV", 19490000, 50, "Máy tính", ""));
        database.createProduct(new Product(R.drawable.nitro5, "Laptop Gaming Acer Nitro 5 Eagle AN515 57 5669", 19490000, 50, "Máy tính", ""));
        database.createProduct(new Product(R.drawable.nitro5, "Laptop gaming Acer Nitro 5 Eagle AN515 57 54MV", 21990000, 50, "Máy tính", ""));
        database.createProduct(new Product(R.drawable.nitro5, "Laptop Gaming Acer Nitro 5 AN515 57 71VV", 22990000, 50, "Máy tính", ""));
        database.createProduct(new Product(R.drawable.nitro5, "Laptop Gaming Acer Nitro 5 Eagle AN515 57 720A", 23990000, 50, "Máy tính", ""));
        database.createProduct(new Product(R.drawable.keyboard, "Bàn phím cơ AKKO 3108 Plus Prunus Lannesiana", 1589000, 50, "Bàn phím", ""));
        database.createProduct(new Product(R.drawable.keyboard, "Bàn phím AKKO 3068 v2 RGB White", 159900, 50, "Bàn phím", ""));
        database.createProduct(new Product(R.drawable.keyboard, "Bàn phím cơ AKKO ACR87 Blue", 1699000, 50, "Bàn phím", ""));
        database.createProduct(new Product(R.drawable.keyboard, "Bàn phím cơ AKKO ACR87 Black", 2290000, 50, "Bàn phím", ""));
        database.createProduct(new Product(R.drawable.keyboard, "Bàn phím AKKO ACR Pro Alice Plus", 289900, 50, "Bàn phím", ""));

        Cursor dataAccount = database.GetData("SELECT * FROM account");

        while (dataAccount.moveToNext()) {
            Account account = new Account(dataAccount.getString(1), dataAccount.getString(2));
            Log.d("user", dataAccount.getString(0));
            Log.d("password", dataAccount.getString(1));
        }

    }

    private String checkLogin() {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        Cursor dataAccount = database.GetData("SELECT * FROM account WHERE username = '" + username + "'" + " AND " + "password = '" + password + "'");
        if (dataAccount.moveToFirst()) {
            return username;
        }
        return null;
    }
}