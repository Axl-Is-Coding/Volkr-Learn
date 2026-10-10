package io.rong.imkit.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import io.rong.message.MediaMessageContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, value = "RC:CombineMsg")
public class CombineMessage extends MediaMessageContent {
    public static final Parcelable.Creator<CombineMessage> CREATOR = new Parcelable.Creator<CombineMessage>() { // from class: io.rong.imkit.message.CombineMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CombineMessage createFromParcel(Parcel parcel) {
            return new CombineMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CombineMessage[] newArray(int i) {
            return new CombineMessage[i];
        }
    };
    private static final String TAG = "CombineMessage";
    private Conversation.ConversationType conversationType;
    private List<String> nameList;
    private List<String> summaryList;
    private String title;

    public static CombineMessage obtain(Uri uri) {
        CombineMessage combineMessage = new CombineMessage();
        if (uri.toString().startsWith(LibStorageUtils.FILE)) {
            combineMessage.setLocalPath(uri);
        } else {
            combineMessage.setMediaUrl(uri);
        }
        return combineMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getTitle())) {
                jSONObject.put("title", getTitle());
            }
            if (!TextUtils.isEmpty(getName())) {
                jSONObject.put("name", getName());
            }
            if (getLocalPath() != null) {
                jSONObject.put("localPath", getLocalPath().toString());
            }
            if (getMediaUrl() != null) {
                jSONObject.put("remoteUrl", getMediaUrl().toString());
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            jSONObject.put("conversationType", this.conversationType.getValue());
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.nameList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("nameList", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.summaryList.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("summaryList", jSONArray2);
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException", e3);
            return null;
        }
    }

    public Conversation.ConversationType getConversationType() {
        return this.conversationType;
    }

    public List<String> getNameList() {
        return this.nameList;
    }

    public List<String> getSummaryList() {
        return this.summaryList;
    }

    public String getTitle() {
        return this.title;
    }

    public void setConversationType(Conversation.ConversationType conversationType) {
        this.conversationType = conversationType;
    }

    public void setNameList(List<String> list) {
        this.nameList = list;
    }

    public void setSummaryList(List<String> list) {
        this.summaryList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, getLocalPath());
        ParcelUtils.writeToParcel(parcel, getMediaUrl());
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getConversationType().getValue()));
        ParcelUtils.writeToParcel(parcel, getNameList());
        ParcelUtils.writeToParcel(parcel, getSummaryList());
    }

    protected CombineMessage() {
        this.conversationType = Conversation.ConversationType.PRIVATE;
        this.nameList = new ArrayList();
        this.summaryList = new ArrayList();
    }

    public CombineMessage(byte[] bArr) {
        String str;
        this.conversationType = Conversation.ConversationType.PRIVATE;
        this.nameList = new ArrayList();
        this.summaryList = new ArrayList();
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("title")) {
                setTitle(jSONObject.optString("title"));
            }
            if (jSONObject.has("name")) {
                setName(jSONObject.optString("name"));
            }
            if (jSONObject.has("localPath")) {
                setLocalPath(Uri.parse(jSONObject.optString("localPath")));
            }
            if (jSONObject.has("remoteUrl")) {
                setMediaUrl(Uri.parse(jSONObject.optString("remoteUrl")));
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.optString("extra"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            setConversationType(Conversation.ConversationType.setValue(jSONObject.optInt("conversationType")));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("nameList");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add((String) jSONArrayOptJSONArray.get(i));
            }
            setNameList(arrayList);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("summaryList");
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                arrayList2.add((String) jSONArrayOptJSONArray2.get(i2));
            }
            setSummaryList(arrayList2);
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    private CombineMessage(Parcel parcel) {
        this.conversationType = Conversation.ConversationType.PRIVATE;
        this.nameList = new ArrayList();
        this.summaryList = new ArrayList();
        setExtra(ParcelUtils.readFromParcel(parcel));
        setName(ParcelUtils.readFromParcel(parcel));
        setLocalPath((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setMediaUrl((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setConversationType(Conversation.ConversationType.setValue(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setNameList(ParcelUtils.readListFromParcel(parcel, String.class));
        setSummaryList(ParcelUtils.readListFromParcel(parcel, String.class));
    }
}
