package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaat extends zzaaq<String> {
    zzaat(int i, String str, String str2) {
        super(i, str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ String zza(Bundle bundle) {
        String strValueOf = String.valueOf(getKey());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return zzrf();
        }
        String strValueOf2 = String.valueOf(getKey());
        return bundle.getString(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag."));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ String zzb(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), zzrf());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, String str) {
        editor.putString(getKey(), str);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ String zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), zzrf());
    }
}
