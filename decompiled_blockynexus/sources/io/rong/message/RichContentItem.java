package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import io.rong.common.ParcelUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class RichContentItem implements Parcelable {
    public static final Parcelable.Creator<RichContentItem> CREATOR = new Parcelable.Creator<RichContentItem>() { // from class: io.rong.message.RichContentItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichContentItem createFromParcel(Parcel parcel) {
            return new RichContentItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichContentItem[] newArray(int i) {
            return new RichContentItem[0];
        }
    };
    private String digest;
    private String imageUrl;
    private String title;
    private String url;

    public RichContentItem(Parcel parcel) {
        setTitle(ParcelUtils.readFromParcel(parcel));
        setDigest(ParcelUtils.readFromParcel(parcel));
        setImageUrl(ParcelUtils.readFromParcel(parcel));
        setUrl(ParcelUtils.readFromParcel(parcel));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDigest() {
        return this.digest;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDigest(String str) {
        this.digest = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.title);
        ParcelUtils.writeToParcel(parcel, this.digest);
        ParcelUtils.writeToParcel(parcel, this.imageUrl);
        ParcelUtils.writeToParcel(parcel, this.url);
    }

    public RichContentItem(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.has("title")) {
                setTitle(jSONObject.optString("title"));
            }
            if (jSONObject.has("digest")) {
                setDigest(jSONObject.optString("digest"));
            }
            if (jSONObject.has("picurl")) {
                setImageUrl(jSONObject.optString("picurl"));
            }
            if (jSONObject.has("url")) {
                setUrl(jSONObject.optString("url"));
            }
        }
    }

    public RichContentItem(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("title")) {
                setTitle(jSONObject.optString("title"));
            }
            if (jSONObject.has("digest")) {
                setDigest(jSONObject.optString("digest"));
            }
            if (jSONObject.has("picurl")) {
                setImageUrl(jSONObject.optString("picurl"));
            }
            if (jSONObject.has("url")) {
                setUrl(jSONObject.optString("url"));
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
    }
}
