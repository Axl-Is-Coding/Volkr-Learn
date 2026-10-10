package io.rong.imkit.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;
import com.just.agentweb.DefaultWebClient;
import io.rong.common.RLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class RongLinkify {
    public static final int ALL = 15;
    public static final int EMAIL_ADDRESSES = 2;
    public static final int MAP_ADDRESSES = 8;
    public static final int PHONE_NUMBERS = 4;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;
    private static final String PHONE_NUMBER_REGEX = "(\\d{2,}-\\d{5,})|(\\d{7,})";
    private static final String TAG = "RongLinkify";
    public static final int WEB_URLS = 1;
    private static final String WEB_URL_REGEX = "[-a-zA-Z0-9+&@#/%?=~_|!:.,;]*\\.[-a-zA-Z0-9+&@#%=~_|]{2,4}(:[0-9]{1,5})?(/[-a-zA-Z0-9+&@#/%?=~_|!:,;]*)*";
    public static final Pattern WEB_URL = Patterns.WEB_URL;
    private static final Pattern PHONE_NUMBER = Patterns.PHONE;
    public static final Linkify.MatchFilter sUrlMatchFilter = new Linkify.MatchFilter() { // from class: io.rong.imkit.utils.RongLinkify.1
        @Override // android.text.util.Linkify.MatchFilter
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            return i == 0 || charSequence.charAt(i - 1) != '@';
        }
    };
    public static final Linkify.MatchFilter sPhoneNumberMatchFilter = new Linkify.MatchFilter() { // from class: io.rong.imkit.utils.RongLinkify.2
        @Override // android.text.util.Linkify.MatchFilter
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                if (Character.isDigit(charSequence.charAt(i)) && (i3 = i3 + 1) >= 5) {
                    return true;
                }
                i++;
            }
            return false;
        }
    };
    public static final Linkify.TransformFilter sPhoneNumberTransformFilter = new Linkify.TransformFilter() { // from class: io.rong.imkit.utils.RongLinkify.3
        @Override // android.text.util.Linkify.TransformFilter
        public final String transformUrl(Matcher matcher, String str) {
            return Patterns.digitsAndPlusOnly(matcher);
        }
    };

    private static class LinkSpec {
        int end;
        int start;
        String url;

        private LinkSpec() {
        }
    }

    public interface MatchFilter {
        boolean acceptMatch(CharSequence charSequence, int i, int i2);
    }

    public interface TransformFilter {
        String transformUrl(Matcher matcher, String str);
    }

    private static void addLinkMovementMethod(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean addLinks(Spannable spannable, int i) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList<LinkSpec> arrayList = new ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, WEB_URL, new String[]{DefaultWebClient.HTTP_SCHEME, DefaultWebClient.HTTPS_SCHEME, "rtsp://"}, sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, Patterns.EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i & 4) != 0) {
            gatherTelLinks(arrayList, spannable, PHONE_NUMBER);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        for (LinkSpec linkSpec : arrayList) {
            applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
        }
        return true;
    }

    private static void applyLink(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = iStart;
                linkSpec.end = iEnd;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String strFindAddress = WebView.findAddress(string);
                if (strFindAddress != null && (iIndexOf = string.indexOf(strFindAddress)) >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = strFindAddress.length() + iIndexOf;
                    linkSpec.start = iIndexOf + i;
                    i += length;
                    linkSpec.end = i;
                    string = string.substring(length);
                    try {
                        linkSpec.url = "geo:0,0?q=" + URLEncoder.encode(strFindAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException e2) {
                RLog.e(TAG, "gatherMapLinks", e2);
                return;
            }
        }
    }

    private static void gatherTelLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.url = "tel:" + matcher.group();
            linkSpec.start = iStart;
            linkSpec.end = iEnd;
            arrayList.add(linkSpec);
        }
    }

    private static String makeUrl(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                z = false;
                break;
            }
            String str2 = strArr[i];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i++;
            }
        }
        if (z) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList) {
        int i;
        Collections.sort(arrayList, new Comparator<LinkSpec>() { // from class: io.rong.imkit.utils.RongLinkify.4
            @Override // java.util.Comparator
            public final int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
                int i2;
                int i3;
                int i4 = linkSpec.start;
                int i5 = linkSpec2.start;
                if (i4 < i5) {
                    return -1;
                }
                if (i4 <= i5 && (i2 = linkSpec.end) >= (i3 = linkSpec2.end)) {
                    return i2 > i3 ? -1 : 0;
                }
                return 1;
            }
        });
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size - 1) {
            LinkSpec linkSpec = arrayList.get(i2);
            int i3 = i2 + 1;
            LinkSpec linkSpec2 = arrayList.get(i3);
            int i4 = linkSpec.start;
            int i5 = linkSpec2.start;
            if (i4 <= i5 && (i = linkSpec.end) > i5) {
                int i6 = linkSpec2.end;
                int i7 = (i6 > i && i - i4 <= i6 - i5) ? i - i4 < i6 - i5 ? i2 : -1 : i3;
                if (i7 != -1) {
                    arrayList.remove(i7);
                    size--;
                }
            }
            i2 = i3;
        }
    }

    public static boolean addLinks(TextView textView, int i) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!addLinks((Spannable) text, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(text);
        if (!addLinks(spannableStringValueOf, i)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(spannableStringValueOf);
        return true;
    }

    public static void addLinks(TextView textView, Pattern pattern, String str) {
        addLinks(textView, pattern, str, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        SpannableString spannableStringValueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(spannableStringValueOf, pattern, str, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str) {
        return addLinks(spannable, pattern, str, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) {
                applyLink(makeUrl(matcher.group(0), new String[]{lowerCase}, matcher, transformFilter), iStart, iEnd, spannable);
                z = true;
            }
        }
        return z;
    }
}
