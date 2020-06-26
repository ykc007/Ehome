package com.ehome.electpin.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.adapter.KeyboardAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2017/6/23.
 */

public class KeyboardView extends RelativeLayout {

    private RelativeLayout rlBack;
    private RecyclerView recyclerView;
    private List<String> datas;
    private List<String> datasdown;
    private KeyboardAdapter adapter;
    private Animation animationIn;
    private Animation animationOut;


    public KeyboardView(Context context) {
        this(context, null);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.layout_key_board, this);
      /*  rlBack = findViewById(R.id.rl_back);
        rlBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) { // 点击关闭键盘
                dismiss();
            }
        });*/
        recyclerView = findViewById(R.id.recycler_view);

        initData();
        initView();
        initAnimation();
    }

    // 填充数据
    private void initData() {
        datasdown =new ArrayList<>();
        datasdown.add("");
        datasdown.add("ABC");
        datasdown.add("DEF");
        datasdown.add("GHI");
        datasdown.add("JKL");
        datasdown.add("MNO");
        datasdown.add("PQRS");
        datasdown.add("TUV");
        datasdown.add("WXYZ");
        datasdown.add("");
        datasdown.add("+");
        datasdown.add("粘贴");
        datasdown.add("");
        datasdown.add("");
        datasdown.add("");

        datas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i < 9) {
                datas.add(String.valueOf(i + 1));
            } else if (i == 9) {
                datas.add("*");
            } else if (i == 10) {
                datas.add("0");
            } else if (i==11){
                datas.add("#");
            }
            else{

                datas.add("");
            }
        }
    }

    // 设置适配器
    private void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new KeyboardAdapter(getContext(), datas,datasdown);
        recyclerView.setAdapter(adapter);
    }

    // 初始化动画效果
    private void initAnimation() {
        animationIn = AnimationUtils.loadAnimation(getContext(), R.anim.keyboard_in);
        animationOut = AnimationUtils.loadAnimation(getContext(), R.anim.keyboard_out);
    }

    // 弹出软键盘
    public void show() {
        startAnimation(animationIn);
        setVisibility(VISIBLE);
    }

    // 关闭软键盘
    public void dismiss() {
        if (isVisible()) {
            startAnimation(animationOut);
            setVisibility(GONE);
        }
    }

    // 判断软键盘的状态
    public boolean isVisible() {
        if (getVisibility() == VISIBLE) {
            return true;
        }
        return false;
    }

    public void setOnKeyBoardClickListener(KeyboardAdapter.OnKeyboardClickListener listener) {
        adapter.setOnKeyboardClickListener(listener);
    }

    public List<String> getDatas() {
        return datas;
    }

    public RelativeLayout getRlBack() {
        return rlBack;
    }
}
