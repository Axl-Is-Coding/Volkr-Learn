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
public abstract class BaseDialogCloseAppBinding extends ViewDataBinding {
    public final Button btnSure;
    public final TextView tvDetails;
    public final TextView tvTitle;

    protected BaseDialogCloseAppBinding(Object obj, View view, int i, Button button, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnSure = button;
        this.tvDetails = textView;
        this.tvTitle = textView2;
    }

    public static BaseDialogCloseAppBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogCloseAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogCloseAppBinding bind(View view, Object obj) {
        return (BaseDialogCloseAppBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_close_app);
    }

    @Deprecated
    public static BaseDialogCloseAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogCloseAppBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_close_app, viewGroup, z, obj);
    }

    public static BaseDialogCloseAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogCloseAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogCloseAppBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_close_app, null, false, obj);
    }
}
