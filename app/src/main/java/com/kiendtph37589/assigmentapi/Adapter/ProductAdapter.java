package com.kiendtph37589.assigmentapi.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiendtph37589.assigmentapi.Activity.Product_details;
import com.kiendtph37589.assigmentapi.Model.ProductsModel;
import com.kiendtph37589.assigmentapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<ProductsModel> ProList;
    private Context context;
    private List<String> favoriteProducts;
    private OnFavoriteClickListener favoriteClickListener;


    public ProductAdapter(List<ProductsModel> proList, Context context) {
        ProList = proList;
        this.context = context;

        favoriteProducts = new ArrayList<>();
    }
    public interface OnFavoriteClickListener{
        void onFavoriteClick(ProductsModel products);
    }
    public void setOnFavoriteClickListener(OnFavoriteClickListener listener){
        this.favoriteClickListener = listener;
    }
    public void addFavoriteProduct(String productId){
        favoriteProducts.add(productId);
    }
    private void removeFavoriteProduct(String productId){
        favoriteProducts.remove(productId);
    }
    public void setData(List<ProductsModel> newData){
        this.ProList = newData;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products_home,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        boolean isFavorite = favoriteProducts.contains(ProList.get(position).get_id());
        if (isFavorite){
            holder.img_love_home.setImageResource(R.drawable.love_red);
        }else {
            holder.img_love_home.setImageResource(R.drawable.love);
        }
        holder.img_love_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favoriteClickListener != null){
                    favoriteClickListener.onFavoriteClick(ProList.get(position));
                }
                if (favoriteProducts.contains(ProList.get(position).get_id())){
                    removeFavoriteProduct(ProList.get(position).get_id());
                    holder.img_love_home.setImageResource(R.drawable.love);
                }else {
                    addFavoriteProduct(ProList.get(position).get_id());
                    holder.img_love_home.setImageResource(R.drawable.love_red);
                }

            }
        });
        holder.tv_Id.setText(ProList.get(position).get_id());
        Picasso.get().load(ProList.get(position).getAnhsp()).into(holder.img_anhsp);
        holder.tv_tensp.setText(ProList.get(position).getTensp());
        holder.tv_khoiluongsp.setText(ProList.get(position).getKhoiluongsp());
        holder.tv_giasp.setText(ProList.get(position).getGiasp());
        holder.btn_add_sp_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Product_details.class);
                intent.putExtra("product_id",ProList.get(position).get_id());
                intent.putExtra("product_image",ProList.get(position).getAnhsp());
                intent.putExtra("product_name",ProList.get(position).getTensp());
                intent.putExtra("product_price",ProList.get(position).getGiasp());
                intent.putExtra("product_weight",ProList.get(position).getKhoiluongsp());
                intent.putExtra("product_describe",ProList.get(position).getMota());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ProList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_love_home,img_anhsp;
        TextView tv_Id,tv_tensp,tv_khoiluongsp,tv_giasp;
        Button btn_add_sp_cart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Id = itemView.findViewById(R.id.tv_Id);
        img_love_home = itemView.findViewById(R.id.img_love_sp);
        img_anhsp = itemView.findViewById(R.id.img_orange_sp);
        tv_tensp = itemView.findViewById(R.id.tv_name_sp);
        tv_khoiluongsp = itemView.findViewById(R.id.tv_weight);
        tv_giasp = itemView.findViewById(R.id.tv_giasp_home);
        btn_add_sp_cart = itemView.findViewById(R.id.btn_add_sp_cart);
        }
    }
}