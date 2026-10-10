package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbu extends zzeof {
    private Date zzde;
    private Date zzdf;
    private long zzdg;
    private long zzdh;
    private double zzdi;
    private float zzdj;
    private zzeop zzdk;
    private long zzdl;
    private int zzdm;
    private int zzdn;
    private int zzdo;
    private int zzdp;
    private int zzdq;
    private int zzdr;

    public zzbu() {
        super("mvhd");
        this.zzdi = 1.0d;
        this.zzdj = 1.0f;
        this.zzdk = zzeop.zziui;
    }

    public final long getDuration() {
        return this.zzdh;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzde + ";modificationTime=" + this.zzdf + ";timescale=" + this.zzdg + ";duration=" + this.zzdh + ";rate=" + this.zzdi + ";volume=" + this.zzdj + ";matrix=" + this.zzdk + ";nextTrackId=" + this.zzdl + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzeoe
    public final void zzl(ByteBuffer byteBuffer) {
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.zzde = zzeom.zzfv(zzbq.zzh(byteBuffer));
            this.zzdf = zzeom.zzfv(zzbq.zzh(byteBuffer));
            this.zzdg = zzbq.zzf(byteBuffer);
            this.zzdh = zzbq.zzh(byteBuffer);
        } else {
            this.zzde = zzeom.zzfv(zzbq.zzf(byteBuffer));
            this.zzdf = zzeom.zzfv(zzbq.zzf(byteBuffer));
            this.zzdg = zzbq.zzf(byteBuffer);
            this.zzdh = zzbq.zzf(byteBuffer);
        }
        this.zzdi = zzbq.zzi(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzdj = ((short) ((r0[1] & 255) | ((short) (0 | ((r0[0] << 8) & 65280))))) / 256.0f;
        zzbq.zzg(byteBuffer);
        zzbq.zzf(byteBuffer);
        zzbq.zzf(byteBuffer);
        this.zzdk = zzeop.zzs(byteBuffer);
        this.zzdm = byteBuffer.getInt();
        this.zzdn = byteBuffer.getInt();
        this.zzdo = byteBuffer.getInt();
        this.zzdp = byteBuffer.getInt();
        this.zzdq = byteBuffer.getInt();
        this.zzdr = byteBuffer.getInt();
        this.zzdl = zzbq.zzf(byteBuffer);
    }

    public final long zzr() {
        return this.zzdg;
    }
}
