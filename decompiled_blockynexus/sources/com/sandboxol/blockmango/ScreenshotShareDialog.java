package com.sandboxol.blockmango;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.game.R;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenshotShareDialog extends BaseShareDialog<com.sandboxol.game.a.y> {
    public ReplyCommand onCloseClick;
    public ReplyCommand onSaveClickCommand;
    public ReplyCommand onShareFaceBookClickCommand;
    public ReplyCommand onShareGoogleClickCommand;
    public ReplyCommand onShareTwitterClickCommand;
    public ReplyCommand onWriteClick;

    public ScreenshotShareDialog(Context context, Bitmap bitmap, int i, Uri uri) {
        super(context, bitmap, i, uri);
        this.onCloseClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.qb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16240a.onClose();
            }
        });
        this.onShareFaceBookClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.lb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16217a.onShareFaceBookClick();
            }
        });
        this.onShareGoogleClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.nb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16226a.onShareGoogleClick();
            }
        });
        this.onShareTwitterClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.pb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16235a.onShareTwitterClick();
            }
        });
        this.onSaveClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.mb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16221a.onSaveClick();
            }
        });
        this.onWriteClick = new ReplyCommand(new Action0() { // from class: com.sandboxol.blockmango.ob
            @Override // rx.functions.Action0
            public final void call() {
                this.f16230a.onWriteClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClick() {
        onSave(getBinding().f17734c.getText() != null ? getBinding().f17734c.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareFaceBookClick() {
        onShareFaceBook(getBinding().f17734c.getText() != null ? getBinding().f17734c.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareGoogleClick() {
        onShareFaceBook(getBinding().f17734c.getText() != null ? getBinding().f17734c.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareTwitterClick() {
        onShareTwitter(getBinding().f17734c.getText() != null ? getBinding().f17734c.getText().toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWriteClick() {
        onWrite(getBinding().f17734c);
    }

    @Override // com.sandboxol.blockmango.BaseShareDialog
    ImageView getshowImage() {
        return getBinding().f17736e;
    }

    @Override // com.sandboxol.blockmango.BaseShareDialog
    int onBIndingLayout() {
        return R.layout.dialog_screenshot_share;
    }
}
