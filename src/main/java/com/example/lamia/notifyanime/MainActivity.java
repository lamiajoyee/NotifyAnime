package com.example.lamia.notifyanime;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebViewFragment;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lamia.notifyanime.Clients.APIClient;
import com.example.lamia.notifyanime.Interfaces.APIInterface;
import com.example.lamia.notifyanime.Models.AuthModel;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends DrawerActivity {

    MaterialViewPager mViewPager;
    TextView textView;

    APIInterface apiInterface;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        textView = (TextView) findViewById(R.id.logo_white);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        //return RecyclerViewFragment.newInstance();
                    case 1:
                        //return RecyclerViewFragment.newInstance();
                    case 2:
                        //return RecyclerViewFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Selection";
                    case 1:
                        return "Actualités";
                    case 2:
                        return "Professionnel";
                    case 3:
                        return "Divertissement";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        textView.setText("Home");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 1:
                        textView.setText("Action");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 2:
                        textView.setText("Adventure");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        textView.setText("Psychological");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        Call<AuthModel> authModelCall = apiInterface.doGetAuthenticated("client_credentials", "lamiajoyee-fsx1t", "ljA9byABYvR3fpKAKHh");
        authModelCall.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                AuthModel authModel = response.body();
                token = authModel.accessToken;
                String tokenType = authModel.tokenType;
                Integer expires = authModel.expires;
                Integer expiresIn = authModel.expiresIn;
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                call.cancel();
            }

        });

    }


}
