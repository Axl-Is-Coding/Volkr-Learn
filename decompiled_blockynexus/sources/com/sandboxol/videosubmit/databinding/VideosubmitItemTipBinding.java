package com.sandboxol.videosubmit.databinding;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitItemTipBinding extends ViewDataBinding {
    protected Drawable mDrawableStart;
    protected String mTip;
    public final TextView tvContentEspecialTipsDetail1;

    protected VideosubmitItemTipBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvContentEspecialTipsDetail1 = textView;
    }

    public static VideosubmitItemTipBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitItemTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public Drawable getDrawableStart() {
        return this.mDrawableStart;
    }

    public String getTip() {
        return this.mTip;
    }

    public abstract void setDrawableStart(Drawable drawable);

    public abstract void setTip(String str);

    @Deprecated
    public static VideosubmitItemTipBinding bind(View view, Object obj) {
        return (VideosubmitItemTipBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_item_tip);
    }

    @Deprecated
    public static VideosubmitItemTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitItemTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_tip, viewGroup, z, obj);
    }

    public static VideosubmitItemTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitItemTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitItemTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_tip, null, false, obj);
    }
}
