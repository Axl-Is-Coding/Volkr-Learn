package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: SavedStateRegistryController.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f2071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2072b = new a();

    private b(c cVar) {
        this.f2071a = cVar;
    }

    public a a() {
        return this.f2072b;
    }

    public void b(Bundle bundle) {
        this.f2072b.a(bundle);
    }

    public void a(Bundle bundle) {
        Lifecycle lifecycle = this.f2071a.getLifecycle();
        if (lifecycle.a() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f2071a));
        this.f2072b.a(lifecycle, bundle);
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}
