//package com.kiendtph37589.assigmentapi.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.kiendtph37589.assigmentapi.Model.Category;
//import com.kiendtph37589.assigmentapi.R;
//
//import java.util.List;
//
//public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
//    private Context context;
//    private List<Category> mlistCategory;
//
//    public CategoryAdapter(Context context) {
//        this.context = context;
//    }
//    public void setData(List<Category> list){
//        this.mlistCategory = list;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
//
//        return new CategoryViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//        Category category = mlistCategory.get(position);
//        if (category == null){
//            return;
//        }
//
//        holder.tv_Name_Category.setText(category.getNameCategory());
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
//        holder.rc_product.setLayoutManager(layoutManager);
//        ProductAdapter productAdapter = new ProductAdapter();
////        productAdapter.setData(category.getVegetable());
//        holder.rc_product.setAdapter(productAdapter);
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mlistCategory != null){
//            return mlistCategory.size();
//        }
//        return 0;
//    }
//
//    public class CategoryViewHolder extends RecyclerView.ViewHolder{
//
//        TextView tv_Name_Category;
//        RecyclerView rc_product;
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tv_Name_Category = itemView.findViewById(R.id.tv_name_category);
//            rc_product = itemView.findViewById(R.id.recyclerView_product);
//        }
//    }
//}
