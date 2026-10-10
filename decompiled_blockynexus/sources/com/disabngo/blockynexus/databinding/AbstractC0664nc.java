package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.nc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapHistoryBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0664nc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f8612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.disabngo.blockynexus.view.dialog.f.b f8615d;

    protected AbstractC0664nc(Object obj, View view, int i, ImageView imageView, TextView textView, View view2) {
        super(obj, view, i);
        this.f8612a = imageView;
        this.f8613b = textView;
        this.f8614c = view2;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.f.b bVar);
}
