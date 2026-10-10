package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: SVGADrawable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView.ScaleType f15487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.opensource.svgaplayer.a.b f15488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f15489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f15490f;

    public c(q qVar, d dVar) {
        kotlin.jvm.internal.i.b(qVar, "videoItem");
        kotlin.jvm.internal.i.b(dVar, "dynamicItem");
        this.f15489e = qVar;
        this.f15490f = dVar;
        this.f15485a = true;
        this.f15487c = ImageView.ScaleType.MATRIX;
        this.f15488d = new com.opensource.svgaplayer.a.b(this.f15489e, this.f15490f);
    }

    public final void a(boolean z) {
        if (this.f15485a == z) {
            return;
        }
        this.f15485a = z;
        invalidateSelf();
    }

    public final d b() {
        return this.f15490f;
    }

    public final q c() {
        return this.f15489e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f15485a || canvas == null) {
            return;
        }
        this.f15488d.a(canvas, this.f15486b, this.f15487c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final int a() {
        return this.f15486b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(q qVar) {
        this(qVar, new d());
        kotlin.jvm.internal.i.b(qVar, "videoItem");
    }

    public final void a(int i) {
        if (this.f15486b == i) {
            return;
        }
        this.f15486b = i;
        invalidateSelf();
    }

    public final void a(ImageView.ScaleType scaleType) {
        kotlin.jvm.internal.i.b(scaleType, "<set-?>");
        this.f15487c = scaleType;
    }
}
