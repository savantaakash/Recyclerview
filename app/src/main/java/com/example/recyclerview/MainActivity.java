package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    int[] mPlaceList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mPlaceList = new int[]{R.drawable.imag_1, R.drawable.imag_2, R.drawable.imag_3,
                R.drawable.imag_4, R.drawable.imag_5, R.drawable.imag_6};

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, mPlaceList);
        mRecyclerView.setAdapter(myAdapter);
    }
}