package com.example.nayan.navigationdrawermenuwithtoolbarmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationFragmentMenu fragmentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerMenu);
        prepareDisplay();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.action_search){
            Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,SubActivity.class);
            startActivity(intent);
        }
        else if (id==R.id.action_setting){
            Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.action_user){
            Toast.makeText(this,"user",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void prepareDisplay() {
        setSupportActionBar(toolbar);
        fragmentMenu = (NavigationFragmentMenu) getSupportFragmentManager().findFragmentById(R.id.fragNav);
        fragmentMenu.setUp(drawerLayout, toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
