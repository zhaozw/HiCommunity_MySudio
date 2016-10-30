package cn.hi028.android.highcommunity.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import net.duohuo.dhroid.activity.BaseFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hi028.android.highcommunity.R;
import cn.hi028.android.highcommunity.activity.AutonomousAct_Third;
import cn.hi028.android.highcommunity.adapter.AutoMyMoitionAdapter;
import cn.hi028.android.highcommunity.bean.Autonomous.Auto_CertificationInitBean;

/**
 * @功能：自治大厅 认证失败<br>
 * @作者： Lee_yting<br>
 * @时间：2016/10/11<br>
 */

public class AutoFrag_CerFailed extends BaseFragment {
    public static final String Tag = "~~~CerFailed";
    public static final String FRAGMENTTAG = "AutoFrag_CerFailed";
    /**创建提案**/
    public static final int TAG_CREAT_MOTION=7;
    AutoMyMoitionAdapter mAdapter;
    List<Auto_CertificationInitBean.CertificationInitDataEntity> mList;
    @Bind(R.id.tv_Automotion_Nodata)
    TextView tv_Nodata;
    @Bind(R.id.frag_Automotion_listview)
    ListView mListview;
    @Bind(R.id.img_Automotion_creat)
    ImageButton but_CreatMotion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Tag, "onCreateView");
        View view = inflater.inflate(R.layout.frag_auto_motion, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    void initView() {
        Log.d(Tag, "initView");
//        mList = new ArrayList<Auto_MotionBean.MotionDataEntity>();
////        List<Auto_MotionBean.MotionDataEntity> list, Context context, View view, int screenWidth, ListView listView
//
//DisplayMetrics mdm=new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mdm);
//
//
//        mAdapter = new AutoMyMoitionAdapter(mList, getActivity(), getActivity().getWindow().getDecorView(),mdm.widthPixels,mListview);
//        mListview.setEmptyView(tv_Nodata);
//        mListview.setAdapter(mAdapter);
////        initDatas();
    }

    private void initDatas() {

    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(Tag, "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Tag, "onResume");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.img_Automotion_creat)
    public void onClick() {

        ceratMotion();

    }
    private void ceratMotion() {

        Intent mIntent_report = new Intent(getActivity(), AutonomousAct_Third.class);
        mIntent_report.putExtra("title", TAG_CREAT_MOTION);
//        mIntent_report.putExtra("owner_id", owner_id);
        startActivity(mIntent_report);

    }
    public  void updateList(List<Auto_CertificationInitBean.CertificationInitDataEntity> mList){
        this.mList=mList;

    }

}