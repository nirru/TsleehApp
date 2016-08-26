package com.oxilo.tsleehapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oxilo.tsleehapp.R;
import com.oxilo.tsleehapp.adapter.ListAdapter;
import com.oxilo.tsleehapp.dummy.DummyContent;
import com.oxilo.tsleehapp.enums.fragments.FragmentAnimationType;
import com.oxilo.tsleehapp.enums.fragments.FragmentTag;
import com.oxilo.tsleehapp.enums.fragments.TransitionType;
import com.oxilo.tsleehapp.uiView.DividerItemDecoration;
import com.oxilo.tsleehapp.uiView.ScreenDensity;
import com.oxilo.tsleehapp.uiView.VerticalSpaceItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final int VERTICAL_ITEM_SPACE = 20;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ListAdapter listAdapter;
    RecyclerView mRecyleView;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInstance();
        initUiView(view);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void initInstance(){
        listAdapter = new ListAdapter(DummyContent.ITEMS,getActivity());
        listAdapter.setOnItemClickListener(new ListAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
               BaseFragment.loadFragmentTransaction((AppCompatActivity)getActivity(),R.id.fragment,FragmentTag.LIST_DEATIL.getAbbreviation(),
                FragmentTag.LIST.getAbbreviation(), TransitionType.EXPLODE,v,"add");
            }
        });
    }

    private void initUiView(View view){
        mRecyleView = (RecyclerView)view.findViewById(R.id.id_recyleview);
        mRecyleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //add ItemDecoration
        int marginInDp = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, VERTICAL_ITEM_SPACE, getResources()
                        .getDisplayMetrics());
        mRecyleView.addItemDecoration(new VerticalSpaceItemDecoration(marginInDp));
        //or
        mRecyleView.addItemDecoration(new DividerItemDecoration(getActivity()));
        //or
//        mRecyleView.addItemDecoration(
//                new DividerItemDecoration(getActivity(), R.drawable.divider));
        mRecyleView.setAdapter(listAdapter);
    }

}
