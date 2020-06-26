package com.ehome.electpin.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.electpin.R;
import com.ehome.electpin.entity.CallIndex;
import com.ehome.electpin.ui.adapter.DallistAapter;
import com.ehome.electpin.ui.adapter.KeyboardAdapter;
import com.ehome.electpin.utils.NavigationBarHeightUtils;
import com.ehome.electpin.views.KeyboardView;
import com.fly.tour.common.mvp.BaseMvpFragment;
import com.fly.tour.common.mvp.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public  class DalFragment extends BaseMvpFragment implements KeyboardAdapter.OnKeyboardClickListener,View.OnClickListener
{
    RecyclerView recyclerView ;
    ImageView dal_pop;
    View popupWindow;
    View out_pop;
    View autodal;
    TextView output_tv;
    View action_dal;
    PopupWindow mp;
    PopupWindow mp1;
    private List<String> datas;
    KeyboardView dalbord;

    public EditText editText;
    View navi;

    @Override
    public void onKeyClick(View view, RecyclerView.ViewHolder holder, int position)
    {

        editText.setText(editText.getText().toString().trim() + datas.get(position));
        editText.setSelection(editText.getText().length());
    }

    @Override
    public void onDeleteClick(View view, RecyclerView.ViewHolder holder, int position)
    {


        switch (position) {
            case 12:
                popupWindow.setVisibility(View.GONE);
                break;
            case 13:

                Toast.makeText(getActivity(),editText.getText().toString().trim(),Toast.LENGTH_LONG);
                break;

            case 14:
                String num = editText.getText().toString().trim();
                if (num.length() > 0) {
                    editText.setText(num.substring(0, num.length() - 1));
                    editText.setSelection(editText.getText().length());
                }

                break;
        }
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()== R.id.re){
            Intent i= new Intent();
            i.setAction("com.ehome.electpin.ui.AutoDialAct");
            startActivity(i);

        }
        else if (R.id.output_tv== view.getId()){

            if (mp1.isShowing()) {
                mp1.dismiss();
            } else {
                mp1.showAsDropDown(action_dal,0,0);
                // 作为下拉视图显示
                // mPopupWindow.showAsDropDown(mPopView, Gravity.CENTER, 200, 300);
            }

        }


    }

    @Override
    public BasePresenter initPresenter()
    {
        return null;
    }


    class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0)
                outRect.top = space;
        }
    }


    List<CallIndex.DataBean> calllist = new ArrayList<>();


    @Override
    public int onBindLayout()
    {
        return R.layout.dial_fragment_layout;
    }

    @Override
    public void initView(View view)
    {
        navi = getActivity().findViewById(R.id.navigation);



        CallIndex.DataBean dataBean1 = new CallIndex.DataBean();
        dataBean1.setName("客户1");
        dataBean1.setStatus("1992 -11");
        dataBean1.setPhone("1342898909");
        dataBean1.setTime("5");
        CallIndex.DataBean dataBean2 = new CallIndex.DataBean();
        dataBean2.setName("客户 x 2");
        dataBean2.setStatus("2022 -11");
        dataBean2.setPhone("15179355089");
        dataBean2.setTime("3");
        CallIndex.DataBean dataBean3 = new CallIndex.DataBean();
        dataBean3.setName("客户  x3");
        dataBean3.setStatus("2020 -11");
        dataBean3.setPhone("13870357777");
        dataBean3.setTime("2");
        calllist.add(dataBean1);
        calllist.add(dataBean2);
        calllist.add(dataBean3);

        autodal = view.findViewById(R.id.re);
        output_tv= view.findViewById(R.id.output_tv);
        action_dal = view.findViewById(R.id.action_dal);
        autodal.setOnClickListener(this);
        output_tv.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.customer_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DallistAapter dallistAapter = new DallistAapter(calllist);
        recyclerView.setAdapter(dallistAapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(30));

        out_pop =getLayoutInflater().inflate(R.layout.output_pop,null);
        mp1 = new PopupWindow(out_pop, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mp1.setBackgroundDrawable(new ColorDrawable());
        mp1.setFocusable(true);
        mp1.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        mp1.setOutsideTouchable(true);
       popupWindow =getLayoutInflater().inflate(R.layout.mykey,null);
       dalbord = popupWindow.findViewById(R.id.dalbord);
       datas =dalbord.getDatas();
       editText= dalbord.findViewById(R.id.phon_pop);

       dalbord.setOnKeyBoardClickListener(this);


        mp = new PopupWindow(popupWindow, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        mp.setBackgroundDrawable(new ColorDrawable());
       mp.setOutsideTouchable(true);
        dal_pop = view.findViewById(R.id.dal_pop);

        dal_pop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

              //  keyboardView.show();

                if (mp.isShowing()) {
                    mp.dismiss();
                } else {
                    // 设置PopupWindow 显示的形式 底部或者下拉等
                    // 在某个位置显示
                    popupWindow.setVisibility(View.VISIBLE);




                   // view.getMeasuredWidth(); // 获取宽度
                //    view.getMeasuredHeight(); // 获取高度

                 mp.showAtLocation(popupWindow, Gravity.BOTTOM, 0,navi.getHeight()+ NavigationBarHeightUtils.getNavigationBarHeight(getActivity()));


                    // 作为下拉视图显示
                    // mPopupWindow.showAsDropDown(mPopView, Gravity.CENTER, 200, 300);
                }
            }
        });

    }

    @Override
    public void initData()
    {

    }

    @Override
    public String getToolbarTitle()
    {
        return null;
    }
}
