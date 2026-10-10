package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: StatusLine.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f4993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4995c;

    public k(w wVar, int i, String str) {
        this.f4993a = wVar;
        this.f4994b = i;
        this.f4995c = str;
    }

    public static k a(aa aaVar) {
        return new k(aaVar.b(), aaVar.c(), aaVar.d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4993a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f4994b);
        if (this.f4995c != null) {
            sb.append(' ');
            sb.append(this.f4995c);
        }
        return sb.toString();
    }

    public static k a(String str) throws IOException {
        w wVar;
        String strSubstring;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                wVar = w.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                wVar = w.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            wVar = w.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new k(wVar, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }
}
