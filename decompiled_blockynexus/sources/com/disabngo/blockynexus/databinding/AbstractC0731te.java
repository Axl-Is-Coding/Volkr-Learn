package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.MeItemView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.te, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentHelpBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0731te extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MeItemView f8832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeItemView f8833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MeItemView f8834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MeItemView f8835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f8836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8837f;
    protected com.disabngo.blockynexus.e.b.J.g g;

    protected AbstractC0731te(Object obj, View view, int i, MeItemView meItemView, MeItemView meItemView2, MeItemView meItemView3, MeItemView meItemView4, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8832a = meItemView;
        this.f8833b = meItemView2;
        this.f8834c = meItemView3;
        this.f8835d = meItemView4;
        this.f8836e = textView;
        this.f8837f = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.J.g gVar);
}
