package com.paves.pavesvet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.paves.pavesvet.ui.dashboard.DashboardFragment;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth firebaseAuth;
    FirebaseUser currentUser;
    DatabaseReference databaseReference;
    ImageView iv_vet, iv_diag, iv_learn, iv_diseases, iv_market, iv_weather, iv_products, iv_services;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        iv_vet = findViewById(R.id.tv_vet);
        iv_diag = findViewById(R.id.tv_diag);
        iv_learn = findViewById(R.id.tv_learn);
        iv_diseases = findViewById(R.id.tv_diseases);
        iv_market = findViewById(R.id.tv_market);
        iv_weather = findViewById(R.id.tv_weather);
        iv_products = findViewById(R.id.tv_products);
        iv_services = findViewById(R.id.tv_services);

        iv_vet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, VetservicesActivity.class);
                startActivity(intent);
            }
        });
        iv_diag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, DiagnosisActivity.class);
                startActivity(intent);
            }
        });
        iv_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, LearnActivity.class);
                startActivity(intent);
            }
        });
        iv_diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, DiseaseActivity.class);
                startActivity(intent);
            }
        });
        iv_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MarketUpdateActivity.class);
                startActivity(intent);
            }
        });
        iv_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, WeatherUpdateActivity.class);
                startActivity(intent);
            }
        });
        iv_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PavesProductsActivity.class);
                startActivity(intent);
            }
        });
        iv_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PavesServicesActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_dashboard, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        updateNavHeader();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_logout){
            firebaseAuth.signOut();

            Intent intent = new Intent(DashboardActivity.this, SelectionActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.nav_dashboard:
                getSupportActionBar().setTitle("Dashboard");
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashboardFragment()).commit();
                break;

        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
    public void updateNavHeader(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navName = headerView.findViewById(R.id.textViewName);
        TextView navEmail = headerView.findViewById(R.id.tv_email);

        navName.setText(currentUser.getDisplayName());
        navEmail.setText(currentUser.getEmail());
    }

}
