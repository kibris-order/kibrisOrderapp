package com.example.campus_comuputer.listviewapplication.categories_activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.verticalRecycleView_activity.RecyclerViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Campus-Comuputer on 4/26/2018.
 */

public class CategoriesRecycleViewAdapter extends RecyclerView.Adapter<CategoriesRecycleViewAdapter.ViewHolder> {
    private static final String TAG = "CategoriesRecycleViewAd";
    Context mContext;
        ArrayList<CategoriesDataModel> mCategoriesDataModel = new ArrayList<>();

    public CategoriesRecycleViewAdapter(Context mContext, ArrayList<CategoriesDataModel> mCategoriesDataModel) {
        this.mContext = mContext;
        this.mCategoriesDataModel = mCategoriesDataModel;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_categories_activity, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        Glide.with(mContext).asBitmap().load(mCategoriesDataModel.get(position).getCategoryImageUrl()).into(holder.imageViewCategories);
        holder.textViewCategoriesTitle.setText(mCategoriesDataModel.get(position).getCategoryTitle());

        holder.relativeLayoutCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mCategoriesDataModel.get(position).getCategoryTitle());
                Toast.makeText(mContext, mCategoriesDataModel.get(position).getCategoryTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoriesDataModel.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayoutCategories;
        ImageView imageViewCategories;
        TextView textViewCategoriesTitle;
        public ViewHolder(View itemView) {
            super(itemView);

            relativeLayoutCategories = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutCategories);
            textViewCategoriesTitle = (TextView) itemView.findViewById(R.id.textViewCategoryTitle);
            imageViewCategories = (ImageView) itemView.findViewById(R.id.imageViewCategoryIcon);

        }
    }

}