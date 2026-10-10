package com.squareup.picasso;

import com.squareup.picasso.Picasso;

/* JADX INFO: compiled from: Picasso.java */
/* JADX INFO: loaded from: classes5.dex */
class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f19323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Picasso.b f19324b;

    x(Picasso.b bVar, Exception exc) {
        this.f19324b = bVar;
        this.f19323a = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException(this.f19323a);
    }
}
