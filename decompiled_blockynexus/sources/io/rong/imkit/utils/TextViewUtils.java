package io.rong.imkit.utils;

import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.widget.AutoLinkTextView;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class TextViewUtils {
    private static final int CONTENT_LIMIT_LENGTH = 150;
    private static RegularExecutor regularExecutor = new RegularExecutor();

    public interface RegularCallBack {
        void finish(SpannableStringBuilder spannableStringBuilder);
    }

    private static class RegularExecutor implements Executor {
        private final Executor mCompressExecutor = Executors.newCachedThreadPool();

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.mCompressExecutor.execute(runnable);
        }
    }

    public static SpannableStringBuilder getSpannable(String str, final RegularCallBack regularCallBack) {
        if (str == null) {
            return new SpannableStringBuilder("");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        final SpannableStringBuilder spannableStringBuilderReplaceEmojiWithText = AndroidEmoji.replaceEmojiWithText(spannableStringBuilder);
        AndroidEmoji.ensure(spannableStringBuilderReplaceEmojiWithText);
        if (spannableStringBuilder.length() < 150) {
            regularContent(spannableStringBuilderReplaceEmojiWithText);
        } else {
            regularExecutor.execute(new Runnable() { // from class: io.rong.imkit.utils.TextViewUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    TextViewUtils.regularContent(spannableStringBuilderReplaceEmojiWithText);
                    regularCallBack.finish(spannableStringBuilderReplaceEmojiWithText);
                }
            });
        }
        return spannableStringBuilderReplaceEmojiWithText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void regularContent(SpannableStringBuilder spannableStringBuilder) {
        Linkify.addLinks(spannableStringBuilder, 7);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class)) {
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            spannableStringBuilder.removeSpan(uRLSpan);
            spannableStringBuilder.setSpan(new AutoLinkTextView.URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
    }
}
