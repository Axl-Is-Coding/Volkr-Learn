package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class q implements ContentFrameLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f318a;

    q(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f318a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void a() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void onDetachedFromWindow() {
        this.f318a.m();
    }
}
