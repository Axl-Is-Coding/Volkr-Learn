package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentActiveRankBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Xc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Guideline f8025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Guideline f8026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f8029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatRadioButton f8030f;
    public final AppCompatRadioButton g;
    public final RadioGroup h;
    protected com.disabngo.blockynexus.e.b.W.a.p i;

    protected Xc(Object obj, View view, int i, Guideline guideline, Guideline guideline2, ImageView imageView, ImageView imageView2, ImageView imageView3, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, RadioGroup radioGroup) {
        super(obj, view, i);
        this.f8025a = guideline;
        this.f8026b = guideline2;
        this.f8027c = imageView;
        this.f8028d = imageView2;
        this.f8029e = imageView3;
        this.f8030f = appCompatRadioButton;
        this.g = appCompatRadioButton2;
        this.h = radioGroup;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.W.a.p pVar);
}
