package com.localapi;

import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class Suits {
    static final long[] SUIT_TYPES = {101, 102, 103};

    private Suits() {
    }

    static synchronized JSONArray ensureSuits(StateStore stateStore) {
        JSONArray jSONArray;
        String[] strArr;
        JSONArray jSONArray2;
        JSONObject jSONObjectRoot = stateStore.root();
        JSONArray jSONArrayOptJSONArray = jSONObjectRoot.optJSONArray("suits");
        if (jSONArrayOptJSONArray != null) {
            return jSONArrayOptJSONArray;
        }
        boolean z = false;
        int i = 1;
        int i2 = 2;
        String[] strArr2 = {"Star Captain", "Neon Drifter", "Frost Warden", "Blaze Vanguard", "Shadow Courier", "Golden Pioneer"};
        String[] strArr3 = {"A locally crafted captain outfit for the bold.", "Glow with the neon grid in this full set.", "Stay cold, stay sharp — the frost set.", "Lead the charge in blazing colors.", "Move unseen with the courier set.", "For those who got here first."};
        JSONArray jSONArray3 = new JSONArray();
        long jCurrentTimeMillis = System.currentTimeMillis() - 2592000000L;
        int i3 = 0;
        JSONArray jSONArray4 = jSONArray3;
        for (int i4 = 6; i3 < i4; i4 = 6) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray5 = jSONArray4;
            long j = i3;
            long j2 = jCurrentTimeMillis;
            jSONObject.put("suitId", j + 600001);
            jSONObject.put("name", String.valueOf(strArr2[i3]) + " Set");
            jSONObject.put("details", strArr3[i3]);
            jSONObject.put("iconUrl", "");
            jSONObject.put("currency", i3 % 3 == 0 ? 2 : 1);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i);
            jSONObject.put("itemType", i2);
            jSONObject.put(FirebaseAnalytics.Param.QUANTITY, i);
            jSONObject.put("expire", z ? 1 : 0);
            jSONObject.put("isNew", i3 % 3 == 0 ? 1 : 0);
            jSONObject.put("isRecommend", i3 % 2 == 0 ? 1 : 0);
            jSONObject.put("isActivity", z ? 1 : 0);
            jSONObject.put("activityFlag", "");
            jSONObject.put("blankType", z ? 1 : 0);
            jSONObject.put("hasLocalRes", z);
            jSONObject.put("hasPurchase", z ? 1 : 0);
            jSONObject.put("buyTime", "");
            jSONObject.put("remainingDays", z ? 1 : 0);
            jSONObject.put("releaseTime", j2 + (j * 86400000));
            jSONObject.put("tag", new JSONArray());
            JSONArray jSONArray6 = new JSONArray();
            int i5 = i3 % 3;
            long jOptLong = 0;
            int i6 = 0;
            while (true) {
                long[] jArr = SUIT_TYPES;
                if (i6 >= jArr.length) {
                    break;
                }
                JSONArray jSONArray7 = jSONArray6;
                JSONArray jSONArray8 = jSONArray5;
                JSONArray jSONArrayEnsureType = DressShop.ensureType(stateStore, jArr[i6]);
                int[] iArr = new int[3];
                iArr[i] = 3;
                iArr[2] = 5;
                int i7 = 0;
                for (int i8 = 3; i7 < i8 && jSONArray7.length() < 8; i8 = 3) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayEnsureType.optJSONObject(iArr[i7] % jSONArrayEnsureType.length());
                    if (jSONObjectOptJSONObject == null) {
                        jSONArray = jSONArray8;
                        strArr = strArr2;
                        jSONArray2 = jSONArray7;
                    } else {
                        jSONArray = jSONArray8;
                        strArr = strArr2;
                        jSONArray2 = jSONArray7;
                        jSONArray2.put(jSONObjectOptJSONObject.optLong("id"));
                        jOptLong += jSONObjectOptJSONObject.optLong("price");
                    }
                    i7++;
                    jSONArray7 = jSONArray2;
                    strArr2 = strArr;
                    jSONArray8 = jSONArray;
                }
                i6++;
                jSONArray6 = jSONArray7;
                strArr2 = strArr2;
                jSONArray5 = jSONArray8;
                z = false;
                i = 1;
                i2 = 2;
            }
            jSONObject.put("price", (int) Math.round(jOptLong * 0.7d));
            jSONObject.put("dressIds", jSONArray6);
            JSONArray jSONArray9 = jSONArray5;
            jSONArray9.put(jSONObject);
            i3++;
            jSONArray4 = jSONArray9;
            jCurrentTimeMillis = j2;
        }
        jSONObjectRoot.put("suits", jSONArray4);
        stateStore.save();
        return jSONArray4;
    }

    static synchronized JSONObject byId(StateStore stateStore, long j) {
        JSONArray jSONArrayOptJSONArray = stateStore.root().optJSONArray("suits");
        int i = 0;
        while (jSONArrayOptJSONArray != null) {
            if (i >= jSONArrayOptJSONArray.length()) {
                break;
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("suitId") == j) {
                return jSONObjectOptJSONObject;
            }
            i++;
        }
        return null;
    }

    static JSONObject giftSuit(StateStore stateStore) {
        return ensureSuits(stateStore).optJSONObject(0);
    }

    static synchronized JSONArray ownedSuits(StateStore stateStore, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        jSONArrayOptJSONArray = jSONObjectUserState.optJSONArray("ownedSuits");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectUserState.put("ownedSuits", jSONArrayOptJSONArray);
        }
        return jSONArrayOptJSONArray;
    }

    static boolean owned(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONArray jSONArrayOwnedSuits = ownedSuits(stateStore, jSONObject);
        for (int i = 0; i < jSONArrayOwnedSuits.length(); i++) {
            if (jSONArrayOwnedSuits.optLong(i) == j) {
                return true;
            }
        }
        return false;
    }

    static synchronized void markOwned(StateStore stateStore, JSONObject jSONObject, long j) {
        if (owned(stateStore, jSONObject, j)) {
            return;
        }
        ownedSuits(stateStore, jSONObject).put(j);
        stateStore.save();
    }

    static boolean giftClaimed(StateStore stateStore, JSONObject jSONObject) {
        return stateStore.userState(jSONObject).optBoolean("giftSuitClaimed");
    }

    static synchronized void markGiftClaimed(StateStore stateStore, JSONObject jSONObject) {
        stateStore.userState(jSONObject).put("giftSuitClaimed", true);
        stateStore.save();
    }

    static JSONObject suitJson(StateStore stateStore, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
        JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("dressIds");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectById = DressShop.byId(stateStore, jSONArrayOptJSONArray.optLong(i));
            if (jSONObjectById != null) {
                jSONArray.put(DressShop.singleJson(stateStore, jSONObject, jSONObjectById));
            }
        }
        jSONObject3.put("decorationInfoList", jSONArray);
        jSONObject3.put("shopDecorationInfos", jSONArray);
        jSONObject3.put("limitedTimes", new JSONArray());
        jSONObject3.put("hasPurchase", owned(stateStore, jSONObject, jSONObject3.optLong("suitId")) ? 1 : 0);
        jSONObject3.put("buyTime", owned(stateStore, jSONObject, jSONObject3.optLong("suitId")) ? String.valueOf(System.currentTimeMillis()) : "");
        return jSONObject3;
    }

    static synchronized boolean buy(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONObject jSONObjectById = byId(stateStore, j);
        if (jSONObjectById != null && !owned(stateStore, jSONObject, j)) {
            String str = jSONObjectById.optInt("currency") == 2 ? StringConstant.CHRISTMAS_GOLDS : StringConstant.CHRISTMAS_DIAMONDS;
            if (jSONObject.optLong(str) < jSONObjectById.optLong("price")) {
                return false;
            }
            stateStore.award(jSONObject, str, -jSONObjectById.optLong("price"));
            markOwned(stateStore, jSONObject, j);
            JSONArray jSONArrayOptJSONArray = jSONObjectById.optJSONArray("dressIds");
            for (int i = 0; jSONArrayOptJSONArray != null && i < jSONArrayOptJSONArray.length(); i++) {
                DressShop.markOwned(stateStore, jSONObject, jSONArrayOptJSONArray.optLong(i));
            }
            jSONObjectById.put("hasPurchase", 1);
            stateStore.save();
            return true;
        }
        return false;
    }
}
