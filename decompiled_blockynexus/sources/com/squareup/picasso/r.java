package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import io.rong.common.LibStorageUtils;
import java.io.IOException;

/* JADX INFO: compiled from: FileRequestHandler.java */
/* JADX INFO: loaded from: classes5.dex */
class r extends C2759n {
    r(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.C2759n, com.squareup.picasso.E
    public boolean a(C c2) {
        return LibStorageUtils.FILE.equals(c2.f19213e.getScheme());
    }

    @Override // com.squareup.picasso.C2759n, com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        return new E.a(null, c(c2), Picasso.LoadedFrom.DISK, a(c2.f19213e));
    }

    static int a(Uri uri) throws IOException {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }
}
