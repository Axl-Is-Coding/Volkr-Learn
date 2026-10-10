package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:MsgExMsg")
public class MessageExpansionMessage extends MessageContent {
    public static final Parcelable.Creator<MessageExpansionMessage> CREATOR = new Parcelable.Creator<MessageExpansionMessage>() { // from class: io.rong.message.MessageExpansionMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageExpansionMessage createFromParcel(Parcel parcel) {
            return new MessageExpansionMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageExpansionMessage[] newArray(int i) {
            return new MessageExpansionMessage[i];
        }
    };
    private static final String TAG = "MessageExpansionMessage";
    private String originalMsgUId;
    private boolean removeAllKeys;
    private List<String> removeExpansionKeyList;
    private Map<String, String> updateExpansion;

    private JSONObject getExpansionDicJSON() {
        JSONObject jSONObject = new JSONObject();
        for (String str : this.updateExpansion.keySet()) {
            try {
                jSONObject.put(str, this.updateExpansion.get(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject;
    }

    private JSONArray getRemoveExpansionKeyJSON() {
        return new JSONArray((Collection) this.removeExpansionKeyList);
    }

    public static MessageExpansionMessage obtain(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("originalMsgUId is empty");
        }
        return new MessageExpansionMessage(str, map);
    }

    private void resolveExpansionDic(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("put"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                String strOptString = jSONObject2.optString(strValueOf);
                if (this.updateExpansion == null) {
                    this.updateExpansion = new HashMap();
                }
                this.updateExpansion.put(strValueOf, strOptString);
            }
        } catch (JSONException e2) {
            RLog.e(TAG, e2.getMessage());
        }
    }

    private void resolveExpansionKeyList(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("del");
        for (int i = 0; i < jSONArray.length(); i++) {
            if (this.removeExpansionKeyList == null) {
                this.removeExpansionKeyList = new ArrayList();
            }
            this.removeExpansionKeyList.add(jSONArray.getString(i));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getOriginalMsgUId())) {
                jSONObject.put("mid", getOriginalMsgUId());
            }
            if (getUpdateExpansion() != null) {
                jSONObject.put("put", getExpansionDicJSON());
            }
            jSONObject.put("del", getRemoveExpansionKeyJSON());
            jSONObject.put("clear", isRemoveAllKeys() ? 1 : 0);
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

    public String getOriginalMsgUId() {
        return this.originalMsgUId;
    }

    public List<String> getRemoveExpansionKeyList() {
        return this.removeExpansionKeyList;
    }

    public Map<String, String> getUpdateExpansion() {
        return this.updateExpansion;
    }

    public boolean isRemoveAllKeys() {
        return this.removeAllKeys;
    }

    public void setOriginalMsgUId(String str) {
        this.originalMsgUId = str;
    }

    public void setRemoveAllKeys(boolean z) {
        this.removeAllKeys = z;
    }

    public void setRemoveExpansionKeyList(List<String> list) {
        this.removeExpansionKeyList = list;
    }

    public void setUpdateExpansionDic(Map<String, String> map) {
        this.updateExpansion = map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.originalMsgUId);
        ParcelUtils.writeToParcel(parcel, this.updateExpansion);
        ParcelUtils.writeListToParcel(parcel, this.removeExpansionKeyList);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.removeAllKeys ? 1 : 0));
    }

    private MessageExpansionMessage(String str, List<String> list) {
        this.originalMsgUId = str;
        this.removeExpansionKeyList = list;
    }

    public static MessageExpansionMessage obtain(String str, List<String> list) {
        if (!TextUtils.isEmpty(str)) {
            return new MessageExpansionMessage(str, list);
        }
        throw new IllegalArgumentException("originalMsgUId is empty");
    }

    private MessageExpansionMessage(String str, boolean z) {
        this.originalMsgUId = str;
        this.removeAllKeys = z;
    }

    public static MessageExpansionMessage obtain(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            return new MessageExpansionMessage(str, z);
        }
        throw new IllegalArgumentException("originalMsgUId is empty");
    }

    private MessageExpansionMessage(String str, Map<String, String> map) {
        this.originalMsgUId = str;
        this.updateExpansion = map;
    }

    private MessageExpansionMessage(Parcel parcel) {
        setOriginalMsgUId(ParcelUtils.readFromParcel(parcel));
        setUpdateExpansionDic(ParcelUtils.readMapFromParcel(parcel));
        setRemoveExpansionKeyList(ParcelUtils.readListFromParcel(parcel, String.class));
        setRemoveAllKeys(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
    }

    public MessageExpansionMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, e2.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "MessageExpansionMessage jsonStr is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("mid")) {
                setOriginalMsgUId(jSONObject.optString("mid"));
            }
            if (jSONObject.has("put")) {
                resolveExpansionDic(jSONObject);
            }
            if (jSONObject.has("del")) {
                resolveExpansionKeyList(jSONObject);
            }
            if (jSONObject.has("clear")) {
                boolean z = true;
                if (jSONObject.optInt("clear") != 1) {
                    z = false;
                }
                setRemoveAllKeys(z);
            }
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }
}
