package com.twitter.sdk.android.tweetcomposer;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.o;
import com.twitter.sdk.android.core.w;
import com.twitter.sdk.android.core.y;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

/* JADX INFO: compiled from: ComposerController.java */
/* JADX INFO: loaded from: classes5.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ComposerView f20301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final y f20302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Uri f20303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ComposerActivity.a f20304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final c f20305e;

    /* JADX INFO: compiled from: ComposerController.java */
    interface a {
        void a();

        void a(String str);

        void b(String str);
    }

    /* JADX INFO: compiled from: ComposerController.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.twitter.c f20307a = new com.twitter.c();

        c() {
        }

        o a(y yVar) {
            return w.g().a(yVar);
        }

        com.twitter.c a() {
            return this.f20307a;
        }
    }

    f(ComposerView composerView, y yVar, Uri uri, String str, String str2, ComposerActivity.a aVar) {
        this(composerView, yVar, uri, str, str2, aVar, new c());
    }

    static boolean a(int i) {
        return i > 0 && i <= 140;
    }

    static boolean b(int i) {
        return i > 140;
    }

    static int c(int i) {
        return 140 - i;
    }

    String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    void b() {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.TWEET_COMPOSE_CANCEL");
        intent.setPackage(this.f20301a.getContext().getPackageName());
        this.f20301a.getContext().sendBroadcast(intent);
    }

    void c() {
        this.f20305e.a(this.f20302b).a().verifyCredentials(false, true, false).enqueue(new e(this));
    }

    f(ComposerView composerView, y yVar, Uri uri, String str, String str2, ComposerActivity.a aVar, c cVar) {
        this.f20301a = composerView;
        this.f20302b = yVar;
        this.f20303c = uri;
        this.f20304d = aVar;
        this.f20305e = cVar;
        composerView.setCallbacks(new b());
        composerView.setTweetText(a(str, str2));
        c();
        a(uri);
    }

    /* JADX INFO: compiled from: ComposerController.java */
    class b implements a {
        b() {
        }

        @Override // com.twitter.sdk.android.tweetcomposer.f.a
        public void a(String str) {
            Intent intent = new Intent(f.this.f20301a.getContext(), (Class<?>) TweetUploadService.class);
            intent.putExtra("EXTRA_USER_TOKEN", f.this.f20302b.a());
            intent.putExtra("EXTRA_TWEET_TEXT", str);
            intent.putExtra("EXTRA_IMAGE_URI", f.this.f20303c);
            f.this.f20301a.getContext().startService(intent);
            f.this.f20304d.finish();
        }

        @Override // com.twitter.sdk.android.tweetcomposer.f.a
        public void b(String str) {
            int iA = f.this.a(str);
            f.this.f20301a.setCharCount(f.c(iA));
            if (f.b(iA)) {
                f.this.f20301a.setCharCountTextStyle(R.style.tw__ComposerCharCountOverflow);
            } else {
                f.this.f20301a.setCharCountTextStyle(R.style.tw__ComposerCharCount);
            }
            f.this.f20301a.postTweetEnabled(f.a(iA));
        }

        @Override // com.twitter.sdk.android.tweetcomposer.f.a
        public void a() {
            f.this.a();
        }
    }

    void a(Uri uri) {
        if (uri != null) {
            this.f20301a.setImageView(uri);
        }
    }

    void a() {
        b();
        this.f20304d.finish();
    }

    int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.f20305e.a().a(str);
    }
}
