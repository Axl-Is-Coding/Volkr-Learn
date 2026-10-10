package com.ta.utdid2.b.a;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f19340a = !b.class.desiredAssertionStatus();

    /* JADX INFO: compiled from: Base64.java */
    static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f19342b;

        a() {
        }
    }

    /* JADX INFO: renamed from: com.ta.utdid2.b.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Base64.java */
    static class C0168b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f19343a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int[] f19344b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f19345c;
        private int state;
        private int value;

        public C0168b(int i, byte[] bArr) {
            this.f19342b = bArr;
            this.f19345c = (i & 8) == 0 ? f19343a : f19344b;
            this.state = 0;
            this.value = 0;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.state;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.value;
            byte[] bArr2 = this.f19342b;
            int[] iArr = this.f19345c;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4) {
                            break;
                        }
                        i6 = iArr[bArr[i9 + 3] & 255] | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 2] & 255] << 6);
                        if (i6 < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5 && i12 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i12 == -2) {
                                i8++;
                            } else if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            i6 = (i6 << 6) | i12;
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i11;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i9 = i11;
                            i8 = 5;
                        } else if (i12 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i12 == -2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                        i9 = i11;
                        i8 = 4;
                    } else if (i12 != -1) {
                        this.state = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i8++;
                    i6 = i12;
                } else if (i12 != -1) {
                    this.state = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.state = i8;
                this.value = i6;
                this.f19341a = i7;
                return true;
            }
            if (i8 != 0) {
                if (i8 == 1) {
                    this.state = 6;
                    return false;
                }
                if (i8 == 2) {
                    bArr2[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i13 = i7 + 1;
                    bArr2[i7] = (byte) (i6 >> 10);
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    this.state = 6;
                    return false;
                }
            }
            this.state = i8;
            this.f19341a = i7;
            return true;
        }
    }

    /* JADX INFO: compiled from: Base64.java */
    static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f19346a = !b.class.desiredAssertionStatus();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final byte[] f19347c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final byte[] f19348d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19349b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f100b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final boolean f101c;
        private int count;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public final boolean f102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f19350e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final byte[] f19351f;

        public c(int i, byte[] bArr) {
            ((a) this).f19342b = bArr;
            this.f100b = (i & 1) == 0;
            this.f101c = (i & 2) == 0;
            this.f102d = (i & 4) != 0;
            this.f19351f = (i & 8) == 0 ? f19347c : f19348d;
            this.f19350e = new byte[2];
            this.f19349b = 0;
            this.count = this.f101c ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 534
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private b() {
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!cVar.f100b) {
            int i5 = i2 % 3;
            if (i5 != 0) {
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.f101c && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.f102d ? 2 : 1);
        }
        ((a) cVar).f19342b = new byte[i4];
        cVar.a(bArr, i, i2, true);
        if (f19340a || cVar.f19341a == i4) {
            return ((a) cVar).f19342b;
        }
        throw new AssertionError();
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C0168b c0168b = new C0168b(i3, new byte[(i2 * 3) / 4]);
        if (c0168b.a(bArr, i, i2, true)) {
            int i4 = c0168b.f19341a;
            byte[] bArr2 = c0168b.f19342b;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
