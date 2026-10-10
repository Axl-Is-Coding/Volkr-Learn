package com.google.firebase.messaging;

import a.a.b;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzg();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    @SafeParcelable.Field(id = 2)
    Bundle zzee;
    private Map<String, String> zzef;
    private Notification zzeg;

    public static class Builder {
        private final Bundle zzee = new Bundle();
        private final Map<String, String> zzef = new b();

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                String strValueOf = String.valueOf(str);
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Invalid to: ".concat(strValueOf) : new String("Invalid to: "));
            }
            this.zzee.putString("google.to", str);
        }

        public Builder addData(String str, String str2) {
            this.zzef.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : this.zzef.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            bundle.putAll(this.zzee);
            this.zzee.remove("from");
            return new RemoteMessage(bundle);
        }

        public Builder clearData() {
            this.zzef.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.zzee.putString("collapse_key", str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.zzef.clear();
            this.zzef.putAll(map);
            return this;
        }

        public Builder setMessageId(String str) {
            this.zzee.putString("google.message_id", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.zzee.putString("message_type", str);
            return this;
        }

        public Builder setTtl(int i) {
            this.zzee.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification {
        private final String tag;
        private final String zzeh;
        private final String zzei;
        private final String[] zzej;
        private final String zzek;
        private final String zzel;
        private final String[] zzem;
        private final String zzen;
        private final String zzeo;
        private final String zzep;
        private final String zzeq;
        private final String zzer;
        private final String zzes;
        private final Uri zzet;

        private Notification(Bundle bundle) {
            this.zzeh = zzb.zza(bundle, "gcm.n.title");
            this.zzei = zzb.zzd(bundle, "gcm.n.title");
            this.zzej = zzf(bundle, "gcm.n.title");
            this.zzek = zzb.zza(bundle, "gcm.n.body");
            this.zzel = zzb.zzd(bundle, "gcm.n.body");
            this.zzem = zzf(bundle, "gcm.n.body");
            this.zzen = zzb.zza(bundle, "gcm.n.icon");
            this.zzep = zzb.zzi(bundle);
            this.tag = zzb.zza(bundle, "gcm.n.tag");
            this.zzeq = zzb.zza(bundle, "gcm.n.color");
            this.zzer = zzb.zza(bundle, "gcm.n.click_action");
            this.zzes = zzb.zza(bundle, "gcm.n.android_channel_id");
            this.zzet = zzb.zzj(bundle);
            this.zzeo = zzb.zza(bundle, "gcm.n.image");
        }

        private static String[] zzf(Bundle bundle, String str) {
            Object[] objArrZzb = zzb.zzb(bundle, str);
            if (objArrZzb == null) {
                return null;
            }
            String[] strArr = new String[objArrZzb.length];
            for (int i = 0; i < objArrZzb.length; i++) {
                strArr[i] = String.valueOf(objArrZzb[i]);
            }
            return strArr;
        }

        public String getBody() {
            return this.zzek;
        }

        public String[] getBodyLocalizationArgs() {
            return this.zzem;
        }

        public String getBodyLocalizationKey() {
            return this.zzel;
        }

        public String getChannelId() {
            return this.zzes;
        }

        public String getClickAction() {
            return this.zzer;
        }

        public String getColor() {
            return this.zzeq;
        }

        public String getIcon() {
            return this.zzen;
        }

        public Uri getImageUrl() {
            String str = this.zzeo;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public Uri getLink() {
            return this.zzet;
        }

        public String getSound() {
            return this.zzep;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTitle() {
            return this.zzeh;
        }

        public String[] getTitleLocalizationArgs() {
            return this.zzej;
        }

        public String getTitleLocalizationKey() {
            return this.zzei;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzee = bundle;
    }

    private static int zzp(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    public final String getCollapseKey() {
        return this.zzee.getString("collapse_key");
    }

    public final Map<String, String> getData() {
        if (this.zzef == null) {
            Bundle bundle = this.zzee;
            b bVar = new b();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        bVar.put(str, str2);
                    }
                }
            }
            this.zzef = bVar;
        }
        return this.zzef;
    }

    public final String getFrom() {
        return this.zzee.getString("from");
    }

    public final String getMessageId() {
        String string = this.zzee.getString("google.message_id");
        return string == null ? this.zzee.getString("message_id") : string;
    }

    public final String getMessageType() {
        return this.zzee.getString("message_type");
    }

    public final Notification getNotification() {
        if (this.zzeg == null && zzb.zzh(this.zzee)) {
            this.zzeg = new Notification(this.zzee);
        }
        return this.zzeg;
    }

    public final int getOriginalPriority() {
        String string = this.zzee.getString("google.original_priority");
        if (string == null) {
            string = this.zzee.getString("google.priority");
        }
        return zzp(string);
    }

    public final int getPriority() {
        String string = this.zzee.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.zzee.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.zzee.getString("google.priority");
        }
        return zzp(string);
    }

    public final long getSentTime() {
        Object obj = this.zzee.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 19);
            sb.append("Invalid sent time: ");
            sb.append(strValueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0L;
        }
    }

    public final String getTo() {
        return this.zzee.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.zzee.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(strValueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    @KeepForSdk
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.zzee);
        return intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzee, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
