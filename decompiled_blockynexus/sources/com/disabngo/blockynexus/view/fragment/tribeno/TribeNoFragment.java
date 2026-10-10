package com.disabngo.blockynexus.view.fragment.tribeno;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Sf;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class TribeNoFragment extends BaseActivity<m, Sf> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Sf sf, m mVar) {
        sf.a(mVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.fragment_tribe_no;
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public m getViewModel() {
        return new m(this);
    }
}
