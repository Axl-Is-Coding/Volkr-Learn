package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1719b;

    n(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar) {
        this.f1719b = jVar;
        this.f1718a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVarRemove = MediaBrowserServiceCompat.this.f1666c.remove(this.f1718a.asBinder());
        if (bVarRemove != null) {
            bVarRemove.f1675f.asBinder().unlinkToDeath(bVarRemove, 0);
        }
    }
}
