package com.example.campus_comuputer.listviewapplication.horizontalRecycleView_activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.shared_classes.RowComponentData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Campus-Comuputer on 4/25/2018.
 */

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "HorizontalRecyclerViewA";
    private ArrayList<RowComponentData> rowComponentData = new ArrayList<>();

    private Context mContext;

    public HorizontalRecyclerViewAdapter(Context mContext, ArrayList<RowComponentData> rowComponentData) {
        this.rowComponentData = rowComponentData;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontallistitem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(rowComponentData.get(position).getUrl())
                .into(holder.image);

        holder.name.setText(rowComponentData.get(position).getName());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an image: "+ rowComponentData.get(position).getName());
                Toast.makeText(mContext, rowComponentData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return rowComponentData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
