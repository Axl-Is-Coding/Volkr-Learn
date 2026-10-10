package com.twitter.sdk.android.tweetcomposer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.twitter.sdk.android.core.s;
import com.twitter.sdk.android.core.y;

/* JADX INFO: loaded from: classes5.dex */
public class ComposerActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f20292a;

    interface a {
        void finish();
    }

    class b implements a {
        b() {
        }

        @Override // com.twitter.sdk.android.tweetcomposer.ComposerActivity.a
        public void finish() {
            ComposerActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.f20292a.a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        y yVar = new y((s) intent.getParcelableExtra("EXTRA_USER_TOKEN"), -1L, "");
        Uri uri = (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI");
        String stringExtra = intent.getStringExtra("EXTRA_TEXT");
        String stringExtra2 = intent.getStringExtra("EXTRA_HASHTAGS");
        setTheme(intent.getIntExtra("EXTRA_THEME", R.style.ComposerLight));
        setContentView(R.layout.tw__activity_composer);
        this.f20292a = new f((ComposerView) findViewById(R.id.tw__composer_view), yVar, uri, stringExtra, stringExtra2, new b());
    }
}
