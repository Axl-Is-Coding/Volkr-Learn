package com.google.android.material.card;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* JADX INFO: compiled from: MaterialCardViewHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends InsetDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f13247a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a(b bVar, Drawable drawable, int i, int i2, int i3, int i4) {
        super(drawable, i, i2, i3, i4);
        this.f13247a = bVar;
    }

    @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return false;
    }
}
