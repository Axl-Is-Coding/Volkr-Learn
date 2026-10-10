package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ad, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentAppVideoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0520ad extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f8158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f8159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatRadioButton f8161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatRadioButton f8162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.wa.d f8163f;

    protected AbstractC0520ad(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2) {
        super(obj, view, i);
        this.f8158a = frameLayout;
        this.f8159b = imageView;
        this.f8160c = imageView2;
        this.f8161d = appCompatRadioButton;
        this.f8162e = appCompatRadioButton2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.wa.d dVar);
}
