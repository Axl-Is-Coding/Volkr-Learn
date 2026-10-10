package zlc.season.rxdownload4.download.downloader;

import okhttp3.J;
import retrofit2.Response;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class p implements io.reactivex.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f23908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Response f23909b;

    p(n nVar, Response response) {
        this.f23908a = nVar;
        this.f23909b = response;
    }

    @Override // io.reactivex.b.a
    public final void run() {
        n.c(this.f23908a).renameTo(n.a(this.f23908a));
        n.d(this.f23908a).delete();
        J j = (J) this.f23909b.body();
        if (j != null) {
            zlc.season.rxdownload4.download.utils.b.a(j);
        }
    }
}
