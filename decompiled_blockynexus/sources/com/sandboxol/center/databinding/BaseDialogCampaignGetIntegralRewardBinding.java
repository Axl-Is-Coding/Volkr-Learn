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
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogCampaignGetIntegralRewardBinding extends ViewDataBinding {
    public final ImageView ivFlash;
    public final LinearLayout llReward;
    protected CampaignGetIntegralRewardDialog mCampaignGetIntegralRewardDialog;
    public final RelativeLayout rlBg;

    protected BaseDialogCampaignGetIntegralRewardBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.ivFlash = imageView;
        this.llReward = linearLayout;
        this.rlBg = relativeLayout;
    }

    public static BaseDialogCampaignGetIntegralRewardBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogCampaignGetIntegralRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public CampaignGetIntegralRewardDialog getCampaignGetIntegralRewardDialog() {
        return this.mCampaignGetIntegralRewardDialog;
    }

    public abstract void setCampaignGetIntegralRewardDialog(CampaignGetIntegralRewardDialog campaignGetIntegralRewardDialog);

    @Deprecated
    public static BaseDialogCampaignGetIntegralRewardBinding bind(View view, Object obj) {
        return (BaseDialogCampaignGetIntegralRewardBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_campaign_get_integral_reward);
    }

    @Deprecated
    public static BaseDialogCampaignGetIntegralRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogCampaignGetIntegralRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_campaign_get_integral_reward, viewGroup, z, obj);
    }

    public static BaseDialogCampaignGetIntegralRewardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogCampaignGetIntegralRewardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogCampaignGetIntegralRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_campaign_get_integral_reward, null, false, obj);
    }
}
