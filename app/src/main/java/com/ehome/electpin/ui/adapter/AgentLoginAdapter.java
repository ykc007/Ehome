package com.ehome.electpin.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehome.electpin.R;
import com.fly.tour.common.util.ToastUtil;

public class AgentLoginAdapter extends RecyclerView.Adapter<AgentLoginAdapter.AgentLoginViewHolder> {
    private Context mContext;
    private OnClickAgentListener onClickAgentListener;

    public AgentLoginAdapter(Context context) {
        this.mContext = context;
    }

    public AgentLoginAdapter(Context context, OnClickAgentListener onClickAgentListener) {
        this.mContext = context;
        this.onClickAgentListener = onClickAgentListener;
    }

    @NonNull
    @Override
    public AgentLoginViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_agent_login, viewGroup, false);
        AgentLoginViewHolder viewHolder = new AgentLoginViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AgentLoginViewHolder agentLoginViewHolder, int i) {

        agentLoginViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                if (onClickAgentListener != null) {
                    onClickAgentListener.OnClickListerner();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class AgentLoginViewHolder extends RecyclerView.ViewHolder {

        public AgentLoginViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public interface OnClickAgentListener {
        void OnClickListerner();
    }


}
