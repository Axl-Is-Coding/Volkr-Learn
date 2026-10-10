package zlc.season.rxdownload4.a;

import android.os.Environment;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.e;
import java.io.File;
import java.util.Map;
import kotlin.collections.z;
import kotlin.j;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload4.download.request.RequestImpl;
import zlc.season.rxdownload4.download.storage.c;

/* JADX INFO: compiled from: RxDownload.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f23866b;

    static {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        i.a((Object) externalStoragePublicDirectory, "getExternalStoragePublic…tory(DIRECTORY_DOWNLOADS)");
        String path = externalStoragePublicDirectory.getPath();
        i.a((Object) path, "getExternalStoragePublic…DIRECTORY_DOWNLOADS).path");
        f23865a = path;
        f23866b = z.a(j.a("Range", "bytes=0-"));
    }

    public static final e<a> a(zlc.season.rxdownload4.a.a.a aVar) {
        return a(aVar, null, 0, 0L, null, null, null, null, null, 255, null);
    }

    public static final e<a> a(zlc.season.rxdownload4.a.a.a aVar, Map<String, String> map, int i, long j) {
        return a(aVar, map, i, j, null, null, null, null, null, 248, null);
    }

    public static final String a() {
        return f23865a;
    }

    public static final void a(String str) {
        a(str, (c) null, 1, (Object) null);
    }

    public static final Map<String, String> b() {
        return f23866b;
    }

    public static /* synthetic */ void a(String str, c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            cVar = zlc.season.rxdownload4.download.storage.b.f23929e;
        }
        a(str, cVar);
    }

    public static final File b(zlc.season.rxdownload4.a.a.a aVar, c cVar) {
        i.b(aVar, "$this$file");
        i.b(cVar, "storage");
        cVar.c(aVar);
        if (aVar.e()) {
            zlc.season.rxdownload4.download.utils.c.a("Task file not found", null, 1, null);
        }
        return new File(aVar.b(), aVar.a());
    }

    public static final void a(String str, c cVar) {
        i.b(str, "$this$delete");
        i.b(cVar, "storage");
        a(new zlc.season.rxdownload4.a.a.a(str, null, null, null, 14, null), cVar);
    }

    public static /* synthetic */ e a(zlc.season.rxdownload4.a.a.a aVar, Map map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, c cVar, zlc.season.rxdownload4.download.request.a aVar2, zlc.season.rxdownload4.a.c.a aVar3, int i2, Object obj) {
        return a(aVar, (i2 & 1) != 0 ? f23866b : map, (i2 & 2) != 0 ? 5 : i, (i2 & 4) != 0 ? 4194304L : j, (i2 & 8) != 0 ? zlc.season.rxdownload4.download.downloader.a.f23871a : bVar, (i2 & 16) != 0 ? zlc.season.rxdownload4.a.b.a.f23867a : bVar2, (i2 & 32) != 0 ? zlc.season.rxdownload4.download.storage.b.f23929e : cVar, (i2 & 64) != 0 ? RequestImpl.f23923b : aVar2, (i2 & 128) != 0 ? zlc.season.rxdownload4.a.c.b.f23870c : aVar3);
    }

    public static final e<a> a(zlc.season.rxdownload4.a.a.a aVar, Map<String, String> map, int i, long j, zlc.season.rxdownload4.download.downloader.b bVar, zlc.season.rxdownload4.a.b.b bVar2, c cVar, zlc.season.rxdownload4.download.request.a aVar2, zlc.season.rxdownload4.a.c.a aVar3) {
        i.b(aVar, "$this$download");
        i.b(map, "header");
        i.b(bVar, "dispatcher");
        i.b(bVar2, "validator");
        i.b(cVar, "storage");
        i.b(aVar2, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        i.b(aVar3, "watcher");
        if (!(j > 0)) {
            throw new IllegalArgumentException("rangeSize must be greater than 0B");
        }
        if (i > 0) {
            return new zlc.season.rxdownload4.a.a.e(aVar, map, i, j, bVar, bVar2, cVar, aVar2, aVar3).i();
        }
        throw new IllegalArgumentException("maxConCurrency must be greater than 0");
    }

    public static final void a(zlc.season.rxdownload4.a.a.a aVar, c cVar) {
        i.b(aVar, "$this$delete");
        i.b(cVar, "storage");
        zlc.season.rxdownload4.download.utils.a.b(b(aVar, cVar));
        cVar.a(aVar);
    }
}
