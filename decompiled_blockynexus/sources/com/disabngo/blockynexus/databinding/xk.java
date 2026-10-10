package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.more.MoreViewModel;

/* JADX INFO: compiled from: ViewDiamondExchangeBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class xk extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f8995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f8998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8999f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final View o;
    protected MoreViewModel p;

    protected xk(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2, View view3) {
        super(obj, view, i);
        this.f8994a = button;
        this.f8995b = constraintLayout;
        this.f8996c = imageView;
        this.f8997d = imageView2;
        this.f8998e = imageView3;
        this.f8999f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = textView6;
        this.l = textView7;
        this.m = textView8;
        this.n = view2;
        this.o = view3;
    }

    public abstract void a(MoreViewModel moreViewModel);
}
