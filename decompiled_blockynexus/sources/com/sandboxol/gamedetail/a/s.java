package com.sandboxol.gamedetail.a;

import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentGameDetailRankBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatRadioButton f17868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatRadioButton f17869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f17870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RadioGroup f17871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.sandboxol.gamedetail.c.a.c.n f17872e;

    protected s(Object obj, View view, int i, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, AppCompatRadioButton appCompatRadioButton3, RadioGroup radioGroup) {
        super(obj, view, i);
        this.f17868a = appCompatRadioButton;
        this.f17869b = appCompatRadioButton2;
        this.f17870c = appCompatRadioButton3;
        this.f17871d = radioGroup;
    }

    public abstract void a(com.sandboxol.gamedetail.c.a.c.n nVar);
}
