package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.videosubmit.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitItemThemeBinding extends ViewDataBinding {
    public final TextView tvTheme;

    protected VideosubmitItemThemeBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvTheme = textView;
    }

    public static VideosubmitItemThemeBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitItemThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    @Deprecated
    public static VideosubmitItemThemeBinding bind(View view, Object obj) {
        return (VideosubmitItemThemeBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_item_theme);
    }

    @Deprecated
    public static VideosubmitItemThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitItemThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_theme, viewGroup, z, obj);
    }

    public static VideosubmitItemThemeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitItemThemeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitItemThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_theme, null, false, obj);
    }
}
