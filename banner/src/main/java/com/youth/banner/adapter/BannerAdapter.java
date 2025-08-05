package com.youth.banner.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.R;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.holder.IViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 * 轮播图适配器基类
 * 用于管理轮播图的数据和视图
 * @param <T> 数据类型
 * @param <VH> ViewHolder类型
 */
public abstract class BannerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IViewHolder<T, VH> {
    /**
     * 数据集合
     */
    protected List<T> mDatas = new ArrayList<>();
    
    /**
     * Banner点击事件监听器
     */
    private OnBannerListener<T> mOnBannerListener;
    
    /**
     * ViewHolder实例
     */
    private VH mViewHolder;
    
    /**
     * 增加的数量，用于实现无限轮播
     */
    private int mIncreaseCount = BannerConfig.INCREASE_COUNT;

    /**
     * 构造函数
     * 
     * @param datas 初始数据集合
     */
    public BannerAdapter(List<T> datas) {
        setDatas(datas);
    }

    /**
     * 设置实体集合
     * 
     * @param datas 数据集合
     */
    public void setDatas(List<T> datas) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 获取指定位置的实体
     * 
     * @param position 真实的位置
     * @return 数据实体
     */
    public T getData(int position) {
        if (position > mDatas.size()-1) {
            return null;
        }
        return mDatas.get(position);
    }

    /**
     * 获取指定位置的实体（转换后的位置）
     * 
     * @param position 转换后的位置
     * @return 数据实体
     */
    public T getRealData(int position) {
        int realPosition = getRealPosition(position);
        if (realPosition > mDatas.size()-1) {
            return null;
        }
        return mDatas.get(realPosition);
    }


    /**
     * 绑定ViewHolder数据
     * 
     * @param holder ViewHolder实例
     * @param position 位置
     */
    @Override
    public final void onBindViewHolder(@NonNull VH holder, int position) {
        mViewHolder = holder;
        int real = getRealPosition(position);
        T data = mDatas.get(real);
        holder.itemView.setTag(R.id.banner_data_key, data);
        holder.itemView.setTag(R.id.banner_pos_key, real);
        onBindView(holder, mDatas.get(real), real, getRealCount());
        if (mOnBannerListener != null) {
            holder.itemView.setOnClickListener(view -> mOnBannerListener.OnBannerClick(data, real));
        }
    }

    /**
     * 创建ViewHolder
     * 
     * @param parent 父容器
     * @param viewType 视图类型
     * @return ViewHolder实例
     */
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VH vh = onCreateHolder(parent, viewType);
        vh.itemView.setOnClickListener(v -> {
            if (mOnBannerListener != null) {
                T data = (T) vh.itemView.getTag(R.id.banner_data_key);
                int real = (int) vh.itemView.getTag(R.id.banner_pos_key);
                mOnBannerListener.OnBannerClick(data, real);
            }
        });
        return vh;
    }

    /**
     * 获取item数量
     * 
     * @return item数量
     */
    @Override
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + mIncreaseCount : getRealCount();
    }

    /**
     * 获取真实的数据数量
     * 
     * @return 真实数据数量
     */
    public int getRealCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 获取真实位置
     * 
     * @param position 位置
     * @return 真实位置
     */
    public int getRealPosition(int position) {
        return BannerUtils.getRealPosition(mIncreaseCount == BannerConfig.INCREASE_COUNT, position, getRealCount());
    }

    /**
     * 设置Banner点击事件监听器
     * 
     * @param listener 点击事件监听器
     */
    public void setOnBannerListener(OnBannerListener<T> listener) {
        this.mOnBannerListener = listener;
    }

    /**
     * 获取ViewHolder实例
     * 
     * @return ViewHolder实例
     */
    public VH getViewHolder() {
        return mViewHolder;
    }

    /**
     * 设置增加的数量
     * 
     * @param increaseCount 增加的数量
     */
    public void setIncreaseCount(int increaseCount) {
        this.mIncreaseCount = increaseCount;
    }
}