package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;

/* JADX INFO: compiled from: SVGAParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SVGAParser.c f15563a;

    n(SVGAParser.c cVar) {
        this.f15563a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SVGAParser.c cVar = this.f15563a;
        if (cVar != null) {
            cVar.onError();
        }
    }
}
