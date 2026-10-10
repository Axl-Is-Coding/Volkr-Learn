package com.google.android.gms.internal.ads;

import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbai implements zzai {
    private final /* synthetic */ String zzecs;
    private final /* synthetic */ zzban zzect;

    zzbai(zzbag zzbagVar, String str, zzban zzbanVar) {
        this.zzecs = str;
        this.zzect = zzbanVar;
    }

    @Override // com.google.android.gms.internal.ads.zzai
    public final void zzc(zzao zzaoVar) {
        String str = this.zzecs;
        String string = zzaoVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        sb.append(string);
        zzbbq.zzfe(sb.toString());
        this.zzect.zzb(null);
    }
}
