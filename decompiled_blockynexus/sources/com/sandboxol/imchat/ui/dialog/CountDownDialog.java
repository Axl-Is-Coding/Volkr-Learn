package com.sandboxol.imchat.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.imchat.R;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class CountDownDialog extends FullScreenDialog implements View.OnClickListener {
    private Button btnCancel;
    private Context context;
    private CountDownDialogListener listener;
    private long ticks;
    private Timer timer;
    private TextView tvCountDown;

    public interface CountDownDialogListener {
        void onClickCancel();
    }

    public CountDownDialog(Context context) {
        super(context);
        this.ticks = 0L;
        this.context = context;
    }

    static /* synthetic */ long access$308(CountDownDialog countDownDialog) {
        long j = countDownDialog.ticks;
        countDownDialog.ticks = 1 + j;
        return j;
    }

    private String formatTen(long j) {
        if (j >= 10) {
            return String.valueOf(j);
        }
        return "0" + String.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatTick() {
        long j = this.ticks;
        return String.format("%s:%s", formatTen(j / 60), formatTen(j % 60));
    }

    private void startTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() { // from class: com.sandboxol.imchat.ui.dialog.CountDownDialog.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((Activity) CountDownDialog.this.context).runOnUiThread(new Runnable() { // from class: com.sandboxol.imchat.ui.dialog.CountDownDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CountDownDialog.this.tvCountDown.setText(CountDownDialog.this.context.getString(R.string.dialog_enter_game_timer, CountDownDialog.this.formatTick()));
                        CountDownDialog.access$308(CountDownDialog.this);
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        stopTimer();
        super.dismiss();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        setContentView(R.layout.dialog_game_count_down);
        this.tvCountDown = (TextView) findViewById(R.id.tvCountDown);
        this.btnCancel = (Button) findViewById(R.id.btnCancel);
        this.btnCancel.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CountDownDialogListener countDownDialogListener = this.listener;
        if (countDownDialogListener != null) {
            countDownDialogListener.onClickCancel();
        }
        dismiss();
    }

    public void start(CountDownDialogListener countDownDialogListener) {
        this.listener = countDownDialogListener;
        startTimer();
    }
}
