package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcng {
    private final Clock zzbqa;

    public zzcng(Clock clock) {
        this.zzbqa = clock;
    }

    public final void zza(List<Object> list, String str, String str2, Object... objArr) {
        if (zzacv.zzdbq.get().booleanValue()) {
            long jCurrentTimeMillis = this.zzbqa.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(jCurrentTimeMillis);
                jsonWriter.name("source").value(str);
                jsonWriter.name("event").value(str2);
                jsonWriter.name("components").beginArray();
                Iterator<Object> it = list.iterator();
                while (it.hasNext()) {
                    jsonWriter.value(it.next().toString());
                }
                jsonWriter.endArray();
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginArray();
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    Object obj = objArr[i];
                    jsonWriter.value(obj != null ? obj.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e2) {
                zzbbq.zzc("unable to log", e2);
            }
            String strValueOf = String.valueOf(stringWriter.toString());
            zzbbq.zzfd(strValueOf.length() != 0 ? "AD-DBG ".concat(strValueOf) : new String("AD-DBG "));
        }
    }
}
