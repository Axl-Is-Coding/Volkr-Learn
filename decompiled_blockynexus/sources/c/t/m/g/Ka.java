package c.t.m.g;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2942a = {31, 113, 239, 397, 439, 557, 619, 773, 853, 977};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f2943b = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a[] f2944c = new a[Math.min(Math.max(1, 5), 10)];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f2945d;

    /* JADX INFO: compiled from: TL */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2946a = 65536;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2947b;

        public a(int i) {
            this.f2947b = i;
        }

        public final int a(String str) {
            int length = str.length();
            int iCharAt = 0;
            for (int i = 0; i < length; i++) {
                iCharAt = str.charAt(i) + (this.f2947b * iCharAt);
            }
            return (this.f2946a - 1) & iCharAt;
        }
    }

    public Ka(byte b2) {
        int i = 0;
        while (true) {
            a[] aVarArr = this.f2944c;
            if (i >= aVarArr.length) {
                this.f2945d = new byte[8192];
                return;
            } else {
                aVarArr[i] = new a(f2942a[i]);
                i++;
            }
        }
    }

    public final byte[] a() {
        byte[] bArr;
        synchronized (this.f2943b) {
            bArr = this.f2945d;
        }
        return bArr;
    }

    public final boolean b(String str) {
        synchronized (this.f2943b) {
            if (str == null) {
                return false;
            }
            a[] aVarArr = this.f2944c;
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= length) {
                    return true;
                }
                int iA = aVarArr[i].a(str);
                if (((1 << (iA % 8)) & this.f2945d[iA / 8]) == 0) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
                i++;
            }
        }
    }

    public final void a(String str) {
        synchronized (this.f2943b) {
            for (a aVar : this.f2944c) {
                int iA = aVar.a(str);
                byte[] bArr = this.f2945d;
                int i = iA / 8;
                bArr[i] = (byte) ((1 << (iA % 8)) | bArr[i]);
            }
        }
    }
}
