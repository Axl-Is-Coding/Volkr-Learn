package io.reactivex;

/* JADX INFO: compiled from: Observable.java */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f22737a = new int[BackpressureStrategy.values().length];

    static {
        try {
            f22737a[BackpressureStrategy.DROP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22737a[BackpressureStrategy.LATEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22737a[BackpressureStrategy.MISSING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22737a[BackpressureStrategy.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
