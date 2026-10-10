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
public abstract class BaseDialogOneButtonBinding extends ViewDataBinding {
    public final Button btnSure;
    public final TextView tvDetails;
    public final TextView tvTitle;

    protected BaseDialogOneButtonBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnSure = button;
        this.tvDetails = textView;
        this.tvTitle = textView2;
    }

    public static BaseDialogOneButtonBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogOneButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogOneButtonBinding bind(View view, Object obj) {
        return (BaseDialogOneButtonBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_one_button);
    }

    @Deprecated
    public static BaseDialogOneButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogOneButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_one_button, viewGroup, z, obj);
    }

    public static BaseDialogOneButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogOneButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogOneButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_one_button, null, false, obj);
    }
}
