package com.kiendtph37589.assigmentapi.Server;

import com.kiendtph37589.assigmentapi.Interface.InterServiceProd;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
   private static final String BASE_URL = "http://192.168.137.1:5000/";
   private static Retrofit retrofit = null;

   public static InterServiceProd getRetrofitClient(){
       if (retrofit == null){
           retrofit  = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit.create(InterServiceProd.class);
   }
}
