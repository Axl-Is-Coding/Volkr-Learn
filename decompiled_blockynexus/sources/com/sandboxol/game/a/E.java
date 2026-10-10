package com.sandboxol.game.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemRechargeShopBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class E extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f17644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f17645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.sandboxol.recharge.dialog.rechargeshop.l f17646c;

    protected E(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f17644a = imageView;
        this.f17645b = linearLayout;
    }
}
