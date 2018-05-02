package com.example.campus_comuputer.listviewapplication.coupon_activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.categories_activity.CategoriesRecycleViewAdapter;

import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/26/2018.
 */

public class CouponRecycleViewAdapter extends  RecyclerView.Adapter<CouponRecycleViewAdapter.ViewHolder>{
    private static final String TAG = "CouponRecycleViewAdapte";
    private Context mContext;
    private ArrayList<CouponDataModel> mCouponDataModels = new ArrayList<>();

    public CouponRecycleViewAdapter(Context mContext, ArrayList<CouponDataModel> couponDataModels) {
        this.mContext = mContext;
        this.mCouponDataModels = couponDataModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_coupon_activity, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewCouponTitle.setText(mCouponDataModels.get(position).getCouponTitle());
        holder.textViewCouponExpiryDate.setText(mCouponDataModels.get(position).getCouponExpiryDate());

        if(mCouponDataModels.get(position).getCouponIsSelected()){
                holder.imageViewCouponCheck.setImageResource(R.drawable.ic_check_black_24dp);
            }
        holder.relativeLayoutCoupon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: "+mCouponDataModels.get(position).getCouponTitle());
                Toast.makeText(mContext, mCouponDataModels.get(position).getCouponTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCouponDataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayoutCoupon;
        TextView textViewCouponTitle;
        TextView textViewCouponExpiryDate;
        ImageView imageViewCouponCheck;
        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayoutCoupon = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutCoupon);
            textViewCouponTitle = (TextView) itemView.findViewById(R.id.textViewCouponTitle);
            textViewCouponExpiryDate = (TextView) itemView.findViewById(R.id.textViewCouponExpiryDate);
            imageViewCouponCheck = (ImageView) itemView.findViewById(R.id.imageViewCouponCheckBtn);

        }
    }
}
