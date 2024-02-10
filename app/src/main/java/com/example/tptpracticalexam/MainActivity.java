package com.example.tptpracticalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tptpracticalexam.adapter.ToysAdapter;
import com.example.tptpracticalexam.databinding.ActivityMainBinding;
import com.example.tptpracticalexam.model.ToysModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Integer[] toysimg = {R.drawable.psungar,R.drawable.schoolbus,R.drawable.rubbersnack,R.drawable.keypiano,R.drawable.magneticslate,R.drawable.tomatrain};
     String[] toysnamearray = {"Popsugar","School Bus","Rubber Snakes","Key Piano","Magnetic Slate","Tomas Train",};
     String[] Price = {"$560.52","500.21","$100.12","$240.50","300.10","$600.34"};

     List<ToysModel> toysModelList = new ArrayList<>();

     ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for (int i=0;i<toysnamearray.length;i++)
        {
            ToysModel t1 = new ToysModel(toysimg[i],toysnamearray[i],Price[i]);
            toysModelList.add(t1);
        }



        ToysAdapter adapter = new ToysAdapter(this,toysModelList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        binding.rvToys.setAdapter(adapter);
        binding.rvToys.setLayoutManager(lm);
    }
}