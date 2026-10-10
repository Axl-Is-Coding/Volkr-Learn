package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f14515a = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a[] f14516b = d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f14518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b[] f14519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14520f;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.decoder.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Version.java */
    public static final class C0140a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14522b;

        C0140a(int i, int i2) {
            this.f14521a = i;
            this.f14522b = i2;
        }

        public int a() {
            return this.f14521a;
        }

        public int b() {
            return this.f14522b;
        }
    }

    /* JADX INFO: compiled from: Version.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0140a[] f14524b;

        b(int i, C0140a... c0140aArr) {
            this.f14523a = i;
            this.f14524b = c0140aArr;
        }

        public C0140a[] a() {
            return this.f14524b;
        }

        public int b() {
            return this.f14523a;
        }

        public int c() {
            int iA = 0;
            for (C0140a c0140a : this.f14524b) {
                iA += c0140a.a();
            }
            return iA;
        }

        public int d() {
            return this.f14523a * c();
        }
    }

    private a(int i, int[] iArr, b... bVarArr) {
        this.f14517c = i;
        this.f14518d = iArr;
        this.f14519e = bVarArr;
        int iB = bVarArr[0].b();
        int iA = 0;
        for (C0140a c0140a : bVarArr[0].a()) {
            iA += c0140a.a() * (c0140a.b() + iB);
        }
        this.f14520f = iA;
    }

    private static a[] d() {
        return new a[]{new a(1, new int[0], new b(7, new C0140a(1, 19)), new b(10, new C0140a(1, 16)), new b(13, new C0140a(1, 13)), new b(17, new C0140a(1, 9))), new a(2, new int[]{6, 18}, new b(10, new C0140a(1, 34)), new b(16, new C0140a(1, 28)), new b(22, new C0140a(1, 22)), new b(28, new C0140a(1, 16))), new a(3, new int[]{6, 22}, new b(15, new C0140a(1, 55)), new b(26, new C0140a(1, 44)), new b(18, new C0140a(2, 17)), new b(22, new C0140a(2, 13))), new a(4, new int[]{6, 26}, new b(20, new C0140a(1, 80)), new b(18, new C0140a(2, 32)), new b(26, new C0140a(2, 24)), new b(16, new C0140a(4, 9))), new a(5, new int[]{6, 30}, new b(26, new C0140a(1, 108)), new b(24, new C0140a(2, 43)), new b(18, new C0140a(2, 15), new C0140a(2, 16)), new b(22, new C0140a(2, 11), new C0140a(2, 12))), new a(6, new int[]{6, 34}, new b(18, new C0140a(2, 68)), new b(16, new C0140a(4, 27)), new b(24, new C0140a(4, 19)), new b(28, new C0140a(4, 15))), new a(7, new int[]{6, 22, 38}, new b(20, new C0140a(2, 78)), new b(18, new C0140a(4, 31)), new b(18, new C0140a(2, 14), new C0140a(4, 15)), new b(26, new C0140a(4, 13), new C0140a(1, 14))), new a(8, new int[]{6, 24, 42}, new b(24, new C0140a(2, 97)), new b(22, new C0140a(2, 38), new C0140a(2, 39)), new b(22, new C0140a(4, 18), new C0140a(2, 19)), new b(26, new C0140a(4, 14), new C0140a(2, 15))), new a(9, new int[]{6, 26, 46}, new b(30, new C0140a(2, 116)), new b(22, new C0140a(3, 36), new C0140a(2, 37)), new b(20, new C0140a(4, 16), new C0140a(4, 17)), new b(24, new C0140a(4, 12), new C0140a(4, 13))), new a(10, new int[]{6, 28, 50}, new b(18, new C0140a(2, 68), new C0140a(2, 69)), new b(26, new C0140a(4, 43), new C0140a(1, 44)), new b(24, new C0140a(6, 19), new C0140a(2, 20)), new b(28, new C0140a(6, 15), new C0140a(2, 16))), new a(11, new int[]{6, 30, 54}, new b(20, new C0140a(4, 81)), new b(30, new C0140a(1, 50), new C0140a(4, 51)), new b(28, new C0140a(4, 22), new C0140a(4, 23)), new b(24, new C0140a(3, 12), new C0140a(8, 13))), new a(12, new int[]{6, 32, 58}, new b(24, new C0140a(2, 92), new C0140a(2, 93)), new b(22, new C0140a(6, 36), new C0140a(2, 37)), new b(26, new C0140a(4, 20), new C0140a(6, 21)), new b(28, new C0140a(7, 14), new C0140a(4, 15))), new a(13, new int[]{6, 34, 62}, new b(26, new C0140a(4, 107)), new b(22, new C0140a(8, 37), new C0140a(1, 38)), new b(24, new C0140a(8, 20), new C0140a(4, 21)), new b(22, new C0140a(12, 11), new C0140a(4, 12))), new a(14, new int[]{6, 26, 46, 66}, new b(30, new C0140a(3, 115), new C0140a(1, 116)), new b(24, new C0140a(4, 40), new C0140a(5, 41)), new b(20, new C0140a(11, 16), new C0140a(5, 17)), new b(24, new C0140a(11, 12), new C0140a(5, 13))), new a(15, new int[]{6, 26, 48, 70}, new b(22, new C0140a(5, 87), new C0140a(1, 88)), new b(24, new C0140a(5, 41), new C0140a(5, 42)), new b(30, new C0140a(5, 24), new C0140a(7, 25)), new b(24, new C0140a(11, 12), new C0140a(7, 13))), new a(16, new int[]{6, 26, 50, 74}, new b(24, new C0140a(5, 98), new C0140a(1, 99)), new b(28, new C0140a(7, 45), new C0140a(3, 46)), new b(24, new C0140a(15, 19), new C0140a(2, 20)), new b(30, new C0140a(3, 15), new C0140a(13, 16))), new a(17, new int[]{6, 30, 54, 78}, new b(28, new C0140a(1, 107), new C0140a(5, 108)), new b(28, new C0140a(10, 46), new C0140a(1, 47)), new b(28, new C0140a(1, 22), new C0140a(15, 23)), new b(28, new C0140a(2, 14), new C0140a(17, 15))), new a(18, new int[]{6, 30, 56, 82}, new b(30, new C0140a(5, 120), new C0140a(1, 121)), new b(26, new C0140a(9, 43), new C0140a(4, 44)), new b(28, new C0140a(17, 22), new C0140a(1, 23)), new b(28, new C0140a(2, 14), new C0140a(19, 15))), new a(19, new int[]{6, 30, 58, 86}, new b(28, new C0140a(3, 113), new C0140a(4, 114)), new b(26, new C0140a(3, 44), new C0140a(11, 45)), new b(26, new C0140a(17, 21), new C0140a(4, 22)), new b(26, new C0140a(9, 13), new C0140a(16, 14))), new a(20, new int[]{6, 34, 62, 90}, new b(28, new C0140a(3, 107), new C0140a(5, 108)), new b(26, new C0140a(3, 41), new C0140a(13, 42)), new b(30, new C0140a(15, 24), new C0140a(5, 25)), new b(28, new C0140a(15, 15), new C0140a(10, 16))), new a(21, new int[]{6, 28, 50, 72, 94}, new b(28, new C0140a(4, 116), new C0140a(4, 117)), new b(26, new C0140a(17, 42)), new b(28, new C0140a(17, 22), new C0140a(6, 23)), new b(30, new C0140a(19, 16), new C0140a(6, 17))), new a(22, new int[]{6, 26, 50, 74, 98}, new b(28, new C0140a(2, 111), new C0140a(7, 112)), new b(28, new C0140a(17, 46)), new b(30, new C0140a(7, 24), new C0140a(16, 25)), new b(24, new C0140a(34, 13))), new a(23, new int[]{6, 30, 54, 78, 102}, new b(30, new C0140a(4, 121), new C0140a(5, 122)), new b(28, new C0140a(4, 47), new C0140a(14, 48)), new b(30, new C0140a(11, 24), new C0140a(14, 25)), new b(30, new C0140a(16, 15), new C0140a(14, 16))), new a(24, new int[]{6, 28, 54, 80, 106}, new b(30, new C0140a(6, 117), new C0140a(4, 118)), new b(28, new C0140a(6, 45), new C0140a(14, 46)), new b(30, new C0140a(11, 24), new C0140a(16, 25)), new b(30, new C0140a(30, 16), new C0140a(2, 17))), new a(25, new int[]{6, 32, 58, 84, 110}, new b(26, new C0140a(8, 106), new C0140a(4, 107)), new b(28, new C0140a(8, 47), new C0140a(13, 48)), new b(30, new C0140a(7, 24), new C0140a(22, 25)), new b(30, new C0140a(22, 15), new C0140a(13, 16))), new a(26, new int[]{6, 30, 58, 86, 114}, new b(28, new C0140a(10, 114), new C0140a(2, 115)), new b(28, new C0140a(19, 46), new C0140a(4, 47)), new b(28, new C0140a(28, 22), new C0140a(6, 23)), new b(30, new C0140a(33, 16), new C0140a(4, 17))), new a(27, new int[]{6, 34, 62, 90, 118}, new b(30, new C0140a(8, 122), new C0140a(4, 123)), new b(28, new C0140a(22, 45), new C0140a(3, 46)), new b(30, new C0140a(8, 23), new C0140a(26, 24)), new b(30, new C0140a(12, 15), new C0140a(28, 16))), new a(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new C0140a(3, 117), new C0140a(10, 118)), new b(28, new C0140a(3, 45), new C0140a(23, 46)), new b(30, new C0140a(4, 24), new C0140a(31, 25)), new b(30, new C0140a(11, 15), new C0140a(31, 16))), new a(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new C0140a(7, 116), new C0140a(7, 117)), new b(28, new C0140a(21, 45), new C0140a(7, 46)), new b(30, new C0140a(1, 23), new C0140a(37, 24)), new b(30, new C0140a(19, 15), new C0140a(26, 16))), new a(30, new int[]{6, 26, 52, 78, 104, 130}, new b(30, new C0140a(5, 115), new C0140a(10, 116)), new b(28, new C0140a(19, 47), new C0140a(10, 48)), new b(30, new C0140a(15, 24), new C0140a(25, 25)), new b(30, new C0140a(23, 15), new C0140a(25, 16))), new a(31, new int[]{6, 30, 56, 82, 108, 134}, new b(30, new C0140a(13, 115), new C0140a(3, 116)), new b(28, new C0140a(2, 46), new C0140a(29, 47)), new b(30, new C0140a(42, 24), new C0140a(1, 25)), new b(30, new C0140a(23, 15), new C0140a(28, 16))), new a(32, new int[]{6, 34, 60, 86, 112, 138}, new b(30, new C0140a(17, 115)), new b(28, new C0140a(10, 46), new C0140a(23, 47)), new b(30, new C0140a(10, 24), new C0140a(35, 25)), new b(30, new C0140a(19, 15), new C0140a(35, 16))), new a(33, new int[]{6, 30, 58, 86, 114, 142}, new b(30, new C0140a(17, 115), new C0140a(1, 116)), new b(28, new C0140a(14, 46), new C0140a(21, 47)), new b(30, new C0140a(29, 24), new C0140a(19, 25)), new b(30, new C0140a(11, 15), new C0140a(46, 16))), new a(34, new int[]{6, 34, 62, 90, 118, 146}, new b(30, new C0140a(13, 115), new C0140a(6, 116)), new b(28, new C0140a(14, 46), new C0140a(23, 47)), new b(30, new C0140a(44, 24), new C0140a(7, 25)), new b(30, new C0140a(59, 16), new C0140a(1, 17))), new a(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new C0140a(12, 121), new C0140a(7, 122)), new b(28, new C0140a(12, 47), new C0140a(26, 48)), new b(30, new C0140a(39, 24), new C0140a(14, 25)), new b(30, new C0140a(22, 15), new C0140a(41, 16))), new a(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new b(30, new C0140a(6, 121), new C0140a(14, 122)), new b(28, new C0140a(6, 47), new C0140a(34, 48)), new b(30, new C0140a(46, 24), new C0140a(10, 25)), new b(30, new C0140a(2, 15), new C0140a(64, 16))), new a(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new b(30, new C0140a(17, 122), new C0140a(4, 123)), new b(28, new C0140a(29, 46), new C0140a(14, 47)), new b(30, new C0140a(49, 24), new C0140a(10, 25)), new b(30, new C0140a(24, 15), new C0140a(46, 16))), new a(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new b(30, new C0140a(4, 122), new C0140a(18, 123)), new b(28, new C0140a(13, 46), new C0140a(32, 47)), new b(30, new C0140a(48, 24), new C0140a(14, 25)), new b(30, new C0140a(42, 15), new C0140a(32, 16))), new a(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new b(30, new C0140a(20, 117), new C0140a(4, 118)), new b(28, new C0140a(40, 47), new C0140a(7, 48)), new b(30, new C0140a(43, 24), new C0140a(22, 25)), new b(30, new C0140a(10, 15), new C0140a(67, 16))), new a(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new b(30, new C0140a(19, 118), new C0140a(6, 119)), new b(28, new C0140a(18, 47), new C0140a(31, 48)), new b(30, new C0140a(34, 24), new C0140a(34, 25)), new b(30, new C0140a(20, 15), new C0140a(61, 16)))};
    }

    public int a() {
        return (this.f14517c * 4) + 17;
    }

    public int b() {
        return this.f14520f;
    }

    public int c() {
        return this.f14517c;
    }

    public String toString() {
        return String.valueOf(this.f14517c);
    }

    public b a(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.f14519e[errorCorrectionLevel.ordinal()];
    }

    public static a a(int i) {
        if (i > 0 && i <= 40) {
            return f14516b[i - 1];
        }
        throw new IllegalArgumentException();
    }
}
