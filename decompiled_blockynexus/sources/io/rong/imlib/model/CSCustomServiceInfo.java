package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import io.rong.imlib.RongIMClient;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CSCustomServiceInfo implements Parcelable {
    public static final Parcelable.Creator<CSCustomServiceInfo> CREATOR = new Parcelable.Creator<CSCustomServiceInfo>() { // from class: io.rong.imlib.model.CSCustomServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSCustomServiceInfo createFromParcel(Parcel parcel) {
            return new CSCustomServiceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSCustomServiceInfo[] newArray(int i) {
            return new CSCustomServiceInfo[i];
        }
    };
    private static final String TAG = "CSCustomServiceInfo";
    private String QQ;
    private String address;
    private String age;
    private String birthday;
    private String city;
    private String define;
    private String email;
    private String enterUrl;
    private String gender;
    private String grade;
    private List<String> listUrl;
    private String loginName;
    private String memo;
    private String mobileNo;
    private String name;
    private String nickName;
    private String page;
    private String portraitUrl;
    private String productId;
    private String profession;
    private String province;
    private String referrer;
    private String skillId;
    private String userId;
    private String weibo;
    private String weixin;

    public static class Builder {
        private String QQ;
        private String address;
        private String age;
        private String birthday;
        private String city;
        private String email;
        private String gender;
        private String grade;
        private String loginName;
        private String memo;
        private String mobileNo;
        private String name;
        private String nickName;
        private String portraitUrl;
        private String profession;
        private String province;
        private String userId;
        private String weibo;
        private String weixin;
        private String page = "";
        private String referrer = "";
        private String enterUrl = "";
        private String skillId = "";
        private List<String> listUrl = new ArrayList();
        private String define = "";
        private String productId = "";

        public Builder QQ(String str) {
            this.QQ = str;
            return this;
        }

        public Builder address(String str) {
            this.address = str;
            return this;
        }

        public Builder age(String str) {
            this.age = str;
            return this;
        }

        public Builder birthday(String str) {
            this.birthday = str;
            return this;
        }

        public CSCustomServiceInfo build() {
            if (RongIMClient.getInstance() == null) {
                return null;
            }
            CSCustomServiceInfo cSCustomServiceInfo = new CSCustomServiceInfo();
            String str = this.userId;
            if (str == null) {
                str = "";
            }
            cSCustomServiceInfo.userId = str;
            String currentUserId = this.nickName;
            if (currentUserId == null) {
                currentUserId = RongIMClient.getInstance().getCurrentUserId();
            }
            cSCustomServiceInfo.nickName = currentUserId;
            String str2 = this.loginName;
            if (str2 == null) {
                str2 = "";
            }
            cSCustomServiceInfo.loginName = str2;
            String str3 = this.name;
            if (str3 == null) {
                str3 = "";
            }
            cSCustomServiceInfo.name = str3;
            String str4 = this.grade;
            if (str4 == null) {
                str4 = "";
            }
            cSCustomServiceInfo.grade = str4;
            String str5 = this.gender;
            if (str5 == null) {
                str5 = "";
            }
            cSCustomServiceInfo.gender = str5;
            String str6 = this.birthday;
            if (str6 == null) {
                str6 = "";
            }
            cSCustomServiceInfo.birthday = str6;
            String str7 = this.age;
            if (str7 == null) {
                str7 = "";
            }
            cSCustomServiceInfo.age = str7;
            String str8 = this.profession;
            if (str8 == null) {
                str8 = "";
            }
            cSCustomServiceInfo.profession = str8;
            String str9 = this.portraitUrl;
            if (str9 == null) {
                str9 = "";
            }
            cSCustomServiceInfo.portraitUrl = str9;
            String str10 = this.province;
            if (str10 == null) {
                str10 = "";
            }
            cSCustomServiceInfo.province = str10;
            String str11 = this.city;
            if (str11 == null) {
                str11 = "";
            }
            cSCustomServiceInfo.city = str11;
            String str12 = this.memo;
            if (str12 == null) {
                str12 = "";
            }
            cSCustomServiceInfo.memo = str12;
            String str13 = this.mobileNo;
            if (str13 == null) {
                str13 = "";
            }
            cSCustomServiceInfo.mobileNo = str13;
            String str14 = this.email;
            if (str14 == null) {
                str14 = "";
            }
            cSCustomServiceInfo.email = str14;
            String str15 = this.address;
            if (str15 == null) {
                str15 = "";
            }
            cSCustomServiceInfo.address = str15;
            String str16 = this.QQ;
            if (str16 == null) {
                str16 = "";
            }
            cSCustomServiceInfo.QQ = str16;
            String str17 = this.weibo;
            if (str17 == null) {
                str17 = "";
            }
            cSCustomServiceInfo.weibo = str17;
            String str18 = this.weixin;
            if (str18 == null) {
                str18 = "";
            }
            cSCustomServiceInfo.weixin = str18;
            String str19 = this.page;
            if (str19 == null) {
                str19 = "";
            }
            cSCustomServiceInfo.page = str19;
            String str20 = this.referrer;
            if (str20 == null) {
                str20 = "";
            }
            cSCustomServiceInfo.referrer = str20;
            String str21 = this.enterUrl;
            if (str21 == null) {
                str21 = "";
            }
            cSCustomServiceInfo.enterUrl = str21;
            String str22 = this.skillId;
            if (str22 == null) {
                str22 = "";
            }
            cSCustomServiceInfo.skillId = str22;
            cSCustomServiceInfo.listUrl = this.listUrl;
            String str23 = this.define;
            if (str23 == null) {
                str23 = "";
            }
            cSCustomServiceInfo.define = str23;
            String str24 = this.productId;
            if (str24 == null) {
                str24 = "";
            }
            cSCustomServiceInfo.productId = str24;
            return cSCustomServiceInfo;
        }

        public Builder city(String str) {
            this.city = str;
            return this;
        }

        public Builder define(String str) {
            this.define = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder enterUrl(String str) {
            this.enterUrl = str;
            return this;
        }

        public Builder gender(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.gender = str;
            }
            return this;
        }

        public Builder grade(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.grade = str;
            }
            return this;
        }

        public Builder listUrl(List<String> list) {
            if (list != null && !list.isEmpty()) {
                this.listUrl.addAll(list);
            }
            return this;
        }

        public Builder loginName(String str) {
            this.loginName = str;
            return this;
        }

        public Builder memo(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.memo = str;
            }
            return this;
        }

        public Builder mobileNo(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mobileNo = str;
            }
            return this;
        }

        public Builder name(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.name = str;
            }
            return this;
        }

        public Builder nickName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.nickName = str;
            }
            return this;
        }

        public Builder page(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.page = str;
            }
            return this;
        }

        public Builder portraitUrl(String str) {
            this.portraitUrl = str;
            return this;
        }

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder profession(String str) {
            this.profession = str;
            return this;
        }

        public Builder province(String str) {
            this.province = str;
            return this;
        }

        public Builder referrer(String str) {
            this.referrer = str;
            return this;
        }

        public Builder skillId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.skillId = str;
            }
            return this;
        }

        public Builder userId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.userId = str;
            }
            return this;
        }

        public Builder weibo(String str) {
            this.weibo = str;
            return this;
        }

        public Builder weixin(String str) {
            this.weixin = str;
            return this;
        }
    }

    CSCustomServiceInfo() {
        this.userId = "";
        this.nickName = "";
        this.loginName = "";
        this.name = "";
        this.grade = "";
        this.gender = "";
        this.birthday = "";
        this.age = "";
        this.profession = "";
        this.portraitUrl = "";
        this.province = "";
        this.city = "";
        this.memo = "";
        this.mobileNo = "";
        this.email = "";
        this.address = "";
        this.QQ = "";
        this.weibo = "";
        this.weixin = "";
        this.page = "";
        this.referrer = "";
        this.enterUrl = "";
        this.skillId = "";
        this.listUrl = new ArrayList();
        this.define = "";
        this.productId = "";
        if (RongIMClient.getInstance() != null) {
            this.nickName = RongIMClient.getInstance().getCurrentUserId();
        } else {
            RLog.e(TAG, "JSONException CSCustomServiceInfo: RongIMClient.getInstance() is null");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAge() {
        return this.age;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCity() {
        return this.city;
    }

    public String getDefine() {
        return this.define;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEnterUrl() {
        return this.enterUrl;
    }

    public String getGender() {
        return this.gender;
    }

    public String getGrade() {
        return this.grade;
    }

    public List<String> getListUrl() {
        return this.listUrl;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPage() {
        return this.page;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProfession() {
        return this.profession;
    }

    public String getProvince() {
        return this.province;
    }

    public String getQQ() {
        return this.QQ;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public String getSkillId() {
        return this.skillId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getWeibo() {
        return this.weibo;
    }

    public String getWeixin() {
        return this.weixin;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.userId);
        ParcelUtils.writeToParcel(parcel, this.nickName);
        ParcelUtils.writeToParcel(parcel, this.loginName);
        ParcelUtils.writeToParcel(parcel, this.name);
        ParcelUtils.writeToParcel(parcel, this.grade);
        ParcelUtils.writeToParcel(parcel, this.gender);
        ParcelUtils.writeToParcel(parcel, this.birthday);
        ParcelUtils.writeToParcel(parcel, this.age);
        ParcelUtils.writeToParcel(parcel, this.profession);
        ParcelUtils.writeToParcel(parcel, this.portraitUrl);
        ParcelUtils.writeToParcel(parcel, this.province);
        ParcelUtils.writeToParcel(parcel, this.city);
        ParcelUtils.writeToParcel(parcel, this.memo);
        ParcelUtils.writeToParcel(parcel, this.mobileNo);
        ParcelUtils.writeToParcel(parcel, this.email);
        ParcelUtils.writeToParcel(parcel, this.address);
        ParcelUtils.writeToParcel(parcel, this.QQ);
        ParcelUtils.writeToParcel(parcel, this.weibo);
        ParcelUtils.writeToParcel(parcel, this.weixin);
        ParcelUtils.writeToParcel(parcel, this.page);
        ParcelUtils.writeToParcel(parcel, this.referrer);
        ParcelUtils.writeToParcel(parcel, this.enterUrl);
        ParcelUtils.writeToParcel(parcel, this.skillId);
        ParcelUtils.writeToParcel(parcel, this.listUrl);
        ParcelUtils.writeToParcel(parcel, this.define);
        ParcelUtils.writeToParcel(parcel, this.productId);
    }

    public CSCustomServiceInfo(Parcel parcel) {
        this.userId = "";
        this.nickName = "";
        this.loginName = "";
        this.name = "";
        this.grade = "";
        this.gender = "";
        this.birthday = "";
        this.age = "";
        this.profession = "";
        this.portraitUrl = "";
        this.province = "";
        this.city = "";
        this.memo = "";
        this.mobileNo = "";
        this.email = "";
        this.address = "";
        this.QQ = "";
        this.weibo = "";
        this.weixin = "";
        this.page = "";
        this.referrer = "";
        this.enterUrl = "";
        this.skillId = "";
        this.listUrl = new ArrayList();
        this.define = "";
        this.productId = "";
        this.userId = ParcelUtils.readFromParcel(parcel);
        this.nickName = ParcelUtils.readFromParcel(parcel);
        this.loginName = ParcelUtils.readFromParcel(parcel);
        this.name = ParcelUtils.readFromParcel(parcel);
        this.grade = ParcelUtils.readFromParcel(parcel);
        this.gender = ParcelUtils.readFromParcel(parcel);
        this.birthday = ParcelUtils.readFromParcel(parcel);
        this.age = ParcelUtils.readFromParcel(parcel);
        this.profession = ParcelUtils.readFromParcel(parcel);
        this.portraitUrl = ParcelUtils.readFromParcel(parcel);
        this.province = ParcelUtils.readFromParcel(parcel);
        this.city = ParcelUtils.readFromParcel(parcel);
        this.memo = ParcelUtils.readFromParcel(parcel);
        this.mobileNo = ParcelUtils.readFromParcel(parcel);
        this.email = ParcelUtils.readFromParcel(parcel);
        this.address = ParcelUtils.readFromParcel(parcel);
        this.QQ = ParcelUtils.readFromParcel(parcel);
        this.weibo = ParcelUtils.readFromParcel(parcel);
        this.weixin = ParcelUtils.readFromParcel(parcel);
        this.page = ParcelUtils.readFromParcel(parcel);
        this.referrer = ParcelUtils.readFromParcel(parcel);
        this.enterUrl = ParcelUtils.readFromParcel(parcel);
        this.skillId = ParcelUtils.readFromParcel(parcel);
        this.listUrl = ParcelUtils.readListFromParcel(parcel, String.class);
        this.define = ParcelUtils.readFromParcel(parcel);
        this.productId = ParcelUtils.readFromParcel(parcel);
    }
}
