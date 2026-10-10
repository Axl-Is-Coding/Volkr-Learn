package com.squareup.picasso;

/* JADX INFO: renamed from: com.squareup.picasso.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class C2748c extends ThreadLocal<StringBuilder> {
    C2748c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public StringBuilder initialValue() {
        return new StringBuilder("Picasso-");
    }
}
