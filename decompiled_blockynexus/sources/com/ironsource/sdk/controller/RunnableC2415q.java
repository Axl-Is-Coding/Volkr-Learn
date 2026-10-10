package com.ironsource.sdk.controller;

import android.app.Activity;
import android.util.Log;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2415q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f15323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.service.g f15324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f15325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ A f15326d;

    RunnableC2415q(A a2, Activity activity, com.ironsource.sdk.service.g gVar, E e2) {
        this.f15326d = a2;
        this.f15323a = activity;
        this.f15324b = gVar;
        this.f15325c = e2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15326d.b(this.f15323a, this.f15324b, this.f15325c);
        } catch (Exception e2) {
            this.f15326d.c(Log.getStackTraceString(e2));
        }
    }
}
