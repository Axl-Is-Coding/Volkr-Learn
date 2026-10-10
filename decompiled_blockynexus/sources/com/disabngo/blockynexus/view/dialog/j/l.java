package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: WeekSignViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f11631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DailySignInfo f11632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f11633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11634e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.j.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f11615a.h();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11635f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.j.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f11616a.j();
        }
    });

    public l(Context context, g gVar, List<DailySignInfo> list) {
        this.f11630a = context;
        this.f11631b = gVar;
        this.f11632c = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        this.f11633d = new i(context, R.string.no_data, list);
    }

    private void i() {
        new k().a(this.f11630a, this.f11632c.getUrl(), f() ? this.f11632c.getName() : String.valueOf(this.f11632c.getQuantity()), 7L, this.f11632c);
        ReportDataAdapter.onEvent(this.f11630a, EventConstant.CLICK_SIGN_IN, VipSubscribeStatus.SUBSCRIPTION_RESTARTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int status = this.f11632c.getStatus();
        if (status == 0) {
            AppToastUtils.showShortNegativeTipToast(this.f11630a, R.string.week_sign_in_not_start);
        } else if (status == 1) {
            i();
        } else {
            if (status != 2) {
                return;
            }
            AppToastUtils.showShortNegativeTipToast(this.f11630a, R.string.week_sign_in_has_sign_in);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f() {
        /*
            r6 = this;
            com.sandboxol.center.entity.DailySignInfo r0 = r6.f11632c
            java.lang.String r0 = r0.getType()
            int r1 = r0.hashCode()
            r2 = -810698576(0xffffffffcfadb8b0, float:-5.829124E9)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == r2) goto L31
            r2 = 3178592(0x308060, float:4.454156E-39)
            if (r1 == r2) goto L27
            r2 = 1655054676(0x62a62154, float:1.5322805E21)
            if (r1 == r2) goto L1d
            goto L3b
        L1d:
            java.lang.String r1 = "diamond"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3b
            r0 = 2
            goto L3c
        L27:
            java.lang.String r1 = "gold"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3b
            r0 = 1
            goto L3c
        L31:
            java.lang.String r1 = "decoration"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3b
            r0 = 0
            goto L3c
        L3b:
            r0 = -1
        L3c:
            if (r0 == 0) goto L43
            if (r0 == r4) goto L42
            if (r0 == r3) goto L42
        L42:
            return r5
        L43:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.j.l.f():boolean");
    }

    public /* synthetic */ void h() {
        this.f11631b.dismiss();
        ReportDataAdapter.onEvent(this.f11630a, EventConstant.SIGN_IN_CLOSE, "close");
    }
}
