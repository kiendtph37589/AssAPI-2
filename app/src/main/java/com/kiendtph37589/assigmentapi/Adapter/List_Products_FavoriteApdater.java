package com.kiendtph37589.assigmentapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiendtph37589.assigmentapi.Model.ProductsModel;
import com.kiendtph37589.assigmentapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class List_Products_FavoriteApdater extends RecyclerView.Adapter<List_Products_FavoriteApdater.ViewHolder>{
    List<ProductsModel> listPro;

    public List_Products_FavoriteApdater(List<ProductsModel> listPro) {
        this.listPro = listPro;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_favorite,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsModel model = listPro.get(position);

        Picasso.get().load(model.getAnhsp()).into(holder.img_anh_sp_yeuthich);
        holder.tv_tensp_yeuthich.setText("Tên sản phẩm: " + model.getTensp());
        holder.tv_giasp_yeuthich.setText("Giá sản phẩm: " + model.getGiasp());
        holder.tv_khoiluongsp_yeuthich.setText("Khối lượng sản phẩm: " + model.getKhoiluongsp());
        holder.btn_Muasp_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btn_xoasp_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listPro.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_anh_sp_yeuthich;
        TextView tv_tensp_yeuthich,tv_giasp_yeuthich,tv_khoiluongsp_yeuthich;
        TextView btn_Muasp_yeuthich, btn_xoasp_yeuthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_anh_sp_yeuthich = itemView.findViewById(R.id.img_anh_sp_yeuthich);
            tv_tensp_yeuthich = itemView.findViewById(R.id.tv_tensp_yeuthich);
            tv_giasp_yeuthich = itemView.findViewById(R.id.tv_giasp_yeuthich);
            tv_khoiluongsp_yeuthich = itemView.findViewById(R.id.tv_khoiluongsp_yeuthich);
            btn_Muasp_yeuthich = itemView.findViewById(R.id.tv_mua_sp_yeuthich);
            btn_xoasp_yeuthich = itemView.findViewById(R.id.tv_xoasp_yeuthich);
        }
    }
}
