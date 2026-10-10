package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.pe, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupNoticeBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0688pe extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f8686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.G.f f8688c;

    protected AbstractC0688pe(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f8686a = imageView;
        this.f8687b = textView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.G.f fVar);
}
