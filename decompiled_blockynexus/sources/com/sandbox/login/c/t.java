package com.sandbox.login.c;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: LoginFragmentAccountRecordBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f15679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f15680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.sandbox.login.f.a.e.r f15681c;

    protected t(Object obj, View view, int i, Button button, TextView textView) {
        super(obj, view, i);
        this.f15679a = button;
        this.f15680b = textView;
    }

    public abstract void a(com.sandbox.login.f.a.e.r rVar);
}
