package io.rong.imageloader.cache.disc;

import android.graphics.Bitmap;
import io.rong.imageloader.utils.IoUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface DiskCache {
    void clear();

    void close();

    File get(String str);

    File getDirectory();

    boolean remove(String str);

    boolean save(String str, Bitmap bitmap) throws IOException;

    boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) throws IOException;
}
