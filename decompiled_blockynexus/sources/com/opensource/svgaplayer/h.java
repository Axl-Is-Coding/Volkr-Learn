package com.opensource.svgaplayer;

import android.animation.ValueAnimator;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: SVGAImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ValueAnimator f15537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SVGAImageView f15538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.opensource.svgaplayer.b.b f15539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ c f15540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f15541e;

    h(ValueAnimator valueAnimator, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, c cVar, boolean z) {
        this.f15537a = valueAnimator;
        this.f15538b = sVGAImageView;
        this.f15539c = bVar;
        this.f15540d = cVar;
        this.f15541e = z;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c cVar = this.f15540d;
        ValueAnimator valueAnimator2 = this.f15537a;
        kotlin.jvm.internal.i.a((Object) valueAnimator2, "animator");
        Object animatedValue = valueAnimator2.getAnimatedValue();
        if (animatedValue == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        cVar.a(((Integer) animatedValue).intValue());
        b callback = this.f15538b.getCallback();
        if (callback != null) {
            int iA = this.f15540d.a();
            double dA = this.f15540d.a() + 1;
            double d2 = this.f15540d.c().d();
            Double.isNaN(dA);
            Double.isNaN(d2);
            callback.a(iA, dA / d2);
        }
    }
}
