package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbm {
    public final String zzguv;
    public String zzguw;
    public Bundle zzgux = new Bundle();

    public zzdbm(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        Map<String, String> mapZzb = map;
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName = strNextName == null ? "" : strNextName;
            byte b2 = -1;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -995427962) {
                if (iHashCode == -271442291 && strNextName.equals("signal_dictionary")) {
                    b2 = 1;
                }
            } else if (strNextName.equals(NativeProtocol.WEB_DIALOG_PARAMS)) {
                b2 = 0;
            }
            if (b2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (b2 != 1) {
                jsonReader.skipValue();
            } else {
                mapZzb = zzbao.zzb(jsonReader);
            }
        }
        this.zzguv = strNextString;
        jsonReader.endObject();
        for (Map.Entry<String, String> entry : mapZzb.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.zzgux.putString(entry.getKey(), entry.getValue());
            }
        }
    }

    final zzdbm zzo(Bundle bundle) {
        try {
            this.zzguw = com.google.android.gms.ads.internal.zzp.zzkr().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzguw = "{}";
        }
        return this;
    }
}
