package hcmute.edu.vn.customspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1Action;
    Fragment2 fragment2Action;
    Fragment3 fragment3Action;
    ListView listView1;
    ListView listView2;
    ListView listView3;
    Spinner spinner;

    Button buttonLogout;
    FirebaseAuth Auth;
    FirebaseUser user;

    TextView textView;
    Switch switcher;
    boolean nightMode;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switcher = findViewById(R.id.switcher);
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        Auth = FirebaseAuth.getInstance();
        buttonLogout = findViewById(R.id.logout);
        user = Auth.getCurrentUser();
        if (user == null)
        {
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();
        }
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });


        spinner = findViewById(R.id.spinner);
//        listView1 = findViewById(R.id.listViewFragment1);
//        listView2 = findViewById(R.id.listViewFragment2);
//        listView3 = findViewById(R.id.listViewFragment3);
        fragment1Action = new Fragment1();
        fragment2Action = new Fragment2();
        fragment3Action = new Fragment3();
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.area_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //String[] value = {"Nam","Đông","Bắc"};
        //ArrayList<String> arrayListSpinner = new ArrayList<>(Arrays.asList(value));
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.style_spinner,arrayListSpinner);
        //spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        selectFragment(fragment1Action);
                        break;
                    case 1:
                        selectFragment(fragment2Action);
                        break;
                    case 2:
                        selectFragment(fragment3Action);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (i){
//                    case 0:
//                        selectFragment(fragment1Action);
//                        break;
//                    case 1:
//                        selectFragment(fragment2Action);
//                        break;
//                    case 2:
//                        selectFragment(fragment3Action);
//                        break;
//                }
//            }
//        });
        // Create ListView Data
//        ArrayList<Person> arrayListPerson = new ArrayList<>();
//
//        arrayListPerson.add(new Person(R.drawable.item1,"Danh Truong Son","He is a 21 year old and living in Sai Gon1"));
//        arrayListPerson.add(new Person(R.drawable.item2,"Dang Phuoc Truong Tai","He is a 21 year old and living in Sai Gon2"));
//        arrayListPerson.add(new Person(R.drawable.item3,"Danh Thanh Tuyen","He is a 21 year old and living in Sai Gon3"));
//
//        // We make custom adapter
//
//        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,arrayListPerson);
//
//        listView.setAdapter(personAdapter);



    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout,fragment);
        fragmentTransaction.commit();

    }
}