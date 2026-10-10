package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat.b;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f1715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Bundle f1716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1717f;

    m(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, int i, int i2, Bundle bundle) {
        this.f1717f = jVar;
        this.f1712a = kVar;
        this.f1713b = str;
        this.f1714c = i;
        this.f1715d = i2;
        this.f1716e = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder iBinderAsBinder = this.f1712a.asBinder();
        MediaBrowserServiceCompat.this.f1666c.remove(iBinderAsBinder);
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.new b(this.f1713b, this.f1714c, this.f1715d, this.f1716e, this.f1712a);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.f1667d = bVar;
        bVar.h = mediaBrowserServiceCompat.a(this.f1713b, this.f1715d, this.f1716e);
        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat2.f1667d = null;
        if (bVar.h == null) {
            Log.i("MBServiceCompat", "No root for client " + this.f1713b + " from service " + m.class.getName());
            try {
                this.f1712a.a();
                return;
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f1713b);
                return;
            }
        }
        try {
            mediaBrowserServiceCompat2.f1666c.put(iBinderAsBinder, bVar);
            iBinderAsBinder.linkToDeath(bVar, 0);
            if (MediaBrowserServiceCompat.this.f1669f == null) {
                return;
            }
            MediaBrowserServiceCompat.k kVar = this.f1712a;
            bVar.h.b();
            throw null;
        } catch (RemoteException unused2) {
            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.f1713b);
            MediaBrowserServiceCompat.this.f1666c.remove(iBinderAsBinder);
        }
    }
}
