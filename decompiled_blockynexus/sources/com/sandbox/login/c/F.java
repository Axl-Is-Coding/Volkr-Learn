package com.sandbox.login.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: LoginFragmentSetAccountBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class F extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f15607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputEditText f15608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.sandbox.login.f.a.a.i f15609c;

    protected F(Object obj, View view, int i, TextInputLayout textInputLayout, TextInputEditText textInputEditText) {
        super(obj, view, i);
        this.f15607a = textInputLayout;
        this.f15608b = textInputEditText;
    }

    public abstract void a(com.sandbox.login.f.a.a.i iVar);
}
