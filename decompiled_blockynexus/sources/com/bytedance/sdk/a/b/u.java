package com.bytedance.sdk.a.b;

import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MediaType.java */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f5307a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f5308b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5312f;

    private u(String str, String str2, String str3, String str4) {
        this.f5309c = str;
        this.f5310d = str2;
        this.f5311e = str3;
        this.f5312f = str4;
    }

    public static u a(String str) {
        Matcher matcher = f5307a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f5308b.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
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
                    return null;
                }
                str2 = strGroup2;
            }
        }
        return new u(str, lowerCase, lowerCase2, str2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).f5309c.equals(this.f5309c);
    }

    public int hashCode() {
        return this.f5309c.hashCode();
    }

    public String toString() {
        return this.f5309c;
    }
}
