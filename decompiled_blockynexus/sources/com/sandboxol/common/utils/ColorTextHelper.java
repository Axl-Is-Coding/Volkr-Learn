package com.sandboxol.common.utils;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class ColorTextHelper {
    public static final String HTML_ATTR_COLOR = "color='";
    public static final String HTML_LABEL_BR = "<br/>";
    public static final String HTML_LABEL_FONT_BEGIN_END = "'>";
    public static final String HTML_LABEL_FONT_BEGIN_START = "<font ";
    public static final String HTML_LABEL_FONT_END = "</font>";
    public static final String HTML_SPACE = "&nbsp;";
    private StringBuilder result;

    public static class Builder {
        String endTag;
        String highLightColor;
        String normalColor;
        StringBuilder result = new StringBuilder();
        String startTag;

        private boolean checkValidity(String str, String str2, String str3) {
            Stack stack = new Stack();
            while (!str.isEmpty()) {
                String strSubstring = str.substring(0, 1);
                str = str.substring(1);
                if (strSubstring.equals(str2)) {
                    stack.push(strSubstring);
                } else if (!strSubstring.equals(str3)) {
                    continue;
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    String str4 = (String) stack.pop();
                    if (strSubstring.equals(str3) && !str4.equals(str2)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private String generateStr(StringBuilder sb, String str, String str2, String str3, String str4) {
            StringBuilder sb2 = new StringBuilder();
            for (String str5 : sb.toString().split(str2)) {
                String[] strArrSplit = str5.split(str);
                if (strArrSplit.length != 1) {
                    setValue(sb2, strArrSplit[0], str3);
                    setValue(sb2, strArrSplit[1], str4);
                } else if (strArrSplit[0].contains(str)) {
                    setValue(sb2, strArrSplit[0], str4);
                } else {
                    setValue(sb2, strArrSplit[0], str3);
                }
            }
            return sb2.toString().replace(UMCustomLogInfoBuilder.LINE_SEP, ColorTextHelper.HTML_LABEL_BR);
        }

        private void setValue(StringBuilder sb, String str, String str2) {
            sb.append(ColorTextHelper.HTML_LABEL_FONT_BEGIN_START);
            sb.append(ColorTextHelper.HTML_ATTR_COLOR);
            sb.append(str2);
            sb.append(ColorTextHelper.HTML_LABEL_FONT_BEGIN_END);
            sb.append(str);
            sb.append(ColorTextHelper.HTML_LABEL_FONT_END);
        }

        public Builder appendText(String str, int i) {
            appendText(str, ColorTextHelper.colorResId2Str(i));
            return this;
        }

        public Builder appendTextWithTag(String str, String str2, String str3, String str4, String str5) {
            this.result.append(str);
            this.startTag = str2;
            this.endTag = str3;
            this.normalColor = str4;
            this.highLightColor = str5;
            return this;
        }

        void applyContent(ColorTextHelper colorTextHelper) {
            colorTextHelper.result = new StringBuilder();
            if (TextUtils.isEmpty(this.startTag) || TextUtils.isEmpty(this.endTag) || TextUtils.isEmpty(this.normalColor) || TextUtils.isEmpty(this.highLightColor)) {
                colorTextHelper.result.append(this.result.toString());
            } else if (checkValidity(this.result.toString(), this.startTag, this.endTag)) {
                colorTextHelper.result.append(generateStr(this.result, this.startTag, this.endTag, this.normalColor, this.highLightColor));
            } else {
                colorTextHelper.result.append(this.result.toString().replace(this.startTag, "").replace(this.endTag, ""));
            }
        }

        public ColorTextHelper create() {
            ColorTextHelper colorTextHelper = new ColorTextHelper();
            try {
                applyContent(colorTextHelper);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return colorTextHelper;
        }

        public Builder appendText(String str, String str2) {
            StringBuilder sb = this.result;
            sb.append(ColorTextHelper.HTML_LABEL_FONT_BEGIN_START);
            sb.append(ColorTextHelper.HTML_ATTR_COLOR);
            sb.append(str2);
            sb.append(ColorTextHelper.HTML_LABEL_FONT_BEGIN_END);
            sb.append(str);
            sb.append(ColorTextHelper.HTML_LABEL_FONT_END);
            return this;
        }

        public Builder appendTextWithTag(String str, String str2, String str3, String str4, int i) {
            return appendTextWithTag(str, str2, str3, str4, ColorTextHelper.colorResId2Str(i));
        }

        public Builder appendTextWithTag(String str, String str2, String str3, int i, String str4) {
            return appendTextWithTag(str, str2, str3, ColorTextHelper.colorResId2Str(i), str4);
        }

        public Builder appendTextWithTag(String str, String str2, String str3, int i, int i2) {
            return appendTextWithTag(str, str2, str3, ColorTextHelper.colorResId2Str(i), ColorTextHelper.colorResId2Str(i2));
        }
    }

    public static String colorResId2Str(int i) {
        try {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    return "#" + Integer.toHexString(BaseApplication.getContext().getResources().getColor(i, null)).substring(r4.length() - 6);
                }
                return "#" + Integer.toHexString(BaseApplication.getContext().getResources().getColor(i)).substring(r4.length() - 6);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "#333333";
            }
        } catch (Throwable unused) {
            return "#333333";
        }
    }

    public Spanned getColorText() {
        StringBuilder sb = this.result;
        if (sb == null) {
            return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml("", 63) : Html.fromHtml("");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return Html.fromHtml(sb.toString(), 63);
            } catch (Exception e2) {
                e2.printStackTrace();
                return Html.fromHtml("", 63);
            }
        }
        try {
            return Html.fromHtml(sb.toString());
        } catch (Exception e3) {
            e3.printStackTrace();
            return Html.fromHtml("");
        }
    }
}
