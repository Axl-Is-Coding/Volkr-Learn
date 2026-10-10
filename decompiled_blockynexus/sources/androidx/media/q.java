package androidx.media;

import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f1731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1732d;

    q(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, ResultReceiver resultReceiver) {
        this.f1732d = jVar;
        this.f1729a = kVar;
        this.f1730b = str;
        this.f1731c = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f1666c.get(this.f1729a.asBinder());
        if (bVar != null) {
            MediaBrowserServiceCompat.this.a(this.f1730b, bVar, this.f1731c);
            return;
        }
        Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f1730b);
    }
}
