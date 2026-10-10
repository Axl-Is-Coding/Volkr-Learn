package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: ASCIIEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements g {
    a() {
    }

    public int a() {
        return 0;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f14458f) >= 2) {
            hVar.a(a(hVar.d().charAt(hVar.f14458f), hVar.d().charAt(hVar.f14458f + 1)));
            hVar.f14458f += 2;
            return;
        }
        char c2 = hVar.c();
        int iA = j.a(hVar.d(), hVar.f14458f, a());
        if (iA == a()) {
            if (!j.c(c2)) {
                hVar.a((char) (c2 + 1));
                hVar.f14458f++;
                return;
            } else {
                hVar.a((char) 235);
                hVar.a((char) ((c2 - 128) + 1));
                hVar.f14458f++;
                return;
            }
        }
        if (iA == 1) {
            hVar.a((char) 230);
            hVar.b(1);
            return;
        }
        if (iA == 2) {
            hVar.a((char) 239);
            hVar.b(2);
            return;
        }
        if (iA == 3) {
            hVar.a((char) 238);
            hVar.b(3);
        } else if (iA == 4) {
            hVar.a((char) 240);
            hVar.b(4);
        } else {
            if (iA != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iA)));
            }
            hVar.a((char) 231);
            hVar.b(5);
        }
    }

    private static char a(char c2, char c3) {
        if (j.b(c2) && j.b(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }
}
