package com.disabngo.blockynexus.view.dialog;

import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;

/* JADX INFO: compiled from: ScrapReceivedAnimDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ga implements SVGAParser.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrapReceivedAnimDialog f11307a;

    Ga(ScrapReceivedAnimDialog scrapReceivedAnimDialog) {
        this.f11307a = scrapReceivedAnimDialog;
    }

    @Override // com.opensource.svgaplayer.SVGAParser.c
    public void a(com.opensource.svgaplayer.q qVar) {
        this.f11307a.f11373a.f8756b.setImageDrawable(new com.opensource.svgaplayer.c(qVar));
        this.f11307a.f11373a.f8756b.setLoops(1);
        this.f11307a.f11373a.f8756b.setFillMode(SVGAImageView.FillMode.Forward);
        this.f11307a.f11373a.f8756b.setClearsAfterStop(false);
        this.f11307a.f11373a.f8756b.startAnimation();
    }

    @Override // com.opensource.svgaplayer.SVGAParser.c
    public void onError() {
    }
}
