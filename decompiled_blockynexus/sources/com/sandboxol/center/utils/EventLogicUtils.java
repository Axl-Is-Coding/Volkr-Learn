package com.sandboxol.center.utils;

import android.content.Context;
import java.text.SimpleDateFormat;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class EventLogicUtils {
    static /* synthetic */ void a(Action1 action1, Context context, String str) {
        String str2 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
        if (str2.equals(str)) {
            if (action1 != null) {
                action1.call(false);
            }
        } else {
            MultiProcessSharedUtils.putString(context, "is.daily", str2);
            if (action1 != null) {
                action1.call(true);
            }
        }
    }

    public static void isDaily(final Context context, String str, final Action1<Boolean> action1) {
        MultiProcessSharedUtils.getString(context, str, new Action1() { // from class: com.sandboxol.center.utils.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EventLogicUtils.a(action1, context, (String) obj);
            }
        });
    }
}
