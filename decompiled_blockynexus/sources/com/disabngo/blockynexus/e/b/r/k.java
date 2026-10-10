package com.disabngo.blockynexus.e.b.r;

import android.view.View;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Gd;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: DiskSpaceFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends TemplateFragment<v, Gd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<Boolean> f10110a = new ObservableField<>(false);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Gd gd, v vVar) {
        gd.a(vVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_disk_space;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        if (this.f10110a.get().booleanValue()) {
            AppToastUtils.showShortPositiveTipToast(this.context, R.string.app_disk_game_manage_clean);
            return;
        }
        super.onBackPressed();
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onLeftButtonClick(View view) {
        if (this.f10110a.get().booleanValue()) {
            AppToastUtils.showShortPositiveTipToast(this.context, R.string.app_disk_game_manage_clean);
        } else {
            super.onLeftButtonClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public v getViewModel() {
        return new v(this.context, this.f10110a);
    }
}
