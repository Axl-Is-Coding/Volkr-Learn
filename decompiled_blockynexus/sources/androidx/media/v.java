package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MediaBrowserServiceCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class v {

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi21.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f1756b;
    }

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi21.java */
    static class b extends MediaBrowserService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f1757a;

        b(Context context, d dVar) {
            attachBaseContext(context);
            this.f1757a = dVar;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            a aVarA = this.f1757a.a(str, i, bundle == null ? null : new Bundle(bundle));
            if (aVarA == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(aVarA.f1755a, aVarA.f1756b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f1757a.b(str, new c<>(result));
        }
    }

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi21.java */
    public interface d {
        a a(String str, int i, Bundle bundle);

        void b(String str, c<List<Parcel>> cVar);
    }

    public static Object a(Context context, d dVar) {
        return new b(context, dVar);
    }

    public static void a(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static IBinder a(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    /* JADX INFO: compiled from: MediaBrowserServiceCompatApi21.java */
    static class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f1758a;

        c(MediaBrowserService.Result result) {
            this.f1758a = result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(T t) {
            if (t instanceof List) {
                this.f1758a.sendResult(a((List<Parcel>) t));
                return;
            }
            if (!(t instanceof Parcel)) {
                this.f1758a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) t;
            parcel.setDataPosition(0);
            this.f1758a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
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
