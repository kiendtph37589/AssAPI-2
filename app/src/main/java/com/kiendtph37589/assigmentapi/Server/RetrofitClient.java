package com.kiendtph37589.assigmentapi.Server;

import com.kiendtph37589.assigmentapi.Interface.InterSelectProd;
import com.kiendtph37589.assigmentapi.Model.ProductsModel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
   private static final String BASE_URL = "http://192.168.0.103:5000/";
   private static Retrofit retrofit = null;

   public static InterSelectProd getRetrofitClient(){
       if (retrofit == null){
           retrofit  = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit.create(InterSelectProd.class);
   }
}
