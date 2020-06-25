package com.ehome.electpin.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehome.electpin.R;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerSeasViewHolder> {
    private Context mContext;


    public CustomerAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public CustomerSeasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_customer, viewGroup, false);
        CustomerSeasViewHolder viewHolder = new CustomerSeasViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerSeasViewHolder salesOrderViewHolder, int i) {

        salesOrderViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.ehome.electpin.ui.CustomDetailsAct");
                salesOrderViewHolder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class CustomerSeasViewHolder extends RecyclerView.ViewHolder {

        public CustomerSeasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
