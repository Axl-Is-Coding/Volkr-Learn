package zlc.season.rxdownload4.download.downloader;

import java.util.Map;
import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload4.download.downloader.n;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class i<T, R> implements io.reactivex.b.o<T, f.b.b<? extends R>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n.a f23884a;

    i(n.a aVar) {
        this.f23884a = aVar;
    }

    @Override // io.reactivex.b.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final io.reactivex.e<Response<J>> apply(Map<String, String> map) {
        kotlin.jvm.internal.i.b(map, "it");
        return this.f23884a.f23900e.get(this.f23884a.f23896a, map);
    }
}
