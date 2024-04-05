package com.kiendtph37589.assigmentapi.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiendtph37589.assigmentapi.R;

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.ViewHolder>{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_anhsp,img_edit_sp,img_delete_sp;
        TextView tv_tensp,tv_giasp,tv_khoiluongsp,tv_soLuong, tv_motasp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_anhsp = itemView.findViewById(R.id.img_anh_sp_list);
            img_edit_sp = itemView.findViewById(R.id.img_editsp_list);
            img_delete_sp = itemView.findViewById(R.id.img_deletesp_list);
            tv_tensp = itemView.findViewById(R.id.tv_tensp_list);
            tv_giasp = itemView.findViewById(R.id.tv_giasp_list);
            tv_khoiluongsp = itemView.findViewById(R.id.tv_khoiluongsp_list);
            tv_soLuong = itemView.findViewById(R.id.tv_soluongsp_list);
            tv_motasp = itemView.findViewById(R.id.tv_motasp_list);
        }
    }
}
