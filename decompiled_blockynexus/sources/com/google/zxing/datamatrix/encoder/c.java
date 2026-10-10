package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: C40Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements g {
    c() {
    }

    static void b(h hVar, StringBuilder sb) {
        hVar.a(a(sb, 0));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.h()) {
                break;
            }
            char c2 = hVar.c();
            hVar.f14458f++;
            int iA = a(c2, sb);
            int iA2 = hVar.a() + ((sb.length() / 3) << 1);
            hVar.c(iA2);
            int iA3 = hVar.g().a() - iA2;
            if (!hVar.h()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA3 < 2 || iA3 > 2)) {
                    iA = a(hVar, sb, sb2, iA);
                }
                while (sb.length() % 3 == 1 && ((iA <= 3 && iA3 != 1) || iA > 3)) {
                    iA = a(hVar, sb, sb2, iA);
                }
            } else if (sb.length() % 3 == 0 && j.a(hVar.d(), hVar.f14458f, a()) != a()) {
                hVar.b(0);
                break;
            }
        }
        a(hVar, sb);
    }

    private int a(h hVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        hVar.f14458f--;
        int iA = a(hVar.c(), sb2);
        hVar.j();
        return iA;
    }

    void a(h hVar, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int iA = hVar.a() + length;
        hVar.c(iA);
        int iA2 = hVar.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(hVar, sb);
            }
            if (hVar.h()) {
                hVar.a((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(hVar, sb);
            }
            if (hVar.h()) {
                hVar.a((char) 254);
            }
            hVar.f14458f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(hVar, sb);
            }
            if (iA2 > 0 || hVar.h()) {
                hVar.a((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.b(0);
    }

    int a(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        }
        if (c2 < ' ') {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        }
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 >= '`' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return a((char) (c2 - 128), sb) + 2;
    }

    private static String a(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }
}
