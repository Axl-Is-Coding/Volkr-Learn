package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.J;
import androidx.core.view.r;

/* JADX INFO: compiled from: CoordinatorLayout.java */
/* JADX INFO: loaded from: classes.dex */
class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f906a;

    a(CoordinatorLayout coordinatorLayout) {
        this.f906a = coordinatorLayout;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        return this.f906a.setWindowInsets(j);
    }
}
