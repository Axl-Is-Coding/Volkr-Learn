package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.c;

/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e extends c.a {

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class a implements TypeEvaluator<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TypeEvaluator<d> f13266a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f13267b = new d();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d evaluate(float f2, d dVar, d dVar2) {
            this.f13267b.a(com.google.android.material.h.a.b(dVar.f13270a, dVar2.f13270a, f2), com.google.android.material.h.a.b(dVar.f13271b, dVar2.f13271b, f2), com.google.android.material.h.a.b(dVar.f13272c, dVar2.f13272c, f2));
            return this.f13267b;
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class b extends Property<e, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<e, d> f13268a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d get(e eVar) {
            return eVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, d dVar) {
            eVar.setRevealInfo(dVar);
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<e, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<e, Integer> f13269a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, Integer num) {
            eVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f13272c;

        public void a(float f2, float f3, float f4) {
            this.f13270a = f2;
            this.f13271b = f3;
            this.f13272c = f4;
        }

        private d() {
        }

        public d(float f2, float f3, float f4) {
            this.f13270a = f2;
            this.f13271b = f3;
            this.f13272c = f4;
        }

        public void a(d dVar) {
            a(dVar.f13270a, dVar.f13271b, dVar.f13272c);
        }

        public boolean a() {
            return this.f13272c == Float.MAX_VALUE;
        }

        public d(d dVar) {
            this(dVar.f13270a, dVar.f13271b, dVar.f13272c);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d dVar);
}
