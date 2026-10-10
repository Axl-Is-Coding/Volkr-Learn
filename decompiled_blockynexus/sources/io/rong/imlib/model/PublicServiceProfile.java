package io.rong.imlib.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import io.rong.common.ParcelUtils;
import io.rong.imlib.model.Conversation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceProfile implements Parcelable {
    public static final Parcelable.Creator<PublicServiceProfile> CREATOR = new Parcelable.Creator<PublicServiceProfile>() { // from class: io.rong.imlib.model.PublicServiceProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceProfile createFromParcel(Parcel parcel) {
            return new PublicServiceProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceProfile[] newArray(int i) {
            return new PublicServiceProfile[i];
        }
    };
    private String introduction;
    private boolean isFollowed;
    private boolean isGlobal;
    private PublicServiceMenu menu;
    private String name;
    private Uri portraitUri;
    private String publicServiceId;
    private Conversation.ConversationType publicServiceType;

    public PublicServiceProfile() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Conversation.ConversationType getConversationType() {
        return this.publicServiceType;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public PublicServiceMenu getMenu() {
        return this.menu;
    }

    public String getName() {
        return this.name;
    }

    public Uri getPortraitUri() {
        return this.portraitUri;
    }

    public String getTargetId() {
        return this.publicServiceId;
    }

    public boolean isFollow() {
        return this.isFollowed;
    }

    public boolean isGlobal() {
        return this.isGlobal;
    }

    public void setExtra(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("introduction")) {
                setIntroduction(jSONObject.optString("introduction"));
            }
            if (jSONObject.has("follow")) {
                setIsFollow(jSONObject.optBoolean("follow"));
            }
            if (jSONObject.has("isGlobal")) {
                setIsGlobal(jSONObject.optBoolean("isGlobal"));
            }
            if (!jSONObject.has("menu") || jSONObject.getJSONArray("menu") == null) {
                return;
            }
            try {
                this.menu = new PublicServiceMenu(jSONObject.getJSONArray("menu"));
            } catch (Exception e2) {
                Log.e("DecodePSMenu", e2.getMessage());
            }
        } catch (JSONException e3) {
            Log.e("JSONException", e3.getMessage());
        }
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setIsFollow(boolean z) {
        this.isFollowed = z;
    }

    public void setIsGlobal(boolean z) {
        this.isGlobal = z;
    }

    public void setMenu(PublicServiceMenu publicServiceMenu) {
        this.menu = publicServiceMenu;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortraitUri(Uri uri) {
        this.portraitUri = uri;
    }

    public void setPublicServiceType(Conversation.ConversationType conversationType) {
        this.publicServiceType = conversationType;
    }

    public void setTargetId(String str) {
        this.publicServiceId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.name);
        ParcelUtils.writeToParcel(parcel, this.portraitUri);
        ParcelUtils.writeToParcel(parcel, this.publicServiceId);
        Conversation.ConversationType conversationType = this.publicServiceType;
        if (conversationType != null) {
            ParcelUtils.writeToParcel(parcel, Integer.valueOf(conversationType.getValue()));
        } else {
            ParcelUtils.writeToParcel(parcel, (Integer) 0);
        }
        ParcelUtils.writeToParcel(parcel, this.introduction);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isFollowed ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isGlobal ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, this.menu);
    }

    public PublicServiceProfile(Parcel parcel) {
        this.name = ParcelUtils.readFromParcel(parcel);
        this.portraitUri = (Uri) ParcelUtils.readFromParcel(parcel, Uri.class);
        this.publicServiceId = ParcelUtils.readFromParcel(parcel);
        this.publicServiceType = Conversation.ConversationType.setValue(ParcelUtils.readIntFromParcel(parcel).intValue());
        this.introduction = ParcelUtils.readFromParcel(parcel);
        this.isFollowed = ParcelUtils.readIntFromParcel(parcel).intValue() == 1;
        this.isGlobal = ParcelUtils.readIntFromParcel(parcel).intValue() == 1;
        this.menu = (PublicServiceMenu) ParcelUtils.readFromParcel(parcel, PublicServiceMenu.class);
    }
}
