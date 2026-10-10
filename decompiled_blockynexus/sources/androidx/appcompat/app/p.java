package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.H;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class p implements H.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f317a;

    p(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f317a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.H.a
    public void a(Rect rect) {
        rect.top = this.f317a.j(rect.top);
    }
}
