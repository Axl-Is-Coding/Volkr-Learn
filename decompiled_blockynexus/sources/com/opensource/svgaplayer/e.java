package com.opensource.svgaplayer;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: SVGAImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f15497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f15498b;

    e(f fVar, q qVar) {
        this.f15497a = fVar;
        this.f15498b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15498b.a(this.f15497a.f15531a.f15535d);
        this.f15497a.f15531a.f15534c.setVideoItem(this.f15498b);
        Drawable drawable = this.f15497a.f15531a.f15534c.getDrawable();
        if (!(drawable instanceof c)) {
            drawable = null;
        }
        c cVar = (c) drawable;
        if (cVar != null) {
            ImageView.ScaleType scaleType = this.f15497a.f15531a.f15534c.getScaleType();
            kotlin.jvm.internal.i.a((Object) scaleType, "scaleType");
            cVar.a(scaleType);
        }
        g gVar = this.f15497a.f15531a;
        if (gVar.f15536e) {
            gVar.f15534c.startAnimation();
        }
    }
}
