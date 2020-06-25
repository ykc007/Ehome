package com.ehome.electpin.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.electpin.R;
import com.ehome.electpin.ui.adapter.AgentLoginAdapter;
import com.ehome.electpin.ui.adapter.StaffManageAdapter;
import com.fly.tour.common.mvp.BaseActivity;
import com.fly.tour.common.util.ToastUtil;
import com.refresh.lib.BaseRefreshLayout;
import com.refresh.lib.DaisyRefreshLayout;

public class AgentLoginActivity extends BaseActivity implements AgentLoginAdapter.OnClickAgentListener {

    RecyclerView recview;
    DaisyRefreshLayout daisy_refresh_layout;

    public static void startAgentLoginActivity(Context context) {
        Intent intent = new Intent(context, AgentLoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_agent_login;
    }

    @Override
    public void initView() {
        mToolbar.setVisibility(View.GONE);
        headerSetting(this, "代理登录", false, false);

        recview = findViewById(R.id.recyclerview);
        daisy_refresh_layout = findViewById(R.id.daisy_refresh_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recview.setLayoutManager(layoutManager);

        daisy_refresh_layout.setOnRefreshListener(new BaseRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        daisy_refresh_layout.setRefreshing(false);
                    }
                }, 1000 * 3);
            }
        });

        daisy_refresh_layout.setOnLoadMoreListener(new BaseRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        daisy_refresh_layout.setLoadMore(false);
                    }
                }, 1000 * 3);
            }
        });

        daisy_refresh_layout.setOnAutoLoadListener(new DaisyRefreshLayout.OnAutoLoadListener() {
            @Override
            public void onAutoLoad() {
                Toast.makeText(getBaseContext(), "开始加载数据了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void initData() {
        AgentLoginAdapter agentLoginAdapter = new AgentLoginAdapter(this, this);
        recview.setAdapter(agentLoginAdapter);
    }

    /**
     * 设置头部
     *
     * @param title
     * @param isGoneLeftIv
     * @param isGoneRightIv
     */
    public void headerSetting(final Context context, String title, boolean isGoneLeftIv, boolean isGoneRightIv) {
        LinearLayout ll_right = findViewById(R.id.ll_right);
        LinearLayout ll_left = findViewById(R.id.ll_left);
        ImageView iv_left = findViewById(R.id.iv_left);
        ImageView iv_right = findViewById(R.id.iv_right);
        TextView tv_left = findViewById(R.id.tv_left);
        TextView tv_right = findViewById(R.id.tv_right);
        TextView tv_center = findViewById(R.id.tv_center);

        tv_center.setText(title);

        iv_left.setVisibility(View.VISIBLE);
        tv_left.setVisibility(View.GONE);
        if (isGoneLeftIv) {
            iv_left.setVisibility(View.GONE);
            tv_left.setVisibility(View.VISIBLE);
            tv_left.setText("");
        }

        iv_right.setVisibility(View.VISIBLE);
        tv_right.setVisibility(View.GONE);
        if (isGoneRightIv) {
            iv_right.setVisibility(View.GONE);
            tv_right.setVisibility(View.VISIBLE);
            tv_right.setText("编辑");
        }


        ll_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        ll_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void OnClickListerner() {
        initAgentPayPopupWindow();
    }

    public void initAgentPayPopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_agent_login_layout, null);

        TextView tv_cancle = contentView.findViewById(R.id.tv_cancle);
        TextView tv_confirm = contentView.findViewById(R.id.tv_confirm);
        TextView tv_select_staff_account = contentView.findViewById(R.id.tv_select_staff_account);
        RecyclerView agent_pop_recview = contentView.findViewById(R.id.agent_pop_recview);
        RadioGroup rg_agent_login = contentView.findViewById(R.id.rg_agent_login);


        tv_select_staff_account.setVisibility(View.GONE);
        agent_pop_recview.setVisibility(View.GONE);

        final PopupWindow mPopupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);


        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
            }
        });

        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
            }
        });

        rg_agent_login.check(R.id.rb_month);
    }
}
