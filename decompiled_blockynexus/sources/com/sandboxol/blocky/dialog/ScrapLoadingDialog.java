package com.sandboxol.blocky.dialog;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.widget.ImageView;
import com.sandboxol.common.R;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import io.rong.imageloader.core.download.BaseImageDownloader;

/* JADX INFO: loaded from: classes.dex */
public class ScrapLoadingDialog extends HideNavigationBarDialog {
    private final int OVERTIME;
    private int boxIndex;
    private Context context;
    private CountDownTimer countDownTimer;
    private AnimationDrawable loadingAnim;

    public ScrapLoadingDialog(Context context) {
        super(context);
        this.OVERTIME = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    }

    private void startTimer() {
        this.countDownTimer = new CountDownTimer(20000L, 1000L) { // from class: com.sandboxol.blocky.dialog.ScrapLoadingDialog.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (ScrapLoadingDialog.this.isShowing()) {
                    ScrapLoadingDialog.this.dismiss();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.countDownTimer.start();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.loadingAnim.isRunning()) {
                this.loadingAnim.stop();
            }
            super.dismiss();
            if (this.countDownTimer != null) {
                this.countDownTimer.cancel();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }

    public int getBoxIndex() {
        return this.boxIndex;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        this.context = context;
        setContentView(R.layout.common_dialog_app_loading);
        this.loadingAnim = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (this.loadingAnim.isRunning()) {
            return;
        }
        this.loadingAnim.start();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        if (isShowing()) {
            dismiss();
        }
    }

    public void setBoxIndex(int i) {
        this.boxIndex = i;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog
    public void show() {
        super.show();
        startTimer();
    }
}
