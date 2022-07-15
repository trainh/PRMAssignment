package com.trainh.assignmentprm.adapter;

public class CartAdapter {
    //extends RecyclerView.Adapter<CartAdapter.MyHolder>{
//    List<Cart> getCartListFiltered;
//    Context context;
//    private List<OrderDetail> cartProList;
//    CartAdapter adapter;
//    public CartAdapter(Context context, ArrayList<OrderDetail> cardItemList) {
//        this.context = context;
//        this.cartProList = cardItemList;
//        this.adapter = this;
//    }
//
////    @NonNull
////    @Override
////    public CartAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart,null);
////        return new MyHolder(v);
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
////        ProductService productService = new ProductService();
////        int pos = position;
////        Product pro = productService.get(cartProList.get(position).getProductId());
////        String orderDetailID = cartProList.get(position).getOderDetailId();
////        int quantity = cartProList.get(position).getQuantity();
////        float price = pro.getPrice();
////        holder.cartName.setText(pro.getName());
////        holder.cartPrice.setText(Float.toString(pro.getPrice()));
////        holder.cartQuantity.setText(Integer.toString(cartProList.get(position).getQuantity()));
////        holder.cartTotal.setText(Float.toString(cartProList.get(position).getTotalUnit()));
////        holder.subtract.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                OrderDetailsService orderDetailService = new OrderDetailsService();
////                if (orderDetailService.UpdateOrderDetail(orderDetailID, quantity - 1, price) == true) {
////                    //thanh cong
////                    String Id = cartProList.get(pos).getOderDetailId();
////                    int qa = orderDetailService.GetOrderDetailByOrderDetailID(Id).getQuantity();
////                    holder.cartQuantity.setText(Integer.toString(qa));
////                    cartProList.get(pos).setQuantity(qa);
////                    adapter.notifyDataSetChanged();
////                }else {
////                    //that bai
////                }
////            }
////        });
////    }
//
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
//    public class MyHolder extends RecyclerView.ViewHolder {
//        TextView cartName;
//        TextView cartPrice;
//        TextView cartQuantity;
//        TextView cartTotal;
//        ImageView subtract, add;
//
//        public MyHolder(@NonNull View itemView) {
//            super(itemView);
//            Context context = itemView.getContext();
//            cartName = itemView.findViewById(R.id.cartName);
//            cartPrice = itemView.findViewById(R.id.cartPrice);
//            cartQuantity = itemView.findViewById(R.id.cartNum);
//            cartTotal = itemView.findViewById(R.id.cartPrice2);
//            subtract = itemView.findViewById(R.id.item_giohang_tru);
//            add = itemView.findViewById(R.id.item_giohang_cong);
//        }
//    }
}
