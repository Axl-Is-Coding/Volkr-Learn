package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.C;
import okhttp3.v;

/* JADX INFO: compiled from: RequestLine.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static String a(C c2, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2.e());
        sb.append(' ');
        if (b(c2, type)) {
            sb.append(c2.g());
        } else {
            sb.append(a(c2.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(C c2, Proxy.Type type) {
        return !c2.d() && type == Proxy.Type.HTTP;
    }

    public static String a(v vVar) {
        String strC = vVar.c();
        String strE = vVar.e();
        if (strE == null) {
            return strC;
        }
        return strC + '?' + strE;
    }
}
