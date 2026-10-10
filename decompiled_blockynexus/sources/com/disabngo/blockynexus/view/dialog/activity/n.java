package com.disabngo.blockynexus.view.dialog.activity;

import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.entity.ActivityTaskActionReward;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.EventRedPointManager;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: ActivityTaskContentItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends OnResponseListener<ActivityTaskAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f11494a;

    n(o oVar) {
        this.f11494a = oVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ActivityTaskAction activityTaskAction) {
        ((ActivityTaskAction) ((ListItemViewModel) this.f11494a).item).setCompleteQuantity(((ActivityTaskAction) ((ListItemViewModel) this.f11494a).item).getQuantity());
        ((ActivityTaskAction) ((ListItemViewModel) this.f11494a).item).setStatus(2);
        this.f11494a.f();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Observable.from(((ActivityTaskAction) ((ListItemViewModel) this.f11494a).item).getActionRewards()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.dialog.activity.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11478a.a(arrayList, arrayList2, (ActivityTaskActionReward) obj);
            }
        });
        new CampaignGetIntegralRewardDialog(((ListItemViewModel) this.f11494a).context).setStringDataList(arrayList.size(), arrayList, arrayList2).show();
        if (this.f11494a.f11495a != null) {
            EventRedPointManager.getInstance().removeOneEventRedPoint(AccountCenter.newInstance().userId.get().longValue(), this.f11494a.f11495a);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(((ListItemViewModel) this.f11494a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((ListItemViewModel) this.f11494a).context, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(java.util.List r6, java.util.List r7, com.disabngo.blockynexus.entity.ActivityTaskActionReward r8) {
        /*
            r5 = this;
            java.lang.String r0 = r8.getRewardType()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -810698576: goto L2d;
                case 116765: goto L23;
                case 3178592: goto L19;
                case 1655054676: goto Lf;
                default: goto Le;
            }
        Le:
            goto L37
        Lf:
            java.lang.String r1 = "diamond"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L19:
            java.lang.String r1 = "gold"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L23:
            java.lang.String r1 = "vip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L2d:
            java.lang.String r1 = "decoration"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 3
            goto L38
        L37:
            r0 = -1
        L38:
            if (r0 == 0) goto L79
            if (r0 == r4) goto L55
            if (r0 == r3) goto L4b
            if (r0 == r2) goto L41
            goto La1
        L41:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.String r1 = "token.refresh.decoration.type"
            r0.sendNoMsg(r1)
            goto La1
        L4b:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.String r1 = "token.buy.vip.success"
            r0.sendNoMsg(r1)
            goto La1
        L55:
            com.sandboxol.center.entity.AccountCenter r0 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Long> r0 = r0.golds
            com.sandboxol.center.entity.AccountCenter r1 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Long> r1 = r1.golds
            java.lang.Object r1 = r1.get()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            int r3 = r8.getQuantity()
            long r3 = (long) r3
            long r1 = r1 + r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.set(r1)
            goto La1
        L79:
            com.sandboxol.center.entity.AccountCenter r0 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Long> r0 = r0.diamonds
            com.sandboxol.center.entity.AccountCenter r1 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Long> r1 = r1.diamonds
            java.lang.Object r1 = r1.get()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            int r3 = r8.getQuantity()
            long r3 = (long) r3
            long r1 = r1 + r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.set(r1)
            com.disabngo.blockynexus.view.dialog.activity.o r0 = r5.f11494a
            com.disabngo.blockynexus.view.dialog.activity.o.a(r0, r8)
        La1:
            java.lang.String r0 = r8.getRewardPic()
            r6.add(r0)
            java.lang.String r6 = r8.getRewardName()
            r7.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.dialog.activity.n.a(java.util.List, java.util.List, com.disabngo.blockynexus.entity.ActivityTaskActionReward):void");
    }
}
