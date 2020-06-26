package com.ehome.electpin.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.activity.CollectionInfoActivity;
import com.fly.tour.api.entity.CollectionEntity;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ConllectionViewHolder> {
    private Context mContext;
    private List<CollectionEntity.DataBean> mCollections;


    public CollectionAdapter(Context context) {
        this.mContext = context;
    }

    public CollectionAdapter(Context context, List<CollectionEntity.DataBean> mCollections) {
        this.mContext = context;
        this.mCollections = mCollections;
    }


    @NonNull
    @Override
    public ConllectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_collection, viewGroup, false);
        ConllectionViewHolder viewHolder = new ConllectionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConllectionViewHolder conllectionViewHolder, int i) {

        CollectionEntity.DataBean collection = mCollections.get(i);

        conllectionViewHolder.tv_collection_money.setText(collection.getMoney());
        conllectionViewHolder.tv_create_time.setText(collection.getCompany());
        conllectionViewHolder.tv_customer_name.setText(collection.getCompany());
        conllectionViewHolder.tv_collection_time.setText(collection.getTime());
        conllectionViewHolder.tv_collection_type.setText(collection.getType());

        conllectionViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollectionInfoActivity.startCollectionInfoActivity(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCollections == null ? 0 : mCollections.size();
    }

    public class ConllectionViewHolder extends RecyclerView.ViewHolder {
        TextView tv_collection_money;
        TextView tv_create_time;
        TextView tv_customer_name;
        TextView tv_collection_time;
        TextView tv_collection_type;

        public ConllectionViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_collection_money = itemView.findViewById(R.id.tv_collection_money);
            tv_create_time = itemView.findViewById(R.id.tv_create_time);
            tv_customer_name = itemView.findViewById(R.id.tv_customer_name);
            tv_collection_time = itemView.findViewById(R.id.tv_collection_time);
            tv_collection_type = itemView.findViewById(R.id.tv_collection_type);
        }
    }
}
