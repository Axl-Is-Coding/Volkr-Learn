package io.rong.imlib.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public final class UserData implements Parcelable {
    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>() { // from class: io.rong.imlib.model.UserData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserData createFromParcel(Parcel parcel) {
            return new UserData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserData[] newArray(int i) {
            return new UserData[i];
        }
    };
    private AccountInfo accountInfo;
    private String appVersion;
    private ClientInfo clientInfo;
    private ContactInfo contactInfo;
    private String extra;
    private PersonalInfo personalInfo;

    public static class AccountInfo implements Parcelable {
        public static final Parcelable.Creator<AccountInfo> CREATOR = new Parcelable.Creator<AccountInfo>() { // from class: io.rong.imlib.model.UserData.AccountInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AccountInfo createFromParcel(Parcel parcel) {
                return new AccountInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AccountInfo[] newArray(int i) {
                return new AccountInfo[i];
            }
        };
        String appUserId;
        String nickName;
        String userName;

        public AccountInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAppUserId() {
            return this.appUserId;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setAppUserId(String str) {
            this.appUserId = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelUtils.writeToParcel(parcel, this.appUserId);
            ParcelUtils.writeToParcel(parcel, this.userName);
            ParcelUtils.writeToParcel(parcel, this.nickName);
        }

        public AccountInfo(Parcel parcel) {
            setAppUserId(ParcelUtils.readFromParcel(parcel));
            setUserName(ParcelUtils.readFromParcel(parcel));
            setNickName(ParcelUtils.readFromParcel(parcel));
        }
    }

    public static class ContactInfo implements Parcelable {
        public static final Parcelable.Creator<ContactInfo> CREATOR = new Parcelable.Creator<ContactInfo>() { // from class: io.rong.imlib.model.UserData.ContactInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ContactInfo createFromParcel(Parcel parcel) {
                return new ContactInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ContactInfo[] newArray(int i) {
                return new ContactInfo[i];
            }
        };
        String address;
        String email;
        String qq;
        String tel;
        String weibo;
        String weixin;

        public ContactInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAddress() {
            return this.address;
        }

        public String getEmail() {
            return this.email;
        }

        public String getQQ() {
            return this.qq;
        }

        public String getTel() {
            return this.tel;
        }

        public String getWeibo() {
            return this.weibo;
        }

        public String getWeixin() {
            return this.weixin;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setQQ(String str) {
            this.qq = str;
        }

        public void setTel(String str) {
            this.tel = str;
        }

        public void setWeibo(String str) {
            this.weibo = str;
        }

        public void setWeixin(String str) {
            this.weixin = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelUtils.writeToParcel(parcel, this.tel);
            ParcelUtils.writeToParcel(parcel, this.email);
            ParcelUtils.writeToParcel(parcel, this.address);
            ParcelUtils.writeToParcel(parcel, this.qq);
            ParcelUtils.writeToParcel(parcel, this.weibo);
            ParcelUtils.writeToParcel(parcel, this.weixin);
        }

        public ContactInfo(Parcel parcel) {
            setTel(ParcelUtils.readFromParcel(parcel));
            setEmail(ParcelUtils.readFromParcel(parcel));
            setAddress(ParcelUtils.readFromParcel(parcel));
            setQQ(ParcelUtils.readFromParcel(parcel));
            setWeibo(ParcelUtils.readFromParcel(parcel));
            setWeixin(ParcelUtils.readFromParcel(parcel));
        }
    }

    public static class PersonalInfo implements Parcelable {
        public static final Parcelable.Creator<PersonalInfo> CREATOR = new Parcelable.Creator<PersonalInfo>() { // from class: io.rong.imlib.model.UserData.PersonalInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PersonalInfo createFromParcel(Parcel parcel) {
                return new PersonalInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PersonalInfo[] newArray(int i) {
                return new PersonalInfo[i];
            }
        };
        String age;
        String birthday;
        String comment;
        String job;
        String portraitUri;
        String realName;
        String sex;

        public PersonalInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAge() {
            return this.age;
        }

        public String getBirthday() {
            return this.birthday;
        }

        public String getComment() {
            return this.comment;
        }

        public String getJob() {
            return this.job;
        }

        public String getPortraitUri() {
            return this.portraitUri;
        }

        public String getRealName() {
            return this.realName;
        }

        public String getSex() {
            return this.sex;
        }

        public void setAge(String str) {
            this.age = str;
        }

        public void setBirthday(String str) {
            this.birthday = str;
        }

        public void setComment(String str) {
            this.comment = str;
        }

        public void setJob(String str) {
            this.job = str;
        }

        public void setPortraitUri(String str) {
            this.portraitUri = str;
        }

        public void setRealName(String str) {
            this.realName = str;
        }

        public void setSex(String str) {
            this.sex = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelUtils.writeToParcel(parcel, this.realName);
            ParcelUtils.writeToParcel(parcel, this.sex);
            ParcelUtils.writeToParcel(parcel, this.birthday);
            ParcelUtils.writeToParcel(parcel, this.age);
            ParcelUtils.writeToParcel(parcel, this.job);
            ParcelUtils.writeToParcel(parcel, this.portraitUri);
            ParcelUtils.writeToParcel(parcel, this.comment);
        }

        public PersonalInfo(Parcel parcel) {
            setRealName(ParcelUtils.readFromParcel(parcel));
            setSex(ParcelUtils.readFromParcel(parcel));
            setBirthday(ParcelUtils.readFromParcel(parcel));
            setAge(ParcelUtils.readFromParcel(parcel));
            setJob(ParcelUtils.readFromParcel(parcel));
            setPortraitUri(ParcelUtils.readFromParcel(parcel));
            setComment(ParcelUtils.readFromParcel(parcel));
        }
    }

    public UserData(Context context) {
        this.clientInfo = new ClientInfo(context);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public ContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public String getExtra() {
        return this.extra;
    }

    public PersonalInfo getPersonalInfo() {
        return this.personalInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.personalInfo);
        ParcelUtils.writeToParcel(parcel, this.accountInfo);
        ParcelUtils.writeToParcel(parcel, this.contactInfo);
        ParcelUtils.writeToParcel(parcel, this.clientInfo);
        ParcelUtils.writeToParcel(parcel, this.appVersion);
        ParcelUtils.writeToParcel(parcel, this.extra);
    }

    public static class ClientInfo implements Parcelable {
        public static final Parcelable.Creator<ClientInfo> CREATOR = new Parcelable.Creator<ClientInfo>() { // from class: io.rong.imlib.model.UserData.ClientInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ClientInfo createFromParcel(Parcel parcel) {
                return new ClientInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ClientInfo[] newArray(int i) {
                return new ClientInfo[i];
            }
        };
        private static final String TAG = "ClientInfo";
        String carrier;
        String device;
        String mobilePhoneManufacturers;
        String network;
        String os = "Android";
        String systemVersion;

        public ClientInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCarrier() {
            return this.carrier;
        }

        public String getDevice() {
            return this.device;
        }

        public String getMobilePhoneManufacturers() {
            return this.mobilePhoneManufacturers;
        }

        public String getNetwork() {
            return this.network;
        }

        public String getOs() {
            return this.os;
        }

        public String getSystemVersion() {
            return this.systemVersion;
        }

        public void setCarrier(String str) {
            this.carrier = str;
        }

        public void setDevice(String str) {
            this.device = str;
        }

        public void setMobilePhoneManufacturers(String str) {
            this.mobilePhoneManufacturers = str;
        }

        public void setNetwork(String str) {
            this.network = str;
        }

        public void setOs(String str) {
            this.os = str;
        }

        public void setSystemVersion(String str) {
            this.systemVersion = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ParcelUtils.writeToParcel(parcel, this.network);
            ParcelUtils.writeToParcel(parcel, this.carrier);
            ParcelUtils.writeToParcel(parcel, this.systemVersion);
            ParcelUtils.writeToParcel(parcel, this.os);
            ParcelUtils.writeToParcel(parcel, this.device);
            ParcelUtils.writeToParcel(parcel, this.mobilePhoneManufacturers);
        }

        public ClientInfo(Context context) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    this.network = connectivityManager.getActiveNetworkInfo().getTypeName();
                }
                if (telephonyManager != null) {
                    this.carrier = telephonyManager.getNetworkOperator();
                }
            } catch (SecurityException e2) {
                RLog.e(TAG, "ClientInfo", e2);
            }
            this.mobilePhoneManufacturers = Build.MANUFACTURER;
            this.device = Build.MODEL;
            this.systemVersion = String.valueOf(Build.VERSION.SDK_INT);
        }

        public ClientInfo(Parcel parcel) {
            setNetwork(ParcelUtils.readFromParcel(parcel));
            setCarrier(ParcelUtils.readFromParcel(parcel));
            setSystemVersion(ParcelUtils.readFromParcel(parcel));
            setOs(ParcelUtils.readFromParcel(parcel));
            setDevice(ParcelUtils.readFromParcel(parcel));
            setMobilePhoneManufacturers(ParcelUtils.readFromParcel(parcel));
        }
    }

    public UserData(Parcel parcel) {
        setPersonalInfo((PersonalInfo) ParcelUtils.readFromParcel(parcel, PersonalInfo.class));
        setAccountInfo((AccountInfo) ParcelUtils.readFromParcel(parcel, AccountInfo.class));
        setContactInfo((ContactInfo) ParcelUtils.readFromParcel(parcel, ContactInfo.class));
        this.clientInfo = (ClientInfo) ParcelUtils.readFromParcel(parcel, ClientInfo.class);
        setAppVersion(ParcelUtils.readFromParcel(parcel));
        setExtra(ParcelUtils.readFromParcel(parcel));
    }
}
