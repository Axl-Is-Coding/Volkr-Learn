package com.localapi;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.umeng.analytics.pro.au;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class Friend {
    public static final int MAX_FRIENDS = 100;

    private Friend() {
    }

    public static JSONObject person(StateStore stateStore, long j) {
        if (j <= 0) {
            return null;
        }
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(j);
        if (jSONObjectFindByUserId != null) {
            return jSONObjectFindByUserId;
        }
        JSONArray jSONArrayCitizens = GameCatalog.citizens(stateStore);
        for (int i = 0; jSONArrayCitizens != null && i < jSONArrayCitizens.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayCitizens.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public static boolean isCitizen(StateStore stateStore, long j) {
        return stateStore.findByUserId(j) == null && person(stateStore, j) != null;
    }

    public static boolean online(StateStore stateStore, long j) {
        return stateStore.isOnline(j);
    }

    private static JSONObject st(StateStore stateStore, JSONObject jSONObject) {
        return stateStore.userState(jSONObject);
    }

    private static JSONArray ids(StateStore stateStore, JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = st(stateStore, jSONObject).optJSONArray(str);
        return jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
    }

    public static boolean isFriend(StateStore stateStore, JSONObject jSONObject, long j) {
        return contains(ids(stateStore, jSONObject, NativeProtocol.AUDIENCE_FRIENDS), j);
    }

    public static boolean isBlacklisted(StateStore stateStore, JSONObject jSONObject, long j) {
        return contains(ids(stateStore, jSONObject, "blacklist"), j);
    }

    private static boolean contains(JSONArray jSONArray, long j) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.optLong(i) == j) {
                return true;
            }
        }
        return false;
    }

    private static void addId(StateStore stateStore, JSONObject jSONObject, String str, long j) throws JSONException {
        JSONArray jSONArrayIds = ids(stateStore, jSONObject, str);
        if (contains(jSONArrayIds, j)) {
            return;
        }
        jSONArrayIds.put(j);
        st(stateStore, jSONObject).put(str, jSONArrayIds);
    }

    private static void removeId(StateStore stateStore, JSONObject jSONObject, String str, long j) throws JSONException {
        JSONArray jSONArrayIds = ids(stateStore, jSONObject, str);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < jSONArrayIds.length(); i++) {
            if (jSONArrayIds.optLong(i) != j) {
                jSONArray.put(jSONArrayIds.optLong(i));
            }
        }
        st(stateStore, jSONObject).put(str, jSONArray);
    }

    public static String aliasOf(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONObject jSONObjectOptJSONObject = st(stateStore, jSONObject).optJSONObject("aliases");
        return jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.optString(String.valueOf(j));
    }

    public static JSONArray pendingRequests(StateStore stateStore, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = st(stateStore, jSONObject).optJSONArray("friendRequestsIn");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                jSONArray.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray;
    }

    public static String add(StateStore stateStore, JSONObject jSONObject, long j, String str) throws JSONException {
        if (j <= 0) {
            return "bad friendId";
        }
        if (j == jSONObject.optLong("userId")) {
            return "cannot add yourself";
        }
        if (isBlacklisted(stateStore, jSONObject, j)) {
            return "user is blacklisted";
        }
        if (isFriend(stateStore, jSONObject, j)) {
            return "already friends";
        }
        if (person(stateStore, j) == null) {
            return "user not found";
        }
        if (friends(stateStore, jSONObject).length() >= 100) {
            return "friend list is full";
        }
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(j);
        if (jSONObjectFindByUserId == null) {
            addId(stateStore, jSONObject, NativeProtocol.AUDIENCE_FRIENDS, j);
            stateStore.save();
            return null;
        }
        JSONArray jSONArrayOptJSONArray = st(stateStore, jSONObjectFindByUserId).optJSONArray("friendRequestsIn");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == jSONObject.optLong("userId") && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                return "request already pending";
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        jSONObject2.put("msg", str == null ? "" : str);
        jSONObject2.put("at", System.currentTimeMillis());
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONArrayOptJSONArray.put(jSONObject2);
        st(stateStore, jSONObjectFindByUserId).put("friendRequestsIn", jSONArrayOptJSONArray);
        stateStore.save();
        return null;
    }

    public static String accept(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONArray jSONArrayOptJSONArray = st(stateStore, jSONObject).optJSONArray("friendRequestsIn");
        boolean z = false;
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                jSONObjectOptJSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 2);
                z = true;
            }
        }
        if (!z) {
            return "no pending request";
        }
        if (friends(stateStore, jSONObject).length() >= 100) {
            return "friend list is full";
        }
        addId(stateStore, jSONObject, NativeProtocol.AUDIENCE_FRIENDS, j);
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(j);
        if (jSONObjectFindByUserId != null) {
            addId(stateStore, jSONObjectFindByUserId, NativeProtocol.AUDIENCE_FRIENDS, jSONObject.optLong("userId"));
        }
        stateStore.save();
        return null;
    }

    public static String reject(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONArray jSONArrayOptJSONArray = st(stateStore, jSONObject).optJSONArray("friendRequestsIn");
        boolean z = false;
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
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

    public static String remove(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        if (!isFriend(stateStore, jSONObject, j)) {
            return "not friends";
        }
        removeId(stateStore, jSONObject, NativeProtocol.AUDIENCE_FRIENDS, j);
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(j);
        if (jSONObjectFindByUserId != null) {
            removeId(stateStore, jSONObjectFindByUserId, NativeProtocol.AUDIENCE_FRIENDS, jSONObject.optLong("userId"));
        }
        stateStore.save();
        return null;
    }

    public static String blacklist(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        if (person(stateStore, j) == null) {
            return "user not found";
        }
        if (j == jSONObject.optLong("userId")) {
            return "cannot blacklist yourself";
        }
        remove(stateStore, jSONObject, j);
        addId(stateStore, jSONObject, "blacklist", j);
        stateStore.save();
        return null;
    }

    public static String setAlias(StateStore stateStore, JSONObject jSONObject, long j, String str) throws JSONException {
        if (!isFriend(stateStore, jSONObject, j)) {
            return "not friends (alias)";
        }
        JSONObject jSONObjectOptJSONObject = st(stateStore, jSONObject).optJSONObject("aliases");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        if (str == null || str.isEmpty()) {
            jSONObjectOptJSONObject.remove(String.valueOf(j));
        } else {
            jSONObjectOptJSONObject.put(String.valueOf(j), str);
        }
        st(stateStore, jSONObject).put("aliases", jSONObjectOptJSONObject);
        stateStore.save();
        return null;
    }

    public static JSONArray friends(StateStore stateStore, JSONObject jSONObject) {
        return ids(stateStore, jSONObject, NativeProtocol.AUDIENCE_FRIENDS);
    }

    public static JSONObject personJson(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectPerson = person(stateStore, j);
        if (jSONObjectPerson == null) {
            return null;
        }
        stateStore.findByUserId(j);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ID", j);
        jSONObject2.put("userId", j);
        jSONObject2.put("localUserId", jSONObject == null ? 0L : jSONObject.optLong("userId"));
        jSONObject2.put("nickName", jSONObjectPerson.optString("nickName"));
        jSONObject2.put("picUrl", (jSONObjectPerson.optString("headPic") == null || jSONObjectPerson.optString("headPic").isEmpty()) ? jSONObjectPerson.optString("picUrl") : jSONObjectPerson.optString("headPic"));
        jSONObject2.put("sex", jSONObjectPerson.optInt("sex"));
        jSONObject2.put("age", 0);
        jSONObject2.put("country", jSONObjectPerson.optString("country"));
        jSONObject2.put("details", jSONObjectPerson.optString("details"));
        jSONObject2.put(au.M, "en");
        jSONObject2.put("expireDate", jSONObjectPerson.optString("expireDate"));
        jSONObject2.put("vip", jSONObjectPerson.optInt("vip"));
        jSONObject2.put("role", 0);
        jSONObject2.put("starCode", jSONObjectPerson.optString("starCode"));
        jSONObject2.put("clanId", jSONObjectPerson.optLong("clanId"));
        jSONObject2.put("clanName", "");
        jSONObject2.put("friend", jSONObject != null && isFriend(stateStore, jSONObject, j));
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, online(stateStore, j) ? 1 : 0);
        jSONObject2.put("logoutTime", 0L);
        jSONObject2.put("gameId", "");
        jSONObject2.put("gameName", "");
        jSONObject2.put("alias", jSONObject != null ? aliasOf(stateStore, jSONObject, j) : "");
        jSONObject2.put("isSearchById", false);
        return jSONObject2;
    }

    public static JSONObject statusBean(StateStore stateStore, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", j);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, online(stateStore, j) ? 1 : 0);
        jSONObject.put("gameId", "");
        jSONObject.put("gameName", "");
        jSONObject.put("gamePic", "");
        jSONObject.put("gamingInfo", JSONObject.NULL);
        jSONObject.put("partyInfo", JSONObject.NULL);
        jSONObject.put("logoutTime", 0L);
        return jSONObject;
    }
}
