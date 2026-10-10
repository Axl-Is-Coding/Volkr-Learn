package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnu {
    public final int height;
    public final int width;
    public final boolean zzhdh;

    public zzdnu(int i, int i2, boolean z) {
        this.width = i;
        this.height = i2;
        this.zzhdh = z;
    }

    static List<zzdnu> zze(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            boolean zNextBoolean = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (ViewHierarchyConstants.DIMENSION_WIDTH_KEY.equals(strNextName)) {
                    iNextInt = jsonReader.nextInt();
                } else if (ViewHierarchyConstants.DIMENSION_HEIGHT_KEY.equals(strNextName)) {
                    iNextInt2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(strNextName)) {
                    zNextBoolean = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzdnu(iNextInt, iNextInt2, zNextBoolean));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
