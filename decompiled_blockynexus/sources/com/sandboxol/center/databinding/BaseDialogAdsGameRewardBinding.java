package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.AdsGameRewardDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogAdsGameRewardBinding extends ViewDataBinding {
    public final ImageView ivFlash;
    public final LinearLayout llReward;
    protected AdsGameRewardDialog mAdsGameRewardDialog;
    public final RelativeLayout rlBg;

    protected BaseDialogAdsGameRewardBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.ivFlash = imageView;
        this.llReward = linearLayout;
        this.rlBg = relativeLayout;
    }

    public static BaseDialogAdsGameRewardBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogAdsGameRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public AdsGameRewardDialog getAdsGameRewardDialog() {
        return this.mAdsGameRewardDialog;
    }

    public abstract void setAdsGameRewardDialog(AdsGameRewardDialog adsGameRewardDialog);

    @Deprecated
    public static BaseDialogAdsGameRewardBinding bind(View view, Object obj) {
        return (BaseDialogAdsGameRewardBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_ads_game_reward);
    }

    @Deprecated
    public static BaseDialogAdsGameRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogAdsGameRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_ads_game_reward, viewGroup, z, obj);
    }

    public static BaseDialogAdsGameRewardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogAdsGameRewardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogAdsGameRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_ads_game_reward, null, false, obj);
    }
}
