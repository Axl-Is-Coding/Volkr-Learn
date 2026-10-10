package com.sandbox.login.e;

import android.text.TextUtils;
import com.sandbox.login.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: compiled from: ViewReturnTextUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static String a(long j) {
        return "ID:" + j;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return BaseApplication.getContext().getString(R.string.login_more_user_account) + str;
    }
}
