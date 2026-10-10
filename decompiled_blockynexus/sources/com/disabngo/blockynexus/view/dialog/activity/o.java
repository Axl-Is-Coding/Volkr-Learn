package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.entity.ActivityTaskActionReward;
import com.disabngo.blockynexus.web.CampaignApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.EventRedPointManager;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActivityTaskContentItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends ListItemViewModel<ActivityTaskAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f11496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f11497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11498d;

    public o(Context context, ActivityTaskAction activityTaskAction, String str) {
        super(context, activityTaskAction);
        this.f11497c = new x();
        this.f11498d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.activity.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f11483a.h();
            }
        });
        this.f11495a = str;
        this.f11496b = new s(context, R.string.no_data, activityTaskAction.getActionRewards());
        if (str != null && activityTaskAction.getStatus() == 1) {
            EventRedPointManager.getInstance().addOneEventRedPoint(AccountCenter.newInstance().userId.get().longValue(), str);
        }
        initMessenger();
    }

    static /* synthetic */ void a(Long l) {
    }

    static /* synthetic */ void b(Long l) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initMessenger() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f11495a
            int r1 = r0.hashCode()
            r2 = 1226862376(0x49206f28, float:657138.5)
            r3 = 1
            if (r1 == r2) goto L1c
            r2 = 1226863719(0x49207467, float:657222.44)
            if (r1 == r2) goto L12
            goto L26
        L12:
            java.lang.String r1 = "weekend"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L26
            r0 = 0
            goto L27
        L1c:
            java.lang.String r1 = "weekday"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = -1
        L27:
            if (r0 == 0) goto L3a
            if (r0 == r3) goto L2c
            goto L47
        L2c:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            com.disabngo.blockynexus.view.dialog.activity.c r2 = new rx.functions.Action1() { // from class: com.disabngo.blockynexus.view.dialog.activity.c
                static {
                    /*
                        com.disabngo.blockynexus.view.dialog.activity.c r0 = new com.disabngo.blockynexus.view.dialog.activity.c
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.disabngo.blockynexus.view.dialog.activity.c) com.disabngo.blockynexus.view.dialog.activity.c.a com.disabngo.blockynexus.view.dialog.activity.c
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.c.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.c.<init>():void");
                }

                @Override // rx.functions.Action1
                public final void call(java.lang.Object r1) {
                    /*
                        r0 = this;
                        java.lang.Long r1 = (java.lang.Long) r1
                        com.disabngo.blockynexus.view.dialog.activity.o.b(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.c.call(java.lang.Object):void");
                }
            }
            java.lang.String r3 = "token.activity.weekday.red.point"
            r0.register(r4, r3, r1, r2)
            goto L47
        L3a:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            com.disabngo.blockynexus.view.dialog.activity.d r2 = new rx.functions.Action1() { // from class: com.disabngo.blockynexus.view.dialog.activity.d
                static {
                    /*
                        com.disabngo.blockynexus.view.dialog.activity.d r0 = new com.disabngo.blockynexus.view.dialog.activity.d
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.disabngo.blockynexus.view.dialog.activity.d) com.disabngo.blockynexus.view.dialog.activity.d.a com.disabngo.blockynexus.view.dialog.activity.d
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.d.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.d.<init>():void");
                }

                @Override // rx.functions.Action1
                public final void call(java.lang.Object r1) {
                    /*
                        r0 = this;
                        java.lang.Long r1 = (java.lang.Long) r1
                        com.disabngo.blockynexus.view.dialog.activity.o.a(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.d.call(java.lang.Object):void");
                }
            }
            java.lang.String r3 = "token.activity.weekend.red.point"
            r0.register(r4, r3, r1, r2)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.o.initMessenger():void");
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        T t = this.item;
        if (t != 0) {
            if ("saturday_login".equals(((ActivityTaskAction) t).getActionFlag())) {
                ReportDataAdapter.onEvent(this.context, EventConstant.SAT_LOGIN_SUC);
                return;
            }
            if ("sunday_login".equals(((ActivityTaskAction) this.item).getActionFlag())) {
                ReportDataAdapter.onEvent(this.context, EventConstant.SUN_LOGIN_SUC);
                return;
            }
            if ("online_time".equals(((ActivityTaskAction) this.item).getActionFlag())) {
                int quantity = ((ActivityTaskAction) this.item).getQuantity();
                if (quantity == 10) {
                    ReportDataAdapter.onEvent(this.context, EventConstant.MIN_SUC);
                } else if (quantity == 30) {
                    ReportDataAdapter.onEvent(this.context, EventConstant.MIN_SUC1);
                } else {
                    if (quantity != 60) {
                        return;
                    }
                    ReportDataAdapter.onEvent(this.context, EventConstant.MIN_SUC2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        CampaignApi.getActivityTaskReward(this.context, this.f11495a, ((ActivityTaskAction) this.item).getActionId(), new n(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ActivityTaskAction getItem() {
        return (ActivityTaskAction) super.getItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ActivityTaskActionReward activityTaskActionReward) {
        if ("recharge".equals(this.f11495a)) {
            int quantity = activityTaskActionReward.getQuantity();
            if (quantity == 60) {
                ReportDataAdapter.onEvent(this.context, EventConstant.FRIST_TOPUP_SUC);
                return;
            }
            if (quantity == 100) {
                ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_SUC);
                return;
            }
            if (quantity == 220) {
                ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_SUC1);
                return;
            }
            if (quantity == 600) {
                ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_SUC3);
            } else if (quantity == 1300) {
                ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_SUC2);
            } else {
                if (quantity != 2800) {
                    return;
                }
                ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_SUC4);
            }
        }
    }
}
