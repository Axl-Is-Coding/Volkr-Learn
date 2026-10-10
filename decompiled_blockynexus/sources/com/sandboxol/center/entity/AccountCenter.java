package com.sandboxol.center.entity;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import com.google.gson.j;
import com.sandboxol.center.R;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.User;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class AccountCenter extends BaseObservable {
    public ObservableField<String> account;
    public ObservableField<Integer> authentication;
    public ObservableField<String> birthday;
    public ObservableField<String> detail;
    public ObservableField<Long> diamonds;
    public ObservableField<String> email;
    public ObservableField<String> expireDate;
    public ObservableField<Long> gDiamonds;
    public ObservableField<Long> gDiamondsProfit;
    public ObservableField<Long> golds;
    public ObservableField<Boolean> hasBinding;
    public ObservableField<Boolean> hasPassword;
    public ObservableField<Boolean> isFinishSecretQuestion;
    public ObservableField<Boolean> isShowDressGuide;
    public ObservableField<Boolean> login;
    public ObservableField<Double> money;
    public ObservableField<String> nickName;
    public ObservableField<String> password;
    public ObservableField<String> picUrl;
    public ObservableField<Double> rate;
    public ObservableField<String> renewPassword;
    public ObservableField<Integer> sex;
    public ObservableField<String> starCode;
    public ObservableField<Integer> starCodeUserDisable;
    public ObservableField<String> telephone;
    public ObservableField<String> token;
    public ObservableField<Long> userId;
    public ObservableField<Integer> vip;

    private static class AccountCenterImpl {
        private static AccountCenter instance = new AccountCenter();

        private AccountCenterImpl() {
        }
    }

    static /* synthetic */ void f() {
        synchronized (AccountCenter.class) {
            if (newInstance().login.get().booleanValue()) {
                AppSharedUtils.newInstance().putAccountInfo(new j().a(newInstance()));
            } else {
                AppSharedUtils.newInstance().putAccountInfo(null);
            }
        }
    }

    public static void getAccountInfo(Action0 action0) {
        AppSharedUtils.newInstance().getAccountInfo(action0);
    }

    public static void logout() {
        AccountCenter accountCenterNewInstance = newInstance();
        accountCenterNewInstance.setNickName(BaseApplication.getApp().getResources().getString(R.string.more_fragment_visitor));
        accountCenterNewInstance.setAccount(BaseApplication.getApp().getResources().getString(R.string.base_more_user_no_account));
        accountCenterNewInstance.setUserId(0L);
        accountCenterNewInstance.setToken("");
        accountCenterNewInstance.setAccount("");
        accountCenterNewInstance.setPassword("");
        accountCenterNewInstance.setDetail("");
        accountCenterNewInstance.setSex(0);
        accountCenterNewInstance.setPicUrl("");
        accountCenterNewInstance.setBirthday("");
        accountCenterNewInstance.setLogin(false);
        accountCenterNewInstance.setTelephone("");
        accountCenterNewInstance.setEmail("");
        accountCenterNewInstance.setDiamonds(0L);
        accountCenterNewInstance.setGolds(0L);
        accountCenterNewInstance.setExpireDate("");
        accountCenterNewInstance.setVip(0);
        accountCenterNewInstance.setHasPassword(false);
        accountCenterNewInstance.setHasBinding(false);
        accountCenterNewInstance.setAuthentication(0);
        accountCenterNewInstance.setStarCode("");
        accountCenterNewInstance.setStarCodeUserDisable(0);
        accountCenterNewInstance.setgDiamondsProfit(0L);
        accountCenterNewInstance.setMoney(0.0d);
        accountCenterNewInstance.setRate(0.0d);
        AppSharedUtils.newInstance().putAccountInfo("");
    }

    public static AccountCenter newInstance() {
        return AccountCenterImpl.instance;
    }

    public static synchronized void putAccountInfo() {
        BaseApplication.getThreadPool().setName("putAccountInfo");
        BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.sandboxol.center.entity.a
            @Override // java.lang.Runnable
            public final void run() {
                AccountCenter.f();
            }
        });
    }

    public static void updateAccount(User user) {
        AccountCenter accountCenterNewInstance = newInstance();
        accountCenterNewInstance.setUserId(newInstance().userId.get().longValue());
        accountCenterNewInstance.setToken(newInstance().token.get());
        accountCenterNewInstance.setHasBinding(newInstance().hasBinding.get().booleanValue());
        accountCenterNewInstance.setAccount(TextUtils.isEmpty(user.getAccount()) ? BaseApplication.getContext().getResources().getString(R.string.base_more_user_no_account) : user.getAccount());
        accountCenterNewInstance.setPassword(user.getPassword());
        accountCenterNewInstance.setNickName(user.getNickName());
        accountCenterNewInstance.setDetail(user.getDetails());
        accountCenterNewInstance.setSex(user.getSex());
        accountCenterNewInstance.setPicUrl(user.getPicUrl());
        accountCenterNewInstance.setBirthday(user.getBirthday());
        accountCenterNewInstance.setLogin(true);
        accountCenterNewInstance.setTelephone(user.getTelephone());
        accountCenterNewInstance.setEmail(user.getEmail());
        accountCenterNewInstance.setDiamonds(user.getDiamonds());
        accountCenterNewInstance.setGDiamonds(user.getGDiamonds());
        accountCenterNewInstance.setGolds(user.getGolds());
        accountCenterNewInstance.setExpireDate(user.getExpireDate());
        accountCenterNewInstance.setVip(user.getVip());
        accountCenterNewInstance.setHasPassword(user.getHasPassword());
        accountCenterNewInstance.setAuthentication(0);
        accountCenterNewInstance.setStarCode(user.getStarCode() == null ? "" : user.getStarCode());
        putAccountInfo();
        BaseApplication.getApp().setAccessToken(accountCenterNewInstance.token.get());
        BaseApplication.getApp().setUserId(accountCenterNewInstance.userId.get().longValue());
    }

    public void clone(AccountCenter accountCenter) {
        ObservableField<Long> observableField = this.userId;
        if (observableField != null) {
            accountCenter.setUserId(observableField.get().longValue());
        }
        ObservableField<String> observableField2 = this.token;
        if (observableField2 != null) {
            accountCenter.setToken(observableField2.get());
        }
        ObservableField<String> observableField3 = this.account;
        if (observableField3 != null) {
            accountCenter.setAccount(observableField3.get());
        }
        ObservableField<String> observableField4 = this.password;
        if (observableField4 != null) {
            accountCenter.setPassword(observableField4.get());
        }
        ObservableField<String> observableField5 = this.nickName;
        if (observableField5 != null) {
            accountCenter.setNickName(observableField5.get());
        }
        ObservableField<String> observableField6 = this.picUrl;
        if (observableField6 != null) {
            accountCenter.setPicUrl(observableField6.get());
        }
        ObservableField<Integer> observableField7 = this.sex;
        if (observableField7 != null) {
            accountCenter.setSex(observableField7.get().intValue());
        }
        ObservableField<String> observableField8 = this.detail;
        if (observableField8 != null) {
            accountCenter.setDetail(observableField8.get());
        }
        ObservableField<String> observableField9 = this.birthday;
        if (observableField9 != null) {
            accountCenter.setBirthday(observableField9.get());
        }
        ObservableField<Boolean> observableField10 = this.login;
        if (observableField10 != null) {
            accountCenter.setLogin(observableField10.get().booleanValue());
        }
        ObservableField<String> observableField11 = this.telephone;
        if (observableField11 != null) {
            accountCenter.setTelephone(observableField11.get());
        }
        ObservableField<String> observableField12 = this.email;
        if (observableField12 != null) {
            accountCenter.setEmail(observableField12.get());
        }
        ObservableField<Long> observableField13 = this.diamonds;
        if (observableField13 != null) {
            accountCenter.setDiamonds(observableField13.get().longValue());
        }
        ObservableField<Long> observableField14 = this.gDiamonds;
        if (observableField14 != null) {
            accountCenter.setGDiamonds(observableField14.get().longValue());
        }
        ObservableField<Long> observableField15 = this.golds;
        if (observableField15 != null) {
            accountCenter.setGolds(observableField15.get().longValue());
        }
        ObservableField<String> observableField16 = this.expireDate;
        if (observableField16 != null) {
            accountCenter.setExpireDate(observableField16.get());
        }
        ObservableField<Integer> observableField17 = this.vip;
        if (observableField17 != null) {
            accountCenter.setVip(observableField17.get().intValue());
        }
        ObservableField<Boolean> observableField18 = this.hasPassword;
        if (observableField18 != null) {
            accountCenter.setHasPassword(observableField18.get().booleanValue());
        }
        ObservableField<Boolean> observableField19 = this.hasBinding;
        if (observableField19 != null) {
            accountCenter.setHasBinding(observableField19.get().booleanValue());
        }
        ObservableField<Boolean> observableField20 = this.isFinishSecretQuestion;
        if (observableField20 != null) {
            accountCenter.setIsFinishSecretQuestion(observableField20.get().booleanValue());
        }
        ObservableField<Integer> observableField21 = this.authentication;
        if (observableField21 != null) {
            accountCenter.setAuthentication(observableField21.get().intValue());
        }
        ObservableField<Boolean> observableField22 = this.isShowDressGuide;
        if (observableField22 != null) {
            accountCenter.setIsShowDressGuide(observableField22.get().booleanValue());
        }
        ObservableField<String> observableField23 = this.renewPassword;
        if (observableField23 != null) {
            accountCenter.setRenewPassword(observableField23.get());
        }
        ObservableField<String> observableField24 = this.starCode;
        if (observableField24 != null) {
            accountCenter.setStarCode(observableField24.get());
        }
        ObservableField<Integer> observableField25 = this.starCodeUserDisable;
        if (observableField25 != null) {
            accountCenter.setStarCodeUserDisable(observableField25.get().intValue());
        }
        ObservableField<Long> observableField26 = this.gDiamondsProfit;
        if (observableField26 != null) {
            accountCenter.setgDiamondsProfit(observableField26.get().longValue());
        }
        ObservableField<Double> observableField27 = this.money;
        if (observableField27 != null) {
            accountCenter.setMoney(observableField27.get().doubleValue());
        }
        ObservableField<Double> observableField28 = this.rate;
        if (observableField28 != null) {
            accountCenter.setRate(observableField28.get().doubleValue());
        }
    }

    public Friend getMyInfo() {
        return new Friend(0L, newInstance().userId.get().longValue(), newInstance().userId.get().longValue(), null, newInstance().detail.get(), null, newInstance().nickName.get(), newInstance().picUrl.get(), 0, newInstance().expireDate.get(), newInstance().vip.get().intValue(), newInstance().sex.get().intValue(), true, TribeCenter.newInstance().tribeClanId.get().longValue(), TribeCenter.newInstance().getTribeNameText(), TribeCenter.newInstance().tribeRole.get().intValue(), false, "", 0, "", "", null, null, null, newInstance().starCode.get(), 0L);
    }

    public String getRenewPassword() {
        return this.renewPassword.get();
    }

    public String getStingID(String str) {
        return "ID:" + str;
    }

    public boolean isHasNotDefaultHeader() {
        return (TextUtils.isEmpty(this.picUrl.get()) || this.picUrl.get().contains("activity/login/login")) ? false : true;
    }

    public boolean isPerfectUserInfo() {
        if (TextUtils.isEmpty(this.birthday.get()) || !isHasNotDefaultHeader()) {
            return false;
        }
        if (TextUtils.isEmpty(this.detail.get())) {
            if (!SharedUtils.getBoolean(BaseApplication.getContext(), newInstance().userId.get() + SharedConstant.FRIEND_MATCH_IS_PERFECT_DATA, false)) {
                return false;
            }
        }
        return true;
    }

    public void setAccount(String str) {
        this.account.set(str);
    }

    public void setAuthentication(int i) {
        this.authentication.set(Integer.valueOf(i));
    }

    public void setBirthday(String str) {
        this.birthday.set(str);
    }

    public void setDetail(String str) {
        this.detail.set(str);
    }

    public void setDiamonds(long j) {
        this.diamonds.set(Long.valueOf(j));
    }

    public void setEmail(String str) {
        this.email.set(str);
    }

    public void setExpireDate(String str) {
        this.expireDate.set(str);
    }

    public void setGDiamonds(long j) {
        this.gDiamonds.set(Long.valueOf(j));
    }

    public void setGolds(long j) {
        this.golds.set(Long.valueOf(j));
    }

    public void setHasBinding(boolean z) {
        this.hasBinding.set(Boolean.valueOf(z));
    }

    public void setHasPassword(boolean z) {
        this.hasPassword.set(Boolean.valueOf(z));
    }

    public void setIsFinishSecretQuestion(boolean z) {
        this.isFinishSecretQuestion.set(Boolean.valueOf(z));
    }

    public void setIsShowDressGuide(boolean z) {
        this.isShowDressGuide.set(Boolean.valueOf(z));
    }

    public void setLogin(boolean z) {
        this.login.set(Boolean.valueOf(z));
    }

    public void setMoney(double d2) {
        this.money.set(Double.valueOf(d2));
    }

    public void setNickName(String str) {
        this.nickName.set(str);
    }

    public void setPassword(String str) {
        this.password.set(str);
    }

    public void setPicUrl(String str) {
        this.picUrl.set(str);
    }

    public void setRate(double d2) {
        this.rate.set(Double.valueOf(d2));
    }

    public void setRenewPassword(String str) {
        this.renewPassword.set(str);
    }

    public void setSex(int i) {
        this.sex.set(Integer.valueOf(i));
    }

    public void setStarCode(String str) {
        this.starCode.set(str);
    }

    public void setStarCodeUserDisable(int i) {
        this.starCodeUserDisable.set(Integer.valueOf(i));
    }

    public void setTelephone(String str) {
        this.telephone.set(str);
    }

    public void setToken(String str) {
        this.token.set(str);
    }

    public void setUserId(long j) {
        this.userId.set(Long.valueOf(j));
    }

    public void setVip(int i) {
        this.vip.set(Integer.valueOf(i));
    }

    public void setgDiamondsProfit(long j) {
        this.gDiamondsProfit.set(Long.valueOf(j));
    }

    private AccountCenter() {
        this.userId = new ObservableField<>(0L);
        this.account = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.base_more_user_no_account));
        this.token = new ObservableField<>("");
        this.password = new ObservableField<>("");
        this.nickName = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.more_fragment_visitor));
        this.picUrl = new ObservableField<>("");
        this.sex = new ObservableField<>(0);
        this.detail = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.more_fragment_details, BaseApplication.getContext().getResources().getString(R.string.more_fragment_no_details)));
        this.birthday = new ObservableField<>("");
        this.login = new ObservableField<>(false);
        this.telephone = new ObservableField<>("");
        this.email = new ObservableField<>("");
        this.diamonds = new ObservableField<>(0L);
        this.gDiamonds = new ObservableField<>(0L);
        this.golds = new ObservableField<>(0L);
        this.expireDate = new ObservableField<>();
        this.vip = new ObservableField<>(0);
        this.hasPassword = new ObservableField<>(false);
        this.hasBinding = new ObservableField<>(false);
        this.isFinishSecretQuestion = new ObservableField<>(false);
        this.authentication = new ObservableField<>(0);
        this.isShowDressGuide = new ObservableField<>(false);
        this.renewPassword = new ObservableField<>("");
        this.starCode = new ObservableField<>("");
        this.starCodeUserDisable = new ObservableField<>(0);
        this.gDiamondsProfit = new ObservableField<>(0L);
        Double dValueOf = Double.valueOf(0.0d);
        this.money = new ObservableField<>(dValueOf);
        this.rate = new ObservableField<>(dValueOf);
    }
}
