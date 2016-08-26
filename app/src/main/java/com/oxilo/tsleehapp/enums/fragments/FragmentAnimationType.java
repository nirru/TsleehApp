package com.oxilo.tsleehapp.enums.fragments;


import com.oxilo.tsleehapp.collections.enums.AbbreviationMap;

public enum FragmentAnimationType {
    // we not have animation
    NONE ("NONE"),

    // fade between fragments
    FADE_IN_FADE_OUT ("FADE_IN_FADE_OUT"),

    // Move content and fade between fragments
    ENTER_RIGHT_AND_FADE_IN_EXIT_RIGHT_FADE_OUT ("ENTER_RIGHT_AND_FADE_IN_EXIT_RIGHT_FADE_OUT");

    private final String abbreviation;

    /**
     * Reverse-lookup map for getting a fragment tag from an abbreviation
     */
    private static final AbbreviationMap<String, FragmentAnimationType> lookup = new AbbreviationMap<String, FragmentAnimationType>();

    static {
        for (FragmentAnimationType tag : FragmentAnimationType.values()) {
            lookup.put(tag.getAbbreviation(), tag);
        }
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static FragmentAnimationType get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    private FragmentAnimationType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
