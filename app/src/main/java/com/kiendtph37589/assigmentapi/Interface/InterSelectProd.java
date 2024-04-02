package com.kiendtph37589.assigmentapi.Interface;

import com.kiendtph37589.assigmentapi.Model.ProductsModel;
import com.kiendtph37589.assigmentapi.Server.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterSelectProd {
    @GET("/product")
    Call<List<ProductsModel>> getProd();
}
