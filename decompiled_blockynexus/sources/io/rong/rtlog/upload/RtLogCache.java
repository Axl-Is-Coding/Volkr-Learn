package io.rong.rtlog.upload;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
class RtLogCache {
    private Context context;
    private LinkedHashMap<String, FullUploadLogCache> fullUploadLogCacheMap = new LinkedHashMap<>();
    private volatile boolean isMapToSp;
    private SharedPreferences preferences;

    RtLogCache(Context context, String str) {
        this.context = context;
        this.preferences = context.getSharedPreferences("rt_log_cache_" + str, 0);
    }

    private Set<String> convertFullUploadTaskCacheToCsvSet() {
        HashSet hashSet = new HashSet();
        Iterator<FullUploadLogCache> it = this.fullUploadLogCacheMap.values().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toCSV());
        }
        return hashSet;
    }

    synchronized void addFullUploadTaskCache(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
        FullUploadLogCache fullUploadLogCache = new FullUploadLogCache(str, str2, str3, str4, str5, str6, j, j2);
        this.fullUploadLogCacheMap.remove(fullUploadLogCache.getLogId());
        this.fullUploadLogCacheMap.put(fullUploadLogCache.getLogId(), fullUploadLogCache);
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putStringSet("full_log_cache", convertFullUploadTaskCacheToCsvSet());
        editorEdit.apply();
    }

    List<FullUploadLogCache> loadFullUploadLogCacheList() {
        if (!this.isMapToSp) {
            this.isMapToSp = true;
            Set<String> stringSet = this.preferences.getStringSet("full_log_cache", null);
            if (stringSet == null) {
                return new ArrayList();
            }
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                FullUploadLogCache fromCSV = FullUploadLogCache.parseFromCSV(it.next());
                if (fromCSV != null && !TextUtils.isEmpty(fromCSV.getLogId())) {
                    this.fullUploadLogCacheMap.put(fromCSV.getLogId(), fromCSV);
                }
            }
        }
        return new ArrayList(this.fullUploadLogCacheMap.values());
    }

    String loadTimingUploadConfigCache() {
        return this.preferences.getString("log_config", "default_config");
    }

    synchronized void removeFullUploadTaskCache(String str) {
        this.fullUploadLogCacheMap.remove(str);
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putStringSet("full_log_cache", convertFullUploadTaskCacheToCsvSet());
        editorEdit.apply();
    }

    void saveTimingUploadConfig(String str) {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putString("log_config", str);
        editorEdit.apply();
    }
}
