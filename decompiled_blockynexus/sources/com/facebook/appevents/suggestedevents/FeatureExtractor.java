package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.tencent.map.geolocation.TencentLocationListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class FeatureExtractor {
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo;
    private static boolean initialized;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    FeatureExtractor() {
    }

    static float[] getDenseFeatures(JSONObject jSONObject, String str) {
        if (!initialized) {
            return null;
        }
        float[] fArr = new float[30];
        Arrays.fill(fArr, WheelView.DividerConfig.FILL);
        try {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject(ViewHierarchyConstants.VIEW_KEY).toString());
            String strOptString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
            JSONArray jSONArray = new JSONArray();
            pruneTree(jSONObject2, jSONArray);
            sum(fArr, parseFeatures(jSONObject2));
            JSONObject interactedNode = getInteractedNode(jSONObject2);
            if (interactedNode == null) {
                return null;
            }
            sum(fArr, nonparseFeatures(interactedNode, jSONArray, strOptString, jSONObject2.toString(), lowerCase));
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private static JSONObject getInteractedNode(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return jSONObject;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject interactedNode = getInteractedNode(jSONArrayOptJSONArray.getJSONObject(i));
                if (interactedNode != null) {
                    return interactedNode;
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    static String getTextFeature(String str, String str2, String str3) {
        return (str3 + " | " + str2 + ", " + str).toLowerCase();
    }

    static void initialize(File file) {
        try {
            rules = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            rules = new JSONObject(new String(bArr, "UTF-8"));
            languageInfo = new HashMap();
            languageInfo.put(ViewHierarchyConstants.ENGLISH, "1");
            languageInfo.put(ViewHierarchyConstants.GERMAN, "2");
            languageInfo.put(ViewHierarchyConstants.SPANISH, "3");
            languageInfo.put(ViewHierarchyConstants.JAPANESE, VipSubscribeStatus.SUBSCRIPTION_PURCHASED);
            eventInfo = new HashMap();
            eventInfo.put(ViewHierarchyConstants.VIEW_CONTENT, "0");
            eventInfo.put(ViewHierarchyConstants.SEARCH, "1");
            eventInfo.put(ViewHierarchyConstants.ADD_TO_CART, "2");
            eventInfo.put(ViewHierarchyConstants.ADD_TO_WISHLIST, "3");
            eventInfo.put(ViewHierarchyConstants.INITIATE_CHECKOUT, VipSubscribeStatus.SUBSCRIPTION_PURCHASED);
            eventInfo.put(ViewHierarchyConstants.ADD_PAYMENT_INFO, VipSubscribeStatus.SUBSCRIPTION_ON_HOLD);
            eventInfo.put(ViewHierarchyConstants.PURCHASE, VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD);
            eventInfo.put(ViewHierarchyConstants.LEAD, VipSubscribeStatus.SUBSCRIPTION_RESTARTED);
            eventInfo.put(ViewHierarchyConstants.COMPLETE_REGISTRATION, VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED);
            textTypeInfo = new HashMap();
            textTypeInfo.put(ViewHierarchyConstants.BUTTON_TEXT, "1");
            textTypeInfo.put(ViewHierarchyConstants.PAGE_TITLE, "2");
            textTypeInfo.put(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, "3");
            textTypeInfo.put(ViewHierarchyConstants.BUTTON_ID, VipSubscribeStatus.SUBSCRIPTION_PURCHASED);
            initialized = true;
        } catch (Exception unused) {
        }
    }

    private static boolean isButton(JSONObject jSONObject) {
        return (jSONObject.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 32) > 0;
    }

    static boolean isInitialized() {
        return initialized;
    }

    private static boolean matchIndicators(String[] strArr, String[] strArr2) {
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (str2.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        float f2 = WheelView.DividerConfig.FILL;
        Arrays.fill(fArr, WheelView.DividerConfig.FILL);
        fArr[3] = jSONArray.length() > 1 ? r2 - 1 : 0;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (isButton(jSONArray.getJSONObject(i))) {
                    fArr[9] = fArr[9] + 1.0f;
                }
            } catch (JSONException unused) {
            }
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String str4 = str + '|' + str3;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        updateHintAndTextRecursively(jSONObject, sb, sb2);
        String string = sb.toString();
        String string2 = sb2.toString();
        fArr[15] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, string2) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[16] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[17] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, string) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[18] = str2.contains(REGEX_CR_PASSWORD_FIELD) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str2) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str2) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str2) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[22] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, string2) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[24] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, string2) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str4) ? 1.0f : WheelView.DividerConfig.FILL;
        fArr[28] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, string2) ? 1.0f : WheelView.DividerConfig.FILL;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str4)) {
            f2 = 1.0f;
        }
        fArr[29] = f2;
        return fArr;
    }

    private static float[] parseFeatures(JSONObject jSONObject) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, WheelView.DividerConfig.FILL);
        String lowerCase = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY).toLowerCase();
        String lowerCase2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY).toLowerCase();
        String lowerCase3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY).toLowerCase();
        int iOptInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (matchIndicators(new String[]{"$", "amount", "price", "total"}, strArr)) {
            double d2 = fArr[0];
            Double.isNaN(d2);
            fArr[0] = (float) (d2 + 1.0d);
        }
        if (matchIndicators(new String[]{REGEX_CR_PASSWORD_FIELD, "pwd"}, strArr)) {
            double d3 = fArr[1];
            Double.isNaN(d3);
            fArr[1] = (float) (d3 + 1.0d);
        }
        if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
            double d4 = fArr[2];
            Double.isNaN(d4);
            fArr[2] = (float) (d4 + 1.0d);
        }
        if (matchIndicators(new String[]{"search"}, strArr)) {
            double d5 = fArr[4];
            Double.isNaN(d5);
            fArr[4] = (float) (d5 + 1.0d);
        }
        if (iOptInt >= 0) {
            double d6 = fArr[5];
            Double.isNaN(d6);
            fArr[5] = (float) (d6 + 1.0d);
        }
        if (iOptInt == 3 || iOptInt == 2) {
            double d7 = fArr[6];
            Double.isNaN(d7);
            fArr[6] = (float) (d7 + 1.0d);
        }
        if (iOptInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            double d8 = fArr[7];
            Double.isNaN(d8);
            fArr[7] = (float) (d8 + 1.0d);
        }
        if (lowerCase3.contains("checkbox")) {
            double d9 = fArr[8];
            Double.isNaN(d9);
            fArr[8] = (float) (d9 + 1.0d);
        }
        if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
            double d10 = fArr[10];
            Double.isNaN(d10);
            fArr[10] = (float) (d10 + 1.0d);
        }
        if (lowerCase3.contains(TencentLocationListener.RADIO) && lowerCase3.contains("button")) {
            double d11 = fArr[12];
            Double.isNaN(d11);
            fArr[12] = (float) (d11 + 1.0d);
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                sum(fArr, parseFeatures(jSONArrayOptJSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private static boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int i = 0;
            while (true) {
                if (i >= jSONArrayOptJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                }
                if (jSONArrayOptJSONArray.getJSONObject(i).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                    z = true;
                    z2 = true;
                    break;
                }
                i++;
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    jSONArray.put(jSONArrayOptJSONArray.getJSONObject(i2));
                }
            } else {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i3);
                    if (pruneTree(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static boolean regexMatched(String str, String str2, String str3, String str4) {
        return regexMatched(rules.optJSONObject("rulesForLanguage").optJSONObject(languageInfo.get(str)).optJSONObject("rulesForEvent").optJSONObject(eventInfo.get(str2)).optJSONObject("positiveRules").optString(textTypeInfo.get(str3)), str4);
    }

    private static void sum(float[] fArr, float[] fArr2) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] + fArr2[i];
        }
    }

    private static void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        String lowerCase = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY, "").toLowerCase();
        String lowerCase2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY, "").toLowerCase();
        if (!lowerCase.isEmpty()) {
            sb.append(lowerCase);
            sb.append(" ");
        }
        if (!lowerCase2.isEmpty()) {
            sb2.append(lowerCase2);
            sb2.append(" ");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            updateHintAndTextRecursively(jSONObject, sb, sb2);
        }
    }

    private static boolean regexMatched(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }
}
