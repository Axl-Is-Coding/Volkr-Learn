package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:BurnNoticeMsg")
public class DestructionCmdMessage extends MessageContent {
    public static final Parcelable.Creator<DestructionCmdMessage> CREATOR = new Parcelable.Creator<DestructionCmdMessage>() { // from class: io.rong.message.DestructionCmdMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DestructionCmdMessage createFromParcel(Parcel parcel) {
            return new DestructionCmdMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DestructionCmdMessage[] newArray(int i) {
            return new DestructionCmdMessage[i];
        }
    };
    private static final String TAG = "DestructionCmdMessage";
    private List<String> burnMessageUIds;

    public void addBurnMessageUId(String str) {
        this.burnMessageUIds.add(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("burnMessageUIds", new JSONArray((Collection) this.burnMessageUIds));
            return jSONObject.toString().getBytes();
        } catch (JSONException unused) {
            return null;
        }
    }

    public List<String> getBurnMessageUIds() {
        return this.burnMessageUIds;
    }

    public void setBurnMessageUIds(List<String> list) {
        if (list == null) {
            return;
        }
        this.burnMessageUIds = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.burnMessageUIds);
    }

    public DestructionCmdMessage() {
        this.burnMessageUIds = new ArrayList();
    }

    private DestructionCmdMessage(Parcel parcel) {
        this.burnMessageUIds = new ArrayList();
        this.burnMessageUIds = parcel.readArrayList(DestructionCmdMessage.class.getClassLoader());
    }

    public DestructionCmdMessage(byte[] bArr) {
        this.burnMessageUIds = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(new String(bArr, "UTF-8")).getJSONArray("burnMessageUIds");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.burnMessageUIds.add(jSONArray.getString(i));
            }
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "DestructionCmdMessage", e2);
        } catch (JSONException e3) {
            RLog.e(TAG, "DestructionCmdMessage", e3);
        }
    }
}
