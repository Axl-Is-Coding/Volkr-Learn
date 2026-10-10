package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: FullLifecycleObserverAdapter.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f1596a = new int[Lifecycle.Event.values().length];

    static {
        try {
            f1596a[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1596a[Lifecycle.Event.ON_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1596a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1596a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1596a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f1596a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f1596a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
