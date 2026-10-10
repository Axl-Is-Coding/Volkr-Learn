package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzjb extends zzlu implements zzpd {
    private int zzahm;
    private int zzaho;
    private final zzij zzamo;
    private final zzio zzamp;
    private boolean zzamq;
    private boolean zzamr;
    private MediaFormat zzams;
    private long zzamt;
    private boolean zzamu;

    public zzjb(zzlw zzlwVar) {
        this(zzlwVar, null, true);
    }

    protected static void zza(int i, long j, long j2) {
    }

    private final boolean zzba(String str) {
        return this.zzamp.zzay(str);
    }

    protected static void zzgd() {
    }

    protected static void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhx
    public final boolean isReady() {
        return this.zzamp.zzfr() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhd {
        int[] iArr;
        int i;
        boolean z = this.zzams != null;
        String string = z ? this.zzams.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzams;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.zzamr && integer == 6 && (i = this.zzahm) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzahm; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        try {
            this.zzamp.zza(string, integer, integer2, this.zzaho, 0, iArr);
        } catch (zzis e2) {
            throw zzhd.zza(e2, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void onStarted() {
        super.onStarted();
        this.zzamp.play();
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void onStopped() {
        this.zzamp.pause();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final int zza(zzlw zzlwVar, zzho zzhoVar) throws zzlz {
        int i;
        int i2;
        String str = zzhoVar.zzahc;
        if (!zzpg.zzbf(str)) {
            return 0;
        }
        int i3 = zzpq.SDK_INT >= 21 ? 16 : 0;
        if (zzba(str) && zzlwVar.zzhj() != null) {
            return i3 | 4 | 3;
        }
        zzlr zzlrVarZzc = zzlwVar.zzc(str, false);
        boolean z = true;
        if (zzlrVarZzc == null) {
            return 1;
        }
        if (zzpq.SDK_INT >= 21 && (((i = zzhoVar.zzahn) != -1 && !zzlrVarZzc.zzay(i)) || ((i2 = zzhoVar.zzahm) != -1 && !zzlrVarZzc.zzaz(i2)))) {
            z = false;
        }
        return i3 | 4 | (z ? 3 : 2);
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzb(zzhu zzhuVar) {
        return this.zzamp.zzb(zzhuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zzc(String str, long j, long j2) {
        this.zzamo.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zzd(zzho zzhoVar) throws zzhd {
        super.zzd(zzhoVar);
        this.zzamo.zzc(zzhoVar);
        this.zzaho = "audio/raw".equals(zzhoVar.zzahc) ? zzhoVar.zzaho : 2;
        this.zzahm = zzhoVar.zzahm;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void zze(boolean z) throws zzhd {
        super.zze(z);
        this.zzamo.zzc(this.zzbcv);
        int i = zzei().zzaif;
        if (i != 0) {
            this.zzamp.zzz(i);
        } else {
            this.zzamp.zzft();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhx
    public final zzpd zzea() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void zzeh() {
        try {
            this.zzamp.release();
            try {
                super.zzeh();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.zzeh();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhx
    public final boolean zzfe() {
        return super.zzfe() && this.zzamp.zzfe();
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzfs() {
        return this.zzamp.zzfs();
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final long zzfz() {
        long jZzj = this.zzamp.zzj(zzfe());
        if (jZzj != Long.MIN_VALUE) {
            if (!this.zzamu) {
                jZzj = Math.max(this.zzamt, jZzj);
            }
            this.zzamt = jZzj;
            this.zzamu = false;
        }
        return this.zzamt;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zzge() throws zzhd {
        try {
            this.zzamp.zzfp();
        } catch (zziw e2) {
            throw zzhd.zza(e2, getIndex());
        }
    }

    private zzjb(zzlw zzlwVar, zzjs<zzju> zzjsVar, boolean z) {
        this(zzlwVar, null, true, null, null);
    }

    private zzjb(zzlw zzlwVar, zzjs<zzju> zzjsVar, boolean z, Handler handler, zzig zzigVar) {
        this(zzlwVar, null, true, null, null, null, new zzie[0]);
    }

    private zzjb(zzlw zzlwVar, zzjs<zzju> zzjsVar, boolean z, Handler handler, zzig zzigVar, zzif zzifVar, zzie... zzieVarArr) {
        super(1, zzlwVar, zzjsVar, z);
        this.zzamp = new zzio(null, zzieVarArr, new zzjd(this));
        this.zzamo = new zzij(null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final zzlr zza(zzlw zzlwVar, zzho zzhoVar, boolean z) throws zzlz {
        zzlr zzlrVarZzhj;
        if (zzba(zzhoVar.zzahc) && (zzlrVarZzhj = zzlwVar.zzhj()) != null) {
            this.zzamq = true;
            return zzlrVarZzhj;
        }
        this.zzamq = false;
        return super.zza(zzlwVar, zzhoVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zza(zzlr zzlrVar, MediaCodec mediaCodec, zzho zzhoVar, MediaCrypto mediaCrypto) {
        this.zzamr = zzpq.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzlrVar.name) && "samsung".equals(zzpq.MANUFACTURER) && (zzpq.DEVICE.startsWith("zeroflte") || zzpq.DEVICE.startsWith("herolte") || zzpq.DEVICE.startsWith("heroqlte"));
        if (this.zzamq) {
            this.zzams = zzhoVar.zzfa();
            this.zzams.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzams, (Surface) null, (MediaCrypto) null, 0);
            this.zzams.setString("mime", zzhoVar.zzahc);
            return;
        }
        mediaCodec.configure(zzhoVar.zzfa(), (Surface) null, (MediaCrypto) null, 0);
        this.zzams = null;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void zza(long j, boolean z) throws zzhd {
        super.zza(j, z);
        this.zzamp.reset();
        this.zzamt = j;
        this.zzamu = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhd {
        if (this.zzamq && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbcv.zzaoh++;
            this.zzamp.zzfo();
            return true;
        }
        try {
            if (!this.zzamp.zzb(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbcv.zzaog++;
            return true;
        } catch (zziv | zziw e2) {
            throw zzhd.zza(e2, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhe
    public final void zza(int i, Object obj) throws zzhd {
        if (i == 2) {
            this.zzamp.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzamp.setStreamType(((Integer) obj).intValue());
        }
    }

    static /* synthetic */ boolean zza(zzjb zzjbVar, boolean z) {
        zzjbVar.zzamu = true;
        return true;
    }
}
