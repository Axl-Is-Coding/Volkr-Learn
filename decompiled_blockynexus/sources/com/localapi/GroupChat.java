package com.localapi;

import com.facebook.internal.AnalyticsEvents;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class GroupChat {
    public static final int DAILY_INVITE_LIMIT = 20;

    private GroupChat() {
    }

    private static JSONObject groups(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        JSONObject jSONObjectOptJSONObject = jSONObjectRoot.optJSONObject("groupChats");
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObjectRoot.put("groupChats", jSONObject);
        return jSONObject;
    }

    private static long nextGroupId(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        long jOptLong = jSONObjectRoot.optLong("nextGroupId", 30001L);
        jSONObjectRoot.put("nextGroupId", 1 + jOptLong);
        return jOptLong;
    }

    private static long nextRequestId(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        long jOptLong = jSONObjectRoot.optLong("nextGroupRequestId", 1L);
        jSONObjectRoot.put("nextGroupRequestId", 1 + jOptLong);
        return jOptLong;
    }

    public static JSONObject find(StateStore stateStore, long j) {
        if (j <= 0) {
            return null;
        }
        return groups(stateStore).optJSONObject(String.valueOf(j));
    }

    public static JSONObject memberOf(JSONObject jSONObject, long j) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public static int identityOf(JSONObject jSONObject, long j) {
        JSONObject jSONObjectMemberOf = memberOf(jSONObject, j);
        if (jSONObjectMemberOf == null) {
            return -1;
        }
        return jSONObjectMemberOf.optInt("identity");
    }

    public static boolean canManage(JSONObject jSONObject, long j) {
        int iIdentityOf = identityOf(jSONObject, j);
        return iIdentityOf == 2 || iIdentityOf == 1;
    }

    public static JSONObject create(StateStore stateStore, JSONObject jSONObject, JSONArray jSONArray, String str) throws JSONException {
        long jOptLong = jSONObject.optLong("userId");
        long jNextGroupId = nextGroupId(stateStore);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("groupId", jNextGroupId);
        if (str == null || str.isEmpty()) {
            str = "Group" + jNextGroupId;
        }
        jSONObject2.put("groupName", str);
        jSONObject2.put("groupNotice", "");
        jSONObject2.put("groupPic", "");
        jSONObject2.put("noticePic", new JSONArray());
        jSONObject2.put("inviteStatus", 0);
        jSONObject2.put("officialGroup", 0);
        jSONObject2.put("ownerId", jOptLong);
        jSONObject2.put("muteAll", 0);
        jSONObject2.put("createdAt", System.currentTimeMillis());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(memberEntry(jSONObject, 2));
        jSONObject2.put("members", jSONArray2);
        jSONObject2.put("joinRequests", new JSONArray());
        groups(stateStore).put(String.valueOf(jNextGroupId), jSONObject2);
        jSONObject.put("groupId", jNextGroupId);
        addMembers(stateStore, jSONObject2, jSONArray);
        stateStore.save();
        return jSONObject2;
    }

    private static JSONObject memberEntry(JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        jSONObject2.put("userName", jSONObject.optString("nickName"));
        jSONObject2.put("pic", jSONObject.optString("picUrl").isEmpty() ? jSONObject.optString("headPic") : jSONObject.optString("picUrl"));
        jSONObject2.put("vip", jSONObject.optInt("vip"));
        jSONObject2.put("identity", i);
        jSONObject2.put("banUntil", 0L);
        return jSONObject2;
    }

    private static void addMembers(StateStore stateStore, JSONObject jSONObject, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObjectPerson;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObject.put("members", jSONArrayOptJSONArray);
        }
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            long jOptLong = jSONArray.optLong(i);
            if (jOptLong > 0 && memberOf(jSONObject, jOptLong) == null && (jSONObjectPerson = Friend.person(stateStore, jOptLong)) != null) {
                JSONObject jSONObjectFindByUserId = stateStore.findByUserId(jOptLong);
                if (jSONObjectFindByUserId != null) {
                    jSONObjectPerson = jSONObjectFindByUserId;
                }
                jSONArrayOptJSONArray.put(memberEntry(jSONObjectPerson, 0));
            }
        }
    }

    public static String quit(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        long jOptLong = jSONObject.optLong("userId");
        if (memberOf(jSONObjectFind, jOptLong) == null) {
            return "not a member";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("members");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") != jOptLong) {
                jSONArray.put(jSONObjectOptJSONObject);
            }
        }
        if (identityOf(jSONObjectFind, jOptLong) == 2) {
            if (jSONArray.length() == 0) {
                groups(stateStore).remove(String.valueOf(j));
                stateStore.save();
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(0);
            jSONObjectOptJSONObject2.put("identity", 2);
            jSONObjectFind.put("ownerId", jSONObjectOptJSONObject2.optLong("userId"));
        }
        jSONObjectFind.put("members", jSONArray);
        stateStore.save();
        return null;
    }

    public static String kick(StateStore stateStore, JSONObject jSONObject, long j, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (!canManage(jSONObjectFind, jSONObject.optLong("userId"))) {
            return "no permission";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("members");
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                boolean z = false;
                for (int i2 = 0; jSONArray != null && i2 < jSONArray.length(); i2++) {
                    if (jSONArray.optLong(i2) == jSONObjectOptJSONObject.optLong("userId")) {
                        z = true;
                    }
                }
                if (!z || jSONObjectOptJSONObject.optInt("identity") == 2) {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        jSONObjectFind.put("members", jSONArray2);
        stateStore.save();
        return null;
    }

    public static String setManagers(StateStore stateStore, JSONObject jSONObject, long j, JSONArray jSONArray, int i) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (identityOf(jSONObjectFind, jSONObject.optLong("userId")) != 2) {
            return "only the owner can set managers";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("members");
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("identity") != 2) {
                for (int i3 = 0; jSONArray != null && i3 < jSONArray.length(); i3++) {
                    if (jSONArray.optLong(i3) == jSONObjectOptJSONObject.optLong("userId")) {
                        jSONObjectOptJSONObject.put("identity", i != 0 ? 1 : 0);
                    }
                }
            }
        }
        stateStore.save();
        return null;
    }

    public static String transfer(StateStore stateStore, JSONObject jSONObject, long j, long j2) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (identityOf(jSONObjectFind, jSONObject.optLong("userId")) != 2) {
            return "only the owner can transfer";
        }
        JSONObject jSONObjectMemberOf = memberOf(jSONObjectFind, j2);
        if (jSONObjectMemberOf == null) {
            return "target is not a member";
        }
        memberOf(jSONObjectFind, jSONObject.optLong("userId")).put("identity", 0);
        jSONObjectMemberOf.put("identity", 2);
        jSONObjectFind.put("ownerId", j2);
        stateStore.save();
        return null;
    }

    public static String banMember(StateStore stateStore, JSONObject jSONObject, long j, long j2, int i) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (!canManage(jSONObjectFind, jSONObject.optLong("userId"))) {
            return "no permission";
        }
        JSONObject jSONObjectMemberOf = memberOf(jSONObjectFind, j2);
        if (jSONObjectMemberOf == null) {
            return "not a member";
        }
        if (jSONObjectMemberOf.optInt("identity") == 2) {
            return "cannot ban the owner";
        }
        jSONObjectMemberOf.put("banUntil", System.currentTimeMillis() + (((long) Math.max(1, i)) * 60000));
        stateStore.save();
        return null;
    }

    public static String unbanMember(StateStore stateStore, JSONObject jSONObject, long j, long j2) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (!canManage(jSONObjectFind, jSONObject.optLong("userId"))) {
            return "no permission";
        }
        JSONObject jSONObjectMemberOf = memberOf(jSONObjectFind, j2);
        if (jSONObjectMemberOf == null) {
            return "not a member";
        }
        jSONObjectMemberOf.put("banUntil", 0L);
        stateStore.save();
        return null;
    }

    public static String toggleMuteAll(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (!canManage(jSONObjectFind, jSONObject.optLong("userId"))) {
            return "no permission";
        }
        jSONObjectFind.put("muteAll", jSONObjectFind.optInt("muteAll") == 0 ? 1 : 0);
        stateStore.save();
        return null;
    }

    public static String apply(StateStore stateStore, JSONObject jSONObject, long j, String str) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        long jOptLong = jSONObject.optLong("userId");
        if (memberOf(jSONObjectFind, jOptLong) != null) {
            return "already a member";
        }
        if (jSONObjectFind.optInt("inviteStatus") == 1) {
            jSONObjectFind.optJSONArray("members").put(memberEntry(jSONObject, 0));
            stateStore.save();
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("joinRequests");
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == jOptLong && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                return "request already pending";
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("requestId", nextRequestId(stateStore));
        jSONObject2.put("userId", jOptLong);
        if (str == null) {
            str = "";
        }
        jSONObject2.put("msg", str);
        jSONObject2.put("at", System.currentTimeMillis());
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONObject2.put("type", 1);
        jSONArrayOptJSONArray.put(jSONObject2);
        stateStore.save();
        return null;
    }

    public static String invite(StateStore stateStore, JSONObject jSONObject, long j, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        if (!canManage(jSONObjectFind, jSONObject.optLong("userId"))) {
            return "no permission";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("joinRequests");
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            long jOptLong = jSONArray.optLong(i);
            if (jOptLong > 0 && memberOf(jSONObjectFind, jOptLong) == null) {
                if (stateStore.findByUserId(jOptLong) == null) {
                    addMembers(stateStore, jSONObjectFind, new JSONArray().put(jOptLong));
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("requestId", nextRequestId(stateStore));
                    jSONObject2.put("userId", jSONObject.optLong("userId"));
                    jSONObject2.put("inviteeId", jOptLong);
                    jSONObject2.put("msg", "");
                    jSONObject2.put("at", System.currentTimeMillis());
                    jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
                    jSONObject2.put("type", 2);
                    jSONArrayOptJSONArray.put(jSONObject2);
                }
            }
        }
        stateStore.save();
        return null;
    }

    public static String acceptRequest(StateStore stateStore, JSONObject jSONObject, long j, long j2, long j3) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("joinRequests");
        JSONObject jSONObject2 = null;
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("requestId") == j2 && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                jSONObject2 = jSONObjectOptJSONObject;
            }
        }
        if (jSONObject2 == null) {
            return "no pending request";
        }
        if (jSONObject2.optInt("type") == 2) {
            if (jSONObject2.optLong("inviteeId") != jSONObject.optLong("userId")) {
                return "not your invitation";
            }
        } else if (!canManage(jSONObjectFind, jSONObject.optLong("userId"))) {
            return "no permission";
        }
        if (jSONObject2.optInt("type") == 2 && memberOf(jSONObjectFind, jSONObject.optLong("userId")) != null) {
            return "already a member";
        }
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(jSONObject2.optInt("type") == 2 ? jSONObject.optLong("userId") : j3);
        if (jSONObjectFindByUserId == null) {
            return "user not found";
        }
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 2);
        jSONObjectFind.optJSONArray("members").put(memberEntry(jSONObjectFindByUserId, 0));
        stateStore.save();
        return null;
    }

    public static String rejectRequest(StateStore stateStore, JSONObject jSONObject, long j, long j2) throws JSONException {
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "group not found";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("joinRequests");
        boolean z = false;
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("requestId") == j2 && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                jSONObjectOptJSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 3);
                z = true;
            }
        }
        if (!z) {
            return "no pending request";
        }
        stateStore.save();
        return null;
    }

    public static JSONArray mine(StateStore stateStore, long j) throws JSONException {
        JSONObject jSONObjectGroups = groups(stateStore);
        JSONArray jSONArrayNames = jSONObjectGroups.names();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayNames != null && i < jSONArrayNames.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONObjectGroups.optJSONObject(jSONArrayNames.optString(i));
            if (jSONObjectOptJSONObject != null && memberOf(jSONObjectOptJSONObject, j) != null) {
                jSONArray.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray requestFeed(com.localapi.StateStore r17, long r18) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.localapi.GroupChat.requestFeed(com.localapi.StateStore, long):org.json.JSONArray");
    }

    public static JSONObject groupJson(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("groupId", jSONObject.optLong("groupId"));
        jSONObject2.put("groupName", jSONObject.optString("groupName"));
        jSONObject2.put("groupNotice", jSONObject.optString("groupNotice"));
        jSONObject2.put("groupPic", jSONObject.optString("groupPic"));
        jSONObject2.put("noticePic", jSONObject.optJSONArray("noticePic") == null ? new JSONArray() : jSONObject.optJSONArray("noticePic"));
        jSONObject2.put("inviteStatus", jSONObject.optInt("inviteStatus"));
        jSONObject2.put("officialGroup", jSONObject.optInt("officialGroup"));
        jSONObject2.put("ownerId", String.valueOf(jSONObject.optLong("ownerId")));
        jSONObject2.put("releaseTime", "");
        jSONObject2.put("muteAll", jSONObject.optInt("muteAll"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        JSONArray jSONArray = new JSONArray();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("userId", jSONObjectOptJSONObject.optLong("userId"));
                jSONObject3.put("userName", jSONObjectOptJSONObject.optString("userName"));
                jSONObject3.put("pic", jSONObjectOptJSONObject.optString("pic"));
                jSONObject3.put("vip", jSONObjectOptJSONObject.optInt("vip"));
                jSONObject3.put("identity", jSONObjectOptJSONObject.optInt("identity"));
                jSONObject3.put("banStatus", jSONObjectOptJSONObject.optLong("banUntil") > jCurrentTimeMillis ? 1 : 0);
                jSONArray.put(jSONObject3);
            }
        }
        jSONObject2.put("groupMembers", jSONArray);
        jSONObject2.put("forbiddenWordsStatus", jSONObject.optInt("muteAll"));
        return jSONObject2;
    }
}
