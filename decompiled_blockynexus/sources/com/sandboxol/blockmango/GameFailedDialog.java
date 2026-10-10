package com.sandboxol.blockmango;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes2.dex */
public class GameFailedDialog extends Dialog implements View.OnClickListener {
    private Button btnBack;
    private Context context;
    private View.OnClickListener onClickListener;
    private TextView tvText;

    public GameFailedDialog(Context context) {
        super(context, R.style.FullScreenTheme);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.context = context;
        init(context);
        initView();
    }

    private void init(Context context) {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        requestWindowFeature(1);
        if (getWindow() != null) {
            getWindow().setWindowAnimations(R.style.cloudDialogWindowAnim);
        }
    }

    private void initView() {
        setContentView(com.sandboxol.game.R.layout.dialog_game_failed);
        this.tvText = (TextView) findViewById(com.sandboxol.game.R.id.tvText);
        this.btnBack = (Button) findViewById(com.sandboxol.game.R.id.btnBack);
        this.btnBack.setOnClickListener(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context context = this.context;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        View.OnClickListener onClickListener = this.onClickListener;
        if (onClickListener == null) {
            Process.killProcess(Process.myPid());
        } else {
            onClickListener.onClick(view);
        }
    }

    public GameFailedDialog setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public GameFailedDialog setText(String str) {
        this.tvText.setText(str);
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.context;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
    }

    public GameFailedDialog setText(int i) {
        this.tvText.setText(this.context.getResources().getText(i));
        return this;
    }
}
