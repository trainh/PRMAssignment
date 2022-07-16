package com.trainh.assignmentprm.entities;


import android.database.Cursor;
import android.util.Log;

import com.trainh.assignmentprm.database.Database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductService {
    Database database;


    public ArrayList<Product> getProducts(String proName) {
        ArrayList<Product> listProCategory = null;
        try{
            if (database.GetData(proName) != null) {
                Cursor dataPro = database.GetData("select * from Product where ProductID = (select ProductID from Product Where ProductName = '"+ proName +"') ");
                listProCategory = new ArrayList<>();
                while (dataPro.moveToNext()) {
                    String image = dataPro.getString("image");
                    String name = dataPro.getString("name");
                    float price = dataPro.getFloat("Price");
                    String quantity = dataPro.getString("Quantity");
                    Product product = new Product(image, name, price, quantity);
                    listProCategory.add(product);
                    Log.d("product", dataPro.getString(2));
                    Product.add(product);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProCategory;
    }


}
