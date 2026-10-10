package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: X12Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class m extends c {
    m() {
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public int a() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.h()) {
                break;
            }
            char c2 = hVar.c();
            hVar.f14458f++;
            a(c2, sb);
            if (sb.length() % 3 == 0) {
                c.b(hVar, sb);
                if (j.a(hVar.d(), hVar.f14458f, a()) != a()) {
                    hVar.b(0);
                    break;
                }
            }
        }
        a(hVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int a(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
        } else {
            j.a(c2);
            throw null;
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void a(h hVar, StringBuilder sb) {
        hVar.k();
        int iA = hVar.g().a() - hVar.a();
        hVar.f14458f -= sb.length();
        if (hVar.f() > 1 || iA > 1 || hVar.f() != iA) {
            hVar.a((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.b(0);
        }
    }
}
