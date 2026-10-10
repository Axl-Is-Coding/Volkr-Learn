package retrofit2;

import okhttp3.C;
import okhttp3.H;
import okhttp3.J;
import okhttp3.Protocol;
import okhttp3.u;
import retrofit2.OkHttpCall;

/* JADX INFO: loaded from: classes5.dex */
public final class Response<T> {
    private final T body;
    private final J errorBody;
    private final H rawResponse;

    private Response(H h, T t, J j) {
        this.rawResponse = h;
        this.body = t;
        this.errorBody = j;
    }

    public static <T> Response<T> error(int i, J j) {
        Utils.checkNotNull(j, "body == null");
        if (i < 400) {
            throw new IllegalArgumentException("code < 400: " + i);
        }
        H.a aVar = new H.a();
        aVar.a(new OkHttpCall.NoContentResponseBody(j.contentType(), j.contentLength()));
        aVar.a(i);
        aVar.a("Response.error()");
        aVar.a(Protocol.HTTP_1_1);
        C.a aVar2 = new C.a();
        aVar2.b("http://localhost/");
        aVar.a(aVar2.a());
        return error(j, aVar.a());
    }

    public static <T> Response<T> success(T t) {
        H.a aVar = new H.a();
        aVar.a(200);
        aVar.a("OK");
        aVar.a(Protocol.HTTP_1_1);
        C.a aVar2 = new C.a();
        aVar2.b("http://localhost/");
        aVar.a(aVar2.a());
        return success(t, aVar.a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.g();
    }

    public J errorBody() {
        return this.errorBody;
    }

    public u headers() {
        return this.rawResponse.o();
    }

    public boolean isSuccessful() {
        return this.rawResponse.q();
    }

    public String message() {
        return this.rawResponse.r();
    }

    public H raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i, T t) {
        if (i >= 200 && i < 300) {
            H.a aVar = new H.a();
            aVar.a(i);
            aVar.a("Response.success()");
            aVar.a(Protocol.HTTP_1_1);
            C.a aVar2 = new C.a();
            aVar2.b("http://localhost/");
            aVar.a(aVar2.a());
            return success(t, aVar.a());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i);
    }

    public static <T> Response<T> error(J j, H h) {
        Utils.checkNotNull(j, "body == null");
        Utils.checkNotNull(h, "rawResponse == null");
        if (!h.q()) {
            return new Response<>(h, null, j);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T t, u uVar) {
        Utils.checkNotNull(uVar, "headers == null");
        H.a aVar = new H.a();
        aVar.a(200);
        aVar.a("OK");
        aVar.a(Protocol.HTTP_1_1);
        aVar.a(uVar);
        C.a aVar2 = new C.a();
        aVar2.b("http://localhost/");
        aVar.a(aVar2.a());
        return success(t, aVar.a());
    }

    public static <T> Response<T> success(T t, H h) {
        Utils.checkNotNull(h, "rawResponse == null");
        if (h.q()) {
            return new Response<>(h, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
