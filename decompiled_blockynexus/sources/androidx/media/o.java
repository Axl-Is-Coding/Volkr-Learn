package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ IBinder f1722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f1723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1724e;

    o(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, IBinder iBinder, Bundle bundle) {
        this.f1724e = jVar;
        this.f1720a = kVar;
        this.f1721b = str;
        this.f1722c = iBinder;
        this.f1723d = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f1666c.get(this.f1720a.asBinder());
        if (bVar != null) {
            MediaBrowserServiceCompat.this.a(this.f1721b, bVar, this.f1722c, this.f1723d);
            return;
        }
        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f1721b);
    }
}
