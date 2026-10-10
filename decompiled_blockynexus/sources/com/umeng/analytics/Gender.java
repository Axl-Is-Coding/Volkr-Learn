package com.umeng.analytics;

import com.facebook.internal.AnalyticsEvents;
import java.util.Locale;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Male' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
public class Gender {
    public static final Gender Female;
    public static final Gender Male;
    public static final Gender Unknown;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ Gender[] f20576a;
    public int value;

    /* JADX INFO: renamed from: com.umeng.analytics.Gender$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20577a = new int[Gender.values().length];

        static {
            try {
                f20577a[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20577a[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20577a[Gender.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i = 1;
        int i2 = 0;
        Male = new Gender("Male", i2, i) { // from class: com.umeng.analytics.Gender.1
            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
            }
        };
        int i3 = 2;
        Female = new Gender("Female", i, i3) { // from class: com.umeng.analytics.Gender.2
            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
            }
        };
        Unknown = new Gender(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, i3, i2) { // from class: com.umeng.analytics.Gender.3
            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
            }
        };
        f20576a = new Gender[]{Male, Female, Unknown};
    }

    public static Gender getGender(int i) {
        return i != 1 ? i != 2 ? Unknown : Female : Male;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(Gender gender) {
        int i = AnonymousClass4.f20577a[gender.ordinal()];
        return i != 1 ? i != 2 ? com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN : com.umeng.commonsdk.statistics.proto.Gender.FEMALE : com.umeng.commonsdk.statistics.proto.Gender.MALE;
    }

    public static Gender valueOf(String str) {
        return (Gender) Enum.valueOf(Gender.class, str);
    }

    public static Gender[] values() {
        return (Gender[]) f20576a.clone();
    }

    public int value() {
        return this.value;
    }

    private Gender(String str, int i, int i2) {
        this.value = i2;
    }
}
