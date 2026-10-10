package com.sandbox.login.c;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: com.sandbox.login.c.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LoginActivityLoginBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2441i extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f15649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f15650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f15651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f15652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextInputEditText f15653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextInputEditText f15654f;
    public final Guideline g;
    public final TextInputLayout h;
    public final ConstraintLayout i;
    public final TextInputLayout j;
    public final ImageView k;
    public final View l;
    public final View m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    protected com.sandbox.login.view.activity.login.D r;

    protected AbstractC2441i(Object obj, View view, int i, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, Guideline guideline, TextInputLayout textInputLayout, ConstraintLayout constraintLayout, TextInputLayout textInputLayout2, ImageView imageView4, View view2, View view3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f15649a = button;
        this.f15650b = imageView;
        this.f15651c = imageView2;
        this.f15652d = imageView3;
        this.f15653e = textInputEditText;
        this.f15654f = textInputEditText2;
        this.g = guideline;
        this.h = textInputLayout;
        this.i = constraintLayout;
        this.j = textInputLayout2;
        this.k = imageView4;
        this.l = view2;
        this.m = view3;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
    }

    public abstract void a(com.sandbox.login.view.activity.login.D d2);
}
