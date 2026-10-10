package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.H;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class t extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f321a;

    t(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f321a = appCompatDelegateImpl;
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        this.f321a.u.setAlpha(1.0f);
        this.f321a.x.a((androidx.core.view.G) null);
        this.f321a.x = null;
    }

    @Override // androidx.core.view.H, androidx.core.view.G
    public void c(View view) {
        this.f321a.u.setVisibility(0);
        this.f321a.u.sendAccessibilityEvent(32);
        if (this.f321a.u.getParent() instanceof View) {
            ViewCompat.H((View) this.f321a.u.getParent());
        }
    }
}
