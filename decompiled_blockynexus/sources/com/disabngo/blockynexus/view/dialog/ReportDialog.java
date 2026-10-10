package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.BlockAccountResult;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ReportDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f11365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f11366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f11367f;
    private Button g;
    private OnTwoButtonDialogClickListener h;
    private a i;
    private long[] j;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public interface a {
        void onLeftClick();
    }

    public ReportDialog(Context context, ReportInfo reportInfo) {
        super(context);
        this.j = new long[2];
        initView();
        a(reportInfo);
    }

    private void a(ReportInfo reportInfo) {
        this.f11362a.setText(this.context.getString(R.string.report_tip, Long.valueOf(reportInfo.getUserId())));
        this.f11363b.setText(this.context.getString(R.string.report_reason, reportInfo.getStopReason()));
        this.f11364c.setText(this.context.getString(R.string.report_date, reportInfo.getStopToTime()));
    }

    public void initView() {
        setContentView(R.layout.dialog_report);
        this.f11362a = (TextView) findViewById(R.id.tvTitle);
        this.f11363b = (TextView) findViewById(R.id.tvReason);
        this.f11364c = (TextView) findViewById(R.id.tvTime);
        this.f11367f = (Button) findViewById(R.id.btnSure);
        this.g = (Button) findViewById(R.id.btnCancel);
        this.f11365d = findViewById(R.id.vLine1);
        this.f11366e = findViewById(R.id.vLine2);
        this.g.setOnClickListener(this);
        this.f11367f.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        long[] jArr = this.j;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.j;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (SystemClock.uptimeMillis() - this.j[0] < 1000) {
            Process.killProcess(Process.myPid());
        } else {
            AppToastUtils.showShortPositiveTipToast(this.context, R.string.exit);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            a aVar = this.i;
            if (aVar != null) {
                aVar.onLeftClick();
                return;
            }
            return;
        }
        if (id != R.id.btnSure) {
            return;
        }
        dismiss();
        OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.h;
        if (onTwoButtonDialogClickListener != null) {
            onTwoButtonDialogClickListener.onClick();
        }
    }

    private void a(BlockAccountResult blockAccountResult) {
        this.f11365d.setVisibility(8);
        this.f11366e.setVisibility(8);
        this.f11367f.setVisibility(8);
        this.f11362a.setText(this.context.getString(R.string.block_device));
        this.f11363b.setText(this.context.getString(R.string.report_reason, blockAccountResult.getReason()));
        this.f11364c.setText(this.context.getString(R.string.report_date, blockAccountResult.getBlockTime()));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportDialog.a(view);
            }
        });
    }

    public ReportDialog(Context context, BlockAccountResult blockAccountResult) {
        super(context);
        this.j = new long[2];
        initView();
        a(blockAccountResult);
    }

    static /* synthetic */ void a(View view) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        Process.killProcess(Process.myPid());
    }

    public ReportDialog a(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.h = onTwoButtonDialogClickListener;
        return this;
    }

    public ReportDialog a(a aVar) {
        this.i = aVar;
        return this;
    }
}
