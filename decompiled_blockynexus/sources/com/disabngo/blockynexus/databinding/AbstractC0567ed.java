package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ed, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentAppVideoTotalBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0567ed extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f8295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f8296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.ya.g f8297d;

    protected AbstractC0567ed(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.f8294a = constraintLayout;
        this.f8295b = appCompatTextView;
        this.f8296c = appCompatTextView2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.ya.g gVar);
}
