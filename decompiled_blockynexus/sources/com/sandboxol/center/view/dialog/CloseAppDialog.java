package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class CloseAppDialog extends FullScreenDialog implements View.OnClickListener {
    private Button btnSure;
    private Context context;
    private TextView tvDetails;

    public CloseAppDialog(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public void initView() {
        setContentView(R.layout.base_dialog_close_app);
        this.tvDetails = (TextView) findViewById(R.id.tvDetails);
        this.btnSure = (Button) findViewById(R.id.btnSure);
        this.btnSure.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        if (view.getId() == R.id.btnSure) {
            Process.killProcess(Process.myPid());
            ReportDataAdapter.onEvent(this.context, EventConstant.MEMORY_NOT_ENOUGH);
        }
    }
}
