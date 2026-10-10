package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.UserSignInList;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActivitySignUpItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ListItemViewModel<UserSignInList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f11450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserSignInResponse f11451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f11452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f11453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f11454e;

    public e(Context context, d dVar, UserSignInResponse userSignInResponse, UserSignInList userSignInList) {
        super(context, userSignInList);
        this.f11453d = new ObservableField<>();
        this.f11454e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11447a.f();
            }
        });
        this.f11450a = dVar;
        this.f11451b = userSignInResponse;
        a(context, userSignInResponse, userSignInList);
    }

    private void a(Context context, UserSignInResponse userSignInResponse, UserSignInList userSignInList) {
        this.f11453d.set(context.getString(R.string.activity_day, Integer.valueOf(userSignInList.getSignInId())));
        List<UserSignInList> userSignInList2 = userSignInResponse.getUserSignInList();
        if (userSignInList2.size() <= 0 || userSignInList2.get(userSignInList2.size() - 1).getRewards().size() <= 1) {
            return;
        }
        this.f11452c = new j(context, R.string.no_data, userSignInList2.get(userSignInList2.size() - 1).getRewards());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        if (((UserSignInList) this.item).isSelect()) {
            new h().a(this.context, this.f11450a, this.f11451b);
        } else if (((UserSignInList) this.item).getStatus() == 1) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.sign_in_has_get);
        } else {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.activity_not_get_reward);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public UserSignInList getItem() {
        return (UserSignInList) super.getItem();
    }
}
