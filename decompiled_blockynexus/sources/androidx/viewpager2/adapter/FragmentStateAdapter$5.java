package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateAdapter$5 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Handler f2406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f2407b;

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f2406a.removeCallbacks(this.f2407b);
            gVar.getLifecycle().b(this);
        }
    }
}
