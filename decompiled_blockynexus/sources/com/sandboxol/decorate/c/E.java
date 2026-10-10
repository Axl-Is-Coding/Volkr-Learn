package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ItemDressBuySuitBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class E extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Group f16997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f16998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f16999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RadioGroup f17000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RadioGroup f17001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatRadioButton f17002f;
    public final AppCompatRadioButton g;
    public final AppCompatRadioButton h;
    public final AppCompatRadioButton i;
    public final DataRecyclerView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final View q;
    public final View r;
    public final View s;
    protected com.sandboxol.decorate.view.dialog.a.I t;

    protected E(Object obj, View view, int i, Group group, ImageView imageView, LinearLayout linearLayout, RadioGroup radioGroup, RadioGroup radioGroup2, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, AppCompatRadioButton appCompatRadioButton3, AppCompatRadioButton appCompatRadioButton4, DataRecyclerView dataRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f16997a = group;
        this.f16998b = imageView;
        this.f16999c = linearLayout;
        this.f17000d = radioGroup;
        this.f17001e = radioGroup2;
        this.f17002f = appCompatRadioButton;
        this.g = appCompatRadioButton2;
        this.h = appCompatRadioButton3;
        this.i = appCompatRadioButton4;
        this.j = dataRecyclerView;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = textView5;
        this.p = textView6;
        this.q = view2;
        this.r = view3;
        this.s = view4;
    }
}
