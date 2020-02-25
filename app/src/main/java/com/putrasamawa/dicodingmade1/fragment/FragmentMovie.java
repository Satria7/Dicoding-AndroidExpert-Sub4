package com.putrasamawa.dicodingmade1.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.putrasamawa.dicodingmade1.adapter.AdapterMovie;
import com.putrasamawa.dicodingmade1.R;
import com.putrasamawa.dicodingmade1.model.ItemMovie;
import com.putrasamawa.dicodingmade1.viewmodel.ViewModelMovie;

import java.util.List;

//* Satria Junanda *//

public class FragmentMovie extends Fragment {
    RecyclerView rey;
    ProgressBar progressBar;
    private ViewModelMovie viewModelMovie;
    AdapterMovie adapter;
    private GridLayoutManager layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment, container, false);
        rey = root.findViewById(R.id.recyclerView);
        progressBar = root.findViewById(R.id.myprogress);

        viewModelMovie = ViewModelProviders.of(this).get(ViewModelMovie.class);
        getPopularMovie();

        return root;
    }

    private void getPopularMovie() {
        viewModelMovie.getAllBlog().observe(this, new Observer<List<ItemMovie>>() {
            @Override
            public void onChanged(@Nullable List<ItemMovie> blogList) {
                prepareRecyclerView(blogList);
                showLoading(false);
            }
        });
    }


    private void prepareRecyclerView(List<ItemMovie> movieList) {

        adapter = new AdapterMovie(movieList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rey.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            rey.setLayoutManager(new GridLayoutManager(getContext(), 3));

        }
        rey.setItemAnimator(new DefaultItemAnimator());
        rey.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        showLoading(false);

    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}

//* Satria Junanda *//