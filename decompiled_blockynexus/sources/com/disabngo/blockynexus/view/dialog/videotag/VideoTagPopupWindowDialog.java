package com.disabngo.blockynexus.view.dialog.videotag;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0609ib;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.greendao.entity.VideoTagInfo;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class VideoTagPopupWindowDialog extends PopupWindow {
    private Context context;
    public f listModel;
    public ReplyCommand onCancelCommand;
    public ReplyCommand onConfirmCommand;
    public VideoTagInfo tag;
    private List<VideoTagInfo> tagList;

    public VideoTagPopupWindowDialog(Context context, List<VideoTagInfo> list, VideoTagInfo videoTagInfo) {
        super(context);
        this.onCancelCommand = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.videotag.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f11704a.onCancel();
            }
        });
        this.onConfirmCommand = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.videotag.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f11705a.onConfirm();
            }
        });
        this.context = context;
        this.tagList = list;
        this.tag = videoTagInfo;
        init();
        initData();
    }

    private void initData() {
        this.listModel = new f(this.context, R.string.no_data, this.tagList, this.tag);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.disabngo.blockynexus.view.dialog.videotag.b
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f11703a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancel() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfirm() {
        if (TextUtils.isEmpty(this.tag.getGameId()) && TextUtils.isEmpty(this.tag.getTagName())) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.activity_video_total_tag_null);
        } else {
            Messenger.getDefault().send(this.tag, MessageToken.TOKEN_VIDEO_TOTAL_SELECT_TAG);
            dismiss();
        }
    }

    public /* synthetic */ void a() {
        Context context = this.context;
        if (context instanceof Activity) {
            WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
            attributes.alpha = 1.0f;
            ((Activity) this.context).getWindow().setAttributes(attributes);
        }
    }

    protected void init() {
        int height;
        AbstractC0609ib abstractC0609ib = (AbstractC0609ib) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_app_video_tag, (ViewGroup) null, false);
        abstractC0609ib.a(this);
        setContentView(abstractC0609ib.getRoot());
        setBackgroundDrawable(new ColorDrawable(0));
        int width = -1;
        if (this.context instanceof Activity) {
            width = (int) (((Activity) r0).getWindowManager().getDefaultDisplay().getWidth() - SizeUtil.dp2px(this.context, 10.0f));
            height = (int) (((Activity) this.context).getWindowManager().getDefaultDisplay().getHeight() * 0.65f);
            WindowManager.LayoutParams attributes = ((Activity) this.context).getWindow().getAttributes();
            attributes.alpha = 0.7f;
            ((Activity) this.context).getWindow().setAttributes(attributes);
        } else {
            height = -1;
        }
        setWidth(width);
        setHeight(height);
        setOutsideTouchable(false);
        setFocusable(true);
    }
}
