package com.sandboxol.blockmango;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.common.utils.luban.CompressionPredicate;
import com.sandboxol.common.utils.luban.Luban;
import com.sandboxol.common.utils.luban.OnCompressListener;
import com.sandboxol.common.utils.luban.OnRenameListener;
import com.sandboxol.game.R;
import com.sandboxol.messager.MessagerClient;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseShareDialog<DV extends ViewDataBinding> extends HideNavigationBarDialog {
    public static final int MODE_SCREEN = 0;
    public static final int MODE_SHOW = 1;
    private String SHARE_SAVE_CLICK;
    private String SHARE_SAVE_FAILED;
    private String SHARE_SAVE_SUCCESS;
    private DV binding;
    private Bitmap bmp;
    private boolean isClickSave;
    public ObservableField<Boolean> isNeedShowSaveBtn;
    public ObservableField<Boolean> isShowWrite;
    private Uri mShareUri;
    private int mode;
    private ThreadPoolExecutor poolExecutor;
    private BlockingDeque<Runnable> queue;

    /* JADX INFO: loaded from: classes.dex */
    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public BaseShareDialog(Context context, Bitmap bitmap, int i, Uri uri) {
        super(context);
        this.SHARE_SAVE_CLICK = "share_save_click";
        this.SHARE_SAVE_SUCCESS = "share_save_success";
        this.SHARE_SAVE_FAILED = "share_save_failed";
        this.queue = new LinkedBlockingDeque(1);
        this.poolExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, this.queue);
        this.isNeedShowSaveBtn = new ObservableField<>(false);
        this.isShowWrite = new ObservableField<>(false);
        this.bmp = bitmap;
        this.mode = i;
        this.mShareUri = uri;
        this.isClickSave = false;
        this.isNeedShowSaveBtn.set(Boolean.valueOf(i == 0));
        initReceiver();
        initView();
        showScreenShot(getshowImage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoShareActivity(int i, Uri uri) {
        Intent intent = new Intent();
        intent.setAction("com.sandboxol.transparent.proxy");
        intent.addCategory("show.transparent.pid");
        intent.putExtra("shareUri", uri);
        intent.putExtra("shareClass", i);
        this.context.startActivity(intent);
    }

    private void initReceiver() {
        MessagerClient.getIns().registerMsg0(getClass(), GameBroadcastType.BROADCAST_DISMISS_SCREENSHOTSHAREDIALOG, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.blockmango.c
            @Override // com.sandboxol.messager.a.a
            public final void onCall() {
                this.f16169a.a();
            }
        });
    }

    private void initView() {
        c();
        this.binding = (DV) androidx.databinding.e.a(LayoutInflater.from(this.context), onBIndingLayout(), (ViewGroup) null, false);
        this.binding.setVariable(com.sandboxol.game.a.g, this);
        setContentView(this.binding.getRoot());
    }

    private void onThirdPartyShare(String str, final int i) {
        if (this.mode == 1) {
            onUrlBitmap2ShareUrl(str, new OnBaseResponseListener<Uri>() { // from class: com.sandboxol.blockmango.BaseShareDialog.1
                @Override // com.sandboxol.center.router.base.OnBaseResponseListener
                public void onError(int i2, String str2) {
                    BaseShareDialog.this.cancel();
                }

                @Override // com.sandboxol.center.router.base.OnBaseResponseListener
                public void onSuccess(Uri uri) {
                    BaseShareDialog.this.gotoShareActivity(i, uri);
                }
            });
        } else {
            gotoShareActivity(i, this.mShareUri);
        }
    }

    private void onUrlBitmap2ShareUrl(String str, OnBaseResponseListener<Uri> onBaseResponseListener) {
        Bitmap bitmapSaveText2Bitmap = saveText2Bitmap(this.bmp, str);
        if (bitmapSaveText2Bitmap != null) {
            CaptureBitmapHelper.getUriFromBitmap(this.context, bitmapSaveText2Bitmap, onBaseResponseListener);
        }
    }

    private Bitmap saveText2Bitmap(Bitmap bitmap, String str) {
        if (TextUtils.isEmpty(str) || bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return bitmap;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Canvas canvas = new Canvas(bitmapCopy);
        paint.setColor(Color.parseColor("#b3000000"));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(SizeUtil.px2dp(this.context, (bitmap.getHeight() * 0.0987775f) - 5.0f));
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        float width = (bitmap.getWidth() / 2) - (rect.width() / 2);
        float height = (bitmap.getHeight() * 0.85f) - rect.height();
        String string = this.context.getString(R.string.dialog_screen_shot_write_hint);
        Rect rect2 = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect2);
        float fAbs = Math.abs(rect2.right - rect2.left);
        float f2 = fAbs / 2.0f;
        float width2 = (bitmap.getWidth() / 2) - f2;
        float width3 = ((bitmap.getWidth() / 2) - f2) + fAbs;
        float fDp2px = width - SizeUtil.dp2px(this.context, 20.0f);
        float fDp2px2 = height - SizeUtil.dp2px(this.context, 4.0f);
        float fWidth = rect.width() + width + SizeUtil.dp2px(this.context, 20.0f);
        float fHeight = rect.height() + height + SizeUtil.dp2px(this.context, 4.0f);
        float fAbs2 = Math.abs(fWidth - fDp2px);
        if (fAbs2 >= fAbs) {
            canvas.drawRect(fDp2px, fDp2px2, fWidth, fHeight, paint);
        } else {
            canvas.drawRect(width2, fDp2px2, width3, fHeight, paint);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0.5f);
        paint.setColor(Color.parseColor("#ffffffff"));
        if (fAbs2 >= fAbs) {
            canvas.drawRect(fDp2px - 0.5f, fDp2px2 - 0.5f, fWidth + 0.5f, fHeight + 0.5f, paint);
        } else {
            canvas.drawRect(width2 - 0.5f, fDp2px2 - 0.5f, width3 + 0.5f, fHeight + 0.5f, paint);
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(str, width, height - rect.top, paint);
        return bitmapCopy;
    }

    private void showScreenShot(ImageView imageView) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bmp.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            com.bumptech.glide.c.c(this.context).mo57load(byteArrayOutputStream.toByteArray()).into(imageView);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a() {
        c();
    }

    public DV getBinding() {
        return this.binding;
    }

    abstract ImageView getshowImage();

    abstract int onBIndingLayout();

    protected void onClose() {
        if (isShowing()) {
            this.poolExecutor.shutdown();
            cancel();
        }
    }

    protected void onSave(String str) {
        ReportDataAdapter.onEvent(this.context, this.SHARE_SAVE_CLICK);
        if (this.isClickSave) {
            return;
        }
        this.isClickSave = true;
        final Bitmap bitmapSaveText2Bitmap = saveText2Bitmap(this.bmp, str);
        if (bitmapSaveText2Bitmap == null) {
            ReportDataAdapter.onEvent(this.context, this.SHARE_SAVE_FAILED);
        } else if ("mounted".equals(Environment.getExternalStorageState())) {
            this.poolExecutor.execute(new Runnable() { // from class: com.sandboxol.blockmango.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16163a.a(bitmapSaveText2Bitmap);
                }
            });
        } else {
            ReportDataAdapter.onEvent(this.context, this.SHARE_SAVE_FAILED);
            ToastUtils.showShortToast(this.context, com.sandboxol.common.R.string.no_sdcard);
        }
    }

    protected void onShareFaceBook(String str) {
        onThirdPartyShare(str, 0);
    }

    protected void onShareGoogle(String str) {
        onThirdPartyShare(str, 1);
    }

    protected void onShareTwitter(String str) {
        onThirdPartyShare(str, 2);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        MessagerClient.getIns().unRegisterMsg(getClass());
        Bitmap bitmap = this.bmp;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bmp.recycle();
            this.bmp = null;
        }
        this.bmp = null;
    }

    protected void onWrite(EditText editText) {
        CommonHelper.showSoftInputFromWindow((Activity) this.context, editText);
        this.isShowWrite.set(Boolean.valueOf(!r2.get().booleanValue()));
    }

    public /* synthetic */ void a(final Bitmap bitmap) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        CommonHelper.saveBitmap(this.context, bitmap, "BlockManGo_" + jCurrentTimeMillis, new CommonHelper.SaveCallback() { // from class: com.sandboxol.blockmango.f
            @Override // com.sandboxol.common.utils.CommonHelper.SaveCallback
            public final void onSucceed(String str) {
                this.f16183a.a(jCurrentTimeMillis, bitmap, str);
            }
        });
    }

    public /* synthetic */ void a(final long j, final Bitmap bitmap, String str) {
        Context context = this.context;
        if (context != null && !((Activity) context).isFinishing()) {
            File file = new File(Environment.getExternalStorageDirectory(), "DCIM/");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            Luban.with(this.context).load(str).ignoreBy(100).setRenameListener(new OnRenameListener() { // from class: com.sandboxol.blockmango.d
                @Override // com.sandboxol.common.utils.luban.OnRenameListener
                public final String rename(String str2) {
                    return BaseShareDialog.a(j, str2);
                }
            }).setTargetDir(file.getPath()).filter(new CompressionPredicate() { // from class: com.sandboxol.blockmango.e
                @Override // com.sandboxol.common.utils.luban.CompressionPredicate
                public final boolean apply(String str2) {
                    return BaseShareDialog.a(str2);
                }
            }).setCompressListener(new OnCompressListener() { // from class: com.sandboxol.blockmango.BaseShareDialog.2

                /* JADX INFO: renamed from: com.sandboxol.blockmango.BaseShareDialog$2$1, reason: invalid class name */
                class AnonymousClass1 extends OnBaseResponseListener<Uri> {
                    final /* synthetic */ File val$file;

                    AnonymousClass1(File file) {
                        this.val$file = file;
                    }

                    public /* synthetic */ void a(File file) {
                        if (EchoesGLSurfaceView.getInstance() != null) {
                            EchoesGLSurfaceView.getInstance().onGameActionTrigger(20, file.getPath());
                        }
                        ReportDataAdapter.onEvent(((FullScreenDialog) BaseShareDialog.this).context, BaseShareDialog.this.SHARE_SAVE_SUCCESS);
                        BaseShareDialog.this.onClose();
                    }

                    @Override // com.sandboxol.center.router.base.OnBaseResponseListener
                    public void onError(int i, String str) {
                        BaseShareDialog.this.onClose();
                    }

                    @Override // com.sandboxol.center.router.base.OnBaseResponseListener
                    public void onSuccess(Uri uri) {
                        if (((FullScreenDialog) BaseShareDialog.this).context == null || ((Activity) ((FullScreenDialog) BaseShareDialog.this).context).isFinishing()) {
                            BaseShareDialog.this.poolExecutor.shutdownNow();
                            return;
                        }
                        Activity activity = (Activity) ((FullScreenDialog) BaseShareDialog.this).context;
                        final File file = this.val$file;
                        activity.runOnUiThread(new Runnable() { // from class: com.sandboxol.blockmango.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f16155a.a(file);
                            }
                        });
                    }
                }

                @Override // com.sandboxol.common.utils.luban.OnCompressListener
                public void onError(Throwable th) {
                    th.printStackTrace();
                    ReportDataAdapter.onEvent(((FullScreenDialog) BaseShareDialog.this).context, BaseShareDialog.this.SHARE_SAVE_FAILED);
                }

                @Override // com.sandboxol.common.utils.luban.OnCompressListener
                public void onStart() {
                }

                @Override // com.sandboxol.common.utils.luban.OnCompressListener
                public void onSuccess(File file2) {
                    CaptureBitmapHelper.getUriFromBitmap(((FullScreenDialog) BaseShareDialog.this).context, bitmap, new AnonymousClass1(file2));
                }
            }).launch();
            return;
        }
        this.poolExecutor.shutdownNow();
    }

    static /* synthetic */ String a(long j, String str) {
        return "BlockManGo_" + j + ".png";
    }

    static /* synthetic */ boolean a(String str) {
        return !TextUtils.isEmpty(str);
    }
}
