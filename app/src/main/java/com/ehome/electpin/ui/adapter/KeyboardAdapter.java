package com.ehome.electpin.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ehome.electpin.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.KeyboardHolder> {

    private Context context;
    private List<String> datas;
    private List<String> datasdown;
    private OnKeyboardClickListener listener;


    public KeyboardAdapter(Context context, List<String> datas,List<String> datasdown) {
        this.context = context;
        this.datas = datas;
        this.datasdown = datasdown;
    }

    @Override
    public KeyboardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_key_board, parent, false);
        KeyboardHolder holder = new KeyboardHolder(view);
        setListener(holder);
        return holder;
    }

    private void setListener(final KeyboardHolder holder) {
        holder.keybord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onKeyClick(view, holder, holder.getAdapterPosition());
                }
            }
        });
        holder.rlDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onDeleteClick(view, holder, holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(KeyboardHolder holder, int position) {
        if (position == 13) {
            holder.rlDel.setVisibility(View.VISIBLE);
            holder.tvKey.setVisibility(View.GONE);
            holder.tvKey_down.setVisibility(View.GONE);

            holder.keyimage.setImageResource(R.drawable.zidongbohao_l);
           /* holder.tvKey.setText(datas.get(position));
            holder.tvKey.setBackgroundResource(R.drawable.selector_item_del);*/
        } else if (position == 12) {
            holder.rlDel.setVisibility(View.VISIBLE);
            holder.tvKey.setVisibility(View.GONE);
            holder.tvKey_down.setVisibility(View.GONE);
            holder.keyimage.setImageResource(R.drawable.bohaopan);
        }
        else if (position == 14) {
            holder.rlDel.setVisibility(View.VISIBLE);
            holder.tvKey.setVisibility(View.GONE);
            holder.tvKey_down.setVisibility(View.GONE);
            }
        else {
            holder.tvKey.setText(datas.get(position));
            holder.tvKey_down.setText(datasdown.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class KeyboardHolder extends RecyclerView.ViewHolder {

        public TextView tvKey;
        public TextView tvKey_down;
        public RelativeLayout rlDel;
        private View convertView;
        public ImageView keyimage;
        @BindView(R.id.keybord)
        public  View keybord;

        public KeyboardHolder(View itemView) {
            super(itemView);
            convertView = itemView;
            tvKey = itemView.findViewById(R.id.tv_key);
            tvKey_down = itemView.findViewById(R.id.keydown);
            rlDel = itemView.findViewById(R.id.rl_del);
            keyimage= itemView.findViewById(R.id.keyimage);
            ButterKnife.bind(this,itemView);
        }

        public View getconvertView() {
            return convertView;
        }
    }

    public interface OnKeyboardClickListener {

        void onKeyClick(View view, RecyclerView.ViewHolder holder, int position);

        void onDeleteClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    public void setOnKeyboardClickListener(OnKeyboardClickListener listener) {
        this.listener = listener;
    }
}
