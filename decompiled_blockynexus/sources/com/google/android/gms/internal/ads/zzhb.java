package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzhb implements zzhw, zzhx {
    private int index;
    private int state;
    private final int zzaee;
    private zzhz zzaef;
    private zznm zzaeg;
    private long zzaeh;
    private boolean zzaei = true;
    private boolean zzaej;

    public zzhb(int i) {
        this.zzaee = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void disable() {
        zzoz.checkState(this.state == 1);
        this.state = 0;
        this.zzaeg = null;
        this.zzaej = false;
        zzeh();
    }

    protected final int getIndex() {
        return this.index;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzhw, com.google.android.gms.internal.ads.zzhx
    public final int getTrackType() {
        return this.zzaee;
    }

    protected void onStarted() throws zzhd {
    }

    protected void onStopped() throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void start() throws zzhd {
        zzoz.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void stop() throws zzhd {
        zzoz.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public void zza(int i, Object obj) throws zzhd {
    }

    protected void zza(long j, boolean z) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zza(zzhz zzhzVar, zzho[] zzhoVarArr, zznm zznmVar, long j, boolean z, long j2) throws zzhd {
        zzoz.checkState(this.state == 0);
        this.zzaef = zzhzVar;
        this.state = 1;
        zze(z);
        zza(zzhoVarArr, zznmVar, j2);
        zza(j, z);
    }

    protected void zza(zzho[] zzhoVarArr, long j) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzdo(long j) throws zzhd {
        this.zzaej = false;
        this.zzaei = false;
        zza(j, false);
    }

    protected final void zzdp(long j) {
        this.zzaeg.zzeh(j - this.zzaeh);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final zzhw zzdz() {
        return this;
    }

    protected void zze(boolean z) throws zzhd {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public zzpd zzea() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final zznm zzeb() {
        return this.zzaeg;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final boolean zzec() {
        return this.zzaei;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzed() {
        this.zzaej = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final boolean zzee() {
        return this.zzaej;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzef() throws IOException {
        this.zzaeg.zzhs();
    }

    @Override // com.google.android.gms.internal.ads.zzhw
    public int zzeg() throws zzhd {
        return 0;
    }

    protected void zzeh() {
    }

    protected final zzhz zzei() {
        return this.zzaef;
    }

    protected final boolean zzej() {
        return this.zzaei ? this.zzaej : this.zzaeg.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zza(zzho[] zzhoVarArr, zznm zznmVar, long j) throws zzhd {
        zzoz.checkState(!this.zzaej);
        this.zzaeg = zznmVar;
        this.zzaei = false;
        this.zzaeh = j;
        zza(zzhoVarArr, j);
    }

    protected final int zza(zzhq zzhqVar, zzjk zzjkVar, boolean z) {
        int iZzb = this.zzaeg.zzb(zzhqVar, zzjkVar, z);
        if (iZzb == -4) {
            if (zzjkVar.zzgl()) {
                this.zzaei = true;
                return this.zzaej ? -4 : -3;
            }
            zzjkVar.zzaob += this.zzaeh;
        } else if (iZzb == -5) {
            zzho zzhoVar = zzhqVar.zzahx;
            long j = zzhoVar.zzahr;
            if (j != Long.MAX_VALUE) {
                zzhqVar.zzahx = zzhoVar.zzds(j + this.zzaeh);
            }
        }
        return iZzb;
    }
}
