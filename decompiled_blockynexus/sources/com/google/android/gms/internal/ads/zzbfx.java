package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfx extends zzbfl implements zzpa<zzom> {
    private String url;
    private ByteBuffer zzamm;
    private final zzbdv zzejr;
    private boolean zzema;
    private final zzbfu zzemg;
    private final zzbfd zzemh;
    private boolean zzemi;
    private final Object zzemj;
    private boolean zzemk;

    public zzbfx(zzbdu zzbduVar, zzbdv zzbdvVar) {
        super(zzbduVar);
        this.zzejr = zzbdvVar;
        this.zzemg = new zzbfu();
        this.zzemh = new zzbfd();
        this.zzemj = new Object();
    }

    private final void zzzk() {
        int iZzaay = (int) this.zzemg.zzaay();
        int iZzq = (int) this.zzemh.zzq(this.zzamm);
        int iPosition = this.zzamm.position();
        int iRound = Math.round(iZzq * (iPosition / iZzaay));
        boolean z = iRound > 0;
        int iZzaav = zzber.zzaav();
        int iZzaaw = zzber.zzaaw();
        String str = this.url;
        zza(str, zzfo(str), iPosition, iZzaay, iRound, iZzq, z, iZzaav, iZzaaw);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void abort() {
        this.zzema = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzemj) {
            if (this.zzamm != null && !this.zzemi) {
                this.zzamm.flip();
                this.zzemi = true;
            }
            this.zzema = true;
        }
        return this.zzamm;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* synthetic */ void zza(zzom zzomVar, zzon zzonVar) {
        zzom zzomVar2 = zzomVar;
        if (zzomVar2 instanceof zzop) {
            this.zzemg.zza((zzop) zzomVar2);
        }
    }

    public final boolean zzaba() {
        return this.zzemk;
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* bridge */ /* synthetic */ void zzc(zzom zzomVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* bridge */ /* synthetic */ void zze(zzom zzomVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b A[Catch: Exception -> 0x0032, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0032, blocks: (B:5:0x0028, B:11:0x004b, B:17:0x0098, B:42:0x00ef, B:43:0x010a, B:45:0x010d, B:46:0x0130), top: B:66:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9 A[Catch: Exception -> 0x013c, TRY_ENTER, TryCatch #1 {Exception -> 0x013c, blocks: (B:3:0x000d, B:9:0x0035, B:12:0x004e, B:13:0x0086, B:19:0x00a9, B:20:0x00ab), top: B:61:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:? -> B:53:0x013a). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzfn(java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfx.zzfn(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    protected final String zzfo(String str) {
        String strValueOf = String.valueOf(super.zzfo(str));
        return strValueOf.length() != 0 ? "cache:".concat(strValueOf) : new String("cache:");
    }
}
