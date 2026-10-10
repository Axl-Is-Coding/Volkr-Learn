package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpy {
    public final List<byte[]> zzahe;
    public final int zzasr;

    private zzpy(List<byte[]> list, int i) {
        this.zzahe = list;
        this.zzasr = i;
    }

    public static zzpy zzi(zzpk zzpkVar) throws zzhv {
        try {
            zzpkVar.zzbp(21);
            int unsignedByte = zzpkVar.readUnsignedByte() & 3;
            int unsignedByte2 = zzpkVar.readUnsignedByte();
            int position = zzpkVar.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < unsignedByte2) {
                zzpkVar.zzbp(1);
                int unsignedShort = zzpkVar.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < unsignedShort; i4++) {
                    int unsignedShort2 = zzpkVar.readUnsignedShort();
                    i3 += unsignedShort2 + 4;
                    zzpkVar.zzbp(unsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzpkVar.zzbo(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < unsignedByte2) {
                zzpkVar.zzbp(1);
                int unsignedShort3 = zzpkVar.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < unsignedShort3; i8++) {
                    int unsignedShort4 = zzpkVar.readUnsignedShort();
                    System.arraycopy(zzpf.zzbjr, 0, bArr, i7, zzpf.zzbjr.length);
                    int length = i7 + zzpf.zzbjr.length;
                    System.arraycopy(zzpkVar.data, zzpkVar.getPosition(), bArr, length, unsignedShort4);
                    i7 = length + unsignedShort4;
                    zzpkVar.zzbp(unsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new zzpy(i2 == 0 ? null : Collections.singletonList(bArr), unsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzhv("Error parsing HEVC config", e2);
        }
    }
}
