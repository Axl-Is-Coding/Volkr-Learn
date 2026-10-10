package com.sandbox.login.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.sandbox.login.R;
import com.sandbox.login.d.t;
import com.sandbox.login.entity.AccountRecordResult;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.dialog.FullScreenDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class ReloginTipDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AccountRecordResult f15973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IClickRelogin f15974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15975c;

    public interface IClickRelogin {
        void onClickRelogin();
    }

    public ReloginTipDialog(Context context, String str, IClickRelogin iClickRelogin) {
        this(context);
        this.f15974b = iClickRelogin;
        this.f15975c = str;
        initView();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void initView() {
        setContentView(R.layout.login_relogin_tip_dialog);
        findViewById(R.id.btnReLogin).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.tipText);
        if (this.f15973a == null) {
            String str = this.f15975c;
            if (str != null) {
                textView.setText(str);
                return;
            }
            return;
        }
        t.a().b(AccountCenter.newInstance().userId + "", new g(this, textView));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnReLogin) {
            dismiss();
            IClickRelogin iClickRelogin = this.f15974b;
            if (iClickRelogin != null) {
                iClickRelogin.onClickRelogin();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return b(a(a(str)));
    }

    private long a(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            if (date == null) {
                return 0L;
            }
            return date.getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private String b(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
    }

    public ReloginTipDialog(Context context, AccountRecordResult accountRecordResult, IClickRelogin iClickRelogin) {
        this(context);
        this.f15974b = iClickRelogin;
        this.f15973a = accountRecordResult;
        initView();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private long a(long j) {
        return j + ((long) TimeZone.getDefault().getRawOffset());
    }

    private ReloginTipDialog(Context context) {
        super(context);
    }
}
