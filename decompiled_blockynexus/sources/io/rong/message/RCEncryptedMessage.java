package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:EncryptedMsg")
public class RCEncryptedMessage extends MessageContent {
    public static final Parcelable.Creator<RCEncryptedMessage> CREATOR = new Parcelable.Creator<RCEncryptedMessage>() { // from class: io.rong.message.RCEncryptedMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptedMessage createFromParcel(Parcel parcel) {
            return new RCEncryptedMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RCEncryptedMessage[] newArray(int i) {
            return new RCEncryptedMessage[i];
        }
    };
    private static String TAG = "io.rong.message.RCEncryptedMessage";
    private String encryptedContent;
    private String originalObjName;
    private String remoteEncId;

    public RCEncryptedMessage() {
    }

    private String getEmotion(String str) {
        Matcher matcher = Pattern.compile("\\[/u([0-9A-Fa-f]+)\\]").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.valueOf(Character.toChars(Integer.parseInt(matcher.group(1), 16))));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remoteEncId", getRemoteEncId());
            jSONObject.put("originalObjName", getOriginalObjName());
            jSONObject.put("encryptedContent", getEncryptedContent());
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            if (getJsonMentionInfo() != null) {
                jSONObject.putOpt("mentionedInfo", getJsonMentionInfo());
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public String getEncryptedContent() {
        return this.encryptedContent;
    }

    public String getOriginalObjName() {
        return this.originalObjName;
    }

    public String getRemoteEncId() {
        return this.remoteEncId;
    }

    public void setEncryptedContent(String str) {
        this.encryptedContent = str;
    }

    public void setOriginalObjName(String str) {
        this.originalObjName = str;
    }

    public void setRemoteEncId(String str) {
        this.remoteEncId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.encryptedContent);
        parcel.writeString(this.remoteEncId);
        parcel.writeString(this.originalObjName);
        parcel.writeParcelable(getUserInfo(), i);
        parcel.writeParcelable(getMentionedInfo(), i);
    }

    public RCEncryptedMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "RCEncryptedMessage", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("encryptedContent")) {
                setEncryptedContent(jSONObject.optString("encryptedContent"));
            }
            if (jSONObject.has("remoteEncId")) {
                setRemoteEncId(jSONObject.optString("remoteEncId"));
            }
            if (jSONObject.has("originalObjName")) {
                setOriginalObjName(jSONObject.optString("originalObjName"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            if (jSONObject.has("mentionedInfo")) {
                setMentionedInfo(parseJsonToMentionInfo(jSONObject.getJSONObject("mentionedInfo")));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    protected RCEncryptedMessage(Parcel parcel) {
        this.encryptedContent = parcel.readString();
        this.remoteEncId = parcel.readString();
        this.originalObjName = parcel.readString();
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setMentionedInfo((MentionedInfo) ParcelUtils.readFromParcel(parcel, MentionedInfo.class));
    }
}
