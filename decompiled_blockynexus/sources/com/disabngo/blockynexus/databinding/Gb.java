package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogHelpContactBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Gb extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f7483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f7484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f7485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f7486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f7487f;
    public final View g;
    public final View h;
    protected com.disabngo.blockynexus.view.dialog.Ba i;

    protected Gb(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f7482a = linearLayout;
        this.f7483b = textView;
        this.f7484c = textView2;
        this.f7485d = constraintLayout;
        this.f7486e = constraintLayout2;
        this.f7487f = view2;
        this.g = view3;
        this.h = view4;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Ba ba);
}
