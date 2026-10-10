package com.disabngo.blockynexus.view.activity.start;

import android.content.Context;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.entity.AuthTokenResponse;

/* JADX INFO: compiled from: StartActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11120a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11121b = 0;

    static /* synthetic */ int b(p pVar) {
        int i = pVar.f11121b;
        pVar.f11121b = i + 1;
        return i;
    }

    public void a(Context context) {
        UserApi.authToken(context, new m(this, context));
    }

    public void a(Context context, AuthTokenResponse authTokenResponse) {
        UserApi.updateUserInfo(context, new o(this, context, authTokenResponse));
    }
}
