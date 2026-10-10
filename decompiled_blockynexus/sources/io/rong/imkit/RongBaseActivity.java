package io.rong.imkit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import io.rong.imkit.utilities.LangUtils;
import io.rong.imkit.utilities.PermissionCheckUtil;

/* JADX INFO: loaded from: classes5.dex */
public class RongBaseActivity extends Activity {
    private ViewFlipper mContentView;
    protected ImageView searchButton;
    protected TextView title;
    protected ViewGroup titleContainer;

    public class ActionBar {
        public ActionBar() {
        }

        public View setActionBar(int i) {
            RongBaseActivity.this.titleContainer.removeAllViews();
            RongBaseActivity.this.titleContainer.setBackgroundColor(0);
            return LayoutInflater.from(RongBaseActivity.this).inflate(i, RongBaseActivity.this.titleContainer);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LangUtils.getConfigurationContext(context));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.rc_base_activity_layout);
        this.titleContainer = (ViewGroup) findViewById(R.id.rc_ac_ll_base_title);
        this.searchButton = (ImageView) findViewById(R.id.rc_search);
        this.title = (TextView) findViewById(R.id.rc_action_bar_title);
        findViewById(R.id.rc_action_bar_back).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.RongBaseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RongBaseActivity.this.finish();
            }
        });
        this.mContentView = (ViewFlipper) findViewById(R.id.rc_base_container);
    }

    protected void onCreateActionbar(ActionBar actionBar) {
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (PermissionCheckUtil.checkPermissions(this, strArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else {
            PermissionCheckUtil.showRequestPermissionFailedAlter(this, PermissionCheckUtil.getNotGrantedPermissionMsg(this, strArr, iArr));
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.mContentView.addView(LayoutInflater.from(this).inflate(i, (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1, 1.0f));
    }
}
