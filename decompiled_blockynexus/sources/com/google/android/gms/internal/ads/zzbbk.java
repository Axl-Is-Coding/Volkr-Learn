package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbk {
    private final List<String> zzeeg;
    private static Object lock = new Object();
    private static boolean zzeee = false;
    private static boolean enabled = false;
    private static Clock zzbqa = DefaultClock.getInstance();
    private static final Set<String> zzeef = new HashSet(Arrays.asList(new String[0]));

    public zzbbk() {
        this(null);
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzeee && enabled;
        }
        return z;
    }

    public static void zzar(boolean z) {
        synchronized (lock) {
            zzeee = true;
            enabled = z;
        }
    }

    private final void zzb(final String str, final String str2, final Map<String, ?> map, final byte[] bArr) {
        zza("onNetworkRequest", new zzbbr(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.zzbbn
            private final String zzdgm;
            private final String zzdgt;
            private final Map zzdgw;
            private final byte[] zzeej;

            {
                this.zzdgt = str;
                this.zzdgm = str2;
                this.zzdgw = map;
                this.zzeej = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzbbr
            public final void zzb(JsonWriter jsonWriter) throws IOException {
                zzbbk.zza(this.zzdgt, this.zzdgm, this.zzdgw, this.zzeej, jsonWriter);
            }
        });
    }

    public static boolean zzbt(Context context) {
        if (Build.VERSION.SDK_INT < 17 || !zzacr.zzdaw.get().booleanValue()) {
            return false;
        }
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Exception e2) {
            zzbbq.zzd("Fail to determine debug setting.", e2);
            return false;
        }
    }

    private final void zzfa(final String str) {
        zza("onNetworkRequestError", new zzbbr(str) { // from class: com.google.android.gms.internal.ads.zzbbo
            private final String zzdgt;

            {
                this.zzdgt = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbbr
            public final void zzb(JsonWriter jsonWriter) throws IOException {
                zzbbk.zza(this.zzdgt, jsonWriter);
            }
        });
    }

    private static synchronized void zzfb(String str) {
        zzbbq.zzfd("GMA Debug BEGIN");
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 4000;
            String strValueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
            zzbbq.zzfd(strValueOf.length() != 0 ? "GMA Debug CONTENT ".concat(strValueOf) : new String("GMA Debug CONTENT "));
            i = i2;
        }
        zzbbq.zzfd("GMA Debug FINISH");
    }

    public static void zzyt() {
        synchronized (lock) {
            zzeee = false;
            enabled = false;
            zzbbq.zzfe("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzyu() {
        boolean z;
        synchronized (lock) {
            z = zzeee;
        }
        return z;
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (isEnabled()) {
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zzez(String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(final byte[] bArr) {
        zza("onNetworkResponseBody", new zzbbr(bArr) { // from class: com.google.android.gms.internal.ads.zzbbp
            private final byte[] zzeek;

            {
                this.zzeek = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzbbr
            public final void zzb(JsonWriter jsonWriter) throws IOException {
                zzbbk.zza(this.zzeek, jsonWriter);
            }
        });
    }

    public zzbbk(String str) {
        List<String> listAsList;
        if (isEnabled()) {
            String[] strArr = new String[1];
            String strValueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = strValueOf.length() != 0 ? "network_request_".concat(strValueOf) : new String("network_request_");
            listAsList = Arrays.asList(strArr);
        } else {
            listAsList = new ArrayList<>();
        }
        this.zzeeg = listAsList;
    }

    private final void zzb(final Map<String, ?> map, final int i) {
        zza("onNetworkResponse", new zzbbr(i, map) { // from class: com.google.android.gms.internal.ads.zzbbm
            private final int zzeeh;
            private final Map zzeei;

            {
                this.zzeeh = i;
                this.zzeei = map;
            }

            @Override // com.google.android.gms.internal.ads.zzbbr
            public final void zzb(JsonWriter jsonWriter) throws IOException {
                zzbbk.zza(this.zzeeh, this.zzeei, jsonWriter);
            }
        });
    }

    public final void zza(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String responseMessage = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String strValueOf = String.valueOf(e2.getMessage());
                    zzbbq.zzfe(strValueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(strValueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzfa(responseMessage);
            }
        }
    }

    public final void zza(Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzfa(null);
            }
        }
    }

    private static void zza(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!zzeef.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name("value").value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name("value").value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    zzbbq.zzfc("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void zza(String str, zzbbr zzbbrVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbqa.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator<String> it = this.zzeeg.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next());
            }
            jsonWriter.endArray();
            zzbbrVar.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzbbq.zzc("unable to log", e2);
        }
        zzfb(stringWriter.toString());
    }

    static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION).value(str);
        }
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        int length = bArr.length;
        String strEncode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(strEncode);
        } else {
            String strZzex = zzbbg.zzex(strEncode);
            if (strZzex != null) {
                jsonWriter.name("bodydigest").value(strZzex);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, (Map<String, ?>) map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
