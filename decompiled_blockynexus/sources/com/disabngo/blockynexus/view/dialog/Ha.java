package com.disabngo.blockynexus.view.dialog;

import android.util.Log;

/* JADX INFO: compiled from: ScrapReceivedAnimDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ha implements com.opensource.svgaplayer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrapReceivedAnimDialog f11309a;

    Ha(ScrapReceivedAnimDialog scrapReceivedAnimDialog) {
        this.f11309a = scrapReceivedAnimDialog;
    }

    @Override // com.opensource.svgaplayer.b
    public void a() {
        this.f11309a.c();
    }

    @Override // com.opensource.svgaplayer.b
    public void b() {
        Log.d("onStep", "onRepeat");
    }

    @Override // com.opensource.svgaplayer.b
    public void onPause() {
    }

    @Override // com.opensource.svgaplayer.b
    public void a(int i, double d2) {
        Log.d("onStep", i + "");
    }
}
