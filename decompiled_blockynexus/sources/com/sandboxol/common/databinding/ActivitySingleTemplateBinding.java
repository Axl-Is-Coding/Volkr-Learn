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
public abstract class ActivitySingleTemplateBinding extends ViewDataBinding {
    public final FrameLayout flTemplateContainer;
    public final ImageButton ibTemplateLeft;
    public final ImageButton ibTemplateRight;
    public final ImageButton ibTemplateSecondRight;
    public final ImageView ivDivideLine;
    public final Toolbar tbTemplateBar;
    public final TextView tvTemplateTitle;
    public final TextView tvTip;

    protected ActivitySingleTemplateBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageView imageView, Toolbar toolbar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.flTemplateContainer = frameLayout;
        this.ibTemplateLeft = imageButton;
        this.ibTemplateRight = imageButton2;
        this.ibTemplateSecondRight = imageButton3;
        this.ivDivideLine = imageView;
        this.tbTemplateBar = toolbar;
        this.tvTemplateTitle = textView;
        this.tvTip = textView2;
    }

    public static ActivitySingleTemplateBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ActivitySingleTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static ActivitySingleTemplateBinding bind(View view, Object obj) {
        return (ActivitySingleTemplateBinding) ViewDataBinding.bind(obj, view, R.layout.activity_single_template);
    }

    @Deprecated
    public static ActivitySingleTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySingleTemplateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_single_template, viewGroup, z, obj);
    }

    public static ActivitySingleTemplateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ActivitySingleTemplateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySingleTemplateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_single_template, null, false, obj);
    }
}
