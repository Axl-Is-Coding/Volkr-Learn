package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import androidx.transition.ChangeBounds;

/* JADX INFO: renamed from: androidx.transition.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0384e extends Property<ChangeBounds.a, PointF> {
    C0384e(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF get(ChangeBounds.a aVar) {
        return null;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(ChangeBounds.a aVar, PointF pointF) {
        aVar.b(pointF);
    }
}
