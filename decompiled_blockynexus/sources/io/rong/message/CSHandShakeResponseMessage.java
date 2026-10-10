package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.sandboxol.center.config.StringConstant;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.CSGroupItem;
import io.rong.imlib.model.CSLMessageItem;
import io.rong.imlib.model.CustomServiceMode;
import io.rong.imlib.model.MessageContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:CsHsR")
public class CSHandShakeResponseMessage extends MessageContent {
    public static final Parcelable.Creator<CSHandShakeResponseMessage> CREATOR = new Parcelable.Creator<CSHandShakeResponseMessage>() { // from class: io.rong.message.CSHandShakeResponseMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSHandShakeResponseMessage createFromParcel(Parcel parcel) {
            return new CSHandShakeResponseMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSHandShakeResponseMessage[] newArray(int i) {
            return new CSHandShakeResponseMessage[i];
        }
    };
    private static final String TAG = "CSHandShakeResponseMessage";
    private int adminTipTime;
    private String adminTipWord;
    private int announceClickFlag;
    private String announceClickUrl;
    private String announceMsg;
    private int announceMsgFlag;
    private String companyIcon;
    private String companyName;
    private boolean disableLocation;
    private int evaEntryPoint;
    private int evaType;
    private ArrayList<CSGroupItem> groupList;
    private ArrayList<CSHumanEvaluateItem> humanEvaluateList;
    private boolean isBlack;
    private int isSuspendWhenQuit;
    private int leaveMessageConfigType;
    private ArrayList<CSLMessageItem> leaveMessageNativeInfo;
    private Uri leaveMessageWebUrl;
    private int mode;
    private String msg;
    private String pid;
    private boolean reportResolveStatus;
    private boolean requiredChangMode;
    private String robotHelloWord;
    private String robotLogo;
    private String robotName;
    private String robotSessionNoEva;
    private String sid;
    private int status;
    private String uid;
    private int userTipTime;
    private String userTipWord;

    public CSHandShakeResponseMessage() {
        this.humanEvaluateList = new ArrayList<>();
        this.groupList = new ArrayList<>();
        this.leaveMessageNativeInfo = new ArrayList<>();
    }

    public static CSHandShakeResponseMessage obtain() {
        return new CSHandShakeResponseMessage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return null;
    }

    public int getAdminTipTime() {
        return this.adminTipTime;
    }

    public String getAdminTipWord() {
        return this.adminTipWord;
    }

    public int getAnnounceClickFlag() {
        return this.announceClickFlag;
    }

    public String getAnnounceClickUrl() {
        return this.announceClickUrl;
    }

    public String getAnnounceMsg() {
        return this.announceMsg;
    }

    public int getAnnounceMsgFlag() {
        return this.announceMsgFlag;
    }

    public int getCode() {
        return this.status;
    }

    public String getCompanyIcon() {
        return this.companyIcon;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public int getEntryPoint() {
        return this.evaEntryPoint;
    }

    public int getEvaType() {
        return this.evaType;
    }

    public ArrayList<CSGroupItem> getGroupList() {
        return this.groupList;
    }

    public ArrayList<CSHumanEvaluateItem> getHumanEvaluateList() {
        return this.humanEvaluateList;
    }

    public int getLeaveMessageConfigType() {
        return this.leaveMessageConfigType;
    }

    public ArrayList<CSLMessageItem> getLeaveMessageNativeInfo() {
        return this.leaveMessageNativeInfo;
    }

    public Uri getLeaveMessageWebUrl() {
        return this.leaveMessageWebUrl;
    }

    public CustomServiceMode getMode() {
        return CustomServiceMode.valueOf(this.mode);
    }

    public String getMsg() {
        return this.msg;
    }

    public String getPid() {
        return this.pid;
    }

    public String getRobotHelloWord() {
        return this.robotHelloWord;
    }

    public String getRobotLogo() {
        return this.robotLogo;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public String getRobotSessionNoEva() {
        return this.robotSessionNoEva;
    }

    public String getSid() {
        return this.sid;
    }

    public String getUid() {
        return this.uid;
    }

    public int getUserTipTime() {
        return this.userTipTime;
    }

    public String getUserTipWord() {
        return this.userTipWord;
    }

    public boolean isBlack() {
        return this.isBlack;
    }

    public boolean isDisableLocation() {
        return this.disableLocation;
    }

    public boolean isReportResolveStatus() {
        return this.reportResolveStatus;
    }

    public boolean isRequiredChangMode() {
        return this.requiredChangMode;
    }

    public int isSuspendWhenQuit() {
        return this.isSuspendWhenQuit;
    }

    public String toString() {
        return "CSHandShakeResponseMessage{status=" + this.status + ", msg='" + this.msg + "', uid='" + this.uid + "', sid='" + this.sid + "', pid='" + this.pid + "', requiredChangMode=" + this.requiredChangMode + ", mode=" + this.mode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
        parcel.writeString(this.msg);
        parcel.writeString(this.uid);
        parcel.writeString(this.sid);
        parcel.writeString(this.pid);
        parcel.writeString(this.companyName);
        parcel.writeString(this.companyIcon);
        parcel.writeByte(this.isBlack ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.requiredChangMode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mode);
        parcel.writeString(this.robotName);
        parcel.writeString(this.robotLogo);
        parcel.writeString(this.robotHelloWord);
        parcel.writeString(this.robotSessionNoEva);
        parcel.writeTypedList(this.humanEvaluateList);
        parcel.writeTypedList(this.groupList);
        parcel.writeInt(this.userTipTime);
        parcel.writeString(this.userTipWord);
        parcel.writeInt(this.adminTipTime);
        parcel.writeString(this.adminTipWord);
        parcel.writeInt(this.evaEntryPoint);
        parcel.writeInt(this.evaType);
        parcel.writeByte(this.disableLocation ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.reportResolveStatus ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.leaveMessageConfigType);
        parcel.writeParcelable(this.leaveMessageWebUrl, i);
        parcel.writeTypedList(this.leaveMessageNativeInfo);
        parcel.writeInt(this.isSuspendWhenQuit);
        parcel.writeInt(this.announceMsgFlag);
        parcel.writeString(this.announceMsg);
        parcel.writeInt(this.announceClickFlag);
        parcel.writeString(this.announceClickUrl);
    }

    public CSHandShakeResponseMessage(byte[] bArr) {
        String str;
        this.humanEvaluateList = new ArrayList<>();
        this.groupList = new ArrayList<>();
        this.leaveMessageNativeInfo = new ArrayList<>();
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException ", e2);
            str = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            this.status = jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            this.msg = jSONObject.optString("msg");
            if (this.status != 0) {
                this.uid = jSONObject2.optString(StringConstant.UID);
                this.sid = jSONObject2.optString("sid");
                this.pid = jSONObject2.optString("pid");
                String str2 = (String) jSONObject2.opt("serviceType");
                if (!TextUtils.isEmpty(str2)) {
                    this.mode = Integer.parseInt(str2);
                }
                String strOptString = jSONObject2.optString("isblack");
                if (!TextUtils.isEmpty(strOptString)) {
                    this.isBlack = Integer.parseInt(strOptString) == 1;
                }
                String str3 = (String) jSONObject2.opt("notAutoCha");
                if (!TextUtils.isEmpty(str3)) {
                    this.requiredChangMode = Integer.parseInt(str3) == 1;
                }
                if (TextUtils.isEmpty(jSONObject2.optString("userTipTime", ""))) {
                    this.userTipTime = 0;
                } else {
                    this.userTipTime = Integer.parseInt(jSONObject2.optString("userTipTime", ""));
                }
                this.userTipWord = jSONObject2.optString("userTipWord");
                if (TextUtils.isEmpty(jSONObject2.optString("adminTipTime", ""))) {
                    this.adminTipTime = 0;
                } else {
                    this.adminTipTime = Integer.parseInt(jSONObject2.optString("adminTipTime", ""));
                }
                this.adminTipWord = jSONObject2.optString("adminTipWord");
                this.announceMsgFlag = jSONObject2.optInt("announceMsgFlag", 0);
                this.announceMsg = jSONObject2.optString("announceMsg", "");
                this.announceClickFlag = jSONObject2.optInt("announceClickFlag", 0);
                this.announceClickUrl = jSONObject2.optString("announceClickUrl", "");
                this.robotName = jSONObject2.optString("robotName");
                this.robotLogo = jSONObject2.optString("robotIcon");
                this.robotHelloWord = jSONObject2.optString("robotWelcome");
                this.companyIcon = jSONObject2.optString("companyIcon");
                this.companyName = jSONObject2.optString("companyName");
                this.robotSessionNoEva = jSONObject2.optString("robotSessionNoEva");
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("evaluateList");
                this.humanEvaluateList.clear();
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString2 = jSONArrayOptJSONArray.optJSONObject(i).optString("value");
                        this.humanEvaluateList.add(new CSHumanEvaluateItem(TextUtils.isEmpty(strOptString2) ? 0 : Integer.parseInt(strOptString2), jSONArrayOptJSONArray.optJSONObject(i).optString("description")));
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("groups");
                this.groupList.clear();
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        this.groupList.add(new CSGroupItem(jSONArrayOptJSONArray2.optJSONObject(i2).optString("id"), jSONArrayOptJSONArray2.optJSONObject(i2).optString("name"), jSONArrayOptJSONArray2.optJSONObject(i2).optBoolean(StringConstant.GAME_ORDER_TYPE_ONLINE)));
                    }
                }
                if (jSONObject2.isNull("suspendWhenQuit")) {
                    this.isSuspendWhenQuit = -1;
                } else {
                    this.isSuspendWhenQuit = jSONObject2.optInt("suspendWhenQuit");
                }
                this.disableLocation = jSONObject2.optInt("disableLocation") == 1;
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("evaConf");
                if (jSONObjectOptJSONObject != null) {
                    this.evaEntryPoint = jSONObjectOptJSONObject.optInt("evaEntryPoint");
                    this.evaType = jSONObjectOptJSONObject.optInt("evaType");
                    this.reportResolveStatus = jSONObjectOptJSONObject.optInt("reportResolveStatus") == 1;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("leaveMsgConf");
                if (jSONObjectOptJSONObject2 != null) {
                    this.leaveMessageConfigType = jSONObjectOptJSONObject2.optInt("type");
                    JSONObject jSONObject3 = jSONObjectOptJSONObject2.getJSONObject("customConf");
                    if (jSONObject3 != null) {
                        String strOptString3 = jSONObject3.optString("url");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            this.leaveMessageWebUrl = Uri.parse(strOptString3);
                        }
                    }
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("defaultConf");
                    this.leaveMessageNativeInfo.clear();
                    if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i3);
                        CSLMessageItem cSLMessageItem = new CSLMessageItem();
                        cSLMessageItem.setName(jSONObjectOptJSONObject3.optString("name"));
                        cSLMessageItem.setTitle(jSONObjectOptJSONObject3.optString("title"));
                        cSLMessageItem.setType(jSONObjectOptJSONObject3.optString("type"));
                        cSLMessageItem.setDefaultText(jSONObjectOptJSONObject3.optString("defaultText"));
                        cSLMessageItem.setRequired(jSONObjectOptJSONObject3.optBoolean("required"));
                        cSLMessageItem.setMax(jSONObjectOptJSONObject3.optInt("max"));
                        cSLMessageItem.setVerification(jSONObjectOptJSONObject3.optString("verification"));
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("message");
                        if (jSONArrayOptJSONArray4 != null) {
                            HashMap map = new HashMap();
                            map.put("empty", jSONArrayOptJSONArray4.optString(0));
                            map.put("wrong_format", jSONArrayOptJSONArray4.optString(1));
                            map.put("over_length", jSONArrayOptJSONArray4.optString(2));
                            cSLMessageItem.setMessage(map);
                        }
                        this.leaveMessageNativeInfo.add(cSLMessageItem);
                    }
                }
            }
        } catch (JSONException e3) {
            RLog.e(TAG, "JSONException " + e3.getMessage());
        }
    }

    protected CSHandShakeResponseMessage(Parcel parcel) {
        this.humanEvaluateList = new ArrayList<>();
        this.groupList = new ArrayList<>();
        this.leaveMessageNativeInfo = new ArrayList<>();
        this.status = parcel.readInt();
        this.msg = parcel.readString();
        this.uid = parcel.readString();
        this.sid = parcel.readString();
        this.pid = parcel.readString();
        this.companyName = parcel.readString();
        this.companyIcon = parcel.readString();
        this.isBlack = parcel.readByte() != 0;
        this.requiredChangMode = parcel.readByte() != 0;
        this.mode = parcel.readInt();
        this.robotName = parcel.readString();
        this.robotLogo = parcel.readString();
        this.robotHelloWord = parcel.readString();
        this.robotSessionNoEva = parcel.readString();
        this.humanEvaluateList = parcel.createTypedArrayList(CSHumanEvaluateItem.CREATOR);
        this.groupList = parcel.createTypedArrayList(CSGroupItem.CREATOR);
        this.userTipTime = parcel.readInt();
        this.userTipWord = parcel.readString();
        this.adminTipTime = parcel.readInt();
        this.adminTipWord = parcel.readString();
        this.evaEntryPoint = parcel.readInt();
        this.evaType = parcel.readInt();
        this.disableLocation = parcel.readByte() != 0;
        this.reportResolveStatus = parcel.readByte() != 0;
        this.leaveMessageConfigType = parcel.readInt();
        this.leaveMessageWebUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.leaveMessageNativeInfo = parcel.createTypedArrayList(CSLMessageItem.CREATOR);
        this.isSuspendWhenQuit = parcel.readInt();
        this.announceMsgFlag = parcel.readInt();
        this.announceMsg = parcel.readString();
        this.announceClickFlag = parcel.readInt();
        this.announceClickUrl = parcel.readString();
    }
}
