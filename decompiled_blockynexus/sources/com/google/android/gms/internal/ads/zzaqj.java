package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqj {
    private final boolean zzdnv;
    private final boolean zzdnw;
    private final boolean zzdnx;
    private final boolean zzdny;
    private final boolean zzdnz;

    private zzaqj(zzaql zzaqlVar) {
        this.zzdnv = zzaqlVar.zzdnv;
        this.zzdnw = zzaqlVar.zzdnw;
        this.zzdnx = zzaqlVar.zzdnx;
        this.zzdny = zzaqlVar.zzdny;
        this.zzdnz = zzaqlVar.zzdnz;
    }

    public final JSONObject zzdp() {
        try {
            return new JSONObject().put("sms", this.zzdnv).put("tel", this.zzdnw).put("calendar", this.zzdnx).put("storePicture", this.zzdny).put("inlineVideo", this.zzdnz);
        } catch (JSONException e2) {
            zzbbq.zzc("Error occured while obtaining the MRAID capabilities.", e2);
            return null;
        }
    }
}
