package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* JADX INFO: renamed from: androidx.transition.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0391i extends Property<View, PointF> {
    C0391i(Class cls, String str) {
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
        int iRound = Math.round(pointF.x);
        int iRound2 = Math.round(pointF.y);
        va.a(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
    }
}
