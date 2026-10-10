package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.SystemAnnouncementInfo;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class NoticeDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f11326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OneButtonDialogListener f11327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SystemAnnouncementInfo f11328f;

    public interface OneButtonDialogListener {
        void onClick();
    }

    public NoticeDialog(Context context, String str, SystemAnnouncementInfo systemAnnouncementInfo) {
        super(context);
        this.f11328f = systemAnnouncementInfo;
        b(str);
    }

    private void a(String str) {
        this.f11325c.setText(str);
        this.f11324b.setText(this.f11328f.getTitle());
        this.f11323a.setText(com.disabngo.blockynexus.d.A.c(this.f11328f.getContent()));
        this.f11326d.setOnClickListener(this);
    }

    private void b(String str) {
        setContentView(R.layout.dialog_notice);
        this.f11325c = (TextView) findViewById(R.id.tvDialogTitle);
        this.f11323a = (TextView) findViewById(R.id.tvDetails);
        this.f11324b = (TextView) findViewById(R.id.tvTitle);
        this.f11326d = (Button) findViewById(R.id.btnSure);
        a(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btnSure) {
            return;
        }
        OneButtonDialogListener oneButtonDialogListener = this.f11327e;
        if (oneButtonDialogListener != null) {
            oneButtonDialogListener.onClick();
        }
        if (isShowing()) {
            dismiss();
        }
    }
}
