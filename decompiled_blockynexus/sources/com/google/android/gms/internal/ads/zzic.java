package com.google.android.gms.internal.ads;

import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzic {
    private static final int[] zzaik = {1, 2, 3, 6};
    private static final int[] zzail = {48000, 44100, LogType.UNEXP_KNOWN_REASON};
    private static final int[] zzaim = {24000, 22050, 16000};
    private static final int[] zzain = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzaio = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzaip = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzho zza(zzpk zzpkVar, String str, String str2, zzjn zzjnVar) {
        int i = zzail[(zzpkVar.readUnsignedByte() & 192) >> 6];
        int unsignedByte = zzpkVar.readUnsignedByte();
        int i2 = zzain[(unsignedByte & 56) >> 3];
        if ((unsignedByte & 4) != 0) {
            i2++;
        }
        return zzho.zza(str, "audio/ac3", null, -1, -1, i2, i, null, zzjnVar, 0, str2);
    }

    public static zzho zzb(zzpk zzpkVar, String str, String str2, zzjn zzjnVar) {
        zzpkVar.zzbp(2);
        int i = zzail[(zzpkVar.readUnsignedByte() & 192) >> 6];
        int unsignedByte = zzpkVar.readUnsignedByte();
        int i2 = zzain[(unsignedByte & 14) >> 1];
        if ((unsignedByte & 1) != 0) {
            i2++;
        }
        return zzho.zza(str, "audio/eac3", null, -1, -1, i2, i, null, zzjnVar, 0, str2);
    }

    public static int zzfi() {
        return 1536;
    }

    public static int zzm(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? zzaik[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
