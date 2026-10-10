package com.ironsource.sdk.controller;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialActivity extends ControllerActivity {
    private static final String q = "InterstitialActivity";

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.ironsource.sdk.utils.f.c(q, "onCreate");
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ironsource.sdk.utils.f.c(q, "onPause");
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        com.ironsource.sdk.utils.f.c(q, "onResume");
    }
}
