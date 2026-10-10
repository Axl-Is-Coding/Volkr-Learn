package zlc.season.rxdownload4.download.request;

import io.reactivex.e;
import java.util.Map;
import kotlin.jvm.internal.i;
import okhttp3.J;
import okhttp3.z;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX INFO: compiled from: RequestImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RequestImpl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api f23922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RequestImpl f23923b = new RequestImpl();

    /* JADX INFO: compiled from: RequestImpl.kt */
    public interface Api {
        @Streaming
        @GET
        e<Response<J>> get(@Url String str, @HeaderMap Map<String, String> map);
    }

    static {
        z zVarA = b.a();
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreateWithScheduler = RxJava2CallAdapterFactory.createWithScheduler(io.reactivex.f.b.b());
        i.a((Object) rxJava2CallAdapterFactoryCreateWithScheduler, "RxJava2CallAdapterFactor…cheduler(Schedulers.io())");
        GsonConverterFactory gsonConverterFactoryCreate = GsonConverterFactory.create();
        i.a((Object) gsonConverterFactoryCreate, "GsonConverterFactory.create()");
        f23922a = (Api) new Retrofit.Builder().baseUrl("http://www.example.com").client(zVarA).addCallAdapterFactory(rxJava2CallAdapterFactoryCreateWithScheduler).addConverterFactory(gsonConverterFactoryCreate).build().create(Api.class);
    }

    private RequestImpl() {
    }

    @Override // zlc.season.rxdownload4.download.request.a
    public e<Response<J>> get(String str, Map<String, String> map) {
        i.b(str, "url");
        i.b(map, "headers");
        return f23922a.get(str, map);
    }
}
