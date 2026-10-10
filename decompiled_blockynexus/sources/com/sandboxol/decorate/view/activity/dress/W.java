package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.LimitedTimes;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.dialog.LeaveDressShopDialog;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressShopSuitItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class W extends ListItemViewModel<SuitDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f17259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f17260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f17261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f17262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f17263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f17264f;
    public ReplyCommand g;

    public W(Context context, SuitDressInfo suitDressInfo) {
        super(context, suitDressInfo);
        this.f17259a = new ObservableField<>(false);
        this.f17260b = new ObservableField<>(0);
        this.f17261c = new ObservableField<>();
        this.f17262d = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.G
            @Override // rx.functions.Action0
            public final void call() {
                this.f17228a.m();
            }
        });
        this.f17263e = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.D
            @Override // rx.functions.Action0
            public final void call() {
                this.f17223a.l();
            }
        });
        this.f17264f = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.E
            @Override // rx.functions.Action0
            public final void call() {
                this.f17226a.f();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.B
            @Override // rx.functions.Action0
            public final void call() {
                this.f17221a.h();
            }
        });
        initView();
    }

    static /* synthetic */ void a(HashMap map, SingleDressInfo singleDressInfo) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        List<LimitedTimes> limitedTimes = ((SuitDressInfo) this.item).getLimitedTimes();
        if (limitedTimes != null && !limitedTimes.isEmpty()) {
            this.f17260b.set(Integer.valueOf(limitedTimes.get(0).getPrice()));
        }
        j();
        this.f17261c.set(this.context.getString(R.string.decorate_new_dress_time_reminder, String.valueOf(((SuitDressInfo) this.item).getRemainingDays())));
        T t = this.item;
        if (t == 0 || ((SuitDressInfo) t).getDecorationInfoList() == null || ((SuitDressInfo) this.item).getDecorationInfoList().size() <= 0) {
            return;
        }
        if (com.sandboxol.decorate.manager.o.a().a(((SuitDressInfo) this.item).getDecorationInfoList().get(0).getResourceId())) {
            this.f17259a.set(true);
        } else {
            com.sandboxol.decorate.manager.q.a(com.sandboxol.decorate.manager.q.b(), ((SuitDressInfo) this.item).getDecorationInfoList().get(0).getResourceId(), this.f17259a);
            com.sandboxol.decorate.f.j.a(((SuitDressInfo) this.item).getDecorationInfoList().get(0));
        }
    }

    private void k() {
        com.sandboxol.decorate.manager.f.e().g().a(this.context, this.item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        new LeaveDressShopDialog(this.context, ((SuitDressInfo) this.item).getActivityFlag()).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.activity.dress.F
            @Override // com.sandboxol.decorate.view.dialog.LeaveDressShopDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        final HashMap map = new HashMap();
        Observable.from(((SuitDressInfo) this.item).getShopDecorationInfos()).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.activity.dress.C
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                W.a(map, (SingleDressInfo) obj);
            }
        });
        new K().a(this.context, map);
    }

    private void p() {
        com.sandboxol.decorate.manager.f.e().h().a(this.context, this.item);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (com.sandboxol.decorate.manager.v.b().f17215d.contains(Long.valueOf(((SuitDressInfo) this.item).getSuitId()))) {
            p();
        } else {
            k();
        }
    }

    public /* synthetic */ void h() {
        AppToastUtils.showShortNegativeTipToast(this.context, R.string.decorate_dress_res_not_ready);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_LOADING_CLICK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable j() {
        if (((SuitDressInfo) this.item).getIsRecommend() == 1) {
            return this.context.getResources().getDrawable(R.mipmap.ic_dress_tag_recommend);
        }
        if (((SuitDressInfo) this.item).getIsNew() == 1) {
            return this.context.getResources().getDrawable(R.mipmap.ic_dress_tag_new);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public SuitDressInfo getItem() {
        return (SuitDressInfo) super.getItem();
    }
}
