package com.sandboxol.common.base.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import com.sandboxol.common.R;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.databinding.ActivitySingleTemplateBinding;
import com.sandboxol.common.utils.BeanUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SingleTemplateActivity extends BaseActivity<ViewModel, ActivitySingleTemplateBinding> implements View.OnClickListener {
    public static String LEFT_RESOURCE_ID = "template.left.resource.id";
    public static String NAME = "template.fragment.name";
    public static String PARAMS = "template.fragment.params";
    public static String RIGHT_RESOURCE_ID = "template.right.resource.id";
    public static String RIGHT_TEXT = "template.right.text";
    public static String TITLE = "template.title";
    private Fragment fragment;

    private void initFragment() {
        this.fragment = getSupportFragmentManager().a(R.id.flTemplateContainer);
        if (this.fragment == null) {
            this.fragment = BeanUtils.getFragment((Class) getIntent().getSerializableExtra(NAME));
            Bundle bundleExtra = getIntent().getBundleExtra(PARAMS);
            if (bundleExtra != null) {
                this.fragment.setArguments(bundleExtra);
            }
            F fA = getSupportFragmentManager().a();
            fA.a(0);
            fA.b(R.id.flTemplateContainer, this.fragment);
            fA.b();
        }
    }

    private void initToolBar() {
        ((ActivitySingleTemplateBinding) this.binding).tbTemplateBar.setTitle("");
        ((ActivitySingleTemplateBinding) this.binding).tvTemplateTitle.setText(getIntent().getStringExtra(TITLE));
        int intExtra = getIntent().getIntExtra(LEFT_RESOURCE_ID, -1);
        ImageButton imageButton = ((ActivitySingleTemplateBinding) this.binding).ibTemplateLeft;
        if (intExtra == -1) {
            intExtra = R.drawable.btn_back;
        }
        imageButton.setImageResource(intExtra);
        int intExtra2 = getIntent().getIntExtra(RIGHT_RESOURCE_ID, -1);
        if (intExtra2 != -1) {
            ((ActivitySingleTemplateBinding) this.binding).ibTemplateRight.setVisibility(0);
            ((ActivitySingleTemplateBinding) this.binding).ibTemplateRight.setImageResource(intExtra2);
        } else {
            ((ActivitySingleTemplateBinding) this.binding).ibTemplateRight.setVisibility(8);
        }
        ((ActivitySingleTemplateBinding) this.binding).ibTemplateLeft.setOnClickListener(this);
        ((ActivitySingleTemplateBinding) this.binding).ibTemplateRight.setOnClickListener(this);
        ((ActivitySingleTemplateBinding) this.binding).ibTemplateSecondRight.setOnClickListener(this);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_single_template;
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected ViewModel getViewModel() {
        return new ViewModel() { // from class: com.sandboxol.common.base.app.SingleTemplateActivity.1
        };
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment fragment = this.fragment;
        if (fragment != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = this.fragment;
        if (fragment == null || !(fragment instanceof TemplateFragment)) {
            return;
        }
        ((TemplateFragment) fragment).onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Fragment fragment;
        int id = view.getId();
        if (id == R.id.ibTemplateLeft) {
            Fragment fragment2 = this.fragment;
            if (fragment2 == null || !(fragment2 instanceof TemplateFragment)) {
                return;
            }
            ((TemplateFragment) fragment2).onLeftButtonClick(view);
            return;
        }
        if ((id == R.id.ibTemplateRight || id == R.id.tvTemplateRight) && (fragment = this.fragment) != null && (fragment instanceof TemplateFragment)) {
            ((TemplateFragment) fragment).onRightButtonClick(view);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setRequestedOrientation(1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public void bindViewModel(ActivitySingleTemplateBinding activitySingleTemplateBinding, ViewModel viewModel) {
        initToolBar();
        initFragment();
    }
}
