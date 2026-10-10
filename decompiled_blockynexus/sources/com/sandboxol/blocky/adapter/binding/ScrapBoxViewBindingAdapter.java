package com.sandboxol.blocky.adapter.binding;

import android.text.Html;
import android.widget.TextView;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.game.R;

/* JADX INFO: loaded from: classes.dex */
public class ScrapBoxViewBindingAdapter {
    public static void setHtmlText(TextView textView, int i, int i2) {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String scrapBoxLevel = ScrapOutlineViewReturnHelper.getScrapBoxLevel(i);
        String scrapBoxLevel2 = ScrapOutlineViewReturnHelper.getScrapBoxLevel((i + 1) % 7);
        int i3 = i2 / 3600;
        if (i3 > 9) {
            strValueOf = String.valueOf(i3);
        } else {
            strValueOf = "0" + i3;
        }
        int i4 = i2 % 3600;
        int i5 = i4 / 60;
        if (i5 > 9) {
            strValueOf2 = String.valueOf(i5);
        } else {
            strValueOf2 = "0" + i5;
        }
        int i6 = i4 % 60;
        if (i6 > 9) {
            strValueOf3 = String.valueOf(i6);
        } else {
            strValueOf3 = "0" + i6;
        }
        int i7 = R.string.game_dialog_scrap_box_tv_output_tip;
        if (i == 5) {
            i7 = R.string.game_dialog_scrap_box_tv_output_tip_1;
        } else if (i == 6) {
            i7 = R.string.game_dialog_scrap_box_tv_output_all_2;
        } else if (i == 7) {
            i7 = R.string.game_dialog_scrap_box_tv_output_all_tip;
        }
        textView.setText(Html.fromHtml(String.format(BaseApplication.getContext().getResources().getString(i7), scrapBoxLevel, strValueOf, strValueOf2, strValueOf3, scrapBoxLevel2)));
    }
}
