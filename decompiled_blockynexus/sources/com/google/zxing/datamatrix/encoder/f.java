package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: EdifactEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements g {
    f() {
    }

    public int a() {
        return 4;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.h()) {
                break;
            }
            a(hVar.c(), sb);
            hVar.f14458f++;
            if (sb.length() >= 4) {
                hVar.a(a(sb, 0));
                sb.delete(0, 4);
                if (j.a(hVar.d(), hVar.f14458f, a()) != a()) {
                    hVar.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(hVar, sb);
    }

    private static void a(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                hVar.k();
                int iA = hVar.g().a() - hVar.a();
                int iF = hVar.f();
                if (iF > iA) {
                    hVar.c(hVar.a() + 1);
                    iA = hVar.g().a() - hVar.a();
                }
                if (iF <= iA && iA <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i = length - 1;
                String strA = a(charSequence, 0);
                if (!(!hVar.h()) || i > 2) {
                    z = false;
                }
                if (i <= 2) {
                    hVar.c(hVar.a() + i);
                    if (hVar.g().a() - hVar.a() >= 3) {
                        hVar.c(hVar.a() + strA.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.j();
                    hVar.f14458f -= i;
                } else {
                    hVar.a(strA);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            hVar.b(0);
        }
    }

    private static void a(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            j.a(c2);
            throw null;
        }
    }

    private static String a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
            char c2 = (char) ((iCharAt >> 16) & 255);
            char c3 = (char) ((iCharAt >> 8) & 255);
            char c4 = (char) (iCharAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c2);
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
