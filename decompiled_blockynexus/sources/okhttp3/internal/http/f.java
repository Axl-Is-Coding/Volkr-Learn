package okhttp3.internal.http;

import io.grpc.internal.GrpcUtil;

/* JADX INFO: compiled from: HttpMethod.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    public static boolean a(String str) {
        return str.equals(GrpcUtil.HTTP_METHOD) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean c(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return str.equals(GrpcUtil.HTTP_METHOD) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
