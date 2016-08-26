package com.oxilo.tsleehapp.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oxilo.tsleehapp.R;
import com.oxilo.tsleehapp.enums.fragments.FragmentAnimationType;
import com.oxilo.tsleehapp.enums.fragments.FragmentTag;

/**
 * A placeholder fragment containing a simple view.
 */
public class LandingActivityFragment extends BaseFragment {

    ImageView cleaningBtn,pestBtn,electricalBtn,plumbingBtn,applianceBtn,carpentryBtn;
    TextView cleaningView,pestView,electricalView,plumbingView,applianceView,carpentryView;

    public LandingActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_landing, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    public void initViews(View view){
        cleaningBtn = (ImageView)view.findViewById(R.id.button_cleaning);
        pestBtn = (ImageView)view.findViewById(R.id.button_pest);
        electricalBtn = (ImageView)view.findViewById(R.id.button_electrical);
        plumbingBtn = (ImageView)view.findViewById(R.id.button_plumbing);
        applianceBtn = (ImageView)view.findViewById(R.id.button_appliance);
        carpentryBtn = (ImageView)view.findViewById(R.id.button_carpentry);

        cleaningView = (TextView) view.findViewById(R.id.text_cleaning);
        pestView = (TextView)view.findViewById(R.id.text_pest);
        electricalView = (TextView)view.findViewById(R.id.text_electrical);
        plumbingView = (TextView)view.findViewById(R.id.text_plumbing);
        applianceView = (TextView)view.findViewById(R.id.text_appliance);
        carpentryView = (TextView)view.findViewById(R.id.text_carpentry);

        cleaningBtn.setOnClickListener(l);
        pestBtn.setOnClickListener(l);
        electricalBtn.setOnClickListener(l);
        plumbingBtn.setOnClickListener(l);
        applianceBtn.setOnClickListener(l);
        carpentryBtn.setOnClickListener(l);

    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            BaseFragment.loadFragmentTransaction((AppCompatActivity)getActivity(), R.id.fragment, FragmentTag.LIST.getAbbreviation(), FragmentAnimationType.NONE);
        }
    };
}
