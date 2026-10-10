package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.c.C0823c;
import com.sandboxol.common.widget.TimeCountDownView;

/* JADX INFO: compiled from: ItemActivityListBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Dg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f7392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f7393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f7394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeCountDownView f7395f;
    public final TextView g;
    public final TextView h;
    protected C0823c i;

    protected Dg(Object obj, View view, int i, View view2, View view3, View view4, ImageView imageView, ImageView imageView2, TimeCountDownView timeCountDownView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7390a = view2;
        this.f7391b = view3;
        this.f7392c = view4;
        this.f7393d = imageView;
        this.f7394e = imageView2;
        this.f7395f = timeCountDownView;
        this.g = textView;
        this.h = textView2;
    }
}
