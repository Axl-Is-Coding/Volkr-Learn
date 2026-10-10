package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribeShopCarBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class _f extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f8128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.ta.h f8130c;

    protected _f(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.f8128a = relativeLayout;
        this.f8129b = textView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.ta.h hVar);
}
