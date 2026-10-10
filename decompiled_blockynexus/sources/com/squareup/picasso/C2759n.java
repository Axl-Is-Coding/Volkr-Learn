package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.squareup.picasso.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentStreamRequestHandler.java */
/* JADX INFO: loaded from: classes5.dex */
class C2759n extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f19297a;

    C2759n(Context context) {
        this.f19297a = context;
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        return "content".equals(c2.f19213e.getScheme());
    }

    InputStream c(C c2) throws FileNotFoundException {
        return this.f19297a.getContentResolver().openInputStream(c2.f19213e);
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        return new E.a(c(c2), Picasso.LoadedFrom.DISK);
    }
}
