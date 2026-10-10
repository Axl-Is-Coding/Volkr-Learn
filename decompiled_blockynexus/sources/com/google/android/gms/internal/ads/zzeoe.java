package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeoe implements zzbp {
    private static zzeoq zzdc = zzeoq.zzn(zzeoe.class);
    private String type;
    private long zzawn;
    private zzbs zzitn;
    private ByteBuffer zzitq;
    private long zzitr;
    private zzeok zzitt;
    private long zzits = -1;
    private ByteBuffer zzitu = null;
    private boolean zzitp = true;
    boolean zzito = true;

    protected zzeoe(String str) {
        this.type = str;
    }

    private final synchronized void zzbke() {
        if (!this.zzitp) {
            try {
                zzeoq zzeoqVar = zzdc;
                String strValueOf = String.valueOf(this.type);
                zzeoqVar.zzik(strValueOf.length() != 0 ? "mem mapping ".concat(strValueOf) : new String("mem mapping "));
                this.zzitq = this.zzitt.zzh(this.zzitr, this.zzits);
                this.zzitp = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzeok zzeokVar, ByteBuffer byteBuffer, long j, zzbo zzboVar) throws IOException {
        this.zzitr = zzeokVar.position();
        this.zzawn = this.zzitr - ((long) byteBuffer.remaining());
        this.zzits = j;
        this.zzitt = zzeokVar;
        zzeokVar.zzfc(zzeokVar.position() + j);
        this.zzitp = false;
        this.zzito = false;
        zzbkf();
    }

    public final synchronized void zzbkf() {
        zzbke();
        zzeoq zzeoqVar = zzdc;
        String strValueOf = String.valueOf(this.type);
        zzeoqVar.zzik(strValueOf.length() != 0 ? "parsing details of ".concat(strValueOf) : new String("parsing details of "));
        if (this.zzitq != null) {
            ByteBuffer byteBuffer = this.zzitq;
            this.zzito = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzitu = byteBuffer.slice();
            }
            this.zzitq = null;
        }
    }

    protected abstract void zzl(ByteBuffer byteBuffer);

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzbs zzbsVar) {
        this.zzitn = zzbsVar;
    }
}
