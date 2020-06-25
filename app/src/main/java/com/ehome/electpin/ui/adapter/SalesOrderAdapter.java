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
import com.ehome.electpin.ui.activity.OrderInfoActivity;
import com.fly.tour.api.entity.SalesOrderEntity;

import java.util.List;

public class SalesOrderAdapter extends RecyclerView.Adapter<SalesOrderAdapter.SalesOrderViewHolder> {
    private Context mContext;
    private List<SalesOrderEntity.SalesOrderBean> mSalesOrderBeans;

    public SalesOrderAdapter(Context context, List<SalesOrderEntity.SalesOrderBean> salesOrderBeans) {
        this.mContext = context;
        this.mSalesOrderBeans = salesOrderBeans;
    }

    @NonNull
    @Override
    public SalesOrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_sales_order, viewGroup, false);
        SalesOrderViewHolder viewHolder = new SalesOrderViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalesOrderViewHolder salesOrderViewHolder, int i) {

        SalesOrderEntity.SalesOrderBean mBean = mSalesOrderBeans.get(i);
        salesOrderViewHolder.tv_money.setText("￥"+mBean.getMoney());
        salesOrderViewHolder.tv_create_time.setText(mBean.getCrdate());
        salesOrderViewHolder.tv_customer_name.setText("客户："+mBean.getName());
        salesOrderViewHolder.tv_deal_time.setText("下单时间："+mBean.getDeal_time());
        salesOrderViewHolder.tv_order_number.setText("订单编号："+mBean.getNumber());

        salesOrderViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderInfoActivity.startOrderInfoActivity(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSalesOrderBeans == null ? 0 : mSalesOrderBeans.size();
    }

    public class SalesOrderViewHolder extends RecyclerView.ViewHolder {
        TextView tv_money;
        TextView tv_create_time;
        TextView tv_customer_name;
        TextView tv_order_number;
        TextView tv_deal_time;

        public SalesOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_money = itemView.findViewById(R.id.tv_money);
            tv_create_time = itemView.findViewById(R.id.tv_create_time);
            tv_customer_name = itemView.findViewById(R.id.tv_customer_name);
            tv_order_number = itemView.findViewById(R.id.tv_order_number);
            tv_deal_time = itemView.findViewById(R.id.tv_deal_time);
        }
    }
}
