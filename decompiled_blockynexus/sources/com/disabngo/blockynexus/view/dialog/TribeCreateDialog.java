package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class TribeCreateDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11393c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f11394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f11395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnTwoButtonDialogClickListener f11396f;
    private a g;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public interface a {
        void onLeftClick();
    }

    public TribeCreateDialog(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public TribeCreateDialog a(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.f11396f = onTwoButtonDialogClickListener;
        return this;
    }

    public void initView() {
        setContentView(R.layout.dialog_tribe_create);
        this.f11391a = (TextView) findViewById(R.id.tvTitle);
        this.f11392b = (TextView) findViewById(R.id.tvDetails);
        this.f11393c = (TextView) findViewById(R.id.tvDetailsEnd);
        this.f11394d = (Button) findViewById(R.id.btnSure);
        this.f11395e = (Button) findViewById(R.id.btnCancel);
        this.f11395e.setOnClickListener(this);
        this.f11394d.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            a aVar = this.g;
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
        OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.f11396f;
        if (onTwoButtonDialogClickListener != null) {
            onTwoButtonDialogClickListener.onClick();
        }
    }

    public TribeCreateDialog setDetailText(String str) {
        this.f11392b.setText(Html.fromHtml(str));
        return this;
    }

    public TribeCreateDialog setTitleText(int i) {
        this.f11391a.setText(i);
        return this;
    }

    public TribeCreateDialog a(String str) {
        this.f11393c.setText(str);
        return this;
    }
}
