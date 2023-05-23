package hcmute.edu.vn.customspinner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment2 extends Fragment implements AdapterView.OnItemClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Person> arrayListPerson = new ArrayList<>();

        arrayListPerson.add(new Person(R.drawable.item1,"Fragment2.1 (Đông)","He is a 21 year old and living in Sai Gon1"));
        arrayListPerson.add(new Person(R.drawable.item2,"Fragment2.2 (Đông)","He is a 21 year old and living in Sai Gon2"));
        arrayListPerson.add(new Person(R.drawable.item3,"Fragment2.3 (Đông)","He is a 21 year old and living in Sai Gon3"));

        ListView listView=(ListView)view.findViewById(R.id.listViewFragment2);

        PersonAdapter personAdapter = new PersonAdapter(getActivity(),R.layout.list_row,arrayListPerson);
        listView.setAdapter(personAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0)
        {
            Toast.makeText(getActivity(),"Danh Truong Son",Toast.LENGTH_LONG).show();
        }
        if(i == 1)
        {
            Toast.makeText(getActivity(),"Dang Phuoc Truong Tai",Toast.LENGTH_LONG).show();
        }
        if(i == 2)
        {
            Toast.makeText(getActivity(),"Danh Thanh Tuyen",Toast.LENGTH_LONG).show();
        }
    }
}