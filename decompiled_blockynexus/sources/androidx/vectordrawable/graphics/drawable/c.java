package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnimatedVectorDrawableCompat f2336a;

    c(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.f2336a = animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.f2336a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f2336a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f2336a.unscheduleSelf(runnable);
    }
}
