package com.ehome.electpin.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ehome.electpin.R;
import com.ehome.electpin.entity.CallIndex;

import java.util.List;

public  class DallistAapter extends RecyclerView.Adapter<DallistAapter.DallistHodler>
{

    List<CallIndex.DataBean> callindex;
    public DallistAapter(List<CallIndex.DataBean> callindex)
    {
        this.callindex = callindex;
    }

    @NonNull
    @Override
    public DallistHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dallist_item,viewGroup,false);
        DallistHodler viewholder =new DallistHodler(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull DallistHodler viewholder, int i)
    {
        viewholder.custom_tv.setText(callindex.get(i).getName());
        viewholder.daldate_tv.setText(callindex.get(i).getStatus());
        viewholder.dalnum_tv.setText(callindex.get(i).getPhone());
        viewholder.daltime_tv.setText(callindex.get(i).getTime());


    }

    @Override
    public int getItemCount()
    {
        return callindex == null ? 0 : callindex.size();
    }

    class DallistHodler extends RecyclerView.ViewHolder
    {
        TextView custom_tv;
        TextView daldate_tv;
        TextView dalnum_tv;
        TextView daltime_tv;

        public DallistHodler(@NonNull View itemView)
        {
            super(itemView);
            custom_tv = itemView.findViewById(R.id.custom_tv);
            daldate_tv = itemView.findViewById(R.id.daldate_tv);
            dalnum_tv = itemView.findViewById(R.id.dalnum_tv);
            daltime_tv = itemView.findViewById(R.id.daltime_tv);
        }
    }


}
