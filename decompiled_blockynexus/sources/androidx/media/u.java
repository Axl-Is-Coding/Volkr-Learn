package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f1750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bundle f1752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f1753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f1754e;

    u(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f1754e = jVar;
        this.f1750a = kVar;
        this.f1751b = str;
        this.f1752c = bundle;
        this.f1753d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f1666c.get(this.f1750a.asBinder());
        if (bVar != null) {
            MediaBrowserServiceCompat.this.a(this.f1751b, this.f1752c, bVar, this.f1753d);
            return;
        }
        Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f1751b + ", extras=" + this.f1752c);
    }
}
