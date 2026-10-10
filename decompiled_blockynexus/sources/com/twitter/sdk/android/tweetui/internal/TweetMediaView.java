package com.twitter.sdk.android.tweetui.internal;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.squareup.picasso.D;
import com.squareup.picasso.InterfaceC2757l;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.F;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.L;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import io.rong.imkit.utils.FileTypeUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TweetMediaView extends ViewGroup implements View.OnClickListener {
    static final int MAX_IMAGE_VIEW_COUNT = 4;
    static final String SIZED_IMAGE_SMALL = ":small";
    final a dependencyProvider;
    private int imageCount;
    private final OverlayImageView[] imageViews;
    boolean internalRoundedCornersEnabled;
    int mediaBgColor;
    private final int mediaDividerSize;
    private List<MediaEntity> mediaEntities;
    private final Path path;
    int photoErrorResId;
    final float[] radii;
    private final RectF rect;
    com.twitter.sdk.android.core.models.m tweet;
    F tweetMediaClickListener;

    static class a {
        a() {
        }

        Picasso a() {
            return L.c().b();
        }
    }

    static class b implements InterfaceC2757l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<ImageView> f20383a;

        b(ImageView imageView) {
            this.f20383a = new WeakReference<>(imageView);
        }

        @Override // com.squareup.picasso.InterfaceC2757l
        public void onError() {
        }

        @Override // com.squareup.picasso.InterfaceC2757l
        public void onSuccess() {
            ImageView imageView = this.f20383a.get();
            if (imageView != null) {
                imageView.setBackgroundResource(R.color.transparent);
            }
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f20384a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f20385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f20386c;

        private c() {
            this(0, 0);
        }

        static c a(int i, int i2) {
            int iMax = Math.max(i, 0);
            int iMax2 = Math.max(i2, 0);
            return (iMax == 0 && iMax2 == 0) ? f20384a : new c(iMax, iMax2);
        }

        private c(int i, int i2) {
            this.f20385b = i;
            this.f20386c = i2;
        }
    }

    public TweetMediaView(Context context) {
        this(context, null);
    }

    void clearImageViews() {
        for (int i = 0; i < this.imageCount; i++) {
            OverlayImageView overlayImageView = this.imageViews[i];
            if (overlayImageView != null) {
                overlayImageView.setVisibility(8);
            }
        }
        this.imageCount = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.internalRoundedCornersEnabled || Build.VERSION.SDK_INT < 18) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    OverlayImageView getOrCreateImageView(int i) {
        OverlayImageView overlayImageView = this.imageViews[i];
        if (overlayImageView == null) {
            overlayImageView = new OverlayImageView(getContext());
            overlayImageView.setLayoutParams(generateDefaultLayoutParams());
            overlayImageView.setOnClickListener(this);
            this.imageViews[i] = overlayImageView;
            addView(overlayImageView, i);
        } else {
            measureImageView(i, 0, 0);
            layoutImage(i, 0, 0, 0, 0);
        }
        overlayImageView.setVisibility(0);
        overlayImageView.setBackgroundColor(this.mediaBgColor);
        overlayImageView.setTag(com.twitter.sdk.android.tweetui.R.id.tw__entity_index, Integer.valueOf(i));
        return overlayImageView;
    }

    String getSizedImagePath(MediaEntity mediaEntity) {
        if (this.imageCount <= 1) {
            return mediaEntity.mediaUrlHttps;
        }
        return mediaEntity.mediaUrlHttps + SIZED_IMAGE_SMALL;
    }

    void initializeImageViews(List<MediaEntity> list) {
        this.imageCount = Math.min(4, list.size());
        for (int i = 0; i < this.imageCount; i++) {
            OverlayImageView orCreateImageView = getOrCreateImageView(i);
            MediaEntity mediaEntity = list.get(i);
            setAltText(orCreateImageView, mediaEntity.altText);
            setMediaImage(orCreateImageView, getSizedImagePath(mediaEntity));
            setOverlayImage(orCreateImageView, l.d(mediaEntity));
        }
    }

    public void launchPhotoGallery(int i) {
        Intent intent = new Intent(getContext(), (Class<?>) GalleryActivity.class);
        intent.putExtra("GALLERY_ITEM", new GalleryActivity.GalleryItem(this.tweet.i, i, this.mediaEntities));
        com.twitter.sdk.android.core.h.b(getContext(), intent);
    }

    public void launchVideoPlayer(MediaEntity mediaEntity) {
        if (l.a(mediaEntity) != null) {
            Intent intent = new Intent(getContext(), (Class<?>) PlayerActivity.class);
            intent.putExtra("PLAYER_ITEM", new PlayerActivity.PlayerItem(l.a(mediaEntity).url, l.b(mediaEntity), l.e(mediaEntity), null, null));
            com.twitter.sdk.android.core.h.b(getContext(), intent);
        }
    }

    void layoutImage(int i, int i2, int i3, int i4, int i5) {
        OverlayImageView overlayImageView = this.imageViews[i];
        if (overlayImageView.getLeft() == i2 && overlayImageView.getTop() == i3 && overlayImageView.getRight() == i4 && overlayImageView.getBottom() == i5) {
            return;
        }
        overlayImageView.layout(i2, i3, i4, i5);
    }

    void layoutImages() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = this.mediaDividerSize;
        int i2 = (measuredWidth - i) / 2;
        int i3 = (measuredHeight - i) / 2;
        int i4 = i2 + i;
        int i5 = this.imageCount;
        if (i5 == 1) {
            layoutImage(0, 0, 0, measuredWidth, measuredHeight);
            return;
        }
        if (i5 == 2) {
            layoutImage(0, 0, 0, i2, measuredHeight);
            layoutImage(1, i2 + this.mediaDividerSize, 0, measuredWidth, measuredHeight);
            return;
        }
        if (i5 == 3) {
            layoutImage(0, 0, 0, i2, measuredHeight);
            layoutImage(1, i4, 0, measuredWidth, i3);
            layoutImage(2, i4, i3 + this.mediaDividerSize, measuredWidth, measuredHeight);
        } else {
            if (i5 != 4) {
                return;
            }
            layoutImage(0, 0, 0, i2, i3);
            layoutImage(2, 0, i3 + this.mediaDividerSize, i2, measuredHeight);
            layoutImage(1, i4, 0, measuredWidth, i3);
            layoutImage(3, i4, i3 + this.mediaDividerSize, measuredWidth, measuredHeight);
        }
    }

    void measureImageView(int i, int i2, int i3) {
        this.imageViews[i].measure(View.MeasureSpec.makeMeasureSpec(i2, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(i3, FileTypeUtils.GIGABYTE));
    }

    c measureImages(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.mediaDividerSize;
        int i4 = (size - i3) / 2;
        int i5 = (size2 - i3) / 2;
        int i6 = this.imageCount;
        if (i6 == 1) {
            measureImageView(0, size, size2);
        } else if (i6 == 2) {
            measureImageView(0, i4, size2);
            measureImageView(1, i4, size2);
        } else if (i6 == 3) {
            measureImageView(0, i4, size2);
            measureImageView(1, i4, i5);
            measureImageView(2, i4, i5);
        } else if (i6 == 4) {
            measureImageView(0, i4, i5);
            measureImageView(1, i4, i5);
            measureImageView(2, i4, i5);
            measureImageView(3, i4, i5);
        }
        return c.a(size, size2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer num = (Integer) view.getTag(com.twitter.sdk.android.tweetui.R.id.tw__entity_index);
        if (this.tweetMediaClickListener != null) {
            this.tweetMediaClickListener.a(this.tweet, !this.mediaEntities.isEmpty() ? this.mediaEntities.get(num.intValue()) : null);
            return;
        }
        if (this.mediaEntities.isEmpty()) {
            launchVideoPlayer(this.tweet);
            return;
        }
        MediaEntity mediaEntity = this.mediaEntities.get(num.intValue());
        if (l.d(mediaEntity)) {
            launchVideoPlayer(mediaEntity);
        } else if (l.c(mediaEntity)) {
            launchPhotoGallery(num.intValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.imageCount > 0) {
            layoutImages();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        c cVarMeasureImages = this.imageCount > 0 ? measureImages(i, i2) : c.f20384a;
        setMeasuredDimension(cVarMeasureImages.f20385b, cVarMeasureImages.f20386c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.path.reset();
        this.rect.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, i, i2);
        this.path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
        this.path.close();
    }

    void setAltText(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            imageView.setContentDescription(getResources().getString(com.twitter.sdk.android.tweetui.R.string.tw__tweet_media));
        } else {
            imageView.setContentDescription(str);
        }
    }

    public void setMediaBgColor(int i) {
        this.mediaBgColor = i;
    }

    void setMediaImage(ImageView imageView, String str) {
        Picasso picassoA = this.dependencyProvider.a();
        if (picassoA == null) {
            return;
        }
        D dA = picassoA.a(str);
        dA.b();
        dA.a();
        dA.a(this.photoErrorResId);
        dA.a(imageView, new b(imageView));
    }

    void setOverlayImage(OverlayImageView overlayImageView, boolean z) {
        if (z) {
            overlayImageView.setOverlayDrawable(getContext().getResources().getDrawable(com.twitter.sdk.android.tweetui.R.drawable.tw__player_overlay));
        } else {
            overlayImageView.setOverlayDrawable(null);
        }
    }

    public void setPhotoErrorResId(int i) {
        this.photoErrorResId = i;
    }

    public void setRoundedCornersRadii(int i, int i2, int i3, int i4) {
        float[] fArr = this.radii;
        float f2 = i;
        fArr[0] = f2;
        fArr[1] = f2;
        float f3 = i2;
        fArr[2] = f3;
        fArr[3] = f3;
        float f4 = i3;
        fArr[4] = f4;
        fArr[5] = f4;
        float f5 = i4;
        fArr[6] = f5;
        fArr[7] = f5;
        requestLayout();
    }

    public void setTweetMediaClickListener(F f2) {
        this.tweetMediaClickListener = f2;
    }

    public void setTweetMediaEntities(com.twitter.sdk.android.core.models.m mVar, List<MediaEntity> list) {
        if (mVar == null || list == null || list.isEmpty() || list.equals(this.mediaEntities)) {
            return;
        }
        this.tweet = mVar;
        this.mediaEntities = list;
        clearImageViews();
        initializeImageViews(list);
        this.internalRoundedCornersEnabled = l.c(list.get(0));
        requestLayout();
    }

    public void setVineCard(com.twitter.sdk.android.core.models.m mVar) {
        com.twitter.sdk.android.core.models.d dVar;
        if (mVar == null || (dVar = mVar.H) == null || !com.twitter.sdk.android.core.internal.p.c(dVar)) {
            return;
        }
        this.tweet = mVar;
        this.mediaEntities = Collections.emptyList();
        clearImageViews();
        initializeImageViews(mVar.H);
        this.internalRoundedCornersEnabled = false;
        requestLayout();
    }

    public TweetMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new a());
    }

    TweetMediaView(Context context, AttributeSet attributeSet, a aVar) {
        super(context, attributeSet);
        this.imageViews = new OverlayImageView[4];
        this.mediaEntities = Collections.emptyList();
        this.path = new Path();
        this.rect = new RectF();
        this.radii = new float[8];
        this.mediaBgColor = -16777216;
        this.dependencyProvider = aVar;
        this.mediaDividerSize = getResources().getDimensionPixelSize(com.twitter.sdk.android.tweetui.R.dimen.tw__media_view_divider_size);
        this.photoErrorResId = com.twitter.sdk.android.tweetui.R.drawable.tw__ic_tweet_photo_error_dark;
    }

    void initializeImageViews(com.twitter.sdk.android.core.models.d dVar) {
        this.imageCount = 1;
        OverlayImageView orCreateImageView = getOrCreateImageView(0);
        com.twitter.sdk.android.core.models.g gVarA = com.twitter.sdk.android.core.internal.p.a(dVar);
        setAltText(orCreateImageView, gVarA.f20230d);
        setMediaImage(orCreateImageView, gVarA.f20229c);
        setOverlayImage(orCreateImageView, true);
    }

    public void launchVideoPlayer(com.twitter.sdk.android.core.models.m mVar) {
        com.twitter.sdk.android.core.models.d dVar = mVar.H;
        Intent intent = new Intent(getContext(), (Class<?>) PlayerActivity.class);
        intent.putExtra("PLAYER_ITEM", new PlayerActivity.PlayerItem(com.twitter.sdk.android.core.internal.p.b(dVar), true, false, null, null));
        com.twitter.sdk.android.core.h.b(getContext(), intent);
    }
}
