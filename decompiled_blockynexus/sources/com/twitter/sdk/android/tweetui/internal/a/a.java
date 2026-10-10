package com.twitter.sdk.android.tweetui.internal.a;

import com.facebook.appevents.UserDataStore;
import com.sandboxol.vip.entity.VipProductType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: HtmlEntities.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final InterfaceC0175a f20394e = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[][] f20391b = {new String[]{"nbsp", "160"}, new String[]{"iexcl", "161"}, new String[]{"cent", "162"}, new String[]{"pound", "163"}, new String[]{"curren", "164"}, new String[]{"yen", "165"}, new String[]{"brvbar", "166"}, new String[]{"sect", "167"}, new String[]{"uml", "168"}, new String[]{"copy", "169"}, new String[]{"ordf", "170"}, new String[]{"laquo", "171"}, new String[]{"not", "172"}, new String[]{"shy", "173"}, new String[]{"reg", "174"}, new String[]{"macr", "175"}, new String[]{"deg", "176"}, new String[]{"plusmn", "177"}, new String[]{"sup2", "178"}, new String[]{"sup3", "179"}, new String[]{"acute", "180"}, new String[]{"micro", "181"}, new String[]{"para", "182"}, new String[]{"middot", "183"}, new String[]{"cedil", "184"}, new String[]{"sup1", "185"}, new String[]{"ordm", "186"}, new String[]{"raquo", "187"}, new String[]{"frac14", "188"}, new String[]{"frac12", "189"}, new String[]{"frac34", "190"}, new String[]{"iquest", "191"}, new String[]{"Agrave", "192"}, new String[]{"Aacute", "193"}, new String[]{"Acirc", "194"}, new String[]{"Atilde", "195"}, new String[]{"Auml", "196"}, new String[]{"Aring", "197"}, new String[]{"AElig", "198"}, new String[]{"Ccedil", "199"}, new String[]{"Egrave", "200"}, new String[]{"Eacute", "201"}, new String[]{"Ecirc", "202"}, new String[]{"Euml", "203"}, new String[]{"Igrave", "204"}, new String[]{"Iacute", "205"}, new String[]{"Icirc", "206"}, new String[]{"Iuml", "207"}, new String[]{"ETH", "208"}, new String[]{"Ntilde", "209"}, new String[]{"Ograve", "210"}, new String[]{"Oacute", "211"}, new String[]{"Ocirc", "212"}, new String[]{"Otilde", "213"}, new String[]{"Ouml", "214"}, new String[]{"times", "215"}, new String[]{"Oslash", "216"}, new String[]{"Ugrave", "217"}, new String[]{"Uacute", "218"}, new String[]{"Ucirc", "219"}, new String[]{"Uuml", "220"}, new String[]{"Yacute", "221"}, new String[]{"THORN", "222"}, new String[]{"szlig", "223"}, new String[]{"agrave", "224"}, new String[]{"aacute", "225"}, new String[]{"acirc", "226"}, new String[]{"atilde", "227"}, new String[]{"auml", "228"}, new String[]{"aring", "229"}, new String[]{"aelig", "230"}, new String[]{"ccedil", "231"}, new String[]{"egrave", "232"}, new String[]{"eacute", "233"}, new String[]{"ecirc", "234"}, new String[]{"euml", "235"}, new String[]{"igrave", "236"}, new String[]{"iacute", "237"}, new String[]{"icirc", "238"}, new String[]{"iuml", "239"}, new String[]{"eth", "240"}, new String[]{"ntilde", "241"}, new String[]{"ograve", "242"}, new String[]{"oacute", "243"}, new String[]{"ocirc", "244"}, new String[]{"otilde", "245"}, new String[]{"ouml", "246"}, new String[]{"divide", "247"}, new String[]{"oslash", "248"}, new String[]{"ugrave", "249"}, new String[]{"uacute", "250"}, new String[]{"ucirc", "251"}, new String[]{"uuml", "252"}, new String[]{"yacute", "253"}, new String[]{"thorn", "254"}, new String[]{"yuml", "255"}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String[][] f20392c = {new String[]{"fnof", "402"}, new String[]{"Alpha", "913"}, new String[]{"Beta", "914"}, new String[]{"Gamma", "915"}, new String[]{"Delta", "916"}, new String[]{"Epsilon", "917"}, new String[]{"Zeta", "918"}, new String[]{"Eta", "919"}, new String[]{"Theta", "920"}, new String[]{"Iota", "921"}, new String[]{"Kappa", "922"}, new String[]{"Lambda", "923"}, new String[]{"Mu", "924"}, new String[]{"Nu", "925"}, new String[]{"Xi", "926"}, new String[]{"Omicron", "927"}, new String[]{"Pi", "928"}, new String[]{"Rho", "929"}, new String[]{"Sigma", "931"}, new String[]{"Tau", "932"}, new String[]{"Upsilon", "933"}, new String[]{"Phi", "934"}, new String[]{"Chi", "935"}, new String[]{"Psi", "936"}, new String[]{"Omega", "937"}, new String[]{"alpha", "945"}, new String[]{"beta", "946"}, new String[]{"gamma", "947"}, new String[]{"delta", "948"}, new String[]{"epsilon", "949"}, new String[]{"zeta", "950"}, new String[]{"eta", "951"}, new String[]{"theta", "952"}, new String[]{"iota", "953"}, new String[]{"kappa", "954"}, new String[]{"lambda", "955"}, new String[]{"mu", "956"}, new String[]{"nu", "957"}, new String[]{"xi", "958"}, new String[]{"omicron", "959"}, new String[]{"pi", "960"}, new String[]{"rho", "961"}, new String[]{"sigmaf", "962"}, new String[]{"sigma", "963"}, new String[]{"tau", "964"}, new String[]{"upsilon", "965"}, new String[]{"phi", "966"}, new String[]{"chi", "967"}, new String[]{"psi", "968"}, new String[]{"omega", "969"}, new String[]{"thetasym", "977"}, new String[]{"upsih", "978"}, new String[]{"piv", "982"}, new String[]{"bull", "8226"}, new String[]{"hellip", "8230"}, new String[]{"prime", "8242"}, new String[]{"Prime", "8243"}, new String[]{"oline", "8254"}, new String[]{"frasl", "8260"}, new String[]{"weierp", "8472"}, new String[]{"image", "8465"}, new String[]{"real", "8476"}, new String[]{"trade", "8482"}, new String[]{"alefsym", "8501"}, new String[]{"larr", "8592"}, new String[]{"uarr", "8593"}, new String[]{"rarr", "8594"}, new String[]{"darr", "8595"}, new String[]{"harr", "8596"}, new String[]{"crarr", "8629"}, new String[]{"lArr", "8656"}, new String[]{"uArr", "8657"}, new String[]{"rArr", "8658"}, new String[]{"dArr", "8659"}, new String[]{"hArr", "8660"}, new String[]{"forall", "8704"}, new String[]{"part", "8706"}, new String[]{"exist", "8707"}, new String[]{"empty", "8709"}, new String[]{"nabla", "8711"}, new String[]{"isin", "8712"}, new String[]{"notin", "8713"}, new String[]{"ni", "8715"}, new String[]{"prod", "8719"}, new String[]{"sum", "8721"}, new String[]{"minus", "8722"}, new String[]{"lowast", "8727"}, new String[]{"radic", "8730"}, new String[]{"prop", "8733"}, new String[]{"infin", "8734"}, new String[]{"ang", "8736"}, new String[]{"and", "8743"}, new String[]{"or", "8744"}, new String[]{"cap", "8745"}, new String[]{"cup", "8746"}, new String[]{"int", "8747"}, new String[]{"there4", "8756"}, new String[]{"sim", "8764"}, new String[]{"cong", "8773"}, new String[]{"asymp", "8776"}, new String[]{"ne", "8800"}, new String[]{"equiv", "8801"}, new String[]{"le", "8804"}, new String[]{UserDataStore.GENDER, "8805"}, new String[]{VipProductType.SUB, "8834"}, new String[]{"sup", "8835"}, new String[]{"sube", "8838"}, new String[]{"supe", "8839"}, new String[]{"oplus", "8853"}, new String[]{"otimes", "8855"}, new String[]{"perp", "8869"}, new String[]{"sdot", "8901"}, new String[]{"lceil", "8968"}, new String[]{"rceil", "8969"}, new String[]{"lfloor", "8970"}, new String[]{"rfloor", "8971"}, new String[]{"lang", "9001"}, new String[]{"rang", "9002"}, new String[]{"loz", "9674"}, new String[]{"spades", "9824"}, new String[]{"clubs", "9827"}, new String[]{"hearts", "9829"}, new String[]{"diams", "9830"}, new String[]{"OElig", "338"}, new String[]{"oelig", "339"}, new String[]{"Scaron", "352"}, new String[]{"scaron", "353"}, new String[]{"Yuml", "376"}, new String[]{"circ", "710"}, new String[]{"tilde", "732"}, new String[]{"ensp", "8194"}, new String[]{"emsp", "8195"}, new String[]{"thinsp", "8201"}, new String[]{"zwnj", "8204"}, new String[]{"zwj", "8205"}, new String[]{"lrm", "8206"}, new String[]{"rlm", "8207"}, new String[]{"ndash", "8211"}, new String[]{"mdash", "8212"}, new String[]{"lsquo", "8216"}, new String[]{"rsquo", "8217"}, new String[]{"sbquo", "8218"}, new String[]{"ldquo", "8220"}, new String[]{"rdquo", "8221"}, new String[]{"bdquo", "8222"}, new String[]{"dagger", "8224"}, new String[]{"Dagger", "8225"}, new String[]{"permil", "8240"}, new String[]{"lsaquo", "8249"}, new String[]{"rsaquo", "8250"}, new String[]{"euro", "8364"}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[][] f20393d = {new String[]{"quot", "34"}, new String[]{"amp", "38"}, new String[]{"lt", "60"}, new String[]{"gt", "62"}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20390a = new a();

    /* JADX INFO: renamed from: com.twitter.sdk.android.tweetui.internal.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HtmlEntities.java */
    interface InterfaceC0175a {
        int a(String str);

        void add(String str, int i);
    }

    /* JADX INFO: compiled from: HtmlEntities.java */
    static class b extends c {
        b() {
        }
    }

    /* JADX INFO: compiled from: HtmlEntities.java */
    static class c implements InterfaceC0175a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f20395a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.twitter.sdk.android.tweetui.internal.a.b f20396b = new com.twitter.sdk.android.tweetui.internal.a.b();

        c() {
        }

        @Override // com.twitter.sdk.android.tweetui.internal.a.a.InterfaceC0175a
        public int a(String str) {
            Object obj = this.f20395a.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        @Override // com.twitter.sdk.android.tweetui.internal.a.a.InterfaceC0175a
        public void add(String str, int i) {
            this.f20395a.put(str, Integer.valueOf(i));
            this.f20396b.a(i, str);
        }
    }

    /* JADX INFO: compiled from: HtmlEntities.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<int[]> f20398b;

        public d(String str, ArrayList<int[]> arrayList) {
            this.f20397a = str;
            this.f20398b = arrayList;
        }
    }

    static {
        a(f20390a);
    }

    static void a(a aVar) {
        aVar.a(f20393d);
        aVar.a(f20391b);
        aVar.a(f20392c);
    }

    public d b(String str) {
        int iA;
        int iIntValue;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        ArrayList arrayList = new ArrayList(5);
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '&') {
                int i2 = i + 1;
                int iIndexOf = str.indexOf(59, i2);
                if (iIndexOf == -1) {
                    sb.append(cCharAt);
                } else {
                    String strSubstring = str.substring(i2, iIndexOf);
                    int length2 = strSubstring.length();
                    if (length2 <= 0) {
                        iA = -1;
                    } else if (strSubstring.charAt(0) != '#' || length2 <= 1) {
                        iA = a(strSubstring);
                    } else {
                        char cCharAt2 = strSubstring.charAt(1);
                        if (cCharAt2 == 'x' || cCharAt2 == 'X') {
                            iIntValue = length2 > 2 ? Integer.valueOf(strSubstring.substring(2), 16).intValue() : -1;
                            iA = iIntValue;
                        } else {
                            try {
                                iIntValue = Integer.parseInt(strSubstring.substring(1));
                            } catch (Exception unused) {
                            }
                            iA = iIntValue;
                        }
                    }
                    if (iA == -1) {
                        sb.append('&');
                        if (strSubstring.indexOf(38) == -1) {
                            sb.append(strSubstring);
                            sb.append(';');
                        }
                    } else {
                        sb.append((char) iA);
                        arrayList.add(new int[]{i, iIndexOf});
                    }
                    i = iIndexOf;
                }
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        return new d(sb.toString(), arrayList);
    }

    public void a(String[][] strArr) {
        for (String[] strArr2 : strArr) {
            a(strArr2[0], Integer.parseInt(strArr2[1]));
        }
    }

    public void a(String str, int i) {
        this.f20394e.add(str, i);
    }

    public int a(String str) {
        return this.f20394e.a(str);
    }
}
