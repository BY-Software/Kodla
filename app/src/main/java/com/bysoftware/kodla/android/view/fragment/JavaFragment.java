package com.bysoftware.kodla.android.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bysoftware.kodla.android.R;
import com.bysoftware.kodla.android.view.adapter.TipAdapter;
import com.bysoftware.kodla.android.view.model.Tip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JavaFragment extends Fragment {
    private List<Tip> tipList = new ArrayList<Tip>();
    @BindView(R.id.tip_list)
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tipList.add(new Tip(getString(R.string.java_tip_1)));
        tipList.add(new Tip(getString(R.string.java_tip_2)));
        tipList.add(new Tip(getString(R.string.java_tip_3)));
        tipList.add(new Tip(getString(R.string.java_tip_4)));
        tipList.add(new Tip(getString(R.string.java_tip_5)));
        TipAdapter tipAdapter = new TipAdapter(getActivity(), R.layout.row_icon, tipList);
        listView.setAdapter(tipAdapter);
    }
}
