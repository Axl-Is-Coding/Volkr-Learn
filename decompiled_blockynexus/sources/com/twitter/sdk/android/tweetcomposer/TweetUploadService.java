package com.twitter.sdk.android.tweetcomposer;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.s;
import com.twitter.sdk.android.core.w;
import com.twitter.sdk.android.core.y;
import java.io.File;
import okhttp3.G;

/* JADX INFO: loaded from: classes5.dex */
public class TweetUploadService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f20294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Intent f20295b;

    static class a {
        a() {
        }

        o a(y yVar) {
            return w.g().a(yVar);
        }
    }

    public TweetUploadService() {
        this(new a());
    }

    void a(y yVar, String str, Uri uri) {
        if (uri != null) {
            a(yVar, uri, new j(this, yVar, str));
        } else {
            a(yVar, str, (String) null);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        s sVar = (s) intent.getParcelableExtra("EXTRA_USER_TOKEN");
        this.f20295b = intent;
        a(new y(sVar, -1L, ""), intent.getStringExtra("EXTRA_TWEET_TEXT"), (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI"));
    }

    TweetUploadService(a aVar) {
        super("TweetUploadService");
        this.f20294a = aVar;
    }

    void a(y yVar, String str, String str2) {
        this.f20294a.a(yVar).d().update(str, null, null, null, null, null, null, true, str2).enqueue(new k(this));
    }

    void a(y yVar, Uri uri, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.h> cVar) {
        o oVarA = this.f20294a.a(yVar);
        String strA = h.a(this, uri);
        if (strA == null) {
            a(new TwitterException("Uri file path resolved to null"));
            return;
        }
        File file = new File(strA);
        oVarA.c().upload(G.create(okhttp3.w.b(h.a(file)), file), null, null).enqueue(cVar);
    }

    void a(TwitterException twitterException) {
        a(this.f20295b);
        n.e().e("TweetUploadService", "Post Tweet failed", twitterException);
        stopSelf();
    }

    void a(long j) {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS");
        intent.putExtra("EXTRA_TWEET_ID", j);
        intent.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent);
    }

    void a(Intent intent) {
        Intent intent2 = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_FAILURE");
        intent2.putExtra("EXTRA_RETRY_INTENT", intent);
        intent2.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent2);
    }
}
