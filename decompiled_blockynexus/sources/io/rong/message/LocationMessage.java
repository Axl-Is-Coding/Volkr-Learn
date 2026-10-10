package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import io.rong.common.ParcelUtils;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DestructionTag
@MessageTag(flag = 3, messageHandler = LocationMessageHandler.class, value = "RC:LBSMsg")
public final class LocationMessage extends MessageContent {
    public static final Parcelable.Creator<LocationMessage> CREATOR = new Parcelable.Creator<LocationMessage>() { // from class: io.rong.message.LocationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationMessage createFromParcel(Parcel parcel) {
            return new LocationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationMessage[] newArray(int i) {
            return new LocationMessage[i];
        }
    };
    private static final String TAG = "LocationMessage";
    protected String extra;
    private String mBase64;
    private Uri mImgUri;
    private double mLat;
    private double mLng;
    private String mPoi;

    public LocationMessage(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            setLat(jSONObject.getDouble(LocationConst.LATITUDE));
            setLng(jSONObject.getDouble(LocationConst.LONGITUDE));
            if (jSONObject.has("content")) {
                setBase64(jSONObject.optString("content"));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            setPoi(jSONObject.optString(LocationConst.POI));
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            if (jSONObject.has("isBurnAfterRead")) {
                setDestruct(jSONObject.getBoolean("isBurnAfterRead"));
            }
            if (jSONObject.has("burnDuration")) {
                setDestructTime(jSONObject.getLong("burnDuration"));
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
    }

    public static LocationMessage obtain(double d2, double d3, String str, Uri uri) {
        return new LocationMessage(d2, d3, str, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.mBase64)) {
                jSONObject.put("content", this.mBase64);
            } else if (this.mImgUri != null) {
                jSONObject.put("content", this.mImgUri);
            }
            jSONObject.put(LocationConst.LATITUDE, this.mLat);
            jSONObject.put(LocationConst.LONGITUDE, this.mLng);
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (!TextUtils.isEmpty(this.mPoi)) {
                jSONObject.put(LocationConst.POI, this.mPoi);
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        this.mBase64 = null;
        return jSONObject.toString().getBytes();
    }

    public String getBase64() {
        return this.mBase64;
    }

    public String getExtra() {
        return this.extra;
    }

    public Uri getImgUri() {
        return this.mImgUri;
    }

    public double getLat() {
        return this.mLat;
    }

    public double getLng() {
        return this.mLng;
    }

    public String getPoi() {
        return this.mPoi;
    }

    public void setBase64(String str) {
        this.mBase64 = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setImgUri(Uri uri) {
        this.mImgUri = uri;
    }

    public void setLat(double d2) {
        this.mLat = d2;
    }

    public void setLng(double d2) {
        this.mLng = d2;
    }

    public void setPoi(String str) {
        this.mPoi = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.extra);
        ParcelUtils.writeToParcel(parcel, Double.valueOf(this.mLat));
        ParcelUtils.writeToParcel(parcel, Double.valueOf(this.mLng));
        ParcelUtils.writeToParcel(parcel, this.mPoi);
        ParcelUtils.writeToParcel(parcel, this.mImgUri);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDestruct() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDestructTime()));
    }

    private LocationMessage(double d2, double d3, String str, Uri uri) {
        this.mLat = d2;
        this.mLng = d3;
        this.mPoi = str;
        this.mImgUri = uri;
    }

    public LocationMessage(Parcel parcel) {
        this.extra = ParcelUtils.readFromParcel(parcel);
        this.mLat = ParcelUtils.readDoubleFromParcel(parcel).doubleValue();
        this.mLng = ParcelUtils.readDoubleFromParcel(parcel).doubleValue();
        this.mPoi = ParcelUtils.readFromParcel(parcel);
        this.mImgUri = (Uri) ParcelUtils.readFromParcel(parcel, Uri.class);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setDestruct(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDestructTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }
}
