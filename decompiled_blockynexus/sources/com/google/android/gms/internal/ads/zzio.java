package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.tendcloud.tenddata.ab;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzio {
    private static boolean zzajn;
    private static boolean zzajo;
    private int streamType;
    private zzhu zzafh;
    private int zzahn;
    private final zziz zzajq;
    private final zzje zzajr;
    private final zzie[] zzajs;
    private final zziu zzajt;
    private final long[] zzajv;
    private final zziq zzajw;
    private final LinkedList<zzix> zzajx;
    private AudioTrack zzajy;
    private int zzajz;
    private int zzaka;
    private int zzakb;
    private boolean zzakc;
    private int zzakd;
    private long zzake;
    private zzhu zzakf;
    private long zzakg;
    private long zzakh;
    private ByteBuffer zzaki;
    private int zzakj;
    private int zzakk;
    private int zzakl;
    private long zzakm;
    private long zzakn;
    private boolean zzako;
    private long zzakp;
    private Method zzakq;
    private int zzakr;
    private long zzaks;
    private long zzakt;
    private int zzaku;
    private long zzakv;
    private long zzakw;
    private int zzakx;
    private int zzaky;
    private long zzakz;
    private long zzala;
    private long zzalb;
    private zzie[] zzalc;
    private ByteBuffer[] zzald;
    private ByteBuffer zzale;
    private ByteBuffer zzalf;
    private byte[] zzalg;
    private int zzalh;
    private int zzali;
    private boolean zzalj;
    private boolean zzalk;
    private int zzall;
    private boolean zzalm;
    private boolean zzaln;
    private long zzalo;
    private float zzdj;
    private final zzif zzajp = null;
    private final ConditionVariable zzaju = new ConditionVariable(true);

    public zzio(zzif zzifVar, zzie[] zzieVarArr, zziu zziuVar) {
        zzir zzirVar = null;
        this.zzajt = zziuVar;
        if (zzpq.SDK_INT >= 18) {
            try {
                this.zzakq = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpq.SDK_INT >= 19) {
            this.zzajw = new zzit();
        } else {
            this.zzajw = new zziq(zzirVar);
        }
        this.zzajq = new zziz();
        this.zzajr = new zzje();
        this.zzajs = new zzie[zzieVarArr.length + 3];
        this.zzajs[0] = new zzjc();
        zzie[] zzieVarArr2 = this.zzajs;
        zzieVarArr2[1] = this.zzajq;
        System.arraycopy(zzieVarArr, 0, zzieVarArr2, 2, zzieVarArr.length);
        this.zzajs[zzieVarArr.length + 2] = this.zzajr;
        this.zzajv = new long[10];
        this.zzdj = 1.0f;
        this.zzaky = 0;
        this.streamType = 3;
        this.zzall = 0;
        this.zzafh = zzhu.zzahz;
        this.zzali = -1;
        this.zzalc = new zzie[0];
        this.zzald = new ByteBuffer[0];
        this.zzajx = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzajy != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zzaz(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1095064472: goto L2a;
                case 187078296: goto L20;
                case 1504578661: goto L16;
                case 1505942594: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 3
            goto L35
        L16:
            java.lang.String r0 = "audio/eac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 1
            goto L35
        L20:
            java.lang.String r0 = "audio/ac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 0
            goto L35
        L2a:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 2
            goto L35
        L34:
            r5 = -1
        L35:
            if (r5 == 0) goto L45
            if (r5 == r4) goto L43
            if (r5 == r3) goto L41
            if (r5 == r2) goto L3e
            return r1
        L3e:
            r5 = 8
            return r5
        L41:
            r5 = 7
            return r5
        L43:
            r5 = 6
            return r5
        L45:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zzaz(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzc(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zziw {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zzc(java.nio.ByteBuffer, long):boolean");
    }

    private final void zzdv(long j) throws zziw {
        ByteBuffer byteBuffer;
        int length = this.zzalc.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzald[i - 1];
            } else {
                byteBuffer = this.zzale;
                if (byteBuffer == null) {
                    byteBuffer = zzie.zzaiy;
                }
            }
            if (i == length) {
                zzc(byteBuffer, j);
            } else {
                zzie zzieVar = this.zzalc[i];
                zzieVar.zzn(byteBuffer);
                ByteBuffer byteBufferZzfm = zzieVar.zzfm();
                this.zzald[i] = byteBufferZzfm;
                if (byteBufferZzfm.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private final long zzdw(long j) {
        return (j * 1000000) / ((long) this.zzahn);
    }

    private final long zzdx(long j) {
        return (j * ((long) this.zzahn)) / 1000000;
    }

    private final void zzfn() {
        ArrayList arrayList = new ArrayList();
        for (zzie zzieVar : this.zzajs) {
            if (zzieVar.isActive()) {
                arrayList.add(zzieVar);
            } else {
                zzieVar.flush();
            }
        }
        int size = arrayList.size();
        this.zzalc = (zzie[]) arrayList.toArray(new zzie[size]);
        this.zzald = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzie zzieVar2 = this.zzalc[i];
            zzieVar2.flush();
            this.zzald[i] = zzieVar2.zzfm();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzfq() throws com.google.android.gms.internal.ads.zziw {
        /*
            r9 = this;
            int r0 = r9.zzali
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.zzakc
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.zzie[] r0 = r9.zzalc
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r9.zzali = r0
        L12:
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.zzali
            com.google.android.gms.internal.ads.zzie[] r5 = r9.zzalc
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.zzfl()
        L28:
            r9.zzdv(r7)
            boolean r0 = r4.zzfe()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.zzali
            int r0 = r0 + r2
            r9.zzali = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.zzalf
            if (r0 == 0) goto L44
            r9.zzc(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzalf
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.zzali = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zzfq():boolean");
    }

    private final void zzfu() {
        if (isInitialized()) {
            if (zzpq.SDK_INT >= 21) {
                this.zzajy.setVolume(this.zzdj);
                return;
            }
            AudioTrack audioTrack = this.zzajy;
            float f2 = this.zzdj;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private final long zzfv() {
        return this.zzakc ? this.zzakw : this.zzakv / ((long) this.zzaku);
    }

    private final void zzfw() {
        this.zzakm = 0L;
        this.zzakl = 0;
        this.zzakk = 0;
        this.zzakn = 0L;
        this.zzako = false;
        this.zzakp = 0L;
    }

    private final boolean zzfx() {
        if (zzpq.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzakb;
        return i == 5 || i == 6;
    }

    public final void pause() {
        this.zzalk = false;
        if (isInitialized()) {
            zzfw();
            this.zzajw.pause();
        }
    }

    public final void play() {
        this.zzalk = true;
        if (isInitialized()) {
            this.zzala = System.nanoTime() / 1000;
            this.zzajy.play();
        }
    }

    public final void release() {
        reset();
        for (zzie zzieVar : this.zzajs) {
            zzieVar.reset();
        }
        this.zzall = 0;
        this.zzalk = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzaks = 0L;
            this.zzakt = 0L;
            this.zzakv = 0L;
            this.zzakw = 0L;
            this.zzakx = 0;
            zzhu zzhuVar = this.zzakf;
            if (zzhuVar != null) {
                this.zzafh = zzhuVar;
                this.zzakf = null;
            } else if (!this.zzajx.isEmpty()) {
                this.zzafh = this.zzajx.getLast().zzafh;
            }
            this.zzajx.clear();
            this.zzakg = 0L;
            this.zzakh = 0L;
            this.zzale = null;
            this.zzalf = null;
            int i = 0;
            while (true) {
                zzie[] zzieVarArr = this.zzalc;
                if (i >= zzieVarArr.length) {
                    break;
                }
                zzie zzieVar = zzieVarArr[i];
                zzieVar.flush();
                this.zzald[i] = zzieVar.zzfm();
                i++;
            }
            this.zzalj = false;
            this.zzali = -1;
            this.zzaki = null;
            this.zzakj = 0;
            this.zzaky = 0;
            this.zzalb = 0L;
            zzfw();
            if (this.zzajy.getPlayState() == 3) {
                this.zzajy.pause();
            }
            AudioTrack audioTrack = this.zzajy;
            this.zzajy = null;
            this.zzajw.zza(null, false);
            this.zzaju.close();
            new zzir(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType == i) {
            return;
        }
        this.streamType = i;
        if (this.zzalm) {
            return;
        }
        reset();
        this.zzall = 0;
    }

    public final void setVolume(float f2) {
        if (this.zzdj != f2) {
            this.zzdj = f2;
            zzfu();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzis {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzio.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean zzay(String str) {
        zzif zzifVar = this.zzajp;
        return zzifVar != null && zzifVar.zzw(zzaz(str));
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j) throws zziv, zziw {
        int i;
        int iZzo;
        ByteBuffer byteBuffer2 = this.zzale;
        zzoz.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            this.zzaju.block();
            if (this.zzalm) {
                this.zzajy = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzajz).setEncoding(this.zzakb).setSampleRate(this.zzahn).build(), this.zzakd, 1, this.zzall);
            } else {
                int i2 = this.zzall;
                if (i2 == 0) {
                    this.zzajy = new AudioTrack(this.streamType, this.zzahn, this.zzajz, this.zzakb, this.zzakd, 1);
                } else {
                    this.zzajy = new AudioTrack(this.streamType, this.zzahn, this.zzajz, this.zzakb, this.zzakd, 1, i2);
                }
            }
            int state = this.zzajy.getState();
            if (state != 1) {
                try {
                    this.zzajy.release();
                } catch (Exception unused) {
                } finally {
                    this.zzajy = null;
                }
                throw new zziv(state, this.zzahn, this.zzajz, this.zzakd);
            }
            int audioSessionId = this.zzajy.getAudioSessionId();
            if (this.zzall != audioSessionId) {
                this.zzall = audioSessionId;
                this.zzajt.zzx(audioSessionId);
            }
            this.zzajw.zza(this.zzajy, zzfx());
            zzfu();
            this.zzaln = false;
            if (this.zzalk) {
                play();
            }
        }
        if (zzfx()) {
            if (this.zzajy.getPlayState() == 2) {
                this.zzaln = false;
                return false;
            }
            if (this.zzajy.getPlayState() == 1 && this.zzajw.zzfy() != 0) {
                return false;
            }
        }
        boolean z = this.zzaln;
        this.zzaln = zzfr();
        if (z && !this.zzaln && this.zzajy.getPlayState() != 1) {
            this.zzajt.zzc(this.zzakd, zzha.zzdm(this.zzake), SystemClock.elapsedRealtime() - this.zzalo);
        }
        if (this.zzale == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzakc && this.zzakx == 0) {
                int i3 = this.zzakb;
                if (i3 == 7 || i3 == 8) {
                    iZzo = zziy.zzo(byteBuffer);
                } else if (i3 == 5) {
                    iZzo = zzic.zzfi();
                } else {
                    if (i3 != 6) {
                        StringBuilder sb = new StringBuilder(38);
                        sb.append("Unexpected audio encoding: ");
                        sb.append(i3);
                        throw new IllegalStateException(sb.toString());
                    }
                    iZzo = zzic.zzm(byteBuffer);
                }
                this.zzakx = iZzo;
            }
            if (this.zzakf != null) {
                if (!zzfq()) {
                    return false;
                }
                this.zzajx.add(new zzix(this.zzakf, Math.max(0L, j), zzdw(zzfv()), null));
                this.zzakf = null;
                zzfn();
            }
            if (this.zzaky == 0) {
                this.zzakz = Math.max(0L, j);
                this.zzaky = 1;
            } else {
                long jZzdw = this.zzakz + zzdw(this.zzakc ? this.zzakt : this.zzaks / ((long) this.zzakr));
                if (this.zzaky != 1 || Math.abs(jZzdw - j) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(jZzdw);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzaky = 2;
                }
                if (this.zzaky == i) {
                    this.zzakz += j - jZzdw;
                    this.zzaky = 1;
                    this.zzajt.zzen();
                }
            }
            if (this.zzakc) {
                this.zzakt += (long) this.zzakx;
            } else {
                this.zzaks += (long) byteBuffer.remaining();
            }
            this.zzale = byteBuffer;
        }
        if (this.zzakc) {
            zzc(this.zzale, j);
        } else {
            zzdv(j);
        }
        if (this.zzale.hasRemaining()) {
            return false;
        }
        this.zzale = null;
        return true;
    }

    public final boolean zzfe() {
        if (isInitialized()) {
            return this.zzalj && !zzfr();
        }
        return true;
    }

    public final void zzfo() {
        if (this.zzaky == 1) {
            this.zzaky = 2;
        }
    }

    public final void zzfp() throws zziw {
        if (!this.zzalj && isInitialized() && zzfq()) {
            this.zzajw.zzdy(zzfv());
            this.zzakj = 0;
            this.zzalj = true;
        }
    }

    public final boolean zzfr() {
        if (isInitialized()) {
            if (zzfv() <= this.zzajw.zzfy()) {
                if (zzfx() && this.zzajy.getPlayState() == 2 && this.zzajy.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzhu zzfs() {
        return this.zzafh;
    }

    public final void zzft() {
        if (this.zzalm) {
            this.zzalm = false;
            this.zzall = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long jZzfz;
        long j;
        long jZza;
        long j2;
        if (!(isInitialized() && this.zzaky != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzajy.getPlayState() == 3) {
            long jZzfz2 = this.zzajw.zzfz();
            if (jZzfz2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.zzakn >= ab.R) {
                    long[] jArr = this.zzajv;
                    int i = this.zzakk;
                    jArr[i] = jZzfz2 - jNanoTime;
                    this.zzakk = (i + 1) % 10;
                    int i2 = this.zzakl;
                    if (i2 < 10) {
                        this.zzakl = i2 + 1;
                    }
                    this.zzakn = jNanoTime;
                    this.zzakm = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzakl;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzakm += this.zzajv[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzfx() && jNanoTime - this.zzakp >= 500000) {
                    this.zzako = this.zzajw.zzga();
                    if (this.zzako) {
                        long jZzgb = this.zzajw.zzgb() / 1000;
                        long jZzgc = this.zzajw.zzgc();
                        if (jZzgb < this.zzala) {
                            this.zzako = false;
                        } else if (Math.abs(jZzgb - jNanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(jZzgc);
                            sb.append(", ");
                            sb.append(jZzgb);
                            sb.append(", ");
                            sb.append(jNanoTime);
                            sb.append(", ");
                            sb.append(jZzfz2);
                            Log.w("AudioTrack", sb.toString());
                            this.zzako = false;
                        } else if (Math.abs(zzdw(jZzgc) - jZzfz2) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(jZzgc);
                            sb2.append(", ");
                            sb2.append(jZzgb);
                            sb2.append(", ");
                            sb2.append(jNanoTime);
                            sb2.append(", ");
                            sb2.append(jZzfz2);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzako = false;
                        }
                    }
                    Method method = this.zzakq;
                    if (method != null && !this.zzakc) {
                        try {
                            this.zzalb = (((long) ((Integer) method.invoke(this.zzajy, null)).intValue()) * 1000) - this.zzake;
                            this.zzalb = Math.max(this.zzalb, 0L);
                            if (this.zzalb > 5000000) {
                                long j3 = this.zzalb;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j3);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzalb = 0L;
                            }
                        } catch (Exception unused) {
                            this.zzakq = null;
                        }
                    }
                    this.zzakp = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        if (this.zzako) {
            jZzfz = zzdw(this.zzajw.zzgc() + zzdx(jNanoTime2 - (this.zzajw.zzgb() / 1000)));
        } else {
            jZzfz = this.zzakl == 0 ? this.zzajw.zzfz() : jNanoTime2 + this.zzakm;
            if (!z) {
                jZzfz -= this.zzalb;
            }
        }
        long j4 = this.zzakz;
        while (!this.zzajx.isEmpty() && jZzfz >= this.zzajx.getFirst().zzagv) {
            zzix zzixVarRemove = this.zzajx.remove();
            this.zzafh = zzixVarRemove.zzafh;
            this.zzakh = zzixVarRemove.zzagv;
            this.zzakg = zzixVarRemove.zzame - this.zzakz;
        }
        if (this.zzafh.zzaia == 1.0f) {
            j2 = (jZzfz + this.zzakg) - this.zzakh;
        } else {
            if (!this.zzajx.isEmpty() || this.zzajr.zzgg() < 1024) {
                j = this.zzakg;
                double d2 = this.zzafh.zzaia;
                double d3 = jZzfz - this.zzakh;
                Double.isNaN(d2);
                Double.isNaN(d3);
                jZza = (long) (d2 * d3);
            } else {
                j = this.zzakg;
                jZza = zzpq.zza(jZzfz - this.zzakh, this.zzajr.zzgf(), this.zzajr.zzgg());
            }
            j2 = jZza + j;
        }
        return j4 + j2;
    }

    public final void zzz(int i) {
        zzoz.checkState(zzpq.SDK_INT >= 21);
        if (this.zzalm && this.zzall == i) {
            return;
        }
        this.zzalm = true;
        this.zzall = i;
        reset();
    }

    public final zzhu zzb(zzhu zzhuVar) {
        if (this.zzakc) {
            this.zzafh = zzhu.zzahz;
            return this.zzafh;
        }
        zzhu zzhuVar2 = new zzhu(this.zzajr.zza(zzhuVar.zzaia), this.zzajr.zzb(zzhuVar.zzaib));
        zzhu zzhuVar3 = this.zzakf;
        if (zzhuVar3 == null) {
            if (!this.zzajx.isEmpty()) {
                zzhuVar3 = this.zzajx.getLast().zzafh;
            } else {
                zzhuVar3 = this.zzafh;
            }
        }
        if (!zzhuVar2.equals(zzhuVar3)) {
            if (isInitialized()) {
                this.zzakf = zzhuVar2;
            } else {
                this.zzafh = zzhuVar2;
            }
        }
        return this.zzafh;
    }
}
