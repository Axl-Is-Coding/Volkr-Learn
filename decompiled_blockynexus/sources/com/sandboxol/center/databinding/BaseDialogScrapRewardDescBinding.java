package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogScrapRewardDescBinding extends ViewDataBinding {
    public final View bgView;
    protected ScrapRewardDescriptionDialog mViewModel;
    public final TextView tvDesc;
    public final TextView tvRewardName;
    public final TextView tvValue;
    public final TextView tvValueRight;
    public final View vBank;
    public final View vLine;

    protected BaseDialogScrapRewardDescBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view3, View view4) {
        super(obj, view, i);
        this.bgView = view2;
        this.tvDesc = textView;
        this.tvRewardName = textView2;
        this.tvValue = textView3;
        this.tvValueRight = textView4;
        this.vBank = view3;
        this.vLine = view4;
    }

    public static BaseDialogScrapRewardDescBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogScrapRewardDescBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public ScrapRewardDescriptionDialog getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(ScrapRewardDescriptionDialog scrapRewardDescriptionDialog);

    @Deprecated
    public static BaseDialogScrapRewardDescBinding bind(View view, Object obj) {
        return (BaseDialogScrapRewardDescBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_scrap_reward_desc);
    }

    @Deprecated
    public static BaseDialogScrapRewardDescBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogScrapRewardDescBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_scrap_reward_desc, viewGroup, z, obj);
    }

    public static BaseDialogScrapRewardDescBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogScrapRewardDescBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogScrapRewardDescBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_scrap_reward_desc, null, false, obj);
    }
}
