package com.oxilo.tsleehapp.enums.fragments;


import com.oxilo.tsleehapp.collections.enums.AbbreviationMap;

public enum FragmentTag {
    MENU("MENU_FRAGMENT"),
    LIST("LIST_FRAGMENT"),
    LIST_DEATIL("LIST_DEATIL");

    private final String abbreviation;

    /**
     * Reverse-lookup map for getting a fragment tag from an abbreviation
     */
    // private static final Map<String, FragmentTag> lookup = new HashMap<String, FragmentTag>();
    private static final AbbreviationMap<String, FragmentTag> lookup = new AbbreviationMap<String, FragmentTag>();

    static {
        for (FragmentTag tag : FragmentTag.values()) {
            lookup.put(tag.getAbbreviation(), tag);
        }
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static FragmentTag get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    FragmentTag(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
