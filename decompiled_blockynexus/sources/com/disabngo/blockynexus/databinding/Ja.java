package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ContentWeekSignBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ja extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f7570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.j.l f7572c;

    protected Ja(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f7570a = imageView;
        this.f7571b = relativeLayout;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.j.l lVar);
}
