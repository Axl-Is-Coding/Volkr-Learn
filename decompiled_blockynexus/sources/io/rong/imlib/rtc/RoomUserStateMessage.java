package io.rong.imlib.rtc;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.rtc.UserState;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 16, value = "RCRTC:state")
public class RoomUserStateMessage extends MessageContent {
    public static final Parcelable.Creator<RoomUserStateMessage> CREATOR = new Parcelable.Creator<RoomUserStateMessage>() { // from class: io.rong.imlib.rtc.RoomUserStateMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoomUserStateMessage createFromParcel(Parcel parcel) {
            return new RoomUserStateMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoomUserStateMessage[] newArray(int i) {
            return new RoomUserStateMessage[i];
        }
    };
    private static final String TAG = "RoomUserStateMessage";
    private List<UserState> userStates;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return new byte[0];
    }

    public List<UserState> getUserStates() {
        return this.userStates;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.userStates);
    }

    private RoomUserStateMessage(Parcel parcel) {
        this.userStates = ParcelUtils.readListFromParcel(parcel, UserState.class);
    }

    public RoomUserStateMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("users");
                this.userStates = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
                    if (jSONObject2 != null) {
                        this.userStates.add(new UserState(jSONObject2.getString("userId"), UserState.State.valueOf(jSONObject2.getInt(ServerProtocol.DIALOG_PARAM_STATE))));
                    }
                }
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }
}
