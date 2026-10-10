package com.disabngo.blockynexus.view.fragment.more;

import android.content.Context;
import com.sandboxol.center.web.UserApi;

/* JADX INFO: compiled from: MoreModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C {
    public void a(Context context) {
        UserApi.updateUserInfo(context, new B(this, context));
    }
}
