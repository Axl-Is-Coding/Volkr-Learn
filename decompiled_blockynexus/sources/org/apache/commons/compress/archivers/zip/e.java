package org.apache.commons.compress.archivers.zip;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;

/* JADX INFO: compiled from: ZipEncodingHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f23536a = a("UTF8");

    public static d a(String str) {
        Charset charsetDefaultCharset = Charset.defaultCharset();
        if (str != null) {
            try {
                charsetDefaultCharset = Charset.forName(str);
            } catch (UnsupportedCharsetException unused) {
            }
        }
        return new b(charsetDefaultCharset, b(charsetDefaultCharset.name()));
    }

    static boolean b(String str) {
        if (str == null) {
            str = Charset.defaultCharset().name();
        }
        if (org.apache.commons.compress.a.c.f23512f.name().equalsIgnoreCase(str)) {
            return true;
        }
        Iterator<String> it = org.apache.commons.compress.a.c.f23512f.aliases().iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
