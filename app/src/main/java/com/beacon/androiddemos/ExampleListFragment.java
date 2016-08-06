package com.beacon.androiddemos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.beacon.listpopupmenu.ListPopupMenuActivity;
import com.beacon.newsreader.NewsReaderActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    // The list of headlines that we are displaying
    Example[] mExamples;

    // The list adapter for the list we are displaying
    ArrayAdapter<String> mListAdapter;

    /**
     * Default constructor required by framework.
     */
    public ExampleListFragment() {
        super();
    }

    @Override
    public void onStart() {
        super.onStart();
        setListAdapter(mListAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mExamples = Example.examples();

        List<String> exampleTitles = Example.exampleTitles(Arrays.asList(mExamples));
        mListAdapter = new ArrayAdapter(getActivity(), R.layout.example_item,
                exampleTitles);
    }

    /**
     * Handles a click on a headline.
     *
     * This causes the configured listener to be notified that a headline was selected.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Example example = mExamples[position];
        example.startExample(getActivity());
    }
}

class Example {
    final String name;
    Class activityClass;

    Example(String name, Class activityClass) {
        super();
        this.name = name;
        this.activityClass = activityClass;
    }

    public void startExample(Context context) {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }

    static List<String> exampleTitles(List<Example> examples) {
        List<String> titles = new ArrayList<>();
        for (Example example : examples) {
            titles.add(example.name);
        }
        return titles;
    }

    static Example[] examples() {
        return new Example[] {
                new Example("News Reader", NewsReaderActivity.class),
                new Example("List Popup Menu", ListPopupMenuActivity.class),
                new Example("Action Bar Share Action", com.beacon.actionbarshareaction.MainActivity.class),
                new Example("Navigation Drawer", com.beacon.navigationdrawer.MainActivity.class),
                new Example("RecyclerView", com.beacon.recyclerview.recyclerview.MainActivity.class),
                new Example("CardView", com.beacon.cardview.CardViewActivity.class),
                new Example("Float Action Button Basic", com.beacon.floatactionbuttonbasic.floatingactionbuttonbasic.MainActivity.class),
                new Example("Activity Transition Basic", com.beacon.activityscenetransitionbasic.activityscenetransitionbasic.MainActivity.class),
        };
    }
}
