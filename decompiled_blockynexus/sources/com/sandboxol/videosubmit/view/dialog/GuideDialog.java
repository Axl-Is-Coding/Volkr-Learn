package com.sandboxol.videosubmit.view.dialog;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.constant.VideoSubmitEventConstant;
import com.sandboxol.videosubmit.constant.VideoSubmitStringConstant;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogGuideBinding;
import io.reactivex.p;
import java.util.concurrent.TimeUnit;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class GuideDialog extends FullScreenDialog {
    public ObservableField<String> backgroundUrl;
    private VideosubmitDialogGuideBinding binding;
    private boolean isGotoLinkDialog;
    private Listener listener;
    public ReplyCommand onDismiss;
    public ReplyCommand onSignNowCommand;

    public interface Listener {
        void callBack();
    }

    public GuideDialog(Context context, Listener listener) {
        super(context);
        this.backgroundUrl = new ObservableField<>("");
        this.onSignNowCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18919a.onSignNow();
            }
        });
        this.onDismiss = new ReplyCommand(new Action0() { // from class: com.sandboxol.videosubmit.view.dialog.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f18938a.dismiss();
            }
        });
        this.listener = listener;
        initView();
    }

    private void initView() {
        this.binding = (VideosubmitDialogGuideBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.videosubmit_dialog_guide, (ViewGroup) null, false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onSignNow() {
        try {
            dismiss();
            ReportDataAdapter.onEvent(this.context, VideoSubmitEventConstant.CLINCK_BGTUBE_LEARNMORE);
            final Intent intent = new Intent(BaseApplication.getApp().getPackageName() + ".videosubmit");
            intent.putExtra(VideoSubmitStringConstant.IS_SHOW_VIDEO_SUBMIT_LINK_DIALOG, this.isGotoLinkDialog);
            p.just(true).delay(500L, TimeUnit.MILLISECONDS).subscribe(new io.reactivex.b.g() { // from class: com.sandboxol.videosubmit.view.dialog.b
                @Override // io.reactivex.b.g
                public final void accept(Object obj) throws Exception {
                    this.f18920a.a(intent, (Boolean) obj);
                }
            });
        } catch (ActivityNotFoundException unused) {
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

    public GuideDialog setBackgroundUrl(String str) {
        this.backgroundUrl.set(str);
        return this;
    }

    public GuideDialog setButtonText(String str) {
        this.binding.btnSignUp.setText(str);
        return this;
    }

    public GuideDialog setGotoLinkDialog(boolean z) {
        this.isGotoLinkDialog = z;
        return this;
    }

    public GuideDialog setButtonText(int i) {
        this.binding.btnSignUp.setText(i);
        return this;
    }
}
