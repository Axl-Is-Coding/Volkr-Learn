package com.sandboxol.vip.b;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: VipDialogSubscribeBottomBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f18978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f18979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f18980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f18981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f18982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f18983f;
    public final DataRecyclerView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final View m;
    protected com.sandboxol.vip.d.a.a.j n;

    protected e(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, DataRecyclerView dataRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2) {
        super(obj, view, i);
        this.f18978a = button;
        this.f18979b = constraintLayout;
        this.f18980c = imageView;
        this.f18981d = imageView2;
        this.f18982e = imageView3;
        this.f18983f = imageView4;
        this.g = dataRecyclerView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
        this.m = view2;
    }

    public abstract void a(com.sandboxol.vip.d.a.a.j jVar);
}
