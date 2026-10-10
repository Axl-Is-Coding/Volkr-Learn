package com.google.android.material.l;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: AbsoluteCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13508a;

    public a(float f2) {
        this.f13508a = f2;
    }

    @Override // com.google.android.material.l.c
    public float a(RectF rectF) {
        return this.f13508a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f13508a == ((a) obj).f13508a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13508a)});
    }
}
