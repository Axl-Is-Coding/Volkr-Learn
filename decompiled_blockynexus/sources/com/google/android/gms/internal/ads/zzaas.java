package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaas extends zzaaq<Integer> {
    zzaas(int i, String str, Integer num) {
        super(1, str, num, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Integer zza(Bundle bundle) {
        String strValueOf = String.valueOf(getKey());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return zzrf();
        }
        String strValueOf2 = String.valueOf(getKey());
        return Integer.valueOf(bundle.getInt(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Integer zzb(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), zzrf().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(getKey(), num.intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Integer zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), zzrf().intValue()));
    }
}
