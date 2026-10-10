package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.o;

/* JADX INFO: compiled from: DefaultImageCache.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected LruCache<String, Bitmap> f5371a = new LruCache<String, Bitmap>(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16) { // from class: com.bytedance.sdk.adnet.b.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };

    @Override // com.bytedance.sdk.adnet.b.d.b
    public Bitmap a(String str) {
        try {
            return this.f5371a.get(str);
        } catch (Throwable th) {
            o.a(th, "DefaultImageCache get bitmap error", new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.bytedance.sdk.adnet.b.d.b
    public void a(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        try {
            this.f5371a.put(str, bitmap);
        } catch (Throwable th) {
            o.a(th, "DefaultImageCache put bitmap error", new Object[0]);
        }
    }
}
