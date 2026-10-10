package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DestructionTag(destructionFlag = 0)
@MessageTag(flag = 3, value = "RC:TxtMsg")
public class TextMessage extends MessageContent {
    public static final Parcelable.Creator<TextMessage> CREATOR = new Parcelable.Creator<TextMessage>() { // from class: io.rong.message.TextMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextMessage createFromParcel(Parcel parcel) {
            return new TextMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextMessage[] newArray(int i) {
            return new TextMessage[i];
        }
    };
    private static final String TAG = "TextMessage";
    private String content;
    protected String extra;

    protected TextMessage() {
    }

    private String getEmotion(String str) {
        Matcher matcher = Pattern.compile("\\[/u([0-9A-Fa-f]+)\\]").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            int i = 0;
            if (strGroup != null) {
                i = Integer.parseInt(strGroup, 16);
            }
            matcher.appendReplacement(stringBuffer, String.valueOf(Character.toChars(i)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static TextMessage obtain(String str) {
        TextMessage textMessage = new TextMessage();
        textMessage.setContent(str);
        return textMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getContent())) {
                jSONObject.put("content", getEmotion(getContent()));
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            if (getJsonMentionInfo() != null) {
                jSONObject.putOpt("mentionedInfo", getJsonMentionInfo());
            }
            jSONObject.put("isBurnAfterRead", isDestruct());
            jSONObject.put("burnDuration", getDestructTime());
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return null;
        }
    }

    public String getContent() {
        return this.content;
    }

    public String getExtra() {
        return this.extra;
    }

    @Override // io.rong.imlib.model.MessageContent
    public List<String> getSearchableWord() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.content);
        return arrayList;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public String toString() {
        return "TextMessage{content='" + this.content + "', extra='" + this.extra + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, this.content);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, getMentionedInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isDestruct() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDestructTime()));
    }

    public TextMessage(byte[] bArr) {
        if (bArr == null) {
            RLog.e(TAG, "data is null ");
            return;
        }
        String str = null;
        try {
            if (bArr.length >= 40960) {
                RLog.e(TAG, "TextMessage length is larger than 40KB, length :" + bArr.length);
            }
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
        }
        if (str == null) {
            RLog.e(TAG, "jsonStr is null ");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                setContent(jSONObject.optString("content"));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            if (jSONObject.has("mentionedInfo")) {
                setMentionedInfo(parseJsonToMentionInfo(jSONObject.getJSONObject("mentionedInfo")));
            }
            if (jSONObject.has("isBurnAfterRead")) {
                setDestruct(jSONObject.getBoolean("isBurnAfterRead"));
            }
            if (jSONObject.has("burnDuration")) {
                setDestructTime(jSONObject.getLong("burnDuration"));
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    public TextMessage(Parcel parcel) {
        setExtra(ParcelUtils.readFromParcel(parcel));
        setContent(ParcelUtils.readFromParcel(parcel));
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setMentionedInfo((MentionedInfo) ParcelUtils.readFromParcel(parcel, MentionedInfo.class));
        setDestruct(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
        setDestructTime(ParcelUtils.readLongFromParcel(parcel).longValue());
    }

    public TextMessage(String str) {
        setContent(str);
    }
}
