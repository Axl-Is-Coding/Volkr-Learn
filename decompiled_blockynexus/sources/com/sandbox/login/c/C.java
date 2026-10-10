package com.sandbox.login.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: LoginFragmentRegisterBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class C extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f15601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f15602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f15603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f15604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f15605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.sandbox.login.view.fragment.register.e f15606f;

    protected C(Object obj, View view, int i, View view2, View view3, FrameLayout frameLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f15601a = view2;
        this.f15602b = view3;
        this.f15603c = frameLayout;
        this.f15604d = textView;
        this.f15605e = textView2;
    }

    public abstract void a(com.sandbox.login.view.fragment.register.e eVar);
}
