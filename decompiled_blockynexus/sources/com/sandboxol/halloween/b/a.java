package com.sandboxol.halloween.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.IndicatorStayLayout;

/* JADX INFO: compiled from: HalloweenDialogCurrencyBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f18584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f18585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f18586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f18587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IndicatorStayLayout f18588f;
    public final IndicatorSeekBar g;
    protected com.sandboxol.halloween.view.dialog.m h;

    protected a(Object obj, View view, int i, View view2, View view3, ImageView imageView, ImageView imageView2, ImageView imageView3, IndicatorStayLayout indicatorStayLayout, IndicatorSeekBar indicatorSeekBar) {
        super(obj, view, i);
        this.f18583a = view2;
        this.f18584b = view3;
        this.f18585c = imageView;
        this.f18586d = imageView2;
        this.f18587e = imageView3;
        this.f18588f = indicatorStayLayout;
        this.g = indicatorSeekBar;
    }

    public abstract void a(com.sandboxol.halloween.view.dialog.m mVar);
}
