package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: SVGAAudioEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f15515f;
    private Integer g;

    public a(AudioEntity audioEntity) {
        i.b(audioEntity, "audioItem");
        this.f15510a = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f15511b = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f15512c = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.f15513d = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.f15514e = num4 != null ? num4.intValue() : 0;
    }

    public final int a() {
        return this.f15512c;
    }

    public final void b(Integer num) {
        this.f15515f = num;
    }

    public final Integer c() {
        return this.f15515f;
    }

    public final int d() {
        return this.f15511b;
    }

    public final void a(Integer num) {
        this.g = num;
    }

    public final Integer b() {
        return this.g;
    }
}
