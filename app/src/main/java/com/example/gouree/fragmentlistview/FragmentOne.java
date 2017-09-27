package com.example.gouree.fragmentlistview;

import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by omsai on 26/09/2017.
 */

public class FragmentOne extends ListFragment
{
    //intitalizing the string and images

    String[] players={"\t\t\t Youtube \n Enjoy the videos and music you love, upload original content, and share it all with friends, family, and the world on YouTube.",
            "\t\t\t Blogger\n Publish your passions your way. Whether you'd like to share your knowledge, experiences or the latest news, create a unique and beautiful blog for free."};
    int[] images={R.drawable.youtube,R.drawable.blogger};

    //using arraylist and adapter
    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from={"Player","Image"};
        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView1};
        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onStart() {

        super.onStart();
       getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id)
            {
              //display toast on click of item
                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

