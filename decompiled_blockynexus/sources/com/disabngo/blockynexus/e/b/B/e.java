package com.disabngo.blockynexus.e.b.B;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupChatItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ListItemViewModel<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<GroupMember> f9112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f9113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f9114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.adapter.e<String> f9115d;

    public e(Context context, GroupInfo groupInfo) {
        super(context, groupInfo);
        this.f9113b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.B.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9109a.f();
            }
        });
        this.f9114c = new ObservableField<>(false);
        this.f9115d = new d(this);
        this.f9112a = groupInfo.getGroupMembers();
        this.f9114c.set(Boolean.valueOf(groupInfo.getOfficialGroup() == 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (y.b().h()) {
            N.a(this.context, (GroupInfo) this.item, y.b().d(), y.b().i());
        } else {
            y.b().f((GroupInfo) this.item);
            N.a(this.context, String.valueOf(((GroupInfo) this.item).getGroupId()), TextEllipsizeUtil.ellipsizeString(20, y.b().c(((GroupInfo) this.item).getGroupId()), TextEllipsizeUtil.SignLib.END_POINT), false, y.b().f(((GroupInfo) this.item).getGroupId()));
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        y.b().a(false);
        y.b().b((String) null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupInfo getItem() {
        return (GroupInfo) super.getItem();
    }
}
