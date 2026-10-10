package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SVGAParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SVGAParser f15553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InputStream f15554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SVGAParser.c f15556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f15557e;

    k(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.c cVar, boolean z) {
        this.f15553a = sVGAParser;
        this.f15554b = inputStream;
        this.f15555c = str;
        this.f15556d = cVar;
        this.f15557e = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        try {
            try {
                byte[] bArrA = this.f15553a.a(this.f15554b);
                if (bArrA != null) {
                    if (bArrA.length > 4 && bArrA[0] == 80 && bArrA[1] == 75 && bArrA[2] == 3 && bArrA[3] == 4) {
                        if (!this.f15553a.a(this.f15555c).exists()) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrA);
                            try {
                                this.f15553a.a(byteArrayInputStream, this.f15555c);
                                kotlin.l lVar = kotlin.l.f22855a;
                            } finally {
                                kotlin.io.a.a(byteArrayInputStream, null);
                            }
                        }
                        this.f15553a.c(this.f15555c, this.f15556d);
                    } else {
                        byte[] bArrA2 = this.f15553a.a(bArrA);
                        if (bArrA2 != null) {
                            MovieEntity movieEntityDecode = MovieEntity.ADAPTER.decode(bArrA2);
                            kotlin.jvm.internal.i.a((Object) movieEntityDecode, "MovieEntity.ADAPTER.decode(it)");
                            final q qVar = new q(movieEntityDecode, new File(this.f15555c));
                            qVar.a(new kotlin.jvm.a.a<kotlin.l>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.a.a
                                public /* bridge */ /* synthetic */ kotlin.l invoke() {
                                    invoke2();
                                    return kotlin.l.f22855a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    k kVar = this;
                                    kVar.f15553a.invokeCompleteCallback(qVar, kVar.f15556d);
                                }
                            });
                        }
                    }
                }
                if (!this.f15557e) {
                    return;
                }
            } catch (Exception e2) {
                this.f15553a.invokeErrorCallback(e2, this.f15556d);
                if (!this.f15557e) {
                    return;
                }
            }
            this.f15554b.close();
        } catch (Throwable th) {
            if (this.f15557e) {
                this.f15554b.close();
            }
            throw th;
        }
    }
}
