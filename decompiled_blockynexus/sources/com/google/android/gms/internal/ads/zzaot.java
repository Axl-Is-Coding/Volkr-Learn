package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.AdRequest$Gender;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzaot {
    private static final /* synthetic */ int[] zzdmd;
    static final /* synthetic */ int[] zzdme = new int[AdRequest$ErrorCode.values().length];

    static {
        try {
            zzdme[AdRequest$ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzdme[AdRequest$ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzdme[AdRequest$ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzdme[AdRequest$ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        zzdmd = new int[AdRequest$Gender.values().length];
        try {
            zzdmd[AdRequest$Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzdmd[AdRequest$Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            zzdmd[AdRequest$Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
