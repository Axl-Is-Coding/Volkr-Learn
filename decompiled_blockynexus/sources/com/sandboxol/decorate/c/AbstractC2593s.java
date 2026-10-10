package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.decorate.view.dialog.d;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDressShopGuideBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2593s extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f17112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f17113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager f17114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected d.b f17115d;

    protected AbstractC2593s(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, ViewPager viewPager) {
        super(obj, view, i);
        this.f17112a = linearLayout;
        this.f17113b = textView;
        this.f17114c = viewPager;
    }

    public abstract void a(d.b bVar);
}
