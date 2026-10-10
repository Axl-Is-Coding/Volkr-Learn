package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzenm extends zzenh {
    zzenm() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzeng.zzhr(i);
        }
        if (i2 == 1) {
            return zzeng.zzap(i, zzend.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzeng.zzj(i, zzend.zza(bArr, j), zzend.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (com.google.android.gms.internal.ads.zzend.zza(r25, r8) > (-65)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        if (com.google.android.gms.internal.ads.zzend.zza(r25, r8) > (-65)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0103, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x012a, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.ads.zzenh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzb(int r24, byte[] r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzb(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzenh
    final String zzo(byte[] bArr, int i, int i2) throws zzekj {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zzend.zza(bArr, i);
            if (!zzeni.zze(bZza)) {
                break;
            }
            i++;
            zzeni.zza(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zzend.zza(bArr, i);
            if (zzeni.zze(bZza2)) {
                int i7 = i5 + 1;
                zzeni.zza(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zzend.zza(bArr, i6);
                    if (!zzeni.zze(bZza3)) {
                        break;
                    }
                    i6++;
                    zzeni.zza(bZza3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else if (zzeni.zzf(bZza2)) {
                if (i6 >= i3) {
                    throw zzekj.zzbhf();
                }
                zzeni.zza(bZza2, zzend.zza(bArr, i6), cArr, i5);
                i = i6 + 1;
                i5++;
            } else if (zzeni.zzg(bZza2)) {
                if (i6 >= i3 - 1) {
                    throw zzekj.zzbhf();
                }
                int i8 = i6 + 1;
                zzeni.zza(bZza2, zzend.zza(bArr, i6), zzend.zza(bArr, i8), cArr, i5);
                i = i8 + 1;
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw zzekj.zzbhf();
                }
                int i9 = i6 + 1;
                byte bZza4 = zzend.zza(bArr, i6);
                int i10 = i9 + 1;
                zzeni.zza(bZza2, bZza4, zzend.zza(bArr, i9), zzend.zza(bArr, i10), cArr, i5);
                i = i10 + 1;
                i5 = i5 + 1 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzenh
    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c2;
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzend.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= c2 || j4 >= j5) {
                if (cCharAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    zzend.zza(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    zzend.zza(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    long j7 = j4 + 1;
                                    zzend.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j8 = j7 + 1;
                                    zzend.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j9 = j8 + 1;
                                    zzend.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j9 + 1;
                                    zzend.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzenj(i4 - 1, length);
                        }
                        if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                            throw new zzenj(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j10 = j4 + j;
                    zzend.zza(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzend.zza(bArr, j10, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    zzend.zza(bArr, j11, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c2 = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                zzend.zza(bArr, j4, (byte) cCharAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c2 = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }
}
