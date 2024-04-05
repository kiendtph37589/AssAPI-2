package com.kiendtph37589.assigmentapi.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kiendtph37589.assigmentapi.Adapter.List_Products_FavoriteApdater;
import com.kiendtph37589.assigmentapi.Adapter.ProductAdapter;
import com.kiendtph37589.assigmentapi.Interface.InterServiceProd;
import com.kiendtph37589.assigmentapi.Model.ProductsModel;
import com.kiendtph37589.assigmentapi.R;
import com.kiendtph37589.assigmentapi.Server.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoveFrag extends Fragment implements ProductAdapter.OnFavoriteClickListener{
    RecyclerView rc_product_favorite;
    List<ProductsModel> listPro = new ArrayList<>();
    List_Products_FavoriteApdater adapter;
    ProductAdapter productAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.love_frag,container,false);

        rc_product_favorite = view.findViewById(R.id.recyclerView_favorite);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rc_product_favorite.setLayoutManager(layoutManager);
        adapter = new List_Products_FavoriteApdater(listPro);
        rc_product_favorite.setAdapter(adapter);

        // Gọi phương thức retrieveFavoriteProductsFromServer() để lấy danh sách sản phẩm yêu thích từ máy chủ
        List<ProductsModel> newFavoriteProductsList = retrieveFavoriteProductsFromServer();
        // Cập nhật danh sách sản phẩm yêu thích
        updateFavoriteProducts(newFavoriteProductsList);
        return view;
    }
    public void updateFavoriteProducts(List<ProductsModel> favoriteProducts) {
        listPro.clear();
        listPro.addAll(favoriteProducts);
        adapter.notifyDataSetChanged();
    }
    // Phương thức retrieveFavoriteProductsFromServer() là nơi bạn gửi yêu cầu đến máy chủ để lấy danh sách sản phẩm yêu thích
    private List<ProductsModel> retrieveFavoriteProductsFromServer() {
        List<ProductsModel> favoriteProductsList = new ArrayList<>();

//         Gửi yêu cầu HTTP đến máy chủ để lấy danh sách sản phẩm yêu thích
//         Xử lý yêu cầu và nhận danh sách sản phẩm yêu thích từ máy chủ
//         Ví dụ:
        RetrofitClient.getRetrofitClient().getProd().enqueue(new Callback<List<ProductsModel>>() {
            @Override
            public void onResponse(Call<List<ProductsModel>> call, Response<List<ProductsModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    favoriteProductsList.addAll(response.body());
                    // Sau khi nhận được dữ liệu, cập nhật giao diện người dùng hoặc lưu trữ vào cơ sở dữ liệu
                    // Cập nhật giao diện người dùng:
                    updateFavoriteProducts(favoriteProductsList);
                }
            }

            @Override
            public void onFailure(Call<List<ProductsModel>> call, Throwable t) {
                t.getMessage();
            }
        });
        return favoriteProductsList;
    }
    @Override
    public void onFavoriteClick(ProductsModel products) {
        // Xử lý sự kiện click vào nút yêu thích ở đây
        if (!listPro.contains(products)) {
            listPro.add(products);
            adapter.notifyDataSetChanged();
            // Hiển thị thông báo hoặc thực hiện các hành động khác sau khi thêm sản phẩm vào danh sách yêu thích
        }
    }
}
