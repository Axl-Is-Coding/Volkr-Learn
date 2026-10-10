package com.sandboxol.center.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sandboxol.common.base.app.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapStatusHelper {
    public static final int STATUS_EXPIRED = 2;
    public static final int STATUS_FINISHED = 1;
    public static final int STATUS_NEW = 0;
    private Map<String, String> scrapReciveIds;
    private Map<String, String> scrapStatus;

    private static class ScrapStatusHelperHolder {
        private static final ScrapStatusHelper instance = new ScrapStatusHelper();

        private ScrapStatusHelperHolder() {
        }
    }

    private Map<String, String> getHashMapData(Context context) {
        HashMap map = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(context.getSharedPreferences("BMScrapStatus", 0).getString("scrapStatusMapKey", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null) {
                    for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                        String string = jSONArrayNames.getString(i2);
                        map.put(string, jSONObject.getString(string));
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return map;
    }

    private Map<String, String> getHashMapIdsData(Context context) {
        HashMap map = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(context.getSharedPreferences("BMScrapRIds", 0).getString("scrapRidsMapKey", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null) {
                    for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                        String string = jSONArrayNames.getString(i2);
                        map.put(string, jSONObject.getString(string));
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return map;
    }

    public static ScrapStatusHelper getInstance() {
        return ScrapStatusHelperHolder.instance;
    }

    private void putHashMapData(Context context, Map<String, String> map) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONArray.put(jSONObject);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("BMScrapStatus", 0).edit();
        editorEdit.putString("scrapStatusMapKey", jSONArray.toString());
        editorEdit.commit();
    }

    private void putHashMapIdsData(Context context, Map<String, String> map) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONArray.put(jSONObject);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("BMScrapRIds", 0).edit();
        editorEdit.putString("scrapRidsMapKey", jSONArray.toString());
        editorEdit.commit();
    }

    public int getCacheStatus(String str) {
        if (this.scrapStatus.get(str) == null || Integer.valueOf(this.scrapStatus.get(str)).intValue() == 0) {
            return 0;
        }
        return Integer.valueOf(this.scrapStatus.get(str)).intValue();
    }

    public long getRId(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.scrapReciveIds.get(str))) {
            return 0L;
        }
        try {
            return Long.parseLong(this.scrapReciveIds.get(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public void updateCacheData(Context context, String str, int i) {
        this.scrapStatus.put(str, String.valueOf(i));
        putHashMapData(context, this.scrapStatus);
    }

    public void updateRId(Context context, String str, long j) {
        this.scrapReciveIds.put(str, String.valueOf(j));
        putHashMapIdsData(context, this.scrapReciveIds);
    }

    private ScrapStatusHelper() {
        this.scrapStatus = new HashMap();
        this.scrapStatus = getHashMapData(BaseApplication.getContext());
        this.scrapReciveIds = new HashMap();
        this.scrapReciveIds = getHashMapIdsData(BaseApplication.getContext());
    }
}
