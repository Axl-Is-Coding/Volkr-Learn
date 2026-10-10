package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PaintDrawable.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Paint f19184a = new Paint();

    protected b() {
        this.f19184a.setStyle(Paint.Style.FILL);
        this.f19184a.setAntiAlias(true);
        this.f19184a.setColor(-5592406);
    }

    public void a(int i) {
        this.f19184a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f19184a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f19184a.setColorFilter(colorFilter);
    }
}
