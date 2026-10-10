package com.squareup.picasso;

/* JADX INFO: compiled from: UrlConnectionDownloader.java */
/* JADX INFO: loaded from: classes5.dex */
class M extends ThreadLocal<StringBuilder> {
    M() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public StringBuilder initialValue() {
        return new StringBuilder();
    }
}
