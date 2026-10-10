package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import androidx.core.content.a.c;
import androidx.core.d.f;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: TypefaceCompatApi29Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends k {
    @Override // androidx.core.a.k
    protected f.b a(f.b[] bVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.a.k
    protected Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[Catch: IOException -> 0x0069, PHI: r4
      0x001c: PHI (r4v5 android.graphics.fonts.FontFamily$Builder) = (r4v3 android.graphics.fonts.FontFamily$Builder), (r4v1 android.graphics.fonts.FontFamily$Builder) binds: [B:19:0x0051, B:8:0x001a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {IOException -> 0x0069, blocks: (B:6:0x000e, B:9:0x001c, B:31:0x0065, B:32:0x0068), top: B:47:0x000e }] */
    @Override // androidx.core.a.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface a(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.d.f.b[] r14, int r15) throws java.lang.Throwable {
        /*
            r11 = this;
            android.content.ContentResolver r12 = r12.getContentResolver()
            int r0 = r14.length
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L9:
            r5 = 1
            if (r3 >= r0) goto L6c
            r6 = r14[r3]
            android.net.Uri r7 = r6.c()     // Catch: java.io.IOException -> L69
            java.lang.String r8 = "r"
            android.os.ParcelFileDescriptor r7 = r12.openFileDescriptor(r7, r8, r13)     // Catch: java.io.IOException -> L69
            if (r7 != 0) goto L20
            if (r7 == 0) goto L69
        L1c:
            r7.close()     // Catch: java.io.IOException -> L69
            goto L69
        L20:
            android.graphics.fonts.Font$Builder r8 = new android.graphics.fonts.Font$Builder     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            int r9 = r6.d()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.graphics.fonts.Font$Builder r8 = r8.setWeight(r9)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            boolean r9 = r6.e()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            if (r9 == 0) goto L34
            goto L35
        L34:
            r5 = 0
        L35:
            android.graphics.fonts.Font$Builder r5 = r8.setSlant(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            int r6 = r6.b()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.graphics.fonts.Font$Builder r5 = r5.setTtcIndex(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.graphics.fonts.Font r5 = r5.build()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            if (r4 != 0) goto L4e
            android.graphics.fonts.FontFamily$Builder r6 = new android.graphics.fonts.FontFamily$Builder     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r4 = r6
            goto L51
        L4e:
            r4.addFont(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
        L51:
            if (r7 == 0) goto L69
            goto L1c
        L54:
            r5 = move-exception
            r6 = r2
            goto L5d
        L57:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L59
        L59:
            r6 = move-exception
            r10 = r6
            r6 = r5
            r5 = r10
        L5d:
            if (r7 == 0) goto L68
            if (r6 == 0) goto L65
            r7.close()     // Catch: java.lang.Throwable -> L68
            goto L68
        L65:
            r7.close()     // Catch: java.io.IOException -> L69
        L68:
            throw r5     // Catch: java.io.IOException -> L69
        L69:
            int r3 = r3 + 1
            goto L9
        L6c:
            if (r4 != 0) goto L6f
            return r2
        L6f:
            android.graphics.fonts.FontStyle r12 = new android.graphics.fonts.FontStyle
            r13 = r15 & 1
            if (r13 == 0) goto L78
            r13 = 700(0x2bc, float:9.81E-43)
            goto L7a
        L78:
            r13 = 400(0x190, float:5.6E-43)
        L7a:
            r14 = r15 & 2
            if (r14 == 0) goto L7f
            r1 = 1
        L7f:
            r12.<init>(r13, r1)
            android.graphics.Typeface$CustomFallbackBuilder r13 = new android.graphics.Typeface$CustomFallbackBuilder
            android.graphics.fonts.FontFamily r14 = r4.build()
            r13.<init>(r14)
            android.graphics.Typeface$CustomFallbackBuilder r12 = r13.setStyle(r12)
            android.graphics.Typeface r12 = r12.build()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a.h.a(android.content.Context, android.os.CancellationSignal, androidx.core.d.f$b[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.a.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0009c[] c0009cArrA = bVar.a();
        int length = c0009cArrA.length;
        FontFamily.Builder builder = null;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                break;
            }
            c.C0009c c0009c = c0009cArrA[i2];
            try {
                Font.Builder weight = new Font.Builder(resources, c0009c.b()).setWeight(c0009c.e());
                if (!c0009c.f()) {
                    i3 = 0;
                }
                Font fontBuild = weight.setSlant(i3).setTtcIndex(c0009c.c()).setFontVariationSettings(c0009c.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            } catch (IOException unused) {
            }
            i2++;
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.a.k
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
