package io.rong.imkit.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.RLog;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.assist.FailReason;
import io.rong.imageloader.core.assist.ImageSize;
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.display.CircleBitmapDisplayer;
import io.rong.imageloader.core.display.RoundedBitmapDisplayer;
import io.rong.imageloader.core.display.SimpleBitmapDisplayer;
import io.rong.imageloader.core.imageaware.ImageViewAware;
import io.rong.imageloader.core.listener.ImageLoadingListener;
import io.rong.imageloader.core.listener.ImageLoadingProgressListener;
import io.rong.imageloader.core.process.BitmapProcessor;
import io.rong.imkit.R;
import io.rong.imkit.utilities.RongUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncImageView extends ImageView {
    private static final int AVATAR_SIZE = 80;
    private static final String TAG = "AsyncImageView";
    private boolean isCircle;
    private int mCornerRadius;
    private Drawable mDefaultDrawable;
    private boolean mHasMask;
    private int mMinSize;
    private WeakReference<Bitmap> mShardWeakBitmap;
    private WeakReference<Bitmap> mWeakBitmap;
    private int minShortSideSize;

    public AsyncImageView(Context context) {
        super(context);
        this.minShortSideSize = 0;
        this.mMinSize = 0;
        this.mCornerRadius = 0;
    }

    private DisplayImageOptions createDisplayImageOptions(int i, boolean z) {
        return createDisplayImageOptions(i, z, null);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private Bitmap getBitmap(Uri uri) {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        try {
            return BitmapFactory.decodeFile(uri.getPath(), new BitmapFactory.Options());
        } catch (Exception e2) {
            RLog.e(TAG, "getBitmap Exception : " + uri);
            RLog.e(TAG, "getBitmap", e2);
            return null;
        }
    }

    private void getShardImage(Drawable drawable, Bitmap bitmap, Canvas canvas) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        WeakReference<Bitmap> weakReference = this.mShardWeakBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
            canvas.drawBitmap(bitmapCreateBitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
            return;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            RLog.e(TAG, "getShardImage OutOfMemoryError");
            RLog.e(TAG, "getShardImage", e2);
            System.gc();
        }
        if (bitmapCreateBitmap != null) {
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, width, height);
            Rect rect2 = new Rect(0, 0, width, height);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(rect2);
            bitmapDrawable.draw(canvas2);
            if (drawable instanceof NinePatchDrawable) {
                NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
                ninePatchDrawable.setBounds(rect);
                ninePatchDrawable.getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
                ninePatchDrawable.draw(canvas2);
            }
            this.mShardWeakBitmap = new WeakReference<>(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapCreateBitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, paint);
        }
    }

    private void measureLayoutParams(View view, Bitmap bitmap) {
        float f2;
        float f3;
        float f4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.mMinSize;
        int iMin = this.minShortSideSize;
        if (iMin > 0) {
            if (width < i || height < i) {
                if (width < height) {
                    int iMin2 = Math.min((int) (((i * 1.0f) / width) * height), iMin);
                    iMin = i;
                    i = iMin2;
                } else {
                    iMin = Math.min((int) (((i * 1.0f) / height) * width), iMin);
                }
            } else if (width >= iMin || height >= iMin) {
                if (width > height) {
                    float f5 = width;
                    f3 = height;
                    if ((f5 * 1.0f) / f3 <= 2.4d) {
                        f4 = (iMin * 1.0f) / f5;
                        i = (int) (f4 * f3);
                    }
                } else {
                    float f6 = height;
                    float f7 = width;
                    if ((f6 * 1.0f) / f7 <= 2.4d) {
                        f2 = ((iMin * 1.0f) / f6) * f7;
                        i = (int) f2;
                    }
                    iMin = i;
                    i = iMin;
                }
            } else if (width > height) {
                f4 = (iMin * 1.0f) / width;
                f3 = height;
                i = (int) (f4 * f3);
            } else {
                f2 = ((iMin * 1.0f) / height) * width;
                i = (int) f2;
                iMin = i;
                i = iMin;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            layoutParams.width = iMin;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutParam(Bitmap bitmap) {
        measureLayoutParams(this, bitmap);
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.view.View
    public void invalidate() {
        WeakReference<Bitmap> weakReference = this.mWeakBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            this.mWeakBitmap = null;
        }
        WeakReference<Bitmap> weakReference2 = this.mShardWeakBitmap;
        if (weakReference2 != null) {
            Bitmap bitmap2 = weakReference2.get();
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.mShardWeakBitmap = null;
        }
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        WeakReference<Bitmap> weakReference = this.mWeakBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            this.mWeakBitmap = null;
        }
        WeakReference<Bitmap> weakReference2 = this.mShardWeakBitmap;
        if (weakReference2 != null) {
            Bitmap bitmap2 = weakReference2.get();
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.mShardWeakBitmap = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mHasMask) {
            super.onDraw(canvas);
            return;
        }
        WeakReference<Bitmap> weakReference = this.mWeakBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        Drawable drawable = getDrawable();
        Drawable backgroundDrawable = ((RCMessageFrameLayout) getParent()).getBackgroundDrawable();
        if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
            canvas.drawBitmap(bitmapCreateBitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
            getShardImage(backgroundDrawable, bitmapCreateBitmap, canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            RLog.e(TAG, "onDraw OutOfMemoryError");
            RLog.e(TAG, "onDraw", e2);
            System.gc();
        }
        if (bitmapCreateBitmap != null) {
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            if (drawable != null) {
                drawable.setBounds(0, 0, width, height);
                drawable.draw(canvas2);
                if (backgroundDrawable instanceof NinePatchDrawable) {
                    NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) backgroundDrawable;
                    ninePatchDrawable.setBounds(0, 0, width, height);
                    ninePatchDrawable.getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    ninePatchDrawable.draw(canvas2);
                }
                this.mWeakBitmap = new WeakReference<>(bitmapCreateBitmap);
            }
            canvas.drawBitmap(bitmapCreateBitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
            getShardImage(backgroundDrawable, bitmapCreateBitmap, canvas);
        }
    }

    public void setAvatar(String str, int i) {
        ImageViewAware imageViewAware = new ImageViewAware(this);
        ImageSize imageSize = new ImageSize(80, 80);
        ImageLoader.getInstance().displayImage(str, imageViewAware, createDisplayImageOptions(i, true), imageSize, null, null);
    }

    public void setBitmap(Bitmap bitmap) {
        setLayoutParam(bitmap);
        setImageBitmap(bitmap);
    }

    public void setCircle(boolean z) {
        this.isCircle = z;
    }

    public void setCornerRadius(int i) {
        this.mCornerRadius = i;
    }

    public void setDefaultDrawable() {
        if (this.mDefaultDrawable != null) {
            DisplayImageOptions displayImageOptionsCreateDisplayImageOptions = createDisplayImageOptions(0, false);
            displayImageOptionsCreateDisplayImageOptions.getDisplayer().display(drawableToBitmap(this.mDefaultDrawable), new ImageViewAware(this), LoadedFrom.DISC_CACHE);
        }
    }

    public void setLocationResource(Uri uri, int i, final int i2, final int i3, final IImageLoadingListener iImageLoadingListener) {
        ImageLoader.getInstance().displayImage(uri == null ? null : uri.toString(), this, new DisplayImageOptions.Builder().resetViewBeforeLoading(false).cacheInMemory(false).cacheOnDisk(true).bitmapConfig(Bitmap.Config.ARGB_8888).showImageOnLoading(i).preProcessor(new BitmapProcessor() { // from class: io.rong.imkit.widget.AsyncImageView.2
            @Override // io.rong.imageloader.core.process.BitmapProcessor
            public Bitmap process(Bitmap bitmap) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i4 = i2;
                int i5 = (width - i4) / 2;
                int i6 = i3;
                int i7 = (height - i6) / 2;
                if (i5 <= 0 || i7 <= 0) {
                    return bitmap;
                }
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i5, i7, i4, i6);
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return bitmapCreateBitmap;
                } catch (OutOfMemoryError unused) {
                    return null;
                }
            }
        }).build(), new ImageLoadingListener() { // from class: io.rong.imkit.widget.AsyncImageView.3
            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingCancelled(String str, View view) {
                iImageLoadingListener.onLoadingFail();
            }

            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                File file = ImageLoader.getInstance().getDiskCache().get(str);
                if (file == null || !file.exists()) {
                    iImageLoadingListener.onLoadingFail();
                } else {
                    iImageLoadingListener.onLoadingComplete(Uri.fromFile(file));
                }
            }

            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                iImageLoadingListener.onLoadingFail();
            }

            @Override // io.rong.imageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        });
    }

    public void setResource(Uri uri) {
        DisplayImageOptions displayImageOptionsCreateDisplayImageOptions = createDisplayImageOptions(0, true);
        if (uri != null) {
            if (!new File(uri.getPath()).exists()) {
                if (this.minShortSideSize > 0) {
                    ImageLoader.getInstance().loadImage(uri.toString(), displayImageOptionsCreateDisplayImageOptions, new ImageLoadingListener() { // from class: io.rong.imkit.widget.AsyncImageView.1
                        @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                        public void onLoadingCancelled(String str, View view) {
                        }

                        @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                            if (bitmap != null) {
                                AsyncImageView.this.setLayoutParam(bitmap);
                                AsyncImageView.this.setImageBitmap(bitmap);
                            }
                        }

                        @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                        public void onLoadingFailed(String str, View view, FailReason failReason) {
                        }

                        @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                        public void onLoadingStarted(String str, View view) {
                        }
                    });
                    return;
                } else {
                    ImageLoader.getInstance().displayImage(uri.toString(), new ImageViewAware(this), displayImageOptionsCreateDisplayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
                    return;
                }
            }
            Bitmap bitmap = getBitmap(uri);
            if (bitmap != null) {
                setLayoutParam(bitmap);
                setImageBitmap(bitmap);
                return;
            }
            setImageBitmap(null);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = RongUtils.dip2px(80.0f);
            layoutParams.width = RongUtils.dip2px(110.0f);
            setLayoutParams(layoutParams);
        }
    }

    private DisplayImageOptions createDisplayImageOptions(int i, boolean z, Object obj) {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        Drawable drawable = this.mDefaultDrawable;
        if (i > 0) {
            try {
                drawable = getContext().getResources().getDrawable(i);
            } catch (Resources.NotFoundException e2) {
                e2.printStackTrace();
            }
        }
        if (drawable != null) {
            builder.showImageOnLoading(drawable);
            builder.showImageForEmptyUri(drawable);
            builder.showImageOnFail(drawable);
        }
        if (obj != null) {
            builder.extraForDownloader(obj);
        }
        if (this.isCircle) {
            builder.displayer(new CircleBitmapDisplayer());
        } else {
            int i2 = this.mCornerRadius;
            if (i2 > 0) {
                builder.displayer(new RoundedBitmapDisplayer(i2));
            } else {
                builder.displayer(new SimpleBitmapDisplayer());
            }
        }
        return builder.resetViewBeforeLoading(false).cacheInMemory(z).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    public void setLayoutParam(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.minShortSideSize = 0;
        this.mMinSize = 0;
        this.mCornerRadius = 0;
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AsyncImageView);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AsyncImageView_RCDefDrawable, 0);
        this.isCircle = typedArrayObtainStyledAttributes.getInt(R.styleable.AsyncImageView_RCShape, 0) == 1;
        this.minShortSideSize = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.AsyncImageView_RCMinShortSideSize, WheelView.DividerConfig.FILL);
        this.mMinSize = (int) TypedValue.complexToDimension(50, getResources().getDisplayMetrics());
        this.mCornerRadius = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.AsyncImageView_RCCornerRadius, WheelView.DividerConfig.FILL);
        this.mHasMask = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AsyncImageView_RCMask, false);
        if (resourceId != 0) {
            this.mDefaultDrawable = getResources().getDrawable(resourceId);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (this.mDefaultDrawable != null) {
            DisplayImageOptions displayImageOptionsCreateDisplayImageOptions = createDisplayImageOptions(resourceId, false);
            displayImageOptionsCreateDisplayImageOptions.getDisplayer().display(drawableToBitmap(displayImageOptionsCreateDisplayImageOptions.getImageForEmptyUri(null)), new ImageViewAware(this), LoadedFrom.DISC_CACHE);
        }
    }

    public void setAvatar(String str, String str2, int i) {
        ImageViewAware imageViewAware = new ImageViewAware(this);
        ImageSize imageSize = new ImageSize(80, 80);
        DisplayImageOptions displayImageOptionsCreateDisplayImageOptions = createDisplayImageOptions(i, true, new String[]{str2, str});
        String strEncode = !TextUtils.isEmpty(str2) ? URLEncoder.encode(str2) : "";
        ImageLoader.getInstance().displayImage("avatar://" + str + strEncode, imageViewAware, displayImageOptionsCreateDisplayImageOptions, imageSize, null, null);
    }

    public void setAvatar(Uri uri) {
        if (uri != null) {
            ImageViewAware imageViewAware = new ImageViewAware(this);
            ImageSize imageSize = new ImageSize(80, 80);
            ImageLoader.getInstance().displayImage(uri.toString(), imageViewAware, createDisplayImageOptions(0, true), imageSize, null, null);
        }
    }

    public void setResource(String str, int i) {
        if (str != null || i > 0) {
            ImageLoader.getInstance().displayImage(str, this, createDisplayImageOptions(i, true));
        }
    }
}
