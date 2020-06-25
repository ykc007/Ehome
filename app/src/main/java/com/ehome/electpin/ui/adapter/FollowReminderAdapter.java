package com.ehome.electpin.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.activity.CollectionInfoActivity;

public class FollowReminderAdapter extends RecyclerView.Adapter<FollowReminderAdapter.ConllectionViewHolder> {
    private Context mContext;


    public FollowReminderAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ConllectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_follow_reminder, viewGroup, false);
        ConllectionViewHolder viewHolder = new ConllectionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConllectionViewHolder salesOrderViewHolder, int i) {

        salesOrderViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollectionInfoActivity.startCollectionInfoActivity(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ConllectionViewHolder extends RecyclerView.ViewHolder {

        public ConllectionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
