package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.identity.OAuthController;
import com.twitter.sdk.android.core.internal.m;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.w;

/* JADX INFO: loaded from: classes5.dex */
public class OAuthActivity extends Activity implements OAuthController.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OAuthController f20128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ProgressBar f20129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f20130c;

    @Override // com.twitter.sdk.android.core.identity.OAuthController.a
    public void a(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f20128a.a(0, new TwitterAuthException("Authorization failed, request was canceled."));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__activity_oauth);
        this.f20129b = (ProgressBar) findViewById(R.id.tw__spinner);
        this.f20130c = (WebView) findViewById(R.id.tw__web_view);
        this.f20129b.setVisibility(bundle != null ? bundle.getBoolean("progress", false) : true ? 0 : 8);
        this.f20128a = new OAuthController(this.f20129b, this.f20130c, (q) getIntent().getParcelableExtra("auth_config"), new OAuth1aService(w.g(), new m()), this);
        this.f20128a.a();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f20129b.getVisibility() == 0) {
            bundle.putBoolean("progress", true);
        }
        super.onSaveInstanceState(bundle);
    }
}
