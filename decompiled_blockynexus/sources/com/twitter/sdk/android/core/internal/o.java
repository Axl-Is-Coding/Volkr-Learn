package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.internal.UserUtils;

/* JADX INFO: compiled from: UserUtils.java */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f20184a = new int[UserUtils.AvatarSize.values().length];

    static {
        try {
            f20184a[UserUtils.AvatarSize.NORMAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20184a[UserUtils.AvatarSize.BIGGER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20184a[UserUtils.AvatarSize.MINI.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20184a[UserUtils.AvatarSize.ORIGINAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20184a[UserUtils.AvatarSize.REASONABLY_SMALL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
