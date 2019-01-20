package com.gomathi.recycleviewimage;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageviewAdapter extends RecyclerView.Adapter<ImageviewAdapter.CustomViewHolder> {

    private Context mContext;

    //private List discriptionList; -check for lint
    private ArrayList<dataItemModel> discriptionList;

    /* Holding Layout View for element*/
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_layout_item, viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        dataItemModel discriptionTxt =this.discriptionList.get(i);
        customViewHolder.discriptionTxt.setText(discriptionTxt.getDiscription());
    }

    public ImageviewAdapter(Context context, ArrayList<dataItemModel> discriptionList) {

        this.mContext =context;
        this.discriptionList =discriptionList;
    }

    @Override

    public int getItemCount() {
        return  discriptionList.size() ;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView discriptionTxt;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.discriptionTxt = itemView.findViewById(R.id.txtView_Discription);
        }
    }
}
