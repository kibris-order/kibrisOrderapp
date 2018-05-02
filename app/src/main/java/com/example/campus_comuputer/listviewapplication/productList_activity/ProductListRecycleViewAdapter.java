package com.example.campus_comuputer.listviewapplication.productList_activity;

import android.content.Context;
import android.graphics.Paint;
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

import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/27/2018.
 */

public class ProductListRecycleViewAdapter extends RecyclerView.Adapter<ProductListRecycleViewAdapter.ViewHolder> {
    private static final String TAG = "ProductListRecycleViewA";
    private Context mContext;
    private ArrayList<ProductListDataModel> mProductListDataModels = new ArrayList<>();

    public ProductListRecycleViewAdapter(Context mContext, ArrayList<ProductListDataModel> mProductListDataModels) {
        Log.d(TAG, "ProductListRecycleViewAdapter: Called");
        this.mContext = mContext;
        this.mProductListDataModels = mProductListDataModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Called");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleview_productlist_activity, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.textViewProductListProductName.setText(mProductListDataModels.get(position).getProductName());
        holder.textViewProductListProductPrice.setText("US $"+mProductListDataModels.get(position).getProductPrice());

        holder.textViewProductListProductOldPrice.setText("US $"+mProductListDataModels.get(position).getProductOldPrice());
        holder.textViewProductListProductOldPrice.setPaintFlags( holder.textViewProductListProductOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(mContext)
                .asBitmap()
                .load(mProductListDataModels.get(position).getProductImageUrl())
                .into(holder.imageViewProductListProductImage);

       holder.textViewProductListProductDiscountPercentage.setText(mProductListDataModels.get(position).getProductDiscountPercentage()+"% OFF");

       if(mProductListDataModels.get(position).isProductHasFreeShipping()){
           holder.textViewProductListProductHasFreeShipping.setText("Free Shipping");
       }else{
           holder.textViewProductListProductHasFreeShipping.setText("");
       }

        holder.textViewProductListProductNumOfOrders.setText(mProductListDataModels.get(position).getProductNumOfOrders()+" Orders");
       holder.relativeLayoutProductList.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d(TAG, "onClick: Clicked"+mProductListDataModels.get(position).getProductName());
               Toast.makeText(mContext, mProductListDataModels.get(position).getProductName(), Toast.LENGTH_SHORT).show();
           }
       });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return mProductListDataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewProductListProductName;
        TextView textViewProductListProductPrice;
        TextView textViewProductListProductOldPrice;
        ImageView imageViewProductListProductImage;
        TextView textViewProductListProductDiscountPercentage;
        TextView textViewProductListProductHasFreeShipping;
        TextView textViewProductListProductNumOfOrders;
        RelativeLayout relativeLayoutProductList;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewProductListProductName = (TextView) itemView.findViewById(R.id.textViewProductListProductName);
            textViewProductListProductPrice = (TextView) itemView.findViewById(R.id.textViewProductListProductPrice);
            textViewProductListProductOldPrice = (TextView) itemView.findViewById(R.id.textViewProductListProductOldPrice);
            imageViewProductListProductImage = (ImageView) itemView.findViewById(R.id.imageViewProductListImage);
            textViewProductListProductDiscountPercentage = (TextView) itemView.findViewById(R.id.textViewProductListDiscountPercentage);
            textViewProductListProductHasFreeShipping = (TextView) itemView.findViewById(R.id.textViewProductListHasFreeShipping);
            textViewProductListProductNumOfOrders = (TextView) itemView.findViewById(R.id.textViewProductListNumOfOrders);
            relativeLayoutProductList = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutProductList);


        }
    }
}
