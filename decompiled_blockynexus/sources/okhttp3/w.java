package okhttp3;

import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MediaType.java */
/* JADX INFO: loaded from: classes5.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f23478a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f23479b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23483f;

    private w(String str, String str2, String str3, String str4) {
        this.f23480c = str;
        this.f23481d = str2;
        this.f23482e = str3;
        this.f23483f = str4;
    }

    public static w a(String str) {
        Matcher matcher = f23478a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = f23479b.matcher(str);
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase(HybridPlusWebView.CHARSET)) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 == null) {
                    strGroup2 = matcher2.group(3);
                } else if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                    strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup2 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup2;
            }
        }
        return new w(str, lowerCase, lowerCase2, str2);
    }

    public static w b(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && ((w) obj).f23480c.equals(this.f23480c);
    }

    public int hashCode() {
        return this.f23480c.hashCode();
    }

    public String toString() {
        return this.f23480c;
    }

    public String b() {
        return this.f23481d;
    }

    public Charset a() {
        return a((Charset) null);
    }

    public Charset a(Charset charset) {
        try {
            return this.f23483f != null ? Charset.forName(this.f23483f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
