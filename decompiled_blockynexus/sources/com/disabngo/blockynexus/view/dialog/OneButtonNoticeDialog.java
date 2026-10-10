package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class OneButtonNoticeDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f11335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11336c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private onClickListener f11337d;

    public interface onClickListener {
        void onClick();
    }

    public OneButtonNoticeDialog(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public OneButtonNoticeDialog a(String str) {
        this.f11336c.setText(str);
        return this;
    }

    public void initView() {
        setContentView(R.layout.dialog_tribe_notice_one_button);
        this.f11334a = (TextView) findViewById(R.id.tvDetails);
        this.f11335b = (Button) findViewById(R.id.btnSure);
        this.f11336c = (TextView) findViewById(R.id.tvTitle);
        findViewById(R.id.rlBg).setOnClickListener(this);
        this.f11335b.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btnSure) {
            if (id != R.id.rlBg) {
                return;
            }
            dismiss();
        } else {
            onClickListener onclicklistener = this.f11337d;
            if (onclicklistener != null) {
                onclicklistener.onClick();
            }
            dismiss();
        }
    }

    public OneButtonNoticeDialog setButtonText(String str) {
        this.f11335b.setText(str);
        return this;
    }

    public OneButtonNoticeDialog setDetailText(String str) {
        this.f11334a.setText(str);
        return this;
    }
}
