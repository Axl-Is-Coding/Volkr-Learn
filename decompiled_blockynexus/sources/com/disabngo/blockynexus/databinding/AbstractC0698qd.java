package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentCashBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0698qd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatRadioButton f8721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f8722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatRadioButton f8723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RadioGroup f8724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8725f;
    public final TextView g;
    public final TextView h;
    public final ConstraintLayout i;
    protected com.disabngo.blockynexus.e.b.i.h j;

    protected AbstractC0698qd(Object obj, View view, int i, Button button, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, AppCompatRadioButton appCompatRadioButton3, RadioGroup radioGroup, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.f8720a = button;
        this.f8721b = appCompatRadioButton;
        this.f8722c = appCompatRadioButton2;
        this.f8723d = appCompatRadioButton3;
        this.f8724e = radioGroup;
        this.f8725f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = constraintLayout;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.i.h hVar);
}
