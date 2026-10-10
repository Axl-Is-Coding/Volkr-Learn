package com.sandboxol.googlepay.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.googlepay.view.fragment.recharge.RechargeItem2ViewModel;

/* JADX INFO: compiled from: GooglepayItemRechargeViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f18207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f18208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f18209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f18210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f18211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f18212f;
    public final TextView g;
    public final View h;
    public final View i;
    public final View j;
    protected RechargeItem2ViewModel k;
    protected Boolean l;

    protected k(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f18207a = imageView;
        this.f18208b = textView;
        this.f18209c = textView2;
        this.f18210d = textView3;
        this.f18211e = textView4;
        this.f18212f = textView5;
        this.g = textView6;
        this.h = view2;
        this.i = view3;
        this.j = view4;
    }

    public abstract void a(RechargeItem2ViewModel rechargeItem2ViewModel);

    public abstract void a(Boolean bool);
}
