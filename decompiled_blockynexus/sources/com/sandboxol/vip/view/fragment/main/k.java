package com.sandboxol.vip.view.fragment.main;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.vip.R;
import com.sandboxol.vip.entity.PrivilegeInfo;
import rx.functions.Action0;

/* JADX INFO: compiled from: MorePrivilegeItemViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends ListItemViewModel<PrivilegeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<Boolean> f19098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f19099b;

    public k(Context context, PrivilegeInfo privilegeInfo, ObservableField<Boolean> observableField) {
        super(context, privilegeInfo);
        this.f19099b = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f19088a.f();
            }
        });
        this.f19098a = observableField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (this.f19098a.get().booleanValue()) {
            Bundle bundle = new Bundle();
            T t = this.item;
            int vipType = t != 0 ? ((PrivilegeInfo) t).getVipType() : 1;
            T t2 = this.item;
            String title = t2 != 0 ? ((PrivilegeInfo) t2).getTitle() : this.context.getString(R.string.vip_privilege_list_item_title_1);
            bundle.putInt("vip.type", vipType);
            bundle.putBoolean("is.subscribed", com.sandboxol.vip.c.a.d(vipType));
            bundle.putString("privilege.title", title);
            Context context = this.context;
            TemplateUtils.startTemplate(context, com.sandboxol.vip.d.b.a.f.class, context.getString(R.string.vip_privilege_detail_title), bundle);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public PrivilegeInfo getItem() {
        return (PrivilegeInfo) super.getItem();
    }
}
