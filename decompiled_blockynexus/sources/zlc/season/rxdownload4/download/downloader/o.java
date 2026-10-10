package zlc.season.rxdownload4.download.downloader;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class o<T, R> implements io.reactivex.b.o<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zlc.season.rxdownload4.a.a f23907a;

    o(zlc.season.rxdownload4.a.a aVar) {
        this.f23907a = aVar;
    }

    @Override // io.reactivex.b.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zlc.season.rxdownload4.a.a apply(Long l) {
        kotlin.jvm.internal.i.b(l, "it");
        zlc.season.rxdownload4.a.a aVar = this.f23907a;
        aVar.a(aVar.a() + l.longValue());
        return aVar;
    }
}
