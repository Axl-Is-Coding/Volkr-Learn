package com.sandboxol.decorate.widget;

import android.graphics.Bitmap;
import com.bumptech.glide.request.target.SimpleTarget;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressRadioGroup.java */
/* JADX INFO: loaded from: classes3.dex */
class j extends SimpleTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageRadioButton f17532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DressRadioGroup f17533b;

    j(DressRadioGroup dressRadioGroup, ImageRadioButton imageRadioButton) {
        this.f17533b = dressRadioGroup;
        this.f17532a = imageRadioButton;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.a.b<? super Bitmap> bVar) {
        ImageRadioButton imageRadioButton = this.f17532a;
        if (imageRadioButton != null) {
            imageRadioButton.setUrlBitmap(bitmap);
            this.f17532a.setBackgroundResource(R.drawable.ic_new_dress_selector);
        }
    }
}
