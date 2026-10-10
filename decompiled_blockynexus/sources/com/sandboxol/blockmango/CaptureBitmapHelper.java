package com.sandboxol.blockmango;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.sandboxol.blocky.router.RealmsController;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.common.utils.BitmapWaterMark;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.game.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureBitmapHelper {

    static class CaptureEntity {
        String gameId;
        String picResUrlOrPath;
        Bitmap screenShot;
        Uri shareUri;

        CaptureEntity() {
        }

        public String getGameId() {
            return this.gameId;
        }

        public String getPicResUrlOrPath() {
            return this.picResUrlOrPath;
        }

        public Bitmap getScreenShot() {
            return this.screenShot;
        }

        public Uri getShareUri() {
            return this.shareUri;
        }

        public void setGameId(String str) {
            this.gameId = str;
        }

        public void setPicResUrlOrPath(String str) {
            this.picResUrlOrPath = str;
        }

        public void setScreenShot(Bitmap bitmap) {
            this.screenShot = bitmap;
        }

        public void setShareUri(Uri uri) {
            this.shareUri = uri;
        }
    }

    static /* synthetic */ void a(Context context, Bitmap bitmap, final Subscriber subscriber) {
        Bitmap bitmapDecodeResource;
        synchronized (CaptureBitmapHelper.class) {
            String gameId = "";
            try {
                gameId = RealmsController.getMe().getEnterRealmsResult().getGame().getGameId();
            } catch (Exception unused) {
            }
            final CaptureEntity captureEntity = new CaptureEntity();
            if ("g1008".equals(gameId) || "g1061".equals(gameId) || "g1062".equals(gameId) || "".equals(gameId)) {
                bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.water_mark_bed_war);
                captureEntity.screenShot = BitmapWaterMark.addWaterMaskImage(bitmap, bitmapDecodeResource);
            } else {
                bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.water_mark_bgo);
                captureEntity.screenShot = BitmapWaterMark.addWaterMaskImage(bitmap, bitmapDecodeResource);
            }
            captureEntity.gameId = gameId;
            getUriFromBitmap(context, captureEntity.screenShot, new OnBaseResponseListener<Uri>() { // from class: com.sandboxol.blockmango.CaptureBitmapHelper.2
                @Override // com.sandboxol.center.router.base.OnBaseResponseListener
                public void onError(int i, String str) {
                    subscriber.onCompleted();
                }

                @Override // com.sandboxol.center.router.base.OnBaseResponseListener
                public void onSuccess(Uri uri) {
                    captureEntity.setShareUri(uri);
                    subscriber.onNext(captureEntity);
                    subscriber.onCompleted();
                }
            });
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (bitmapDecodeResource != null && !bitmapDecodeResource.isRecycled()) {
                bitmapDecodeResource.recycle();
            }
        }
    }

    static /* synthetic */ void b(Context context, Bitmap bitmap, Subscriber subscriber) {
        try {
            subscriber.onNext(Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, (String) null, (String) null)));
        } catch (Exception e2) {
            ToastUtils.showLongToast(context, R.string.screen_dialog_failed);
            subscriber.onError(e2);
        }
        subscriber.onCompleted();
    }

    public static void captureBitmap(final Context context, final Bitmap bitmap, final String str, final Action0 action0) {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.blockmango.C
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                CaptureBitmapHelper.a(context, bitmap, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CaptureEntity>() { // from class: com.sandboxol.blockmango.CaptureBitmapHelper.1
            @Override // rx.Observer
            public void onCompleted() {
                Action0 action02 = action0;
                if (action02 != null) {
                    action02.call();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
            }

            @Override // rx.Observer
            public void onNext(CaptureEntity captureEntity) {
                if ("g1008".equals(captureEntity.gameId) || "g1061".equals(captureEntity.gameId) || "g1062".equals(captureEntity.gameId) || "".equals(captureEntity.gameId)) {
                    new BedWarScreenshotShareDialog(context, captureEntity.screenShot, !TextUtils.isEmpty(str) ? 1 : 0, captureEntity.getShareUri()).show();
                } else {
                    new ScreenshotShareDialog(context, captureEntity.screenShot, !TextUtils.isEmpty(str) ? 1 : 0, captureEntity.getShareUri()).show();
                }
            }
        });
    }

    public static void getUriFromBitmap(final Context context, final Bitmap bitmap, final OnBaseResponseListener<Uri> onBaseResponseListener) {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.blockmango.D
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                CaptureBitmapHelper.b(context, bitmap, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Uri>() { // from class: com.sandboxol.blockmango.CaptureBitmapHelper.3
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                onBaseResponseListener.onError(-1, "");
            }

            @Override // rx.Observer
            public void onNext(Uri uri) {
                OnBaseResponseListener onBaseResponseListener2 = onBaseResponseListener;
                if (onBaseResponseListener2 != null) {
                    onBaseResponseListener2.onSuccess(uri);
                }
            }
        });
    }
}
