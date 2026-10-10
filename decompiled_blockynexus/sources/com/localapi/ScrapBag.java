package com.localapi;

import com.sandboxol.center.config.StringConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class ScrapBag {
    static final String[] SCRAP_IDS = {"s1", "s2", "s3", "s4", "s5", "s6"};

    private ScrapBag() {
    }

    static synchronized JSONObject backpack(StateStore stateStore, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        jSONObjectOptJSONObject = jSONObjectUserState.optJSONObject("scraps");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            int i = 0;
            while (true) {
                String[] strArr = SCRAP_IDS;
                if (i >= strArr.length) {
                    break;
                }
                jSONObjectOptJSONObject.put(strArr[i], ((i * 3) % 8) + 2);
                i++;
            }
            jSONObjectUserState.put("scraps", jSONObjectOptJSONObject);
            stateStore.save();
        }
        return jSONObjectOptJSONObject;
    }

    static synchronized int scrapNum(StateStore stateStore, JSONObject jSONObject, String str) {
        return backpack(stateStore, jSONObject).optInt(str);
    }

    static synchronized void addScrap(StateStore stateStore, JSONObject jSONObject, String str, int i) {
        JSONObject jSONObjectBackpack = backpack(stateStore, jSONObject);
        jSONObjectBackpack.put(str, Math.max(0, jSONObjectBackpack.optInt(str) + i));
        stateStore.save();
    }

    static int valueOf(String str) {
        try {
            return Integer.parseInt(str.substring(1)) * 100;
        } catch (Throwable unused) {
            return 100;
        }
    }

    static synchronized int bagValue(StateStore stateStore, JSONObject jSONObject) {
        int i;
        JSONObject jSONObjectBackpack = backpack(stateStore, jSONObject);
        JSONArray jSONArrayNames = jSONObjectBackpack.names();
        i = 0;
        if (jSONArrayNames != null) {
            int iOptInt = 0;
            while (i < jSONArrayNames.length()) {
                iOptInt += jSONObjectBackpack.optInt(jSONArrayNames.optString(i)) * valueOf(jSONArrayNames.optString(i));
                i++;
            }
            i = iOptInt;
        }
        return i;
    }

    static JSONArray scrapInfos(String[] strArr, int[] iArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scrapId", strArr[i]);
            jSONObject.put("scrapName", "Scrap " + strArr[i].toUpperCase());
            jSONObject.put("scrapDesc", "A fragment used for exchange.");
            jSONObject.put("scrapPic", "");
            jSONObject.put("scrapNum", iArr[i]);
            jSONObject.put("scrapValue", valueOf(strArr[i]));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    static JSONObject card(String str) {
        try {
            int i = Integer.parseInt(str.substring(1));
            if (i >= 1 && i <= 6) {
                String[] strArr = SCRAP_IDS;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cardId", str);
                jSONObject.put("cardName", "Reward " + i);
                jSONObject.put("cardPic", "");
                jSONObject.put("cardQuality", (i % 3) + 1);
                jSONObject.put("cardValue", i * 300);
                jSONObject.put("needs", scrapInfos(new String[]{strArr[(i - 1) % 6], strArr[i % 6]}, new int[]{i + 1, i}));
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    static synchronized JSONObject combine(StateStore stateStore, JSONObject jSONObject, String str, int i) {
        JSONObject jSONObjectCard = card(str);
        if (jSONObjectCard != null && i >= 1) {
            JSONArray jSONArrayOptJSONArray = jSONObjectCard.optJSONArray("needs");
            JSONObject jSONObjectBackpack = backpack(stateStore, jSONObject);
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                if (jSONObjectBackpack.optInt(jSONObject2.optString("scrapId")) < jSONObject2.optInt("scrapNum") * i) {
                    return null;
                }
            }
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i3);
                addScrap(stateStore, jSONObject, jSONObject3.optString("scrapId"), (-jSONObject3.optInt("scrapNum")) * i);
            }
            long jOptLong = jSONObjectCard.optLong("cardValue") * ((long) i);
            stateStore.award(jSONObject, StringConstant.CHRISTMAS_GOLDS, jOptLong);
            JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
            JSONArray jSONArrayOptJSONArray2 = jSONObjectUserState.optJSONArray("combineHistory");
            if (jSONArrayOptJSONArray2 == null) {
                jSONArrayOptJSONArray2 = new JSONArray();
                jSONObjectUserState.put("combineHistory", jSONArrayOptJSONArray2);
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("rewardName", jSONObjectCard.optString("cardName"));
            jSONObject4.put("rewardPic", "");
            jSONObject4.put("cardQuality", jSONObjectCard.optInt("cardQuality"));
            jSONObject4.put("amount", i);
            jSONObject4.put("combineTime", simpleDateFormat.format(new Date()));
            jSONArrayOptJSONArray2.put(jSONObject4);
            stateStore.save();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("amount", i);
            jSONObject5.put("cardName", jSONObjectCard.optString("cardName"));
            jSONObject5.put("rewardType", 1);
            jSONObject5.put("decorationType", 0);
            jSONObject5.put("expire", 0);
            jSONObject5.put("gameId", "");
            jSONObject5.put("goldsCredited", jOptLong);
            return jSONObject5;
        }
        return null;
    }
}
