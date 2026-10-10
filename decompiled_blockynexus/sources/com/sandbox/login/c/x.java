package com.sandbox.login.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: LoginFragmentConfirmPasswordBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f15691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputEditText f15692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.sandbox.login.f.a.c.g f15693c;

    protected x(Object obj, View view, int i, TextInputLayout textInputLayout, TextInputEditText textInputEditText) {
        super(obj, view, i);
        this.f15691a = textInputLayout;
        this.f15692b = textInputEditText;
    }

    public abstract void a(com.sandbox.login.f.a.c.g gVar);
}
