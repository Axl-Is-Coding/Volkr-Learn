package com.sandboxol.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityTemplateBinding extends ViewDataBinding {
    public final FrameLayout flTemplateContainer;
    public final ImageButton ibTemplateLeft;
    public final ImageButton ibTemplateRight;
    public final ImageView ivDivideLine;
    public final Toolbar tbTemplateBar;
    public final TextView tvTemplateRight;
    public final TextView tvTemplateTitle;
    public final TextView tvTip;

    protected ActivityTemplateBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.flTemplateContainer = frameLayout;
        this.ibTemplateLeft = imageButton;
        this.ibTemplateRight = imageButton2;
        this.ivDivideLine = imageView;
        this.tbTemplateBar = toolbar;
        this.tvTemplateRight = textView;
        this.tvTemplateTitle = textView2;
        this.tvTip = textView3;
    }

    public static ActivityTemplateBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ActivityTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static ActivityTemplateBinding bind(View view, Object obj) {
        return (ActivityTemplateBinding) ViewDataBinding.bind(obj, view, R.layout.activity_template);
    }

    @Deprecated
    public static ActivityTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityTemplateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_template, viewGroup, z, obj);
    }

    public static ActivityTemplateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ActivityTemplateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityTemplateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_template, null, false, obj);
    }
}
