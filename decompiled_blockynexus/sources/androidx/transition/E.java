package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: GhostViewPort.java */
/* JADX INFO: loaded from: classes.dex */
class E implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f2160a;

    E(F f2) {
        this.f2160a = f2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view;
        ViewCompat.G(this.f2160a);
        F f2 = this.f2160a;
        ViewGroup viewGroup = f2.f2162a;
        if (viewGroup == null || (view = f2.f2163b) == null) {
            return true;
        }
        viewGroup.endViewTransition(view);
        ViewCompat.G(this.f2160a.f2162a);
        F f3 = this.f2160a;
        f3.f2162a = null;
        f3.f2163b = null;
        return true;
    }
}
