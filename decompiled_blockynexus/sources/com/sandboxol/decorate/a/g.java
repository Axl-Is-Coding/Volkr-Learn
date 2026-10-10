package com.sandboxol.decorate.a;

import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.decorate.widget.DressMenuButton;
import com.sandboxol.decorate.widget.DressRadioGroup;

/* JADX INFO: compiled from: DressRadioGroupBindAdapters.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    static /* synthetic */ void a(ReplyCommand replyCommand, DressRadioGroup.Tab tab) {
        if (replyCommand != null) {
            replyCommand.execute(tab);
        }
    }

    public static void b(DressRadioGroup dressRadioGroup, final ReplyCommand<Boolean> replyCommand) {
        dressRadioGroup.setFullScreenListener(new DressRadioGroup.a() { // from class: com.sandboxol.decorate.a.b
            @Override // com.sandboxol.decorate.widget.DressRadioGroup.a
            public final void a(boolean z) {
                g.a(replyCommand, z);
            }
        });
    }

    public static void c(DressRadioGroup dressRadioGroup, final ReplyCommand<DressRadioGroup.Tab> replyCommand) {
        dressRadioGroup.setTabChangeListener(new DressRadioGroup.b() { // from class: com.sandboxol.decorate.a.c
            @Override // com.sandboxol.decorate.widget.DressRadioGroup.b
            public final void a(DressRadioGroup.Tab tab) {
                g.a(replyCommand, tab);
            }
        });
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, boolean z) {
        if (replyCommand != null) {
            replyCommand.execute(Boolean.valueOf(z));
        }
    }

    public static void a(DressRadioGroup dressRadioGroup, DressRadioGroup.Tab tab) {
        dressRadioGroup.selectTab(tab);
    }

    public static void a(DressRadioGroup dressRadioGroup, boolean z) {
        dressRadioGroup.setFullScreenCheck(z);
    }

    public static void a(DressRadioGroup dressRadioGroup, final ReplyCommand<DressMenuButton.MenuItem> replyCommand) {
        dressRadioGroup.setFirstMenuSelectedListener(new DressMenuButton.a() { // from class: com.sandboxol.decorate.a.d
            @Override // com.sandboxol.decorate.widget.DressMenuButton.a
            public final void a(DressMenuButton.MenuItem menuItem) {
                g.a(replyCommand, menuItem);
            }
        });
    }

    static /* synthetic */ void a(ReplyCommand replyCommand, DressMenuButton.MenuItem menuItem) {
        if (replyCommand != null) {
            replyCommand.execute(menuItem);
        }
    }
}
