package com.sandboxol.decorate.c;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemDressExpiredBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class I extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f17009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f17010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.sandboxol.decorate.view.dialog.b.d f17011c;

    protected I(Object obj, View view, int i, ImageView imageView, View view2) {
        super(obj, view, i);
        this.f17009a = imageView;
        this.f17010b = view2;
    }
}
