package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import java.util.Map;

/* JADX INFO: compiled from: SavedStateRegistry.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f2068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2069c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.arch.core.b.b<String, b> f2067a = new androidx.arch.core.b.b<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2070d = true;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SavedStateRegistry.java */
    public interface InterfaceC0033a {
        void a(c cVar);
    }

    /* JADX INFO: compiled from: SavedStateRegistry.java */
    public interface b {
        Bundle a();
    }

    a() {
    }

    public Bundle a(String str) {
        if (!this.f2069c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2068b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f2068b.remove(str);
        if (this.f2068b.isEmpty()) {
            this.f2068b = null;
        }
        return bundle2;
    }

    void a(Lifecycle lifecycle, Bundle bundle) {
        if (!this.f2069c) {
            if (bundle != null) {
                this.f2068b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            lifecycle.a(new d() { // from class: androidx.savedstate.SavedStateRegistry$1
                @Override // androidx.lifecycle.e
                public void a(g gVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        this.f2066a.f2070d = true;
                    } else if (event == Lifecycle.Event.ON_STOP) {
                        this.f2066a.f2070d = false;
                    }
                }
            });
            this.f2069c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2068b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.arch.core.b.b<String, b>.d dVarC = this.f2067a.c();
        while (dVarC.hasNext()) {
            Map.Entry next = dVarC.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
