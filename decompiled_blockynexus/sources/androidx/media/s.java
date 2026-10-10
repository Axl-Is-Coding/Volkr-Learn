package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1740b;

    s(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar) {
        this.f1740b = jVar;
        this.f1739a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder iBinderAsBinder = this.f1739a.asBinder();
        MediaBrowserServiceCompat.b bVarRemove = MediaBrowserServiceCompat.this.f1666c.remove(iBinderAsBinder);
        if (bVarRemove != null) {
            iBinderAsBinder.unlinkToDeath(bVarRemove, 0);
        }
    }
}
