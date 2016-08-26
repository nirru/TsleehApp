package com.oxilo.tsleehapp.enums.fragments;

import com.oxilo.tsleehapp.R;
import com.oxilo.tsleehapp.collections.enums.AbbreviationMap;

/**
 * Created by ericbasendra on 26/08/16.
 */
public enum TransitionType {
    // we not have animation
    NONE (0),

    // Image Transform between fragments/Activity
    IMAGE_TRANSFORM (R.transition.change_image_transform),

    // Move content and fade between fragments
    EXPLODE (android.R.transition.explode);

    private final int abbreviation;

    /**
     * Reverse-lookup map for getting a fragment tag from an abbreviation
     */
    private static final AbbreviationMap<String, FragmentAnimationType> lookup = new AbbreviationMap<String, FragmentAnimationType>();

    static {
        for (FragmentAnimationType tag : FragmentAnimationType.values()) {
            lookup.put(tag.getAbbreviation(), tag);
        }
    }


    public int getAbbreviation() {
        return abbreviation;
    }

    public static FragmentAnimationType get(String abbreviation) {
        return lookup.get(abbreviation);
    }


    TransitionType(int abbreviation) {
        this.abbreviation = abbreviation;
    }

}
