package com.google.zxing.datamatrix.encoder;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: EncoderContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SymbolShapeHint f14454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.zxing.a f14455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.zxing.a f14456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f14457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14458f;
    private int g;
    private k h;
    private int i;

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c2 = (char) (bytes[i] & 255);
            if (c2 == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.f14453a = sb.toString();
        this.f14454b = SymbolShapeHint.FORCE_NONE;
        this.f14457e = new StringBuilder(str.length());
        this.g = -1;
    }

    private int l() {
        return this.f14453a.length() - this.i;
    }

    public void a(SymbolShapeHint symbolShapeHint) {
        this.f14454b = symbolShapeHint;
    }

    public StringBuilder b() {
        return this.f14457e;
    }

    public char c() {
        return this.f14453a.charAt(this.f14458f);
    }

    public String d() {
        return this.f14453a;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return l() - this.f14458f;
    }

    public k g() {
        return this.h;
    }

    public boolean h() {
        return this.f14458f < l();
    }

    public void i() {
        this.g = -1;
    }

    public void j() {
        this.h = null;
    }

    public void k() {
        c(a());
    }

    public void a(com.google.zxing.a aVar, com.google.zxing.a aVar2) {
        this.f14455c = aVar;
        this.f14456d = aVar2;
    }

    public void b(int i) {
        this.g = i;
    }

    public void c(int i) {
        k kVar = this.h;
        if (kVar == null || i > kVar.a()) {
            this.h = k.a(i, this.f14454b, this.f14455c, this.f14456d, true);
        }
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.f14457e.append(str);
    }

    public void a(char c2) {
        this.f14457e.append(c2);
    }

    public int a() {
        return this.f14457e.length();
    }
}
