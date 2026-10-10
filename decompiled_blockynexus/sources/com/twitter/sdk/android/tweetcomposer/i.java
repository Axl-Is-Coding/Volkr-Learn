package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import fi.iki.elonen.NanoHTTPD;
import java.net.URL;

/* JADX INFO: compiled from: TweetComposer.java */
/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f20309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private URL f20311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f20312d;

    public i(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.f20309a = context;
    }

    public i a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text must not be null.");
        }
        if (this.f20310b != null) {
            throw new IllegalStateException("text already set.");
        }
        this.f20310b = str;
        return this;
    }

    Intent b() {
        Intent intent = new Intent("android.intent.action.SEND");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f20310b)) {
            sb.append(this.f20310b);
        }
        if (this.f20311c != null) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(this.f20311c.toString());
        }
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        intent.setType(NanoHTTPD.MIME_PLAINTEXT);
        Uri uri = this.f20312d;
        if (uri != null) {
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.setType("image/jpeg");
        }
        for (ResolveInfo resolveInfo : this.f20309a.getPackageManager().queryIntentActivities(intent, 65536)) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                return intent;
            }
        }
        return null;
    }

    Intent c() {
        URL url = this.f20311c;
        return new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://twitter.com/intent/tweet?text=%s&url=%s", com.twitter.sdk.android.core.internal.a.f.c(this.f20310b), com.twitter.sdk.android.core.internal.a.f.c(url == null ? "" : url.toString()))));
    }

    public i a(Uri uri) {
        if (uri != null) {
            if (this.f20312d == null) {
                this.f20312d = uri;
                return this;
            }
            throw new IllegalStateException("imageUri already set.");
        }
        throw new IllegalArgumentException("imageUri must not be null.");
    }

    public Intent a() {
        Intent intentB = b();
        return intentB == null ? c() : intentB;
    }
}
