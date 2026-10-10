package com.sandboxol.gamedetail.a;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogGameDetailShopBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2682k extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatTextView f17845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f17846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f17847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f17848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f17849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f17850f;
    public final AppCompatImageView g;
    protected com.sandboxol.gamedetail.view.dialog.e h;

    protected AbstractC2682k(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3) {
        super(obj, view, i);
        this.f17845a = appCompatTextView;
        this.f17846b = appCompatTextView2;
        this.f17847c = appCompatTextView3;
        this.f17848d = constraintLayout;
        this.f17849e = appCompatImageView;
        this.f17850f = appCompatImageView2;
        this.g = appCompatImageView3;
    }

    public abstract void a(com.sandboxol.gamedetail.view.dialog.e eVar);
}
