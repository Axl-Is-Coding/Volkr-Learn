package com.sandboxol.imchat.message.entity;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@MessageTag(flag = 3, value = "app:team")
public class InviteTeamMessage extends MessageContent {
    public static final Parcelable.Creator<InviteTeamMessage> CREATOR = new Parcelable.Creator<InviteTeamMessage>() { // from class: com.sandboxol.imchat.message.entity.InviteTeamMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InviteTeamMessage createFromParcel(Parcel parcel) {
            return new InviteTeamMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InviteTeamMessage[] newArray(int i) {
            return new InviteTeamMessage[i];
        }
    };
    private long captainId;
    private String captainName;
    private String captainPicUrl;
    private String chatRoomId;
    private String gameName;
    private String gameType;
    private long gameVersion;
    private int isNewEngine;
    private int isUgc;
    private int maxMember;
    private int memberCount;
    private String picUrl;
    private String psid;
    private String roomName;
    private int teamCount;
    private String teamId;
    private int teamType;

    public InviteTeamMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gameName", this.gameName);
            jSONObject.put("picUrl", this.picUrl);
            jSONObject.put("captainPicUrl", this.captainPicUrl);
            jSONObject.put("gameType", this.gameType);
            jSONObject.put("captainId", this.captainId);
            jSONObject.put("captainName", this.captainName);
            jSONObject.put("chatRoomId", this.chatRoomId);
            jSONObject.put("teamId", this.teamId);
            jSONObject.put("gameVersion", this.gameVersion);
            jSONObject.put("rooName", this.roomName);
            jSONObject.put("maxMember", this.maxMember);
            jSONObject.put("memberCount", this.memberCount);
            jSONObject.put("teamCount", this.teamCount);
            jSONObject.put("teamType", this.teamType);
            jSONObject.put("psid", this.psid);
            jSONObject.put("isNewEngine", this.isNewEngine);
            jSONObject.put("isUgc", this.isUgc);
            if (getJSONUserInfo() != null) {
                jSONObject.putOpt("user", getJSONUserInfo());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public long getCaptainId() {
        return this.captainId;
    }

    public String getCaptainName() {
        String str = this.captainName;
        return str == null ? "" : str;
    }

    public String getCaptainPicUrl() {
        String str = this.captainPicUrl;
        return str == null ? "" : str;
    }

    public String getChatRoomId() {
        String str = this.chatRoomId;
        return str == null ? "" : str;
    }

    public String getGameName() {
        String str = this.gameName;
        return str == null ? "" : str;
    }

    public String getGameType() {
        String str = this.gameType;
        return str == null ? "" : str;
    }

    public long getGameVersion() {
        return this.gameVersion;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public int getIsUgc() {
        return this.isUgc;
    }

    public int getMaxMember() {
        return this.maxMember;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getPicUrl() {
        String str = this.picUrl;
        return str == null ? "" : str;
    }

    public String getPsid() {
        return this.psid;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getTeamCount() {
        return this.teamCount;
    }

    public String getTeamId() {
        String str = this.teamId;
        return str == null ? "" : str;
    }

    public int getTeamType() {
        return this.teamType;
    }

    public void setCaptainId(long j) {
        this.captainId = j;
    }

    public void setCaptainName(String str) {
        this.captainName = str;
    }

    public void setCaptainPicUrl(String str) {
        this.captainPicUrl = str;
    }

    public void setChatRoomId(String str) {
        this.chatRoomId = str;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameType(String str) {
        this.gameType = str;
    }

    public void setGameVersion(long j) {
        this.gameVersion = j;
    }

    public void setIsNewEngine(int i) {
        this.isNewEngine = i;
    }

    public void setIsUgc(int i) {
        this.isUgc = i;
    }

    public void setMaxMember(int i) {
        this.maxMember = i;
    }

    public void setMemberCount(int i) {
        this.memberCount = i;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPsid(String str) {
        this.psid = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setTeamCount(int i) {
        this.teamCount = i;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setTeamType(int i) {
        this.teamType = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.gameName);
        ParcelUtils.writeToParcel(parcel, this.picUrl);
        ParcelUtils.writeToParcel(parcel, this.captainPicUrl);
        ParcelUtils.writeToParcel(parcel, this.gameType);
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.captainId));
        ParcelUtils.writeToParcel(parcel, this.captainName);
        ParcelUtils.writeToParcel(parcel, this.chatRoomId);
        ParcelUtils.writeToParcel(parcel, this.teamId);
        ParcelUtils.writeToParcel(parcel, Long.valueOf(this.gameVersion));
        ParcelUtils.writeToParcel(parcel, this.roomName);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.maxMember));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.memberCount));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.teamCount));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.teamType));
        ParcelUtils.writeToParcel(parcel, this.psid);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isNewEngine));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.isUgc));
        ParcelUtils.writeToParcel(parcel, getUserInfo());
    }

    public InviteTeamMessage(Parcel parcel) {
        this.gameName = ParcelUtils.readFromParcel(parcel);
        this.picUrl = ParcelUtils.readFromParcel(parcel);
        this.captainPicUrl = ParcelUtils.readFromParcel(parcel);
        this.gameType = ParcelUtils.readFromParcel(parcel);
        this.captainId = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.captainName = ParcelUtils.readFromParcel(parcel);
        this.chatRoomId = ParcelUtils.readFromParcel(parcel);
        this.teamId = ParcelUtils.readFromParcel(parcel);
        this.gameVersion = ParcelUtils.readLongFromParcel(parcel).longValue();
        this.roomName = ParcelUtils.readFromParcel(parcel);
        this.maxMember = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.memberCount = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.teamCount = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.teamType = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.psid = ParcelUtils.readFromParcel(parcel);
        this.isNewEngine = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.isUgc = ParcelUtils.readIntFromParcel(parcel).intValue();
        setUserInfo((UserInfo) ParcelUtils.readFromParcel(parcel, UserInfo.class));
    }

    public InviteTeamMessage(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, long j2, String str8, int i, int i2, int i3, int i4, String str9, int i5, int i6) {
        this.gameName = str;
        this.picUrl = str3;
        this.captainPicUrl = str4;
        this.gameType = str2;
        this.captainId = j;
        this.captainName = str5;
        this.chatRoomId = str6;
        this.teamId = str7;
        this.gameVersion = j2;
        this.roomName = str8;
        this.maxMember = i;
        this.memberCount = i2;
        this.teamCount = i3;
        this.teamType = i4;
        this.psid = str9;
        this.isNewEngine = i5;
        this.isUgc = i6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InviteTeamMessage(byte[] bArr) {
        String str;
        String str2;
        String str3;
        try {
            str = "teamType";
            str2 = "teamCount";
            try {
                str3 = new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
                str3 = null;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str = "teamType";
            str2 = "teamCount";
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.has("gameName")) {
                this.gameName = jSONObject.optString("gameName");
            }
            if (jSONObject.has("picUrl")) {
                this.picUrl = jSONObject.optString("picUrl");
            }
            if (jSONObject.has("captainPicUrl")) {
                this.captainPicUrl = jSONObject.optString("captainPicUrl");
            }
            if (jSONObject.has("gameType")) {
                this.gameType = jSONObject.optString("gameType");
            }
            if (jSONObject.has("captainId")) {
                this.captainId = jSONObject.optLong("captainId");
            }
            if (jSONObject.has("captainName")) {
                this.captainName = jSONObject.optString("captainName");
            }
            if (jSONObject.has("chatRoomId")) {
                this.chatRoomId = jSONObject.optString("chatRoomId");
            }
            if (jSONObject.has("teamId")) {
                this.teamId = jSONObject.optString("teamId");
            }
            if (jSONObject.has("gameVersion")) {
                this.gameVersion = jSONObject.optLong("gameVersion");
            }
            if (jSONObject.has("rooName")) {
                this.roomName = jSONObject.optString("rooName");
            }
            if (jSONObject.has("maxMember")) {
                this.maxMember = jSONObject.optInt("maxMember");
            }
            if (jSONObject.has("memberCount")) {
                this.memberCount = jSONObject.optInt("memberCount");
            }
            String str4 = str2;
            if (jSONObject.has(str4)) {
                this.teamCount = jSONObject.optInt(str4);
            }
            String str5 = str;
            if (jSONObject.has(str5)) {
                this.teamType = jSONObject.optInt(str5);
            }
            if (jSONObject.has("psid")) {
                this.psid = jSONObject.optString("psid");
            }
            if (jSONObject.has("isNewEngine")) {
                this.isNewEngine = jSONObject.optInt("isNewEngine");
            }
            if (jSONObject.has("isUgc")) {
                this.isUgc = jSONObject.optInt("isUgc");
            }
            if (jSONObject.has("user")) {
                setUserInfo(parseJsonToUserInfo(jSONObject.getJSONObject("user")));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
