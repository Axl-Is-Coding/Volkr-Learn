package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import rx.functions.Action0;

/* JADX INFO: compiled from: WeekSignItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ListItemViewModel<DailySignInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f11622b;

    public h(Context context, DailySignInfo dailySignInfo) {
        super(context, dailySignInfo);
        this.f11621a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.j.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11611a.i();
            }
        });
        this.f11622b = new ObservableField<>();
        this.f11622b.set(context.getString(CommonHelper.getResourcesById(BaseApplication.getContext(), "week_sign_in_day_", dailySignInfo.getId() + "", "string")));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h() {
        new k().a(this.context, ((DailySignInfo) this.item).getUrl(), f() ? ((DailySignInfo) this.item).getName() : String.valueOf(((DailySignInfo) this.item).getQuantity()), ((DailySignInfo) this.item).getId(), (DailySignInfo) this.item);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SIGN_IN, String.valueOf(((DailySignInfo) this.item).getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        int status = ((DailySignInfo) this.item).getStatus();
        if (status == 0) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.week_sign_in_not_start);
        } else if (status == 1) {
            h();
        } else {
            if (status != 2) {
                return;
            }
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.week_sign_in_has_sign_in);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f() {
        /*
            r6 = this;
            T r0 = r6.item
            com.sandboxol.center.entity.DailySignInfo r0 = (com.sandboxol.center.entity.DailySignInfo) r0
            java.lang.String r0 = r0.getType()
            int r1 = r0.hashCode()
            r2 = -810698576(0xffffffffcfadb8b0, float:-5.829124E9)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == r2) goto L33
            r2 = 3178592(0x308060, float:4.454156E-39)
            if (r1 == r2) goto L29
            r2 = 1655054676(0x62a62154, float:1.5322805E21)
            if (r1 == r2) goto L1f
            goto L3d
        L1f:
            java.lang.String r1 = "diamond"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3d
            r0 = 2
            goto L3e
        L29:
            java.lang.String r1 = "gold"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3d
            r0 = 1
            goto L3e
        L33:
            java.lang.String r1 = "decoration"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3d
            r0 = 0
            goto L3e
        L3d:
            r0 = -1
        L3e:
            if (r0 == 0) goto L45
            if (r0 == r4) goto L44
            if (r0 == r3) goto L44
        L44:
            return r5
        L45:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.j.h.f():boolean");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public DailySignInfo getItem() {
        return (DailySignInfo) super.getItem();
    }
}
