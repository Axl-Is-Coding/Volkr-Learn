package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentGdiamondRankBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Wd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Guideline f7999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Guideline f8000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f8003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatRadioButton f8004f;
    public final AppCompatRadioButton g;
    public final RadioGroup h;
    protected com.disabngo.blockynexus.e.b.W.c.p i;

    protected Wd(Object obj, View view, int i, Guideline guideline, Guideline guideline2, ImageView imageView, ImageView imageView2, ImageView imageView3, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, RadioGroup radioGroup) {
        super(obj, view, i);
        this.f7999a = guideline;
        this.f8000b = guideline2;
        this.f8001c = imageView;
        this.f8002d = imageView2;
        this.f8003e = imageView3;
        this.f8004f = appCompatRadioButton;
        this.g = appCompatRadioButton2;
        this.h = radioGroup;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.W.c.p pVar);
}
