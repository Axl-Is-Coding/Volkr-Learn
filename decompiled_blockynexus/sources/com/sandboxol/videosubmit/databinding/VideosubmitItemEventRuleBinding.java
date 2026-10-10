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
public abstract class VideosubmitItemEventRuleBinding extends ViewDataBinding {
    protected Drawable mDrawableStart;
    protected String mRule;
    public final TextView tvContentSignupDetail1;

    protected VideosubmitItemEventRuleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.tvContentSignupDetail1 = textView;
    }

    public static VideosubmitItemEventRuleBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitItemEventRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public Drawable getDrawableStart() {
        return this.mDrawableStart;
    }

    public String getRule() {
        return this.mRule;
    }

    public abstract void setDrawableStart(Drawable drawable);

    public abstract void setRule(String str);

    @Deprecated
    public static VideosubmitItemEventRuleBinding bind(View view, Object obj) {
        return (VideosubmitItemEventRuleBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_item_event_rule);
    }

    @Deprecated
    public static VideosubmitItemEventRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitItemEventRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_event_rule, viewGroup, z, obj);
    }

    public static VideosubmitItemEventRuleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitItemEventRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitItemEventRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_item_event_rule, null, false, obj);
    }
}
