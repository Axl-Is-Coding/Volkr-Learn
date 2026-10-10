package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class MediaStoreRequestHandler extends C2759n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f19251b = {AdUnitActivity.EXTRA_ORIENTATION};

    enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);

        final int androidKind;
        final int height;
        final int width;

        PicassoKind(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }

    MediaStoreRequestHandler(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.C2759n, com.squareup.picasso.E
    public boolean a(C c2) {
        Uri uri = c2.f19213e;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // com.squareup.picasso.C2759n, com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.f19297a.getContentResolver();
        int iA = a(contentResolver, c2.f19213e);
        String type = contentResolver.getType(c2.f19213e);
        boolean z = type != null && type.startsWith("video/");
        if (c2.c()) {
            PicassoKind picassoKindA = a(c2.i, c2.j);
            if (!z && picassoKindA == PicassoKind.FULL) {
                return new E.a(null, c(c2), Picasso.LoadedFrom.DISK, iA);
            }
            long id = ContentUris.parseId(c2.f19213e);
            BitmapFactory.Options optionsB = E.b(c2);
            optionsB.inJustDecodeBounds = true;
            E.a(c2.i, c2.j, picassoKindA.width, picassoKindA.height, optionsB, c2);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, id, picassoKindA == PicassoKind.FULL ? 1 : picassoKindA.androidKind, optionsB);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, picassoKindA.androidKind, optionsB);
            }
            if (thumbnail != null) {
                return new E.a(thumbnail, null, Picasso.LoadedFrom.DISK, iA);
            }
        }
        return new E.a(null, c(c2), Picasso.LoadedFrom.DISK, iA);
    }

    static PicassoKind a(int i, int i2) {
        PicassoKind picassoKind = PicassoKind.MICRO;
        if (i <= picassoKind.width && i2 <= picassoKind.height) {
            return picassoKind;
        }
        PicassoKind picassoKind2 = PicassoKind.MINI;
        return (i > picassoKind2.width || i2 > picassoKind2.height) ? PicassoKind.FULL : picassoKind2;
    }

    static int a(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, f19251b, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(0);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return i;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
