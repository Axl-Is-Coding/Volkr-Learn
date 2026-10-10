package com.bytedance.sdk.a.b.a.i;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: DistinguishedNameParser.java */
/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5195f;
    private char[] g;

    d(X500Principal x500Principal) {
        this.f5190a = x500Principal.getName("RFC2253");
        this.f5191b = this.f5190a.length();
    }

    private String a() {
        while (true) {
            int i = this.f5192c;
            if (i >= this.f5191b || this.g[i] != ' ') {
                break;
            }
            this.f5192c = i + 1;
        }
        int i2 = this.f5192c;
        if (i2 == this.f5191b) {
            return null;
        }
        this.f5193d = i2;
        this.f5192c = i2 + 1;
        while (true) {
            int i3 = this.f5192c;
            if (i3 >= this.f5191b) {
                break;
            }
            char[] cArr = this.g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f5192c = i3 + 1;
        }
        int i4 = this.f5192c;
        if (i4 >= this.f5191b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5190a);
        }
        this.f5194e = i4;
        if (this.g[i4] == ' ') {
            while (true) {
                int i5 = this.f5192c;
                if (i5 >= this.f5191b) {
                    break;
                }
                char[] cArr2 = this.g;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.f5192c = i5 + 1;
            }
            char[] cArr3 = this.g;
            int i6 = this.f5192c;
            if (cArr3[i6] != '=' || i6 == this.f5191b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5190a);
            }
        }
        this.f5192c++;
        while (true) {
            int i7 = this.f5192c;
            if (i7 >= this.f5191b || this.g[i7] != ' ') {
                break;
            }
            this.f5192c = i7 + 1;
        }
        int i8 = this.f5194e;
        int i9 = this.f5193d;
        if (i8 - i9 > 4) {
            char[] cArr4 = this.g;
            if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                char[] cArr5 = this.g;
                int i10 = this.f5193d;
                if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                    char[] cArr6 = this.g;
                    int i11 = this.f5193d;
                    if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                        this.f5193d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.g;
        int i12 = this.f5193d;
        return new String(cArr7, i12, this.f5194e - i12);
    }

    private String b() {
        this.f5192c++;
        this.f5193d = this.f5192c;
        this.f5194e = this.f5193d;
        while (true) {
            int i = this.f5192c;
            if (i == this.f5191b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5190a);
            }
            char[] cArr = this.g;
            if (cArr[i] == '\"') {
                this.f5192c = i + 1;
                while (true) {
                    int i2 = this.f5192c;
                    if (i2 >= this.f5191b || this.g[i2] != ' ') {
                        break;
                    }
                    this.f5192c = i2 + 1;
                }
                char[] cArr2 = this.g;
                int i3 = this.f5193d;
                return new String(cArr2, i3, this.f5194e - i3);
            }
            if (cArr[i] == '\\') {
                cArr[this.f5194e] = e();
            } else {
                cArr[this.f5194e] = cArr[i];
            }
            this.f5192c++;
            this.f5194e++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r6.f5194e = r6.f5192c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c() {
        /*
            r6 = this;
            int r0 = r6.f5192c
            int r1 = r0 + 4
            int r2 = r6.f5191b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La8
            r6.f5193d = r0
            int r0 = r0 + 1
            r6.f5192c = r0
        L10:
            int r0 = r6.f5192c
            int r1 = r6.f5191b
            if (r0 == r1) goto L61
            char[] r1 = r6.g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L61
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.f5194e = r0
            int r0 = r0 + 1
            r6.f5192c = r0
        L37:
            int r0 = r6.f5192c
            int r1 = r6.f5191b
            if (r0 >= r1) goto L65
            char[] r1 = r6.g
            char r1 = r1[r0]
            if (r1 != r4) goto L65
            int r0 = r0 + 1
            r6.f5192c = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r6.f5192c
            int r0 = r0 + 1
            r6.f5192c = r0
            goto L10
        L61:
            int r0 = r6.f5192c
            r6.f5194e = r0
        L65:
            int r0 = r6.f5194e
            int r1 = r6.f5193d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L91
            r2 = r0 & 1
            if (r2 == 0) goto L91
            int r2 = r0 / 2
            byte[] r2 = new byte[r2]
            r3 = 0
            int r1 = r1 + 1
        L78:
            int r4 = r2.length
            if (r3 >= r4) goto L87
            int r4 = r6.a(r1)
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 2
            int r3 = r3 + 1
            goto L78
        L87:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.g
            int r3 = r6.f5193d
            r1.<init>(r2, r3, r0)
            return r1
        L91:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f5190a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f5190a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto Lc0
        Lbf:
            throw r0
        Lc0:
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.i.d.c():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.g;
        r2 = r8.f5193d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.f5194e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r8 = this;
            int r0 = r8.f5192c
            r8.f5193d = r0
            r8.f5194e = r0
        L6:
            int r0 = r8.f5192c
            int r1 = r8.f5191b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.f5193d
            int r3 = r8.f5194e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f5194e
            int r3 = r2 + 1
            r8.f5194e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f5192c = r0
            goto L6
        L40:
            int r0 = r8.f5194e
            int r2 = r0 + 1
            r8.f5194e = r2
            char r2 = r8.e()
            r1[r0] = r2
            int r0 = r8.f5192c
            int r0 = r0 + 1
            r8.f5192c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.f5193d
            int r3 = r8.f5194e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f5194e
            r8.f5195f = r2
            int r0 = r0 + 1
            r8.f5192c = r0
            int r0 = r2 + 1
            r8.f5194e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f5192c
            int r1 = r8.f5191b
            if (r0 >= r1) goto L87
            char[] r1 = r8.g
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f5194e
            int r7 = r2 + 1
            r8.f5194e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f5192c = r0
            goto L6e
        L87:
            int r0 = r8.f5192c
            int r1 = r8.f5191b
            if (r0 == r1) goto L9b
            char[] r1 = r8.g
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.f5193d
            int r3 = r8.f5195f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.i.d.d():java.lang.String");
    }

    private char e() {
        this.f5192c++;
        int i = this.f5192c;
        if (i == this.f5191b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5190a);
        }
        char c2 = this.g[i];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return f();
                    }
                    break;
            }
        }
        return this.g[this.f5192c];
    }

    private char f() {
        int i;
        int i2;
        int iA = a(this.f5192c);
        this.f5192c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i2 = iA & 31;
            i = 1;
        } else if (iA <= 239) {
            i = 2;
            i2 = iA & 15;
        } else {
            i = 3;
            i2 = iA & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f5192c++;
            int i4 = this.f5192c;
            if (i4 == this.f5191b || this.g[i4] != '\\') {
                return '?';
            }
            this.f5192c = i4 + 1;
            int iA2 = a(this.f5192c);
            this.f5192c++;
            if ((iA2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (iA2 & 63);
        }
        return (char) i2;
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f5191b) {
            char c2 = this.g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f5190a);
                }
                i2 = c2 - '7';
            }
            char c3 = this.g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f5190a);
                }
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f5190a);
    }

    public String a(String str) {
        String strB;
        this.f5192c = 0;
        this.f5193d = 0;
        this.f5194e = 0;
        this.f5195f = 0;
        this.g = this.f5190a.toCharArray();
        String strA = a();
        if (strA == null) {
            return null;
        }
        do {
            int i = this.f5192c;
            if (i == this.f5191b) {
                return null;
            }
            char c2 = this.g[i];
            if (c2 == '\"') {
                strB = b();
            } else if (c2 != '#') {
                strB = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d();
            } else {
                strB = c();
            }
            if (str.equalsIgnoreCase(strA)) {
                return strB;
            }
            int i2 = this.f5192c;
            if (i2 >= this.f5191b) {
                return null;
            }
            char[] cArr = this.g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f5190a);
            }
            this.f5192c++;
            strA = a();
        } while (strA != null);
        throw new IllegalStateException("Malformed DN: " + this.f5190a);
    }
}
