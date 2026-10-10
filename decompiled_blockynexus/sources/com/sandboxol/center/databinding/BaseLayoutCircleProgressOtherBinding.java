package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.widget.CustomCircleProgressView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLayoutCircleProgressOtherBinding extends ViewDataBinding {
    public final CustomCircleProgressView cpvProgress;
    public final ImageView ivRing;
    public final ImageView ivTick;
    public final TextView tvPercent;
    public final View vShadow;

    protected BaseLayoutCircleProgressOtherBinding(Object obj, View view, int i, CustomCircleProgressView customCircleProgressView, ImageView imageView, ImageView imageView2, TextView textView, View view2) {
        super(obj, view, i);
        this.cpvProgress = customCircleProgressView;
        this.ivRing = imageView;
        this.ivTick = imageView2;
        this.tvPercent = textView;
        this.vShadow = view2;
    }

    public static BaseLayoutCircleProgressOtherBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseLayoutCircleProgressOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseLayoutCircleProgressOtherBinding bind(View view, Object obj) {
        return (BaseLayoutCircleProgressOtherBinding) ViewDataBinding.bind(obj, view, R.layout.base_layout_circle_progress_other);
    }

    @Deprecated
    public static BaseLayoutCircleProgressOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseLayoutCircleProgressOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_circle_progress_other, viewGroup, z, obj);
    }

    public static BaseLayoutCircleProgressOtherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseLayoutCircleProgressOtherBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseLayoutCircleProgressOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_circle_progress_other, null, false, obj);
    }
}
