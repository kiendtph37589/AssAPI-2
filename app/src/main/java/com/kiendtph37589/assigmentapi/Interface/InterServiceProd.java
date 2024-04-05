package com.kiendtph37589.assigmentapi.Interface;

import com.kiendtph37589.assigmentapi.Model.ProductsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterServiceProd {
    @GET("/product")
    Call<List<ProductsModel>> getProd();


}
