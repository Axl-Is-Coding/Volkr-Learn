package com.sandboxol.halloween.view.fragment.tasks;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.view.widget.counDownView.CountDownManager;
import com.sandboxol.center.view.widget.counDownView.ICountDownOverProvider;
import com.sandboxol.center.view.widget.counDownView.NormalCountDownTimer;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.entity.HalloweenTask;
import com.sandboxol.halloween.entity.HalloweenTaskResponse;
import com.sandboxol.halloween.view.fragment.tasks.h;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class TasksItemViewModel extends ListItemViewModel<HalloweenTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NormalCountDownTimer f18737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f18738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f18739f;
    public ObservableField<Integer> g;
    public ObservableField<String> h;
    public ObservableField<Drawable> i;
    public ObservableField<String> j;
    public ObservableField<Integer> k;
    public ObservableField<Long> l;
    public ObservableField<Boolean> m;
    public ReplyCommand n;

    public TasksItemViewModel(Context context, HalloweenTask halloweenTask) {
        super(context, halloweenTask);
        this.f18734a = 101;
        this.f18735b = 102;
        this.f18736c = 103;
        this.f18738e = new ObservableField<>(1);
        this.f18739f = new ObservableField<>(0);
        this.g = new ObservableField<>(0);
        this.h = new ObservableField<>("0/0");
        this.i = new ObservableField<>();
        this.j = new ObservableField<>();
        this.k = new ObservableField<>();
        this.l = new ObservableField<>(-1L);
        this.m = new ObservableField<>(false);
        this.n = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.tasks.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18742a.onClick();
            }
        });
        initData();
    }

    private void d(int i) {
        if (i == 1) {
            this.i.set(androidx.core.content.b.c(this.context, R.drawable.halloween_bg_btn_receive));
        } else if (i != 2) {
            this.i.set(androidx.core.content.b.c(this.context, R.drawable.halloween_bg_btn_go));
        } else {
            this.i.set(androidx.core.content.b.c(this.context, R.drawable.halloween_bg_btn_finish));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            r3 = this;
            T r0 = r3.item
            com.sandboxol.halloween.entity.HalloweenTask r0 = (com.sandboxol.halloween.entity.HalloweenTask) r0
            java.lang.String r0 = r0.getTaskType()
            int r1 = r0.hashCode()
            r2 = 1
            switch(r1) {
                case -1655867487: goto L4d;
                case -885692133: goto L43;
                case -881074528: goto L39;
                case -859663748: goto L2f;
                case -401007680: goto L25;
                case 207715503: goto L1b;
                case 1878364486: goto L11;
                default: goto L10;
            }
        L10:
            goto L57
        L11:
            java.lang.String r1 = "playGame"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 1
            goto L58
        L1b:
            java.lang.String r1 = "recharge600"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 6
            goto L58
        L25:
            java.lang.String r1 = "onlineTime"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 0
            goto L58
        L2f:
            java.lang.String r1 = "consumeGold"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 4
            goto L58
        L39:
            java.lang.String r1 = "consumeGCube"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 2
            goto L58
        L43:
            java.lang.String r1 = "consumeBCube"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 3
            goto L58
        L4d:
            java.lang.String r1 = "recharge60"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L57
            r0 = 5
            goto L58
        L57:
            r0 = -1
        L58:
            switch(r0) {
                case 0: goto L77;
                case 1: goto L77;
                case 2: goto L77;
                case 3: goto L6d;
                case 4: goto L6d;
                case 5: goto L5c;
                case 6: goto L5c;
                default: goto L5b;
            }
        L5b:
            goto L80
        L5c:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.String r1 = "token.open.recharge"
            r0.sendNoMsg(r1)
            com.sandboxol.halloween.c.b r0 = com.sandboxol.halloween.c.b.b()
            r0.a(r2)
            goto L80
        L6d:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.String r1 = "token.open.shop"
            r0.sendNoMsg(r1)
            goto L80
        L77:
            com.sandboxol.common.messenger.Messenger r0 = com.sandboxol.common.messenger.Messenger.getDefault()
            java.lang.String r1 = "token.open.main.activity"
            r0.sendNoMsg(r1)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.view.fragment.tasks.TasksItemViewModel.h():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        h.a(this.context, ((HalloweenTask) this.item).getTaskType(), new h.a() { // from class: com.sandboxol.halloween.view.fragment.tasks.a
            @Override // com.sandboxol.halloween.view.fragment.tasks.h.a
            public final void a(HalloweenTaskResponse halloweenTaskResponse) {
                this.f18740a.a(halloweenTaskResponse);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        T t = this.item;
        if (t != 0) {
            this.f18739f.set(Integer.valueOf(((HalloweenTask) t).getRequire()));
            this.g.set(Integer.valueOf(((HalloweenTask) this.item).getStatus() == 2 ? ((HalloweenTask) this.item).getRequire() : ((HalloweenTask) this.item).getComplete()));
            this.h.set(this.g.get() + "/" + this.f18739f.get());
            d(((HalloweenTask) this.item).getStatus());
            c(((HalloweenTask) this.item).getStatus());
            b(((HalloweenTask) this.item).getStatus());
            HalloweenInfoResponse halloweenInfoResponseA = com.sandboxol.halloween.c.b.b().a();
            if (halloweenInfoResponseA != null) {
                this.l.set(Long.valueOf(halloweenInfoResponseA.getSurplusSeconds() * 1000));
                this.m.set(Boolean.valueOf(((HalloweenTask) this.item).getStatus() == 2 && halloweenInfoResponseA.getSurplusSeconds() != 0));
                if (this.m.get().booleanValue() && this.f18737d == null) {
                    this.f18737d = new NormalCountDownTimer(halloweenInfoResponseA.getSurplusSeconds() * 1000, 1000L);
                    this.f18737d.setiCountDownOverProvider(new ICountDownOverProvider() { // from class: com.sandboxol.halloween.view.fragment.tasks.b
                        @Override // com.sandboxol.center.view.widget.counDownView.ICountDownOverProvider
                        public final void onFinish() {
                            this.f18741a.f();
                        }
                    });
                    CountDownManager.getInstance().registerCountDownTime(this.f18737d);
                    ObservableField<Integer> observableField = this.f18738e;
                    observableField.set(Integer.valueOf(observableField.get().intValue() + 1));
                }
            }
        }
    }

    private void j() {
        Messenger.getDefault().sendNoMsg("token.refresh.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onClick() {
        int status = ((HalloweenTask) this.item).getStatus();
        if (status == 1) {
            i();
        } else if (status != 2) {
            h();
        }
    }

    public /* synthetic */ void a(HalloweenTaskResponse halloweenTaskResponse) {
        j();
        Context context = this.context;
        AppToastUtils.showLongPositiveTipToast(context, context.getString(R.string.halloween_receive_candy_tips, String.valueOf(halloweenTaskResponse.getAcquireCandy())));
    }

    public void b(int i) {
        if (i == 1) {
            this.j.set(this.context.getString(R.string.halloween_task_tips_receive));
        } else if (i != 2) {
            this.j.set(this.context.getString(R.string.halloween_task_tips_doing));
        } else {
            this.j.set(this.context.getString(R.string.halloween_task_tips_completed));
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.k.set(Integer.valueOf(androidx.core.content.b.a(this.context, R.color.halloween_btn_status_color_receive)));
        } else if (i != 2) {
            this.k.set(Integer.valueOf(androidx.core.content.b.a(this.context, R.color.halloween_btn_status_color_doing)));
        } else {
            this.k.set(Integer.valueOf(androidx.core.content.b.a(this.context, R.color.halloween_btn_status_color_finish)));
        }
    }

    public /* synthetic */ void f() {
        this.m.set(false);
        j();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public HalloweenTask getItem() {
        initData();
        return (HalloweenTask) super.getItem();
    }
}
