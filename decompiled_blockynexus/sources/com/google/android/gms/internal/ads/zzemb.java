package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemb extends zzeiq {
    private final zzemd zziml;
    private zzeiu zzimm = zzbif();
    private final /* synthetic */ zzemc zzimn;

    zzemb(zzemc zzemcVar) {
        this.zzimn = zzemcVar;
        this.zziml = new zzemd(this.zzimn, null);
    }

    private final zzeiu zzbif() {
        if (this.zziml.hasNext()) {
            return (zzeiu) ((zzeiw) this.zziml.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzimm != null;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final byte nextByte() {
        zzeiu zzeiuVar = this.zzimm;
        if (zzeiuVar == null) {
            throw new NoSuchElementException();
        }
        byte bNextByte = zzeiuVar.nextByte();
        if (!this.zzimm.hasNext()) {
            this.zzimm = zzbif();
        }
        return bNextByte;
    }
}
