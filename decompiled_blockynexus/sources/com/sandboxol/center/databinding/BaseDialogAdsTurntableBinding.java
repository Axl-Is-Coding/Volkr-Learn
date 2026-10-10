package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.adsturntable.AdsTurntableDialog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogAdsTurntableBinding extends ViewDataBinding {
    protected AdsTurntableDialog mAdsTurntableDialog;
    public final RecyclerView rvReward;
    public final TextView textvSelect;
    public final View vSelect;
    public final View view13;
    public final View view14;
    public final View view16;
    public final View view17;

    protected BaseDialogAdsTurntableBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView, View view2, View view3, View view4, View view5, View view6) {
        super(obj, view, i);
        this.rvReward = recyclerView;
        this.textvSelect = textView;
        this.vSelect = view2;
        this.view13 = view3;
        this.view14 = view4;
        this.view16 = view5;
        this.view17 = view6;
    }

    public static BaseDialogAdsTurntableBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogAdsTurntableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public AdsTurntableDialog getAdsTurntableDialog() {
        return this.mAdsTurntableDialog;
    }

    public abstract void setAdsTurntableDialog(AdsTurntableDialog adsTurntableDialog);

    @Deprecated
    public static BaseDialogAdsTurntableBinding bind(View view, Object obj) {
        return (BaseDialogAdsTurntableBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_ads_turntable);
    }

    @Deprecated
    public static BaseDialogAdsTurntableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogAdsTurntableBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_ads_turntable, viewGroup, z, obj);
    }

    public static BaseDialogAdsTurntableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogAdsTurntableBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogAdsTurntableBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_ads_turntable, null, false, obj);
    }
}
