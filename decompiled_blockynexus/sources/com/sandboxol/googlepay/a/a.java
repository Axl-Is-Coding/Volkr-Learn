package com.sandboxol.googlepay.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentPayBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f18178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f18179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f18180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f18181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f18182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.sandboxol.googlepay.c.a.a.d f18183f;

    protected a(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f18178a = imageView;
        this.f18179b = imageView2;
        this.f18180c = textView;
        this.f18181d = textView2;
        this.f18182e = textView3;
    }

    public abstract void a(com.sandboxol.googlepay.c.a.a.d dVar);
}
