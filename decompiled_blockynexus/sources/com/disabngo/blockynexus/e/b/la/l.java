package com.disabngo.blockynexus.e.b.la;

import android.app.Activity;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.B;
import com.disabngo.blockynexus.entity.TribeClanRequest;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.List;

/* JADX INFO: compiled from: TribeCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f9917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f9918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Boolean> f9919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9920d;

    public l(Activity activity, h hVar, ObservableField<Boolean> observableField) {
        this.f9917a = activity;
        this.f9918b = hVar;
        this.f9919c = observableField;
    }

    public void a() {
        B.b().b(this.f9917a, this.f9918b);
    }

    public void a(List<String> list, String str, String str2, int i) {
        if (a(list, str2, str)) {
            return;
        }
        if (this.f9918b.g() != null && this.f9918b.h() != null) {
            a(list, str, str2, i, 1);
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f9917a, R.string.tribe_icon_empty);
        }
    }

    public void a(List<String> list, String str, String str2, String str3, Long l) {
        this.f9920d = l.longValue();
        if (a(list, str2, str)) {
            return;
        }
        if (this.f9918b.g() != null && this.f9918b.h() != null) {
            a(list, str, str2, 0, 2);
        } else {
            a(str3, list, str, str2);
        }
    }

    private void a(List<String> list, String str, String str2, int i, int i2) {
        UserApi.uploadIcon(this.f9917a, this.f9918b.g(), this.f9918b.h(), new i(this, i2, str, list, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, List<String> list, String str3, int i) {
        this.f9919c.set(false);
        ReportDataAdapter.onEvent(this.f9917a, EventConstant.CLAN_BUILD_SURE);
        TribeApi.clanRequest(this.f9917a, new TribeClanRequest(str3, str, str2, list, i), new j(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list, String str2, String str3) {
        this.f9919c.set(false);
        TribeApi.clanUpdate(this.f9917a, new TribeClanRequest(this.f9920d, str3, str, str2, list), new k(this));
    }

    private boolean a(List<String> list, String str, String str2) {
        if (!AccountCenter.newInstance().login.get().booleanValue()) {
            AppToastUtils.showShortNegativeTipToast(this.f9917a, R.string.not_login);
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            AppToastUtils.showShortNegativeTipToast(this.f9917a, R.string.tribe_name_empty);
            return true;
        }
        if (list.size() == 0) {
            AppToastUtils.showShortNegativeTipToast(this.f9917a, R.string.tribe_label_empty);
            return true;
        }
        if (list.size() > 4) {
            AppToastUtils.showShortNegativeTipToast(this.f9917a, R.string.tribe_label_max);
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        AppToastUtils.showShortNegativeTipToast(this.f9917a, R.string.tribe_introduction_empty);
        return true;
    }
}
