package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribeNoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Sf extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f7875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.fragment.tribeno.m f7876b;

    protected Sf(Object obj, View view, int i, Toolbar toolbar) {
        super(obj, view, i);
        this.f7875a = toolbar;
    }

    public abstract void a(com.disabngo.blockynexus.view.fragment.tribeno.m mVar);
}
