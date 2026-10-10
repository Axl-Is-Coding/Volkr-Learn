package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bundle f1747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f1748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1749e;

    t(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f1749e = jVar;
        this.f1745a = kVar;
        this.f1746b = str;
        this.f1747c = bundle;
        this.f1748d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f1666c.get(this.f1745a.asBinder());
        if (bVar != null) {
            MediaBrowserServiceCompat.this.b(this.f1746b, this.f1747c, bVar, this.f1748d);
            return;
        }
        Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f1746b);
    }
}
