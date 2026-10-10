package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.a.C0813b;

/* JADX INFO: compiled from: FragmentAboutBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Tc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f7896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f7897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f7899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected C0813b f7900e;

    protected Tc(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7896a = imageView;
        this.f7897b = textView;
        this.f7898c = textView2;
        this.f7899d = textView3;
    }

    public abstract void a(C0813b c0813b);
}
