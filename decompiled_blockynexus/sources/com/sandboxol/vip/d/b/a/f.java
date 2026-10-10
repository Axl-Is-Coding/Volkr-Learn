package com.sandboxol.vip.d.b.a;

import android.os.Bundle;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.vip.R;
import com.sandboxol.vip.b.o;

/* JADX INFO: compiled from: PrivilegeDetailFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends TemplateFragment<h, o> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(o oVar, h hVar) {
        oVar.a(hVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.vip_fragment_privilege_detail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public h getViewModel() {
        String str;
        int i;
        boolean z;
        Bundle arguments = getArguments();
        String string = getString(R.string.vip_privilege_list_item_title_1);
        if (arguments != null) {
            int i2 = arguments.getInt("vip.type", 1);
            String string2 = arguments.getString("privilege.title", getString(R.string.vip_privilege_list_item_title_1));
            z = arguments.getBoolean("is.subscribed", false);
            str = string2;
            i = i2;
        } else {
            str = string;
            i = 1;
            z = false;
        }
        ((o) this.binding).n.setPageTransformer(false, new i());
        return new h(this.context, i, z, str, (o) this.binding);
    }
}
