package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogWeekSignBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Pc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.j.l f7768c;

    protected Pc(Object obj, View view, int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f7766a = linearLayout;
        this.f7767b = relativeLayout;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.j.l lVar);
}
