package com.disabngo.blockynexus.binding.adapter;

import com.disabngo.blockynexus.view.widget.TribeDressRadioGroup;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: TribeDressRadioGroupBindAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    static /* synthetic */ void a(ReplyCommand replyCommand, TribeDressRadioGroup.Tab tab) {
        if (replyCommand != null) {
            replyCommand.execute(tab);
        }
    }

    public static void b(TribeDressRadioGroup tribeDressRadioGroup, final ReplyCommand<TribeDressRadioGroup.Tab> replyCommand) {
        tribeDressRadioGroup.setTabChangeListener(new TribeDressRadioGroup.b() { // from class: com.disabngo.blockynexus.binding.adapter.d
            @Override // com.disabngo.blockynexus.view.widget.TribeDressRadioGroup.b
            public final void a(TribeDressRadioGroup.Tab tab) {
                s.a(replyCommand, tab);
            }
        });
    }

    public static void c(TribeDressRadioGroup tribeDressRadioGroup, boolean z) {
        if (z) {
            tribeDressRadioGroup.showCurrent();
        } else {
            tribeDressRadioGroup.hideCurrent();
        }
    }

    public static void d(TribeDressRadioGroup tribeDressRadioGroup, boolean z) {
        if (z) {
            tribeDressRadioGroup.showMoneyType();
        } else {
            tribeDressRadioGroup.hideMoneyType();
        }
    }

    public static void a(TribeDressRadioGroup tribeDressRadioGroup, final ReplyCommand<Boolean> replyCommand) {
        tribeDressRadioGroup.setFullScreenListener(new TribeDressRadioGroup.a() { // from class: com.disabngo.blockynexus.binding.adapter.c
            @Override // com.disabngo.blockynexus.view.widget.TribeDressRadioGroup.a
            public final void a(boolean z) {
                s.a(replyCommand, z);
            }
        });
    }

    public static void b(TribeDressRadioGroup tribeDressRadioGroup, boolean z) {
        if (z) {
            tribeDressRadioGroup.showCbShowAll();
        } else {
            tribeDressRadioGroup.hideCbShowAll();
        }
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, boolean z) {
        if (replyCommand != null) {
            replyCommand.execute(Boolean.valueOf(z));
        }
    }

    public static void a(TribeDressRadioGroup tribeDressRadioGroup, TribeDressRadioGroup.Tab tab) {
        tribeDressRadioGroup.selectTab(tab);
    }

    public static void a(TribeDressRadioGroup tribeDressRadioGroup, boolean z) {
        tribeDressRadioGroup.setFullScreenCheck(z);
    }
}
