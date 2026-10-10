package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogAppLoadingBinding extends ViewDataBinding {
    public final ImageView ivLoading;

    protected BaseDialogAppLoadingBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivLoading = imageView;
    }

    public static BaseDialogAppLoadingBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogAppLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseDialogAppLoadingBinding bind(View view, Object obj) {
        return (BaseDialogAppLoadingBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_app_loading);
    }

    @Deprecated
    public static BaseDialogAppLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogAppLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_loading, viewGroup, z, obj);
    }

    public static BaseDialogAppLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogAppLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogAppLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_app_loading, null, false, obj);
    }
}
