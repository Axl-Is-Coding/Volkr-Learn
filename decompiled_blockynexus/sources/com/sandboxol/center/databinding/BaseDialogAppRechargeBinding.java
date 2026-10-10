package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogAppRechargeBinding extends ViewDataBinding {
    public final Button btnSure;
    public final TextView tvDetails;
    public final TextView tvTitle;

    protected BaseDialogAppRechargeBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnSure = button;
        this.tvDetails = textView;
        this.tvTitle = textView2;
    }

    public static BaseDialogAppRechargeBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogAppRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogAppRechargeBinding bind(View view, Object obj) {
        return (BaseDialogAppRechargeBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_app_recharge);
    }

    @Deprecated
    public static BaseDialogAppRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogAppRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_recharge, viewGroup, z, obj);
    }

    public static BaseDialogAppRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogAppRechargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogAppRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_recharge, null, false, obj);
    }
}
