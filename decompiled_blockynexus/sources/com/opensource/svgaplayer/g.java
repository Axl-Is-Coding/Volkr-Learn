package com.opensource.svgaplayer;

import com.just.agentweb.DefaultWebClient;
import java.net.URL;

/* JADX INFO: compiled from: SVGAImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SVGAParser f15533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SVGAImageView f15534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f15535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f15536e;

    g(String str, SVGAParser sVGAParser, SVGAImageView sVGAImageView, boolean z, boolean z2) {
        this.f15532a = str;
        this.f15533b = sVGAParser;
        this.f15534c = sVGAImageView;
        this.f15535d = z;
        this.f15536e = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = new f(this);
        if (kotlin.text.n.b(this.f15532a, DefaultWebClient.HTTP_SCHEME, false, 2, null) || kotlin.text.n.b(this.f15532a, DefaultWebClient.HTTPS_SCHEME, false, 2, null)) {
            this.f15533b.b(new URL(this.f15532a), fVar);
        } else {
            this.f15533b.b(this.f15532a, fVar);
        }
    }
}
