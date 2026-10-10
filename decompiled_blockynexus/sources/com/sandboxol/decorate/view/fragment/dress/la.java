package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonEventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.dialog.LeaveDressShopDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressSuitItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class la extends ListItemViewModel<SuitDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f17437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f17438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f17439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f17440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f17441e;

    public la(Context context, SuitDressInfo suitDressInfo) {
        super(context, suitDressInfo);
        this.f17437a = new ObservableField<>(false);
        this.f17438b = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.l
            @Override // rx.functions.Action0
            public final void call() {
                this.f17436a.m();
            }
        });
        this.f17439c = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.n
            @Override // rx.functions.Action0
            public final void call() {
                this.f17445a.l();
            }
        });
        this.f17440d = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f17449a.h();
            }
        });
        this.f17441e = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f17435a.i();
            }
        });
        initView();
    }

    private void a(boolean z) {
        if (!z) {
            com.sandboxol.decorate.manager.f.e().b().a(this.context, this.item);
        } else {
            com.sandboxol.decorate.manager.f.e().k().a(this.context, this.item);
            ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_RECOMMEND_CLICK);
        }
    }

    private void b(boolean z) {
        if (z) {
            com.sandboxol.decorate.manager.f.e().l().a(this.context, this.item);
        } else {
            com.sandboxol.decorate.manager.f.e().c().a(this.context, this.item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        T t = this.item;
        if (t != 0 && ((SuitDressInfo) t).getDecorationInfoList() != null) {
            a((SuitDressInfo) this.item);
        }
        T t2 = this.item;
        if (t2 == 0 || ((SuitDressInfo) t2).getDecorationInfoList() == null || ((SuitDressInfo) this.item).getDecorationInfoList().size() <= 0) {
            return;
        }
        if (com.sandboxol.decorate.manager.o.a().a(((SuitDressInfo) this.item).getDecorationInfoList().get(0).getResourceId())) {
            this.f17437a.set(true);
        } else {
            com.sandboxol.decorate.manager.q.a(com.sandboxol.decorate.manager.q.a(), ((SuitDressInfo) this.item).getDecorationInfoList().get(0).getResourceId(), this.f17437a);
            com.sandboxol.decorate.f.j.a(((SuitDressInfo) this.item).getDecorationInfoList().get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((SuitDressInfo) this.item).getSuitId()));
        new LeaveDressShopDialog(this.context, ((SuitDressInfo) this.item).getActivityFlag()).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.fragment.dress.m
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
        Observable.from(((SuitDressInfo) this.item).getDecorationInfoList()).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.fragment.dress.p
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                la.a(map, (SingleDressInfo) obj);
            }
        });
        new com.sandboxol.decorate.view.activity.dress.K().a(this.context, map);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_RECOMMEND_PRICE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f() {
        return ((SuitDressInfo) this.item).getExpire() < 0 ? this.context.getString(R.string.decorate_time_limit) : this.context.getString(R.string.decorate_left_days, Integer.valueOf(((SuitDressInfo) this.item).getExpire()));
    }

    public /* synthetic */ void h() {
        AppToastUtils.showShortNegativeTipToast(this.context, R.string.decorate_dress_res_not_ready);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_LOADING_CLICK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void i() {
        if (com.sandboxol.decorate.manager.v.a().f17215d.contains(Long.valueOf(((SuitDressInfo) this.item).getSuitId()))) {
            b(((SuitDressInfo) this.item).isDressRec());
        } else {
            a(((SuitDressInfo) this.item).isDressRec());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable k() {
        if (((SuitDressInfo) this.item).getIsRecommend() == 1) {
            return androidx.core.content.b.c(this.context, R.mipmap.ic_dress_tag_recommend);
        }
        if (((SuitDressInfo) this.item).getIsNew() == 1) {
            return androidx.core.content.b.c(this.context, R.mipmap.ic_dress_tag_new);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public SuitDressInfo getItem() {
        return (SuitDressInfo) super.getItem();
    }

    private void a(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            if (!com.sandboxol.decorate.manager.v.a().f17213b.containsValue(it.next().getResourceId())) {
                return;
            }
        }
        com.sandboxol.decorate.manager.v.a().f17215d.clear();
        com.sandboxol.decorate.manager.v.a().f17215d.add(Long.valueOf(suitDressInfo.getSuitId()));
        ArrayList arrayList = new ArrayList();
        for (SingleDressInfo singleDressInfo : suitDressInfo.getDecorationInfoList()) {
            arrayList.add(Long.valueOf(singleDressInfo.getTypeId()));
            if (com.sandboxol.decorate.manager.n.a(singleDressInfo)) {
                arrayList.addAll(singleDressInfo.getOccupyPosition());
            }
        }
        com.sandboxol.decorate.manager.n.b().a(arrayList);
    }

    static /* synthetic */ void a(HashMap map, SingleDressInfo singleDressInfo) {
    }
}
