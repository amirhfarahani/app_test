package ir.amirhfarahani.fragmenttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ir.amirhfarahani.fragmenttest.Fragment.HomeFragment;
import ir.amirhfarahani.fragmenttest.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment;
    ProfileFragment profileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.getMenu().findItem(R.id.home_menu).setChecked(true);
        setFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        setFragment(new HomeFragment());
                        item.setChecked(true);
                        break;
                    case R.id.profile_menu:
                        setFragment(new ProfileFragment());
                        item.setChecked(true);
                        break;

                }


                return false;
            }
        });


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_main, fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}