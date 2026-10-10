package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitRwardsBinding extends ViewDataBinding {
    public final ImageView ivAdd;
    public final ImageView ivAdd2;
    public final ImageView ivAdd3;
    public final ImageView ivAdd4;
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final TextView tvContentRewardDetail1Badge;
    public final TextView tvContentRewardDetail1Title;
    public final TextView tvContentRewardDetail1TitleCount;
    public final TextView tvContentRewardDetail2Nickname;
    public final TextView tvContentRewardDetail2Title;
    public final TextView tvContentRewardDetail2TitleCount;
    public final TextView tvContentRewardDetail3Nickname;
    public final TextView tvContentRewardDetail3Title;
    public final TextView tvContentRewardDetail3TitleCount;
    public final TextView tvContentRewardDetail4Nickname;
    public final TextView tvContentRewardDetail4Title;
    public final TextView tvContentRewardDetail4TitleCount;
    public final ImageView tvContentRewardPerson;
    public final TextView tvContentRewardTips;
    public final View vContentReward;
    public final View vContentRewardDetail1;
    public final View vContentRewardDetail1Title;
    public final View vContentRewardDetail2;
    public final View vContentRewardDetail2Title;
    public final View vContentRewardDetail3;
    public final View vContentRewardDetail3Title;
    public final View vContentRewardDetail4;
    public final View vContentRewardDetail4Title;

    protected VideosubmitRwardsBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ImageView imageView5, TextView textView13, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10) {
        super(obj, view, i);
        this.ivAdd = imageView;
        this.ivAdd2 = imageView2;
        this.ivAdd3 = imageView3;
        this.ivAdd4 = imageView4;
        this.tvContentRewardDetail1Badge = textView;
        this.tvContentRewardDetail1Title = textView2;
        this.tvContentRewardDetail1TitleCount = textView3;
        this.tvContentRewardDetail2Nickname = textView4;
        this.tvContentRewardDetail2Title = textView5;
        this.tvContentRewardDetail2TitleCount = textView6;
        this.tvContentRewardDetail3Nickname = textView7;
        this.tvContentRewardDetail3Title = textView8;
        this.tvContentRewardDetail3TitleCount = textView9;
        this.tvContentRewardDetail4Nickname = textView10;
        this.tvContentRewardDetail4Title = textView11;
        this.tvContentRewardDetail4TitleCount = textView12;
        this.tvContentRewardPerson = imageView5;
        this.tvContentRewardTips = textView13;
        this.vContentReward = view2;
        this.vContentRewardDetail1 = view3;
        this.vContentRewardDetail1Title = view4;
        this.vContentRewardDetail2 = view5;
        this.vContentRewardDetail2Title = view6;
        this.vContentRewardDetail3 = view7;
        this.vContentRewardDetail3Title = view8;
        this.vContentRewardDetail4 = view9;
        this.vContentRewardDetail4Title = view10;
    }

    public static VideosubmitRwardsBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitRwardsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static VideosubmitRwardsBinding bind(View view, Object obj) {
        return (VideosubmitRwardsBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_rwards);
    }

    @Deprecated
    public static VideosubmitRwardsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitRwardsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_rwards, viewGroup, z, obj);
    }

    public static VideosubmitRwardsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitRwardsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitRwardsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_rwards, null, false, obj);
    }
}
