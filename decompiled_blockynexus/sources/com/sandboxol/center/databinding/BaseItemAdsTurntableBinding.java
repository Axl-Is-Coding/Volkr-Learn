package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseItemAdsTurntableBinding extends ViewDataBinding {
    public final ImageView ivReward;
    public final View view18;

    protected BaseItemAdsTurntableBinding(Object obj, View view, int i, ImageView imageView, View view2) {
        super(obj, view, i);
        this.ivReward = imageView;
        this.view18 = view2;
    }

    public static BaseItemAdsTurntableBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseItemAdsTurntableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseItemAdsTurntableBinding bind(View view, Object obj) {
        return (BaseItemAdsTurntableBinding) ViewDataBinding.bind(obj, view, R.layout.base_item_ads_turntable);
    }

    @Deprecated
    public static BaseItemAdsTurntableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseItemAdsTurntableBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_item_ads_turntable, viewGroup, z, obj);
    }

    public static BaseItemAdsTurntableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseItemAdsTurntableBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseItemAdsTurntableBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_item_ads_turntable, null, false, obj);
    }
}
