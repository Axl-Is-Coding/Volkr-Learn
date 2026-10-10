package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;

/* JADX INFO: compiled from: ResourceRequestHandler.java */
/* JADX INFO: loaded from: classes5.dex */
class F extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f19235a;

    F(Context context) {
        this.f19235a = context;
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        if (c2.f19214f != 0) {
            return true;
        }
        return "android.resource".equals(c2.f19213e.getScheme());
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        Resources resourcesA = P.a(this.f19235a, c2);
        return new E.a(a(resourcesA, P.a(resourcesA, c2), c2), Picasso.LoadedFrom.DISK);
    }

    private static Bitmap a(Resources resources, int i, C c2) {
        BitmapFactory.Options optionsB = E.b(c2);
        if (E.a(optionsB)) {
            BitmapFactory.decodeResource(resources, i, optionsB);
            E.a(c2.i, c2.j, optionsB, c2);
        }
        return BitmapFactory.decodeResource(resources, i, optionsB);
    }
}
