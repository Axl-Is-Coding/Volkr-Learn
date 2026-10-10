package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.view.fragment.dress.va;
import com.sandboxol.decorate.widget.DressRadioGroup;
import com.sandboxol.decorate.widget.DressViewPageFilter;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentDressBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2597w extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f17125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DressRadioGroup f17126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f17127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f17128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f17129f;
    public final LinearLayout g;
    public final RelativeLayout h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final DressViewPageFilter o;
    protected va p;

    protected AbstractC2597w(Object obj, View view, int i, View view2, ImageView imageView, DressRadioGroup dressRadioGroup, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view3, DressViewPageFilter dressViewPageFilter) {
        super(obj, view, i);
        this.f17124a = view2;
        this.f17125b = imageView;
        this.f17126c = dressRadioGroup;
        this.f17127d = frameLayout;
        this.f17128e = imageView2;
        this.f17129f = imageView3;
        this.g = linearLayout;
        this.h = relativeLayout;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
        this.n = view3;
        this.o = dressViewPageFilter;
    }

    public abstract void a(va vaVar);
}
