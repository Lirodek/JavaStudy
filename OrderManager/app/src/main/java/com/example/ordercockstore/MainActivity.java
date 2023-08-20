package com.example.ordercockstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.example.ordercockstore.DTO.Manager;
import com.example.ordercockstore.DTO.OrderMenu;
import com.example.ordercockstore.DTO.User;
import com.example.ordercockstore.Socket.Protocol;
import com.example.ordercockstore.Socket.service_Socket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String temp;
    service_Socket socket;
    private static Context context;

    User user = new User();
    OrderMenu menu = new OrderMenu();
    Manager manager = new Manager();
    Manager thisManager = new Manager();

    private ArrayList<OrderMenu> orderMenuList = new ArrayList<OrderMenu>();

    private ArrayList<Manager> marketList = new ArrayList<Manager>();

    boolean loginCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
    }

    public void setThisManager(String market) {
        for (int i = 0; i < marketList.size(); i++) {
            if (market.compareTo(marketList.get(i).getMarket()) == 0) {
                thisManager = marketList.get(i);
                System.out.println("이거테스트용" + thisManager);
                break;
            }
        }
    }

    public Manager getMarket() {
        return thisManager;
    }

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("naminsik"));
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        int check = 0;

        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("pw");
            //CallYourMethod(message); 실행시킬 메소드를 전달 받은 데이터를 담아 호출하려면 이렇게 한다.
            String line[] = message.split("\\|");
            System.out.println(line[0]);
            if (line[0].compareTo(Protocol.ENTERLOGIN_OK) == 0) {
                check++;
                Type usertype = new TypeToken<User>() {
                }.getType();
                Type menutype = new TypeToken<ArrayList<OrderMenu>>() {
                }.getType();
                Type marketype = new TypeToken<ArrayList<Manager>>() {
                }.getType();
                System.out.println("라인안" + line[8]);
                User user = new Gson().fromJson(line[2], usertype);
                ArrayList<OrderMenu> menulist = new Gson().fromJson(line[4], menutype);
                ArrayList<Manager> marketlist = new Gson().fromJson(line[8], marketype);

                settingUser(user);
                settingMenu(menulist);

                //loginCheckChange();

            } else if (line[0].compareTo(Protocol.LOGOUT) == 0) {
                user = null;
                loginCheck = false;
                //fragmentLogin();
            }
        }
    };

    public User settingUser(User user) {
        if (user != null)
            this.user = user;
        return this.user;
    }

    public ArrayList<OrderMenu> settingMenu(ArrayList<OrderMenu> menulist) {
        if (menulist != null) {
            this.orderMenuList = menulist;
            for (int i = 0; i < orderMenuList.size(); i++) {
            }

        }
        return this.orderMenuList;
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onPause();
    }

    public String getTemp() {
        return temp;
    }


    public static Context getContext() {
        return context.getApplicationContext();
    }

    // ===================> 플래그먼트 컨트롤 <===================

//    public void fragmentSignUp() {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.nav_host_fragment_content_main, new SignupFragment());
//        ft.addToBackStack(null);
//        ft.commit();
//    }
//
//    public void fragmentSignIn() {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.nav_host_fragment_content_main, new LoginFragment());
//        ft.addToBackStack(null);
//        ft.commit();
//    }
//
//    public void fragmentMain() {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.nav_host_fragment_content_main, new HomeFragment());
//        ft.addToBackStack(null);
//        ft.commit();
//    }
//
//    public void fragmentLogin() {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.nav_host_fragment_content_main, new LoginFragment());
//        ft.addToBackStack(null);
//        ft.commit();
//    }

    // ===============> 데이터체크 <===============
    public boolean loginCheck() {
        return loginCheck;
    }

    public static Context ApplicationContext() {
        return context;
    }

//    public void loginCheckChange() {
//        loginCheck = true;
//        fragmentMain();
//    }

}