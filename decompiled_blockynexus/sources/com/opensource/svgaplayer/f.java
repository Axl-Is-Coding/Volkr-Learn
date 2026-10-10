package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;

/* JADX INFO: compiled from: SVGAImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements SVGAParser.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f15531a;

    f(g gVar) {
        this.f15531a = gVar;
    }

    @Override // com.opensource.svgaplayer.SVGAParser.c
    public void a(q qVar) {
        kotlin.jvm.internal.i.b(qVar, "videoItem");
        this.f15531a.f15534c.post(new e(this, qVar));
    }

    @Override // com.opensource.svgaplayer.SVGAParser.c
    public void onError() {
    }
}
