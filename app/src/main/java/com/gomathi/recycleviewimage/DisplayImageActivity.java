package com.gomathi.recycleviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class DisplayImageActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ImageviewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_container);

        mRecyclerView= (RecyclerView) findViewById(R.id.rcv_imageContainer);
        mAdapter = new ImageviewAdapter(this, getList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }


    public ArrayList<dataItemModel> getList (){
        ArrayList<dataItemModel> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataItemModel dataItemModel = new dataItemModel();
            dataItemModel.setDiscription("Welcome Home for the "+ i + " time");
            list.add(dataItemModel);
        }

        return list;

    }
}
