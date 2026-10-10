package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C0501c implements com.bumptech.glide.load.n<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<Integer> f4668a = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<Bitmap.CompressFormat> f4669b = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4670c;

    public C0501c(com.bumptech.glide.load.engine.a.b bVar) {
        this.f4670c = bVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:47|3|4|(2:45|5)|(5:51|6|(2:8|9)(1:10)|11|12)|43|13|28|29|(1:31)|32|33) */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #2 {all -> 0x00c0, blocks: (B:3:0x0021, B:13:0x004d, B:29:0x006a, B:31:0x0070, B:35:0x00bc, B:36:0x00bf), top: B:47:0x0021 }] */
    @Override // com.bumptech.glide.load.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.bumptech.glide.load.engine.C<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.l r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.a(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.e.a.e.a(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.e.h.a()     // Catch: java.lang.Throwable -> Lc0
            com.bumptech.glide.load.k<java.lang.Integer> r4 = com.bumptech.glide.load.resource.bitmap.C0501c.f4668a     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r4 = r11.a(r4)     // Catch: java.lang.Throwable -> Lc0
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lc0
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lc0
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            com.bumptech.glide.load.engine.a.b r10 = r8.f4670c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r10 == 0) goto L45
            com.bumptech.glide.load.data.c r10 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            com.bumptech.glide.load.engine.a.b r6 = r8.f4670c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6 = r10
            goto L46
        L45:
            r6 = r7
        L46:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r6.close()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5 = 1
        L4d:
            r6.close()     // Catch: java.io.IOException -> L69 java.lang.Throwable -> Lc0
            goto L69
        L51:
            r9 = move-exception
            r6 = r7
            goto Lba
        L54:
            r10 = move-exception
            r6 = r7
            goto L5a
        L57:
            r9 = move-exception
            goto Lba
        L59:
            r10 = move-exception
        L5a:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L66
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch: java.lang.Throwable -> L57
        L66:
            if (r6 == 0) goto L69
            goto L4d
        L69:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lc0
            if (r10 == 0) goto Lb6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
            r10.<init>()     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r4 = "Compressed with type: "
            r10.append(r4)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = " of size "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            int r1 = com.bumptech.glide.e.n.a(r9)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = " in "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            double r1 = com.bumptech.glide.e.h.a(r2)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = ", options format: "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            com.bumptech.glide.load.k<android.graphics.Bitmap$CompressFormat> r1 = com.bumptech.glide.load.resource.bitmap.C0501c.f4669b     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r11 = r11.a(r1)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc0
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lc0
            r10.append(r9)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> Lc0
            android.util.Log.v(r0, r9)     // Catch: java.lang.Throwable -> Lc0
        Lb6:
            com.bumptech.glide.e.a.e.a()
            return r5
        Lba:
            if (r6 == 0) goto Lbf
            r6.close()     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> Lc0
        Lbf:
            throw r9     // Catch: java.lang.Throwable -> Lc0
        Lc0:
            r9 = move-exception
            com.bumptech.glide.e.a.e.a()
            goto Lc6
        Lc5:
            throw r9
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.C0501c.a(com.bumptech.glide.load.engine.C, java.io.File, com.bumptech.glide.load.l):boolean");
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.bumptech.glide.load.l lVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) lVar.a(f4669b);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.n
    public EncodeStrategy a(com.bumptech.glide.load.l lVar) {
        return EncodeStrategy.TRANSFORMED;
    }
}
