package com.bytedance.sdk.a.b;

import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Cookie.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f5267a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f5268b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f5269c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f5270d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5272f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5271e = str;
        this.f5272f = str2;
        this.g = j;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    public String a() {
        return this.f5271e;
    }

    public String b() {
        return this.f5272f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f5271e.equals(this.f5271e) && lVar.f5272f.equals(this.f5272f) && lVar.h.equals(this.h) && lVar.i.equals(this.i) && lVar.g == this.g && lVar.j == this.j && lVar.k == this.k && lVar.l == this.l && lVar.m == this.m;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f5271e.hashCode()) * 31) + this.f5272f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        long j = this.g;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.j ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.a.b.a.c.c(str);
    }

    private static String b(String str) {
        if (str.endsWith(Consts.DOT)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(Consts.DOT)) {
            str = str.substring(1);
        }
        String strA = com.bytedance.sdk.a.b.a.c.a(str);
        if (strA != null) {
            return strA;
        }
        throw new IllegalArgumentException();
    }

    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7 A[PHI: r0
      0x00c7: PHI (r0v15 long) = (r0v2 long), (r0v5 long) binds: [B:42:0x00c5, B:53:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.bytedance.sdk.a.b.l a(long r24, com.bytedance.sdk.a.b.s r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.l.a(long, com.bytedance.sdk.a.b.s, java.lang.String):com.bytedance.sdk.a.b.l");
    }

    private static long a(String str, int i, int i2) {
        int iA = a(str, i, i2, false);
        Matcher matcher = f5270d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iA < i2) {
            int iA2 = a(str, iA + 1, i2, true);
            matcher.region(iA, iA2);
            if (i4 == -1 && matcher.usePattern(f5270d).matches()) {
                int i8 = Integer.parseInt(matcher.group(1));
                int i9 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
                i6 = i9;
                i4 = i8;
            } else if (i5 == -1 && matcher.usePattern(f5269c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1 && matcher.usePattern(f5268b).matches()) {
                iIndexOf = f5268b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f5267a).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            iA = a(str, iA2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 >= 0 && i7 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.a.b.a.c.g);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iIndexOf - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long a(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> listB = rVar.b("Set-Cookie");
        int size = listB.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            l lVarA = a(sVar, listB.get(i));
            if (lVarA != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lVarA);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5271e);
        sb.append('=');
        sb.append(this.f5272f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.a.b.a.c.d.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(Consts.DOT);
            }
            sb.append(this.h);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
