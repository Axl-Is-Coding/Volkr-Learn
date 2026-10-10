package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.widget.CustomCircleProgressView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLayoutCircleProgressBinding extends ViewDataBinding {
    public final ConstraintLayout clMain;
    public final CustomCircleProgressView cpvProgress;
    public final ImageView ivRing;
    public final ImageView ivTick;
    public final TextView tvPercent;
    public final View vShadow;

    protected BaseLayoutCircleProgressBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, CustomCircleProgressView customCircleProgressView, ImageView imageView, ImageView imageView2, TextView textView, View view2) {
        super(obj, view, i);
        this.clMain = constraintLayout;
        this.cpvProgress = customCircleProgressView;
        this.ivRing = imageView;
        this.ivTick = imageView2;
        this.tvPercent = textView;
        this.vShadow = view2;
    }

    public static BaseLayoutCircleProgressBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseLayoutCircleProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseLayoutCircleProgressBinding bind(View view, Object obj) {
        return (BaseLayoutCircleProgressBinding) ViewDataBinding.bind(obj, view, R.layout.base_layout_circle_progress);
    }

    @Deprecated
    public static BaseLayoutCircleProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseLayoutCircleProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_circle_progress, viewGroup, z, obj);
    }

    public static BaseLayoutCircleProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseLayoutCircleProgressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseLayoutCircleProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_circle_progress, null, false, obj);
    }
}
