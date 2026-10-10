package cn.qqtheme.framework.entity;

import cn.qqtheme.framework.util.LogUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class JavaBean implements Serializable {
    private static final long serialVersionUID = -6111323241670458039L;

    public String toString() {
        int i;
        ArrayList arrayList = new ArrayList();
        Class<?> superclass = getClass();
        arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            i = 0;
            if (superclass == Object.class) {
                break;
            }
            superclass = superclass.getSuperclass();
            Field[] declaredFields = superclass.getDeclaredFields();
            int length = declaredFields.length;
            while (i < length) {
                Field field = declaredFields[i];
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                    arrayList.add(field);
                }
                i++;
            }
        }
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[arrayList.size()]);
        int length2 = fieldArr.length;
        while (i < length2) {
            Field field2 = fieldArr[i];
            String name = field2.getName();
            try {
                Object obj = field2.get(this);
                sb.append(name);
                sb.append("=");
                sb.append(obj);
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            } catch (IllegalAccessException e2) {
                LogUtils.error(e2);
            }
            i++;
        }
        return sb.toString();
    }
}
