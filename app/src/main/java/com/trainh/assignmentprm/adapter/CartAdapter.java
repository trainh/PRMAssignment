package com.trainh.assignmentprm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trainh.assignmentprm.R;
import com.trainh.assignmentprm.entities.Cart;
import com.trainh.assignmentprm.entities.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartAdapterVh> {

    private List<Cart> cartList;
    private List<Cart> getCartListFiltered;
    private Context context;
    public CartAdapter.SelectedCart selectedCart;

    public CartAdapter(List<Cart> cartList, CartAdapter.SelectedCart selectedCart) {
        this.cartList = cartList;
        this.getCartListFiltered = cartList;
        this.selectedCart = (CartAdapter.SelectedCart) selectedCart;
    }


    @NonNull
    @Override
    public CartAdapter.CartAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new CartAdapter.CartAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_cart,null));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapterVh holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductAdapterVh holder, int position) {

        Cart cart = cartList.get(position);
        DecimalFormat formatter = new DecimalFormat("#,###,###");

        String username = cart.getName();
        String price = formatter.format(cart.getPrice()) + " vnd";
        int image = cart.getImage();
        holder.tvName.setText(username);
        holder.tvPrice.setText(price);
        holder.ivProduct.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if(charSequence == null | charSequence.length() == 0){
                    filterResults.count = getCartListFiltered.size();
                    filterResults.values = getCartListFiltered;

                }else{
                    String searchChr = charSequence.toString().toLowerCase();

                    List<Cart> resultData = new ArrayList<>();

                    for(Cart userModel: getCartListFiltered){
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

                cartList = (List<Cart>) filterResults.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }


    public interface SelectedCart{

        void selectedCart(Cart cart);

    }

    public class CartAdapterVh extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPrice;
        ImageView ivProduct;

        ImageView imIcon;
        public CartAdapterVh(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivProduct = itemView.findViewById(R.id.ivProduct);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedCart.selectedCart(cartList.get(getAdapterPosition()));
                }
            });
        }
    }

//    @NonNull
//    @Override
//    public CartAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart,null);
//        return new MyHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        ProductService productService = new ProductService();
//        int pos = position;
//        Product pro = productService.get(cartProList.get(position).getProductId());
//        String orderDetailID = cartProList.get(position).getOderDetailId();
//        int quantity = cartProList.get(position).getQuantity();
//        float price = pro.getPrice();
//        holder.cartName.setText(pro.getName());
//        holder.cartPrice.setText(Float.toString(pro.getPrice()));
//        holder.cartQuantity.setText(Integer.toString(cartProList.get(position).getQuantity()));
//        holder.cartTotal.setText(Float.toString(cartProList.get(position).getTotalUnit()));
//        holder.subtract.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OrderDetailsService orderDetailService = new OrderDetailsService();
//                if (orderDetailService.UpdateOrderDetail(orderDetailID, quantity - 1, price) == true) {
//                    //thanh cong
//                    String Id = cartProList.get(pos).getOderDetailId();
//                    int qa = orderDetailService.GetOrderDetailByOrderDetailID(Id).getQuantity();
//                    holder.cartQuantity.setText(Integer.toString(qa));
//                    cartProList.get(pos).setQuantity(qa);
//                    adapter.notifyDataSetChanged();
//                }else {
//                    //that bai
//                }
//            }
//        });
//    }

//    public Filter getFilter() {
//
//        Filter filter = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                FilterResults filterResults = new FilterResults();
//
//                if(charSequence == null | charSequence.length() == 0){
//                    filterResults.count = getCartListFiltered.size();
//                    filterResults.values = getCartListFiltered;
//
//                }else{
//                    String searchChr = charSequence.toString().toLowerCase();
//
//                    List<Cart> resultData = new ArrayList<>();
//
//                    for(Cart cartModel: getCartListFiltered){
//                        if(cartModel.getName().toLowerCase().contains(searchChr)){
//                            resultData.add(cartModel);
//                        }
//                    }
//                    filterResults.count = resultData.size();
//                    filterResults.values = resultData;
//
//                }
//
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//
//                cartProList  = (List<OrderDetail>) filterResults.values;
//                notifyDataSetChanged();
//
//            }
//        };
//        return filter;
//    }
//
//    @Override
//    public int getItemCount() {
//        return cartProList.size();
//    }
//
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView cartName;
        TextView cartPrice;
        TextView cartQuantity;
        TextView cartTotal;
        ImageView subtract, add;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            cartName = itemView.findViewById(R.id.cartName);
            cartPrice = itemView.findViewById(R.id.cartPrice);
            cartQuantity = itemView.findViewById(R.id.cartNum);
            cartTotal = itemView.findViewById(R.id.cartPrice2);
            subtract = itemView.findViewById(R.id.item_giohang_tru);
            add = itemView.findViewById(R.id.item_giohang_cong);
        }
    }

}
