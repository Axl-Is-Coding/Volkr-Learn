package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ActivityVideoSubmitBinding extends ViewDataBinding {
    public final ImageView imTitleReward;
    public final ImageView ivContentProcessItem1Left;
    public final ImageView ivContentProcessItem2Left;
    public final ImageView ivContentProcessItem3Left;
    public final ImageView ivTitle;
    protected VideoSubmitViewModel mVideoSubmitViewModel;
    public final NestedScrollView nsContent;
    public final TextView textView4;
    public final TextView textView5;
    public final TextView tvContentAwardInGameBadge;
    public final TextView tvContentAwardInGameEffects;
    public final TextView tvContentAwardInGameNickname;
    public final TextView tvContentAwardInGameTitle;
    public final TextView tvContentGames;
    public final TextView tvContentPlanDetail;
    public final TextView tvContentPlanTitle;
    public final TextView tvContentProcessItem1Left;
    public final TextView tvContentProcessItem2Left;
    public final TextView tvContentProcessItem3Left;
    public final TextView tvContentProcessTitle;
    public final TextView tvContentSignupTips;
    public final TextView tvContentTotalCubes;
    public final VideosubmitRwardsBinding vAward;
    public final View vBottom;
    public final View vContent;
    public final View vContentAwards;
    public final View vContentGames;
    public final View vContentPlan;
    public final View vContentPlanDivide;
    public final View vContentProcess;
    public final View vContentProcessItem1;
    public final View vContentProcessItem2;
    public final View vContentProcessItem3;
    public final View vContentSignupTips;
    public final View vContentTimeDetailArrow1;
    public final View vContentTimeDetailArrow2;
    public final VideosubmitEventRulesBinding vEventRules;
    public final VideosubmitGamesBinding vGames;
    public final VideosubmitVideoThemesBinding vThemes;
    public final VideosubmitTipsBinding vTips;
    public final VideosubmitWinnersBinding vWinners;

    protected ActivityVideoSubmitBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, VideosubmitRwardsBinding videosubmitRwardsBinding, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, View view12, View view13, View view14, VideosubmitEventRulesBinding videosubmitEventRulesBinding, VideosubmitGamesBinding videosubmitGamesBinding, VideosubmitVideoThemesBinding videosubmitVideoThemesBinding, VideosubmitTipsBinding videosubmitTipsBinding, VideosubmitWinnersBinding videosubmitWinnersBinding) {
        super(obj, view, i);
        this.imTitleReward = imageView;
        this.ivContentProcessItem1Left = imageView2;
        this.ivContentProcessItem2Left = imageView3;
        this.ivContentProcessItem3Left = imageView4;
        this.ivTitle = imageView5;
        this.nsContent = nestedScrollView;
        this.textView4 = textView;
        this.textView5 = textView2;
        this.tvContentAwardInGameBadge = textView3;
        this.tvContentAwardInGameEffects = textView4;
        this.tvContentAwardInGameNickname = textView5;
        this.tvContentAwardInGameTitle = textView6;
        this.tvContentGames = textView7;
        this.tvContentPlanDetail = textView8;
        this.tvContentPlanTitle = textView9;
        this.tvContentProcessItem1Left = textView10;
        this.tvContentProcessItem2Left = textView11;
        this.tvContentProcessItem3Left = textView12;
        this.tvContentProcessTitle = textView13;
        this.tvContentSignupTips = textView14;
        this.tvContentTotalCubes = textView15;
        this.vAward = videosubmitRwardsBinding;
        setContainedBinding(this.vAward);
        this.vBottom = view2;
        this.vContent = view3;
        this.vContentAwards = view4;
        this.vContentGames = view5;
        this.vContentPlan = view6;
        this.vContentPlanDivide = view7;
        this.vContentProcess = view8;
        this.vContentProcessItem1 = view9;
        this.vContentProcessItem2 = view10;
        this.vContentProcessItem3 = view11;
        this.vContentSignupTips = view12;
        this.vContentTimeDetailArrow1 = view13;
        this.vContentTimeDetailArrow2 = view14;
        this.vEventRules = videosubmitEventRulesBinding;
        setContainedBinding(this.vEventRules);
        this.vGames = videosubmitGamesBinding;
        setContainedBinding(this.vGames);
        this.vThemes = videosubmitVideoThemesBinding;
        setContainedBinding(this.vThemes);
        this.vTips = videosubmitTipsBinding;
        setContainedBinding(this.vTips);
        this.vWinners = videosubmitWinnersBinding;
        setContainedBinding(this.vWinners);
    }

    public static ActivityVideoSubmitBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ActivityVideoSubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public VideoSubmitViewModel getVideoSubmitViewModel() {
        return this.mVideoSubmitViewModel;
    }

    public abstract void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel);

    @Deprecated
    public static ActivityVideoSubmitBinding bind(View view, Object obj) {
        return (ActivityVideoSubmitBinding) ViewDataBinding.bind(obj, view, R.layout.activity_video_submit);
    }

    @Deprecated
    public static ActivityVideoSubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityVideoSubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_video_submit, viewGroup, z, obj);
    }

    public static ActivityVideoSubmitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ActivityVideoSubmitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityVideoSubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_video_submit, null, false, obj);
    }
}
