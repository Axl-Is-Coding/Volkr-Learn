package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import java.util.Queue;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d<T extends m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f4473a = com.bumptech.glide.e.n.a(20);

    d() {
    }

    abstract T a();

    public void a(T t) {
        if (this.f4473a.size() < 20) {
            this.f4473a.offer(t);
        }
    }

    T b() {
        T tPoll = this.f4473a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }
}
