package com.sandboxol.videosubmit.view.dialog;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogRegisterSucceedBinding;

/* JADX INFO: loaded from: classes4.dex */
public class RegisterSucceedDialog extends FullScreenDialog {
    private long time;
    public ObservableField<String> timeText;

    public RegisterSucceedDialog(Context context) {
        super(context);
        this.timeText = new ObservableField<>("0");
        this.time = 0L;
        initView();
        startTimer();
    }

    private void initView() {
        VideosubmitDialogRegisterSucceedBinding videosubmitDialogRegisterSucceedBinding = (VideosubmitDialogRegisterSucceedBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.videosubmit_dialog_register_succeed, (ViewGroup) null, false);
        videosubmitDialogRegisterSucceedBinding.setViewModel(this);
        setContentView(videosubmitDialogRegisterSucceedBinding.getRoot());
    }

    private void startTimer() {
        new CountDownTimer(3150L, 1000L) { // from class: com.sandboxol.videosubmit.view.dialog.RegisterSucceedDialog.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                RegisterSucceedDialog.this.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                RegisterSucceedDialog.this.timeText.set("(" + (j / 1000) + "S)");
                RegisterSucceedDialog.this.time = j;
            }
        }.start();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.time >= 3) {
            super.onBackPressed();
        }
    }
}
