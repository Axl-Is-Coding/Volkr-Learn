package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdny implements zzbat {
    public final String zzdpn;
    public final String zzdpp;
    public final JSONObject zzfxs;
    private final JSONObject zzhen;

    zzdny(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        this.zzhen = zzbao.zzc(jsonReader);
        this.zzdpp = this.zzhen.optString("ad_html", null);
        this.zzdpn = this.zzhen.optString("ad_base_url", null);
        this.zzfxs = this.zzhen.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.internal.ads.zzbat
    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzbao.zza(jsonWriter, this.zzhen);
    }
}
