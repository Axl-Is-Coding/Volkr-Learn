package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.places.model.PlaceFields;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.statistics.UserData;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsHs")
public class CSHandShakeMessage extends MessageContent {
    public static final Parcelable.Creator<CSHandShakeMessage> CREATOR = new Parcelable.Creator<CSHandShakeMessage>() { // from class: io.rong.message.CSHandShakeMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSHandShakeMessage createFromParcel(Parcel parcel) {
            return new CSHandShakeMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSHandShakeMessage[] newArray(int i) {
            return new CSHandShakeMessage[i];
        }
    };
    private static final String TAG = "CSHandShakeMessage";
    private CSCustomServiceInfo customServiceInfo;

    public CSHandShakeMessage() {
    }

    public static CSHandShakeMessage obtain() {
        return new CSHandShakeMessage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject2.put("userId", this.customServiceInfo.getUserId());
            jSONObject2.put("nickName", this.customServiceInfo.getNickName());
            jSONObject2.put("loginName", this.customServiceInfo.getLoginName());
            jSONObject2.put("name", this.customServiceInfo.getName());
            jSONObject2.put("grade", this.customServiceInfo.getGrade());
            jSONObject2.put(UserData.GENDER_KEY, this.customServiceInfo.getGender());
            jSONObject2.put("birthday", this.customServiceInfo.getBirthday());
            jSONObject2.put("age", this.customServiceInfo.getAge());
            jSONObject2.put("profession", this.customServiceInfo.getProfession());
            jSONObject2.put("portraitUrl", this.customServiceInfo.getPortraitUrl());
            jSONObject2.put("province", this.customServiceInfo.getProvince());
            jSONObject2.put("city", this.customServiceInfo.getCity());
            jSONObject2.put("memo", this.customServiceInfo.getMemo());
            jSONObject.putOpt("userInfo", jSONObject2);
            jSONObject3.put("mobileNo", this.customServiceInfo.getMobileNo());
            jSONObject3.put("email", this.customServiceInfo.getEmail());
            jSONObject3.put("address", this.customServiceInfo.getAddress());
            jSONObject3.put("QQ", this.customServiceInfo.getQQ());
            jSONObject3.put("weibo", this.customServiceInfo.getWeibo());
            jSONObject3.put("weixin", this.customServiceInfo.getWeixin());
            jSONObject.putOpt("contactInfo", jSONObject3);
            jSONObject4.put(PlaceFields.PAGE, this.customServiceInfo.getPage());
            jSONObject4.put("referrer", this.customServiceInfo.getReferrer());
            jSONObject4.put("enterUrl", this.customServiceInfo.getEnterUrl());
            jSONObject4.put("skillId", this.customServiceInfo.getSkillId());
            JSONArray jSONArray = new JSONArray();
            List<String> listUrl = this.customServiceInfo.getListUrl();
            if (listUrl != null && listUrl.size() > 0) {
                Iterator<String> it = listUrl.iterator();
                int i = 0;
                while (it.hasNext()) {
                    jSONArray.put(i, it.next());
                    i++;
                }
            }
            jSONObject4.put("listUrl", jSONArray);
            jSONObject4.put("define", this.customServiceInfo.getDefine());
            jSONObject4.put("productId", this.customServiceInfo.getProductId());
            jSONObject.put("requestInfo", jSONObject4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "UnsupportedEncodingException ", e3);
            return new byte[0];
        }
    }

    public void setCustomInfo(CSCustomServiceInfo cSCustomServiceInfo) {
        this.customServiceInfo = cSCustomServiceInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.customServiceInfo);
    }

    public CSHandShakeMessage(byte[] bArr) {
    }

    public CSHandShakeMessage(Parcel parcel) {
        this.customServiceInfo = (CSCustomServiceInfo) ParcelUtils.readFromParcel(parcel, CSCustomServiceInfo.class);
    }
}
