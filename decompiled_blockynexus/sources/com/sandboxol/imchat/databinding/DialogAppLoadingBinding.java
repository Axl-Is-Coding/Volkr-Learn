package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DialogAppLoadingBinding extends ViewDataBinding {
    public final ImageView ivLoading;

    protected DialogAppLoadingBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.ivLoading = imageView;
    }

    public static DialogAppLoadingBinding bind(View view) {
        return bind(view, e.a());
    }

    public static DialogAppLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static DialogAppLoadingBinding bind(View view, Object obj) {
        return (DialogAppLoadingBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_app_loading);
    }

    @Deprecated
    public static DialogAppLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAppLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_app_loading, viewGroup, z, obj);
    }

    public static DialogAppLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static DialogAppLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAppLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_app_loading, null, false, obj);
    }
}
