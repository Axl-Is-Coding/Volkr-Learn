package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.C0507d;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.disabngo.blockynexus.e.b.y.C0958i;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.imchat.web.error.PartyOnError;
import io.rong.imkit.RongContext;

/* JADX INFO: compiled from: PartyHallModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PartyItem f11884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f11885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f11886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ E f11887d;

    C(E e2, PartyItem partyItem, Context context, PartyAuthInfo partyAuthInfo) {
        this.f11887d = e2;
        this.f11884a = partyItem;
        this.f11885b = context;
        this.f11886c = partyAuthInfo;
    }

    public /* synthetic */ void a(PartyItem partyItem, Context context, PartyAuthInfo partyAuthInfo, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.f11887d.f11894f.put(Long.valueOf(System.currentTimeMillis()), partyItem.getTeamId());
            this.f11887d.b(partyItem.getTeamId());
            this.f11887d.c();
            new C0958i().a(context, partyItem.getGameType(), C0507d.a(partyItem, partyAuthInfo.getDispUrl(), partyAuthInfo.getRegion(), 4, partyAuthInfo.getCountry()), (ObservableField<Boolean>) null, (C0953d) null);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f11885b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f11885b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        if (TextUtils.isEmpty(this.f11884a.getChatGroupId())) {
            Context context = this.f11885b;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.party_chat_room_id_null));
        } else {
            if (RongContext.getInstance() == null) {
                Context context2 = this.f11885b;
                AppToastUtils.showShortNegativeTipToast(context2, context2.getString(R.string.party_chat_room_init_fail));
                return;
            }
            io.reactivex.p<Boolean> pVarRequest = new RxPermissions2((FragmentActivity) this.f11885b).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            final PartyItem partyItem = this.f11884a;
            final Context context3 = this.f11885b;
            final PartyAuthInfo partyAuthInfo = this.f11886c;
            pVarRequest.subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.e
                @Override // io.reactivex.b.g
                public final void accept(Object obj) throws Exception {
                    this.f11911a.a(partyItem, context3, partyAuthInfo, (Boolean) obj);
                }
            }, new B(this));
        }
    }
}
