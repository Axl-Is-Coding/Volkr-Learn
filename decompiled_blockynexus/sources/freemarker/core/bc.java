package freemarker.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import com.umeng.analytics.pro.au;
import java.io.Writer;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: _CoreAPI.java */
/* JADX INFO: loaded from: classes5.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f21519a;

    static {
        TreeSet treeSet = new TreeSet();
        treeSet.add("assign");
        treeSet.add("attempt");
        treeSet.add("break");
        treeSet.add("call");
        treeSet.add("case");
        treeSet.add("comment");
        treeSet.add("compress");
        treeSet.add(StringConstant.PARTY_GAME_CATEGORY_DEFAULT);
        treeSet.add("else");
        treeSet.add("elseif");
        treeSet.add("elseIf");
        treeSet.add("escape");
        treeSet.add("fallback");
        treeSet.add("flush");
        treeSet.add("foreach");
        treeSet.add("forEach");
        treeSet.add("ftl");
        treeSet.add("function");
        treeSet.add("global");
        treeSet.add("if");
        treeSet.add("import");
        treeSet.add("include");
        treeSet.add(FirebaseAnalytics.Param.ITEMS);
        treeSet.add("list");
        treeSet.add("local");
        treeSet.add("lt");
        treeSet.add("macro");
        treeSet.add("nested");
        treeSet.add("noescape");
        treeSet.add("noEscape");
        treeSet.add("noparse");
        treeSet.add("noParse");
        treeSet.add("nt");
        treeSet.add("recover");
        treeSet.add("recurse");
        treeSet.add("return");
        treeSet.add("rt");
        treeSet.add("sep");
        treeSet.add("setting");
        treeSet.add("stop");
        treeSet.add("switch");
        treeSet.add(au.az);
        treeSet.add("transform");
        treeSet.add("visit");
        f21519a = Collections.unmodifiableSet(treeSet);
    }

    public static Xb[] a(Environment environment) {
        return environment.g();
    }

    public static void a(Xb[] xbArr, boolean z, Writer writer) {
        Environment.a(xbArr, z, writer);
    }
}
