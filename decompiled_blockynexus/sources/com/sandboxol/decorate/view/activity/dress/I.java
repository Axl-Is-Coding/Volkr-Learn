package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
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

/* JADX INFO: compiled from: DressShopItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class I extends ListItemViewModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f17230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f17231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f17232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f17233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f17234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f17235f;
    public ReplyCommand g;

    public I(Context context, SingleDressInfo singleDressInfo) {
        super(context, singleDressInfo);
        this.f17230a = new ObservableField<>(false);
        this.f17231b = new ObservableField<>();
        this.f17232c = new ObservableField<>();
        this.f17233d = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f17276a.m();
            }
        });
        this.f17234e = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f17275a.l();
            }
        });
        this.f17235f = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f17273a.f();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f17274a.h();
            }
        });
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.f17231b.set(this.context.getString(R.string.decorate_new_dress_time_reminder, String.valueOf(((SingleDressInfo) this.item).getRemainingDays())));
        this.f17232c.set(Integer.valueOf(((SingleDressInfo) this.item).getSuitId() == 0 ? ((SingleDressInfo) this.item).getPrice() : (int) ((SingleDressInfo) this.item).getSuitPrice()));
        if (com.sandboxol.decorate.manager.o.a().a(((SingleDressInfo) this.item).getResourceId())) {
            this.f17230a.set(true);
        } else {
            com.sandboxol.decorate.manager.q.a(com.sandboxol.decorate.manager.q.b(), ((SingleDressInfo) this.item).getResourceId(), this.f17230a);
            com.sandboxol.decorate.f.j.a((SingleDressInfo) this.item);
        }
    }

    private void k() {
        com.sandboxol.decorate.manager.f.e().f().a(this.context, this.item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((SingleDressInfo) this.item).getId()));
        new LeaveDressShopDialog(this.context, ((SingleDressInfo) this.item).getActivityFlag()).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.activity.dress.b
            @Override // com.sandboxol.decorate.view.dialog.LeaveDressShopDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        HashMap map = new HashMap();
        map.put(Long.valueOf(((SingleDressInfo) this.item).getTypeId()), new ShopRecommendDecorationInfo((SingleDressInfo) this.item));
        new K().a(this.context, map);
    }

    private void p() {
        com.sandboxol.decorate.manager.f.e().i().a(this.context, this.item);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (com.sandboxol.decorate.manager.v.b().f17213b.containsValue(((SingleDressInfo) this.item).getResourceId())) {
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
