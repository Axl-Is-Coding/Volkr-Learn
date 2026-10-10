package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.n;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: GifDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements n<GifDrawable> {
    @Override // com.bumptech.glide.load.n
    public EncodeStrategy a(l lVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(C<GifDrawable> c2, File file, l lVar) throws Throwable {
        try {
            com.bumptech.glide.e.a.a(c2.get().b(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
