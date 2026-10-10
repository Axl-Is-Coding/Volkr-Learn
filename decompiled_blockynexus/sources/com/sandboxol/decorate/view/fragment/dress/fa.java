package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonEventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.decorate.view.dialog.LeaveDressShopDialog;
import java.util.HashMap;
import rx.functions.Action0;

/* JADX INFO: compiled from: DressItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class fa extends ListItemViewModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f17419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f17420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f17421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f17422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f17423f;
    public ReplyCommand g;

    public fa(Context context, SingleDressInfo singleDressInfo, int i) {
        super(context, singleDressInfo);
        this.f17419b = new ObservableField<>(false);
        this.f17420c = new ObservableField<>();
        this.f17421d = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f17413a.u();
            }
        });
        this.f17422e = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f17416a.p();
            }
        });
        this.f17423f = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f17424a.h();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f17411a.i();
            }
        });
        this.f17418a = i;
        initView();
    }

    private void D() {
        new TwoButtonDialog(this.context).setDetailText(this.context.getString(R.string.decorate_vip_level_not_enough)).setRightButtonText(R.string.decorate_vip_pay_open_vip).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.fragment.dress.f
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_VIP_RECHARGE);
            }
        }).show();
    }

    private void a(boolean z) {
        if (z) {
            com.sandboxol.decorate.manager.f.e().j().a(this.context, this.item);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_RECOMMEND_CLICK);
        } else {
            if (m()) {
                return;
            }
            com.sandboxol.decorate.manager.f.e().a().a(this.context, this.item);
            SandboxReportManager.onEvent(ReportEvent.NEW_DRESS_CLICK_CARD, ReportEventType.NEW_USER_BEHAVIOR, "app");
        }
    }

    private void b(boolean z) {
        if (z) {
            com.sandboxol.decorate.manager.f.e().m().a(this.context, this.item);
        } else {
            com.sandboxol.decorate.manager.f.e().d().a(this.context, this.item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        if (com.sandboxol.decorate.manager.o.a().a(((SingleDressInfo) this.item).getResourceId())) {
            this.f17419b.set(true);
        } else {
            com.sandboxol.decorate.manager.q.a(com.sandboxol.decorate.manager.q.a(), ((SingleDressInfo) this.item).getResourceId(), this.f17419b);
            com.sandboxol.decorate.f.j.a((SingleDressInfo) this.item);
        }
        this.f17420c.set(Integer.valueOf(((SingleDressInfo) this.item).getSuitId() == 0 ? ((SingleDressInfo) this.item).getPrice() : (int) ((SingleDressInfo) this.item).getSuitPrice()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean m() {
        int typeId = (int) ((SingleDressInfo) this.item).getTypeId();
        if ((typeId != 6 && typeId != 7) || AccountCenter.newInstance().vip.get().intValue() >= ((SingleDressInfo) this.item).getVip()) {
            return false;
        }
        D();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void p() {
        ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((SingleDressInfo) this.item).getId()));
        new LeaveDressShopDialog(this.context, ((SingleDressInfo) this.item).getActivityFlag()).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.fragment.dress.b
            @Override // com.sandboxol.decorate.view.dialog.LeaveDressShopDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void u() {
        HashMap map = new HashMap();
        map.put(Long.valueOf(((SingleDressInfo) this.item).getTypeId()), new ShopRecommendDecorationInfo((SingleDressInfo) this.item));
        new com.sandboxol.decorate.view.activity.dress.K().a(this.context, map);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_RECOMMEND_PRICE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f() {
        return ((SingleDressInfo) this.item).getExpire() < 0 ? this.context.getString(R.string.decorate_time_limit) : this.context.getString(R.string.decorate_left_days, Integer.valueOf(((SingleDressInfo) this.item).getExpire()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void h() {
        if (com.sandboxol.decorate.manager.v.a().f17214c.containsValue(Long.valueOf(((SingleDressInfo) this.item).getId()))) {
            b(((SingleDressInfo) this.item).isDressRec());
        } else {
            a(((SingleDressInfo) this.item).isDressRec());
        }
    }

    public /* synthetic */ void i() {
        AppToastUtils.showShortNegativeTipToast(this.context, R.string.decorate_dress_res_not_ready);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_LOADING_CLICK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable l() {
        if (((SingleDressInfo) this.item).getIsRecommend() == 1) {
            return androidx.core.content.b.c(this.context, R.mipmap.ic_dress_tag_recommend);
        }
        if (((SingleDressInfo) this.item).getIsNew() == 1) {
            return androidx.core.content.b.c(this.context, R.mipmap.ic_dress_tag_new);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public SingleDressInfo getItem() {
        return (SingleDressInfo) super.getItem();
    }
}
