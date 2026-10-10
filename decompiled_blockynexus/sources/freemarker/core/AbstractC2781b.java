package freemarker.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import com.tendcloud.tenddata.cp;
import java.util.HashMap;

/* JADX INFO: renamed from: freemarker.core.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BuiltIn.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractC2781b extends Hb implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final HashMap f21518f = new HashMap(379, 0.67f);
    protected Hb g;
    protected String h;

    static {
        a("abs", new C2809ka());
        a("ancestors", new C2782ba());
        a("api", new C());
        a("boolean", new C2822ob());
        a("byte", new C2812la());
        a("c", new D());
        a("cap_first", "capFirst", new Ia());
        a("capitalize", new Ja());
        a("ceiling", new C2815ma());
        a("children", new C2785ca());
        a("chop_linebreak", "chopLinebreak", new Ka());
        a("contains", new La());
        a("date", new E(2));
        a("date_if_unknown", "dateIfUnknown", new C2811l(2));
        a("datetime", new E(3));
        a("datetime_if_unknown", "datetimeIfUnknown", new C2811l(3));
        a(StringConstant.PARTY_GAME_CATEGORY_DEFAULT, new Db());
        a("double", new C2818na());
        a("ends_with", "endsWith", new Ma());
        a("ensure_ends_with", "ensureEndsWith", new Na());
        a("ensure_starts_with", "ensureStartsWith", new Oa());
        a("eval", new C2825pb());
        a("exists", new Eb());
        a("first", new Aa());
        a("float", new C2821oa());
        a("floor", new C2824pa());
        a("chunk", new C2853za());
        a("counter", new r());
        a("item_cycle", "itemCycle", new C2849y());
        a("has_api", "hasApi", new F());
        a("has_content", "hasContent", new Fb());
        a("has_next", "hasNext", new C2831s());
        a("html", new C2795fb());
        a("if_exists", "ifExists", new Gb());
        a(FirebaseAnalytics.Param.INDEX, new C2834t());
        a("index_of", "indexOf", new Pa(false));
        a("int", new C2827qa());
        a("interpret", new Mb());
        a("is_boolean", "isBoolean", new G());
        a("is_collection", "isCollection", new H());
        a("is_collection_ex", "isCollectionEx", new I());
        J j = new J();
        a("is_date", "isDate", j);
        a("is_date_like", "isDateLike", j);
        a("is_date_only", "isDateOnly", new K(2));
        a("is_even_item", "isEvenItem", new C2837u());
        a("is_first", "isFirst", new C2840v());
        a("is_last", "isLast", new C2843w());
        a("is_unknown_date_like", "isUnknownDateLike", new K(0));
        a("is_datetime", "isDatetime", new K(3));
        a("is_directive", "isDirective", new L());
        a("is_enumerable", "isEnumerable", new M());
        a("is_hash_ex", "isHashEx", new O());
        a("is_hash", "isHash", new N());
        a("is_infinite", "isInfinite", new C2829ra());
        a("is_indexable", "isIndexable", new P());
        a("is_macro", "isMacro", new Q());
        a("is_method", "isMethod", new S());
        a("is_nan", "isNan", new C2832sa());
        a("is_node", "isNode", new T());
        a("is_number", "isNumber", new U());
        a("is_odd_item", "isOddItem", new C2846x());
        a("is_sequence", "isSequence", new V());
        a("is_string", "isString", new W());
        a("is_time", "isTime", new K(1));
        a("is_transform", "isTransform", new X());
        a("iso_utc", "isoUtc", new C2817n(null, 6, true));
        a("iso_utc_fz", "isoUtcFZ", new C2817n(Boolean.TRUE, 6, true));
        a("iso_utc_nz", "isoUtcNZ", new C2817n(Boolean.FALSE, 6, true));
        a("iso_utc_ms", "isoUtcMs", new C2817n(null, 7, true));
        a("iso_utc_ms_nz", "isoUtcMsNZ", new C2817n(Boolean.FALSE, 7, true));
        a("iso_utc_m", "isoUtcM", new C2817n(null, 5, true));
        a("iso_utc_m_nz", "isoUtcMNZ", new C2817n(Boolean.FALSE, 5, true));
        a("iso_utc_h", "isoUtcH", new C2817n(null, 4, true));
        a("iso_utc_h_nz", "isoUtcHNZ", new C2817n(Boolean.FALSE, 4, true));
        a("iso_local", "isoLocal", new C2817n(null, 6, false));
        a("iso_local_nz", "isoLocalNZ", new C2817n(Boolean.FALSE, 6, false));
        a("iso_local_ms", "isoLocalMs", new C2817n(null, 7, false));
        a("iso_local_ms_nz", "isoLocalMsNZ", new C2817n(Boolean.FALSE, 7, false));
        a("iso_local_m", "isoLocalM", new C2817n(null, 5, false));
        a("iso_local_m_nz", "isoLocalMNZ", new C2817n(Boolean.FALSE, 5, false));
        a("iso_local_h", "isoLocalH", new C2817n(null, 4, false));
        a("iso_local_h_nz", "isoLocalHNZ", new C2817n(Boolean.FALSE, 4, false));
        a("iso", new C2814m(null, 6));
        a("iso_nz", "isoNZ", new C2814m(Boolean.FALSE, 6));
        a("iso_ms", "isoMs", new C2814m(null, 7));
        a("iso_ms_nz", "isoMsNZ", new C2814m(Boolean.FALSE, 7));
        a("iso_m", "isoM", new C2814m(null, 5));
        a("iso_m_nz", "isoMNZ", new C2814m(Boolean.FALSE, 5));
        a("iso_h", "isoH", new C2814m(null, 4));
        a("iso_h_nz", "isoHNZ", new C2814m(Boolean.FALSE, 4));
        a("j_string", "jString", new C2798gb());
        a("join", new Ba());
        a("js_string", "jsString", new C2801hb());
        a("json_string", "jsonString", new C2804ib());
        a("keep_after", "keepAfter", new Qa());
        a("keep_before", "keepBefore", new Sa());
        a("keep_after_last", "keepAfterLast", new Ra());
        a("keep_before_last", "keepBeforeLast", new Ta());
        a("keys", new C2820o());
        a("last_index_of", "lastIndexOf", new Pa(true));
        a("last", new Ca());
        a("left_pad", "leftPad", new Wa(true));
        a(cp.a.LENGTH, new Ua());
        a("long", new C2835ta());
        a("lower_abc", "lowerAbc", new C2838ua());
        a("lower_case", "lowerCase", new Va());
        a("namespace", new Y());
        a("new", new Pb());
        a("node_name", "nodeName", new C2788da());
        a("node_namespace", "nodeNamespace", new C2791ea());
        a("node_type", "nodeType", new C2794fa());
        a("number", new C2828qb());
        a("number_to_date", "numberToDate", new C2841va(2));
        a("number_to_time", "numberToTime", new C2841va(1));
        a("number_to_datetime", "numberToDatetime", new C2841va(3));
        a("parent", new C2797ga());
        a("item_parity", "itemParity", new C2852z());
        a("item_parity_cap", "itemParityCap", new A());
        a("reverse", new Da());
        a("right_pad", "rightPad", new Wa(false));
        a("root", new C2800ha());
        a("round", new C2844wa());
        a("remove_ending", "removeEnding", new Ya());
        a("remove_beginning", "removeBeginning", new Xa());
        a("rtf", new C2807jb());
        a("seq_contains", "seqContains", new Ea());
        a("seq_index_of", "seqIndexOf", new Fa(1));
        a("seq_last_index_of", "seqLastIndexOf", new Fa(-1));
        a("short", new C2847xa());
        a("size", new Z());
        a("sort_by", "sortBy", new Ha());
        a("sort", new Ga());
        a("split", new Za());
        a("switch", new C2839ub());
        a("starts_with", "startsWith", new _a());
        a("string", new C2779aa());
        a("substring", new C2780ab());
        a("then", new C2842vb());
        a("time", new E(1));
        a("time_if_unknown", "timeIfUnknown", new C2811l(1));
        a("trim", new C2783bb());
        a("uncap_first", "uncapFirst", new C2786cb());
        a("upper_abc", "upperAbc", new C2850ya());
        a("upper_case", "upperCase", new C2789db());
        a("url", new C2810kb());
        a("url_path", "urlPath", new C2813lb());
        a("values", new C2823p());
        a("web_safe", "webSafe", (AbstractC2781b) f21518f.get("html"));
        a("word_list", "wordList", new C2792eb());
        a("xhtml", new C2816mb());
        a("xml", new C2819nb());
        a("matches", new C2833sb());
        a("groups", new C2830rb());
        a("replace", new C2836tb());
        if (252 >= f21518f.size()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Update NUMBER_OF_BIS! Should be: ");
        stringBuffer.append(f21518f.size());
        throw new AssertionError(stringBuffer.toString());
    }

    AbstractC2781b() {
    }

    private static void a(String str, AbstractC2781b abstractC2781b) {
        f21518f.put(str, abstractC2781b);
    }

    @Override // freemarker.core.Yb
    Object b(int i) {
        if (i == 0) {
            return this.g;
        }
        if (i == 1) {
            return this.h;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.Yb
    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.g.e());
        stringBuffer.append("?");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }

    @Override // freemarker.core.Yb
    String h() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }

    @Override // freemarker.core.Yb
    int i() {
        return 2;
    }

    private static void a(String str, String str2, AbstractC2781b abstractC2781b) {
        f21518f.put(str, abstractC2781b);
        f21518f.put(str2, abstractC2781b);
    }

    @Override // freemarker.core.Yb
    Qb a(int i) {
        if (i == 0) {
            return Qb.f21489b;
        }
        if (i == 1) {
            return Qb.f21490c;
        }
        throw new IndexOutOfBoundsException();
    }
}
