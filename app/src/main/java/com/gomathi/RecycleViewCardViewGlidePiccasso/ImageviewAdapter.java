package com.gomathi.RecycleViewCardViewGlidePiccasso;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ImageviewAdapter extends RecyclerView.Adapter<ImageviewAdapter.CustomViewHolder> {

    private Context mContext;

    //private List discriptionList; -check for lint
    private ArrayList<dataItemModel> discriptionList;

    /* Holding Layout View for element*/
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_gridview_mage, viewGroup,false);

       // View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_layout_item, viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        dataItemModel dataItem =this.discriptionList.get(i);

        customViewHolder.discriptionTxt.setText(dataItem.getDiscription());

     /*   Glide.with(mContext)
                .load(dataItem.getImageUrl()).
                 apply(new RequestOptions().override(200, 200)
                .error(R.drawable.cat))
                .into(customViewHolder.getImageView());*/


        Picasso.get()
                .load(dataItem.getImageUrl())
                .placeholder(R.drawable.cat)
                .resize(400, 400)
                .error(R.drawable.cat)
                .into(customViewHolder.getImageView());


        //.apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
        //apply(new RequestOptions().override(200, 200))
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
        protected ImageView imageView;

        public ImageView getImageView() {
            return this.imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.discriptionTxt = itemView.findViewById(R.id.txtView_Discription);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
