package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: compiled from: CharMatcher.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements com.google.common.base.n<Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13733a = n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f13734b = c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f13735c = b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f13736d = d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f13737e = f();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f13738f = h();
    public static final c g = i();
    public static final c h = k();
    public static final c i = j();
    public static final c j = g();
    public static final c k = e();
    public static final c l = m();
    public static final c m = a();
    public static final c n = l();

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class a extends n {
        static final a p = new a();

        private a() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.c
        public int a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            com.google.common.base.m.b(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return true;
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class b extends n {
        static final b p = new b();

        b() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return c2 <= 127;
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class C0130c extends c {
        static final c o = new C0130c();

        private C0130c() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            if (c2 != ' ' && c2 != 133 && c2 != 5760) {
                if (c2 == 8199) {
                    return false;
                }
                if (c2 != 8287 && c2 != 12288 && c2 != 8232 && c2 != 8233) {
                    switch (c2) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c2 >= 8192 && c2 <= 8202;
                    }
                }
            }
            return true;
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class d extends p {
        static final d r = new d();

        private d() {
            super("CharMatcher.digit()", p(), o());
        }

        private static char[] o() {
            char[] cArr = new char[31];
            for (int i = 0; i < 31; i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + '\t');
            }
            return cArr;
        }

        private static char[] p() {
            return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    static abstract class e extends c {
        e() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class f extends p {
        static final f r = new f();

        private f() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class g extends e {
        private final char o;

        g(char c2) {
            this.o = c2;
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return c2 == this.o;
        }

        public String toString() {
            return "CharMatcher.is('" + c.d(this.o) + "')";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class h extends c {
        static final h o = new h();

        private h() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return Character.isDigit(c2);
        }

        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class i extends n {
        static final i p = new i();

        private i() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return c2 <= 31 || (c2 >= 127 && c2 <= 159);
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class j extends c {
        static final j o = new j();

        private j() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return Character.isLetter(c2);
        }

        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class k extends c {
        static final k o = new k();

        private k() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return Character.isLetterOrDigit(c2);
        }

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class l extends c {
        static final l o = new l();

        private l() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return Character.isLowerCase(c2);
        }

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class m extends c {
        static final m o = new m();

        private m() {
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return Character.isUpperCase(c2);
        }

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    static abstract class n extends e {
        private final String o;

        n(String str) {
            com.google.common.base.m.a(str);
            this.o = str;
        }

        public final String toString() {
            return this.o;
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static class p extends c {
        private final String o;
        private final char[] p;
        private final char[] q;

        p(String str, char[] cArr, char[] cArr2) {
            this.o = str;
            this.p = cArr;
            this.q = cArr2;
            com.google.common.base.m.a(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                com.google.common.base.m.a(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    com.google.common.base.m.a(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        @Override // com.google.common.base.c, com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            int iBinarySearch = Arrays.binarySearch(this.p, c2);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i = (iBinarySearch ^ (-1)) - 1;
            return i >= 0 && c2 <= this.q[i];
        }

        public String toString() {
            return this.o;
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class q extends p {
        static final q r = new q();

        private q() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    /* JADX INFO: compiled from: CharMatcher.java */
    static final class r extends n {
        static final int p = Integer.numberOfLeadingZeros(31);
        static final r q = new r();

        r() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c2) >>> p) == c2;
        }
    }

    protected c() {
    }

    public static c b() {
        return b.p;
    }

    public static c c() {
        return C0130c.o;
    }

    public static c d() {
        return d.r;
    }

    public static c e() {
        return f.r;
    }

    public static c f() {
        return h.o;
    }

    public static c g() {
        return i.p;
    }

    public static c h() {
        return j.o;
    }

    public static c i() {
        return k.o;
    }

    public static c j() {
        return l.o;
    }

    public static c k() {
        return m.o;
    }

    public static c l() {
        return o.p;
    }

    public static c m() {
        return q.r;
    }

    public static c n() {
        return r.q;
    }

    public abstract boolean c(char c2);

    /* JADX INFO: compiled from: CharMatcher.java */
    private static final class o extends n {
        static final o p = new o();

        private o() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.c
        public int a(CharSequence charSequence, int i) {
            com.google.common.base.m.b(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return false;
        }

        @Override // com.google.common.base.c
        public String a(CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    public static c a() {
        return a.p;
    }

    public static c b(char c2) {
        return new g(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        com.google.common.base.m.b(i2, length);
        while (i2 < length) {
            if (c(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String a(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!c(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    @Override // com.google.common.base.n
    @Deprecated
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(Character ch) {
        return c(ch.charValue());
    }
}
