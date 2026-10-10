package zlc.season.rxdownload4.download.downloader;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import zlc.season.rxdownload4.download.downloader.d;

/* JADX INFO: compiled from: NormalDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class f<T1, T2> implements io.reactivex.b.b<d.a, io.reactivex.d<zlc.season.rxdownload4.a.a>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f23880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zlc.season.rxdownload4.a.a f23881b;

    f(d dVar, zlc.season.rxdownload4.a.a aVar) {
        this.f23880a = dVar;
        this.f23881b = aVar;
    }

    @Override // io.reactivex.b.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(d.a aVar, io.reactivex.d<zlc.season.rxdownload4.a.a> dVar) throws IOException {
        long j = aVar.c().read(aVar.a(), PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (j == -1) {
            aVar.b().flush();
            d.b(this.f23880a).renameTo(d.a(this.f23880a));
            dVar.onComplete();
        } else {
            aVar.b().emit();
            zlc.season.rxdownload4.a.a aVar2 = this.f23881b;
            aVar2.a(aVar2.a() + j);
            dVar.onNext(aVar2);
        }
    }
}
