package com.sandbox.login.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: LoginFragmentChangePasswordBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f15685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f15686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextInputEditText f15687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextInputEditText f15688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.sandbox.login.f.a.b.h f15689e;

    protected v(Object obj, View view, int i, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputEditText textInputEditText, TextInputEditText textInputEditText2) {
        super(obj, view, i);
        this.f15685a = textInputLayout;
        this.f15686b = textInputLayout2;
        this.f15687c = textInputEditText;
        this.f15688d = textInputEditText2;
    }

    public abstract void a(com.sandbox.login.f.a.b.h hVar);
}
