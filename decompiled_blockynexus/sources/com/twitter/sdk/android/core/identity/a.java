package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import com.twitter.sdk.android.core.n;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AuthState.java */
/* JADX INFO: loaded from: classes5.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<AuthHandler> f20138a = new AtomicReference<>(null);

    a() {
    }

    public boolean a(Activity activity, AuthHandler authHandler) {
        if (c()) {
            n.e().w("Twitter", "Authorize already in progress");
        } else if (authHandler.a(activity)) {
            boolean zCompareAndSet = this.f20138a.compareAndSet(null, authHandler);
            if (zCompareAndSet) {
                return zCompareAndSet;
            }
            n.e().w("Twitter", "Failed to update authHandler, authorize already in progress.");
            return zCompareAndSet;
        }
        return false;
    }

    public AuthHandler b() {
        return this.f20138a.get();
    }

    public boolean c() {
        return this.f20138a.get() != null;
    }

    public void a() {
        this.f20138a.set(null);
    }
}
