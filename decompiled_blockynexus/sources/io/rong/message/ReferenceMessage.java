package io.rong.message;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 3, messageHandler = ReferenceMessageHandler.class, value = "RC:ReferenceMsg")
public class ReferenceMessage extends MediaMessageContent {
    public static final Parcelable.Creator<ReferenceMessage> CREATOR = new Parcelable.Creator<ReferenceMessage>() { // from class: io.rong.message.ReferenceMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReferenceMessage createFromParcel(Parcel parcel) {
            return new ReferenceMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReferenceMessage[] newArray(int i) {
            return new ReferenceMessage[i];
        }
    };
    private static final String TAG = "ReferenceMessage";
    private String content;
    private String extra;
    private String objName;
    private MessageContent referMsg;
    private String referMsgUserId;

    private ReferenceMessage() {
    }

    public static ReferenceMessage obtainMessage(String str, MessageContent messageContent) {
        if (str == null || messageContent == null) {
            return null;
        }
        return new ReferenceMessage(str, messageContent);
    }

    public ReferenceMessage buildSendText(String str) {
        this.content = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getUserId())) {
                jSONObject.put("referMsgUserId", getUserId());
            }
            if (!TextUtils.isEmpty(getEditSendText())) {
                jSONObject.put("content", getEditSendText());
            }
            if (!TextUtils.isEmpty(getObjName())) {
                jSONObject.put("objName", getObjName());
            }
            if (getReferenceContent() != null) {
                jSONObject.putOpt("referMsg", new JSONObject(new String(getReferenceContent().encode(), "UTF-8")));
            }
            if (!TextUtils.isEmpty(getExtra())) {
                jSONObject.put("extra", getExtra());
            }
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
            if (getJsonMentionInfo() != null) {
                jSONObject.putOpt("mentionedInfo", getJsonMentionInfo());
            }
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "encode UnsupportedEncodingException", e2);
        } catch (JSONException e3) {
            RLog.e(TAG, "encode JSONException", e3);
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            RLog.e(TAG, "encode jsonObject UnsupportedEncodingException", e4);
            return null;
        }
    }

    public String getEditSendText() {
        return this.content;
    }

    @Override // io.rong.message.MediaMessageContent
    public String getExtra() {
        return this.extra;
    }

    @Override // io.rong.message.MediaMessageContent
    public Uri getLocalPath() {
        if (this.objName.equals("RC:FileMsg")) {
            return ((FileMessage) this.referMsg).getLocalPath();
        }
        return null;
    }

    @Override // io.rong.message.MediaMessageContent
    public Uri getMediaUrl() {
        if (this.objName.equals("RC:FileMsg")) {
            return ((FileMessage) this.referMsg).getMediaUrl();
        }
        return null;
    }

    @Override // io.rong.message.MediaMessageContent
    public String getName() {
        if (this.objName.equals("RC:FileMsg")) {
            return ((FileMessage) this.referMsg).getName();
        }
        return null;
    }

    String getObjName() {
        return this.objName;
    }

    public MessageContent getReferenceContent() {
        return this.referMsg;
    }

    @Override // io.rong.imlib.model.MessageContent
    public List<String> getSearchableWord() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getEditSendText());
        return arrayList;
    }

    public String getUserId() {
        return this.referMsgUserId;
    }

    public void setContent(MessageContent messageContent) {
        this.referMsg = messageContent;
    }

    public void setEditSendText(String str) {
        this.content = str;
    }

    @Override // io.rong.message.MediaMessageContent
    public void setExtra(String str) {
        this.extra = str;
    }

    @Override // io.rong.message.MediaMessageContent
    public void setLocalPath(Uri uri) {
        if (this.objName.equals("RC:FileMsg")) {
            ((FileMessage) this.referMsg).setLocalPath(uri);
        }
    }

    @Override // io.rong.message.MediaMessageContent
    public void setMediaUrl(Uri uri) {
        if (this.objName.equals("RC:FileMsg")) {
            ((FileMessage) this.referMsg).setMediaUrl(uri);
        }
    }

    @Override // io.rong.message.MediaMessageContent
    public void setName(String str) {
        if (this.objName.equals("RC:FileMsg")) {
            ((FileMessage) this.referMsg).setName(str);
        }
    }

    void setObjName(String str) {
        this.objName = str;
    }

    public void setUserId(String str) {
        this.referMsgUserId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getUserId());
        ParcelUtils.writeToParcel(parcel, getEditSendText());
        ParcelUtils.writeToParcel(parcel, getObjName());
        ParcelUtils.writeToParcel(parcel, getReferenceContent());
        ParcelUtils.writeToParcel(parcel, getExtra());
        ParcelUtils.writeToParcel(parcel, getUserInfo());
        ParcelUtils.writeToParcel(parcel, getMentionedInfo());
    }

    private ReferenceMessage(String str, MessageContent messageContent) {
        MessageTag messageTag;
        this.referMsgUserId = str;
        this.referMsg = messageContent;
        if (messageContent == null) {
            RLog.e(TAG, "MessageContent is null");
            return;
        }
        try {
            messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        } catch (Throwable th) {
            RLog.e(TAG, "throwable:" + th.toString());
            messageTag = null;
        }
        if (messageTag == null) {
            RLog.e(TAG, "MessageTag is null");
        } else {
            if (!Arrays.asList("RC:TxtMsg", "RC:ImgMsg", "RC:FileMsg", "RC:ImgTextMsg", "RC:ReferenceMsg").contains(messageTag.value())) {
                throw new RuntimeException("引用消息不支持此消息类型");
            }
            this.objName = messageTag.value();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public ReferenceMessage(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            RLog.e(TAG, "UnsupportedEncodingException", e2);
            str = null;
        }
        if (str == null) {
            RLog.e(TAG, "jsonStr is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("referMsgUserId")) {
                setUserId(jSONObject.getString("referMsgUserId"));
            }
            if (jSONObject.has("content")) {
                setEditSendText(jSONObject.getString("content"));
            }
            if (jSONObject.has("objName")) {
                setObjName(jSONObject.getString("objName"));
            }
            if (jSONObject.has("referMsg") && !TextUtils.isEmpty(getObjName())) {
                byte[] bytes = ((JSONObject) jSONObject.get("referMsg")).toString().getBytes("UTF-8");
                String objName = getObjName();
                byte b2 = -1;
                switch (objName.hashCode()) {
                    case -961182724:
                        if (objName.equals("RC:FileMsg")) {
                            b2 = 2;
                        }
                        break;
                    case -911587622:
                        if (objName.equals("RC:ImgTextMsg")) {
                            b2 = 3;
                        }
                        break;
                    case -623230209:
                        if (objName.equals("RC:ReferenceMsg")) {
                            b2 = 4;
                        }
                        break;
                    case 751141447:
                        if (objName.equals("RC:ImgMsg")) {
                            b2 = 1;
                        }
                        break;
                    case 1076608122:
                        if (objName.equals("RC:TxtMsg")) {
                            b2 = 0;
                        }
                        break;
                }
                if (b2 == 0) {
                    setContent(new TextMessage(bytes));
                } else if (b2 == 1) {
                    setContent(new ImageMessage(bytes));
                } else if (b2 == 2) {
                    setContent(new FileMessage(bytes));
                } else if (b2 == 3) {
                    setContent(new RichContentMessage(bytes));
                } else if (b2 == 4) {
                    setContent(new ReferenceMessage(bytes));
                }
            }
            if (jSONObject.has("extra")) {
                setExtra(jSONObject.getString("extra"));
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
            if (jSONObject.has("mentionedInfo")) {
                setMentionedInfo(parseJsonToMentionInfo(jSONObject.getJSONObject("mentionedInfo")));
            }
        } catch (UnsupportedEncodingException e3) {
            RLog.e(TAG, "ReferenceMessage UnsupportedEncodingException", e3);
        } catch (JSONException e4) {
            RLog.e(TAG, "JSONException " + e4.getMessage());
        }
    }

    public ReferenceMessage(Parcel parcel) {
        setUserId(parcel.readString());
        setEditSendText(parcel.readString());
        setObjName(parcel.readString());
        setContent((MessageContent) ParcelUtils.readFromParcel(parcel, MessageContent.class));
        setExtra(parcel.readString());
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
        setMentionedInfo((MentionedInfo) ParcelUtils.readFromParcel(parcel, MentionedInfo.class));
    }
}
