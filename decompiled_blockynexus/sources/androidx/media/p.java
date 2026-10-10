package androidx.media;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ IBinder f1727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1728d;

    p(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, IBinder iBinder) {
        this.f1728d = jVar;
        this.f1725a = kVar;
        this.f1726b = str;
        this.f1727c = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f1666c.get(this.f1725a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f1726b);
            return;
        }
        if (MediaBrowserServiceCompat.this.a(this.f1726b, bVar, this.f1727c)) {
            return;
        }
        Log.w("MBServiceCompat", "removeSubscription called for " + this.f1726b + " which is not subscribed");
    }
}
