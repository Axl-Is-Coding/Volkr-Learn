package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.s;
import com.twitter.sdk.android.core.y;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AuthHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f20125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f20126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.twitter.sdk.android.core.c<y> f20127c;

    AuthHandler(q qVar, com.twitter.sdk.android.core.c<y> cVar, int i) {
        this.f20126b = qVar;
        this.f20127c = cVar;
        this.f20125a = i;
    }

    q a() {
        return this.f20126b;
    }

    public abstract boolean a(Activity activity);

    com.twitter.sdk.android.core.c<y> getCallback() {
        return this.f20127c;
    }

    public boolean a(int i, int i2, Intent intent) {
        if (this.f20125a != i) {
            return false;
        }
        com.twitter.sdk.android.core.c<y> callback = getCallback();
        if (callback == null) {
            return true;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("tk");
            String stringExtra2 = intent.getStringExtra("ts");
            String stringExtra3 = intent.getStringExtra(FirebaseAnalytics.Param.SCREEN_NAME);
            callback.a(new k<>(new y(new s(stringExtra, stringExtra2), intent.getLongExtra("user_id", 0L), stringExtra3), null));
            return true;
        }
        if (intent == null || !intent.hasExtra("auth_error")) {
            callback.a(new TwitterAuthException("Authorize failed."));
            return true;
        }
        callback.a((TwitterAuthException) intent.getSerializableExtra("auth_error"));
        return true;
    }
}
