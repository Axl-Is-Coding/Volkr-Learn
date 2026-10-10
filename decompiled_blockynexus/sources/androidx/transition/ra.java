package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class ra implements sa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f2289a;

    ra(View view) {
        this.f2289a = view.getOverlay();
    }

    @Override // androidx.transition.sa
    public void a(Drawable drawable) {
        this.f2289a.add(drawable);
    }

    @Override // androidx.transition.sa
    public void b(Drawable drawable) {
        this.f2289a.remove(drawable);
    }
}
