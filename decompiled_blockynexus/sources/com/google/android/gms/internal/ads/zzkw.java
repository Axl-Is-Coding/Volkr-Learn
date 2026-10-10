package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.internal.ads.zzmc;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkw {
    private static final int zzawt = zzpq.zzbl("vide");
    private static final int zzawu = zzpq.zzbl("soun");
    private static final int zzawv = zzpq.zzbl(ViewHierarchyConstants.TEXT_KEY);
    private static final int zzaww = zzpq.zzbl("sbtl");
    private static final int zzawx = zzpq.zzbl("subt");
    private static final int zzawy = zzpq.zzbl("clcp");
    private static final int zzawz = zzpq.zzbl("cenc");
    private static final int zzavt = zzpq.zzbl("meta");

    /* JADX WARN: Removed duplicated region for block: B:202:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0830 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzln zza(com.google.android.gms.internal.ads.zzku r48, com.google.android.gms.internal.ads.zzkt r49, long r50, com.google.android.gms.internal.ads.zzjn r52, boolean r53) throws com.google.android.gms.internal.ads.zzhv {
        /*
            Method dump skipped, instruction units count: 2154
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkw.zza(com.google.android.gms.internal.ads.zzku, com.google.android.gms.internal.ads.zzkt, long, com.google.android.gms.internal.ads.zzjn, boolean):com.google.android.gms.internal.ads.zzln");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair<java.lang.String, byte[]> zzb(com.google.android.gms.internal.ads.zzpk r3, int r4) {
        /*
            int r4 = r4 + 8
            int r4 = r4 + 4
            r3.zzbo(r4)
            r4 = 1
            r3.zzbp(r4)
            zzc(r3)
            r0 = 2
            r3.zzbp(r0)
            int r1 = r3.readUnsignedByte()
            r2 = r1 & 128(0x80, float:1.8E-43)
            if (r2 == 0) goto L1d
            r3.zzbp(r0)
        L1d:
            r2 = r1 & 64
            if (r2 == 0) goto L28
            int r2 = r3.readUnsignedShort()
            r3.zzbp(r2)
        L28:
            r2 = 32
            r1 = r1 & r2
            if (r1 == 0) goto L30
            r3.zzbp(r0)
        L30:
            r3.zzbp(r4)
            zzc(r3)
            int r0 = r3.readUnsignedByte()
            r1 = 0
            if (r0 == r2) goto L80
            r2 = 33
            if (r0 == r2) goto L7d
            r2 = 35
            if (r0 == r2) goto L7a
            r2 = 64
            if (r0 == r2) goto L77
            r2 = 107(0x6b, float:1.5E-43)
            if (r0 == r2) goto L70
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L6d
            r2 = 166(0xa6, float:2.33E-43)
            if (r0 == r2) goto L6a
            switch(r0) {
                case 102: goto L77;
                case 103: goto L77;
                case 104: goto L77;
                default: goto L58;
            }
        L58:
            switch(r0) {
                case 169: goto L63;
                case 170: goto L5c;
                case 171: goto L5c;
                case 172: goto L63;
                default: goto L5b;
            }
        L5b:
            goto L82
        L5c:
            java.lang.String r3 = "audio/vnd.dts.hd"
            android.util.Pair r3 = android.util.Pair.create(r3, r1)
            return r3
        L63:
            java.lang.String r3 = "audio/vnd.dts"
            android.util.Pair r3 = android.util.Pair.create(r3, r1)
            return r3
        L6a:
            java.lang.String r1 = "audio/eac3"
            goto L82
        L6d:
            java.lang.String r1 = "audio/ac3"
            goto L82
        L70:
            java.lang.String r3 = "audio/mpeg"
            android.util.Pair r3 = android.util.Pair.create(r3, r1)
            return r3
        L77:
            java.lang.String r1 = "audio/mp4a-latm"
            goto L82
        L7a:
            java.lang.String r1 = "video/hevc"
            goto L82
        L7d:
            java.lang.String r1 = "video/avc"
            goto L82
        L80:
            java.lang.String r1 = "video/mp4v-es"
        L82:
            r0 = 12
            r3.zzbp(r0)
            r3.zzbp(r4)
            int r4 = zzc(r3)
            byte[] r0 = new byte[r4]
            r2 = 0
            r3.zze(r0, r2, r4)
            android.util.Pair r3 = android.util.Pair.create(r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkw.zzb(com.google.android.gms.internal.ads.zzpk, int):android.util.Pair");
    }

    private static int zzc(zzpk zzpkVar) {
        int unsignedByte = zzpkVar.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = zzpkVar.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    public static zzls zza(zzln zzlnVar, zzku zzkuVar, zzjz zzjzVar) throws zzhv {
        zzky zzkzVar;
        boolean z;
        int iZzjf;
        int iZzjf2;
        int i;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i2;
        long j;
        long j2;
        int[] iArr3;
        int[] iArr4;
        int i3;
        long[] jArr3;
        boolean z2;
        int[] iArr5;
        long[] jArr4;
        int i4;
        int i5;
        zzln zzlnVar2 = zzlnVar;
        zzkt zzktVarZzau = zzkuVar.zzau(zzkr.zzavi);
        if (zzktVarZzau != null) {
            zzkzVar = new zzla(zzktVarZzau);
        } else {
            zzkt zzktVarZzau2 = zzkuVar.zzau(zzkr.zzavj);
            if (zzktVarZzau2 != null) {
                zzkzVar = new zzkz(zzktVarZzau2);
            } else {
                throw new zzhv("Track has no sample table size information");
            }
        }
        int iZzgy = zzkzVar.zzgy();
        if (iZzgy == 0) {
            return new zzls(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzkt zzktVarZzau3 = zzkuVar.zzau(zzkr.zzavk);
        if (zzktVarZzau3 == null) {
            zzktVarZzau3 = zzkuVar.zzau(zzkr.zzavl);
            z = true;
        } else {
            z = false;
        }
        zzpk zzpkVar = zzktVarZzau3.zzawi;
        zzpk zzpkVar2 = zzkuVar.zzau(zzkr.zzavh).zzawi;
        zzpk zzpkVar3 = zzkuVar.zzau(zzkr.zzave).zzawi;
        zzkt zzktVarZzau4 = zzkuVar.zzau(zzkr.zzavf);
        zzpk zzpkVar4 = zzktVarZzau4 != null ? zzktVarZzau4.zzawi : null;
        zzkt zzktVarZzau5 = zzkuVar.zzau(zzkr.zzavg);
        zzpk zzpkVar5 = zzktVarZzau5 != null ? zzktVarZzau5.zzawi : null;
        zzkv zzkvVar = new zzkv(zzpkVar2, zzpkVar, z);
        zzpkVar3.zzbo(12);
        int iZzjf3 = zzpkVar3.zzjf() - 1;
        int iZzjf4 = zzpkVar3.zzjf();
        int iZzjf5 = zzpkVar3.zzjf();
        if (zzpkVar5 != null) {
            zzpkVar5.zzbo(12);
            iZzjf = zzpkVar5.zzjf();
        } else {
            iZzjf = 0;
        }
        int iZzjf6 = -1;
        if (zzpkVar4 != null) {
            zzpkVar4.zzbo(12);
            iZzjf2 = zzpkVar4.zzjf();
            if (iZzjf2 > 0) {
                iZzjf6 = zzpkVar4.zzjf() - 1;
            } else {
                zzpkVar4 = null;
            }
        } else {
            iZzjf2 = 0;
        }
        long j3 = 0;
        if (!(zzkzVar.zzha() && "audio/raw".equals(zzlnVar2.zzahx.zzahc) && iZzjf3 == 0 && iZzjf == 0 && iZzjf2 == 0)) {
            jArr = new long[iZzgy];
            iArr = new int[iZzgy];
            jArr2 = new long[iZzgy];
            int i6 = iZzjf2;
            iArr2 = new int[iZzgy];
            int i7 = i6;
            int i8 = iZzjf5;
            int i9 = iZzjf;
            int iZzjf7 = iZzjf6;
            long j4 = 0;
            long j5 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int iZzjf8 = 0;
            int iZzjf9 = iZzjf4;
            int i13 = iZzjf3;
            int i14 = 0;
            while (i14 < iZzgy) {
                long j6 = j4;
                int i15 = i10;
                while (i15 == 0) {
                    zzoz.checkState(zzkvVar.zzgx());
                    j6 = zzkvVar.zzawn;
                    i15 = zzkvVar.zzawm;
                    i13 = i13;
                    i8 = i8;
                }
                int i16 = i13;
                int i17 = i8;
                if (zzpkVar5 != null) {
                    while (iZzjf8 == 0 && i9 > 0) {
                        iZzjf8 = zzpkVar5.zzjf();
                        i12 = zzpkVar5.readInt();
                        i9--;
                    }
                    iZzjf8--;
                }
                int i18 = i12;
                jArr[i14] = j6;
                iArr[i14] = zzkzVar.zzgz();
                if (iArr[i14] > i11) {
                    i4 = iZzgy;
                    i11 = iArr[i14];
                } else {
                    i4 = iZzgy;
                }
                zzky zzkyVar = zzkzVar;
                jArr2[i14] = j5 + ((long) i18);
                iArr2[i14] = zzpkVar4 == null ? 1 : 0;
                if (i14 == iZzjf7) {
                    iArr2[i14] = 1;
                    i7--;
                    if (i7 > 0) {
                        iZzjf7 = zzpkVar4.zzjf() - 1;
                    }
                }
                int i19 = i7;
                int i20 = iZzjf7;
                int iZzjf10 = i17;
                j5 += (long) iZzjf10;
                iZzjf9--;
                if (iZzjf9 != 0 || i16 <= 0) {
                    i5 = i16;
                } else {
                    i5 = i16 - 1;
                    iZzjf9 = zzpkVar3.zzjf();
                    iZzjf10 = zzpkVar3.zzjf();
                }
                int i21 = i5;
                long j7 = j6 + ((long) iArr[i14]);
                i14++;
                iZzjf7 = i20;
                iZzgy = i4;
                i10 = i15 - 1;
                i12 = i18;
                i13 = i21;
                j4 = j7;
                i8 = iZzjf10;
                i7 = i19;
                zzkzVar = zzkyVar;
            }
            i = iZzgy;
            int i22 = i13;
            zzoz.checkArgument(iZzjf8 == 0);
            while (i9 > 0) {
                zzoz.checkArgument(zzpkVar5.zzjf() == 0);
                zzpkVar5.readInt();
                i9--;
            }
            if (i7 == 0 && iZzjf9 == 0 && i10 == 0 && i22 == 0) {
                zzlnVar2 = zzlnVar;
            } else {
                int i23 = i7;
                zzlnVar2 = zzlnVar;
                int i24 = zzlnVar2.id;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i24);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i23);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(iZzjf9);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i10);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i22);
                Log.w("AtomParsers", sb.toString());
            }
            j = j5;
            i2 = i11;
        } else {
            i = iZzgy;
            zzky zzkyVar2 = zzkzVar;
            int i25 = zzkvVar.length;
            long[] jArr5 = new long[i25];
            int[] iArr6 = new int[i25];
            while (zzkvVar.zzgx()) {
                int i26 = zzkvVar.index;
                jArr5[i26] = zzkvVar.zzawn;
                iArr6[i26] = zzkvVar.zzawm;
            }
            int iZzgz = zzkyVar2.zzgz();
            long j8 = iZzjf5;
            int i27 = 8192 / iZzgz;
            int iZzf = 0;
            for (int i28 : iArr6) {
                iZzf += zzpq.zzf(i28, i27);
            }
            long[] jArr6 = new long[iZzf];
            int[] iArr7 = new int[iZzf];
            long[] jArr7 = new long[iZzf];
            int[] iArr8 = new int[iZzf];
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            while (i29 < iArr6.length) {
                int i33 = iArr6[i29];
                long j9 = jArr5[i29];
                int i34 = i30;
                int iMax = i32;
                while (i33 > 0) {
                    int iMin = Math.min(i27, i33);
                    jArr6[i31] = j9;
                    iArr7[i31] = iZzgz * iMin;
                    iMax = Math.max(iMax, iArr7[i31]);
                    jArr7[i31] = ((long) i34) * j8;
                    iArr8[i31] = 1;
                    j9 += (long) iArr7[i31];
                    i34 += iMin;
                    i33 -= iMin;
                    i31++;
                    iArr6 = iArr6;
                    jArr5 = jArr5;
                }
                i29++;
                i32 = iMax;
                i30 = i34;
            }
            zzld zzldVar = new zzld(jArr6, iArr7, i32, jArr7, iArr8);
            jArr = zzldVar.zzaoo;
            iArr = zzldVar.zzaon;
            int i35 = zzldVar.zzaxi;
            jArr2 = zzldVar.zzaxj;
            iArr2 = zzldVar.zzaxk;
            i2 = i35;
            j = 0;
        }
        if (zzlnVar2.zzbag != null && !zzjzVar.zzgs()) {
            long[] jArr8 = zzlnVar2.zzbag;
            if (jArr8.length == 1 && zzlnVar2.type == 1 && jArr2.length >= 2) {
                long j10 = zzlnVar2.zzbah[0];
                long jZza = zzpq.zza(jArr8[0], zzlnVar2.zzdg, zzlnVar2.zzbad) + j10;
                if (jArr2[0] <= j10 && j10 < jArr2[1] && jArr2[jArr2.length - 1] < jZza && jZza <= j) {
                    long j11 = j - jZza;
                    long jZza2 = zzpq.zza(j10 - jArr2[0], zzlnVar2.zzahx.zzahn, zzlnVar2.zzdg);
                    long jZza3 = zzpq.zza(j11, zzlnVar2.zzahx.zzahn, zzlnVar2.zzdg);
                    if ((jZza2 != 0 || jZza3 != 0) && jZza2 <= 2147483647L && jZza3 <= 2147483647L) {
                        zzjzVar.zzahp = (int) jZza2;
                        zzjzVar.zzahq = (int) jZza3;
                        zzpq.zza(jArr2, 1000000L, zzlnVar2.zzdg);
                        return new zzls(jArr, iArr, i2, jArr2, iArr2);
                    }
                }
            }
            long[] jArr9 = zzlnVar2.zzbag;
            if (jArr9.length == 1) {
                char c2 = 0;
                if (jArr9[0] == 0) {
                    int i36 = 0;
                    while (i36 < jArr2.length) {
                        jArr2[i36] = zzpq.zza(jArr2[i36] - zzlnVar2.zzbah[c2], 1000000L, zzlnVar2.zzdg);
                        i36++;
                        c2 = 0;
                    }
                    return new zzls(jArr, iArr, i2, jArr2, iArr2);
                }
            }
            boolean z3 = zzlnVar2.type == 1;
            int i37 = 0;
            boolean z4 = false;
            int i38 = 0;
            int i39 = 0;
            while (true) {
                long[] jArr10 = zzlnVar2.zzbag;
                j2 = -1;
                if (i37 >= jArr10.length) {
                    break;
                }
                int[] iArr9 = iArr;
                long j12 = zzlnVar2.zzbah[i37];
                if (j12 != -1) {
                    long jZza4 = zzpq.zza(jArr10[i37], zzlnVar2.zzdg, zzlnVar2.zzbad);
                    int iZzb = zzpq.zzb(jArr2, j12, true, true);
                    int iZzb2 = zzpq.zzb(jArr2, j12 + jZza4, z3, false);
                    i38 += iZzb2 - iZzb;
                    z4 |= i39 != iZzb;
                    i39 = iZzb2;
                }
                i37++;
                iArr = iArr9;
            }
            int[] iArr10 = iArr;
            boolean z5 = (i38 != i) | z4;
            long[] jArr11 = z5 ? new long[i38] : jArr;
            int[] iArr11 = z5 ? new int[i38] : iArr10;
            if (z5) {
                i2 = 0;
            }
            int[] iArr12 = z5 ? new int[i38] : iArr2;
            long[] jArr12 = new long[i38];
            int i40 = i2;
            int i41 = 0;
            int i42 = 0;
            while (true) {
                long[] jArr13 = zzlnVar2.zzbag;
                if (i41 >= jArr13.length) {
                    break;
                }
                long[] jArr14 = jArr11;
                long[] jArr15 = jArr12;
                long j13 = zzlnVar2.zzbah[i41];
                long j14 = jArr13[i41];
                if (j13 != j2) {
                    iArr4 = iArr12;
                    i3 = i41;
                    long jZza5 = zzpq.zza(j14, zzlnVar2.zzdg, zzlnVar2.zzbad) + j13;
                    int iZzb3 = zzpq.zzb(jArr2, j13, true, true);
                    int iZzb4 = zzpq.zzb(jArr2, jZza5, z3, false);
                    if (z5) {
                        int i43 = iZzb4 - iZzb3;
                        jArr3 = jArr14;
                        System.arraycopy(jArr, iZzb3, jArr3, i42, i43);
                        z2 = z3;
                        iArr5 = iArr10;
                        System.arraycopy(iArr5, iZzb3, iArr11, i42, i43);
                        System.arraycopy(iArr2, iZzb3, iArr4, i42, i43);
                    } else {
                        jArr3 = jArr14;
                        z2 = z3;
                        iArr5 = iArr10;
                    }
                    int i44 = i40;
                    while (iZzb3 < iZzb4) {
                        long[] jArr16 = jArr;
                        int[] iArr13 = iArr2;
                        long j15 = j13;
                        jArr15[i42] = zzpq.zza(j3, 1000000L, zzlnVar2.zzbad) + zzpq.zza(jArr2[iZzb3] - j13, 1000000L, zzlnVar2.zzdg);
                        if (z5 && iArr11[i42] > i44) {
                            i44 = iArr5[iZzb3];
                        }
                        i42++;
                        iZzb3++;
                        jArr = jArr16;
                        j13 = j15;
                        iArr2 = iArr13;
                    }
                    jArr4 = jArr;
                    iArr3 = iArr2;
                    i40 = i44;
                } else {
                    iArr3 = iArr2;
                    iArr4 = iArr12;
                    i3 = i41;
                    jArr3 = jArr14;
                    z2 = z3;
                    iArr5 = iArr10;
                    jArr4 = jArr;
                }
                j3 += j14;
                i41 = i3 + 1;
                jArr = jArr4;
                iArr10 = iArr5;
                iArr12 = iArr4;
                jArr11 = jArr3;
                z3 = z2;
                iArr2 = iArr3;
                jArr12 = jArr15;
                j2 = -1;
            }
            long[] jArr17 = jArr11;
            long[] jArr18 = jArr12;
            int[] iArr14 = iArr12;
            boolean z6 = false;
            for (int i45 = 0; i45 < iArr14.length && !z6; i45++) {
                z6 |= (iArr14[i45] & 1) != 0;
            }
            if (z6) {
                return new zzls(jArr17, iArr11, i40, jArr18, iArr14);
            }
            throw new zzhv("The edited sample sequence does not contain a sync sample.");
        }
        int[] iArr15 = iArr;
        zzpq.zza(jArr2, 1000000L, zzlnVar2.zzdg);
        return new zzls(jArr, iArr15, i2, jArr2, iArr2);
    }

    public static zzmc zza(zzkt zzktVar, boolean z) {
        if (z) {
            return null;
        }
        zzpk zzpkVar = zzktVar.zzawi;
        zzpkVar.zzbo(8);
        while (zzpkVar.zzja() >= 8) {
            int position = zzpkVar.getPosition();
            int i = zzpkVar.readInt();
            if (zzpkVar.readInt() == zzkr.zzavt) {
                zzpkVar.zzbo(position);
                int i2 = position + i;
                zzpkVar.zzbp(12);
                while (true) {
                    if (zzpkVar.getPosition() >= i2) {
                        break;
                    }
                    int position2 = zzpkVar.getPosition();
                    int i3 = zzpkVar.readInt();
                    if (zzpkVar.readInt() == zzkr.zzavu) {
                        zzpkVar.zzbo(position2);
                        int i4 = position2 + i3;
                        zzpkVar.zzbp(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpkVar.getPosition() < i4) {
                            zzmc.zza zzaVarZzd = zzlk.zzd(zzpkVar);
                            if (zzaVarZzd != null) {
                                arrayList.add(zzaVarZzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmc(arrayList);
                        }
                    } else {
                        zzpkVar.zzbp(i3 - 8);
                    }
                }
                return null;
            }
            zzpkVar.zzbp(i - 8);
        }
        return null;
    }

    private static int zza(zzpk zzpkVar, int i, int i2, zzkx zzkxVar, int i3) {
        zzlq zzlqVar;
        int position = zzpkVar.getPosition();
        while (true) {
            if (position - i >= i2) {
                return 0;
            }
            zzpkVar.zzbo(position);
            int i4 = zzpkVar.readInt();
            zzoz.checkArgument(i4 > 0, "childAtomSize should be positive");
            if (zzpkVar.readInt() == zzkr.zzaun) {
                int i5 = position + 8;
                Pair pairCreate = null;
                Integer numValueOf = null;
                zzlq zzlqVar2 = null;
                boolean z = false;
                while (i5 - position < i4) {
                    zzpkVar.zzbo(i5);
                    int i6 = zzpkVar.readInt();
                    int i7 = zzpkVar.readInt();
                    if (i7 == zzkr.zzaut) {
                        numValueOf = Integer.valueOf(zzpkVar.readInt());
                    } else if (i7 == zzkr.zzauo) {
                        zzpkVar.zzbp(4);
                        z = zzpkVar.readInt() == zzawz;
                    } else if (i7 == zzkr.zzaup) {
                        int i8 = i5 + 8;
                        while (true) {
                            if (i8 - i5 >= i6) {
                                zzlqVar = null;
                                break;
                            }
                            zzpkVar.zzbo(i8);
                            int i9 = zzpkVar.readInt();
                            if (zzpkVar.readInt() == zzkr.zzauq) {
                                zzpkVar.zzbp(6);
                                boolean z2 = zzpkVar.readUnsignedByte() == 1;
                                int unsignedByte = zzpkVar.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpkVar.zze(bArr, 0, 16);
                                zzlqVar = new zzlq(z2, unsignedByte, bArr);
                            } else {
                                i8 += i9;
                            }
                        }
                        zzlqVar2 = zzlqVar;
                    }
                    i5 += i6;
                }
                if (z) {
                    zzoz.checkArgument(numValueOf != null, "frma atom is mandatory");
                    zzoz.checkArgument(zzlqVar2 != null, "schi->tenc atom is mandatory");
                    pairCreate = Pair.create(numValueOf, zzlqVar2);
                }
                if (pairCreate != null) {
                    zzkxVar.zzaxa[i3] = (zzlq) pairCreate.second;
                    return ((Integer) pairCreate.first).intValue();
                }
            }
            position += i4;
        }
    }
}
