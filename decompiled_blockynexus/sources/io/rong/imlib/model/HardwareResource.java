package io.rong.imlib.model;

/* JADX INFO: loaded from: classes5.dex */
public class HardwareResource {
    private ResourceType mResourceType;

    public enum ResourceType {
        AUDIO(1),
        VIDEO(2);

        private int value;

        ResourceType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static ResourceType valueOf(int i) {
            for (ResourceType resourceType : values()) {
                if (resourceType.value == i) {
                    return resourceType;
                }
            }
            return null;
        }
    }

    public ResourceType getmResourceType() {
        return this.mResourceType;
    }

    public void setmResourceType(ResourceType resourceType) {
        this.mResourceType = resourceType;
    }
}
