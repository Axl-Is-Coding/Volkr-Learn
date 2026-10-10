package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.zc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapRuleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0795zc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f9036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f9037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f9038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.h.b f9039d;

    protected AbstractC0795zc(Object obj, View view, int i, ImageView imageView, TextView textView, View view2) {
        super(obj, view, i);
        this.f9036a = imageView;
        this.f9037b = textView;
        this.f9038c = view2;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.h.b bVar);
}
