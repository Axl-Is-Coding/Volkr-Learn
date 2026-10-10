package com.google.zxing.d.a;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: QRCode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Mode f14444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ErrorCorrectionLevel f14445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.zxing.qrcode.decoder.a f14446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14447d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f14448e;

    public static boolean a(int i) {
        return i >= 0 && i < 8;
    }

    public b a() {
        return this.f14448e;
    }

    public void b(int i) {
        this.f14447d = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f14444a);
        sb.append("\n ecLevel: ");
        sb.append(this.f14445b);
        sb.append("\n version: ");
        sb.append(this.f14446c);
        sb.append("\n maskPattern: ");
        sb.append(this.f14447d);
        if (this.f14448e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f14448e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(Mode mode) {
        this.f14444a = mode;
    }

    public void a(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f14445b = errorCorrectionLevel;
    }

    public void a(com.google.zxing.qrcode.decoder.a aVar) {
        this.f14446c = aVar;
    }

    public void a(b bVar) {
        this.f14448e = bVar;
    }
}
