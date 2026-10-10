package zlc.season.rxdownload3.http;

import io.reactivex.b.g;
import io.reactivex.b.o;
import io.reactivex.m;
import kotlin.jvm.internal.i;
import okhttp3.J;
import retrofit2.Response;
import zlc.season.rxdownload3.core.DownloadConfig;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.helper.UtilsKt;

/* JADX INFO: compiled from: HttpCore.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RetrofitApi f23836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HttpCore f23837b = new HttpCore();

    static {
        Object objCreate = RetrofitClient.a(RetrofitClient.f23842c, null, 1, null).create(RetrofitApi.class);
        i.a(objCreate, "RetrofitClient.get().cre…(RetrofitApi::class.java)");
        f23836a = (RetrofitApi) objCreate;
    }

    private HttpCore() {
    }

    public final io.reactivex.i<Object> a(final RealMission realMission) {
        i.b(realMission, "mission");
        io.reactivex.i<R> iVarA = (DownloadConfig.r.q() ? f23836a.checkByHead("bytes=0-", realMission.b().e()) : f23836a.checkByGet("bytes=0-", realMission.b().e())).a((o<? super Response<Void>, ? extends m<? extends R>>) new o<T, m<? extends R>>() { // from class: zlc.season.rxdownload3.http.HttpCore$checkUrl$1
            @Override // io.reactivex.b.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final io.reactivex.i<Object> apply(Response<Void> response) {
                i.b(response, "it");
                if (!response.isSuccessful()) {
                    throw new RuntimeException(response.message());
                }
                realMission.a(response);
                return io.reactivex.i.a(UtilsKt.a());
            }
        });
        i.a((Object) iVarA, "if (DownloadConfig.useHe…Maybe.just(ANY)\n        }");
        return iVarA;
    }

    public static /* synthetic */ io.reactivex.i a(HttpCore httpCore, RealMission realMission, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return httpCore.a(realMission, str);
    }

    public final io.reactivex.i<Response<J>> a(RealMission realMission, String str) {
        i.b(realMission, "mission");
        i.b(str, "range");
        io.reactivex.i<Response<J>> iVarB = f23836a.download(str, realMission.b().e()).b(new g<Response<J>>() { // from class: zlc.season.rxdownload3.http.HttpCore$download$1
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(Response<J> response) {
                i.a((Object) response, "it");
                if (!response.isSuccessful()) {
                    throw new RuntimeException(response.message());
                }
            }
        });
        i.a((Object) iVarB, "api.download(range, miss…      }\n                }");
        return iVarB;
    }
}
