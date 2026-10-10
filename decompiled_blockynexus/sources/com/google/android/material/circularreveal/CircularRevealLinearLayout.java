package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.material.circularreveal.e;

/* JADX INFO: loaded from: classes2.dex */
public class CircularRevealLinearLayout extends LinearLayout implements e {
    private final c helper;

    public CircularRevealLinearLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c.a
    public void actualDraw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.c.a
    public boolean actualIsOpaque() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.e
    public void buildCircularRevealCache() {
        this.helper.a();
    }

    @Override // com.google.android.material.circularreveal.e
    public void destroyCircularRevealCache() {
        this.helper.b();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.helper;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.helper.c();
    }

    @Override // com.google.android.material.circularreveal.e
    public int getCircularRevealScrimColor() {
        return this.helper.d();
    }

    @Override // com.google.android.material.circularreveal.e
    public e.d getRevealInfo() {
        return this.helper.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.helper;
        return cVar != null ? cVar.f() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.helper.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealScrimColor(int i) {
        this.helper.a(i);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setRevealInfo(e.d dVar) {
        this.helper.a(dVar);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.helper = new c(this);
    }
}
