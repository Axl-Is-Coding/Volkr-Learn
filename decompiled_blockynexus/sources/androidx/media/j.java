package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MediaBrowserServiceCompat.java */
/* JADX INFO: loaded from: classes.dex */
class j extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ v.c f1709f;
    final /* synthetic */ MediaBrowserServiceCompat.d g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(MediaBrowserServiceCompat.d dVar, Object obj, v.c cVar) {
        super(obj);
        this.g = dVar;
        this.f1709f = cVar;
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
        this.f1709f.a(arrayList);
    }
}
