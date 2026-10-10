package freemarker.ext.beans;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: UnsafeMethods.java */
/* JADX INFO: loaded from: classes5.dex */
class ta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f21639a = b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21640b;

    static boolean a(Method method) {
        return f21639a.contains(method);
    }

    private static final Set b() throws Throwable {
        Properties properties = new Properties();
        Class clsA = f21640b;
        if (clsA == null) {
            clsA = a("freemarker.ext.beans.BeansWrapper");
            f21640b = clsA;
        }
        InputStream resourceAsStream = clsA.getResourceAsStream("unsafeMethods.txt");
        if (resourceAsStream == null) {
            return Collections.EMPTY_SET;
        }
        String str = null;
        try {
            try {
                properties.load(resourceAsStream);
                resourceAsStream.close();
                HashSet hashSet = new HashSet((properties.size() * 4) / 3, 1.0f);
                Map mapA = a();
                for (String str2 : properties.keySet()) {
                    try {
                        try {
                            try {
                                hashSet.add(a(str2, mapA));
                            } catch (ClassNotFoundException e2) {
                                if (C2874u.f21642b) {
                                    throw e2;
                                }
                            }
                        } catch (NoSuchMethodException e3) {
                            if (C2874u.f21642b) {
                                throw e3;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str = str2;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Could not load unsafe method ");
                        stringBuffer.append(str);
                        stringBuffer.append(" ");
                        stringBuffer.append(e.getClass().getName());
                        stringBuffer.append(" ");
                        stringBuffer.append(e.getMessage());
                        throw new RuntimeException(stringBuffer.toString());
                    }
                }
                return hashSet;
            } catch (Throwable th) {
                resourceAsStream.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static Method a(String str, Map map) throws NoSuchMethodException, ClassNotFoundException {
        int iIndexOf = str.indexOf(40);
        int iLastIndexOf = str.lastIndexOf(46, iIndexOf);
        Class clsB = freemarker.template.utility.a.b(str.substring(0, iLastIndexOf));
        String strSubstring = str.substring(iLastIndexOf + 1, iIndexOf);
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(iIndexOf + 1, str.length() - 1), ",");
        int iCountTokens = stringTokenizer.countTokens();
        Class<?>[] clsArr = new Class[iCountTokens];
        for (int i = 0; i < iCountTokens; i++) {
            String strNextToken = stringTokenizer.nextToken();
            clsArr[i] = (Class) map.get(strNextToken);
            if (clsArr[i] == null) {
                clsArr[i] = freemarker.template.utility.a.b(strNextToken);
            }
        }
        return clsB.getMethod(strSubstring, clsArr);
    }

    private static Map a() {
        HashMap map = new HashMap();
        map.put("boolean", Boolean.TYPE);
        map.put("byte", Byte.TYPE);
        map.put("char", Character.TYPE);
        map.put("short", Short.TYPE);
        map.put("int", Integer.TYPE);
        map.put("long", Long.TYPE);
        map.put("float", Float.TYPE);
        map.put("double", Double.TYPE);
        return map;
    }
}
