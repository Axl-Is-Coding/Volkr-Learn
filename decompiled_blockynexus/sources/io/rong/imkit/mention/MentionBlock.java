package io.rong.imkit.mention;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class MentionBlock {
    public int end;
    public String name;
    public boolean offset;
    public int start;
    public String userId;

    MentionBlock() {
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().putOpt("userId", this.userId).putOpt("name", this.name).putOpt("offset", Boolean.valueOf(this.offset)).putOpt("start", Integer.valueOf(this.start)).putOpt("end", Integer.valueOf(this.end));
        } catch (JSONException unused) {
            return null;
        }
    }

    public String toString() {
        try {
            return new JSONObject().putOpt("userId", this.userId).putOpt("name", this.name).putOpt("offset", Boolean.valueOf(this.offset)).putOpt("start", Integer.valueOf(this.start)).putOpt("end", Integer.valueOf(this.end)).toString();
        } catch (JSONException unused) {
            return super.toString();
        }
    }

    MentionBlock(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.userId = jSONObject.optString("userId");
            this.name = jSONObject.optString("name");
            this.offset = jSONObject.optBoolean("offset");
            this.start = jSONObject.optInt("start");
            this.end = jSONObject.optInt("end");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
