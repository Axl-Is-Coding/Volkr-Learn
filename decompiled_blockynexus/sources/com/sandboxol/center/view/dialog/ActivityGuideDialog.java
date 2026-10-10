package com.sandboxol.center.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.databinding.BaseDialogActivityGuideBinding;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.videosubmit.constant.VideoSubmitEventConstant;
import com.sandboxol.videosubmit.constant.VideoSubmitStringConstant;
import java.io.File;
import java.util.concurrent.TimeUnit;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityGuideDialog extends FullScreenDialog {
    public ObservableField<Drawable> backgroundDrawable;
    public ObservableField<String> backgroundUrl;
    private BaseDialogActivityGuideBinding binding;
    private String gotoUrl;
    private boolean isGotoLinkDialog;
    private Listener listener;
    public ReplyCommand onBackgroundUrlGetCommand;
    public ReplyCommand onDismiss;
    public ReplyCommand onSignNowCommand;

    public interface Listener {
        void callBack();
    }

    public ActivityGuideDialog(Context context, Listener listener) {
        super(context);
        this.backgroundUrl = new ObservableField<>("");
        this.backgroundDrawable = new ObservableField<>();
        this.onSignNowCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f16373a.onSignNow();
            }
        });
        this.onBackgroundUrlGetCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f16366a.onBackgroundUrlGet();
            }
        });
        this.onDismiss = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f16379a.dismiss();
            }
        });
        this.listener = listener;
        initView();
    }

    private void initView() {
        this.binding = (BaseDialogActivityGuideBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.base_dialog_activity_guide, (ViewGroup) null, false);
        this.binding.setViewModel(this);
        setContentView(this.binding.getRoot());
    }

    private boolean isTouchPointInView(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    private static boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) && !activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackgroundUrlGet() {
        if (isValidContextForGlide(this.context)) {
            final String strA = zlc.season.rxdownload4.download.utils.b.a(this.backgroundUrl.get());
            final String apkOrSoDownloadPath = CommonHelper.getApkOrSoDownloadPath(this.context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            File file = new File(apkOrSoDownloadPath, strA);
            if (file.exists()) {
                show();
                this.binding.iv.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
                return;
            }
            DownloadInfo savePath = new DownloadInfo().setUrl(this.backgroundUrl.get()).setSaveName(strA).setSavePath(apkOrSoDownloadPath);
            com.sandboxol.file.b.a aVar = new com.sandboxol.file.b.a();
            aVar.a(savePath);
            aVar.a(1);
            aVar.a(new com.sandboxol.file.d.c() { // from class: com.sandboxol.center.view.dialog.ActivityGuideDialog.1
                @Override // com.sandboxol.file.d.c
                public void onComplete(Progress progress) {
                    ActivityGuideDialog.this.show();
                    File file2 = new File(apkOrSoDownloadPath, strA);
                    if (file2.exists()) {
                        ActivityGuideDialog.this.binding.iv.setImageBitmap(BitmapFactory.decodeFile(file2.getPath()));
                    }
                }

                @Override // com.sandboxol.file.d.c
                public void onError(Throwable th) {
                    ActivityGuideDialog.this.show();
                }

                @Override // com.sandboxol.file.d.c
                public /* synthetic */ void onNext(Progress progress) {
                    com.sandboxol.file.d.b.b(this, progress);
                }

                @Override // com.sandboxol.file.d.c
                public /* synthetic */ void onSubscribe(Throwable th) {
                    com.sandboxol.file.d.b.a(this, th);
                }
            });
            new com.sandboxol.file.c.d(aVar).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSignNow() {
        try {
            dismiss();
            if (TextUtils.isEmpty(this.gotoUrl)) {
                ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLINCK_BGTUBE_LEARNMORE);
                final Intent intent = new Intent(BaseApplication.getApp().getPackageName() + ".videosubmit");
                intent.putExtra(VideoSubmitStringConstant.IS_SHOW_VIDEO_SUBMIT_LINK_DIALOG, this.isGotoLinkDialog);
                io.reactivex.p.just(true).delay(500L, TimeUnit.MILLISECONDS).subscribe(new io.reactivex.b.g() { // from class: com.sandboxol.center.view.dialog.b
                    @Override // io.reactivex.b.g
                    public final void accept(Object obj) throws Exception {
                        this.f16371a.a(intent, (Boolean) obj);
                    }
                });
            } else if (Helper.hasBrowserCount(this.context)) {
                this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.gotoUrl)));
            } else {
                AppToastUtils.showShortNegativeTipToast(this.context, R.string.base_no_browser);
            }
        } catch (Exception unused) {
            AppToastUtils.showShortNegativeTipToast(this.context, "empty");
        }
    }

    public /* synthetic */ void a(Intent intent, Boolean bool) throws Exception {
        this.context.startActivity(intent);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Listener listener = this.listener;
        if (listener != null) {
            listener.callBack();
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (!isTouchPointInView(this.binding.v, rawX, rawY)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (isTouchPointInView(this.binding.btnSignUp, rawX, rawY) || isTouchPointInView(this.binding.ivClose, rawX, rawY)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public ActivityGuideDialog setBackgroundUrl(String str) {
        this.backgroundUrl.set(str);
        onBackgroundUrlGet();
        return this;
    }

    public ActivityGuideDialog setButtonText(String str) {
        this.binding.btnSignUp.setText(str);
        return this;
    }

    public ActivityGuideDialog setGotoLinkDialog(boolean z) {
        this.isGotoLinkDialog = z;
        return this;
    }

    public ActivityGuideDialog setGotoUrl(String str) {
        this.gotoUrl = str;
        return this;
    }

    public ActivityGuideDialog setButtonText(int i) {
        this.binding.btnSignUp.setText(i);
        return this;
    }
}
