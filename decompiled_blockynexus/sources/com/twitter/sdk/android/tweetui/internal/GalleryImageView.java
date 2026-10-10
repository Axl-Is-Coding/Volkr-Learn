package com.twitter.sdk.android.tweetui.internal;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.squareup.picasso.J;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

/* JADX INFO: loaded from: classes5.dex */
public class GalleryImageView extends FrameLayout implements J {
    final MultiTouchImageView imageView;
    final ProgressBar progressBar;

    public GalleryImageView(Context context) {
        this(context, new MultiTouchImageView(context), new ProgressBar(context));
    }

    @Override // com.squareup.picasso.J
    public void onBitmapFailed(Drawable drawable) {
    }

    @Override // com.squareup.picasso.J
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.imageView.setImageBitmap(bitmap);
        this.progressBar.setVisibility(8);
    }

    @Override // com.squareup.picasso.J
    public void onPrepareLoad(Drawable drawable) {
        this.imageView.setImageResource(R.color.transparent);
        this.progressBar.setVisibility(0);
    }

    public void setSwipeToDismissCallback(SwipeToDismissTouchListener.a aVar) {
        this.imageView.setOnTouchListener(SwipeToDismissTouchListener.a(this.imageView, aVar));
    }

    GalleryImageView(Context context, MultiTouchImageView multiTouchImageView, ProgressBar progressBar) {
        super(context);
        this.imageView = multiTouchImageView;
        this.progressBar = progressBar;
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(progressBar);
        multiTouchImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        addView(multiTouchImageView);
    }
}
