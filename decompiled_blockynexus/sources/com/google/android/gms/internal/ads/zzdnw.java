package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import com.umeng.analytics.pro.au;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnw {
    public final int responseCode;
    public final List<String> zzdkm;
    public final String zzdtb;
    public final String zzdto;
    public final long zzglu;
    public final int zzhel;
    public final zzdnx zzhem;

    zzdnw(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List<String> listEmptyList = Collections.emptyList();
        jsonReader.beginObject();
        String strNextString = "";
        int iNextInt = 0;
        zzdnx zzdnxVar = null;
        long jNextLong = 0;
        int iNextInt2 = 0;
        String strNextString2 = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("nofill_urls".equals(strNextName)) {
                listEmptyList = zzbao.zza(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString2 = jsonReader.nextString();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if (au.aI.equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyo)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzdnxVar = new zzdnx(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        this.zzdkm = listEmptyList;
        this.zzhel = iNextInt;
        this.zzdtb = strNextString;
        this.zzdto = strNextString2;
        this.responseCode = iNextInt2;
        this.zzglu = jNextLong;
        this.zzhem = zzdnxVar;
    }
}
