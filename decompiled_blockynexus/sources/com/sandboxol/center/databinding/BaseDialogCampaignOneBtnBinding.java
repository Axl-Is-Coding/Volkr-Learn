package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.CampaignOneButtonDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogCampaignOneBtnBinding extends ViewDataBinding {
    protected CampaignOneButtonDialog mCampaignOneButtonDialog;
    public final RelativeLayout rlBg;
    public final LinearLayout rlDialog;

    protected BaseDialogCampaignOneBtnBinding(Object obj, View view, int i, RelativeLayout relativeLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.rlBg = relativeLayout;
        this.rlDialog = linearLayout;
    }

    public static BaseDialogCampaignOneBtnBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogCampaignOneBtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public CampaignOneButtonDialog getCampaignOneButtonDialog() {
        return this.mCampaignOneButtonDialog;
    }

    public abstract void setCampaignOneButtonDialog(CampaignOneButtonDialog campaignOneButtonDialog);

    @Deprecated
    public static BaseDialogCampaignOneBtnBinding bind(View view, Object obj) {
        return (BaseDialogCampaignOneBtnBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_campaign_one_btn);
    }

    @Deprecated
    public static BaseDialogCampaignOneBtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogCampaignOneBtnBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_campaign_one_btn, viewGroup, z, obj);
    }

    public static BaseDialogCampaignOneBtnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogCampaignOneBtnBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogCampaignOneBtnBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_campaign_one_btn, null, false, obj);
    }
}
