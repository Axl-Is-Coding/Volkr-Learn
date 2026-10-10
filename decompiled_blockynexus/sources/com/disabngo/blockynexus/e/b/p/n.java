package com.disabngo.blockynexus.e.b.p;

import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.q;

/* JADX INFO: compiled from: CheckUpdateViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements SVGAParser.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f10043a;

    n(o oVar) {
        this.f10043a = oVar;
    }

    @Override // com.opensource.svgaplayer.SVGAParser.c
    public void a(q qVar) {
        com.opensource.svgaplayer.c cVar = new com.opensource.svgaplayer.c(qVar);
        this.f10043a.f10049f.setLoops(0);
        this.f10043a.f10049f.setImageDrawable(cVar);
        this.f10043a.f10049f.startAnimation();
    }

    @Override // com.opensource.svgaplayer.SVGAParser.c
    public void onError() {
    }
}
