package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class y implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FriendActivityIntentInfo f10693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Friend f10694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f10695d;

    y(F f2, Context context, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend) {
        this.f10695d = f2;
        this.f10692a = context;
        this.f10693b = friendActivityIntentInfo;
        this.f10694c = friend;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10695d.b(this.f10692a, this.f10693b, this.f10694c);
        } else {
            this.f10695d.a(this.f10692a, this.f10693b, this.f10694c, str);
        }
    }
}
