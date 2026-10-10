package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.v;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class k extends MediaBrowserServiceCompat.i<MediaBrowserCompat.MediaItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ v.c f1710f;
    final /* synthetic */ MediaBrowserServiceCompat.e g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(MediaBrowserServiceCompat.e eVar, Object obj, v.c cVar) {
        super(obj);
        this.g = eVar;
        this.f1710f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(MediaBrowserCompat.MediaItem mediaItem) {
        if (mediaItem == null) {
            this.f1710f.a((Object) null);
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        mediaItem.writeToParcel(parcelObtain, 0);
        this.f1710f.a(parcelObtain);
    }
}
