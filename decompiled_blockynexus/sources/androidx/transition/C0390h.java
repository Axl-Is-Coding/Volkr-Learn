package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* JADX INFO: renamed from: androidx.transition.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0390h extends Property<View, PointF> {
    C0390h(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF get(View view) {
        return null;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(View view, PointF pointF) {
        va.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
    }
}
