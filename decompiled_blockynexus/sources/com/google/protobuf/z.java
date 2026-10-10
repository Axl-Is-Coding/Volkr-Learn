package com.google.protobuf;

import cn.qqtheme.framework.widget.WheelView;
import com.google.protobuf.GeneratedMessageLite;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: MessageLiteToString.java */
/* JADX INFO: loaded from: classes2.dex */
final class z {
    static String a(x xVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(xVar, sb, 0);
        return sb.toString();
    }

    private static void a(x xVar, StringBuilder sb, int i) {
        boolean zBooleanValue;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : xVar.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String strReplaceFirst = ((String) it.next()).replaceFirst("get", "");
            if (strReplaceFirst.endsWith("List") && !strReplaceFirst.endsWith("OrBuilderList")) {
                String str = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 4);
                Method method2 = (Method) map.get("get" + strReplaceFirst);
                if (method2 != null) {
                    a(sb, i, a(str), GeneratedMessageLite.invokeOrDie(method2, xVar, new Object[0]));
                }
            }
            if (((Method) map2.get("set" + strReplaceFirst)) != null) {
                if (strReplaceFirst.endsWith("Bytes")) {
                    if (map.containsKey("get" + strReplaceFirst.substring(0, strReplaceFirst.length() - 5))) {
                    }
                }
                String str2 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1);
                Method method3 = (Method) map.get("get" + strReplaceFirst);
                Method method4 = (Method) map.get("has" + strReplaceFirst);
                if (method3 != null) {
                    Object objInvokeOrDie = GeneratedMessageLite.invokeOrDie(method3, xVar, new Object[0]);
                    if (method4 == null) {
                        zBooleanValue = !a(objInvokeOrDie);
                    } else {
                        zBooleanValue = ((Boolean) GeneratedMessageLite.invokeOrDie(method4, xVar, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        a(sb, i, a(str2), objInvokeOrDie);
                    }
                }
            }
        }
        if (xVar instanceof GeneratedMessageLite.c) {
            Iterator<Map.Entry<FieldDescriptorType, Object>> itB = ((GeneratedMessageLite.c) xVar).f14286a.b();
            while (itB.hasNext()) {
                Map.Entry entry = (Map.Entry) itB.next();
                a(sb, i, "[" + ((GeneratedMessageLite.e) entry.getKey()).a() + "]", entry.getValue());
            }
        }
        K k = ((GeneratedMessageLite) xVar).unknownFields;
        if (k != null) {
            k.a(sb, i);
        }
    }

    private static boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == WheelView.DividerConfig.FILL;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof String) {
            return obj.equals("");
        }
        if (obj instanceof ByteString) {
            return obj.equals(ByteString.EMPTY);
        }
        return obj instanceof x ? obj == ((x) obj).getDefaultInstanceForType() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
    }

    static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(J.a((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(J.a((ByteString) obj));
            sb.append('\"');
        } else {
            if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                a((GeneratedMessageLite) obj, sb, i + 2);
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                for (int i3 = 0; i3 < i; i3++) {
                    sb.append(' ');
                }
                sb.append("}");
                return;
            }
            sb.append(": ");
            sb.append(obj.toString());
        }
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }
}
