package com.sandboxol.common.utils;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.e;
import com.sandboxol.common.entity.S3Image;
import com.sandboxol.common.utils.S3ImageImageLoader;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class S3Module extends com.bumptech.glide.b.a {
    @Override // com.bumptech.glide.b.a
    public void applyOptions(Context context, e eVar) {
    }

    @Override // com.bumptech.glide.b.d
    public void registerComponents(Context context, c cVar, Registry registry) {
        registry.a(S3Image.class, InputStream.class, new S3ImageImageLoader.Factory());
    }
}
