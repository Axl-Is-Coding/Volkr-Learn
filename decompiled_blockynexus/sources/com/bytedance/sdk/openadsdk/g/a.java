package com.bytedance.sdk.openadsdk.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DiskImageCache.java */
/* JADX INFO: loaded from: classes.dex */
class a extends com.bytedance.sdk.adnet.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakHashMap<String, String> f6758c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.b.a f6759d = new com.bytedance.sdk.openadsdk.b.d();

    private a() {
    }

    public static a a() {
        return new a();
    }

    private static String b() {
        if (TextUtils.isEmpty(f6757b)) {
            File file = new File(com.bytedance.sdk.adnet.a.b(o.a()), "diskImage");
            file.mkdirs();
            f6757b = file.getAbsolutePath();
        }
        return f6757b;
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public Bitmap a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Bitmap bitmapA = super.a(str);
        if (bitmapA == null) {
            File file = new File(b(), str);
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        bitmapA = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, null);
                        if (bitmapA != null) {
                            super.a(str, bitmapA);
                        }
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return bitmapA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.graphics.Bitmap] */
    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public void a(String str, Bitmap bitmap) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bitmap == 0) {
            return;
        }
        super.a(str, bitmap);
        File file = new File(b(), str);
        if (file.exists() && file.isFile() && file.length() > 0) {
            return;
        }
        File file2 = new File(file + ".tmp");
        file2.delete();
        ?? r3 = 0;
        r3 = 0;
        try {
            try {
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException unused) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.flush();
            if (file2.exists() && file2.length() > 0) {
                file2.renameTo(file);
            }
            this.f6759d.a(file);
            fileOutputStream.close();
            r3 = compressFormat;
        } catch (Throwable th3) {
            th = th3;
            r3 = fileOutputStream;
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f6758c.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String strA = h.a(str);
        this.f6758c.put(str, strA);
        return strA;
    }
}
