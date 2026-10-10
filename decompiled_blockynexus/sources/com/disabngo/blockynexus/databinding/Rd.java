package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: FragmentForgetPasswordByEmailOrQuestionBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Rd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputEditText f7833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f7834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.w.h f7837e;

    protected Rd(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7833a = textInputEditText;
        this.f7834b = textInputLayout;
        this.f7835c = textView;
        this.f7836d = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.w.h hVar);
}
