package com.sandbox.login.f.a.f;

import android.os.Build;
import android.util.Log;
import com.sandbox.login.R;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: RegisterStep1ViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f15884a;

    h(i iVar) {
        this.f15884a = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (!bool.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f15884a.f15885a.f15889b.f15618f.setHelperTextColor(this.f15884a.f15885a.f15888a.getColorStateList(R.color.login_tips_color_1));
            }
            this.f15884a.f15885a.f15889b.f15618f.setHelperText(this.f15884a.f15885a.f15888a.getString(R.string.base_set_account_exits));
        } else {
            this.f15884a.f15885a.f();
            Messenger.getDefault().send(this.f15884a.f15885a.f15890c, "token.do.next.step");
            this.f15884a.f15885a.f15889b.g.setHelperText("");
            this.f15884a.f15885a.f15889b.h.setHelperText("");
            this.f15884a.f15885a.f15889b.f15618f.setHelperText("");
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i != 1013) {
            this.f15884a.f15885a.f15889b.f15618f.setHelperText("");
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15884a.f15885a.f15889b.f15618f.setHelperTextColor(this.f15884a.f15885a.f15888a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15884a.f15885a.f15889b.f15618f.setHelperText(this.f15884a.f15885a.f15888a.getString(R.string.base_set_account_error));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f15884a.f15885a.f15889b.f15618f.setHelperText("");
        Log.e("error", "code :" + i);
    }
}
