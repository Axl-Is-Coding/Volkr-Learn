package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0540c;
import com.disabngo.blockynexus.e.b.h.C0850a;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActivityNewDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f11491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0850a f11492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11493c;

    public m(Context context, String str, String str2, String str3, String str4) {
        super(context);
        this.f11492b = new C0850a();
        this.f11493c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.activity.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11477a.a();
            }
        });
        initView();
        this.f11491a = new q(context, R.string.no_data, str, str2, str3, str4);
        if ("recharge".equals(str4)) {
            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_GIFT_TIME);
        }
    }

    private void initView() {
        AbstractC0540c abstractC0540c = (AbstractC0540c) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.activity_content_temp_weekend, (ViewGroup) null, false);
        abstractC0540c.a(this);
        setContentView(abstractC0540c.getRoot());
    }

    public /* synthetic */ void a() {
        dismiss();
    }
}
