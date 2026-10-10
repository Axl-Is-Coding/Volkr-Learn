package zlc.season.rxdownload4.download.downloader;

import java.util.concurrent.Callable;
import okhttp3.J;
import okio.BufferedSource;
import okio.Okio;
import zlc.season.rxdownload4.download.downloader.d;

/* JADX INFO: compiled from: NormalDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e<V> implements Callable<d.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f23878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ J f23879b;

    e(d dVar, J j) {
        this.f23878a = dVar;
        this.f23879b = j;
    }

    @Override // java.util.concurrent.Callable
    public final d.a call() {
        BufferedSource bufferedSourceSource = this.f23879b.source();
        kotlin.jvm.internal.i.a((Object) bufferedSourceSource, "body.source()");
        return new d.a(bufferedSourceSource, Okio.buffer(Okio.sink$default(d.b(this.f23878a), false, 1, null)), null, 4, null);
    }
}
