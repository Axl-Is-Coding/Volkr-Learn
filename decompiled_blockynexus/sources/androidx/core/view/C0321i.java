package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: renamed from: androidx.core.view.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MotionEventCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0321i {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
