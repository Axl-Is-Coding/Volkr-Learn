package com.disabngo.blockynexus.view.fragment.partyhall;

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
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.imchat.web.error.PartyOnError;
import io.rong.imkit.RongContext;

/* JADX INFO: compiled from: PartyHallItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PartyAuthInfo f11941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f11942b;

    s(t tVar, PartyAuthInfo partyAuthInfo) {
        this.f11942b = tVar;
        this.f11941a = partyAuthInfo;
    }

    public /* synthetic */ void a(PartyAuthInfo partyAuthInfo, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            new C0958i().a(((ListItemViewModel) this.f11942b.f11943a).context, ((PartyItem) ((ListItemViewModel) this.f11942b.f11943a).item).getGameType(), C0507d.a((PartyItem) ((ListItemViewModel) this.f11942b.f11943a).item, partyAuthInfo.getDispUrl(), partyAuthInfo.getRegion(), 2, partyAuthInfo.getCountry()), (ObservableField<Boolean>) null, (C0953d) null);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(((ListItemViewModel) this.f11942b.f11943a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(((ListItemViewModel) this.f11942b.f11943a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        if (TextUtils.isEmpty(((PartyItem) ((ListItemViewModel) this.f11942b.f11943a).item).getChatGroupId())) {
            AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f11942b.f11943a).context, ((ListItemViewModel) this.f11942b.f11943a).context.getString(R.string.party_chat_room_id_null));
        } else {
            if (RongContext.getInstance() == null) {
                AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f11942b.f11943a).context, ((ListItemViewModel) this.f11942b.f11943a).context.getString(R.string.party_chat_room_init_fail));
                return;
            }
            io.reactivex.p<Boolean> pVarRequest = new RxPermissions2((FragmentActivity) ((ListItemViewModel) this.f11942b.f11943a).context).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            final PartyAuthInfo partyAuthInfo = this.f11941a;
            pVarRequest.subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.view.fragment.partyhall.a
                @Override // io.reactivex.b.g
                public final void accept(Object obj) throws Exception {
                    this.f11906a.a(partyAuthInfo, (Boolean) obj);
                }
            }, new r(this));
        }
    }
}
