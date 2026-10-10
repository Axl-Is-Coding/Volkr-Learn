package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import okhttp3.J;

/* JADX INFO: compiled from: OAuth1aService.java */
/* JADX INFO: loaded from: classes5.dex */
class f extends com.twitter.sdk.android.core.c<J> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.twitter.sdk.android.core.c f20196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OAuth1aService f20197b;

    f(OAuth1aService oAuth1aService, com.twitter.sdk.android.core.c cVar) {
        this.f20197b = oAuth1aService;
        this.f20196a = cVar;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(com.twitter.sdk.android.core.k<J> kVar) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(kVar.f20217a.byteStream()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                String string = sb.toString();
                l lVarA = OAuth1aService.a(string);
                if (lVarA != null) {
                    this.f20196a.a(new com.twitter.sdk.android.core.k(lVarA, null));
                    return;
                }
                this.f20196a.a(new TwitterAuthException("Failed to parse auth response: " + string));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            this.f20196a.a(new TwitterAuthException(e2.getMessage(), e2));
        }
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        this.f20196a.a(twitterException);
    }
}
