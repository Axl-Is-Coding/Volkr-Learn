package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;

/* JADX INFO: compiled from: SVGADynamicEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f15491a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, Bitmap> f15492b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f15493c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, TextPaint> f15494d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, StaticLayout> f15495e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, BoringLayout> f15496f = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> g = new HashMap<>();
    private HashMap<String, int[]> h = new HashMap<>();
    private HashMap<String, a> i = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.e<Canvas, Integer, Integer, Integer, Boolean>> j = new HashMap<>();
    private boolean k;

    public final HashMap<String, BoringLayout> a() {
        return this.f15496f;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> b() {
        return this.g;
    }

    public final HashMap<String, kotlin.jvm.a.e<Canvas, Integer, Integer, Integer, Boolean>> c() {
        return this.j;
    }

    public final HashMap<String, Boolean> d() {
        return this.f15491a;
    }

    public final HashMap<String, a> e() {
        return this.i;
    }

    public final HashMap<String, Bitmap> f() {
        return this.f15492b;
    }

    public final HashMap<String, StaticLayout> g() {
        return this.f15495e;
    }

    public final HashMap<String, String> h() {
        return this.f15493c;
    }

    public final HashMap<String, TextPaint> i() {
        return this.f15494d;
    }

    public final HashMap<String, int[]> j() {
        return this.h;
    }

    public final boolean k() {
        return this.k;
    }

    public final void a(boolean z) {
        this.k = z;
    }
}
