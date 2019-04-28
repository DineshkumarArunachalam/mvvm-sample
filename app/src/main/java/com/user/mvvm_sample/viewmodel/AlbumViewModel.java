package com.user.mvvm_sample.viewmodel;




import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.user.mvvm_sample.interfaces.Details;

import com.user.mvvm_sample.model.RetroPhoto;
import com.user.mvvm_sample.service.ReterofitClient;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumViewModel extends ViewModel {

    private List<RetroPhoto> retroPhotos;
    public MutableLiveData<String> bindText=new MutableLiveData<>();



    public MutableLiveData<String> getBindText() {
        return bindText;
    }

    public List<RetroPhoto> getRetroPhotos() {
        if(retroPhotos==null) {
            
            retroPhotos= loadAlbums();
        }
        return retroPhotos;
    }

    private List<RetroPhoto> loadAlbums() {

      Details service= ReterofitClient.getRetrofit().create(Details.class);
      Call<List<RetroPhoto>> data=service.getAllPhotos();

      data.enqueue(new Callback<List<RetroPhoto>>() {
          @Override
          public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
              retroPhotos=response.body();
          }

          @Override
          public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {

          }
      });

        getBindText().setValue("api status");
        return retroPhotos;
    }
}
