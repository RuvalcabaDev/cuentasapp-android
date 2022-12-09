package com.example.cuentasapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cuentasapp.tools.ImageViewCircleTransform;

import java.security.MessageDigest;


@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {
    int wizard_page_position;

    public MainFragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.main_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String url = "https://www.cuentasapp.com/images/logo_size_invert.jpg";

        ImageView img = (ImageView) view.findViewById(R.id.imagePage1);
        loadImageRequest(img, url);

        return view;
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(getActivity())
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()) {
                    @Override
                    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

                    }
                })
                .thumbnail(0.01f)
                .centerCrop()
                .into(img);
    }
}
