package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentClanRankBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ad extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Guideline f7266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Guideline f7267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f7268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RadioGroup f7269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.W.b.p f7270e;

    protected Ad(Object obj, View view, int i, Guideline guideline, Guideline guideline2, AppCompatRadioButton appCompatRadioButton, RadioGroup radioGroup) {
        super(obj, view, i);
        this.f7266a = guideline;
        this.f7267b = guideline2;
        this.f7268c = appCompatRadioButton;
        this.f7269d = radioGroup;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.W.b.p pVar);
}
