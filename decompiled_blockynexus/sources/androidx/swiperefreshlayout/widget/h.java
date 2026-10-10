package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: SwipeRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class h extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f2111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f2112c;

    h(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f2112c = swipeRefreshLayout;
        this.f2110a = i;
        this.f2111b = i2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        this.f2112c.mProgress.setAlpha((int) (this.f2110a + ((this.f2111b - r0) * f2)));
    }
}
