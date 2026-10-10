package b.h.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static int a(String str) {
        Context context = BaseApplication.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "mipmap", context.getPackageName());
    }
}
