package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;

/* JADX INFO: compiled from: SVGAParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SVGAParser.c f15561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f15562b;

    m(SVGAParser.c cVar, q qVar) {
        this.f15561a = cVar;
        this.f15562b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SVGAParser.c cVar = this.f15561a;
        if (cVar != null) {
            cVar.a(this.f15562b);
        }
    }
}
