package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import androidx.transition.ChangeTransform;

/* JADX INFO: renamed from: androidx.transition.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeTransform.java */
/* JADX INFO: loaded from: classes.dex */
class C0400r extends Property<ChangeTransform.b, PointF> {
    C0400r(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF get(ChangeTransform.b bVar) {
        return null;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(ChangeTransform.b bVar, PointF pointF) {
        bVar.a(pointF);
    }
}
