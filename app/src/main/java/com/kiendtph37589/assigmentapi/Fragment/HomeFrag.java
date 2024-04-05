package com.kiendtph37589.assigmentapi.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//
//import com.kiendtph37589.assigmentapi.Adapter.CategoryAdapter;
import com.kiendtph37589.assigmentapi.Activity.PersonProfile;
import com.kiendtph37589.assigmentapi.Adapter.ProductAdapter;
import com.kiendtph37589.assigmentapi.Login;
//import com.kiendtph37589.assigmentapi.Model.Category;
import com.kiendtph37589.assigmentapi.Model.ProductsModel;
import com.kiendtph37589.assigmentapi.R;
import com.kiendtph37589.assigmentapi.Server.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFrag extends Fragment {
    RecyclerView recycler_home;
    ViewFlipper v_flipper;
    ImageView img_logout,img_person_profile,img_seach_home;

    ProductAdapter productAdapter;
//    CategoryAdapter categoryAdapter;
    List<ProductsModel> listPro = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        recycler_home = view.findViewById(R.id.recyclerView);
        img_logout = view.findViewById(R.id.img_logout_home);
        img_person_profile = view.findViewById(R.id.img_person_profile);
        img_seach_home = view.findViewById(R.id.img_search_home);
        img_seach_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchDialog();
            }
        });
        img_person_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PersonProfile.class);
                startActivity(intent);
            }
        });
//        categoryAdapter = new CategoryAdapter(getContext());
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//        recycler_home.setLayoutManager(layoutManager);
//
//        categoryAdapter.setData(getListCategory());
//        recycler_home.setAdapter(categoryAdapter);
            selectRetrofit();
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
//        recycler_home.setLayoutManager(layoutManager);
//        recycler_home.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recycler_home.setLayoutManager(layoutManager);
        recycler_home.setHasFixedSize(true);
        productAdapter = new ProductAdapter(listPro,getContext());
        recycler_home.setAdapter(productAdapter);



        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Thông báo!!!");
                builder.setMessage("Are you sure?");
                builder.setIcon(android.R.drawable.ic_popup_reminder);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember", "false");
                        editor.apply();
                        startActivity(new Intent(getContext(),Login.class));

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                Dialog dialog = builder.create();
                dialog.show();
            }
        });

        //slide
        int images[] = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
        v_flipper = view.findViewById(R.id.v_flipper);

        // for loop
        //but i frefer foreach
        for (int image : images){
            flipperImages(image);
        }
    return view;
    }

    private void showSearchDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.search_layout, null);
        EditText editTextSearch = dialogView.findViewById(R.id.edit_text_search);
//        Button buttonSearch = dialogView.findViewById(R.id.button_search);
        builder.setView(dialogView);

        // Xử lý sự kiện khi nhấn nút "Tìm kiếm"
//        buttonSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Lấy dữ liệu từ EditText
//                String searchString = editTextSearch.getText().toString().trim();
//                // Thực hiện tìm kiếm và cập nhật giao diện người dùng
//                performSearch(searchString);
//            }
//        });

        AlertDialog dialog = builder.create();
        dialog.show();

        // Lấy window của dialog để cấu hình các thuộc tính
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            // Thiết lập vị trí của dialog
            layoutParams.gravity = Gravity.TOP;
            // Thiết lập margin cho dialog (nếu cần)
            layoutParams.y = 100; // Điều chỉnh giá trị y để thay đổi vị trí theo nhu cầu
            window.setAttributes(layoutParams);
        }
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Không cần xử lý trước sự thay đổi văn bản
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Không cần xử lý khi văn bản thay đổi
                // Lấy dữ liệu từ EditText
                String searchString = editTextSearch.getText().toString().trim();
                // Thực hiện tìm kiếm và cập nhật giao diện người dùng
                performSearch(searchString);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void performSearch(String searchString) {
        List<ProductsModel> searchResults = new ArrayList<>();
        for (ProductsModel product : listPro) {
            if (product.getTensp().toLowerCase().contains(searchString.toLowerCase())) {
                searchResults.add(product);
            }
        }
        productAdapter.setData(searchResults);
    }

    private void selectRetrofit() {
        RetrofitClient.getRetrofitClient().getProd().enqueue(new Callback<List<ProductsModel>>() {
            @Override
            public void onResponse(Call<List<ProductsModel>> call, Response<List<ProductsModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    listPro.addAll(response.body());
                    productAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<ProductsModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "onFailure" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }
}
