package com.sandboxol.halloween.view.fragment.exchange;

import androidx.databinding.ObservableField;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: ExchangeFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class o extends BaseFragment<ExchangeViewModel, com.sandboxol.halloween.b.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<Integer> f18727a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandboxol.halloween.b.i iVar, ExchangeViewModel exchangeViewModel) {
        iVar.a(exchangeViewModel);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.halloween_fragment_exchange;
    }

    public void a(ObservableField<Integer> observableField) {
        this.f18727a = observableField;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public ExchangeViewModel getViewModel() {
        return new ExchangeViewModel(this.context, this.f18727a);
    }
}
