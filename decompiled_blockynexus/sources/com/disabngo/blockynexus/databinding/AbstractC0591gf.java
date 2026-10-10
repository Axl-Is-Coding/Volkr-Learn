package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.gf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentScrapMainBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0591gf extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f8370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f8371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f8374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f8375f;
    public final ConstraintLayout g;
    public final TabLayout h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final ViewPager m;
    protected com.disabngo.blockynexus.e.b.da.o n;

    protected AbstractC0591gf(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TabLayout tabLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ViewPager viewPager) {
        super(obj, view, i);
        this.f8370a = imageView;
        this.f8371b = imageView2;
        this.f8372c = imageView3;
        this.f8373d = imageView4;
        this.f8374e = constraintLayout;
        this.f8375f = constraintLayout2;
        this.g = constraintLayout3;
        this.h = tabLayout;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = viewPager;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.da.o oVar);
}
