package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzne implements zzmz {
    private final zzmz[] zzbfe;
    private final ArrayList<zzmz> zzbff;
    private zznc zzbfg;
    private zzhy zzbfh;
    private Object zzbfi;
    private zzng zzbfk;
    private final zzid zzaev = new zzid();
    private int zzbfj = -1;

    public zzne(zzmz... zzmzVarArr) {
        this.zzbfe = zzmzVarArr;
        this.zzbff = new ArrayList<>(Arrays.asList(zzmzVarArr));
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zza(zzhc zzhcVar, boolean z, zznc zzncVar) {
        this.zzbfg = zzncVar;
        int i = 0;
        while (true) {
            zzmz[] zzmzVarArr = this.zzbfe;
            if (i >= zzmzVarArr.length) {
                return;
            }
            zzmzVarArr[i].zza(zzhcVar, false, new zznd(this, i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzb(zzmx zzmxVar) {
        zznb zznbVar = (zznb) zzmxVar;
        int i = 0;
        while (true) {
            zzmz[] zzmzVarArr = this.zzbfe;
            if (i >= zzmzVarArr.length) {
                return;
            }
            zzmzVarArr[i].zzb(zznbVar.zzbex[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzhz() throws IOException {
        zzng zzngVar = this.zzbfk;
        if (zzngVar != null) {
            throw zzngVar;
        }
        for (zzmz zzmzVar : this.zzbfe) {
            zzmzVar.zzhz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzia() {
        for (zzmz zzmzVar : this.zzbfe) {
            zzmzVar.zzia();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final zzmx zza(int i, zzok zzokVar) {
        zzmx[] zzmxVarArr = new zzmx[this.zzbfe.length];
        for (int i2 = 0; i2 < zzmxVarArr.length; i2++) {
            zzmxVarArr[i2] = this.zzbfe[i2].zza(i, zzokVar);
        }
        return new zznb(zzmxVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i, zzhy zzhyVar, Object obj) {
        zzng zzngVar;
        if (this.zzbfk == null) {
            int iZzff = zzhyVar.zzff();
            int i2 = 0;
            while (true) {
                if (i2 < iZzff) {
                    if (zzhyVar.zza(i2, this.zzaev, false).zzait) {
                        zzngVar = new zzng(0);
                        break;
                    }
                    i2++;
                } else {
                    if (this.zzbfj == -1) {
                        this.zzbfj = zzhyVar.zzfg();
                    } else if (zzhyVar.zzfg() != this.zzbfj) {
                        zzngVar = new zzng(1);
                    }
                    zzngVar = null;
                }
            }
            this.zzbfk = zzngVar;
        }
        if (this.zzbfk != null) {
            return;
        }
        this.zzbff.remove(this.zzbfe[i]);
        if (i == 0) {
            this.zzbfh = zzhyVar;
            this.zzbfi = obj;
        }
        if (this.zzbff.isEmpty()) {
            this.zzbfg.zzb(this.zzbfh, this.zzbfi);
        }
    }
}
