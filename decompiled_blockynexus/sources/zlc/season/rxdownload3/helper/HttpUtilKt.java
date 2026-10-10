package zlc.season.rxdownload3.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import kotlin.text.o;
import okhttp3.internal.http.e;
import retrofit2.Response;

/* JADX INFO: compiled from: HttpUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpUtilKt {
    public static final String a(String str, String str2, Response<?> response) {
        i.b(str, "saveName");
        i.b(str2, "url");
        i.b(response, "response");
        if (str.length() > 0) {
            return str;
        }
        String strA = a(response);
        return strA.length() == 0 ? a(str2) : strA;
    }

    public static final long b(Response<?> response) {
        i.b(response, "response");
        return e.a(response.headers());
    }

    public static final boolean c(Response<?> response) {
        i.b(response, "response");
        return i.a((Object) "chunked", (Object) g(response));
    }

    public static final boolean d(Response<?> response) {
        i.b(response, "resp");
        if (!response.isSuccessful()) {
            return false;
        }
        if (response.code() != 206) {
            if (!(f(response).length() > 0)) {
                if (!(e(response).length() > 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final String e(Response<?> response) {
        String strB = response.headers().b("Accept-Ranges");
        return strB == null ? "" : strB;
    }

    private static final String f(Response<?> response) {
        String strB = response.headers().b("Content-Range");
        return strB == null ? "" : strB;
    }

    private static final String g(Response<?> response) {
        String strB = response.headers().b("Transfer-Encoding");
        return strB == null ? "" : strB;
    }

    public static final String a(String str) {
        i.b(str, "url");
        String strSubstring = str.substring(o.b((CharSequence) str, '/', 0, false, 6, (Object) null) + 1);
        i.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final String a(Response<?> response) {
        i.b(response, "response");
        String strB = response.headers().b("Content-Disposition");
        if (strB != null) {
            if (!(strB.length() == 0)) {
                Pattern patternCompile = Pattern.compile(".*filename=(.*)");
                String lowerCase = strB.toLowerCase();
                i.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                Matcher matcher = patternCompile.matcher(lowerCase);
                if (!matcher.find()) {
                    return "";
                }
                String strGroup = matcher.group(1);
                i.a((Object) strGroup, "result");
                if (n.b(strGroup, "\"", false, 2, null)) {
                    strGroup = strGroup.substring(1);
                    i.a((Object) strGroup, "(this as java.lang.String).substring(startIndex)");
                }
                i.a((Object) strGroup, "result");
                if (n.a(strGroup, "\"", false, 2, null)) {
                    strGroup = strGroup.substring(0, strGroup.length() - 1);
                    i.a((Object) strGroup, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                i.a((Object) strGroup, "result");
                return n.a(strGroup, "/", "_", false);
            }
        }
        return "";
    }
}
