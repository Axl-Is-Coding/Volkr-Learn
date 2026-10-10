package com.sandboxol.blockmango.webvideo;

import android.content.Intent;
import android.os.Bundle;
import com.sandboxol.blockmango.config.GameStringConstant;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.game.R;
import com.sandboxol.game.a.AbstractC2664c;

/* JADX INFO: loaded from: classes2.dex */
public class WebVideoActivity extends BaseActivity<WebVideoViewModel, AbstractC2664c> {
    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_web_video;
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public void bindViewModel(AbstractC2664c abstractC2664c, WebVideoViewModel webVideoViewModel) {
        abstractC2664c.a(webVideoViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public WebVideoViewModel getViewModel() {
        Intent intent = getIntent();
        return new WebVideoViewModel(this, (AbstractC2664c) this.binding, intent != null ? intent.getStringExtra(GameStringConstant.WEB_VIDEO) : null);
    }
}
