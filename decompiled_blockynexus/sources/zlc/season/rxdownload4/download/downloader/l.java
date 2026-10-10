package zlc.season.rxdownload4.download.downloader;

import java.io.IOException;
import zlc.season.rxdownload4.download.downloader.n;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class l<T1, T2> implements io.reactivex.b.b<n.b, io.reactivex.d<Long>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f23889a = new l();

    l() {
    }

    @Override // io.reactivex.b.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(n.b bVar, io.reactivex.d<Long> dVar) throws IOException {
        byte[] bArr = new byte[8192];
        int i = bVar.d().read(bArr);
        if (i == -1) {
            dVar.onComplete();
            return;
        }
        bVar.c().put(bArr, 0, i);
        long j = i;
        bVar.a(bVar.a() + j);
        bVar.e().putLong(16, bVar.a());
        dVar.onNext(Long.valueOf(j));
    }
}
