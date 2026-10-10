package com.sandboxol.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class ImageUtils {
    private static LruCache<Integer, Bitmap> bitmapLruCache = new LruCache<Integer, Bitmap>((((int) Runtime.getRuntime().maxMemory()) / 1024) / 8) { // from class: com.sandboxol.common.utils.ImageUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(Integer num, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    static /* synthetic */ void a(Context context, int i, Subscriber subscriber) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
        synchronized (ImageUtils.class) {
            bitmapLruCache.put(Integer.valueOf(i), bitmapDecodeStream);
        }
        subscriber.onNext(bitmapDecodeStream);
        subscriber.onCompleted();
    }

    public static void setBackgroundResource(final Context context, final ImageView imageView, final int i) {
        Bitmap bitmap;
        synchronized (ImageUtils.class) {
            bitmap = bitmapLruCache.get(Integer.valueOf(i));
        }
        if (bitmap == null) {
            Observable.unsafeCreate(new Observable.OnSubscribe() { // from class: com.sandboxol.common.utils.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ImageUtils.a(context, i, (Subscriber) obj);
                }
            }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bitmap>() { // from class: com.sandboxol.common.utils.ImageUtils.2
                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                }

                @Override // rx.Observer
                public void onNext(Bitmap bitmap2) {
                    imageView.setImageBitmap(bitmap2);
                }
            });
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }
}
