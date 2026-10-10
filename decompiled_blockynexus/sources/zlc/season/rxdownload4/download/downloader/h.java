package zlc.season.rxdownload4.download.downloader;

import java.util.Map;
import kotlin.collections.z;
import zlc.season.rxdownload4.download.downloader.q;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class h<T, R> implements io.reactivex.b.o<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f23883a = new h();

    h() {
    }

    @Override // io.reactivex.b.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, String> apply(q.c cVar) {
        kotlin.jvm.internal.i.b(cVar, "it");
        Map<String, String> mapA = z.a(kotlin.j.a("Range", "bytes=" + cVar.b() + '-' + cVar.c()));
        zlc.season.rxdownload4.download.utils.c.a(mapA, null, 1, null);
        return mapA;
    }
}
