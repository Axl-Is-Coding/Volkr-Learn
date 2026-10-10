package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, value = "RC:PSImgTxtMsg")
public class PublicServiceRichContentMessage extends MessageContent implements Parcelable {
    public static final Parcelable.Creator<PublicServiceRichContentMessage> CREATOR = new Parcelable.Creator<PublicServiceRichContentMessage>() { // from class: io.rong.message.PublicServiceRichContentMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceRichContentMessage createFromParcel(Parcel parcel) {
            return new PublicServiceRichContentMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceRichContentMessage[] newArray(int i) {
            return new PublicServiceRichContentMessage[i];
        }
    };
    private RichContentItem mRichContentItem;
    private UserInfo mUser;

    public PublicServiceRichContentMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return null;
    }

    public RichContentItem getMessage() {
        return this.mRichContentItem;
    }

    public UserInfo getPublicServiceUserInfo() {
        return this.mUser;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.mRichContentItem);
    }

    public PublicServiceRichContentMessage(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            this.mRichContentItem = new RichContentItem((JSONObject) ((JSONArray) jSONObject.get("articles")).get(0));
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("user");
            if (jSONObject2 == null || TextUtils.isEmpty(jSONObject2.optString("portrait"))) {
                return;
            }
            this.mUser = new UserInfo(jSONObject2.optString("id"), jSONObject2.optString("name"), Uri.parse(jSONObject2.optString("portrait")));
        } catch (JSONException e2) {
            RLog.e("PSImgTxtMsg", e2.getMessage());
        }
    }

    public PublicServiceRichContentMessage(Parcel parcel) {
        this.mRichContentItem = (RichContentItem) ParcelUtils.readFromParcel(parcel, RichContentItem.class);
    }
}
