package com.example.rahulkumarpandey.bottombarwithlib;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customBottomBar();
    }

    private void customBottomBar() {

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.item_1, R.drawable.delete, 0);// I passed 0 becoz i dont need , do as per ur requirement
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.item_2, R.drawable.likefilled, 0);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.item_3, R.drawable.share, 0);

        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);


        // <------- SET BELOW PROPERTY AS PER YOUR REQUIREMENT----------->
        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Enable the translation of the FloatingActionButton
        // bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

         // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

        // Display color under navigation bar (API 21+)
        // Don't forget these lines in your style-v21
        // <item name="android:windowTranslucentNavigation">true</item>
        // <item name="android:fitsSystemWindows">true</item>
        bottomNavigation.setTranslucentNavigationEnabled(true);

        // Manage titles
        //  bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        // bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        // bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        // Set current item programmatically
        bottomNavigation.setCurrentItem(1);

        // Customize notification (title, background, typeface)
      //  bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

        // Add or remove notification for each item
        //  bottomNavigation.setNotification("1", 3);
        // OR
        AHNotification notification = new AHNotification.Builder()
                .setText("1")
                .setBackgroundColor(ContextCompat.getColor(this, R.color.color_notification_back))
                .setTextColor(ContextCompat.getColor(this, R.color.color_notification_text))
                .build();
        bottomNavigation.setNotification(notification, 1);
        // Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {
                // Manage the new y position
            }
        });
    }
}
