package io.rong.imkit.activity;

import android.os.Bundle;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import io.rong.common.dlog.DLog;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.fragment.FileListFragment;

/* JADX INFO: loaded from: classes5.dex */
public class FileListActivity extends RongBaseNoActionbarActivity {
    private int fragmentCount = 0;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = this.fragmentCount - 1;
        this.fragmentCount = i;
        if (i != 0) {
            super.onBackPressed();
            return;
        }
        AbstractC0336n supportFragmentManager = getSupportFragmentManager();
        for (int i2 = 0; i2 < supportFragmentManager.c(); i2++) {
            Fragment fragmentA = supportFragmentManager.a(supportFragmentManager.b(i2).getName());
            if (fragmentA != null) {
                fragmentA.onDestroy();
            }
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(DLog.CRS, DLog.CRS);
        requestWindowFeature(1);
        setContentView(R.layout.rc_ac_file_list);
        if (getSupportFragmentManager().a(R.id.rc_ac_fl_storage_folder_list_fragment) == null) {
            showFragment(new FileListFragment());
        }
    }

    public void showFragment(Fragment fragment) {
        this.fragmentCount++;
        F fA = getSupportFragmentManager().a();
        fA.a(this.fragmentCount + "");
        fA.b(R.id.rc_ac_fl_storage_folder_list_fragment, fragment);
        fA.b();
    }
}
