package com.sandboxol.videosubmit.view.dialog;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogSubmitSucceedBinding;

/* JADX INFO: loaded from: classes4.dex */
public class SubmitSucceedDialog extends FullScreenDialog {
    private long time;
    public ObservableField<String> timeText;

    public SubmitSucceedDialog(Context context) {
        super(context);
        this.timeText = new ObservableField<>("0");
        this.time = 0L;
        initView();
        startTimer();
    }

    private void initView() {
        VideosubmitDialogSubmitSucceedBinding videosubmitDialogSubmitSucceedBinding = (VideosubmitDialogSubmitSucceedBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.videosubmit_dialog_submit_succeed, (ViewGroup) null, false);
        videosubmitDialogSubmitSucceedBinding.setViewModel(this);
        setContentView(videosubmitDialogSubmitSucceedBinding.getRoot());
    }

    private void startTimer() {
        new CountDownTimer(3150L, 1000L) { // from class: com.sandboxol.videosubmit.view.dialog.SubmitSucceedDialog.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                SubmitSucceedDialog.this.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                SubmitSucceedDialog.this.timeText.set("(" + (j / 1000) + "S)");
                SubmitSucceedDialog.this.time = j;
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
