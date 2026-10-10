package com.sandboxol.center.binding.adapter;

import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.listener.OnViewClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapLevelViewBindingAdapter {
    static /* synthetic */ void a(ReplyCommand replyCommand, int i, ReplyCommand replyCommand2, ScrapLevelImageView scrapLevelImageView) {
        if (replyCommand != null) {
            replyCommand.execute(Integer.valueOf(i));
        }
        if (replyCommand2 != null) {
            replyCommand2.execute(scrapLevelImageView);
        }
    }

    public static void setScrapImageViewAnim(ScrapLevelImageView scrapLevelImageView, boolean z) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setAnim(z);
        }
    }

    public static void setScrapImageViewLevel(ScrapLevelImageView scrapLevelImageView, int i) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setType(i);
        }
    }

    public static void setScrapImageViewNum(ScrapLevelImageView scrapLevelImageView, int i) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setIvLevel(i);
        }
    }

    public static void setScrapImageViewNumStatus(ScrapLevelImageView scrapLevelImageView, int i, String str) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setScrapTextStatus(i != 0 ? 0 : 4);
            scrapLevelImageView.setScrapText(str);
        }
    }

    public static void setScrapImageViewOnClick(final ScrapLevelImageView scrapLevelImageView, final ReplyCommand<Integer> replyCommand, final int i, final ReplyCommand<ScrapLevelImageView> replyCommand2) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setClickListener(new OnViewClickListener() { // from class: com.sandboxol.center.binding.adapter.c
                @Override // com.sandboxol.common.listener.OnViewClickListener
                public final void onClick() {
                    ScrapLevelViewBindingAdapter.a(replyCommand, i, replyCommand2, scrapLevelImageView);
                }
            });
        }
    }

    public static void setScrapImageViewPercentStatus(ScrapLevelImageView scrapLevelImageView, int i, String str) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setScrapTextStatus(i != 0 ? 0 : 4);
            scrapLevelImageView.setScrapGameText(str);
        }
    }

    public static void setScrapImageViewResId(ScrapLevelImageView scrapLevelImageView, int i) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setResId(i);
        }
    }

    public static void setScrapImageViewStatus(ScrapLevelImageView scrapLevelImageView, int i, int i2, int i3, boolean z) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setScrapShadowStatus(i == 1 ? 4 : 0);
            scrapLevelImageView.setScrapDoneStatus(i2 == 2 ? 0 : 4);
            scrapLevelImageView.setScrapLockStatus(i3 == 0 ? 0 : 4, z);
        }
    }

    public static void setScrapImageViewType(ScrapLevelImageView scrapLevelImageView, int i) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setType(i);
        }
    }

    public static void setScrapImageViewUrl(ScrapLevelImageView scrapLevelImageView, String str) {
        if (scrapLevelImageView != null) {
            scrapLevelImageView.setPic(str);
        }
    }
}
