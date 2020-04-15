package com.example.coronavirushelplines;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.search_edit_text)
    AppCompatEditText searchEditText;

   private List<StatesModel> states;
   HomeAdapter homeAdapter;

   @BindView(R.id.more)
    AppCompatImageView popMenu;

   @BindView(R.id.testIcon)
    AppCompatImageView testIcon;

    @Override
    protected void onCreate(Bundle savedInstanceStatesModel) {
        super.onCreate(savedInstanceStatesModel);
         setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initRV();
        testIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this  , test.class));
            }
        });


        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    homeAdapter.getFilter().filter(s.toString());
            }
        });

        popMenu.setOnClickListener(this);


    }

    public void setPopMenu(){
        PopupMenu p = new PopupMenu(this, popMenu);
        p.getMenuInflater().inflate(R.menu.pop_menu, p .getMenu());
        p.setOnMenuItemClickListener(this);
        p.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.news:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, NewsPage.class));
                return true;
            case R.id.tips:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                startActivity((new Intent (this, Tips.class)));
            default: return super.onOptionsItemSelected(item);
        }


    }




    public void initRV(){
        homeAdapter = new HomeAdapter(this);
        fillStatesModels();
//        homeAdapter.setStateAdapterItems(states);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false );
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }

//    private void filter(String filter){
//        List<StatesModel> filteredStates = new ArrayList<>();
//
//        for (StatesModel state : states){
//            if(state.getState().toLowerCase().contains(filter.toLowerCase()))
//                filteredStates.add(state);
//        }
//        homeAdapter.setFilteredStates(filteredStates);
//    }

    private void fillStatesModels(){
        states = new ArrayList<>();

        states.add(new StatesModel("1.","Abia",
                "South East",
                "070022442362","0700ABIADOC"));

        states.add(new StatesModel("2.","Adamawa",
                "North East",
                "08031230359","07080601139"));

        states.add(new StatesModel("3.","Akwa Ibom",
                "South South",
                "08028442194","08037934966"));

        states.add(new StatesModel("4.","Anambra",
                "South East",
                "08145434416","08030953771"));

        states.add(new StatesModel("5.","Bauchi",
                "North East ",
                "08028442194","08037934966"));

        states.add(new StatesModel("6.","Bayelsa",
                "South South",
                "08039216821","07019304970"));

        states.add(new StatesModel("7.","Benue",
                "North Central",
                "09018602439","07025031214"));

        states.add(new StatesModel("8.","Borno",
                "North East ",
                "080099999999","08088159881"));

        states.add(new StatesModel("9.","Cross River",
                "South South",
                "09036281412","08050907736"));

        states.add(new StatesModel("10.","Delta",
                "South South",
                "08033521961","08035078541"));

        states.add(new StatesModel("11.","Ebonyi",
                "South East",
                "09020332489",""));

        states.add(new StatesModel("12.","Edo",
                "South South",
                "08084096723","08064258163"));

        states.add(new StatesModel("13.","Ekiti",
                "South West",
                "09062970434","09062970435"));

        states.add(new StatesModel("14.","Enugu",
                "South East",
                "117","112"));

        states.add(new StatesModel("15.","FCT",
                "North Central ",
                "08099936312","07080631500"));

        states.add(new StatesModel("16.","Gombe",
                "North East",
                "08103371257",""));

        states.add(new StatesModel("17.","Imo",
                "South East",
                "08099555577","07087110839"));

        states.add(new StatesModel("18.","Jigawa",
                "North West",
                "",""));

        states.add(new StatesModel("19.","Kaduna",
                "North West",
                "08035871662","08025088304"));

        states.add(new StatesModel("20.","Kano",
                "North West",
                "08039704476","08037038597"));

        states.add(new StatesModel("21.","Katsina",
                "North West ",
                "09035037114","09047092428"));

        states.add(new StatesModel("22.","Kebbi",
                "North West",
                "",""));

        states.add(new StatesModel("23.","Kogi",
                "North Central",
                "07088292249","08150953486"));

        states.add(new StatesModel("24.","Kwara",
                "North Central",
                "0906201000001","09062010002"));

        states.add(new StatesModel("25.","Lagos",
                "South West",
                "08023169485","08033565529"));

        states.add(new StatesModel("26.","Nasarawa",
                "North Central",
                "",""));

        states.add(new StatesModel("27.","Niger",
                "North Central ",
                "08038246018","09093093642"));

        states.add(new StatesModel("28.","Ogun",
                "South West ",
                "08188978392","08188978392"));

        states.add(new StatesModel("29.","Ondo",
                "South West",
                "080COVID19","08002684319"));

        states.add(new StatesModel("30.","Osun",
                "South West",
                "08035025692","08033908772"));

        states.add(new StatesModel("31.","Oyo",
                "South West ",
                "08038210122","08023229267"));

        states.add(new StatesModel("32.","Plateau",
                "North Central",
                "08035422711","08035779917"));

        states.add(new StatesModel("33.","Rivers",
                "South South",
                "08031888093","08033124314"));

        states.add(new StatesModel("34.","Sokoto",
                "North West ",
                "07031935037","08036394462"));

        states.add(new StatesModel("35.","Taraba",
                "North East ",
                "08039359368","08037450227"));

        states.add(new StatesModel("36.","Yobe",
                "North East",
                "08131834764","07041116027"));

        states.add(new StatesModel("37.","Zamfara",
                "North West ",
                "08035626731","08035161538"));

        homeAdapter.setStateAdapterItems(states);
    }


    @Override
    public void onClick(View v) {
        setPopMenu();
    }
}
