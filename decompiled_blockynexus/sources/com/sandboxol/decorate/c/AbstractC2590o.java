package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.widget.DiscountTextView;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDressBuyBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2590o extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f17100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f17101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataRecyclerView f17102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DiscountTextView f17103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DiscountTextView f17104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f17105f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final ImageView m;
    public final ConstraintLayout n;
    public final ImageView o;
    public final ImageView p;
    protected com.sandboxol.decorate.view.dialog.a.E q;

    protected AbstractC2590o(Object obj, View view, int i, Button button, LinearLayout linearLayout, DataRecyclerView dataRecyclerView, DiscountTextView discountTextView, DiscountTextView discountTextView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.f17100a = button;
        this.f17101b = linearLayout;
        this.f17102c = dataRecyclerView;
        this.f17103d = discountTextView;
        this.f17104e = discountTextView2;
        this.f17105f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = textView6;
        this.l = textView7;
        this.m = imageView;
        this.n = constraintLayout;
        this.o = imageView2;
        this.p = imageView3;
    }

    public abstract void a(com.sandboxol.decorate.view.dialog.a.E e2);
}
