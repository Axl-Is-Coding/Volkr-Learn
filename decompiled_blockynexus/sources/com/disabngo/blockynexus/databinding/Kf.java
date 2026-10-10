package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribeHasBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Kf extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Toolbar f7614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.fragment.tribehas.T f7615c;

    protected Kf(Object obj, View view, int i, RelativeLayout relativeLayout, Toolbar toolbar) {
        super(obj, view, i);
        this.f7613a = relativeLayout;
        this.f7614b = toolbar;
    }

    public abstract void a(com.disabngo.blockynexus.view.fragment.tribehas.T t);
}
