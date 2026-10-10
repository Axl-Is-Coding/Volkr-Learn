package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat.b;

/* JADX INFO: renamed from: androidx.media.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0350r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f1736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Bundle f1737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1738f;

    RunnableC0350r(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, int i, int i2, Bundle bundle) {
        this.f1738f = jVar;
        this.f1733a = kVar;
        this.f1734b = str;
        this.f1735c = i;
        this.f1736d = i2;
        this.f1737e = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder iBinderAsBinder = this.f1733a.asBinder();
        MediaBrowserServiceCompat.this.f1666c.remove(iBinderAsBinder);
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.new b(this.f1734b, this.f1735c, this.f1736d, this.f1737e, this.f1733a);
        MediaBrowserServiceCompat.this.f1666c.put(iBinderAsBinder, bVar);
        try {
            iBinderAsBinder.linkToDeath(bVar, 0);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}
