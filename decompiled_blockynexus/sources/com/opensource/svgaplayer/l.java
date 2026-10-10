package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import java.net.URL;

/* JADX INFO: compiled from: SVGAParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SVGAParser f15558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ URL f15559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SVGAParser.c f15560c;

    l(SVGAParser sVGAParser, URL url, SVGAParser.c cVar) {
        this.f15558a = sVGAParser;
        this.f15559b = url;
        this.f15560c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SVGAParser sVGAParser = this.f15558a;
        sVGAParser.c(sVGAParser.a(this.f15559b), this.f15560c);
    }
}
