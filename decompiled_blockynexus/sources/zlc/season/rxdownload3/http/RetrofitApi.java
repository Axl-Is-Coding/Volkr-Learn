package zlc.season.rxdownload3.http;

import io.reactivex.i;
import okhttp3.J;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX INFO: compiled from: RetrofitApi.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface RetrofitApi {
    @GET
    i<Response<Void>> checkByGet(@Header("Range") String str, @Url String str2);

    @HEAD
    i<Response<Void>> checkByHead(@Header("Range") String str, @Url String str2);

    @Streaming
    @GET
    i<Response<J>> download(@Header("Range") String str, @Url String str2);
}
