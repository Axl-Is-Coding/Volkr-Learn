package com.disabngo.blockynexus.view.activity.newsearch;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.google.common.collect.Maps;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {
    public Map<String, String> b(Map<String, String> map) {
        String str;
        String key = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(CommonHelper.getUserLanguage())) {
                key = entry.getKey();
            }
        }
        if (!TextUtils.isEmpty(key) && (str = map.get(key)) != null) {
            map.remove(key);
            map.put(key, str);
            map.put("All", BaseApplication.getContext().getString(R.string.app_update_user_all_language));
        }
        return map;
    }

    public void a(Context context, long j, ObservableField<Boolean> observableField, boolean z, int i) {
        a(context, j, observableField, z, null, i);
    }

    public void a(Context context, long j, ObservableField<Boolean> observableField, boolean z, ObservableField<String> observableField2, int i) {
        new EditTextDialog(context).c(context.getString(R.string.send_apply_for_friend)).b(context.getString(R.string.send_apply_for_friend_msg)).a(new m(this, j, context, i, observableField2, observableField, z)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i) {
        if (i == 4) {
            ReportDataAdapter.onEvent(context, EventConstant.APPLY_RECOM_FRI, "Search Page");
        } else if (i == 5) {
            ReportDataAdapter.onEvent(context, EventConstant.APPLY_FILTER_FRI, "Search Page");
        } else {
            if (i != 6) {
                return;
            }
            ReportDataAdapter.onEvent(context, EventConstant.APPLY_SEARCH_FRI, "Search Page");
        }
    }

    public static String a(Map<String, Map<String, String>> map, String str) {
        String key = "";
        if (map == null || map.size() == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        int i = 0;
        for (int i2 = 0; i2 < map.size(); i2++) {
            Iterator<Map.Entry<String, String>> it = map.get(arrayList.get(i2)).entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().equals(str)) {
                    i = i2;
                }
            }
        }
        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
            if (entry.getValue() == map.get(arrayList.get(i))) {
                key = entry.getKey();
            }
        }
        return key;
    }

    public static String b(Map<String, String> map, String str) {
        String key = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(str)) {
                key = entry.getKey();
            }
        }
        return key;
    }

    public static Map<String, String> a(Map<String, Map<String, String>> map) {
        LinkedHashMap linkedHashMapC = Maps.c();
        linkedHashMapC.put("All", BaseApplication.getContext().getString(R.string.app_update_user_all_game));
        for (String str : map.keySet()) {
            Iterator<String> it = map.get(str).keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().equals(CommonHelper.getUserLanguage())) {
                    linkedHashMapC.put(str, map.get(str).get(CommonHelper.getUserLanguage()));
                    break;
                }
                linkedHashMapC.put(str, map.get(str).get("en"));
            }
        }
        return linkedHashMapC;
    }
}
