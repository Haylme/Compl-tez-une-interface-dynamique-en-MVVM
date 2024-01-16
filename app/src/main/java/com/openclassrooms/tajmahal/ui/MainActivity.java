package com.openclassrooms.tajmahal.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        if (savedInstanceState == null) {
            NavHostFragment navHostFragment = NavHostFragment.create(R.navigation.nav_graph);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_main_container, navHostFragment)
                    .setPrimaryNavigationFragment(navHostFragment)

                    .commit();
        }
    }
}
