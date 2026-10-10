package io.rong.imlib.model;

import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.model.MentionedInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class MessageContent implements Parcelable {
    private static final String TAG = "MessageContent";
    private long destructTime;
    private boolean isDestruct;
    private MentionedInfo mentionedInfo;
    private UserInfo userInfo;

    protected MessageContent() {
    }

    public abstract byte[] encode();

    public long getDestructTime() {
        return this.destructTime;
    }

    public JSONObject getJSONDestructInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isBurnAfterRead", this.isDestruct);
            jSONObject.put("burnDuration", this.destructTime);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public JSONObject getJSONUserInfo() {
        if (getUserInfo() == null || getUserInfo().getUserId() == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", getUserInfo().getUserId());
            if (!TextUtils.isEmpty(getUserInfo().getName())) {
                jSONObject.put("name", getUserInfo().getName());
            }
            if (getUserInfo().getPortraitUri() != null) {
                jSONObject.put("portrait", getUserInfo().getPortraitUri());
            }
            if (!TextUtils.isEmpty(getUserInfo().getExtra())) {
                jSONObject.put("extra", getUserInfo().getExtra());
            }
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        return jSONObject;
    }

    protected JSONObject getJsonMentionInfo() {
        if (getMentionedInfo() == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", getMentionedInfo().getType().getValue());
            if (getMentionedInfo().getMentionedUserIdList() == null) {
                jSONObject.put("userIdList", (Object) null);
            } else {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = getMentionedInfo().getMentionedUserIdList().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("userIdList", jSONArray);
            }
            jSONObject.put("mentionedContent", getMentionedInfo().getMentionedContent());
        } catch (JSONException e2) {
            RLog.e(TAG, "JSONException " + e2.getMessage());
        }
        return jSONObject;
    }

    public MentionedInfo getMentionedInfo() {
        return this.mentionedInfo;
    }

    public List<String> getSearchableWord() {
        return null;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public boolean isDestruct() {
        return this.destructTime > 0;
    }

    public void parseJsonToDestructInfo(JSONObject jSONObject) {
        try {
            this.isDestruct = jSONObject.getBoolean("isBurnAfterRead");
            this.destructTime = jSONObject.getLong("burnDuration");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    protected MentionedInfo parseJsonToMentionInfo(JSONObject jSONObject) {
        MentionedInfo.MentionedType mentionedTypeValueOf = MentionedInfo.MentionedType.valueOf(jSONObject.optInt("type"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("userIdList");
        String strOptString = jSONObject.optString("mentionedContent");
        if (mentionedTypeValueOf.equals(MentionedInfo.MentionedType.NONE)) {
            return null;
        }
        if (mentionedTypeValueOf.equals(MentionedInfo.MentionedType.ALL)) {
            return new MentionedInfo(mentionedTypeValueOf, null, strOptString);
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                arrayList.add((String) jSONArrayOptJSONArray.get(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new MentionedInfo(mentionedTypeValueOf, arrayList, strOptString);
    }

    public UserInfo parseJsonToUserInfo(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("id");
        String strOptString2 = jSONObject.optString("name");
        String strOptString3 = jSONObject.optString("portrait");
        String strOptString4 = jSONObject.optString("extra");
        if (TextUtils.isEmpty(strOptString3)) {
            strOptString3 = jSONObject.optString("icon");
        }
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        UserInfo userInfo = new UserInfo(strOptString, strOptString2, strOptString3 != null ? Uri.parse(strOptString3) : null);
        userInfo.setExtra(strOptString4);
        return userInfo;
    }

    public void setDestruct(boolean z) {
        this.isDestruct = z;
    }

    public void setDestructTime(long j) {
        this.destructTime = j;
    }

    public void setMentionedInfo(MentionedInfo mentionedInfo) {
        this.mentionedInfo = mentionedInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public MessageContent(byte[] bArr) {
    }
}
