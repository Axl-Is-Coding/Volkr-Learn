package zlc.season.rxdownload3.http;

import kotlin.jvm.internal.i;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zlc.season.rxdownload3.core.DownloadConfig;

/* JADX INFO: compiled from: RetrofitClient.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RetrofitClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RetrofitClient f23842c = new RetrofitClient();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23840a = "http://www.example.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final OkHttpClientFactory f23841b = DownloadConfig.r.o();

    private RetrofitClient() {
    }

    public static /* synthetic */ Retrofit a(RetrofitClient retrofitClient, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = f23840a;
        }
        return retrofitClient.a(str);
    }

    public final Retrofit a(String str) {
        i.b(str, "baseUrl");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(str).client(f23841b.build()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        i.a((Object) retrofitBuild, "Retrofit.Builder()\n     …\n                .build()");
        return retrofitBuild;
    }
}
