package com.user.mvvm_sample.view;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.user.mvvm_sample.R;
import com.user.mvvm_sample.databinding.ActivityMainBinding;
import com.user.mvvm_sample.viewmodel.AlbumViewModel;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        AlbumViewModel albumViewModel= ViewModelProviders.of(this).get(AlbumViewModel.class);

        binding.setDataset(albumViewModel);

    }
}
