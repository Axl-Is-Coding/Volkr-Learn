package me.iwf.photopicker.utils;

import android.content.Context;
import android.provider.MediaStore;
import com.umeng.analytics.pro.ay;

/* JADX INFO: compiled from: PhotoDirectoryLoader.java */
/* JADX INFO: loaded from: classes5.dex */
public class f extends androidx.loader.content.b {
    final String[] i;

    public f(Context context, boolean z) {
        super(context);
        this.i = new String[]{ay.f20688d, "_data", "bucket_id", "bucket_display_name", "date_added", "_size"};
        a(this.i);
        a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        b("date_added DESC");
        StringBuilder sb = new StringBuilder();
        sb.append("mime_type=? or mime_type=? or mime_type=? ");
        sb.append(z ? "or mime_type=?" : "");
        a(sb.toString());
        b(z ? new String[]{"image/jpeg", "image/png", "image/jpg", "image/gif"} : new String[]{"image/jpeg", "image/png", "image/jpg"});
    }
}
