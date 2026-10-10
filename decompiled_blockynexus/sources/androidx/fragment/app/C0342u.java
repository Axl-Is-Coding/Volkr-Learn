package androidx.fragment.app;

import android.os.Bundle;

/* JADX INFO: renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class C0342u extends C0334l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LayoutInflaterFactory2C0343v f1530b;

    C0342u(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v) {
        this.f1530b = layoutInflaterFactory2C0343v;
    }

    @Override // androidx.fragment.app.C0334l
    public Fragment a(ClassLoader classLoader, String str) {
        AbstractC0335m abstractC0335m = this.f1530b.t;
        return abstractC0335m.a(abstractC0335m.c(), str, (Bundle) null);
    }
}
