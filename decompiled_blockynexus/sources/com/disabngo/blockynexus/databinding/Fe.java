package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentMakeFriendBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Fe extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f7448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f7449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f7450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f7451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f7452f;
    public final RelativeLayout g;
    public final RelativeLayout h;
    public final RelativeLayout i;
    public final TextView j;
    protected com.disabngo.blockynexus.e.b.O.t k;
    protected com.disabngo.blockynexus.view.activity.main.nc l;

    protected Fe(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        super(obj, view, i);
        this.f7447a = relativeLayout;
        this.f7448b = imageView;
        this.f7449c = imageView2;
        this.f7450d = imageView3;
        this.f7451e = imageView4;
        this.f7452f = linearLayout;
        this.g = relativeLayout2;
        this.h = relativeLayout3;
        this.i = relativeLayout4;
        this.j = textView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.O.t tVar);

    public abstract void a(com.disabngo.blockynexus.view.activity.main.nc ncVar);
}
