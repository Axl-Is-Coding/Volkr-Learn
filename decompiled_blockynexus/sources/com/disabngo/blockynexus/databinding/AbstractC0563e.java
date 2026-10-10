package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityDiscoverBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0563e extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f8283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.activity.discover.n f8284b;

    protected AbstractC0563e(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f8283a = textView;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.discover.n nVar);
}
