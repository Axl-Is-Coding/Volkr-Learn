package androidx.viewpager2.adapter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateAdapter$2 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f2404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f2405b;

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        if (this.f2405b.b()) {
            return;
        }
        gVar.getLifecycle().b(this);
        this.f2404a.a();
        throw null;
    }
}
