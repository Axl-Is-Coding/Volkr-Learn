package androidx.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

/* JADX INFO: renamed from: androidx.media.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class C0349e extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.b f1704f;
    final /* synthetic */ String g;
    final /* synthetic */ Bundle h;
    final /* synthetic */ Bundle i;
    final /* synthetic */ MediaBrowserServiceCompat j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0349e(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, MediaBrowserServiceCompat.b bVar, String str, Bundle bundle, Bundle bundle2) {
        super(obj);
        this.j = mediaBrowserServiceCompat;
        this.f1704f = bVar;
        this.g = str;
        this.h = bundle;
        this.i = bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(List<MediaBrowserCompat.MediaItem> list) {
        if (this.j.f1666c.get(this.f1704f.f1675f.asBinder()) != this.f1704f) {
            if (MediaBrowserServiceCompat.f1664a) {
                Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f1704f.f1670a + " id=" + this.g);
                return;
            }
            return;
        }
        if ((a() & 1) != 0) {
            list = this.j.a(list, this.h);
        }
        try {
            this.f1704f.f1675f.a(this.g, list, this.h, this.i);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.g + " package=" + this.f1704f.f1670a);
        }
    }
}
