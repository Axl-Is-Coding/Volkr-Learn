package com.twitter.sdk.android.tweetui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.squareup.picasso.Picasso;

/* JADX INFO: compiled from: TweetUi.java */
/* JADX INFO: loaded from: classes5.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static volatile L f20344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.twitter.sdk.android.core.m<com.twitter.sdk.android.core.y> f20345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.twitter.sdk.android.core.g f20346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f20347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private I f20348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Picasso f20349f;

    L() {
        com.twitter.sdk.android.core.w wVarG = com.twitter.sdk.android.core.w.g();
        this.f20347d = com.twitter.sdk.android.core.n.d().a(a());
        this.f20345b = wVarG.h();
        this.f20346c = wVarG.e();
        this.f20348e = new I(new Handler(Looper.getMainLooper()), wVarG.h());
        this.f20349f = Picasso.a(com.twitter.sdk.android.core.n.d().a(a()));
    }

    public static L c() {
        if (f20344a == null) {
            synchronized (L.class) {
                if (f20344a == null) {
                    f20344a = new L();
                }
            }
        }
        return f20344a;
    }

    public String a() {
        return "com.twitter.sdk.android:tweet-ui";
    }

    public Picasso b() {
        return this.f20349f;
    }

    I d() {
        return this.f20348e;
    }
}
