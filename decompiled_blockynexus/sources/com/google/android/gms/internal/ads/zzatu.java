package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatu extends zzatz {
    private final String type;
    private final int zzdvs;

    public zzatu(String str, int i) {
        this.type = str;
        this.zzdvs = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzatu)) {
            zzatu zzatuVar = (zzatu) obj;
            if (Objects.equal(this.type, zzatuVar.type) && Objects.equal(Integer.valueOf(this.zzdvs), Integer.valueOf(zzatuVar.zzdvs))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final int getAmount() {
        return this.zzdvs;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final String getType() {
        return this.type;
    }
}
