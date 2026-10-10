package com.google.android.ads.mediationtestsuite.viewmodels;

/* JADX INFO: loaded from: classes.dex */
public interface ListItemViewModel {

    public enum ViewType {
        HEADER(1),
        INFO_LABEL(2),
        DETAIL_ITEM(3),
        AD_LOAD(4);

        private final int id;

        ViewType(int i) {
            this.id = i;
        }

        public static ViewType withValue(int i) {
            for (ViewType viewType : values()) {
                if (i == viewType.id) {
                    return viewType;
                }
            }
            return null;
        }

        public int getId() {
            return this.id;
        }
    }

    ViewType getViewType();
}
