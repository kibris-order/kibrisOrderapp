package com.example.campus_comuputer.listviewapplication.paymentRequired_activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.campus_comuputer.listviewapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/26/2018.
 */

public class PaymentRequiredAdapter extends RecyclerView.Adapter<PaymentRequiredAdapter.ViewHolder> {
    private static final String TAG = "PaymentRequiredAdapter";
    Context mContext;
    ArrayList<PaymentRequiredDataModel> mPaymentRequiredDataModels= new ArrayList<>();

    public PaymentRequiredAdapter(Context mContext, ArrayList<PaymentRequiredDataModel> mPaymentRequiredDataModels) {
        this.mContext = mContext;
        this.mPaymentRequiredDataModels = mPaymentRequiredDataModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_paymentrequired_activity, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.textViewOrderId.setText("Order ID:"+mPaymentRequiredDataModels.get(position).getOrderId());
        holder.textViewOrderTotal.setText("US $"+mPaymentRequiredDataModels.get(position).calculateTotalAmount());
        holder.textViewOrderQuantity.setText("Quantity:"+mPaymentRequiredDataModels.get(position).getOrderQuantity());
        Glide.with(mContext).asBitmap().load(mPaymentRequiredDataModels.get(position).getOrderProductImageUrl()).into(holder.imageViewOrderImage);
        holder.textViewOrderProductName.setText(mPaymentRequiredDataModels.get(position).getOrderProductTitle());
        holder.textViewOrderProductPrice.setText("US $"+mPaymentRequiredDataModels.get(position).getOrderProductPrice());
        holder.textViewOrderQuantityx.setText("x"+mPaymentRequiredDataModels.get(position).getOrderQuantity());
        holder.relativeLayoutPaymentRequired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked");
                Toast.makeText(mContext, mPaymentRequiredDataModels.get(position).getOrderProductTitle() + "Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        holder.linearLayoutViewOrderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: View Detail of "+mPaymentRequiredDataModels.get(position).getOrderProductTitle() + "Clicked");
                Toast.makeText(mContext, "View Detail of "+mPaymentRequiredDataModels.get(position).getOrderProductTitle() + "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPaymentRequiredDataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewOrderId;
        TextView textViewOrderTotal;
        TextView textViewOrderQuantity;
        ImageView imageViewOrderImage;
        TextView textViewOrderProductName;
        TextView textViewOrderProductPrice;
        TextView textViewOrderQuantityx;
        RelativeLayout relativeLayoutPaymentRequired;
        LinearLayout linearLayoutViewOrderDetail;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewOrderId = itemView.findViewById(R.id.textViewOrderId);
            textViewOrderTotal = itemView.findViewById(R.id.textViewOrderTotalAmount);
            textViewOrderQuantity = itemView.findViewById(R.id.textViewOrderQuantity);
            imageViewOrderImage = itemView.findViewById(R.id.imageViewOrderImage);
            textViewOrderProductName = itemView.findViewById(R.id.textViewOrderProductName);
            textViewOrderProductPrice = itemView.findViewById(R.id.textViewOrderProductPrice);
            textViewOrderQuantityx = itemView.findViewById(R.id.textViewOrderQuantityx);
            relativeLayoutPaymentRequired = itemView.findViewById(R.id.relativeLayoutPaymentRequired);
            linearLayoutViewOrderDetail = itemView.findViewById(R.id.linerLayoutOrderViewDetail);

        }
    }
}
