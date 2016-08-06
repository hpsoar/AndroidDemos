package com.beacon.androiddemos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.beacon.newsreader.NewsReaderActivity;
import com.beacon.androiddemos.R;

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

        mExamples = new Example[] {
            new Example("News Reader", NewsReaderActivity.class),
        };

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
}
