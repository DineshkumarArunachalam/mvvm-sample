package com.user.mvvm_sample.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.user.mvvm_sample.util.Constants.BASE_URL;

public class ReterofitClient {

    private static Retrofit retrofit=null;


    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
            .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;


    }

}
