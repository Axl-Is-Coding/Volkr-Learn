package com.disabngo.blockynexus.receiver;

import android.content.Context;
import io.rong.imlib.RongIMClient;
import io.rong.push.notification.PushNotificationMessage;

/* JADX INFO: compiled from: RongCloudPushMessageReceiver.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends RongIMClient.ConnectCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PushNotificationMessage f10486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RongCloudPushMessageReceiver f10488c;

    a(RongCloudPushMessageReceiver rongCloudPushMessageReceiver, PushNotificationMessage pushNotificationMessage, Context context) {
        this.f10488c = rongCloudPushMessageReceiver;
        this.f10486a = pushNotificationMessage;
        this.f10487b = context;
    }

    @Override // io.rong.imlib.RongIMClient.ConnectCallback
    public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
    }

    @Override // io.rong.imlib.RongIMClient.ConnectCallback
    public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
    }

    @Override // io.rong.imlib.RongIMClient.ConnectCallback
    public void onSuccess(String str) {
        this.f10488c.gotoActivity(this.f10486a, this.f10487b);
    }
}
