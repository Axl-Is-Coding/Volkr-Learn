package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import com.opensource.svgaplayer.SVGAImageView;

/* JADX INFO: compiled from: FragmentRefreshDataBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ve extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SVGAImageView f7963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f7964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f7965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.p.o f7966f;

    protected Ve(Object obj, View view, int i, View view2, View view3, SVGAImageView sVGAImageView, ProgressBar progressBar, View view4) {
        super(obj, view, i);
        this.f7961a = view2;
        this.f7962b = view3;
        this.f7963c = sVGAImageView;
        this.f7964d = progressBar;
        this.f7965e = view4;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.p.o oVar);
}
