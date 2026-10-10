package com.disabngo.blockynexus.e.b.ta;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding._f;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TribeShopCarFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<h, _f> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(_f _fVar, h hVar) {
        _fVar.a(hVar);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_shop_car;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause((Activity) this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume((Activity) this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public h getViewModel() {
        List arrayList = (List) getArguments().getSerializable("tribe.shop.car.goods.list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return new h(this.context, arrayList);
    }
}
