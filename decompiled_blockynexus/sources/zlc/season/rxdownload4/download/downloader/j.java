package zlc.season.rxdownload4.download.downloader;

import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload4.download.downloader.n;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class j<T, R> implements io.reactivex.b.o<T, f.b.b<? extends R>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n.a f23885a;

    j(n.a aVar) {
        this.f23885a = aVar;
    }

    @Override // io.reactivex.b.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final io.reactivex.e<Long> apply(Response<J> response) {
        kotlin.jvm.internal.i.b(response, "it");
        n.a aVar = this.f23885a;
        return aVar.a(aVar.f23897b, (Response<J>) response);
    }
}
