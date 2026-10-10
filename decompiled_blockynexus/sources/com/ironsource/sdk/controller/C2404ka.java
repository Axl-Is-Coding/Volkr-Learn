package com.ironsource.sdk.controller;

import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ka, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class C2404ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f15299a = new int[SSAEnums$ProductType.values().length];

    static {
        try {
            f15299a[SSAEnums$ProductType.RewardedVideo.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15299a[SSAEnums$ProductType.Interstitial.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15299a[SSAEnums$ProductType.OfferWall.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15299a[SSAEnums$ProductType.OfferWallCredits.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15299a[SSAEnums$ProductType.Banner.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
