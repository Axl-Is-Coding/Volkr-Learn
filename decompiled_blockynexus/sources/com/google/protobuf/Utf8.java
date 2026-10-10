package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
final class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f14335a;

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    static abstract class a {
        a() {
        }

        abstract int a(int i, byte[] bArr, int i2, int i3);

        abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        final boolean a(byte[] bArr, int i, int i2) {
            return a(0, bArr, i, i2) == 0;
        }
    }

    static final class c extends a {
        c() {
        }

        static boolean a() {
            return M.b() && M.c();
        }

        private static int b(byte[] bArr, long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = ((int) j) & 7;
            long j2 = j;
            int i3 = i2;
            while (i3 > 0) {
                long j3 = 1 + j2;
                if (M.a(bArr, j2) < 0) {
                    return i2 - i3;
                }
                i3--;
                j2 = j3;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (M.b(bArr, j2) & (-9187201950435737472L)) == 0) {
                j2 += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        
            if (com.google.protobuf.M.a(r13, r2) > (-65)) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
        
            if (com.google.protobuf.M.a(r13, r2) > (-65)) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a2, code lost:
        
            if (com.google.protobuf.M.a(r13, r2) > (-65)) goto L55;
         */
        @Override // com.google.protobuf.Utf8.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int a(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instruction units count: 209
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.c.a(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.a
        int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            char c2;
            long j;
            long jA;
            long j2;
            long j3;
            int i3;
            char cCharAt;
            long jA2 = M.a() + ((long) i);
            long j4 = ((long) i2) + jA2;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                c2 = 128;
                j = 1;
                if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                M.a(bArr, jA2, (byte) cCharAt);
                i4++;
                jA2 = 1 + jA2;
            }
            if (i4 == length) {
                jA = M.a();
            } else {
                while (i4 < length) {
                    char cCharAt2 = charSequence.charAt(i4);
                    if (cCharAt2 >= c2 || jA2 >= j4) {
                        if (cCharAt2 < 2048 && jA2 <= j4 - 2) {
                            long j5 = jA2 + j;
                            M.a(bArr, jA2, (byte) ((cCharAt2 >>> 6) | 960));
                            M.a(bArr, j5, (byte) ((cCharAt2 & '?') | 128));
                            j2 = j5 + j;
                            j3 = j;
                        } else {
                            if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jA2 > j4 - 3) {
                                if (jA2 <= j4 - 4) {
                                    int i5 = i4 + 1;
                                    if (i5 != length) {
                                        char cCharAt3 = charSequence.charAt(i5);
                                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                            long j6 = jA2 + 1;
                                            M.a(bArr, jA2, (byte) ((codePoint >>> 18) | 240));
                                            long j7 = j6 + 1;
                                            M.a(bArr, j6, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j8 = j7 + 1;
                                            M.a(bArr, j7, (byte) (((codePoint >>> 6) & 63) | 128));
                                            j3 = 1;
                                            j2 = j8 + 1;
                                            M.a(bArr, j8, (byte) ((codePoint & 63) | 128));
                                            i4 = i5;
                                        } else {
                                            i4 = i5;
                                        }
                                    }
                                    throw new UnpairedSurrogateException(i4 - 1, length);
                                }
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                                    throw new UnpairedSurrogateException(i4, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jA2);
                            }
                            long j9 = jA2 + j;
                            M.a(bArr, jA2, (byte) ((cCharAt2 >>> '\f') | 480));
                            long j10 = j9 + j;
                            M.a(bArr, j9, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                            M.a(bArr, j10, (byte) ((cCharAt2 & '?') | 128));
                            j2 = j10 + 1;
                            j3 = 1;
                        }
                        i4++;
                        c2 = 128;
                        long j11 = j3;
                        jA2 = j2;
                        j = j11;
                    } else {
                        long j12 = jA2 + j;
                        M.a(bArr, jA2, (byte) cCharAt2);
                        j3 = j;
                        j2 = j12;
                    }
                    i4++;
                    c2 = 128;
                    long j112 = j3;
                    jA2 = j2;
                    j = j112;
                }
                jA = M.a();
            }
            return (int) (jA2 - jA);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int a(byte[] r8, long r9, int r11) {
            /*
                int r0 = b(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.M.a(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.M.a(r8, r9)
                if (r9 <= r4) goto L37
                goto L39
            L37:
                r9 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r11 >= r6) goto L46
                int r8 = a(r8, r1, r9, r11)
                return r8
            L46:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.M.a(r8, r9)
                if (r9 > r4) goto L63
                r10 = -96
                if (r1 != r0) goto L56
                if (r9 < r10) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r9 >= r10) goto L63
            L5c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.M.a(r8, r6)
                if (r9 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r11 >= r0) goto L6c
                int r8 = a(r8, r1, r9, r11)
                return r8
            L6c:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.M.a(r8, r9)
                if (r9 > r4) goto L8e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.M.a(r8, r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.M.a(r8, r9)
                if (r9 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.c.a(byte[], long, int):int");
        }

        private static int a(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return Utf8.b(i);
            }
            if (i2 == 1) {
                return Utf8.b(i, M.a(bArr, j));
            }
            if (i2 == 2) {
                return Utf8.b(i, M.a(bArr, j), M.a(bArr, j + 1));
            }
            throw new AssertionError();
        }
    }

    static {
        f14335a = c.a() ? new c() : new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean b(byte[] bArr, int i, int i2) {
        return f14335a.a(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return b(b2);
        }
        if (i3 == 1) {
            return b(b2, bArr[i]);
        }
        if (i3 == 2) {
            return b(b2, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        return f14335a.a(i, bArr, i2, i3);
    }

    static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iA = length;
        while (true) {
            if (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 2048) {
                    iA += a(charSequence, i);
                    break;
                }
                iA += (127 - cCharAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (iA >= length) {
            return iA;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iA) + 4294967296L));
    }

    static final class b extends a {
        b() {
        }

        private static int b(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return c(bArr, i, i2);
        }

        private static int c(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i3 >= i2) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b2 >= -16) {
                        if (i3 >= i2 - 2) {
                            return Utf8.c(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                            int i5 = i4 + 1;
                            if (bArr[i4] <= -65) {
                                i3 = i5 + 1;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i3 >= i2 - 1) {
                        return Utf8.c(bArr, i3, i2);
                    }
                    int i6 = i3 + 1;
                    byte b4 = bArr[i3];
                    if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                        i = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                i = i3;
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
        
            if (r8[r9] > (-65)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x007a, code lost:
        
            if (r8[r7] > (-65)) goto L50;
         */
        @Override // com.google.protobuf.Utf8.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int a(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L7d
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L18
                r7 = -62
                if (r0 < r7) goto L17
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L7e
            L17:
                return r2
            L18:
                r4 = -16
                if (r0 >= r4) goto L45
                int r7 = r7 >> 8
                r7 = r7 ^ r2
                byte r7 = (byte) r7
                if (r7 != 0) goto L30
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L2d
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L2d:
                r5 = r9
                r9 = r7
                r7 = r5
            L30:
                if (r7 > r3) goto L44
                r4 = -96
                if (r0 != r1) goto L38
                if (r7 < r4) goto L44
            L38:
                r1 = -19
                if (r0 != r1) goto L3e
                if (r7 >= r4) goto L44
            L3e:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L7e
            L44:
                return r2
            L45:
                int r1 = r7 >> 8
                r1 = r1 ^ r2
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L57
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5b
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L57:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
                r7 = r9
            L5b:
                if (r4 != 0) goto L69
                int r9 = r7 + 1
                r4 = r8[r7]
                if (r9 < r10) goto L68
                int r7 = com.google.protobuf.Utf8.a(r0, r1, r4)
                return r7
            L68:
                r7 = r9
            L69:
                if (r1 > r3) goto L7c
                int r9 = r0 << 28
                int r1 = r1 + 112
                int r9 = r9 + r1
                int r9 = r9 >> 30
                if (r9 != 0) goto L7c
                if (r4 > r3) goto L7c
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L7d
            L7c:
                return r2
            L7d:
                r7 = r9
            L7e:
                int r7 = b(r8, r7, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.b.a(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.a
        int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char cCharAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) cCharAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char cCharAt2 = charSequence.charAt(i7);
                if (cCharAt2 >= 128 || i8 >= i6) {
                    if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                        int i9 = i8 + 1;
                        bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                        i8 = i9 + 1;
                        bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                            if (i8 <= i6 - 4) {
                                int i10 = i7 + 1;
                                if (i10 != charSequence.length()) {
                                    char cCharAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                        int i11 = i8 + 1;
                                        bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        bArr[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        bArr[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i8 = i13 + 1;
                                        bArr[i13] = (byte) ((codePoint & 63) | 128);
                                        i7 = i10;
                                    } else {
                                        i7 = i10;
                                    }
                                }
                                throw new UnpairedSurrogateException(i7 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                        }
                        int i14 = i8 + 1;
                        bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i3 = i15 + 1;
                        bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i7++;
                } else {
                    i3 = i8 + 1;
                    bArr[i8] = (byte) cCharAt2;
                }
                i8 = i3;
                i7++;
            }
            return i8;
        }
    }

    private static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f14335a.a(charSequence, bArr, i, i2);
    }
}
