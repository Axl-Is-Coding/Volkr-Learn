package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.WheelPicker;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.m.C0870b;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.IconUploadHelper;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.User;
import java.util.Calendar;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateUserInfoViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f12048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f12049b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f12051d = new ObservableField<>("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f12052e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f12053f = new ObservableField<>(false);
    public ObservableField<Boolean> g = new ObservableField<>(false);
    public ObservableField<Boolean> h = new ObservableField<>(false);
    public ObservableField<Integer> i = new ObservableField<>();
    public ObservableField<String> j = new ObservableField<>();
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f12055a.onClickNickName();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f12054a.onClickDetail();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f12058a.onClickSex();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f12056a.h();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f12057a.onClickBirthday();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f12061a.i();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private User f12050c = new User();

    public UpdateUserInfoViewModel(Context context, i iVar) {
        this.f12048a = context;
        this.f12049b = iVar;
        this.f12051d.set(context.getString(AccountCenter.newInstance().sex.get().intValue() == 1 ? R.string.account_male : R.string.account_female));
        initData();
        initMessenger();
    }

    private void initData() {
        if (SharedUtils.getLong(this.f12048a, SharedConstant.IS_REWARD_UPDATE_USER_INFO_GIFT, 0L) != AccountCenter.newInstance().userId.get().longValue()) {
            new j(this.f12050c).a(this.f12048a, new k(this));
        } else {
            this.f12053f.set(false);
        }
        if (TextUtils.isEmpty(AccountCenter.newInstance().detail.get())) {
            if (!SharedUtils.getBoolean(this.f12048a, AccountCenter.newInstance().userId.get() + SharedConstant.FRIEND_MATCH_IS_PERFECT_DATA, false)) {
                this.f12052e.set(true);
            }
        }
        this.g.set(Boolean.valueOf(AccountCenter.newInstance().isPerfectUserInfo()));
        this.h.set(Boolean.valueOf(AccountCenter.newInstance().isHasNotDefaultHeader()));
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.FRIEND_MATCH_UPDATE_USER_INFO_DETAIL, User.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f12060a.a((User) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void i() {
        UserApi.getPerfectUserInfoReward(this.f12048a, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int i = !TextUtils.isEmpty(AccountCenter.newInstance().birthday.get()) ? 20 : 0;
        if (AccountCenter.newInstance().isHasNotDefaultHeader()) {
            i += 20;
        }
        if (!TextUtils.isEmpty(AccountCenter.newInstance().detail.get())) {
            i += 20;
        }
        if (!TextUtils.isEmpty(AccountCenter.newInstance().nickName.get())) {
            i += 20;
        }
        if (AccountCenter.newInstance().sex.get().intValue() != 0) {
            i += 20;
        }
        this.i.set(Integer.valueOf(i));
        this.j.set(this.i.get() + "%");
        this.g.set(Boolean.valueOf(AccountCenter.newInstance().isPerfectUserInfo()));
        this.h.set(Boolean.valueOf(AccountCenter.newInstance().isHasNotDefaultHeader()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickBirthday() {
        DatePicker datePicker = new DatePicker((Activity) this.f12048a);
        Calendar calendar = Calendar.getInstance();
        datePicker.setRangeStart(1980, 1, 1);
        datePicker.setRangeEnd(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        datePicker.setLabel(this.f12048a.getString(R.string.account_year), this.f12048a.getString(R.string.account_month), this.f12048a.getString(R.string.account_day));
        if (TextUtils.isEmpty(AccountCenter.newInstance().birthday.get())) {
            datePicker.setSelectedItem(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        } else {
            String[] strArrSplit = AccountCenter.newInstance().birthday.get().split("-");
            if (strArrSplit.length == 3) {
                datePicker.setSelectedItem(Integer.valueOf(strArrSplit[0]).intValue(), Integer.valueOf(strArrSplit[1]).intValue(), Integer.valueOf(strArrSplit[2]).intValue());
            } else {
                datePicker.setSelectedItem(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
            }
        }
        a(datePicker);
        datePicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() { // from class: com.disabngo.blockynexus.view.fragment.updateuserinfo.f
            @Override // cn.qqtheme.framework.picker.DatePicker.OnYearMonthDayPickListener
            public final void onDatePicked(String str, String str2, String str3) {
                this.f12059a.a(str, str2, str3);
            }
        });
        datePicker.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickDetail() {
        Context context = this.f12048a;
        TemplateUtils.startTemplate(context, C0870b.class, context.getString(R.string.item_view_details), this.f12048a.getString(R.string.finish));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickNickName() {
        Context context = this.f12048a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.n.d.class, context.getString(R.string.item_view_change_nick_name), this.f12048a.getString(R.string.finish));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickSex() {
        AppToastUtils.showShortNegativeTipToast(this.f12048a, R.string.change_sex_no_support);
    }

    public void f() {
        new j(this.f12050c).loadData(this.f12048a, new m(this));
    }

    public /* synthetic */ void h() {
        this.f12049b.i();
    }

    void j() {
        i iVar = this.f12049b;
        if (iVar.f12062a == null) {
            return;
        }
        IconUploadHelper.uploadIcon(this.f12048a, iVar.g(), this.f12049b.h(), new l(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(com.sandboxol.greendao.entity.User r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getDetails()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L2e
            android.content.Context r0 = r4.f12048a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.sandboxol.center.entity.AccountCenter r3 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Long> r3 = r3.userId
            java.lang.Object r3 = r3.get()
            r2.append(r3)
            java.lang.String r3 = "friend.match.is.perfect.data"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r0 = com.sandboxol.common.utils.SharedUtils.getBoolean(r0, r2, r1)
            if (r0 == 0) goto L37
        L2e:
            androidx.databinding.ObservableField<java.lang.Boolean> r0 = r4.f12052e
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.set(r1)
        L37:
            com.sandboxol.center.entity.AccountCenter r0 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.String> r0 = r0.detail
            java.lang.String r5 = r5.getDetails()
            r0.set(r5)
            com.sandboxol.center.entity.AccountCenter.putAccountInfo()
            r4.l()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.fragment.updateuserinfo.UpdateUserInfoViewModel.a(com.sandboxol.greendao.entity.User):void");
    }

    public /* synthetic */ void a(String str, String str2, String str3) {
        String str4 = str + "-" + str2 + "-" + str3;
        AccountCenter.newInstance().setBirthday(str4);
        this.f12050c.setBirthday(str4);
        f();
        ReportDataAdapter.onEvent(this.f12048a, EventConstant.MORE_BIR_SUC);
    }

    private void a(WheelPicker wheelPicker) {
        wheelPicker.setOffset(2);
        wheelPicker.setTextSize(20);
        wheelPicker.setLineSpaceMultiplier(3.0f);
        wheelPicker.setCancelTextColor(this.f12048a.getResources().getColor(R.color.colorPrimary));
        wheelPicker.setSubmitTextColor(this.f12048a.getResources().getColor(R.color.colorPrimary));
        wheelPicker.setTextColor(androidx.core.content.b.a(this.f12048a, R.color.colorPrimary));
        wheelPicker.setDividerVisible(false);
        wheelPicker.setCycleDisable(true);
    }
}
