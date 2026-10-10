package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MediaBrowserServiceCompatApi26.java */
/* JADX INFO: loaded from: classes.dex */
class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Field f1759a;

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi26.java */
    static class a extends w.a {
        a(Context context, c cVar) {
            super(context, cVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((c) this.f1757a).a(str, new b(result), bundle);
        }
    }

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi26.java */
    public interface c extends w.b {
        void a(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            f1759a = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f1759a.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.w("MBSCompatApi26", e2);
        }
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi26.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f1760a;

        b(MediaBrowserService.Result result) {
            this.f1760a = result;
        }

        public void a(List<Parcel> list, int i) {
            try {
                x.f1759a.setInt(this.f1760a, i);
            } catch (IllegalAccessException e2) {
                Log.w("MBSCompatApi26", e2);
            }
            this.f1760a.sendResult(a(list));
        }

        List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }
}
