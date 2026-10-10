package io.rong.imlib.location.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imlib.MessageTag;
import io.rong.imlib.location.RealTimeLocationType;
import io.rong.imlib.model.MessageContent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 16, value = "RC:RL")
public class RealTimeLocationStatusMessage extends MessageContent {
    public static final Parcelable.Creator<RealTimeLocationStatusMessage> CREATOR = new Parcelable.Creator<RealTimeLocationStatusMessage>() { // from class: io.rong.imlib.location.message.RealTimeLocationStatusMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationStatusMessage createFromParcel(Parcel parcel) {
            return new RealTimeLocationStatusMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationStatusMessage[] newArray(int i) {
            return new RealTimeLocationStatusMessage[i];
        }
    };
    private double latitude;
    private double longitude;
    private int realTimeLocationType;

    public static RealTimeLocationStatusMessage obtain(double d2, double d3) {
        RealTimeLocationStatusMessage realTimeLocationStatusMessage = new RealTimeLocationStatusMessage();
        realTimeLocationStatusMessage.latitude = d2;
        realTimeLocationStatusMessage.longitude = d3;
        return realTimeLocationStatusMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LocationConst.LATITUDE, this.latitude);
            jSONObject.put(LocationConst.LONGITUDE, this.longitude);
            jSONObject.put("type", this.realTimeLocationType);
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        return jSONObject.toString().getBytes();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public RealTimeLocationType getRealTimeLocationType() {
        return RealTimeLocationType.valueOf(this.realTimeLocationType);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeInt(this.realTimeLocationType);
    }

    public RealTimeLocationStatusMessage() {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.realTimeLocationType = 0;
    }

    public static RealTimeLocationStatusMessage obtain(double d2, double d3, RealTimeLocationType realTimeLocationType) {
        RealTimeLocationStatusMessage realTimeLocationStatusMessage = new RealTimeLocationStatusMessage();
        realTimeLocationStatusMessage.latitude = d2;
        realTimeLocationStatusMessage.longitude = d3;
        if (realTimeLocationType == null) {
            realTimeLocationStatusMessage.realTimeLocationType = 0;
        } else {
            realTimeLocationStatusMessage.realTimeLocationType = realTimeLocationType.getValue();
        }
        return realTimeLocationStatusMessage;
    }

    public RealTimeLocationStatusMessage(byte[] bArr) {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.realTimeLocationType = 0;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has(LocationConst.LATITUDE)) {
                this.latitude = jSONObject.optDouble(LocationConst.LATITUDE);
            }
            if (jSONObject.has(LocationConst.LONGITUDE)) {
                this.longitude = jSONObject.optDouble(LocationConst.LONGITUDE);
            }
            if (jSONObject.has("type")) {
                this.realTimeLocationType = RealTimeLocationType.valueOf(jSONObject.optInt("type")).getValue();
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
    }

    private RealTimeLocationStatusMessage(Parcel parcel) {
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.realTimeLocationType = 0;
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.realTimeLocationType = parcel.readInt();
    }
}
