package miu.com.pos_miu_application.views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import miu.com.pos_miu_application.R;
import miu.com.pos_miu_application.views.Fragement.CategoriesFragment;
import miu.com.pos_miu_application.views.Fragement.MainFragment;
import miu.com.pos_miu_application.views.Fragement.OrdersFragment;
import miu.com.pos_miu_application.views.Fragement.ProductsFragment;
import miu.com.pos_miu_application.views.Fragement.StaffsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        setSupportActionBar(toolbar);
        toolbarAction();
        loadDefaultFragment();
        itemSelectAction();
    }

    private void loadDefaultFragment() {
        //Load Default fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new MainFragment());
        fragmentTransaction.commit();
    }
    private void replaceFragement(Object o) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, (Fragment) o);
        fragmentTransaction.commit();
    }

    private void itemSelectAction() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    private void toolbarAction() {
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    private void linkViews() {
        drawerLayout = findViewById(R.id.draw_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_order:
                replaceFragement(new OrdersFragment());
                break;
            case R.id.nav_products:
                replaceFragement(new ProductsFragment());
                break;
            case R.id.nav_cate:
                replaceFragement(new CategoriesFragment());
                break;
            case R.id.nav_staff:
                replaceFragement(new StaffsFragment());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}