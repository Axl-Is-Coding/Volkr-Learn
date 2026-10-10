package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbal extends zzbh {
    private final /* synthetic */ byte[] zzecu;
    private final /* synthetic */ Map zzecv;
    private final /* synthetic */ zzbbk zzecw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbal(zzbag zzbagVar, int i, String str, zzal zzalVar, zzai zzaiVar, byte[] bArr, Map map, zzbbk zzbbkVar) {
        super(i, str, zzalVar, zzaiVar);
        this.zzecu = bArr;
        this.zzecv = map;
        this.zzecw = zzbbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final Map<String, String> getHeaders() throws zzl {
        Map<String, String> map = this.zzecv;
        return map == null ? super.getHeaders() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final byte[] zzg() throws zzl {
        byte[] bArr = this.zzecu;
        return bArr == null ? super.zzg() : bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbh, com.google.android.gms.internal.ads.zzaa
    /* JADX INFO: renamed from: zzj */
    public final void zza(String str) {
        this.zzecw.zzez(str);
        super.zza(str);
    }
}
