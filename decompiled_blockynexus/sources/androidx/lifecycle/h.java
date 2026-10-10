package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: LifecycleRegistry.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f1597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f1598b = new int[Lifecycle.State.values().length];

    static {
        try {
            f1598b[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1598b[Lifecycle.State.CREATED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1598b[Lifecycle.State.STARTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1598b[Lifecycle.State.RESUMED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1598b[Lifecycle.State.DESTROYED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f1597a = new int[Lifecycle.Event.values().length];
        try {
            f1597a[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f1597a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f1597a[Lifecycle.Event.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f1597a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f1597a[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f1597a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f1597a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
