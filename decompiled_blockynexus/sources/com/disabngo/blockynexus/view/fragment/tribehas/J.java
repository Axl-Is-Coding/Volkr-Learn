package com.disabngo.blockynexus.view.fragment.tribehas;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.dialog.BottomDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.TribeMember;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeHasItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class J extends ListItemViewModel<TribeMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11976d;

    /* JADX WARN: Multi-variable type inference failed */
    public J(Context context, TribeMember tribeMember, boolean z) {
        Context context2;
        int i;
        super(context, tribeMember);
        if (((TribeMember) this.item).getRole() == 20) {
            context2 = this.context;
            i = R.string.tribe_chief;
        } else {
            context2 = this.context;
            i = R.string.tribe_elder;
        }
        this.f11973a = new ObservableField<>(context2.getString(i));
        this.f11975c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f12008a.f();
            }
        });
        this.f11976d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11998a.h();
            }
        });
        this.f11974b = z;
    }

    private int c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? R.string.tribe_sure_select_elder : R.string.tribe_sure_move_chief : R.string.tribe_sure_select_member : R.string.tribe_sure_select_elder;
    }

    private int d(int i) {
        return i != 1 ? i != 2 ? i != 3 ? R.string.tribe_select_elder : R.string.tribe_move_chief : R.string.tribe_select_member : R.string.tribe_select_elder;
    }

    private void j() {
        new BottomDialog(this.context).a(this.context.getString(R.string.tribe_remove_member), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.f
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f12002a.g(bottomDialog);
            }
        }).a(this.context.getString(R.string.cancel), C1169a.f11997a).show();
    }

    private void removeMember() {
        new TwoButtonDialog(this.context).setTitleText(this.context.getString(R.string.tribe_remove_member)).setDetailText(this.context.getString(R.string.tribe_sure_remove_member)).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.g
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f12003a.i();
            }
        }).show();
    }

    public /* synthetic */ void g(BottomDialog bottomDialog) {
        removeMember();
        bottomDialog.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void h() {
        if (!this.f11974b || AccountCenter.newInstance().userId.get().longValue() == ((TribeMember) this.item).getUserId()) {
            return;
        }
        int iIntValue = TribeCenter.newInstance().tribeRole.get().intValue();
        if (iIntValue != 10) {
            if (iIntValue != 20) {
                return;
            }
            f(((TribeMember) this.item).getRole());
        } else if (((TribeMember) this.item).getRole() == 0) {
            j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void i() {
        TribeApi.removeMember(this.context, ((TribeMember) this.item).getUserId(), new I(this));
    }

    public /* synthetic */ void a(BottomDialog bottomDialog) {
        e(3);
        bottomDialog.cancel();
    }

    public /* synthetic */ void b(BottomDialog bottomDialog) {
        e(2);
        bottomDialog.cancel();
    }

    public /* synthetic */ void c(BottomDialog bottomDialog) {
        removeMember();
        bottomDialog.cancel();
    }

    public /* synthetic */ void d(BottomDialog bottomDialog) {
        e(3);
        bottomDialog.cancel();
    }

    public /* synthetic */ void e(BottomDialog bottomDialog) {
        e(1);
        bottomDialog.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (((TribeMember) this.item).getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
            com.disabngo.blockynexus.e.b.x.J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((TribeMember) this.item).getUserId(), 2));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeMember getItem() {
        return (TribeMember) super.getItem();
    }

    private void e(final int i) {
        new TwoButtonDialog(this.context).setTitleText(this.context.getString(d(i))).setDetailText(this.context.getString(c(i))).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.j
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f12006a.b(i);
            }
        }).show();
    }

    private void f(int i) {
        if (i == 0) {
            new BottomDialog(this.context).a(this.context.getString(R.string.tribe_move_chief), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.c
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f11999a.d(bottomDialog);
                }
            }).a(this.context.getString(R.string.tribe_select_elder), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.l
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f12009a.e(bottomDialog);
                }
            }).a(this.context.getString(R.string.tribe_remove_member), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.e
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f12001a.f(bottomDialog);
                }
            }).a(this.context.getString(R.string.cancel), C1169a.f11997a).show();
        } else {
            if (i != 10) {
                return;
            }
            new BottomDialog(this.context).a(this.context.getString(R.string.tribe_move_chief), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.d
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f12000a.a(bottomDialog);
                }
            }).a(this.context.getString(R.string.tribe_select_member), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.i
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f12005a.b(bottomDialog);
                }
            }).a(this.context.getString(R.string.tribe_remove_member), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.h
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f12004a.c(bottomDialog);
                }
            }).a(this.context.getString(R.string.cancel), C1169a.f11997a).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void b(int i) {
        TribeApi.setIdentity(this.context, ((TribeMember) this.item).getUserId(), i, new H(this));
    }

    public /* synthetic */ void f(BottomDialog bottomDialog) {
        removeMember();
        bottomDialog.cancel();
    }
}
