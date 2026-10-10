package com.localapi;

import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class DressShop {
    private DressShop() {
    }

    static synchronized JSONArray ensureType(StateStore stateStore, long j) {
        JSONArray jSONArrayByType = Skins.byType(j);
        if (jSONArrayByType != null && jSONArrayByType.length() > 0) {
            return jSONArrayByType;
        }
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("dresses");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            stateStore.root().put("dresses", jSONObjectOptJSONObject);
        }
        String strValueOf = String.valueOf(j);
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(strValueOf);
        if (jSONArrayOptJSONArray != null) {
            return jSONArrayOptJSONArray;
        }
        String[] strArr = {"Star", "Retro", "Neon", "Pixel", "Cloud", "Shadow", "Golden", "Cyber", "Frost", "Blaze"};
        String[] strArr2 = {"Cap", "Jacket", "Suit", "Cape", "Boots", "Visor", "Pack", "Aura", "Gloves", "Mask"};
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        for (int i2 = 10; i < i2; i2 = 10) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = jSONArray;
            long j2 = i;
            jSONObject.put("id", (100 * j) + 300000 + j2);
            jSONObject.put("typeId", j);
            jSONObject.put("name", String.valueOf(strArr[i]) + " " + strArr2[i % 10]);
            jSONObject.put("details", "Locally crafted " + strArr2[i % 10].toLowerCase() + " for your avatar.");
            jSONObject.put("iconUrl", "");
            jSONObject.put("currency", i % 3 == 0 ? 2 : 1);
            jSONObject.put("price", ((i * 260) % 2600) + 200);
            jSONObject.put("sex", 0);
            jSONObject.put("expire", 0);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 1);
            jSONObject.put("itemType", 1);
            jSONObject.put(FirebaseAnalytics.Param.QUANTITY, 1);
            jSONObject.put("isNew", i % 4 == 0 ? 1 : 0);
            jSONObject.put("hasPurchase", 0);
            jSONObject.put("resourceId", "dress-" + j + "-" + i);
            jSONObject.put("releaseTime", System.currentTimeMillis() - ((10 - j2) * 86400000));
            jSONArray2.put(jSONObject);
            i++;
            jSONArray = jSONArray2;
        }
        jSONObjectOptJSONObject.put(strValueOf, jSONArray);
        stateStore.save();
        return jSONArray;
    }

    static synchronized JSONObject byId(StateStore stateStore, long j) {
        JSONObject jSONObjectById = Skins.byId(j);
        if (jSONObjectById != null) {
            return jSONObjectById;
        }
        JSONObject jSONObjectOptJSONObject = stateStore.root().optJSONObject("dresses");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        if (jSONArrayNames == null) {
            return null;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(jSONArrayNames.optString(i));
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.optLong("id") == j) {
                        return jSONObjectOptJSONObject2;
                    }
                }
            }
        }
        return null;
    }

    static JSONObject singleJson(StateStore stateStore, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
        if (!jSONObject3.has("decorationInfoList")) {
            jSONObject3.put("decorationInfoList", new JSONArray());
        }
        if (!jSONObject3.has("limitedTimes")) {
            jSONObject3.put("limitedTimes", new JSONArray());
        }
        if (!jSONObject3.has("tag")) {
            jSONObject3.put("tag", new JSONArray());
        }
        if (!jSONObject3.has("occupyPosition")) {
            jSONObject3.put("occupyPosition", new JSONArray());
        }
        if (!jSONObject3.has("suitId")) {
            jSONObject3.put("suitId", 0);
        }
        if (!jSONObject3.has("suitPrice")) {
            jSONObject3.put("suitPrice", 0);
        }
        if (!jSONObject3.has("remainingDays")) {
            jSONObject3.put("remainingDays", 0);
        }
        if (!jSONObject3.has("orderField")) {
            jSONObject3.put("orderField", 0);
        }
        if (!jSONObject3.has("isActivity")) {
            jSONObject3.put("isActivity", 0);
        }
        if (!jSONObject3.has("isDressRec")) {
            jSONObject3.put("isDressRec", false);
        }
        if (!jSONObject3.has("isRecommend")) {
            jSONObject3.put("isRecommend", 0);
        }
        if (!jSONObject3.has("blankType")) {
            jSONObject3.put("blankType", 0);
        }
        if (!jSONObject3.has("clanLevel")) {
            jSONObject3.put("clanLevel", 0);
        }
        if (!jSONObject3.has("buySuccess")) {
            jSONObject3.put("buySuccess", false);
        }
        if (!jSONObject3.has("activityFlag")) {
            jSONObject3.put("activityFlag", "");
        }
        if (!jSONObject3.has("itemType")) {
            jSONObject3.put("itemType", 1);
        }
        if (!jSONObject3.has(FirebaseAnalytics.Param.QUANTITY)) {
            jSONObject3.put(FirebaseAnalytics.Param.QUANTITY, 1);
        }
        jSONObject3.put("hasPurchase", owned(stateStore, jSONObject, jSONObject2.optLong("id")) ? 1 : 0);
        if (Skins.byId(jSONObject2.optLong("id")) != null) {
            jSONObject3.put("iconUrl", Skins.iconUrl(jSONObject2.optLong("id")));
        }
        return jSONObject3;
    }

    static synchronized JSONObject wardrobe(StateStore stateStore, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("wardrobe");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectOptJSONObject.put("owned", new JSONArray());
            jSONObjectOptJSONObject.put("using", new JSONArray());
            jSONObjectUserState.put("wardrobe", jSONObjectOptJSONObject);
        }
        return jSONObjectOptJSONObject;
    }

    static boolean owned(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONArray jSONArrayOptJSONArray = wardrobe(stateStore, jSONObject).optJSONArray("owned");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (jSONArrayOptJSONArray.optLong(i) == j) {
                    return true;
                }
            }
        }
        return false;
    }

    static synchronized void markOwned(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONObject jSONObjectWardrobe = wardrobe(stateStore, jSONObject);
        JSONArray jSONArrayOptJSONArray = jSONObjectWardrobe.optJSONArray("owned");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectWardrobe.put("owned", jSONArrayOptJSONArray);
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            if (jSONArrayOptJSONArray.optLong(i) == j) {
                return;
            }
        }
        jSONArrayOptJSONArray.put(j);
        stateStore.save();
    }

    static synchronized void setUsing(StateStore stateStore, JSONObject jSONObject, JSONArray jSONArray, boolean z) {
        boolean z2;
        JSONObject jSONObjectWardrobe = wardrobe(stateStore, jSONObject);
        JSONArray jSONArrayOptJSONArray = jSONObjectWardrobe.optJSONArray("using");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectWardrobe.put("using", jSONArrayOptJSONArray);
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            long jOptLong = jSONArray.optLong(i);
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArrayOptJSONArray.length()) {
                    z2 = false;
                    break;
                } else if (jSONArrayOptJSONArray.optLong(i2) == jOptLong) {
                    if (!z) {
                        jSONArrayOptJSONArray.remove(i2);
                    }
                    z2 = true;
                } else {
                    i2++;
                }
            }
            if (z && !z2) {
                jSONArrayOptJSONArray.put(jOptLong);
            }
        }
        stateStore.save();
    }

    static synchronized JSONArray usingList(StateStore stateStore, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = wardrobe(stateStore, jSONObject).optJSONArray("using");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray == null) {
            return jSONArray;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectById = byId(stateStore, jSONArrayOptJSONArray.optLong(i));
            if (jSONObjectById != null) {
                jSONArray.put(singleJson(stateStore, jSONObject, jSONObjectById));
            }
        }
        return jSONArray;
    }

    static synchronized boolean buy(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONObject jSONObjectById = byId(stateStore, j);
        if (jSONObjectById == null) {
            return false;
        }
        long jOptLong = jSONObjectById.optLong("price");
        String str = jSONObjectById.optInt("currency") == 2 ? StringConstant.CHRISTMAS_GOLDS : StringConstant.CHRISTMAS_DIAMONDS;
        if (jSONObject.optLong(str) < jOptLong) {
            return false;
        }
        stateStore.award(jSONObject, str, -jOptLong);
        markOwned(stateStore, jSONObject, j);
        jSONObjectById.put("hasPurchase", 1);
        stateStore.save();
        return true;
    }

    static JSONObject buyResponse(JSONArray jSONArray, JSONArray jSONArray2, long j, long j2) throws JSONException {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            String strValueOf = String.valueOf(jSONArray.optLong(i));
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray2.length()) {
                    z = false;
                    break;
                }
                if (String.valueOf(jSONArray2.optLong(i2)).equals(strValueOf)) {
                    z = true;
                    break;
                }
                i2++;
            }
            jSONObject2.put(strValueOf, z);
        }
        jSONObject.put("decorationPurchaseStatus", jSONObject2);
        jSONObject.put("suitPurchaseStatus", new JSONObject());
        jSONObject.put("goldsNeed", j);
        jSONObject.put("diamondsNeed", j2);
        jSONObject.put("needShowAds", false);
        return jSONObject;
    }
}
