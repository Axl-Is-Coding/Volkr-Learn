package com.disabngo.blockynexus.view.fragment.groupbannedtimelist;

import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.GroupChatApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GroupBannedTimeModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getString(R.string.new_group_ban_10m));
        arrayList.add(context.getString(R.string.new_group_ban_1h));
        arrayList.add(context.getString(R.string.new_group_ban_12h));
        arrayList.add(context.getString(R.string.new_group_ban_1day));
        arrayList.add(context.getString(R.string.new_group_ban_1month));
        return arrayList;
    }

    public void a(Context context, long j, long j2, String str, String str2) {
        GroupChatApi.postBanMember(context, j, j2, a(context, str2), new f(this, context, str, str2));
    }

    private int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equals(context.getString(R.string.new_group_ban_10m))) {
            return 10;
        }
        if (str.equals(context.getString(R.string.new_group_ban_1h))) {
            return 60;
        }
        if (str.equals(context.getString(R.string.new_group_ban_12h))) {
            return 720;
        }
        if (str.equals(context.getString(R.string.new_group_ban_1day))) {
            return 1440;
        }
        return str.equals(context.getString(R.string.new_group_ban_1month)) ? 43200 : 0;
    }
}
