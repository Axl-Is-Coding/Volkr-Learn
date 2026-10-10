package io.rong.imkit;

import com.sandboxol.vip.entity.VipDiamond;

/* JADX INFO: loaded from: classes5.dex */
public class InputBar {

    public enum Style {
        STYLE_SWITCH_CONTAINER_EXTENSION(291),
        STYLE_SWITCH_CONTAINER(288),
        STYLE_CONTAINER_EXTENSION(35),
        STYLE_EXTENSION_CONTAINER(VipDiamond.MVP),
        STYLE_CONTAINER(32);

        int v;

        Style(int i) {
            this.v = i;
        }

        public static Style getStyle(int i) {
            for (Style style : values()) {
                if (style.v == i) {
                    return style;
                }
            }
            return null;
        }
    }

    public enum Type {
        TYPE_DEFAULT,
        TYPE_CS_ROBOT,
        TYPE_CS_HUMAN,
        TYPE_CS_ROBOT_FIRST,
        TYPE_CS_HUMAN_FIRST
    }
}
