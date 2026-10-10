package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.fg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentVerificationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0581fg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f8338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatRadioButton f8339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f8340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.va.d f8341d;

    protected AbstractC0581fg(Object obj, View view, int i, FrameLayout frameLayout, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2) {
        super(obj, view, i);
        this.f8338a = frameLayout;
        this.f8339b = appCompatRadioButton;
        this.f8340c = appCompatRadioButton2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.va.d dVar);
}
