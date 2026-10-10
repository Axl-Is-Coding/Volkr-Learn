package com.disabngo.blockynexus.e.b.fa;

import android.content.Context;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: SecretQuestionModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9774a;

    public j(Context context) {
        this.f9774a = context;
    }

    public void a(Context context, String str, List<SecretQuestionInfo> list, String str2, OnResponseListener onResponseListener) {
        UserApi.setUserQuestion(context, str, list, str2, onResponseListener);
    }
}
