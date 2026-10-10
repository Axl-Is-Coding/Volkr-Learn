package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.squareup.picasso.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Action.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractC2746a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Picasso f19274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C f19275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final WeakReference<T> f19276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f19277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f19278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f19279f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    /* JADX INFO: renamed from: com.squareup.picasso.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Action.java */
    static class C0167a<M> extends WeakReference<M> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractC2746a f19280a;

        public C0167a(AbstractC2746a abstractC2746a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f19280a = abstractC2746a;
        }
    }

    AbstractC2746a(Picasso picasso, T t, C c2, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f19274a = picasso;
        this.f19275b = c2;
        this.f19276c = t == null ? null : new C0167a(this, t, picasso.m);
        this.f19278e = i;
        this.f19279f = i2;
        this.f19277d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    void a() {
        this.l = true;
    }

    abstract void a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    abstract void b();

    String c() {
        return this.i;
    }

    int d() {
        return this.f19278e;
    }

    int e() {
        return this.f19279f;
    }

    Picasso f() {
        return this.f19274a;
    }

    Picasso.Priority g() {
        return this.f19275b.s;
    }

    C h() {
        return this.f19275b;
    }

    Object i() {
        return this.j;
    }

    T j() {
        WeakReference<T> weakReference = this.f19276c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    boolean k() {
        return this.l;
    }

    boolean l() {
        return this.k;
    }
}
