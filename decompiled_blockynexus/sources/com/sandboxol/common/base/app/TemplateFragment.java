package com.sandboxol.common.base.app;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.base.viewmodel.ViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TemplateFragment<VM extends ViewModel, D extends ViewDataBinding> extends BaseFragment<VM, D> {
    public void onBackPressed() {
    }

    public void onLeftButtonClick(View view) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void onRightButtonClick(View view) {
    }
}
