package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
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
@MessageTag(flag = 3, value = "RC:ImgTextMsg")
public class RichContentMessage extends MessageContent implements Parcelable {
    public static final Parcelable.Creator<RichContentMessage> CREATOR = new Parcelable.Creator<RichContentMessage>() { // from class: io.rong.message.RichContentMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichContentMessage createFromParcel(Parcel parcel) {
            return new RichContentMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichContentMessage[] newArray(int i) {
            return new RichContentMessage[i];
        }
    };
    private static final String TAG = "RichContentMessage";
    private String content;
    private String extra;
    private String imgUrl;
    private String title;
    private String url;

    public RichContentMessage(String str, String str2, String str3) {
        this.url = "";
        this.extra = "";
        this.title = str;
        this.content = str2;
        this.imgUrl = str3;
    }

    private String getExpression(String str) {
        Matcher matcher = Pattern.compile("\\[/u([0-9A-Fa-f]+)\\]").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, toExpressionChar(matcher.group(1)));
        }
        matcher.appendTail(stringBuffer);
        Log.d("getExpression--", stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static RichContentMessage obtain(String str, String str2, String str3) {
        return new RichContentMessage(str, str2, str3);
    }

    private String toExpressionChar(String str) {
        return String.valueOf(Character.toChars(Integer.parseInt(str, 16)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", getExpression(getTitle()));
            jSONObject.put("content", getExpression(getContent()));
            jSONObject.put("imageUri", getImgUrl());
            jSONObject.put("url", getUrl());
            jSONObject.put("extra", getExtra());
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return new byte[0];
        }
    }

    public String getContent() {
        return this.content;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    @Override // io.rong.imlib.model.MessageContent
    public List<String> getSearchableWord() {
        ArrayList arrayList = new ArrayList();
        String str = this.title;
        if (str != null) {
            arrayList.add(str);
        }
        String str2 = this.content;
        if (str2 != null) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
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
        ParcelUtils.writeToParcel(parcel, this.content);
        ParcelUtils.writeToParcel(parcel, this.imgUrl);
        ParcelUtils.writeToParcel(parcel, this.url);
        ParcelUtils.writeToParcel(parcel, this.extra);
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    public static RichContentMessage obtain(String str, String str2, String str3, String str4) {
        return new RichContentMessage(str, str2, str3, str4);
    }

    public RichContentMessage(String str, String str2, String str3, String str4) {
        this.url = "";
        this.extra = "";
        this.title = str;
        this.content = str2;
        this.imgUrl = str3;
        this.url = str4;
    }

    protected RichContentMessage(Parcel parcel) {
        this.url = "";
        this.extra = "";
        this.title = ParcelUtils.readFromParcel(parcel);
        this.content = ParcelUtils.readFromParcel(parcel);
        this.imgUrl = ParcelUtils.readFromParcel(parcel);
        this.url = ParcelUtils.readFromParcel(parcel);
        this.extra = ParcelUtils.readFromParcel(parcel);
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public RichContentMessage() {
        this.url = "";
        this.extra = "";
    }

    public RichContentMessage(byte[] bArr) {
        this.url = "";
        this.extra = "";
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            this.title = jSONObject.optString("title");
            this.content = jSONObject.optString("content");
            this.imgUrl = jSONObject.optString("imageUri");
            this.url = jSONObject.optString("url");
            this.extra = jSONObject.optString("extra");
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e2) {
            Log.e("JSONException", e2.getMessage());
        }
    }
}
