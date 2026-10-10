package com.sandboxol.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CommonDialogAppLoadingBinding extends ViewDataBinding {
    public final ImageView ivLoading;

    protected CommonDialogAppLoadingBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivLoading = imageView;
    }

    public static CommonDialogAppLoadingBinding bind(View view) {
        return bind(view, e.a());
    }

    public static CommonDialogAppLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static CommonDialogAppLoadingBinding bind(View view, Object obj) {
        return (CommonDialogAppLoadingBinding) ViewDataBinding.bind(obj, view, R.layout.common_dialog_app_loading);
    }

    @Deprecated
    public static CommonDialogAppLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CommonDialogAppLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.common_dialog_app_loading, viewGroup, z, obj);
    }

    public static CommonDialogAppLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static CommonDialogAppLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CommonDialogAppLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.common_dialog_app_loading, null, false, obj);
    }
}
