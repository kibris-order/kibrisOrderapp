package com.example.campus_comuputer.listviewapplication.verticalRecycleView_activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.shared_classes.RowComponentData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Campus-Comuputer on 4/23/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<RowComponentData> rowComponentData = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context mContext,ArrayList<RowComponentData> rowComponentData) {
        this.rowComponentData = rowComponentData;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, " onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(rowComponentData.get(position).getUrl())
                .into(holder.image);

        holder.imageName.setText(rowComponentData.get(position).getName());
        holder.imageDescription.setText(rowComponentData.get(position).getDescription());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + rowComponentData.get(position).getName());
                Toast.makeText(mContext, rowComponentData.get(position).getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return rowComponentData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        TextView imageDescription;
        RelativeLayout parentLayout;
       // ImageButton imageButton;
        //this holdes each individual view in memory


        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            imageDescription = itemView.findViewById(R.id.image_description);
           // imageButton = itemView.findViewById(R.id.imageButton);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
