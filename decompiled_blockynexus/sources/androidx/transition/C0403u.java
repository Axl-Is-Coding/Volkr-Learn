package androidx.transition;

import android.view.View;

/* JADX INFO: renamed from: androidx.transition.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Fade.java */
/* JADX INFO: loaded from: classes.dex */
class C0403u extends C0379ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f2297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fade f2298b;

    C0403u(Fade fade, View view) {
        this.f2298b = fade;
        this.f2297a = view;
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        va.a(this.f2297a, 1.0f);
        va.a(this.f2297a);
        transition.b(this);
    }
}
