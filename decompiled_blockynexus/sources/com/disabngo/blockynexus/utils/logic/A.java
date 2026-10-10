package com.disabngo.blockynexus.utils.logic;

import io.rong.imlib.model.Conversation;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f10516a = new int[Conversation.ConversationType.values().length];

    static {
        try {
            f10516a[Conversation.ConversationType.PRIVATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10516a[Conversation.ConversationType.GROUP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
