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
import com.ehome.electpin.ui.activity.ContractInfoActivity;
import com.ehome.electpin.ui.activity.OrderInfoActivity;
import com.fly.tour.api.entity.ContractEntity;

import java.util.List;

public class ContractAdapter extends RecyclerView.Adapter<ContractAdapter.ContractViewHolder> {
    private Context mContext;
    private List<ContractEntity.ContractBean> mContractBeans;


    public ContractAdapter(Context context, List<ContractEntity.ContractBean> contractBeans) {
        this.mContext = context;
        this.mContractBeans = contractBeans;
    }

    @NonNull
    @Override
    public ContractViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_contract, viewGroup, false);
        ContractViewHolder viewHolder = new ContractViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContractViewHolder contractViewHolder, int i) {

        ContractEntity.ContractBean mBean = mContractBeans.get(i);
        contractViewHolder.tv_contract_title.setText(mBean.getTitle());
        contractViewHolder.tv_create_time.setText(mBean.getCrdate());
        contractViewHolder.tv_customer_name.setText("客户：" + mBean.getName());
        contractViewHolder.tv_start_time.setText("开始时间：" + mBean.getStart_time());
        contractViewHolder.tv_end_time.setText("结束时间：" + mBean.getEnd_time());
        contractViewHolder.tv_contract_number.setText("合同编号：" + mBean.getNumber());

        contractViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContractInfoActivity.startContractInfoActivity(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mContractBeans == null ? 0 : mContractBeans.size();
    }

    public class ContractViewHolder extends RecyclerView.ViewHolder {
        TextView tv_contract_title;
        TextView tv_create_time;
        TextView tv_customer_name;
        TextView tv_contract_number;
        TextView tv_start_time;
        TextView tv_end_time;

        public ContractViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_contract_title = itemView.findViewById(R.id.tv_contract_title);
            tv_create_time = itemView.findViewById(R.id.tv_create_time);
            tv_customer_name = itemView.findViewById(R.id.tv_customer_name);
            tv_contract_number = itemView.findViewById(R.id.tv_contract_number);
            tv_start_time = itemView.findViewById(R.id.tv_start_time);
            tv_end_time = itemView.findViewById(R.id.tv_end_time);
        }
    }
}
