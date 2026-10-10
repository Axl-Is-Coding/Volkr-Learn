package com.sandboxol.vip.b;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: VipFragmentPrivilegeCenterBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f19002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataRecyclerView f19003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f19004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f19005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f19006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f19007f;
    public final TextView g;
    public final View h;
    public final View i;
    public final TextView j;
    public final View k;
    public final TextView l;
    public final View m;
    public final TextView n;
    public final ViewPager o;
    protected com.sandboxol.vip.view.fragment.main.s p;

    protected m(Object obj, View view, int i, Button button, DataRecyclerView dataRecyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3, TextView textView6, View view4, TextView textView7, View view5, TextView textView8, ViewPager viewPager) {
        super(obj, view, i);
        this.f19002a = button;
        this.f19003b = dataRecyclerView;
        this.f19004c = textView;
        this.f19005d = textView2;
        this.f19006e = textView3;
        this.f19007f = textView4;
        this.g = textView5;
        this.h = view2;
        this.i = view3;
        this.j = textView6;
        this.k = view4;
        this.l = textView7;
        this.m = view5;
        this.n = textView8;
        this.o = viewPager;
    }

    public abstract void a(com.sandboxol.vip.view.fragment.main.s sVar);
}
