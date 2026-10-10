package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.cd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentAppVideoRecommendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0544cd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatRadioButton f8225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f8226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.xa.q f8227d;

    protected AbstractC0544cd(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2) {
        super(obj, view, i);
        this.f8224a = constraintLayout;
        this.f8225b = appCompatRadioButton;
        this.f8226c = appCompatRadioButton2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.xa.q qVar);
}
