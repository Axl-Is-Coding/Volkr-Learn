package com.sandbox.login.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.bumptech.glide.request.target.CustomTarget;
import com.sandboxol.center.view.widget.RoundDrawable;

/* JADX INFO: compiled from: ResHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends CustomTarget<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f15754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Context f15755e;

    g(ObservableField observableField, Context context) {
        this.f15754d = observableField;
        this.f15755e = context;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.a.b<? super Bitmap> bVar) {
        this.f15754d.set(new RoundDrawable(this.f15755e, bitmap, 5, 5));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }
}
