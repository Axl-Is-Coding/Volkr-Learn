package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.b f1708a;

    i(MediaBrowserServiceCompat.b bVar) {
        this.f1708a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = this.f1708a;
        MediaBrowserServiceCompat.this.f1666c.remove(bVar.f1675f.asBinder());
    }
}
