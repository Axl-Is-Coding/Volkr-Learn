package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class l extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ x.b f1711f;
    final /* synthetic */ MediaBrowserServiceCompat.f g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l(MediaBrowserServiceCompat.f fVar, Object obj, x.b bVar) {
        super(obj);
        this.g = fVar;
        this.f1711f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(List<MediaBrowserCompat.MediaItem> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (MediaBrowserCompat.MediaItem mediaItem : list) {
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                arrayList.add(parcelObtain);
            }
        } else {
            arrayList = null;
        }
        this.f1711f.a(arrayList, a());
    }
}
