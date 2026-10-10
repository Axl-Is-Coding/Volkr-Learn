package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityFriendsInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0628k extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f8502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f8503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageButton f8504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f8506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatRadioButton f8507f;
    public final AppCompatRadioButton g;
    public final RelativeLayout h;
    public final TextView i;
    public final TextView j;
    protected com.disabngo.blockynexus.view.activity.friends.M k;

    protected AbstractC0628k(Object obj, View view, int i, FrameLayout frameLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, LinearLayout linearLayout, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8502a = frameLayout;
        this.f8503b = imageButton;
        this.f8504c = imageButton2;
        this.f8505d = imageView;
        this.f8506e = linearLayout;
        this.f8507f = appCompatRadioButton;
        this.g = appCompatRadioButton2;
        this.h = relativeLayout;
        this.i = textView;
        this.j = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.friends.M m);
}
