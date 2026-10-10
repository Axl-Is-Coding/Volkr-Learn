package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.cconfig.UMRemoteConfig;

/* JADX INFO: compiled from: ActiveFetchConfigTask.java */
/* JADX INFO: loaded from: classes5.dex */
public class aj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f20640a;

    public aj(Context context) {
        this.f20640a = context;
    }

    private boolean a() {
        boolean zA;
        try {
            ae aeVarF = z.a(this.f20640a).f();
            if (!"0".equals(aeVarF.c())) {
                return false;
            }
            String strA = aeVarF.a();
            if (TextUtils.isEmpty(strA) || !(zA = z.a(this.f20640a).a(strA))) {
                return false;
            }
            z.a(this.f20640a).b(strA);
            return zA;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            UMRemoteConfig.getInstance().handlerMessage(3, Boolean.valueOf(a()), null);
        } catch (Exception unused) {
        }
    }
}
