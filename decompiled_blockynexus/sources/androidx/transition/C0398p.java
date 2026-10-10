package androidx.transition;

import android.widget.ImageView;

/* JADX INFO: renamed from: androidx.transition.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeImageTransform.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class C0398p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2276a = new int[ImageView.ScaleType.values().length];

    static {
        try {
            f2276a[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2276a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
