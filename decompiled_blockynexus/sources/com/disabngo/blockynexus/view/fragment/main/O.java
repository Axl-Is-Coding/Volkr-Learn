package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.disabngo.blockynexus.e.b.y.C0958i;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.greendao.entity.FriendPartyStatus;
import com.sandboxol.imchat.web.error.PartyOnError;
import io.rong.imkit.RongContext;

/* JADX INFO: compiled from: OtherWayEnterGameLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class O extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f11784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ P f11785b;

    O(P p, PartyAuthInfo partyAuthInfo) {
        this.f11785b = p;
        this.f11784a = partyAuthInfo;
    }

    static /* synthetic */ void a(Context context, FriendPartyStatus friendPartyStatus, PartyAuthInfo partyAuthInfo, String str, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            new C0958i().a(context, friendPartyStatus.getGameId(), C0507d.a(friendPartyStatus, partyAuthInfo.getDispUrl(), partyAuthInfo.getRegion(), context.getString(R.string.party), str, partyAuthInfo.getEngineType(), partyAuthInfo.getCountry()), (ObservableField<Boolean>) null, (C0953d) null);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f11785b.f11786a, i);
        com.disabngo.blockynexus.d.n.a(this.f11785b.f11786a, "isPartyExist, " + i + ": " + str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f11785b.f11786a, i);
        com.disabngo.blockynexus.d.n.a(this.f11785b.f11786a, "isPartyExist, " + i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        if (TextUtils.isEmpty(this.f11785b.f11787b.getChatGroupId())) {
            Context context = this.f11785b.f11786a;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.party_chat_room_id_null));
            Context context2 = this.f11785b.f11786a;
            com.disabngo.blockynexus.d.n.a(context2, context2.getString(R.string.party_chat_room_id_null));
            return;
        }
        if (RongContext.getInstance() == null) {
            Context context3 = this.f11785b.f11786a;
            AppToastUtils.showShortNegativeTipToast(context3, context3.getString(R.string.party_chat_room_init_fail));
            Context context4 = this.f11785b.f11786a;
            com.disabngo.blockynexus.d.n.a(context4, context4.getString(R.string.party_chat_room_init_fail));
            return;
        }
        io.reactivex.p<Boolean> pVarRequest = new RxPermissions2((FragmentActivity) this.f11785b.f11786a).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        P p = this.f11785b;
        final Context context5 = p.f11786a;
        final FriendPartyStatus friendPartyStatus = p.f11787b;
        final PartyAuthInfo partyAuthInfo = this.f11784a;
        final String str2 = p.f11788c;
        pVarRequest.subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.fragment.main.p
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                O.a(context5, friendPartyStatus, partyAuthInfo, str2, (Boolean) obj);
            }
        }, new N(this));
    }
}
