package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzps {
    private final int height;
    private final int width;
    public final List<byte[]> zzahe;
    public final int zzasr;
    public final float zzbkc;

    private zzps(List<byte[]> list, int i, int i2, int i3, float f2) {
        this.zzahe = list;
        this.zzasr = i;
        this.width = i2;
        this.height = i3;
        this.zzbkc = f2;
    }

    public static zzps zzg(zzpk zzpkVar) throws zzhv {
        int i;
        int i2;
        float f2;
        try {
            zzpkVar.zzbp(4);
            int unsignedByte = (zzpkVar.readUnsignedByte() & 3) + 1;
            if (unsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int unsignedByte2 = zzpkVar.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < unsignedByte2; i3++) {
                arrayList.add(zzh(zzpkVar));
            }
            int unsignedByte3 = zzpkVar.readUnsignedByte();
            for (int i4 = 0; i4 < unsignedByte3; i4++) {
                arrayList.add(zzh(zzpkVar));
            }
            if (unsignedByte2 > 0) {
                zzpi zzpiVarZzd = zzpf.zzd((byte[]) arrayList.get(0), unsignedByte, ((byte[]) arrayList.get(0)).length);
                int i5 = zzpiVarZzd.width;
                int i6 = zzpiVarZzd.height;
                f2 = zzpiVarZzd.zzbkc;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f2 = 1.0f;
            }
            return new zzps(arrayList, unsignedByte, i, i2, f2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzhv("Error parsing AVC config", e2);
        }
    }

    private static byte[] zzh(zzpk zzpkVar) {
        int unsignedShort = zzpkVar.readUnsignedShort();
        int position = zzpkVar.getPosition();
        zzpkVar.zzbp(unsignedShort);
        return zzpc.zzc(zzpkVar.data, position, unsignedShort);
    }
}
