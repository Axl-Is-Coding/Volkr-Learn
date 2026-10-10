package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class f extends MediaBrowserServiceCompat.i<MediaBrowserCompat.MediaItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ResultReceiver f1705f;
    final /* synthetic */ MediaBrowserServiceCompat g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.g = mediaBrowserServiceCompat;
        this.f1705f = resultReceiver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(MediaBrowserCompat.MediaItem mediaItem) {
        if ((a() & 2) != 0) {
            this.f1705f.send(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", mediaItem);
        this.f1705f.send(0, bundle);
    }
}
