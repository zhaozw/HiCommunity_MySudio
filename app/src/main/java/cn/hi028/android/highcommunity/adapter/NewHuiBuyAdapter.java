/***************************************************************************
 * Copyright (c) by raythinks.com, Inc. All Rights Reserved
 **************************************************************************/

package cn.hi028.android.highcommunity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.duohuo.dhroid.util.ImageLoaderUtil;
import net.duohuo.dhroid.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

import cn.hi028.android.highcommunity.R;
import cn.hi028.android.highcommunity.activity.fragment.NewHuiBuyFrag;
import cn.hi028.android.highcommunity.bean.Autonomous.NewSupplyPaydetailBean;
import cn.hi028.android.highcommunity.utils.Constacts;

/**
 *@功能：新版惠生活商品支付adapter<br>
 *@作者： Lee_yting<br>
 *@版本：2.0<br>
 *@时间：2016/12/14<br>
 */
public class NewHuiBuyAdapter extends BaseFragmentAdapter {
    static final String Tag="NewHuiBuyAdapter:";
    NewHuiBuyFrag frag;
    List<NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity> mList=new ArrayList<NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity>();
    Context context;
    LayoutInflater inflater;

    public NewHuiBuyAdapter(NewHuiBuyFrag frag,Context context){
        this.frag=frag;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    public NewHuiBuyAdapter(NewHuiBuyFrag frag,Context context, List<NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity> mList) {
        this.context = context;
        this.mList = mList;
        this.frag = frag;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return  ListUtils.getSize(mList);
    }

    @Override
    public NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(frag.getActivity()).inflate(
                    R.layout.adapter_newsupp_showpaygoods, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_merchant = (TextView) convertView.findViewById(R.id.newsupply_showpay_merchant);
            viewHolder.tv_merchantSum = (TextView) convertView.findViewById(R.id.newsupply_showpay_merchantSum);
            viewHolder.listContainer = (LinearLayout) convertView.findViewById(R.id.newsupply_showpay_goodslist_container);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity mBean = mList.get(position);
        viewHolder.tv_merchant.setText(mBean.getMerchant());
        if (mBean.getTotal_amount()!=-1){
            viewHolder.tv_merchantSum.setText("小计：￥" + mBean.getTotal_amount());
        }
        List<NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity.SupplyPayInfoEntity> mInfoList = mBean.getInfo();
        Log.e(Tag,"mInfoList.size:"+mInfoList.size());
        for (int i = 0; i < mInfoList.size(); i++) {
            Log.e(Tag,"mInfoList.i :"+i);

            NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity.SupplyPayInfoEntity mInfoBean = mInfoList.get(i);
            View mListView = inflater.inflate(R.layout.item_newsupp_showpay, null);
            TextView  tv_goods_name = (TextView) mListView.findViewById(R.id.tv_goods_name);
            TextView tv_goods_total = (TextView) mListView.findViewById(R.id.tv_goods_total);
            TextView tv_goods_price = (TextView) mListView.findViewById(R.id.tv_goods_price);
            TextView tv_standard = (TextView) mListView.findViewById(R.id.tv_goods_standard);
            TextView tv_goods_num = (TextView) mListView.findViewById(R.id.tv_goods_num);
            ImageView img_goods_pic = (ImageView) mListView.findViewById(R.id.img_goods_pic);

            tv_goods_name.setText(mInfoBean.getName());
            tv_goods_price.setText(mInfoBean.getPrice() + "");
//            tv_goods_total.setText("小计：￥" + CommonUtils.f2Bi(mInfoBean.getLittle_amount()));
            tv_goods_total.setText("小计：￥" + mInfoBean.getLittle_amount());
            tv_goods_num.setText("× "+mInfoBean.getNum());
            tv_standard.setText(mInfoBean.getStandard());
            ImageLoaderUtil.disPlay(Constacts.IMAGEHTTP+mInfoBean.getPic(),img_goods_pic,R.mipmap.default_no_pic,null);
            viewHolder.listContainer.addView(mListView);
        }

        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        //TODO 这里需要改
//        frag.orderParams.setGoods(data);
//        frag.updateOrder();
    }
    @Override
    public void AddNewData(Object mObject) {
        if (mObject instanceof List<?>) {
            mList = (List<NewSupplyPaydetailBean.SupplyPayDataEntity.SupplyPayGoodsEntity>) mObject;
        }
        notifyDataSetChanged();
        super.AddNewData(mObject);
    }

    public void ClearData() {
        mList.clear();
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView tv_merchant,tv_merchantSum;
        LinearLayout listContainer;


    }

}

