package com.user.mvvm_sample.interfaces;

import com.user.mvvm_sample.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Details {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
