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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, value = "RC:PSMultiImgTxtMsg")
public class PublicServiceMultiRichContentMessage extends MessageContent {
    public static final Parcelable.Creator<PublicServiceMultiRichContentMessage> CREATOR = new Parcelable.Creator<PublicServiceMultiRichContentMessage>() { // from class: io.rong.message.PublicServiceMultiRichContentMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceMultiRichContentMessage createFromParcel(Parcel parcel) {
            return new PublicServiceMultiRichContentMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceMultiRichContentMessage[] newArray(int i) {
            return new PublicServiceMultiRichContentMessage[i];
        }
    };
    private ArrayList<RichContentItem> mRichContentItems;
    private UserInfo mUser;

    public PublicServiceMultiRichContentMessage() {
        this.mRichContentItems = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return null;
    }

    public ArrayList<RichContentItem> getMessages() {
        return this.mRichContentItems;
    }

    public UserInfo getPublicServiceUserInfo() {
        return this.mUser;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeListToParcel(parcel, this.mRichContentItems);
    }

    public PublicServiceMultiRichContentMessage(byte[] bArr) {
        this.mRichContentItems = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            JSONArray jSONArray = (JSONArray) jSONObject.get("articles");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.mRichContentItems.add(new RichContentItem((JSONObject) jSONArray.get(i)));
            }
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("user");
            if (jSONObject2 == null || TextUtils.isEmpty(jSONObject2.optString("portrait"))) {
                return;
            }
            this.mUser = new UserInfo(jSONObject2.optString("id"), jSONObject2.optString("name"), Uri.parse(jSONObject2.optString("portrait")));
        } catch (JSONException e2) {
            RLog.e("PSMultiImgTxtMsg", e2.getMessage());
        }
    }

    public PublicServiceMultiRichContentMessage(Parcel parcel) {
        this.mRichContentItems = new ArrayList<>();
        this.mRichContentItems = ParcelUtils.readListFromParcel(parcel, RichContentItem.class);
    }
}
