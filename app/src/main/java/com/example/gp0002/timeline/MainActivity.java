package com.example.gp0002.timeline;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentTabHost を取得する
        FragmentTabHost host = (FragmentTabHost) findViewById(android.R.id.tabhost);
        host.setup(this, getSupportFragmentManager(), R.id.content);

//        tab specを生成
        TabSpec tabSpec1 = host.newTabSpec("Tab1");
//        Button button1 = new Button(this);
//        button1.setBackgroundResource(R.drawable.ic_launcher);
        tabSpec1.setIndicator("左");

//        fragmentの画面に表示させる文言をBundleの"name"でセーブさせる
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", "最初の画面");
//        tab hostに追加
        host.addTab(tabSpec1, SampleFragment.class, bundle1);

        TabSpec tabSpec2 = host.newTabSpec("tab2");
        Button button2 = new Button(this);
        button2.setBackgroundResource(R.drawable.ic_launcher);
        tabSpec2.setIndicator(button2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", "Tab2");
//        tab hostに追加
        host.addTab(tabSpec2, SampleFragment.class, bundle2);

        TabSpec tabSpec3 = host.newTabSpec("tab3");
        Button button3 = new Button(this);
        button3.setBackgroundResource(R.drawable.ic_launcher);
        tabSpec3.setIndicator(button3);
        Bundle bundle3 = new Bundle();
        bundle3.putString("name", "Tab3");
        host.addTab(tabSpec3, SampleFragment.class, bundle3);
    }

    public static class SampleFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            textView.setText(getArguments().getString("name"));
            return textView;
        }
    }
}