package androidx.core.e;

import android.text.SpannableStringBuilder;
import com.umeng.analytics.pro.ci;
import java.util.Locale;

/* JADX INFO: compiled from: BidiFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f1107a = e.f1140c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1108b = Character.toString(8206);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f1109c = Character.toString(8207);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final a f1110d = new a(false, 2, f1107a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a f1111e = new a(true, 2, f1107a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1112f;
    private final int g;
    private final d h;

    /* JADX INFO: renamed from: androidx.core.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidiFormatter.java */
    public static final class C0010a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f1115c;

        public C0010a() {
            b(a.a(Locale.getDefault()));
        }

        private static a a(boolean z) {
            return z ? a.f1111e : a.f1110d;
        }

        private void b(boolean z) {
            this.f1113a = z;
            this.f1115c = a.f1107a;
            this.f1114b = 2;
        }

        public a a() {
            return (this.f1114b == 2 && this.f1115c == a.f1107a) ? a(this.f1113a) : new a(this.f1113a, this.f1114b, this.f1115c);
        }
    }

    /* JADX INFO: compiled from: BidiFormatter.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final byte[] f1116a = new byte[1792];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f1117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f1118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1120e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private char f1121f;

        static {
            for (int i = 0; i < 1792; i++) {
                f1116a[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f1117b = charSequence;
            this.f1118c = z;
            this.f1119d = charSequence.length();
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f1116a[c2] : Character.getDirectionality(c2);
        }

        private byte e() {
            char c2;
            int i = this.f1120e;
            do {
                int i2 = this.f1120e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1117b;
                int i3 = i2 - 1;
                this.f1120e = i3;
                this.f1121f = charSequence.charAt(i3);
                c2 = this.f1121f;
                if (c2 == '&') {
                    return (byte) 12;
                }
            } while (c2 != ';');
            this.f1120e = i;
            this.f1121f = ';';
            return ci.k;
        }

        private byte f() {
            char cCharAt;
            do {
                int i = this.f1120e;
                if (i >= this.f1119d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f1117b;
                this.f1120e = i + 1;
                cCharAt = charSequence.charAt(i);
                this.f1121f = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte g() {
            char cCharAt;
            int i = this.f1120e;
            while (true) {
                int i2 = this.f1120e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1117b;
                int i3 = i2 - 1;
                this.f1120e = i3;
                this.f1121f = charSequence.charAt(i3);
                char c2 = this.f1121f;
                if (c2 == '<') {
                    return (byte) 12;
                }
                if (c2 == '>') {
                    break;
                }
                if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f1121f;
                    do {
                        int i4 = this.f1120e;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f1117b;
                            int i5 = i4 - 1;
                            this.f1120e = i5;
                            cCharAt = charSequence2.charAt(i5);
                            this.f1121f = cCharAt;
                        }
                    } while (cCharAt != c3);
                }
            }
            this.f1120e = i;
            this.f1121f = '>';
            return ci.k;
        }

        private byte h() {
            char cCharAt;
            int i = this.f1120e;
            while (true) {
                int i2 = this.f1120e;
                if (i2 >= this.f1119d) {
                    this.f1120e = i;
                    this.f1121f = '<';
                    return ci.k;
                }
                CharSequence charSequence = this.f1117b;
                this.f1120e = i2 + 1;
                this.f1121f = charSequence.charAt(i2);
                char c2 = this.f1121f;
                if (c2 == '>') {
                    return (byte) 12;
                }
                if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f1121f;
                    do {
                        int i3 = this.f1120e;
                        if (i3 < this.f1119d) {
                            CharSequence charSequence2 = this.f1117b;
                            this.f1120e = i3 + 1;
                            cCharAt = charSequence2.charAt(i3);
                            this.f1121f = cCharAt;
                        }
                    } while (cCharAt != c3);
                }
            }
        }

        byte b() {
            this.f1121f = this.f1117b.charAt(this.f1120e);
            if (Character.isHighSurrogate(this.f1121f)) {
                int iCodePointAt = Character.codePointAt(this.f1117b, this.f1120e);
                this.f1120e += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f1120e++;
            byte bA = a(this.f1121f);
            if (!this.f1118c) {
                return bA;
            }
            char c2 = this.f1121f;
            return c2 == '<' ? h() : c2 == '&' ? f() : bA;
        }

        int c() {
            this.f1120e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f1120e < this.f1119d && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f1120e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int d() {
            this.f1120e = this.f1119d;
            int i = 0;
            int i2 = 0;
            while (this.f1120e > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i == 0) {
                        i = i2;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i2 == 0) {
                        return 1;
                    }
                    if (i == 0) {
                        i = i2;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i == i2) {
                                return -1;
                            }
                            i2--;
                            break;
                        case 16:
                        case 17:
                            if (i == i2) {
                                return 1;
                            }
                            i2--;
                            break;
                        case 18:
                            i2++;
                            break;
                        default:
                            if (i == 0) {
                                i = i2;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }

        byte a() {
            this.f1121f = this.f1117b.charAt(this.f1120e - 1);
            if (Character.isLowSurrogate(this.f1121f)) {
                int iCodePointBefore = Character.codePointBefore(this.f1117b, this.f1120e);
                this.f1120e -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f1120e--;
            byte bA = a(this.f1121f);
            if (!this.f1118c) {
                return bA;
            }
            char c2 = this.f1121f;
            return c2 == '>' ? g() : c2 == ';' ? e() : bA;
        }
    }

    a(boolean z, int i, d dVar) {
        this.f1112f = z;
        this.g = i;
        this.h = dVar;
    }

    public static a a() {
        return new C0010a().a();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public boolean b() {
        return (this.g & 2) != 0;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean zIsRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f1112f || !(zIsRtl || c(charSequence) == 1)) ? this.f1112f ? (!zIsRtl || c(charSequence) == -1) ? f1109c : "" : "" : f1108b;
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean zIsRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f1112f || !(zIsRtl || b(charSequence) == 1)) ? this.f1112f ? (!zIsRtl || b(charSequence) == -1) ? f1109c : "" : "" : f1108b;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).c();
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, zIsRtl ? e.f1139b : e.f1138a));
        }
        if (zIsRtl != this.f1112f) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, zIsRtl ? e.f1139b : e.f1138a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }
}
