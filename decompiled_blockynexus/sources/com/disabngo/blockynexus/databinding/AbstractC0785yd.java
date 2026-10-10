package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.yd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentChatBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0785yd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f9008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatRadioButton f9009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f9010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.activity.main.nc f9011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.o.x f9012e;

    protected AbstractC0785yd(Object obj, View view, int i, FrameLayout frameLayout, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2) {
        super(obj, view, i);
        this.f9008a = frameLayout;
        this.f9009b = appCompatRadioButton;
        this.f9010c = appCompatRadioButton2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.o.x xVar);

    public abstract void a(com.disabngo.blockynexus.view.activity.main.nc ncVar);
}
