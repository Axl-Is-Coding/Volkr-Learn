package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:RRRspMsg")
public class ReadReceiptResponseMessage extends MessageContent {
    public static final Parcelable.Creator<ReadReceiptResponseMessage> CREATOR = new Parcelable.Creator<ReadReceiptResponseMessage>() { // from class: io.rong.message.ReadReceiptResponseMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptResponseMessage createFromParcel(Parcel parcel) {
            return new ReadReceiptResponseMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReadReceiptResponseMessage[] newArray(int i) {
            return new ReadReceiptResponseMessage[i];
        }
    };
    private static final String RECEIPT_MAP = "receiptMessageDic";
    private static final String TAG = "ReadReceiptResponseMessage";
    private HashMap<String, ArrayList<String>> mReceiptMap;

    public ReadReceiptResponseMessage(HashMap<String, ArrayList<String>> map) {
        this.mReceiptMap = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.mReceiptMap != null) {
                for (String str : this.mReceiptMap.keySet()) {
                    ArrayList<String> arrayList = this.mReceiptMap.get(str);
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject2.put(str, jSONArray);
                }
                jSONObject.put(RECEIPT_MAP, jSONObject2);
            }
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

    public ArrayList<String> getMessageUIdListBySenderId(String str) {
        return this.mReceiptMap.get(str);
    }

    public Set<String> getSenderIdSet() {
        return this.mReceiptMap.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.mReceiptMap);
    }

    public ReadReceiptResponseMessage(List<Message> list) {
        this.mReceiptMap = new HashMap<>();
        for (Message message : list) {
            String senderUserId = message.getSenderUserId();
            String uId = message.getUId();
            ArrayList<String> arrayList = this.mReceiptMap.get(senderUserId);
            arrayList = arrayList == null ? new ArrayList<>() : arrayList;
            if (!arrayList.contains(uId)) {
                arrayList.add(uId);
                this.mReceiptMap.put(senderUserId, arrayList);
            }
        }
    }

    public ReadReceiptResponseMessage(Parcel parcel) {
        this.mReceiptMap = (HashMap) ParcelUtils.readMapFromParcel(parcel);
    }

    public ReadReceiptResponseMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, e2.getMessage());
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(RECEIPT_MAP)) {
                this.mReceiptMap = new HashMap<>();
                JSONObject jSONObject2 = jSONObject.getJSONObject(RECEIPT_MAP);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String string = itKeys.next().toString();
                    JSONArray jSONArray = jSONObject2.getJSONArray(string);
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    this.mReceiptMap.put(string, arrayList);
                }
            }
        } catch (JSONException e3) {
            RLog.e(TAG, e3.getMessage());
        }
    }
}
