package com.squareup.picasso;

import com.squareup.picasso.E;
import java.io.IOException;

/* JADX INFO: renamed from: com.squareup.picasso.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class C2749d extends E {
    C2749d() {
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        throw new IllegalStateException("Unrecognized type of request: " + c2);
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        return true;
    }
}
