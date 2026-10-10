package com.google.android.gms.ads.nonagon.transaction.omid;

import com.facebook.share.internal.MessengerShareContentUtility;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class OmidSettings {
    private final JSONObject zzhfl;

    public OmidSettings(JSONObject jSONObject) {
        this.zzhfl = jSONObject;
    }

    public OmidMediaType getMediaType() {
        int iOptInt = this.zzhfl.optInt(MessengerShareContentUtility.MEDIA_TYPE, -1);
        return iOptInt != 0 ? iOptInt != 1 ? OmidMediaType.UNKNOWN : OmidMediaType.VIDEO : OmidMediaType.DISPLAY;
    }

    public String getVideoEventsOwner() {
        if (zza.zzhfn[getMediaType().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
