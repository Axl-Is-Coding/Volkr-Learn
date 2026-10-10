package com.facebook.appevents.aam;

import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class MetadataRule {
    private static final String FIELD_K = "k";
    private static final String FIELD_V = "v";
    private static final String FILED_K_DELIMITER = ",";
    private static final String TAG = "com.facebook.appevents.aam.MetadataRule";
    private static List<MetadataRule> rules = new ArrayList();
    private List<String> keyRules;
    private String name;
    private String valRule;

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.keyRules = list;
        this.valRule = str2;
    }

    private static void constructRules(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObject.get(next) instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2.has(FIELD_K) && jSONObject2.has(FIELD_V) && !jSONObject2.getString(FIELD_K).isEmpty() && !jSONObject2.getString(FIELD_V).isEmpty()) {
                        rules.add(new MetadataRule(next, Arrays.asList(jSONObject2.getString(FIELD_K).split(FILED_K_DELIMITER)), jSONObject2.getString(FIELD_V)));
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    static List<MetadataRule> getRules() {
        return new ArrayList(rules);
    }

    private static void removeUnusedRules() {
        Map<String, String> internalHashedUserData = UserDataStore.getInternalHashedUserData();
        if (internalHashedUserData.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MetadataRule> it = rules.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : internalHashedUserData.keySet()) {
            if (!hashSet.contains(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        UserDataStore.removeRules(arrayList);
    }

    static void updateRules(String str) {
        try {
            rules.clear();
            constructRules(new JSONObject(str));
            removeUnusedRules();
        } catch (JSONException unused) {
        }
    }

    List<String> getKeyRules() {
        return new ArrayList(this.keyRules);
    }

    String getName() {
        return this.name;
    }

    String getValRule() {
        return this.valRule;
    }
}
