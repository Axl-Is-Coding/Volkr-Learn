package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class o implements androidx.core.view.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f316a;

    o(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f316a = appCompatDelegateImpl;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        int iE = j.e();
        int iJ = this.f316a.j(iE);
        if (iE != iJ) {
            j = j.a(j.c(), iJ, j.d(), j.b());
        }
        return ViewCompat.b(view, j);
    }
}
