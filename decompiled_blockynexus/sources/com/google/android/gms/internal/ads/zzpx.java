package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tendcloud.tenddata.ab;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzpx extends zzlu {
    private static final int[] zzblb = {1920, 1600, 1440, LogType.UNEXP_ANR, 960, 854, 640, 540, 480};
    private int zzaif;
    private boolean zzalm;
    private final zzqb zzblc;
    private final zzqg zzbld;
    private final long zzble;
    private final int zzblf;
    private final boolean zzblg;
    private final long[] zzblh;
    private zzho[] zzbli;
    private zzpz zzblj;
    private Surface zzblk;
    private Surface zzbll;
    private int zzblm;
    private boolean zzbln;
    private long zzblo;
    private long zzblp;
    private int zzblq;
    private int zzblr;
    private int zzbls;
    private float zzblt;
    private int zzblu;
    private int zzblv;
    private int zzblw;
    private float zzblx;
    private int zzbly;
    private int zzblz;
    private int zzbma;
    private float zzbmb;
    zzqc zzbmc;
    private long zzbmd;
    private int zzbme;
    private final Context zzvr;

    public zzpx(Context context, zzlw zzlwVar, long j, Handler handler, zzqd zzqdVar, int i) {
        this(context, zzlwVar, 0L, null, false, handler, zzqdVar, -1);
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjm();
        zzpn.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpn.endSection();
        this.zzbcv.zzaog++;
        this.zzblr = 0;
        zzjk();
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    private static int zzi(zzho zzhoVar) {
        int i = zzhoVar.zzahd;
        return i != -1 ? i : zza(zzhoVar.zzahc, zzhoVar.width, zzhoVar.height);
    }

    private static int zzj(zzho zzhoVar) {
        int i = zzhoVar.zzahh;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final void zzji() {
        this.zzblo = this.zzble > 0 ? SystemClock.elapsedRealtime() + this.zzble : -9223372036854775807L;
    }

    private final void zzjj() {
        MediaCodec mediaCodecZzhe;
        this.zzbln = false;
        if (zzpq.SDK_INT < 23 || !this.zzalm || (mediaCodecZzhe = zzhe()) == null) {
            return;
        }
        this.zzbmc = new zzqc(this, mediaCodecZzhe);
    }

    private final void zzjl() {
        this.zzbly = -1;
        this.zzblz = -1;
        this.zzbmb = -1.0f;
        this.zzbma = -1;
    }

    private final void zzjm() {
        if (this.zzbly == this.zzblu && this.zzblz == this.zzblv && this.zzbma == this.zzblw && this.zzbmb == this.zzblx) {
            return;
        }
        this.zzbld.zzb(this.zzblu, this.zzblv, this.zzblw, this.zzblx);
        this.zzbly = this.zzblu;
        this.zzblz = this.zzblv;
        this.zzbma = this.zzblw;
        this.zzbmb = this.zzblx;
    }

    private final void zzjn() {
        if (this.zzbly == -1 && this.zzblz == -1) {
            return;
        }
        this.zzbld.zzb(this.zzblu, this.zzblv, this.zzblw, this.zzblx);
    }

    private final void zzjo() {
        if (this.zzblq > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbld.zzf(this.zzblq, jElapsedRealtime - this.zzblp);
            this.zzblq = 0;
            this.zzblp = jElapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzpq.SDK_INT < 23 || this.zzalm) {
            return false;
        }
        return !z || zzpt.zzc(this.zzvr);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhx
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzbln || (((surface = this.zzbll) != null && this.zzblk == surface) || zzhe() == null))) {
            this.zzblo = -9223372036854775807L;
            return true;
        }
        if (this.zzblo == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.zzblo) {
            return true;
        }
        this.zzblo = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.zzblu = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.zzblv = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        this.zzblx = this.zzblt;
        if (zzpq.SDK_INT >= 21) {
            int i = this.zzbls;
            if (i == 90 || i == 270) {
                int i2 = this.zzblu;
                this.zzblu = this.zzblv;
                this.zzblv = i2;
                this.zzblx = 1.0f / this.zzblx;
            }
        } else {
            this.zzblw = this.zzbls;
        }
        mediaCodec.setVideoScalingMode(this.zzblm);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void onStarted() {
        super.onStarted();
        this.zzblq = 0;
        this.zzblp = SystemClock.elapsedRealtime();
        this.zzblo = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void onStopped() {
        zzjo();
        super.onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final int zza(zzlw zzlwVar, zzho zzhoVar) throws zzlz {
        boolean z;
        int i;
        int i2;
        String str = zzhoVar.zzahc;
        if (!zzpg.zzbg(str)) {
            return 0;
        }
        zzjn zzjnVar = zzhoVar.zzahf;
        if (zzjnVar != null) {
            z = false;
            for (int i3 = 0; i3 < zzjnVar.zzaol; i3++) {
                z |= zzjnVar.zzag(i3).zzaom;
            }
        } else {
            z = false;
        }
        zzlr zzlrVarZzc = zzlwVar.zzc(str, z);
        if (zzlrVarZzc == null) {
            return 1;
        }
        boolean zZzbc = zzlrVarZzc.zzbc(zzhoVar.zzagz);
        if (zZzbc && (i = zzhoVar.width) > 0 && (i2 = zzhoVar.height) > 0) {
            if (zzpq.SDK_INT >= 21) {
                zZzbc = zzlrVarZzc.zza(i, i2, zzhoVar.zzahg);
            } else {
                zZzbc = i * i2 <= zzly.zzhk();
                if (!zZzbc) {
                    int i4 = zzhoVar.width;
                    int i5 = zzhoVar.height;
                    String str2 = zzpq.zzbkm;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i4);
                    sb.append("x");
                    sb.append(i5);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        return (zZzbc ? 3 : 2) | (zzlrVarZzc.zzbbe ? 8 : 4) | (zzlrVarZzc.zzalm ? 16 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zzc(String str, long j, long j2) {
        this.zzbld.zzb(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zzd(zzho zzhoVar) throws zzhd {
        super.zzd(zzhoVar);
        this.zzbld.zzc(zzhoVar);
        float f2 = zzhoVar.zzahi;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.zzblt = f2;
        this.zzbls = zzj(zzhoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void zze(boolean z) throws zzhd {
        super.zze(z);
        this.zzaif = zzei().zzaif;
        this.zzalm = this.zzaif != 0;
        this.zzbld.zzc(this.zzbcv);
        this.zzblc.enable();
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void zzeh() {
        this.zzblu = -1;
        this.zzblv = -1;
        this.zzblx = -1.0f;
        this.zzblt = -1.0f;
        this.zzbmd = -9223372036854775807L;
        this.zzbme = 0;
        zzjl();
        zzjj();
        this.zzblc.disable();
        this.zzbmc = null;
        this.zzalm = false;
        try {
            super.zzeh();
        } finally {
            this.zzbcv.zzgn();
            this.zzbld.zzd(this.zzbcv);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zzhg() {
        try {
            super.zzhg();
        } finally {
            Surface surface = this.zzbll;
            if (surface != null) {
                if (this.zzblk == surface) {
                    this.zzblk = null;
                }
                this.zzbll.release();
                this.zzbll = null;
            }
        }
    }

    final void zzjk() {
        if (this.zzbln) {
            return;
        }
        this.zzbln = true;
        this.zzbld.zzb(this.zzblk);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzpx(Context context, zzlw zzlwVar, long j, zzjs<zzju> zzjsVar, boolean z, Handler handler, zzqd zzqdVar, int i) {
        super(2, zzlwVar, null, false);
        boolean z2 = false;
        this.zzble = 0L;
        this.zzblf = -1;
        this.zzvr = context.getApplicationContext();
        this.zzblc = new zzqb(context);
        this.zzbld = new zzqg(handler, zzqdVar);
        if (zzpq.SDK_INT <= 22 && "foster".equals(zzpq.DEVICE) && "NVIDIA".equals(zzpq.MANUFACTURER)) {
            z2 = true;
        }
        this.zzblg = z2;
        this.zzblh = new long[10];
        this.zzbmd = -9223372036854775807L;
        this.zzblo = -9223372036854775807L;
        this.zzblu = -1;
        this.zzblv = -1;
        this.zzblx = -1.0f;
        this.zzblt = -1.0f;
        this.zzblm = 1;
        zzjl();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    protected final void zza(zzho[] zzhoVarArr, long j) throws zzhd {
        this.zzbli = zzhoVarArr;
        if (this.zzbmd == -9223372036854775807L) {
            this.zzbmd = j;
        } else {
            int i = this.zzbme;
            long[] jArr = this.zzblh;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbme = i + 1;
            }
            this.zzblh[this.zzbme - 1] = j;
        }
        super.zza(zzhoVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzhb
    protected final void zza(long j, boolean z) throws zzhd {
        super.zza(j, z);
        zzjj();
        this.zzblr = 0;
        int i = this.zzbme;
        if (i != 0) {
            this.zzbmd = this.zzblh[i - 1];
            this.zzbme = 0;
        }
        if (z) {
            zzji();
        } else {
            this.zzblo = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhe
    public final void zza(int i, Object obj) throws zzhd {
        if (i != 1) {
            if (i == 4) {
                this.zzblm = ((Integer) obj).intValue();
                MediaCodec mediaCodecZzhe = zzhe();
                if (mediaCodecZzhe != null) {
                    mediaCodecZzhe.setVideoScalingMode(this.zzblm);
                    return;
                }
                return;
            }
            super.zza(i, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.zzbll;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzlr zzlrVarZzhf = zzhf();
                if (zzlrVarZzhf != null && zzn(zzlrVarZzhf.zzbbf)) {
                    this.zzbll = zzpt.zzc(this.zzvr, zzlrVarZzhf.zzbbf);
                    surface = this.zzbll;
                }
            }
        }
        if (this.zzblk != surface) {
            this.zzblk = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec mediaCodecZzhe2 = zzhe();
                if (zzpq.SDK_INT >= 23 && mediaCodecZzhe2 != null && surface != null) {
                    mediaCodecZzhe2.setOutputSurface(surface);
                } else {
                    zzhg();
                    zzhd();
                }
            }
            if (surface != null && surface != this.zzbll) {
                zzjn();
                zzjj();
                if (state == 2) {
                    zzji();
                    return;
                }
                return;
            }
            zzjl();
            zzjj();
            return;
        }
        if (surface == null || surface == this.zzbll) {
            return;
        }
        zzjn();
        if (this.zzbln) {
            this.zzbld.zzb(this.zzblk);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final boolean zza(zzlr zzlrVar) {
        return this.zzblk != null || zzn(zzlrVar.zzbbf);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zza(zzlr zzlrVar, MediaCodec mediaCodec, zzho zzhoVar, MediaCrypto mediaCrypto) throws zzlz {
        zzpz zzpzVar;
        int i;
        Point point;
        float f2;
        zzho[] zzhoVarArr = this.zzbli;
        int i2 = zzhoVar.width;
        int i3 = zzhoVar.height;
        int iZzi = zzi(zzhoVar);
        if (zzhoVarArr.length == 1) {
            zzpzVar = new zzpz(i2, i3, iZzi);
        } else {
            int iMax = i3;
            int iMax2 = iZzi;
            boolean z = false;
            int iMax3 = i2;
            for (zzho zzhoVar2 : zzhoVarArr) {
                if (zza(zzlrVar.zzbbe, zzhoVar, zzhoVar2)) {
                    z |= zzhoVar2.width == -1 || zzhoVar2.height == -1;
                    iMax3 = Math.max(iMax3, zzhoVar2.width);
                    int iMax4 = Math.max(iMax, zzhoVar2.height);
                    iMax2 = Math.max(iMax2, zzi(zzhoVar2));
                    iMax = iMax4;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(iMax3);
                sb.append("x");
                sb.append(iMax);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzhoVar.height > zzhoVar.width;
                int i4 = z2 ? zzhoVar.height : zzhoVar.width;
                int i5 = z2 ? zzhoVar.width : zzhoVar.height;
                float f3 = i5 / i4;
                int[] iArr = zzblb;
                int length = iArr.length;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = length;
                    int i8 = iArr[i6];
                    int[] iArr2 = iArr;
                    int i9 = (int) (i8 * f3);
                    if (i8 <= i4 || i9 <= i5) {
                        break;
                    }
                    int i10 = i4;
                    int i11 = i5;
                    if (zzpq.SDK_INT >= 21) {
                        int i12 = z2 ? i9 : i8;
                        if (z2) {
                            i9 = i8;
                        }
                        Point pointZzd = zzlrVar.zzd(i12, i9);
                        i = iMax2;
                        f2 = f3;
                        if (zzlrVar.zza(pointZzd.x, pointZzd.y, zzhoVar.zzahg)) {
                            point = pointZzd;
                            break;
                        }
                        i6++;
                        length = i7;
                        iArr = iArr2;
                        i4 = i10;
                        i5 = i11;
                        iMax2 = i;
                        f3 = f2;
                    } else {
                        i = iMax2;
                        f2 = f3;
                        int iZzf = zzpq.zzf(i8, 16) << 4;
                        int iZzf2 = zzpq.zzf(i9, 16) << 4;
                        if (iZzf * iZzf2 <= zzly.zzhk()) {
                            int i13 = z2 ? iZzf2 : iZzf;
                            if (z2) {
                                iZzf2 = iZzf;
                            }
                            point = new Point(i13, iZzf2);
                        } else {
                            i6++;
                            length = i7;
                            iArr = iArr2;
                            i4 = i10;
                            i5 = i11;
                            iMax2 = i;
                            f3 = f2;
                        }
                    }
                }
                i = iMax2;
                point = null;
                if (point != null) {
                    iMax3 = Math.max(iMax3, point.x);
                    iMax = Math.max(iMax, point.y);
                    iMax2 = Math.max(i, zza(zzhoVar.zzahc, iMax3, iMax));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(iMax3);
                    sb2.append("x");
                    sb2.append(iMax);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                } else {
                    iMax2 = i;
                }
            }
            zzpzVar = new zzpz(iMax3, iMax, iMax2);
        }
        this.zzblj = zzpzVar;
        zzpz zzpzVar2 = this.zzblj;
        boolean z3 = this.zzblg;
        int i14 = this.zzaif;
        MediaFormat mediaFormatZzfa = zzhoVar.zzfa();
        mediaFormatZzfa.setInteger("max-width", zzpzVar2.width);
        mediaFormatZzfa.setInteger("max-height", zzpzVar2.height);
        int i15 = zzpzVar2.zzbmf;
        if (i15 != -1) {
            mediaFormatZzfa.setInteger("max-input-size", i15);
        }
        if (z3) {
            mediaFormatZzfa.setInteger("auto-frc", 0);
        }
        if (i14 != 0) {
            mediaFormatZzfa.setFeatureEnabled("tunneled-playback", true);
            mediaFormatZzfa.setInteger("audio-session-id", i14);
        }
        if (this.zzblk == null) {
            zzoz.checkState(zzn(zzlrVar.zzbbf));
            if (this.zzbll == null) {
                this.zzbll = zzpt.zzc(this.zzvr, zzlrVar.zzbbf);
            }
            this.zzblk = this.zzbll;
        }
        mediaCodec.configure(mediaFormatZzfa, this.zzblk, (MediaCrypto) null, 0);
        if (zzpq.SDK_INT < 23 || !this.zzalm) {
            return;
        }
        this.zzbmc = new zzqc(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final void zza(zzjk zzjkVar) {
        if (zzpq.SDK_INT >= 23 || !this.zzalm) {
            return;
        }
        zzjk();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final boolean zza(MediaCodec mediaCodec, boolean z, zzho zzhoVar, zzho zzhoVar2) {
        if (!zza(z, zzhoVar, zzhoVar2)) {
            return false;
        }
        int i = zzhoVar2.width;
        zzpz zzpzVar = this.zzblj;
        return i <= zzpzVar.width && zzhoVar2.height <= zzpzVar.height && zzhoVar2.zzahd <= zzpzVar.zzbmf;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    protected final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzbme;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzblh;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzbmd = jArr[0];
            this.zzbme = i3 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.zzbme);
        }
        long j4 = j3 - this.zzbmd;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzblk == this.zzbll) {
            if (!zzem(j5)) {
                return false;
            }
            zza(mediaCodec, i, j4);
            return true;
        }
        if (!this.zzbln) {
            if (zzpq.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long jElapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long jNanoTime = System.nanoTime();
        long jZzf = this.zzblc.zzf(j3, (jElapsedRealtime * 1000) + jNanoTime);
        long j6 = (jZzf - jNanoTime) / 1000;
        if (zzem(j6)) {
            zzpn.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzpn.endSection();
            zzjl zzjlVar = this.zzbcv;
            zzjlVar.zzaoi++;
            this.zzblq++;
            this.zzblr++;
            zzjlVar.zzaoj = Math.max(this.zzblr, zzjlVar.zzaoj);
            if (this.zzblq == this.zzblf) {
                zzjo();
            }
            return true;
        }
        if (zzpq.SDK_INT >= 21) {
            if (j6 < 50000) {
                zza(mediaCodec, i, j4, jZzf);
                return true;
            }
        } else if (j6 < ab.R) {
            if (j6 > 11000) {
                try {
                    Thread.sleep((j6 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            zzb(mediaCodec, i, j4);
            return true;
        }
        return false;
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzpn.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpn.endSection();
        this.zzbcv.zzaoh++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjm();
        zzpn.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpn.endSection();
        this.zzbcv.zzaog++;
        this.zzblr = 0;
        zzjk();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zza(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L86
            if (r9 != r0) goto L7
            goto L86
        L7:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 3
            r5 = 4
            r6 = 2
            switch(r1) {
                case -1664118616: goto L46;
                case -1662541442: goto L3c;
                case 1187890754: goto L32;
                case 1331836730: goto L28;
                case 1599127256: goto L1e;
                case 1599127257: goto L14;
                default: goto L13;
            }
        L13:
            goto L50
        L14:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L50
            r7 = 5
            goto L51
        L1e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L50
            r7 = 3
            goto L51
        L28:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L50
            r7 = 2
            goto L51
        L32:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L50
            r7 = 1
            goto L51
        L3c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L50
            r7 = 4
            goto L51
        L46:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L50
            r7 = 0
            goto L51
        L50:
            r7 = -1
        L51:
            if (r7 == 0) goto L7d
            if (r7 == r3) goto L7d
            if (r7 == r6) goto L61
            if (r7 == r4) goto L7d
            if (r7 == r5) goto L5e
            if (r7 == r2) goto L5e
            return r0
        L5e:
            int r8 = r8 * r9
            goto L80
        L61:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzpq.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L6c
            return r0
        L6c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzpq.zzf(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzpq.zzf(r9, r7)
            int r8 = r8 * r7
            int r7 = r8 << 4
            int r8 = r7 << 4
            goto L7f
        L7d:
            int r8 = r8 * r9
        L7f:
            r5 = 2
        L80:
            int r8 = r8 * 3
            int r5 = r5 * 2
            int r8 = r8 / r5
            return r8
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpx.zza(java.lang.String, int, int):int");
    }

    private static boolean zza(boolean z, zzho zzhoVar, zzho zzhoVar2) {
        if (!zzhoVar.zzahc.equals(zzhoVar2.zzahc) || zzj(zzhoVar) != zzj(zzhoVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzhoVar.width == zzhoVar2.width && zzhoVar.height == zzhoVar2.height;
    }
}
