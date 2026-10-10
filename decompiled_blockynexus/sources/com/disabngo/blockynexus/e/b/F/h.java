package com.disabngo.blockynexus.e.b.F;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupMemberItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ListItemViewModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f9250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f9251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f9252c;
    public Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Drawable> f9253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9254e;

    /* JADX INFO: compiled from: GroupMemberItemViewModel.java */
    public interface a {
    }

    public h(Context context, GroupMember groupMember, boolean z, u uVar) {
        super(context, groupMember);
        this.f9251b = new ObservableField<>(false);
        this.f9252c = new ObservableField<>(true);
        this.f9253d = new ObservableField<>();
        this.f9254e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.F.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9241a.h();
            }
        });
        this.context = context;
        this.f9252c.set(Boolean.valueOf(z));
        this.f9250a = uVar;
        f();
    }

    private void b(int i) {
        if (i == 0) {
            if (this.f9250a.g.size() > 1) {
                this.f9250a.n.set(true);
                return;
            }
            return;
        }
        if (i == 1) {
            u uVar = this.f9250a;
            uVar.o.set(Boolean.valueOf(uVar.g.size() > 0));
            u uVar2 = this.f9250a;
            uVar2.p.set(Boolean.valueOf(uVar2.g.size() > 0));
            this.f9250a.b(1);
            return;
        }
        if (i != 2) {
            return;
        }
        u uVar3 = this.f9250a;
        uVar3.o.set(Boolean.valueOf(uVar3.g.size() > 0));
        u uVar4 = this.f9250a;
        uVar4.p.set(Boolean.valueOf(uVar4.g.size() > 0));
    }

    private void c(int i) {
        if (i == 0) {
            u uVar = this.f9250a;
            uVar.n.set(Boolean.valueOf(uVar.g.size() >= 2));
            return;
        }
        if (i == 1) {
            u uVar2 = this.f9250a;
            uVar2.o.set(Boolean.valueOf(uVar2.g.size() >= 1));
            u uVar3 = this.f9250a;
            uVar3.p.set(Boolean.valueOf(uVar3.g.size() >= 1));
            this.f9250a.b(-1);
            return;
        }
        if (i != 2) {
            return;
        }
        u uVar4 = this.f9250a;
        uVar4.o.set(Boolean.valueOf(uVar4.g.size() >= 1));
        u uVar5 = this.f9250a;
        uVar5.p.set(Boolean.valueOf(uVar5.g.size() >= 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        if (y.b().a(((GroupMember) this.item).getIdentity()).equals(this.context.getString(R.string.admi))) {
            this.f9253d.set(this.context.getResources().getDrawable(R.drawable.bg_group_identity_admin));
        } else if (y.b().a(((GroupMember) this.item).getIdentity()).equals(this.context.getString(R.string.group_owner))) {
            this.f9253d.set(this.context.getResources().getDrawable(R.drawable.bg_group_identiy_owner));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (((GroupMember) this.item).getUserId() == 32 || ((GroupMember) this.item).getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
            return;
        }
        Long lValueOf = 0L;
        try {
            lValueOf = Long.valueOf(((GroupMember) this.item).getUserId());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        J.a(this.context, (Friend) null, new FriendActivityIntentInfo(lValueOf.longValue(), 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if (this.f9250a.g == null) {
            return;
        }
        CheckBox checkBox = (CheckBox) view;
        long userId = ((GroupMember) this.item).getUserId();
        if (!checkBox.isChecked()) {
            this.f9251b.set(false);
            if (this.f9250a.g.contains(Long.valueOf(userId))) {
                this.f9250a.g.remove(Long.valueOf(userId));
                c(this.f9250a.f9279b);
                return;
            }
            return;
        }
        u uVar = this.f9250a;
        if (uVar.f9279b != 1 || uVar.j != 1) {
            if (this.f9250a.g.contains(Long.valueOf(userId))) {
                return;
            }
            this.f9250a.g.add(Long.valueOf(userId));
            this.f9251b.set(true);
            b(this.f9250a.f9279b);
            return;
        }
        if (uVar.g.size() >= this.f9250a.x.get().intValue() || this.f9250a.g.contains(Long.valueOf(userId))) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.new_group_error_8109);
            checkBox.setChecked(false);
            this.f9251b.set(false);
        } else {
            this.f9250a.g.add(Long.valueOf(userId));
            this.f9251b.set(true);
            b(this.f9250a.f9279b);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupMember getItem() {
        return (GroupMember) super.getItem();
    }
}
