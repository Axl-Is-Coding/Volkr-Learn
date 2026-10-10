package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: compiled from: ViewGroupOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class la implements ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f2270a;

    la(ViewGroup viewGroup) {
        this.f2270a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.sa
    public void a(Drawable drawable) {
        this.f2270a.add(drawable);
    }

    @Override // androidx.transition.sa
    public void b(Drawable drawable) {
        this.f2270a.remove(drawable);
    }

    @Override // androidx.transition.ma
    public void a(View view) {
        this.f2270a.add(view);
    }

    @Override // androidx.transition.ma
    public void b(View view) {
        this.f2270a.remove(view);
    }
}
