package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnx {
    private int code;
    private String description;

    zzdnx(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        jsonReader.beginObject();
        int iNextInt = 3;
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            byte b2 = -1;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -1724546052) {
                if (iHashCode == 3059181 && strNextName.equals("code")) {
                    b2 = 0;
                }
            } else if (strNextName.equals("description")) {
                b2 = 1;
            }
            if (b2 == 0) {
                iNextInt = jsonReader.nextInt();
            } else if (b2 != 1) {
                jsonReader.skipValue();
            } else {
                strNextString = jsonReader.nextString();
            }
        }
        jsonReader.endObject();
        this.code = iNextInt;
        this.description = strNextString;
    }

    public final String getDescription() {
        return this.description;
    }
}
