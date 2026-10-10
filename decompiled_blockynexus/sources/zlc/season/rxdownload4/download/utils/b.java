package zlc.season.rxdownload4.download.utils;

import java.io.Closeable;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import kotlin.text.o;
import retrofit2.Response;

/* JADX INFO: compiled from: HttpUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final void a(Closeable closeable) {
        i.b(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final String b(Response<?> response) {
        i.b(response, "$this$fileName");
        String strE = e(response);
        String strF = f(response);
        return strF.length() == 0 ? a(strE) : strF;
    }

    public static final boolean c(Response<?> response) {
        i.b(response, "$this$isChunked");
        return i.a((Object) a(response, "Transfer-Encoding"), (Object) "chunked");
    }

    public static final boolean d(Response<?> response) {
        i.b(response, "$this$isSupportRange");
        if (response.code() != 206) {
            if (!(a(response, "Content-Range").length() > 0) && !i.a((Object) a(response, "Accept-Ranges"), (Object) "bytes")) {
                return false;
            }
        }
        return true;
    }

    public static final String e(Response<?> response) {
        i.b(response, "$this$url");
        String string = response.raw().y().g().toString();
        i.a((Object) string, "raw().request().url().toString()");
        return string;
    }

    private static final String f(Response<?> response) {
        String strA = a(response, "Content-Disposition");
        Locale locale = Locale.getDefault();
        i.a((Object) locale, "Locale.getDefault()");
        if (strA == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strA.toLowerCase(locale);
        i.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (lowerCase.length() == 0) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(lowerCase);
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

    public static final long a(Response<?> response) {
        i.b(response, "$this$contentLength");
        return d.a(a(response, "Content-Length"), -1L);
    }

    public static final long a(Response<?> response, long j) {
        i.b(response, "$this$sliceCount");
        long jA = a(response);
        long j2 = jA % j;
        long j3 = jA / j;
        return j2 == 0 ? j3 : j3 + 1;
    }

    public static final String a(String str) {
        i.b(str, "url");
        if (!(str.length() > 0)) {
            return "";
        }
        int iB = o.b((CharSequence) str, '#', 0, false, 6, (Object) null);
        if (iB > 0) {
            str = str.substring(0, iB);
            i.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        int iB2 = o.b((CharSequence) str, '?', 0, false, 6, (Object) null);
        if (iB2 > 0) {
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(0, iB2);
            i.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        int iB3 = o.b((CharSequence) str, '/', 0, false, 6, (Object) null);
        if (iB3 >= 0) {
            int i = iB3 + 1;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(i);
            i.a((Object) str, "(this as java.lang.String).substring(startIndex)");
        }
        return ((str.length() > 0) && Pattern.matches("[a-zA-Z_0-9.\\-()%]+", str)) ? str : "";
    }

    private static final String a(Response<?> response, String str) {
        String strB = response.headers().b(str);
        return strB != null ? strB : "";
    }
}
