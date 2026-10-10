package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0104zaa> zacl;

    public zaa(Activity activity) {
        this(C0104zaa.zaa(activity));
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0104zaa c0104zaa = this.zacl.get();
        if (c0104zaa == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        c0104zaa.zaa(runnable);
        return this;
    }

    private zaa(C0104zaa c0104zaa) {
        this.zacl = new WeakReference<>(c0104zaa);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.zaa$zaa, reason: collision with other inner class name */
    static class C0104zaa extends LifecycleCallback {
        private List<Runnable> zacm;

        private C0104zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.zacm = new ArrayList();
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C0104zaa zaa(Activity activity) {
            C0104zaa c0104zaa;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                c0104zaa = (C0104zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0104zaa.class);
                if (c0104zaa == null) {
                    c0104zaa = new C0104zaa(fragment);
                }
            }
            return c0104zaa;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacm;
                this.zacm = new ArrayList();
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacm.add(runnable);
        }
    }
}
