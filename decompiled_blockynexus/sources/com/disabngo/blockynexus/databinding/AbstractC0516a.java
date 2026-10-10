package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityAppVideoDetailBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0516a extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppBarLayout f8142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f8143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f8144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f8145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f8146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f8147f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final ConstraintLayout j;
    public final ImageButton k;
    public final AppCompatTextView l;
    public final View m;
    public final LinearLayout n;
    protected com.disabngo.blockynexus.view.activity.videodetail.y o;

    protected AbstractC0516a(Object obj, View view, int i, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, ConstraintLayout constraintLayout, ImageButton imageButton, AppCompatTextView appCompatTextView6, View view2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f8142a = appBarLayout;
        this.f8143b = appCompatImageView;
        this.f8144c = appCompatImageView2;
        this.f8145d = appCompatImageView3;
        this.f8146e = appCompatTextView;
        this.f8147f = appCompatTextView2;
        this.g = appCompatTextView3;
        this.h = appCompatTextView4;
        this.i = appCompatTextView5;
        this.j = constraintLayout;
        this.k = imageButton;
        this.l = appCompatTextView6;
        this.m = view2;
        this.n = linearLayout;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.videodetail.y yVar);
}
