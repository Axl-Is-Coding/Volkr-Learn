package com.google.android.gms.internal.ads;

import com.just.agentweb.WebIndicator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkq {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjn zzahf;
    public int zzahj;
    public byte[] zzahk;
    public int zzahm;
    public int zzahn;
    private String zzaht;
    public String zzarm;
    public int zzarn;
    public boolean zzaro;
    public byte[] zzarp;
    public zzkf zzarq;
    public byte[] zzarr;
    public int zzars;
    public int zzart;
    public int zzaru;
    public boolean zzarv;
    public int zzarw;
    public int zzarx;
    public int zzary;
    public int zzarz;
    public int zzasa;
    public float zzasb;
    public float zzasc;
    public float zzasd;
    public float zzase;
    public float zzasf;
    public float zzasg;
    public float zzash;
    public float zzasi;
    public float zzasj;
    public float zzask;
    public int zzasl;
    public long zzasm;
    public long zzasn;
    public boolean zzaso;
    public boolean zzasp;
    public zzkg zzasq;
    public int zzasr;

    private zzkq() {
        this.width = -1;
        this.height = -1;
        this.zzars = -1;
        this.zzart = -1;
        this.zzaru = 0;
        this.zzahk = null;
        this.zzahj = -1;
        this.zzarv = false;
        this.zzarw = -1;
        this.zzarx = -1;
        this.zzary = -1;
        this.zzarz = 1000;
        this.zzasa = 200;
        this.zzasb = -1.0f;
        this.zzasc = -1.0f;
        this.zzasd = -1.0f;
        this.zzase = -1.0f;
        this.zzasf = -1.0f;
        this.zzasg = -1.0f;
        this.zzash = -1.0f;
        this.zzasi = -1.0f;
        this.zzasj = -1.0f;
        this.zzask = -1.0f;
        this.zzahm = 1;
        this.zzasl = -1;
        this.zzahn = WebIndicator.MAX_UNIFORM_SPEED_DURATION;
        this.zzasm = 0L;
        this.zzasn = 0L;
        this.zzasp = true;
        this.zzaht = "eng";
    }

    private static boolean zzb(zzpk zzpkVar) throws zzhv {
        try {
            int iZzjb = zzpkVar.zzjb();
            if (iZzjb == 1) {
                return true;
            }
            if (iZzjb == 65534) {
                zzpkVar.zzbo(24);
                if (zzpkVar.readLong() == zzkl.zzapm.getMostSignificantBits()) {
                    if (zzpkVar.readLong() == zzkl.zzapm.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhv("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) throws zzhv {
        try {
            if (bArr[0] != 2) {
                throw new zzhv("Error parsing vorbis codec private");
            }
            int i = 1;
            int i2 = 0;
            while (bArr[i] == -1) {
                i2 += 255;
                i++;
            }
            int i3 = i + 1;
            int i4 = i2 + bArr[i];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new zzhv("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzhv("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzhv("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhv("Error parsing vorbis codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzjx r30, int r31) throws com.google.android.gms.internal.ads.zzhv {
        /*
            Method dump skipped, instruction units count: 1402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkq.zza(com.google.android.gms.internal.ads.zzjx, int):void");
    }

    /* synthetic */ zzkq(zzko zzkoVar) {
        this();
    }

    private static List<byte[]> zza(zzpk zzpkVar) throws zzhv {
        try {
            zzpkVar.zzbp(16);
            if (zzpkVar.zzjd() != 826496599) {
                return null;
            }
            byte[] bArr = zzpkVar.data;
            for (int position = zzpkVar.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhv("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhv("Error parsing FourCC VC1 codec private");
        }
    }
}
