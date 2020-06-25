package com.ehome.electpin.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.activity.CollectionInfoActivity;

public class StaffManageAdapter extends RecyclerView.Adapter<StaffManageAdapter.StaffManageViewHolder> {
    private Context mContext;


    public StaffManageAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public StaffManageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_staff_manage, viewGroup, false);
        StaffManageViewHolder viewHolder = new StaffManageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaffManageViewHolder staffManageViewHolder, int i) {

        staffManageViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class StaffManageViewHolder extends RecyclerView.ViewHolder {

        public StaffManageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
