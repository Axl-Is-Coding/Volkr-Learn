package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.pa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class C2414pa implements WebController.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebController f15322a;

    C2414pa(WebController webController) {
        this.f15322a = webController;
    }

    @Override // com.ironsource.sdk.controller.WebController.d
    public void a(String str, SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar) {
        this.f15322a.triggerOnControllerInitProductFail(str, sSAEnums$ProductType, dVar);
    }
}
