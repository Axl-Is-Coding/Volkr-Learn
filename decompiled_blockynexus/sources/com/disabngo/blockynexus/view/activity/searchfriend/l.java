package com.disabngo.blockynexus.view.activity.searchfriend;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import java.util.Map;

/* JADX INFO: compiled from: SearchFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public void a(Context context, long j, ObservableField<Boolean> observableField, boolean z) {
        a(context, j, observableField, z, null);
    }

    public void a(Context context, long j, ObservableField<Boolean> observableField, boolean z, ObservableField<String> observableField2) {
        new EditTextDialog(context).c(context.getString(R.string.send_apply_for_friend)).b(context.getString(R.string.send_apply_for_friend_msg)).a(new k(this, j, context, observableField2, observableField, z)).show();
        ReportDataAdapter.onEvent(context, EventConstant.CHAT_SEARCH_ADD_FRIEND, z ? "Search" : "Recommend");
    }

    public Map<String, String> a(Map<String, String> map) {
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

    public static String a(Map<String, String> map, String str) {
        String key = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(str)) {
                key = entry.getKey();
            }
        }
        return key;
    }
}
