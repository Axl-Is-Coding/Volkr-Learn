package com.bytedance.sdk.openadsdk.h;

import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f6956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6957c;

    /* JADX INFO: compiled from: Request.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f6958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f6959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f6960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f6961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f6962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f6963f;
        final List<String> g;

        private a(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.f6958a = i;
            this.f6959b = str;
            this.f6960c = str2;
            this.f6961d = i2;
            this.f6962e = i3;
            this.f6963f = str3;
            this.g = list;
        }

        static a a(c cVar, List<b> list) throws d {
            String str;
            int i;
            int i2;
            int iIndexOf = cVar.f6967b.indexOf("?");
            if (iIndexOf == -1) {
                throw new d("path format error, path: " + cVar.f6967b);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : cVar.f6967b.substring(iIndexOf + 1).split("&")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if ("k".equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith("u")) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if ("f".equals(strArrSplit[0]) && com.bytedance.sdk.openadsdk.h.g.d.b(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new d("rawKey or key is empty, path: " + cVar.f6967b);
            }
            if (list != null) {
                int i4 = 0;
                int i5 = 0;
                for (b bVar : list) {
                    if (bVar != null && "Range".equalsIgnoreCase(bVar.f6964a)) {
                        int iIndexOf2 = bVar.f6965b.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new d("Range format error, Range: " + bVar.f6965b);
                        }
                        if (!"bytes".equalsIgnoreCase(bVar.f6965b.substring(0, iIndexOf2).trim())) {
                            throw new d("Range format error, Range: " + bVar.f6965b);
                        }
                        String strSubstring = bVar.f6965b.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new d("Range format error, Range: " + bVar.f6965b);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new d("Range format error, Range: " + bVar.f6965b);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i4 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i4 > (i5 = Integer.parseInt(strTrim2))) {
                                throw new d("Range format error, Range: " + bVar.f6965b);
                            }
                            str2 = bVar.f6965b;
                        } catch (NumberFormatException unused) {
                            throw new d("Range format error, Range: " + bVar.f6965b);
                        }
                    }
                }
                i2 = i4;
                i = i5;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new a(i3, strDecode, strDecode2, i2, i, str, arrayList);
            }
            throw new d("no url found: path: " + cVar.f6967b);
        }

        public String toString() {
            return "Extra{flag=" + this.f6958a + ", rawKey='" + this.f6959b + "', key='" + this.f6960c + "', from=" + this.f6961d + ", to=" + this.f6962e + ", urls=" + this.g + '}';
        }
    }

    /* JADX INFO: compiled from: Request.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6965b;

        public b(String str, String str2) {
            this.f6964a = str;
            this.f6965b = str2;
        }

        static b a(String str) throws d {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new d("request header format error, header: " + str);
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() != 0 && strTrim2.length() != 0) {
                return new b(strTrim, strTrim2);
            }
            throw new d("request header format error, header: " + str);
        }

        public String toString() {
            return "Header{name='" + this.f6964a + "', value='" + this.f6965b + "'}";
        }
    }

    /* JADX INFO: compiled from: Request.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f6966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f6967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f6968c;

        private c(String str, String str2, String str3) {
            this.f6966a = str;
            this.f6967b = str2;
            this.f6968c = str3;
        }

        static c a(String str) throws d {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new d("request line format error, line: " + str);
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new d("request line format error, line: " + str);
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() != 0 && strTrim2.length() != 0 && strTrim3.length() != 0) {
                return new c(strTrim, strTrim2, strTrim3);
            }
            throw new d("request line format error, line: " + str);
        }

        public String toString() {
            return "RequestLine{method='" + this.f6966a + "', path='" + this.f6967b + "', version='" + this.f6968c + "'}";
        }
    }

    /* JADX INFO: compiled from: Request.java */
    static final class d extends Exception {
        d(String str) {
            super(str);
        }
    }

    public i(c cVar, List<b> list, a aVar) {
        this.f6955a = cVar;
        this.f6956b = list;
        this.f6957c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bytedance.sdk.openadsdk.h.g.d.f6950a));
        ArrayList arrayList = new ArrayList();
        c cVarA = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (cVarA == null) {
                cVarA = c.a(strTrim);
            } else {
                arrayList.add(b.a(strTrim));
            }
        }
        if (cVarA != null) {
            return new i(cVarA, arrayList, a.a(cVarA, arrayList));
        }
        throw new d("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.f6955a + ", headers=" + this.f6956b + ", extra=" + this.f6957c + '}';
    }

    static String a(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strA = null;
        do {
            if (strA != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strA = a(sb, str, str2, list);
        } while (strA.length() > 3072);
        return strA;
    }

    private static String a(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk");
        sb.append("=");
        sb.append(Uri.encode(str));
        sb.append("&");
        sb.append("k");
        sb.append("=");
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&");
            sb.append("u");
            sb.append(i);
            sb.append("=");
            sb.append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }
}
