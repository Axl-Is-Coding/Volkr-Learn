package zlc.season.rxdownload4.download.downloader;

import okhttp3.J;
import retrofit2.Response;

/* JADX INFO: compiled from: DefaultDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23871a = new a();

    private a() {
    }

    @Override // zlc.season.rxdownload4.download.downloader.b
    public c a(Response<J> response) {
        kotlin.jvm.internal.i.b(response, "response");
        return zlc.season.rxdownload4.download.utils.b.d(response) ? new n() : new d();
    }
}
