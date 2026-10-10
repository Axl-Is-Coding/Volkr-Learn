package com.google.android.material.l;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13527a;

    public k(float f2) {
        this.f13527a = f2;
    }

    @Override // com.google.android.material.l.c
    public float a(RectF rectF) {
        return this.f13527a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f13527a == ((k) obj).f13527a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13527a)});
    }
}
