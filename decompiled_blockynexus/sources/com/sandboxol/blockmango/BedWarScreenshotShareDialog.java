package com.sandboxol.blockmango;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.game.R;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class BedWarScreenshotShareDialog extends BaseShareDialog<com.sandboxol.game.a.A> {
    public ReplyCommand onCloseClick;
    public ReplyCommand onSaveClickCommand;
    public ReplyCommand onShareFaceBookClickCommand;
    public ReplyCommand onShareGoogleClickCommand;
    public ReplyCommand onShareTwitterClickCommand;
    public ReplyCommand onWriteClick;

    public BedWarScreenshotShareDialog(Context context, Bitmap bitmap, int i, Uri uri) {
        super(context, bitmap, i, uri);
        this.onCloseClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.bb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16168a.onClose();
            }
        });
        this.onShareFaceBookClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f16195a.onShareFaceBookClick();
            }
        });
        this.onShareGoogleClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f16190a.onShareGoogleClick();
            }
        });
        this.onShareTwitterClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f16208a.onShareTwitterClick();
            }
        });
        this.onSaveClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f16199a.onSaveClick();
            }
        });
        this.onWriteClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f16204a.onWriteClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClick() {
        onSave(getBinding().f17636e.getText() != null ? getBinding().f17636e.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareFaceBookClick() {
        onShareFaceBook(getBinding().f17636e.getText() != null ? getBinding().f17636e.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareGoogleClick() {
        onShareFaceBook(getBinding().f17636e.getText() != null ? getBinding().f17636e.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareTwitterClick() {
        onShareTwitter(getBinding().f17636e.getText() != null ? getBinding().f17636e.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWriteClick() {
        onWrite(getBinding().f17636e);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_SHOW_BED_WAR_UI);
        super.dismiss();
    }

    @Override // com.sandboxol.blockmango.BaseShareDialog
    ImageView getshowImage() {
        return getBinding().g;
    }

    @Override // com.sandboxol.blockmango.BaseShareDialog
    int onBIndingLayout() {
        return R.layout.dialog_screenshot_share_for_bed_war;
    }
}
