package com.sandbox.login.c;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: LoginRegisterStep1Binding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class H extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f15613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckBox f15614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextInputEditText f15615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextInputEditText f15616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextInputEditText f15617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextInputLayout f15618f;
    public final TextInputLayout g;
    public final TextInputLayout h;
    public final TextView i;
    protected com.sandbox.login.f.a.f.l j;

    protected H(Object obj, View view, int i, View view2, CheckBox checkBox, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextView textView) {
        super(obj, view, i);
        this.f15613a = view2;
        this.f15614b = checkBox;
        this.f15615c = textInputEditText;
        this.f15616d = textInputEditText2;
        this.f15617e = textInputEditText3;
        this.f15618f = textInputLayout;
        this.g = textInputLayout2;
        this.h = textInputLayout3;
        this.i = textView;
    }

    public abstract void a(com.sandbox.login.f.a.f.l lVar);
}
