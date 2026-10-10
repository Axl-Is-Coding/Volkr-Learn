package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ActivityLifecycleManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f20167a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ActivityLifecycleManager.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<Application.ActivityLifecycleCallbacks> f20168a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Application f20169b;

        a(Application application) {
            this.f20169b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(b bVar) {
            if (this.f20169b == null) {
                return false;
            }
            d dVar = new d(this, bVar);
            this.f20169b.registerActivityLifecycleCallbacks(dVar);
            this.f20168a.add(dVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: ActivityLifecycleManager.java */
    public static abstract class b {
        public void a(Activity activity) {
        }

        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void c(Activity activity) {
        }

        public abstract void d(Activity activity);

        public void e(Activity activity) {
        }
    }

    public e(Context context) {
        this.f20167a = new a((Application) context.getApplicationContext());
    }

    public boolean a(b bVar) {
        a aVar = this.f20167a;
        return aVar != null && aVar.a(bVar);
    }
}
