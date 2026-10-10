package com.opensource.svgaplayer;

import android.media.SoundPool;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: SVGAVideoEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
final class p implements SoundPool.OnLoadCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref$IntRef f15565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f15566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ q f15567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.a f15568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ MovieEntity f15569e;

    p(Ref$IntRef ref$IntRef, List list, q qVar, kotlin.jvm.a.a aVar, MovieEntity movieEntity) {
        this.f15565a = ref$IntRef;
        this.f15566b = list;
        this.f15567c = qVar;
        this.f15568d = aVar;
        this.f15569e = movieEntity;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        Ref$IntRef ref$IntRef = this.f15565a;
        ref$IntRef.element++;
        if (ref$IntRef.element >= this.f15566b.size()) {
            this.f15568d.invoke();
        }
    }
}
