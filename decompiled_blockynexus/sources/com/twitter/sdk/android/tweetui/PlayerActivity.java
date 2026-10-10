package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class PlayerActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    v f20356a;

    public static class PlayerItem implements Serializable {
        public final String callToActionText;
        public final String callToActionUrl;
        public final boolean looping;
        public final boolean showVideoControls;
        public final String url;

        public PlayerItem(String str, boolean z, boolean z2, String str2, String str3) {
            this.url = str;
            this.looping = z;
            this.showVideoControls = z2;
            this.callToActionText = str2;
            this.callToActionUrl = str3;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__player_activity);
        PlayerItem playerItem = (PlayerItem) getIntent().getSerializableExtra("PLAYER_ITEM");
        this.f20356a = new v(findViewById(android.R.id.content), new u(this));
        this.f20356a.a(playerItem);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f20356a.a();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f20356a.b();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f20356a.c();
    }
}
