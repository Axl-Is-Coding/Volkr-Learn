package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.y;

/* JADX INFO: compiled from: OAuthHandler.java */
/* JADX INFO: loaded from: classes5.dex */
class d extends AuthHandler {
    d(q qVar, com.twitter.sdk.android.core.c<y> cVar, int i) {
        super(qVar, cVar, i);
    }

    @Override // com.twitter.sdk.android.core.identity.AuthHandler
    public boolean a(Activity activity) {
        activity.startActivityForResult(b(activity), this.f20125a);
        return true;
    }

    Intent b(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) OAuthActivity.class);
        intent.putExtra("auth_config", a());
        return intent;
    }
}
