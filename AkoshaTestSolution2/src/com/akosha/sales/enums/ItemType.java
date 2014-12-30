package com.akosha.sales.enums;

public enum ItemType {
    EXEMPTED(true, false),
    OTHERS(false, false),
    IMPORTED_EXEMPTED(true, true),
    IMPORTED_OTHERS(false, true);

    private boolean isExempted;
    private boolean isImported;

    private ItemType(boolean exepmted, boolean imported) {
        isExempted = exepmted;
        isImported = imported;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempted() {
        return isExempted;
    }
}
