package com.google.android.material.i;

import android.graphics.Typeface;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f13422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0129a f13423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13424c;

    /* JADX INFO: renamed from: com.google.android.material.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0129a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0129a interfaceC0129a, Typeface typeface) {
        this.f13422a = typeface;
        this.f13423b = interfaceC0129a;
    }

    @Override // com.google.android.material.i.h
    public void a(Typeface typeface, boolean z) {
        a(typeface);
    }

    @Override // com.google.android.material.i.h
    public void a(int i) {
        a(this.f13422a);
    }

    public void a() {
        this.f13424c = true;
    }

    private void a(Typeface typeface) {
        if (this.f13424c) {
            return;
        }
        this.f13423b.a(typeface);
    }
}
