package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjf {
    private final int zzahn;
    private float zzaia;
    private float zzaib;
    private final int zzana;
    private final int zzanb;
    private final int zzanc;
    private final int zzand;
    private final short[] zzane;
    private int zzanf;
    private short[] zzang;
    private int zzanh;
    private short[] zzani;
    private int zzanj;
    private short[] zzank;
    private int zzanl;
    private int zzanm;
    private int zzann;
    private int zzano;
    private int zzanp;
    private int zzanq;
    private int zzanr;
    private int zzans;
    private int zzant;
    private int zzanu;

    public zzjf(int i, int i2) {
        this.zzahn = i;
        this.zzana = i2;
        this.zzanb = i / 400;
        this.zzanc = i / 65;
        this.zzand = this.zzanc * 2;
        int i3 = this.zzand;
        this.zzane = new short[i3];
        this.zzanf = i3;
        this.zzang = new short[i3 * i2];
        this.zzanh = i3;
        this.zzani = new short[i3 * i2];
        this.zzanj = i3;
        this.zzank = new short[i3 * i2];
        this.zzanl = 0;
        this.zzanm = 0;
        this.zzanr = 0;
        this.zzaia = 1.0f;
        this.zzaib = 1.0f;
    }

    private final void zzaa(int i) {
        int i2 = this.zzano + i;
        int i3 = this.zzanh;
        if (i2 > i3) {
            this.zzanh = i3 + (i3 / 2) + i;
            this.zzani = Arrays.copyOf(this.zzani, this.zzanh * this.zzana);
        }
    }

    private final void zzab(int i) {
        int i2 = this.zzann + i;
        int i3 = this.zzanf;
        if (i2 > i3) {
            this.zzanf = i3 + (i3 / 2) + i;
            this.zzang = Arrays.copyOf(this.zzang, this.zzanf * this.zzana);
        }
    }

    private final void zzgi() {
        int iZza;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.zzano;
        float f2 = this.zzaia / this.zzaib;
        double d2 = f2;
        int i7 = 1;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            int i8 = this.zzann;
            if (i8 >= this.zzand) {
                int i9 = 0;
                while (true) {
                    int i10 = this.zzanq;
                    if (i10 > 0) {
                        int iMin = Math.min(this.zzand, i10);
                        zza(this.zzang, i9, iMin);
                        this.zzanq -= iMin;
                        i9 += iMin;
                    } else {
                        short[] sArr = this.zzang;
                        int i11 = this.zzahn;
                        int i12 = i11 > 4000 ? i11 / 4000 : 1;
                        if (this.zzana == i7 && i12 == i7) {
                            iZza = zza(sArr, i9, this.zzanb, this.zzanc);
                        } else {
                            zzb(sArr, i9, i12);
                            int iZza2 = zza(this.zzane, 0, this.zzanb / i12, this.zzanc / i12);
                            if (i12 != i7) {
                                int i13 = iZza2 * i12;
                                int i14 = i12 << 2;
                                int i15 = i13 - i14;
                                int i16 = i13 + i14;
                                int i17 = this.zzanb;
                                if (i15 >= i17) {
                                    i17 = i15;
                                }
                                int i18 = this.zzanc;
                                if (i16 > i18) {
                                    i16 = i18;
                                }
                                if (this.zzana == i7) {
                                    iZza = zza(sArr, i9, i17, i16);
                                } else {
                                    zzb(sArr, i9, i7);
                                    iZza = zza(this.zzane, 0, i17, i16);
                                }
                            } else {
                                iZza = iZza2;
                            }
                        }
                        int i19 = this.zzant;
                        int i20 = i19 != 0 && this.zzanr != 0 && this.zzanu <= i19 * 3 && (i19 << 1) > this.zzans * 3 ? this.zzanr : iZza;
                        this.zzans = this.zzant;
                        this.zzanr = iZza;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.zzang;
                            if (f2 >= 2.0f) {
                                i2 = (int) (i20 / (f2 - 1.0f));
                            } else {
                                this.zzanq = (int) ((i20 * (2.0f - f2)) / (f2 - 1.0f));
                                i2 = i20;
                            }
                            zzaa(i2);
                            int i21 = i2;
                            zza(i2, this.zzana, this.zzani, this.zzano, sArr2, i9, sArr2, i9 + i20);
                            this.zzano += i21;
                            i9 += i20 + i21;
                        } else {
                            int i22 = i20;
                            short[] sArr3 = this.zzang;
                            if (f2 < 0.5f) {
                                i = (int) ((i22 * f2) / (1.0f - f2));
                            } else {
                                this.zzanq = (int) ((i22 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i = i22;
                            }
                            int i23 = i22 + i;
                            zzaa(i23);
                            int i24 = this.zzana;
                            System.arraycopy(sArr3, i9 * i24, this.zzani, this.zzano * i24, i24 * i22);
                            zza(i, this.zzana, this.zzani, this.zzano + i22, sArr3, i22 + i9, sArr3, i9);
                            this.zzano += i23;
                            i9 += i;
                        }
                    }
                    if (this.zzand + i9 > i8) {
                        break;
                    } else {
                        i7 = 1;
                    }
                }
                int i25 = this.zzann - i9;
                short[] sArr4 = this.zzang;
                int i26 = this.zzana;
                System.arraycopy(sArr4, i9 * i26, sArr4, 0, i26 * i25);
                this.zzann = i25;
            }
        } else {
            zza(this.zzang, 0, this.zzann);
            this.zzann = 0;
        }
        float f3 = this.zzaib;
        if (f3 == 1.0f || this.zzano == i6) {
            return;
        }
        int i27 = this.zzahn;
        int i28 = (int) (i27 / f3);
        while (true) {
            if (i28 <= 16384 && i27 <= 16384) {
                break;
            }
            i28 /= 2;
            i27 /= 2;
        }
        int i29 = this.zzano - i6;
        int i30 = this.zzanp + i29;
        int i31 = this.zzanj;
        if (i30 > i31) {
            this.zzanj = i31 + (i31 / 2) + i29;
            this.zzank = Arrays.copyOf(this.zzank, this.zzanj * this.zzana);
        }
        short[] sArr5 = this.zzani;
        int i32 = this.zzana;
        System.arraycopy(sArr5, i6 * i32, this.zzank, this.zzanp * i32, i32 * i29);
        this.zzano = i6;
        this.zzanp += i29;
        int i33 = 0;
        while (true) {
            i3 = this.zzanp;
            if (i33 >= i3 - 1) {
                break;
            }
            while (true) {
                i4 = this.zzanl;
                int i34 = (i4 + 1) * i28;
                i5 = this.zzanm;
                if (i34 <= i5 * i27) {
                    break;
                }
                zzaa(1);
                int i35 = 0;
                while (true) {
                    int i36 = this.zzana;
                    if (i35 < i36) {
                        short[] sArr6 = this.zzani;
                        int i37 = (this.zzano * i36) + i35;
                        short[] sArr7 = this.zzank;
                        int i38 = (i33 * i36) + i35;
                        short s = sArr7[i38];
                        short s2 = sArr7[i38 + i36];
                        int i39 = this.zzanm * i27;
                        int i40 = this.zzanl;
                        int i41 = i40 * i28;
                        int i42 = (i40 + 1) * i28;
                        int i43 = i42 - i39;
                        int i44 = i42 - i41;
                        sArr6[i37] = (short) (((s * i43) + ((i44 - i43) * s2)) / i44);
                        i35++;
                    }
                }
                this.zzanm++;
                this.zzano++;
            }
            this.zzanl = i4 + 1;
            if (this.zzanl == i27) {
                this.zzanl = 0;
                zzoz.checkState(i5 == i28);
                this.zzanm = 0;
            }
            i33++;
        }
        int i45 = i3 - 1;
        if (i45 != 0) {
            short[] sArr8 = this.zzank;
            int i46 = this.zzana;
            System.arraycopy(sArr8, i45 * i46, sArr8, 0, (i3 - i45) * i46);
            this.zzanp -= i45;
        }
    }

    public final void setSpeed(float f2) {
        this.zzaia = f2;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.zzana;
        int i2 = iRemaining / i;
        zzab(i2);
        shortBuffer.get(this.zzang, this.zzann * this.zzana, ((i * i2) << 1) / 2);
        this.zzann += i2;
        zzgi();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.zzana, this.zzano);
        shortBuffer.put(this.zzani, 0, this.zzana * iMin);
        this.zzano -= iMin;
        short[] sArr = this.zzani;
        int i = this.zzana;
        System.arraycopy(sArr, iMin * i, sArr, 0, this.zzano * i);
    }

    public final void zzc(float f2) {
        this.zzaib = f2;
    }

    public final void zzfl() {
        int i;
        int i2 = this.zzann;
        float f2 = this.zzaia;
        float f3 = this.zzaib;
        int i3 = this.zzano + ((int) ((((i2 / (f2 / f3)) + this.zzanp) / f3) + 0.5f));
        zzab((this.zzand * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzand;
            int i5 = this.zzana;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzang[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzann += i * 2;
        zzgi();
        if (this.zzano > i3) {
            this.zzano = i3;
        }
        this.zzann = 0;
        this.zzanq = 0;
        this.zzanp = 0;
    }

    public final int zzgh() {
        return this.zzano;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzand / i2;
        int i4 = this.zzana;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzane[i7] = (short) (i8 / i5);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzaa(i2);
        int i3 = this.zzana;
        System.arraycopy(sArr, i * i3, this.zzani, this.zzano * i3, i3 * i2);
        this.zzano += i2;
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzana;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.zzant = i5 / i6;
        this.zzanu = i7 / i8;
        return i6;
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
