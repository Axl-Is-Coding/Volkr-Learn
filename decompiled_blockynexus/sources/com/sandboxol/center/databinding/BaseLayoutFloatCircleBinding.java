package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.widget.CircleProgressView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLayoutFloatCircleBinding extends ViewDataBinding {
    public final CircleProgressView cpvProgress;
    public final ImageView ivPic;
    public final ImageView ivPicBg;
    public final TextView tvAvailableCount;
    public final TextView tvRemainingTimeBox;

    protected BaseLayoutFloatCircleBinding(Object obj, View view, int i, CircleProgressView circleProgressView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cpvProgress = circleProgressView;
        this.ivPic = imageView;
        this.ivPicBg = imageView2;
        this.tvAvailableCount = textView;
        this.tvRemainingTimeBox = textView2;
    }

    public static BaseLayoutFloatCircleBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseLayoutFloatCircleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseLayoutFloatCircleBinding bind(View view, Object obj) {
        return (BaseLayoutFloatCircleBinding) ViewDataBinding.bind(obj, view, R.layout.base_layout_float_circle);
    }

    @Deprecated
    public static BaseLayoutFloatCircleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseLayoutFloatCircleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_float_circle, viewGroup, z, obj);
    }

    public static BaseLayoutFloatCircleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseLayoutFloatCircleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseLayoutFloatCircleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_float_circle, null, false, obj);
    }
}
