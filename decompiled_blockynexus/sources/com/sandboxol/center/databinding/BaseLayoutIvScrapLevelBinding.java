package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLayoutIvScrapLevelBinding extends ViewDataBinding {
    public final View bgMain;
    public final View bgScrapOutline;
    public final ImageView ivScrapDone;
    public final TextView ivScrapGameText;
    public final ImageView ivScrapLevel;
    public final ImageView ivScrapLevelVip;
    public final ImageView ivScrapLock;
    public final ImageView ivScrapPic;
    public final TextView ivScrapText;
    public final View vScrapShadow;

    protected BaseLayoutIvScrapLevelBinding(Object obj, View view, int i, View view2, View view3, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView2, View view4) {
        super(obj, view, i);
        this.bgMain = view2;
        this.bgScrapOutline = view3;
        this.ivScrapDone = imageView;
        this.ivScrapGameText = textView;
        this.ivScrapLevel = imageView2;
        this.ivScrapLevelVip = imageView3;
        this.ivScrapLock = imageView4;
        this.ivScrapPic = imageView5;
        this.ivScrapText = textView2;
        this.vScrapShadow = view4;
    }

    public static BaseLayoutIvScrapLevelBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseLayoutIvScrapLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static BaseLayoutIvScrapLevelBinding bind(View view, Object obj) {
        return (BaseLayoutIvScrapLevelBinding) ViewDataBinding.bind(obj, view, R.layout.base_layout_iv_scrap_level);
    }

    @Deprecated
    public static BaseLayoutIvScrapLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseLayoutIvScrapLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_iv_scrap_level, viewGroup, z, obj);
    }

    public static BaseLayoutIvScrapLevelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseLayoutIvScrapLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseLayoutIvScrapLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_iv_scrap_level, null, false, obj);
    }
}
