package com.disabngo.blockynexus.e.b.S;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Cd;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PartyCreateFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends TemplateFragment<v, Cd> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Cd cd, v vVar) {
        cd.a(vVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_create_party;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public v getViewModel() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return new v(this.context, (Cd) this.binding, new ArrayList());
        }
        return new v(this.context, (Cd) this.binding, (List) new com.google.gson.j().a(arguments.getString(StringConstant.PARTY_CREATE_ALL_GAME_ID_INFO), new k(this).getType()));
    }
}
