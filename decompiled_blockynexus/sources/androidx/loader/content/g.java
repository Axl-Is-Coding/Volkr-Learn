package androidx.loader.content;

import androidx.loader.content.ModernAsyncTask;

/* JADX INFO: compiled from: ModernAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f1641a = new int[ModernAsyncTask.Status.values().length];

    static {
        try {
            f1641a[ModernAsyncTask.Status.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1641a[ModernAsyncTask.Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
