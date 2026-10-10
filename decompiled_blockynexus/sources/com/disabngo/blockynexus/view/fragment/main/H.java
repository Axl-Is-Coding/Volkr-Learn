package com.disabngo.blockynexus.view.fragment.main;

import android.annotation.SuppressLint;
import android.view.animation.Animation;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.De;
import com.disabngo.blockynexus.view.activity.main.nc;
import com.sandboxol.center.aims.MainPageAnimation;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: MainFragment.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ValidFragment"})
public class H extends BaseFragment<MainFragmentViewModel, De> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11769a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MainFragmentViewModel f11770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private nc f11771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11772d;

    public H(nc ncVar) {
        this.f11771c = ncVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(De de, MainFragmentViewModel mainFragmentViewModel) {
        de.a(mainFragmentViewModel);
        de.a(this.f11771c);
    }

    public String g() {
        return this.f11772d;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (!this.f11769a) {
            return new MainPageAnimation(z, 0);
        }
        this.f11769a = false;
        return super.onCreateAnimation(i, z, i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            MainFragmentViewModel mainFragmentViewModel = this.f11770b;
            if (mainFragmentViewModel != null) {
                mainFragmentViewModel.stopTimer();
                return;
            }
            return;
        }
        MainFragmentViewModel mainFragmentViewModel2 = this.f11770b;
        if (mainFragmentViewModel2 != null) {
            mainFragmentViewModel2.startTimer();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MainFragmentViewModel mainFragmentViewModel = this.f11770b;
        if (mainFragmentViewModel != null) {
            mainFragmentViewModel.stopTimer();
        }
        this.f11770b.setClosePage(true);
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MainFragmentViewModel mainFragmentViewModel = this.f11770b;
        if (mainFragmentViewModel != null) {
            mainFragmentViewModel.startTimer();
        }
        this.f11770b.setClosePage(false);
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public MainFragmentViewModel getViewModel() {
        this.f11770b = new MainFragmentViewModel(this.activity, (De) this.binding);
        return this.f11770b;
    }

    public void a(String str) {
        this.f11772d = str;
    }
}
