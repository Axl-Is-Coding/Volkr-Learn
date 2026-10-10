package com.sandboxol.imchat.message.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@MessageTag(flag = 3, value = "app:help")
public class HelpMessage extends MessageContent {
    public static final Parcelable.Creator<HelpMessage> CREATOR = new Parcelable.Creator<HelpMessage>() { // from class: com.sandboxol.imchat.message.entity.HelpMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HelpMessage createFromParcel(Parcel parcel) {
            return new HelpMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HelpMessage[] newArray(int i) {
            return new HelpMessage[i];
        }
    };
    private String content;

    public HelpMessage(Parcel parcel) {
        this.content = ParcelUtils.readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", "这是一条消息内容");
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.content);
    }

    public HelpMessage() {
    }

    public HelpMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
            }
        } catch (JSONException unused2) {
        }
    }
}
