package com.localapi;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sandboxol.center.config.StringConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class Mail {
    static final int TYPE_DIAMONDS = 1;
    static final int TYPE_GOLDS = 2;

    private Mail() {
    }

    static JSONObject currencyAttachment(int i, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", i);
        jSONObject.put("itemId", String.valueOf(i));
        jSONObject.put("name", i == 1 ? "Diamonds" : "Golds");
        jSONObject.put("icon", "");
        jSONObject.put("qty", j);
        return jSONObject;
    }

    static synchronized void ensureWelcomeMail(StateStore stateStore, JSONObject jSONObject) {
        JSONObject jSONObjectUserState = stateStore.userState(jSONObject);
        if (jSONObjectUserState.optBoolean("welcomeMail")) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(currencyAttachment(2, 500L));
        stateStore.addMail(jSONObject, "Welcome to the local world", "Your account is ready. Everything here runs on the local API — have fun! Claim the attached golds to get started.", 0, "", jSONArray);
        jSONObjectUserState.put("welcomeMail", true);
        stateStore.save();
    }

    static JSONObject toJson(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", jSONObject.optLong("id"));
        jSONObject2.put("title", jSONObject.optString("title"));
        jSONObject2.put("content", jSONObject.optString("content"));
        jSONObject2.put("type", jSONObject.optInt("type"));
        jSONObject2.put("extra", jSONObject.optString("extra"));
        jSONObject2.put("sendDate", jSONObject.optLong("sendDate"));
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(MessengerShareContentUtility.ATTACHMENT);
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", jSONObjectOptJSONObject.optInt("type"));
                    jSONObject3.put("itemId", jSONObjectOptJSONObject.optString("itemId"));
                    jSONObject3.put("name", jSONObjectOptJSONObject.optString("name"));
                    jSONObject3.put("icon", jSONObjectOptJSONObject.optString("icon"));
                    jSONObject3.put("qty", jSONObjectOptJSONObject.optInt("qty"));
                    jSONArray.put(jSONObject3);
                }
            }
        }
        jSONObject2.put(MessengerShareContentUtility.ATTACHMENT, jSONArray);
        return jSONObject2;
    }

    static JSONArray list(StateStore stateStore, JSONObject jSONObject) {
        JSONArray jSONArrayMails = stateStore.mails(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int length = jSONArrayMails.length() - 1; length >= 0; length--) {
            JSONObject jSONObjectOptJSONObject = jSONArrayMails.optJSONObject(length);
            if (jSONObjectOptJSONObject != null) {
                jSONArray.put(toJson(jSONObjectOptJSONObject));
            }
        }
        return jSONArray;
    }

    static boolean hasNew(StateStore stateStore, JSONObject jSONObject) {
        JSONArray jSONArrayMails = stateStore.mails(jSONObject);
        for (int i = 0; i < jSONArrayMails.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayMails.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == 0) {
                return true;
            }
        }
        return false;
    }

    static JSONArray operate(StateStore stateStore, JSONObject jSONObject, int i, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            long jOptLong = jSONArray.optLong(i2, 0L);
            if (jOptLong > 0) {
                if (i == 3) {
                    stateStore.deleteMail(jSONObject, jOptLong);
                } else {
                    stateStore.markMail(jSONObject, jOptLong, i);
                }
            }
        }
        return list(stateStore, jSONObject);
    }

    static synchronized boolean claim(StateStore stateStore, JSONObject jSONObject, long j) {
        JSONObject jSONObjectFindMail = stateStore.findMail(jSONObject, j);
        if (jSONObjectFindMail == null) {
            return false;
        }
        if (jSONObjectFindMail.optBoolean("claimed")) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectFindMail.optJSONArray(MessengerShareContentUtility.ATTACHMENT);
        long j2 = 0;
        long j3 = 0;
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("type");
                    long jOptLong = jSONObjectOptJSONObject.optLong("qty", 0L);
                    if (iOptInt == 1) {
                        j3 += jOptLong;
                    } else if (iOptInt == 2) {
                        j2 += jOptLong;
                    }
                }
            }
        }
        if (j2 > 0) {
            stateStore.award(jSONObject, StringConstant.CHRISTMAS_GOLDS, j2);
        }
        if (j3 > 0) {
            stateStore.award(jSONObject, StringConstant.CHRISTMAS_DIAMONDS, j3);
        }
        jSONObjectFindMail.put("claimed", true);
        jSONObjectFindMail.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 2);
        stateStore.save();
        L.i("mail claim: userId=" + jSONObject.optLong("userId") + " mailId=" + j + " +" + j2 + " golds +" + j3 + " diamonds");
        return true;
    }
}
