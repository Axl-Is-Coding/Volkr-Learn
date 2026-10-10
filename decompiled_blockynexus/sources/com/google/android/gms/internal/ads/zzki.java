package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzki implements zzkj {
    private final byte[] zzapb = new byte[8];
    private final Stack<zzkk> zzapc = new Stack<>();
    private final zzks zzapd = new zzks();
    private zzkm zzape;
    private int zzapf;
    private int zzapg;
    private long zzaph;

    zzki() {
    }

    @Override // com.google.android.gms.internal.ads.zzkj
    public final void reset() {
        this.zzapf = 0;
        this.zzapc.clear();
        this.zzapd.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzkj
    public final void zza(zzkm zzkmVar) {
        this.zzape = zzkmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkj
    public final boolean zzb(zzjy zzjyVar) throws InterruptedException, IOException {
        String str;
        int iZzat;
        int iZza;
        zzoz.checkState(this.zzape != null);
        while (true) {
            if (!this.zzapc.isEmpty() && zzjyVar.getPosition() >= this.zzapc.peek().zzapi) {
                this.zzape.zzap(this.zzapc.pop().zzapg);
                return true;
            }
            if (this.zzapf == 0) {
                long jZza = this.zzapd.zza(zzjyVar, true, false, 4);
                if (jZza == -2) {
                    zzjyVar.zzgq();
                    while (true) {
                        zzjyVar.zza(this.zzapb, 0, 4);
                        iZzat = zzks.zzat(this.zzapb[0]);
                        if (iZzat != -1 && iZzat <= 4) {
                            iZza = (int) zzks.zza(this.zzapb, iZzat, false);
                            if (this.zzape.zzao(iZza)) {
                                break;
                            }
                        }
                        zzjyVar.zzai(1);
                    }
                    zzjyVar.zzai(iZzat);
                    jZza = iZza;
                }
                if (jZza == -1) {
                    return false;
                }
                this.zzapg = (int) jZza;
                this.zzapf = 1;
            }
            if (this.zzapf == 1) {
                this.zzaph = this.zzapd.zza(zzjyVar, false, true, 8);
                this.zzapf = 2;
            }
            int iZzan = this.zzape.zzan(this.zzapg);
            if (iZzan != 0) {
                if (iZzan == 1) {
                    long position = zzjyVar.getPosition();
                    this.zzapc.add(new zzkk(this.zzapg, this.zzaph + position));
                    this.zzape.zzd(this.zzapg, position, this.zzaph);
                    this.zzapf = 0;
                    return true;
                }
                if (iZzan == 2) {
                    long j = this.zzaph;
                    if (j <= 8) {
                        this.zzape.zzc(this.zzapg, zza(zzjyVar, (int) j));
                        this.zzapf = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j);
                    throw new zzhv(sb.toString());
                }
                if (iZzan == 3) {
                    long j2 = this.zzaph;
                    if (j2 > 2147483647L) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j2);
                        throw new zzhv(sb2.toString());
                    }
                    zzkm zzkmVar = this.zzape;
                    int i = this.zzapg;
                    int i2 = (int) j2;
                    if (i2 == 0) {
                        str = "";
                    } else {
                        byte[] bArr = new byte[i2];
                        zzjyVar.readFully(bArr, 0, i2);
                        str = new String(bArr);
                    }
                    zzkmVar.zza(i, str);
                    this.zzapf = 0;
                    return true;
                }
                if (iZzan == 4) {
                    this.zzape.zza(this.zzapg, (int) this.zzaph, zzjyVar);
                    this.zzapf = 0;
                    return true;
                }
                if (iZzan != 5) {
                    StringBuilder sb3 = new StringBuilder(32);
                    sb3.append("Invalid element type ");
                    sb3.append(iZzan);
                    throw new zzhv(sb3.toString());
                }
                long j3 = this.zzaph;
                if (j3 != 4 && j3 != 8) {
                    StringBuilder sb4 = new StringBuilder(40);
                    sb4.append("Invalid float size: ");
                    sb4.append(j3);
                    throw new zzhv(sb4.toString());
                }
                zzkm zzkmVar2 = this.zzape;
                int i3 = this.zzapg;
                int i4 = (int) this.zzaph;
                zzkmVar2.zza(i3, i4 == 4 ? Float.intBitsToFloat((int) r7) : Double.longBitsToDouble(zza(zzjyVar, i4)));
                this.zzapf = 0;
                return true;
            }
            zzjyVar.zzai((int) this.zzaph);
            this.zzapf = 0;
        }
    }

    private final long zza(zzjy zzjyVar, int i) throws InterruptedException, IOException {
        zzjyVar.readFully(this.zzapb, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzapb[i2] & 255));
        }
        return j;
    }
}
