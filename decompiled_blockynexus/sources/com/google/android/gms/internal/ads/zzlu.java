package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public abstract class zzlu extends zzhb {
    private static final byte[] zzbbl = zzpq.zzbm("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzho zzahx;
    private ByteBuffer[] zzald;
    private final zzlw zzbbm;
    private final zzjs<zzju> zzbbn;
    private final boolean zzbbo;
    private final zzjk zzbbp;
    private final zzjk zzbbq;
    private final zzhq zzbbr;
    private final List<Long> zzbbs;
    private final MediaCodec.BufferInfo zzbbt;
    private zzjq<zzju> zzbbu;
    private zzjq<zzju> zzbbv;
    private MediaCodec zzbbw;
    private zzlr zzbbx;
    private boolean zzbby;
    private boolean zzbbz;
    private boolean zzbca;
    private boolean zzbcb;
    private boolean zzbcc;
    private boolean zzbcd;
    private boolean zzbce;
    private boolean zzbcf;
    private boolean zzbcg;
    private ByteBuffer[] zzbch;
    private long zzbci;
    private int zzbcj;
    private int zzbck;
    private boolean zzbcl;
    private boolean zzbcm;
    private int zzbcn;
    private int zzbco;
    private boolean zzbcp;
    private boolean zzbcq;
    private boolean zzbcr;
    private boolean zzbcs;
    private boolean zzbct;
    private boolean zzbcu;
    protected zzjl zzbcv;

    public zzlu(int i, zzlw zzlwVar, zzjs<zzju> zzjsVar, boolean z) {
        super(i);
        zzoz.checkState(zzpq.SDK_INT >= 16);
        zzoz.checkNotNull(zzlwVar);
        this.zzbbm = zzlwVar;
        this.zzbbn = zzjsVar;
        this.zzbbo = z;
        this.zzbbp = new zzjk(0);
        this.zzbbq = new zzjk(0);
        this.zzbbr = new zzhq();
        this.zzbbs = new ArrayList();
        this.zzbbt = new MediaCodec.BufferInfo();
        this.zzbcn = 0;
        this.zzbco = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzhh() throws com.google.android.gms.internal.ads.zzhd {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzhh():boolean");
    }

    private final void zzhi() throws zzhd {
        if (this.zzbco == 2) {
            zzhg();
            zzhd();
        } else {
            this.zzbcs = true;
            zzge();
        }
    }

    public boolean isReady() {
        if (this.zzahx == null || this.zzbct) {
            return false;
        }
        if (zzej() || this.zzbck >= 0) {
            return true;
        }
        return this.zzbci != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzbci;
    }

    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    protected void onStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    protected void onStopped() {
    }

    @Override // com.google.android.gms.internal.ads.zzhw
    public final int zza(zzho zzhoVar) throws zzhd {
        try {
            return zza(this.zzbbm, zzhoVar);
        } catch (zzlz e2) {
            throw zzhd.zza(e2, getIndex());
        }
    }

    protected abstract int zza(zzlw zzlwVar, zzho zzhoVar) throws zzlz;

    protected void zza(zzjk zzjkVar) {
    }

    protected abstract void zza(zzlr zzlrVar, MediaCodec mediaCodec, zzho zzhoVar, MediaCrypto mediaCrypto) throws zzlz;

    protected abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhd;

    protected boolean zza(MediaCodec mediaCodec, boolean z, zzho zzhoVar, zzho zzhoVar2) {
        return false;
    }

    protected boolean zza(zzlr zzlrVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzb(long j, long j2) throws zzhd {
        if (this.zzbcs) {
            zzge();
            return;
        }
        if (this.zzahx == null) {
            this.zzbbq.clear();
            int iZza = zza(this.zzbbr, this.zzbbq, true);
            if (iZza != -5) {
                if (iZza == -4) {
                    zzoz.checkState(this.zzbbq.zzgl());
                    this.zzbcr = true;
                    zzhi();
                    return;
                }
                return;
            }
            zzd(this.zzbbr.zzahx);
        }
        zzhd();
        if (this.zzbbw != null) {
            zzpn.beginSection("drainAndFeed");
            while (zzd(j, j2)) {
            }
            while (zzhh()) {
            }
            zzpn.endSection();
        } else {
            zzdp(j);
            this.zzbbq.clear();
            int iZza2 = zza(this.zzbbr, this.zzbbq, false);
            if (iZza2 == -5) {
                zzd(this.zzbbr.zzahx);
            } else if (iZza2 == -4) {
                zzoz.checkState(this.zzbbq.zzgl());
                this.zzbcr = true;
                zzhi();
            }
        }
        this.zzbcv.zzgn();
    }

    protected void zzc(String str, long j, long j2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void zzd(com.google.android.gms.internal.ads.zzho r5) throws com.google.android.gms.internal.ads.zzhd {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzho r0 = r4.zzahx
            r4.zzahx = r5
            com.google.android.gms.internal.ads.zzho r5 = r4.zzahx
            com.google.android.gms.internal.ads.zzjn r5 = r5.zzahf
            r1 = 0
            if (r0 != 0) goto Ld
            r2 = r1
            goto Lf
        Ld:
            com.google.android.gms.internal.ads.zzjn r2 = r0.zzahf
        Lf:
            boolean r5 = com.google.android.gms.internal.ads.zzpq.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L4d
            com.google.android.gms.internal.ads.zzho r5 = r4.zzahx
            com.google.android.gms.internal.ads.zzjn r5 = r5.zzahf
            if (r5 == 0) goto L4b
            com.google.android.gms.internal.ads.zzjs<com.google.android.gms.internal.ads.zzju> r5 = r4.zzbbn
            if (r5 == 0) goto L3b
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzho r3 = r4.zzahx
            com.google.android.gms.internal.ads.zzjn r3 = r3.zzahf
            com.google.android.gms.internal.ads.zzjq r5 = r5.zza(r1, r3)
            r4.zzbbv = r5
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r5 = r4.zzbbv
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r1 = r4.zzbbu
            if (r5 != r1) goto L4d
            com.google.android.gms.internal.ads.zzjs<com.google.android.gms.internal.ads.zzju> r1 = r4.zzbbn
            r1.zza(r5)
            goto L4d
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.google.android.gms.internal.ads.zzhd r5 = com.google.android.gms.internal.ads.zzhd.zza(r5, r0)
            throw r5
        L4b:
            r4.zzbbv = r1
        L4d:
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r5 = r4.zzbbv
            com.google.android.gms.internal.ads.zzjq<com.google.android.gms.internal.ads.zzju> r1 = r4.zzbbu
            if (r5 != r1) goto L7e
            android.media.MediaCodec r5 = r4.zzbbw
            if (r5 == 0) goto L7e
            com.google.android.gms.internal.ads.zzlr r1 = r4.zzbbx
            boolean r1 = r1.zzbbe
            com.google.android.gms.internal.ads.zzho r3 = r4.zzahx
            boolean r5 = r4.zza(r5, r1, r0, r3)
            if (r5 == 0) goto L7e
            r4.zzbcm = r2
            r4.zzbcn = r2
            boolean r5 = r4.zzbca
            if (r5 == 0) goto L7a
            com.google.android.gms.internal.ads.zzho r5 = r4.zzahx
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L7a
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L7a
            goto L7b
        L7a:
            r2 = 0
        L7b:
            r4.zzbcf = r2
            return
        L7e:
            boolean r5 = r4.zzbcp
            if (r5 == 0) goto L85
            r4.zzbco = r2
            return
        L85:
            r4.zzhg()
            r4.zzhd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzd(com.google.android.gms.internal.ads.zzho):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    protected void zze(boolean z) throws zzhd {
        this.zzbcv = new zzjl();
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhw
    public final int zzeg() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    protected void zzeh() {
        this.zzahx = null;
        try {
            zzhg();
            try {
                if (this.zzbbu != null) {
                    this.zzbbn.zza(this.zzbbu);
                }
                try {
                    if (this.zzbbv != null && this.zzbbv != this.zzbbu) {
                        this.zzbbn.zza(this.zzbbv);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.zzbbv != null && this.zzbbv != this.zzbbu) {
                        this.zzbbn.zza(this.zzbbv);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.zzbbu != null) {
                    this.zzbbn.zza(this.zzbbu);
                }
                try {
                    if (this.zzbbv != null && this.zzbbv != this.zzbbu) {
                        this.zzbbn.zza(this.zzbbv);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.zzbbv != null && this.zzbbv != this.zzbbu) {
                        this.zzbbn.zza(this.zzbbv);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    public boolean zzfe() {
        return this.zzbcs;
    }

    protected void zzge() throws zzhd {
    }

    protected final void zzhd() throws zzhd {
        zzho zzhoVar;
        if (this.zzbbw != null || (zzhoVar = this.zzahx) == null) {
            return;
        }
        this.zzbbu = this.zzbbv;
        String str = zzhoVar.zzahc;
        zzjq<zzju> zzjqVar = this.zzbbu;
        if (zzjqVar != null) {
            int state = zzjqVar.getState();
            if (state == 0) {
                throw zzhd.zza(this.zzbbu.zzgp(), getIndex());
            }
            if (state == 3 || state == 4) {
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.zzbbx == null) {
            try {
                this.zzbbx = zza(this.zzbbm, zzhoVar, false);
                zzlr zzlrVar = this.zzbbx;
                if (this.zzbbx == null) {
                    zza(new zzlt(this.zzahx, (Throwable) null, false, -49999));
                    throw null;
                }
            } catch (zzlz e2) {
                zza(new zzlt(this.zzahx, (Throwable) e2, false, -49998));
                throw null;
            }
        }
        if (zza(this.zzbbx)) {
            String str2 = this.zzbbx.name;
            this.zzbby = zzpq.SDK_INT < 21 && this.zzahx.zzahe.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            int i = zzpq.SDK_INT;
            this.zzbbz = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzpq.SDK_INT == 19 && zzpq.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.zzbca = zzpq.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzpq.DEVICE) || "flounder_lte".equals(zzpq.DEVICE) || "grouper".equals(zzpq.DEVICE) || "tilapia".equals(zzpq.DEVICE));
            this.zzbcb = zzpq.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.zzbcc = (zzpq.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzpq.SDK_INT <= 19 && "hb2000".equals(zzpq.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.zzbcd = zzpq.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
            this.zzbce = zzpq.SDK_INT <= 18 && this.zzahx.zzahm == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strValueOf = String.valueOf(str2);
                zzpn.beginSection(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                this.zzbbw = MediaCodec.createByCodecName(str2);
                zzpn.endSection();
                zzpn.beginSection("configureCodec");
                zza(this.zzbbx, this.zzbbw, this.zzahx, (MediaCrypto) null);
                zzpn.endSection();
                zzpn.beginSection("startCodec");
                this.zzbbw.start();
                zzpn.endSection();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                zzc(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                this.zzbch = this.zzbbw.getInputBuffers();
                this.zzald = this.zzbbw.getOutputBuffers();
                this.zzbci = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.zzbcj = -1;
                this.zzbck = -1;
                this.zzbcu = true;
                this.zzbcv.zzaod++;
            } catch (Exception e3) {
                zza(new zzlt(this.zzahx, (Throwable) e3, false, str2));
                throw null;
            }
        }
    }

    protected final MediaCodec zzhe() {
        return this.zzbbw;
    }

    protected final zzlr zzhf() {
        return this.zzbbx;
    }

    protected void zzhg() {
        this.zzbci = -9223372036854775807L;
        this.zzbcj = -1;
        this.zzbck = -1;
        this.zzbct = false;
        this.zzbcl = false;
        this.zzbbs.clear();
        this.zzbch = null;
        this.zzald = null;
        this.zzbbx = null;
        this.zzbcm = false;
        this.zzbcp = false;
        this.zzbby = false;
        this.zzbbz = false;
        this.zzbca = false;
        this.zzbcb = false;
        this.zzbcc = false;
        this.zzbce = false;
        this.zzbcf = false;
        this.zzbcg = false;
        this.zzbcq = false;
        this.zzbcn = 0;
        this.zzbco = 0;
        this.zzbbp.zzdd = null;
        MediaCodec mediaCodec = this.zzbbw;
        if (mediaCodec != null) {
            this.zzbcv.zzaoe++;
            try {
                mediaCodec.stop();
                try {
                    this.zzbbw.release();
                    this.zzbbw = null;
                    zzjq<zzju> zzjqVar = this.zzbbu;
                    if (zzjqVar == null || this.zzbbv == zzjqVar) {
                        return;
                    }
                    try {
                        this.zzbbn.zza(zzjqVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.zzbbw = null;
                    zzjq<zzju> zzjqVar2 = this.zzbbu;
                    if (zzjqVar2 != null && this.zzbbv != zzjqVar2) {
                        try {
                            this.zzbbn.zza(zzjqVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.zzbbw.release();
                    this.zzbbw = null;
                    zzjq<zzju> zzjqVar3 = this.zzbbu;
                    if (zzjqVar3 != null && this.zzbbv != zzjqVar3) {
                        try {
                            this.zzbbn.zza(zzjqVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.zzbbw = null;
                    zzjq<zzju> zzjqVar4 = this.zzbbu;
                    if (zzjqVar4 != null && this.zzbbv != zzjqVar4) {
                        try {
                            this.zzbbn.zza(zzjqVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    protected zzlr zza(zzlw zzlwVar, zzho zzhoVar, boolean z) throws zzlz {
        return zzlwVar.zzc(zzhoVar.zzahc, z);
    }

    private final void zza(zzlt zzltVar) throws zzhd {
        throw zzhd.zza(zzltVar, getIndex());
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    protected void zza(long j, boolean z) throws zzhd {
        this.zzbcr = false;
        this.zzbcs = false;
        if (this.zzbbw != null) {
            this.zzbci = -9223372036854775807L;
            this.zzbcj = -1;
            this.zzbck = -1;
            this.zzbcu = true;
            this.zzbct = false;
            this.zzbcl = false;
            this.zzbbs.clear();
            this.zzbcf = false;
            this.zzbcg = false;
            if (this.zzbbz || ((this.zzbcc && this.zzbcq) || this.zzbco != 0)) {
                zzhg();
                zzhd();
            } else {
                this.zzbbw.flush();
                this.zzbcp = false;
            }
            if (!this.zzbcm || this.zzahx == null) {
                return;
            }
            this.zzbcn = 1;
        }
    }

    private final boolean zzd(long j, long j2) throws zzhd {
        boolean zZza;
        boolean z;
        if (this.zzbck < 0) {
            if (this.zzbcd && this.zzbcq) {
                try {
                    this.zzbck = this.zzbbw.dequeueOutputBuffer(this.zzbbt, 0L);
                } catch (IllegalStateException unused) {
                    zzhi();
                    if (this.zzbcs) {
                        zzhg();
                    }
                    return false;
                }
            } else {
                this.zzbck = this.zzbbw.dequeueOutputBuffer(this.zzbbt, 0L);
            }
            int i = this.zzbck;
            if (i < 0) {
                if (i != -2) {
                    if (i == -3) {
                        this.zzald = this.zzbbw.getOutputBuffers();
                        return true;
                    }
                    if (this.zzbcb && (this.zzbcr || this.zzbco == 2)) {
                        zzhi();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.zzbbw.getOutputFormat();
                if (this.zzbca && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == 32 && outputFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == 32) {
                    this.zzbcg = true;
                } else {
                    if (this.zzbce) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbbw, outputFormat);
                }
                return true;
            }
            if (this.zzbcg) {
                this.zzbcg = false;
                this.zzbbw.releaseOutputBuffer(i, false);
                this.zzbck = -1;
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.zzbbt;
            if ((bufferInfo.flags & 4) != 0) {
                zzhi();
                this.zzbck = -1;
                return false;
            }
            ByteBuffer byteBuffer = this.zzald[i];
            if (byteBuffer != null) {
                byteBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.zzbbt;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            long j3 = this.zzbbt.presentationTimeUs;
            int size = this.zzbbs.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (this.zzbbs.get(i2).longValue() == j3) {
                    this.zzbbs.remove(i2);
                    z = true;
                    break;
                }
                i2++;
            }
            this.zzbcl = z;
        }
        if (this.zzbcd && this.zzbcq) {
            try {
                zZza = zza(j, j2, this.zzbbw, this.zzald[this.zzbck], this.zzbck, this.zzbbt.flags, this.zzbbt.presentationTimeUs, this.zzbcl);
            } catch (IllegalStateException unused2) {
                zzhi();
                if (this.zzbcs) {
                    zzhg();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.zzbbw;
            ByteBuffer[] byteBufferArr = this.zzald;
            int i3 = this.zzbck;
            ByteBuffer byteBuffer2 = byteBufferArr[i3];
            MediaCodec.BufferInfo bufferInfo3 = this.zzbbt;
            zZza = zza(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzbcl);
        }
        if (!zZza) {
            return false;
        }
        long j4 = this.zzbbt.presentationTimeUs;
        this.zzbck = -1;
        return true;
    }
}
