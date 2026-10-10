package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: Base256Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements g {
    b() {
    }

    public int a() {
        return 5;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.h()) {
                break;
            }
            sb.append(hVar.c());
            hVar.f14458f++;
            if (j.a(hVar.d(), hVar.f14458f, a()) != a()) {
                hVar.b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = hVar.a() + length + 1;
        hVar.c(iA);
        boolean z = hVar.g().a() - iA > 0;
        if (hVar.h() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            hVar.a(a(sb.charAt(i), hVar.a() + 1));
        }
    }

    private static char a(char c2, int i) {
        int i2 = c2 + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }
}
