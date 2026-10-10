package io.rong.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri) throws Exception;
}
