package com.localapi;

import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class Tribe {
    public static final long CREATE_FEE_DIAMONDS = 60;
    public static final long CREATE_FEE_GOLDS = 8000;
    public static final int MAX_MEMBERS_BASE = 20;

    private Tribe() {
    }

    private static JSONObject clans(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        JSONObject jSONObjectOptJSONObject = jSONObjectRoot.optJSONObject("tribes");
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObjectRoot.put("tribes", jSONObject);
        return jSONObject;
    }

    private static long nextClanId(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        long jOptLong = jSONObjectRoot.optLong("nextClanId", 50001L);
        jSONObjectRoot.put("nextClanId", 1 + jOptLong);
        return jOptLong;
    }

    public static JSONObject find(StateStore stateStore, long j) {
        if (j <= 0) {
            return null;
        }
        return clans(stateStore).optJSONObject(String.valueOf(j));
    }

    public static JSONObject clanOf(StateStore stateStore, JSONObject jSONObject) {
        return find(stateStore, jSONObject.optLong("clanId"));
    }

    public static JSONObject memberOf(JSONObject jSONObject, long j) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public static int roleOf(JSONObject jSONObject, long j) {
        JSONObject jSONObjectMemberOf = memberOf(jSONObject, j);
        if (jSONObjectMemberOf == null) {
            return -1;
        }
        return jSONObjectMemberOf.optInt("role");
    }

    public static boolean nameTaken(StateStore stateStore, String str, long j) {
        JSONArray jSONArrayNames = clans(stateStore).names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                JSONObject jSONObjectOptJSONObject = clans(stateStore).optJSONObject(jSONArrayNames.optString(i));
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("clanId") != j && str.equalsIgnoreCase(jSONObjectOptJSONObject.optString("name"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String create(StateStore stateStore, JSONObject jSONObject, String str, String str2, String str3, JSONArray jSONArray, int i) throws JSONException {
        long jOptLong = jSONObject.optLong("userId");
        if (jSONObject.optLong("clanId") > 0) {
            return "already in a clan";
        }
        if (str == null || str.trim().isEmpty()) {
            return "clan name required";
        }
        String strReplace = str.trim().replace(UMCustomLogInfoBuilder.LINE_SEP, " ");
        if (nameTaken(stateStore, strReplace, 0L)) {
            return "clan name taken";
        }
        long j = i == 1 ? 60L : CREATE_FEE_GOLDS;
        String str4 = i == 1 ? StringConstant.CHRISTMAS_DIAMONDS : StringConstant.CHRISTMAS_GOLDS;
        if (jSONObject.optLong(str4) < j) {
            return "not enough " + str4 + " to create a clan";
        }
        stateStore.award(jSONObject, str4, -j);
        long jNextClanId = nextClanId(stateStore);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", jNextClanId);
        jSONObject2.put("name", strReplace);
        jSONObject2.put("details", str2 == null ? "" : str2);
        jSONObject2.put("headPic", str3 != null ? str3 : "");
        jSONObject2.put("tags", jSONArray == null ? new JSONArray() : jSONArray);
        jSONObject2.put("experience", 0L);
        jSONObject2.put("currency", 0L);
        jSONObject2.put("freeVerify", 0);
        jSONObject2.put("chiefId", jOptLong);
        jSONObject2.put("createdAt", System.currentTimeMillis());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(memberEntry(jSONObject, 20));
        jSONObject2.put("members", jSONArray2);
        jSONObject2.put("bulletin", new JSONObject());
        jSONObject2.put("joinRequests", new JSONArray());
        jSONObject2.put("invitations", new JSONArray());
        jSONObject2.put("donations", new JSONArray());
        jSONObject2.put("purchases", new JSONArray());
        clans(stateStore).put(String.valueOf(jNextClanId), jSONObject2);
        jSONObject.put("clanId", jNextClanId);
        stateStore.save();
        return null;
    }

    private static JSONObject memberEntry(JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        jSONObject2.put("role", i);
        jSONObject2.put("experience", 0);
        jSONObject2.put("expireDate", jSONObject.optString("expireDate"));
        jSONObject2.put("headPic", jSONObject.optString("picUrl"));
        jSONObject2.put("nickName", jSONObject.optString("nickName"));
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONObject2.put("vip", jSONObject.optInt("vip"));
        return jSONObject2;
    }

    public static String dissolve(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectFindByUserId;
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        if (roleOf(jSONObjectClanOf, jSONObject.optLong("userId")) != 20) {
            return "only the chief can dissolve";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("members");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (jSONObjectFindByUserId = stateStore.findByUserId(jSONObjectOptJSONObject.optLong("userId"))) != null) {
                    jSONObjectFindByUserId.put("clanId", 0);
                    jSONObjectFindByUserId.put("clanQuitAt", System.currentTimeMillis());
                }
            }
        }
        clans(stateStore).remove(String.valueOf(jSONObjectClanOf.optLong("clanId")));
        stateStore.save();
        return null;
    }

    public static String exit(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        long jOptLong = jSONObject.optLong("userId");
        if (roleOf(jSONObjectClanOf, jOptLong) == 20) {
            return "the chief cannot leave; dissolve instead";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("members");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") != jOptLong) {
                    jSONArray.put(jSONObjectOptJSONObject);
                }
            }
        }
        jSONObjectClanOf.put("members", jSONArray);
        jSONObject.put("clanId", 0);
        jSONObject.put("clanQuitAt", System.currentTimeMillis());
        stateStore.save();
        return null;
    }

    public static String kick(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        int iRoleOf = roleOf(jSONObjectClanOf, jSONObject.optLong("userId"));
        if (iRoleOf != 20 && iRoleOf != 10) {
            return "no permission";
        }
        JSONObject jSONObjectMemberOf = memberOf(jSONObjectClanOf, j);
        if (jSONObjectMemberOf == null) {
            return "not a member";
        }
        if (jSONObjectMemberOf.optInt("role") == 20) {
            return "cannot remove the chief";
        }
        if (jSONObjectMemberOf.optInt("role") > 0 && iRoleOf != 20) {
            return "cannot remove chiefs or elders";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("members");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") != j) {
                    jSONArray.put(jSONObjectOptJSONObject);
                }
            }
        }
        jSONObjectClanOf.put("members", jSONArray);
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(j);
        if (jSONObjectFindByUserId != null) {
            jSONObjectFindByUserId.put("clanId", 0);
            jSONObjectFindByUserId.put("clanQuitAt", System.currentTimeMillis());
        }
        stateStore.save();
        return null;
    }

    public static String setIdentity(StateStore stateStore, JSONObject jSONObject, long j, int i) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        if (roleOf(jSONObjectClanOf, jSONObject.optLong("userId")) != 20) {
            return "only the chief can set roles";
        }
        JSONObject jSONObjectMemberOf = memberOf(jSONObjectClanOf, j);
        if (jSONObjectMemberOf == null) {
            return "not a member";
        }
        long jOptLong = jSONObject.optLong("userId");
        if (i == 3) {
            if (jSONObjectMemberOf.optInt("role") == 20 || j == jOptLong) {
                return "cannot change the chief";
            }
            jSONObjectMemberOf.put("role", 20);
            JSONObject jSONObjectMemberOf2 = memberOf(jSONObjectClanOf, jOptLong);
            if (jSONObjectMemberOf2 != null) {
                jSONObjectMemberOf2.put("role", 0);
            }
            jSONObjectClanOf.put("chiefId", j);
            stateStore.save();
            return null;
        }
        if (jSONObjectMemberOf.optInt("role") == 20 || j == jOptLong) {
            return "cannot change the chief";
        }
        if (i == 1) {
            jSONObjectMemberOf.put("role", 10);
            stateStore.save();
            return null;
        }
        if (i == 2) {
            jSONObjectMemberOf.put("role", 0);
            stateStore.save();
            return null;
        }
        return "bad role type";
    }

    static Long joinCooldownLeft(JSONObject jSONObject) {
        long jOptLong = jSONObject.optLong("clanQuitAt");
        if (jOptLong <= 0) {
            return null;
        }
        long jCurrentTimeMillis = (jOptLong + 86400000) - System.currentTimeMillis();
        if (jCurrentTimeMillis > 0) {
            return Long.valueOf(jCurrentTimeMillis);
        }
        return null;
    }

    public static String requestJoin(StateStore stateStore, JSONObject jSONObject, long j, String str) throws JSONException {
        if (jSONObject.optLong("clanId") > 0) {
            return "already in a clan";
        }
        if (joinCooldownLeft(jSONObject) != null) {
            return "you can join a clan again after 24 hours";
        }
        JSONObject jSONObjectFind = find(stateStore, j);
        if (jSONObjectFind == null) {
            return "clan not found";
        }
        if (members(jSONObjectFind).length() >= maxMembers(jSONObjectFind)) {
            return "clan is full";
        }
        long jOptLong = jSONObject.optLong("userId");
        if (jSONObjectFind.optInt("freeVerify") == 1) {
            return join(stateStore, jSONObjectFind, jSONObject);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFind.optJSONArray("joinRequests");
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == jOptLong && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                return "already requested";
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", jOptLong);
        if (str == null) {
            str = "";
        }
        jSONObject2.put("msg", str);
        jSONObject2.put("at", System.currentTimeMillis());
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONArrayOptJSONArray.put(jSONObject2);
        stateStore.save();
        return null;
    }

    public static String agreeJoin(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        int iRoleOf = roleOf(jSONObjectClanOf, jSONObject.optLong("userId"));
        if (iRoleOf != 20 && iRoleOf != 10) {
            return "no permission";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("joinRequests");
        JSONObject jSONObject2 = null;
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == j && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                jSONObject2 = jSONObjectOptJSONObject;
            }
        }
        if (jSONObject2 == null) {
            return "no pending request";
        }
        JSONObject jSONObjectFindByUserId = stateStore.findByUserId(j);
        if (jSONObjectFindByUserId == null) {
            return "user not found";
        }
        if (jSONObjectFindByUserId.optLong("clanId") > 0) {
            jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 3);
            stateStore.save();
            return "user already in a clan";
        }
        if (members(jSONObjectClanOf).length() >= maxMembers(jSONObjectClanOf)) {
            return "clan is full";
        }
        if (joinCooldownLeft(jSONObjectFindByUserId) != null) {
            jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 3);
            stateStore.save();
            return "you can join a clan again after 24 hours";
        }
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 2);
        String strJoin = join(stateStore, jSONObjectClanOf, jSONObjectFindByUserId);
        if (strJoin != null) {
            return strJoin;
        }
        return null;
    }

    public static String rejectJoin(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        int iRoleOf = roleOf(jSONObjectClanOf, jSONObject.optLong("userId"));
        if (iRoleOf != 20 && iRoleOf != 10) {
            return "no permission";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("joinRequests");
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

    public static String invite(StateStore stateStore, JSONObject jSONObject, JSONArray jSONArray, String str) throws JSONException {
        JSONObject jSONObjectFindByUserId;
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        int iRoleOf = roleOf(jSONObjectClanOf, jSONObject.optLong("userId"));
        if (iRoleOf != 20 && iRoleOf != 10) {
            return "no permission";
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("invitations");
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            long jOptLong = jSONArray.optLong(i);
            if (jOptLong > 0 && (jSONObjectFindByUserId = stateStore.findByUserId(jOptLong)) != null && jSONObjectFindByUserId.optLong("clanId") <= 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", nextInviteId(stateStore));
                jSONObject2.put("userId", jSONObject.optLong("userId"));
                jSONObject2.put("inviteeId", jOptLong);
                jSONObject2.put("msg", str == null ? "" : str);
                jSONObject2.put("at", System.currentTimeMillis());
                jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
                jSONArrayOptJSONArray.put(jSONObject2);
            }
        }
        stateStore.save();
        return null;
    }

    private static long nextInviteId(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        long jOptLong = jSONObjectRoot.optLong("nextInviteId", 1L);
        jSONObjectRoot.put("nextInviteId", 1 + jOptLong);
        return jOptLong;
    }

    public static String agreeInvitation(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        if (jSONObject.optLong("clanId") > 0) {
            return "already in a clan";
        }
        if (joinCooldownLeft(jSONObject) != null) {
            return "you can join a clan again after 24 hours";
        }
        JSONObject jSONObjectFindInvitationClan = findInvitationClan(stateStore, j, jSONObject.optLong("userId"));
        if (jSONObjectFindInvitationClan == null) {
            return "invitation not found";
        }
        if (members(jSONObjectFindInvitationClan).length() >= maxMembers(jSONObjectFindInvitationClan)) {
            return "clan is full";
        }
        markInvitation(jSONObjectFindInvitationClan, j, 2);
        return join(stateStore, jSONObjectFindInvitationClan, jSONObject);
    }

    public static String rejectInvitation(StateStore stateStore, JSONObject jSONObject, long j) throws JSONException {
        JSONObject jSONObjectFindInvitationClan = findInvitationClan(stateStore, j, jSONObject.optLong("userId"));
        if (jSONObjectFindInvitationClan == null) {
            return "invitation not found";
        }
        markInvitation(jSONObjectFindInvitationClan, j, 3);
        stateStore.save();
        return null;
    }

    private static JSONObject findInvitationClan(StateStore stateStore, long j, long j2) {
        JSONArray jSONArrayNames = clans(stateStore).names();
        if (jSONArrayNames == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            JSONObject jSONObjectOptJSONObject = clans(stateStore).optJSONObject(jSONArrayNames.optString(i));
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("invitations");
            for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.optLong("id") == j && jSONObjectOptJSONObject2.optLong("inviteeId") == j2) {
                    return jSONObjectOptJSONObject;
                }
            }
        }
        return null;
    }

    private static void markInvitation(JSONObject jSONObject, long j, int i) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("invitations");
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("id") == j) {
                jSONObjectOptJSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i);
            }
        }
    }

    private static String join(StateStore stateStore, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObject.put("members", jSONArrayOptJSONArray);
        }
        jSONArrayOptJSONArray.put(memberEntry(jSONObject2, 0));
        jSONObject2.put("clanId", jSONObject.optLong("clanId"));
        stateStore.save();
        return null;
    }

    public static JSONArray members(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("members");
        return jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
    }

    public static int maxMembers(JSONObject jSONObject) {
        return (level(jSONObject) * 2) + 20;
    }

    public static int level(JSONObject jSONObject) {
        return Math.min(((int) (jSONObject.optLong("experience") / 1000)) + 1, 10);
    }

    public static long tribeCurrency(JSONObject jSONObject) {
        return jSONObject.optLong("tribeCurrency");
    }

    public static JSONObject donationInfo(StateStore stateStore, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        JSONObject jSONObjectOptJSONObject = stateStore.userState(jSONObject).optJSONObject("donations");
        String strUtcDate = utcDate();
        if (jSONObjectOptJSONObject == null || !strUtcDate.equals(jSONObjectOptJSONObject.optString("date"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("date", strUtcDate);
            jSONObjectOptJSONObject.put(StringConstant.MONEY_TYPE_GOLD, 0);
            jSONObjectOptJSONObject.put(StringConstant.MONEY_TYPE_DIAMOND, 0);
            jSONObjectOptJSONObject.put("count", 0);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("clanId", jSONObjectClanOf == null ? 0L : jSONObjectClanOf.optLong("clanId"));
        jSONObject2.put("currentGold", jSONObjectOptJSONObject.optInt(StringConstant.MONEY_TYPE_GOLD));
        jSONObject2.put("maxGold", BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        jSONObject2.put("currentDiamond", jSONObjectOptJSONObject.optInt(StringConstant.MONEY_TYPE_DIAMOND));
        jSONObject2.put("maxDiamond", 2000);
        jSONObject2.put("currentTask", jSONObjectOptJSONObject.optInt("count"));
        jSONObject2.put("maxTask", 10);
        jSONObject2.put("currentExperience", jSONObjectClanOf == null ? 0 : (int) Math.min(jSONObjectClanOf.optLong("experience"), 2147483647L));
        jSONObject2.put("maxExperience", level(jSONObjectClanOf == null ? new JSONObject() : jSONObjectClanOf) * 1000);
        jSONObject2.put(FirebaseAnalytics.Param.LEVEL, jSONObjectClanOf != null ? level(jSONObjectClanOf) : 0);
        return jSONObject2;
    }

    static String utcDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static String donate(StateStore stateStore, JSONObject jSONObject, int i, int i2) throws JSONException {
        int iOptInt;
        if (i2 <= 0) {
            return "bad quantity";
        }
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        boolean z = i == 2;
        String str = z ? StringConstant.CHRISTMAS_GOLDS : StringConstant.CHRISTMAS_DIAMONDS;
        if (jSONObject.optLong(str) < i2) {
            return "not enough ".concat(str);
        }
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("donations");
        String strUtcDate = utcDate();
        if (jSONObjectOptJSONObject == null || !strUtcDate.equals(jSONObjectOptJSONObject.optString("date"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("date", strUtcDate);
            jSONObjectOptJSONObject.put(StringConstant.MONEY_TYPE_GOLD, 0);
            jSONObjectOptJSONObject.put(StringConstant.MONEY_TYPE_DIAMOND, 0);
            jSONObjectOptJSONObject.put("count", 0);
        }
        if (!z) {
            iOptInt = jSONObjectOptJSONObject.optInt(StringConstant.MONEY_TYPE_DIAMOND);
        } else {
            iOptInt = jSONObjectOptJSONObject.optInt(StringConstant.MONEY_TYPE_GOLD);
        }
        int i3 = iOptInt + i2;
        if (i3 > (z ? BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT : 2000)) {
            return "daily donation limit reached";
        }
        if (jSONObjectOptJSONObject.optInt("count") >= 10) {
            return "daily donation count limit reached";
        }
        stateStore.award(jSONObject, str, -i2);
        int i4 = z ? i2 : i2 * 10;
        int iMax = Math.max(1, i4 / 10);
        jSONObjectClanOf.put("experience", jSONObjectClanOf.optLong("experience") + ((long) i4));
        jSONObjectOptJSONObject.put(z ? StringConstant.MONEY_TYPE_GOLD : StringConstant.MONEY_TYPE_DIAMOND, i3);
        jSONObjectOptJSONObject.put("count", jSONObjectOptJSONObject.optInt("count") + 1);
        jSONObjectUserState.put("donations", jSONObjectOptJSONObject);
        jSONObject.put("tribeCurrency", tribeCurrency(jSONObject) + ((long) iMax));
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("donations");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectClanOf.put("donations", jSONArrayOptJSONArray);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("date", System.currentTimeMillis());
        jSONObject2.put("userId", jSONObject.optLong("userId"));
        jSONObject2.put("nickName", jSONObject.optString("nickName"));
        jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, i2);
        jSONObject2.put("type", i);
        jSONObject2.put("experienceGot", i4);
        jSONObject2.put("tribeCurrencyGot", iMax);
        jSONArrayOptJSONArray.put(jSONObject2);
        stateStore.save();
        return null;
    }

    public static JSONArray donationHistory(StateStore stateStore, JSONObject jSONObject) {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return new JSONArray();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("donations");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray == null) {
            return jSONArray;
        }
        for (int length = jSONArrayOptJSONArray.length() - 1; length >= 0; length--) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(length);
            if (jSONObjectOptJSONObject != null) {
                jSONArray.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray;
    }

    public static String setBulletin(StateStore stateStore, JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        int iRoleOf = roleOf(jSONObjectClanOf, jSONObject.optLong("userId"));
        if (iRoleOf != 20 && iRoleOf != 10) {
            return "no permission";
        }
        JSONObject jSONObject2 = new JSONObject();
        if (str == null) {
            str = "";
        }
        jSONObject2.put("content", str);
        jSONObject2.put("updateTime", System.currentTimeMillis());
        jSONObjectClanOf.put("bulletin", jSONObject2);
        stateStore.save();
        return null;
    }

    public static String setFreeVerify(StateStore stateStore, JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        if (roleOf(jSONObjectClanOf, jSONObject.optLong("userId")) != 20) {
            return "only the chief can change verification";
        }
        jSONObjectClanOf.put("freeVerify", i != 1 ? 0 : 1);
        stateStore.save();
        return null;
    }

    public static JSONObject tasks(StateStore stateStore, JSONObject jSONObject, int i) throws JSONException {
        int i2;
        clanOf(stateStore, jSONObject);
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("tribeTaskProg");
        String strUtcDate = utcDate();
        if (jSONObjectOptJSONObject == null || !strUtcDate.equals(jSONObjectOptJSONObject.optString("date"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("date", strUtcDate);
            jSONObjectOptJSONObject.put("accepted", new JSONArray());
            jSONObjectOptJSONObject.put("claimed", new JSONArray());
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("accepted");
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("claimed");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectUserState.optJSONObject("donations");
        int iOptInt = (jSONObjectOptJSONObject2 == null || !strUtcDate.equals(jSONObjectOptJSONObject2.optString("date"))) ? 0 : jSONObjectOptJSONObject2.optInt("count");
        int iPlayedToday = playedToday(jSONObjectUserState, strUtcDate);
        int i3 = (jSONObjectUserState.optJSONArray("signIns") == null || !stateStore.hasSignedIn(jSONObject, strUtcDate)) ? 0 : 1;
        JSONArray jSONArray = new JSONArray();
        if (i == 1) {
            jSONArray.put(task(1, "Donate to the clan", 1L, iOptInt, 50, 100));
            jSONArray.put(task(2, "Play 2 games with clan members", 2L, iPlayedToday, 100, 200));
            jSONArray.put(task(3, "Daily sign in", 1L, i3, 30, 50));
        } else {
            jSONArray.put(task(11, "Donate once", 1L, iOptInt, 30, 60));
            jSONArray.put(task(12, "Play 3 games", 3L, iPlayedToday, 60, 120));
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i4);
            long jOptLong = jSONObjectOptJSONObject3.optLong("taskId");
            boolean zContains = contains(jSONArrayOptJSONArray, jOptLong);
            boolean zContains2 = contains(jSONArrayOptJSONArray2, jOptLong);
            jSONObjectOptJSONObject3.put("id", (int) jOptLong);
            jSONObjectOptJSONObject3.put("finished", jSONObjectOptJSONObject3.optLong("need") <= jSONObjectOptJSONObject3.optLong("__progress") ? 1 : 0);
            if (zContains2) {
                i2 = 3;
            } else if (zContains) {
                i2 = jSONObjectOptJSONObject3.optInt("finished") == 1 ? 2 : 1;
            } else {
                i2 = 0;
            }
            jSONObjectOptJSONObject3.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i2);
            jSONObjectOptJSONObject3.remove("__progress");
            jSONArray2.put(jSONObjectOptJSONObject3);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("currencyCost", 0);
        jSONObject2.put("currencyType", 1);
        jSONObject2.put("nextFreeFlushTime", 0);
        jSONObject2.put("remainTime", 0L);
        jSONObject2.put("tasks", jSONArray2);
        return jSONObject2;
    }

    private static JSONObject task(int i, String str, long j, long j2, int i2, int i3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taskId", i);
        jSONObject.put("id", i);
        jSONObject.put("name", str);
        jSONObject.put("need", j);
        jSONObject.put("__progress", j2);
        jSONObject.put("currencyReward", i2);
        jSONObject.put("experienceReward", i3);
        jSONObject.put("finished", 0);
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
        jSONObject.put("type", "day");
        return jSONObject;
    }

    private static int playedToday(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playedGames");
        int i = 0;
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && str.equals(utcDateOf(jSONObjectOptJSONObject.optLong("at")))) {
                i++;
            }
        }
        return i;
    }

    static String utcDateOf(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(j));
    }

    private static boolean contains(JSONArray jSONArray, long j) {
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            if (jSONArray.optLong(i) == j) {
                return true;
            }
        }
        return false;
    }

    public static String taskAction(StateStore stateStore, JSONObject jSONObject, long j, int i, boolean z) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("tribeTaskProg");
        String strUtcDate = utcDate();
        if (jSONObjectOptJSONObject == null || !strUtcDate.equals(jSONObjectOptJSONObject.optString("date"))) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("date", strUtcDate);
            jSONObjectOptJSONObject.put("accepted", new JSONArray());
            jSONObjectOptJSONObject.put("claimed", new JSONArray());
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("accepted");
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("claimed");
        if (z) {
            if (!contains(jSONArrayOptJSONArray, j)) {
                return "task not accepted";
            }
            if (contains(jSONArrayOptJSONArray2, j)) {
                return "reward already claimed";
            }
            JSONArray jSONArrayOptJSONArray3 = tasks(stateStore, jSONObject, i).optJSONArray("tasks");
            JSONObject jSONObject2 = null;
            for (int i2 = 0; jSONArrayOptJSONArray3 != null && i2 < jSONArrayOptJSONArray3.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray3.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.optLong("taskId") == j) {
                    jSONObject2 = jSONObjectOptJSONObject2;
                }
            }
            if (jSONObject2 == null) {
                return "unknown task";
            }
            if (jSONObject2.optInt("finished") != 1) {
                return "task not finished";
            }
            jSONArrayOptJSONArray2.put(j);
            jSONObject.put("tribeCurrency", tribeCurrency(jSONObject) + jSONObject2.optLong("currencyReward"));
            jSONObjectClanOf.put("experience", jSONObjectClanOf.optLong("experience") + jSONObject2.optLong("experienceReward"));
        } else {
            if (contains(jSONArrayOptJSONArray, j)) {
                return "task already accepted";
            }
            jSONArrayOptJSONArray.put(j);
        }
        jSONObjectUserState.put("tribeTaskProg", jSONObjectOptJSONObject);
        stateStore.save();
        return null;
    }

    public static JSONArray shop(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectRoot = stateStore.root();
        JSONArray jSONArrayOptJSONArray = jSONObjectRoot.optJSONArray("tribeShop");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            return jSONArrayOptJSONArray;
        }
        JSONArray jSONArray = new JSONArray();
        String[][] strArr = {new String[]{"Wooden Frame", "A humble wooden avatar frame."}, new String[]{"Bronze Frame", "Bronze avatar frame for loyal members."}, new String[]{"Silver Frame", "Shiny silver avatar frame."}, new String[]{"Golden Frame", "A golden frame for dedicated chiefs."}, new String[]{"Emerald Frame", "Emerald-trimmed avatar frame."}, new String[]{"Dragon Frame", "Legendary dragon-scale frame."}};
        String[][] strArr2 = {new String[]{"Plain Bubble", "A simple chat bubble."}, new String[]{"Sky Bubble", "Chat bubble with a sky pattern."}, new String[]{"Lava Bubble", "Chat bubble with molten lava."}, new String[]{"Frost Bubble", "Chat bubble with frost edges."}, new String[]{"Neon Bubble", "A neon glowing chat bubble."}, new String[]{"Royal Bubble", "The royal purple chat bubble."}};
        int i = 0;
        int i2 = 9001;
        while (i < 6) {
            String[] strArr3 = strArr[i];
            jSONArray.put(shopItem(i2, 1, strArr3[0], strArr3[1], (i * 30) + 20, (i / 3) + 1));
            i++;
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 < 6) {
            String[] strArr4 = strArr2[i4];
            jSONArray.put(shopItem(i3, 2, strArr4[0], strArr4[1], (i4 * 30) + 20, (i4 / 3) + 1));
            i4++;
            i3++;
        }
        jSONObjectRoot.put("tribeShop", jSONArray);
        stateStore.save();
        return jSONArray;
    }

    private static JSONObject shopItem(int i, int i2, String str, String str2, int i3, int i4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", i);
        jSONObject.put("typeId", i2);
        jSONObject.put("name", str);
        jSONObject.put("details", str2);
        jSONObject.put("iconUrl", "");
        jSONObject.put("resourceId", "tribe_deco_" + i);
        jSONObject.put("price", i3);
        jSONObject.put("currency", 3);
        jSONObject.put("expire", -1);
        jSONObject.put(FirebaseAnalytics.Param.QUANTITY, 1);
        jSONObject.put("sex", 0);
        jSONObject.put("tag", new JSONArray());
        jSONObject.put("clanLevel", i4);
        jSONObject.put("hasPurchase", 0);
        return jSONObject;
    }

    public static String buyDecorations(StateStore stateStore, JSONObject jSONObject, long[] jArr) throws JSONException {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return "not in a clan";
        }
        JSONArray jSONArrayShop = shop(stateStore);
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("purchases");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == jSONObject.optLong("userId")) {
                jSONArray.put(jSONObjectOptJSONObject.optLong("decorationId"));
            }
        }
        int length = jArr.length;
        long j = 0;
        long jOptLong = 0;
        int i2 = 0;
        while (true) {
            JSONObject jSONObject2 = null;
            if (i2 < length) {
                int i3 = length;
                long j2 = jArr[i2];
                int i4 = 0;
                while (true) {
                    if (i4 >= jSONArrayShop.length()) {
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayShop.optJSONObject(i4);
                    if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.optLong("id") == j2) {
                        jSONObject2 = jSONObjectOptJSONObject2;
                        break;
                    }
                    i4++;
                    jSONObject2 = null;
                }
                if (jSONObject2 == null) {
                    return "unknown decoration " + j2;
                }
                if (level(jSONObjectClanOf) < jSONObject2.optInt("clanLevel")) {
                    return "clan level too low";
                }
                if (!contains(jSONArray, j2)) {
                    jOptLong += jSONObject2.optLong("price");
                }
                i2++;
                length = i3;
                j = 0;
            } else {
                if (jOptLong > j) {
                    if (tribeCurrency(jSONObject) < jOptLong) {
                        return "not enough tribe currency";
                    }
                    jSONObject.put("tribeCurrency", tribeCurrency(jSONObject) - jOptLong);
                }
                for (long j3 : jArr) {
                    if (!contains(jSONArray, j3)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("userId", jSONObject.optLong("userId"));
                        jSONObject3.put("decorationId", j3);
                        jSONObject3.put("at", System.currentTimeMillis());
                        jSONArrayOptJSONArray.put(jSONObject3);
                    }
                }
                stateStore.save();
                return null;
            }
        }
    }

    public static boolean ownsDecoration(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONObject jSONObjectClanOf = clanOf(stateStore, jSONObject);
        if (jSONObjectClanOf == null) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectClanOf.optJSONArray("purchases");
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("userId") == jSONObject.optLong("userId") && jSONObjectOptJSONObject.optLong("decorationId") == j) {
                return true;
            }
        }
        return false;
    }

    public static void ensureNpcTribes(StateStore stateStore) throws JSONException {
        JSONObject jSONObjectClans = clans(stateStore);
        if (jSONObjectClans.length() > 0) {
            return;
        }
        int i = 8;
        int i2 = 0;
        char c2 = 1;
        Object[][] objArr = {new String[]{"Blocky Pioneers", "The first builders of the local world."}, new String[]{"Night Builders", "We build while you sleep."}, new String[]{"Pixel Wolves", "Fast, friendly, always playing."}, new String[]{"Cloud Crafters", "Sky-high creations only."}, new String[]{"Rookie Republic", "New players welcome!"}, new String[]{"Arena Legends", "Battle-hardened competitors."}, new String[]{"Sandbox Society", "Creative minds unite."}, new String[]{"Diamond Guild", "Collectors and traders."}};
        String[] strArr = {"OldWolf", "Nova", "Pixie", "CloudMaster", "RookieKing", "Legend", "Maker", "Glimmer"};
        int i3 = 0;
        while (i3 < i) {
            long jNextClanId = nextClanId(stateStore);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clanId", jNextClanId);
            jSONObject.put("name", objArr[i3][i2]);
            jSONObject.put("details", objArr[i3][c2]);
            jSONObject.put("headPic", "");
            jSONObject.put("tags", new JSONArray());
            jSONObject.put("experience", ((long) (8 - i3)) * 200);
            Object[][] objArr2 = objArr;
            jSONObject.put("currency", 0L);
            jSONObject.put("freeVerify", i3 % 3 == 0 ? 1 : 0);
            jSONObject.put("chiefId", 0L);
            String[] strArr2 = strArr;
            jSONObject.put("createdAt", System.currentTimeMillis());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userId", 0L);
            jSONObject2.put("role", 20);
            jSONObject2.put("experience", i2);
            jSONObject2.put("expireDate", "");
            jSONObject2.put("headPic", "");
            jSONObject2.put("nickName", strArr2[i3]);
            jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i2);
            jSONObject2.put("vip", i2);
            jSONArray.put(jSONObject2);
            int i4 = 0;
            while (i4 < (i3 % 4) + 3) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("userId", 0L);
                jSONObject3.put("role", 0);
                jSONObject3.put("experience", 0);
                jSONObject3.put("expireDate", "");
                jSONObject3.put("headPic", "");
                i4++;
                jSONObject3.put("nickName", String.valueOf(strArr2[i3]) + "fan" + i4);
                jSONObject3.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 0);
                jSONObject3.put("vip", 0);
                jSONArray.put(jSONObject3);
                jNextClanId = jNextClanId;
            }
            jSONObject.put("members", jSONArray);
            jSONObject.put("bulletin", new JSONObject());
            jSONObject.put("joinRequests", new JSONArray());
            jSONObject.put("invitations", new JSONArray());
            jSONObject.put("donations", new JSONArray());
            jSONObject.put("purchases", new JSONArray());
            jSONObjectClans.put(String.valueOf(jNextClanId), jSONObject);
            i3++;
            objArr = objArr2;
            strArr = strArr2;
            c2 = 1;
            i = 8;
            i2 = 0;
        }
        stateStore.save();
    }

    public static boolean isNpc(JSONObject jSONObject) {
        return jSONObject.optLong("chiefId") == 0;
    }
}
