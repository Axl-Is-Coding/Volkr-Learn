package com.sandboxol.common.base.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.base.viewmodel.ViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseFragment<VM extends ViewModel, D extends ViewDataBinding> extends com.trello.rxlifecycle.components.support.a {
    protected Activity activity;
    protected D binding;
    protected Context context;
    protected VM viewModel;

    protected void bindData() {
    }

    protected void bindView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.binding == null) {
            this.binding = (D) e.a(layoutInflater, getLayoutId(), viewGroup, false);
            this.viewModel = (VM) getViewModel();
            bindViewModel(this.binding, this.viewModel);
        }
    }

    protected abstract void bindViewModel(D d2, VM vm);

    protected abstract int getLayoutId();

    protected abstract VM getViewModel();

    protected boolean isClearViewModel() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.context = getContext();
        this.activity = getActivity();
        bindView(layoutInflater, viewGroup);
        VM vm = this.viewModel;
        if (vm != null) {
            vm.onCreate();
        }
        return this.binding.getRoot();
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        VM vm;
        super.onDestroy();
        if (!isClearViewModel() || (vm = this.viewModel) == null) {
            return;
        }
        vm.onDestroy();
        this.viewModel = null;
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VM vm = this.viewModel;
        if (vm != null) {
            vm.onPause();
        }
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        bindData();
        VM vm = this.viewModel;
        if (vm != null) {
            vm.onResume();
        }
    }
}
