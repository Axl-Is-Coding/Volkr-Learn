package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.xc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapRewardReceiveBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0773xc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f8962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f8965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8966f;
    public final TextView g;
    protected com.disabngo.blockynexus.view.dialog.Qa h;

    protected AbstractC0773xc(Object obj, View view, int i, View view2, View view3, View view4, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8961a = view2;
        this.f8962b = view3;
        this.f8963c = view4;
        this.f8964d = imageView;
        this.f8965e = imageView2;
        this.f8966f = textView;
        this.g = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Qa qa);
}
