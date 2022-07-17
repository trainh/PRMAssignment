package com.trainh.assignmentprm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trainh.assignmentprm.R;
import com.trainh.assignmentprm.entities.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartAdapterVh> implements Filterable {

    private List<Product> productList;
    private List<Product> getProductListFiltered;
    private Context context;
    public CartAdapter.SelectedProduct selectedProduct;

    public CartAdapter(List<Product> productList, CartAdapter.SelectedProduct selectedProduct) {
        this.productList = productList;
        this.getProductListFiltered = productList;
        this.selectedProduct = selectedProduct;
    }

    @NonNull
    @Override
    public CartAdapter.CartAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new CartAdapter.CartAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_cart,null));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartAdapterVh holder, int position) {

        Product product = productList.get(position);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        holder.cartName.setText(product.getName());
        holder.cartPrice.setText(formatter.format(product.getPrice()));
        holder.item_giohang_image.setImageResource(product.getImage());
        holder.cartQuantity.setText(String.valueOf(product.getQuantity()));
        holder.cartTotal.setText(formatter.format(product.getQuantity() * product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if(charSequence == null | charSequence.length() == 0){
                    filterResults.count = getProductListFiltered.size();
                    filterResults.values = getProductListFiltered;

                }else{
                    String searchChr = charSequence.toString().toLowerCase();

                    List<Product> resultData = new ArrayList<>();

                    for(Product userModel: getProductListFiltered){
                        if(userModel.getName().toLowerCase().contains(searchChr)){
                            resultData.add(userModel);
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;

                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                productList = (List<Product>) filterResults.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }


    public interface SelectedProduct{

        void selectedProduct(Product product);

    }

    public class CartAdapterVh extends RecyclerView.ViewHolder {

        ImageView item_giohang_image;
        TextView cartName;
        TextView cartPrice;
        TextView cartQuantity;
        TextView cartTotal;



        ImageView imIcon;
        public CartAdapterVh(@NonNull View itemView) {
            super(itemView);
            item_giohang_image = itemView.findViewById(R.id.item_giohang_image);
            cartName = itemView.findViewById(R.id.cartName);
            cartPrice = itemView.findViewById(R.id.cartPrice);
            cartQuantity = itemView.findViewById(R.id.cartQuantity);
            cartTotal = itemView.findViewById(R.id.cartTotal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedProduct.selectedProduct(productList.get(getAdapterPosition()));
                }
            });
        }
    }
}
