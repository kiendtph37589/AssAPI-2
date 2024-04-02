package com.kiendtph37589.assigmentapi.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kiendtph37589.assigmentapi.Adapter.ProductAdapter;
import com.kiendtph37589.assigmentapi.Interface.InterSelectProd;
import com.kiendtph37589.assigmentapi.Login;
import com.kiendtph37589.assigmentapi.Model.ProductsModel;
import com.kiendtph37589.assigmentapi.R;
import com.kiendtph37589.assigmentapi.Server.RetrofitClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFrag extends Fragment {
    RecyclerView recycler_home;
    ViewFlipper v_flipper;
    ImageView img_logout;

    ProductAdapter productAdapter;
    List<ProductsModel> listPro = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        recycler_home = view.findViewById(R.id.recyclerView);
        img_logout = view.findViewById(R.id.img_logout_home);
        selectRetrofit();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recycler_home.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(listPro);
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
    String strkq = "";
    List<ProductsModel> listsp;
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
