package com.example.contactapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {
    private static final String TAG = "recyclerAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages= new ArrayList<>();
    private Context mcontext;
    private boolean attachToRoot;
    private int positon;
    private String msg;

    public recyclerAdapter(Context context, ArrayList<String> images, ArrayList<String> ImageNames) {
        mImages = images;
        mImageNames = ImageNames;
        mcontext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent, attachToRoot:false) ;
        ViewHolder holder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Log.d (TAG, msg:"onBindViewHolder:called.") ;

        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(positon))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d(TAG, msg: "onClick: clicked on:" + mImageNames.get(position))

                Toast.makeText(mcontext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageNames.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView ImageName;
        ConstraintLayout parentLayout;


        public ViewHolder( View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            ImageName = itemView.findViewById(R.id.im1);
            parentLayout = itemView.findViewById(R.id.parent_Layout);



        }
    }
}
