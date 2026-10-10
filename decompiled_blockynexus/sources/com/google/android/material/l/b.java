package com.google.android.material.l;

import android.graphics.RectF;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f13509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13510b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f13509a;
            f2 += ((b) cVar).f13510b;
        }
        this.f13509a = cVar;
        this.f13510b = f2;
    }

    @Override // com.google.android.material.l.c
    public float a(RectF rectF) {
        return Math.max(WheelView.DividerConfig.FILL, this.f13509a.a(rectF) + this.f13510b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13509a.equals(bVar.f13509a) && this.f13510b == bVar.f13510b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13509a, Float.valueOf(this.f13510b)});
    }
}
