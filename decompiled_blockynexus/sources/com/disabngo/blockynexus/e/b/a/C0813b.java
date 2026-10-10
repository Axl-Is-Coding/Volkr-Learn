package com.disabngo.blockynexus.e.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.a.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AboutViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0813b extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f9614a = new ObservableField<>("");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f9615b = new ObservableField<>("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f9616c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f9617d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f9618e;

    public C0813b(Context context) {
        this.f9618e = context;
        i();
        f();
        h();
    }

    private void f() {
        String latelyRegion = AppInfoCenter.newInstance().getLatelyRegion();
        if (latelyRegion != null) {
            this.f9616c.set(this.f9618e.getString(R.string.game_region) + latelyRegion);
        }
    }

    private void h() {
        ObservableField<String> observableField = this.f9617d;
        Context context = this.f9618e;
        observableField.set(context.getString(R.string.decoration_version, String.valueOf(SharedUtils.getLong(context, SharedConstant.CLOTHES_RES_VERSION_CODE))));
    }

    private void i() {
        try {
            PackageInfo packageInfo = this.f9618e.getPackageManager().getPackageInfo(this.f9618e.getPackageName(), 0);
            this.f9614a.set(this.f9618e.getString(R.string.about_version) + packageInfo.versionName + " build " + packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        this.f9615b.set(this.f9618e.getString(R.string.about_game_code, Long.valueOf(EngineEnv.v1().getEngineVersion())) + ", " + EngineEnv.v2().getEngineVersion() + "," + EngineEnv.v3().getEngineVersion());
    }
}
