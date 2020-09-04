package com.example.zerohunger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.net.Uri;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG="Mainactivity";

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }
    private static final int TEZ_REQUEST_CODE = 123;
    private static final String GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Button payButton = findViewById(R.id.pay_button);
      payButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Uri uri =
              new Uri.Builder()
                  .scheme("upi")
                  .authority("pay")
                  .appendQueryParameter("pa", "test@axisbank")
                  .appendQueryParameter("pn", "Test Merchant")
                  .appendQueryParameter("mc", "1234")
                  .appendQueryParameter("tr", "123456789")
                  .appendQueryParameter("tn", "test transaction note")
                  .appendQueryParameter("am", "10.01")
                  .appendQueryParameter("cu", "INR")
                  .appendQueryParameter("url", "https://test.merchant.website")
                  .build();
          Intent intent = new Intent(Intent.ACTION_VIEW);
          intent.setData(uri);
          intent.setPackage(GOOGLE_TEZ_PACKAGE_NAME);
          startActivityForResult(intent, TEZ_REQUEST_CODE);
        }
      });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);

      if (requestCode == TEZ_REQUEST_CODE) {
        // Process based on the data in response.
        Log.d("result", data.getStringExtra("Status"));
      }
    }
    
    private static JSONObject baseConfigurationJson(){
    return new JSONObject()
        .put("apiVersion",2)
        .put("apiVersionMinor",0)
        .put("allowedPaymentMethods", new JSONArray().put(getCardPaymentMethod()));
    }    
    
    public void donate(View view){
        
        EditText donatename = (EditText)findViewById(R.id.donatename);
        EditText donatephone = (EditText)findViewById(R.id.donatephone);
        EditText donatepay = (EditText)findViewById(R.id.donatepay);

        Toast.makeText(this,"hi"+ donatename.getText().toString() + "you are on the way to donate rupees :" + donatepay.getText().toString() ,Toast.LENGTH_LONG.show());
        private PaymentsClient paymentsClient;
        
        IsReadyTOPayRequest readyToPayrequest = IsReadyToPayRequest.fromJson(baseConfigurationJson().toString());
        
        Task<Boolean> task = paymentsClient.isReadyToPay(readyToPayRequest);
        
        task.addOnCompleteListener(this, new onCompleteListener<Boolean>(){
            
            public void onComplete(@NonNull Task<Boolean> completeTask){
                
                if(completeTask.isSuccessful()){
                    showGooglePayButton(CompleteTask.getResult());
                    
                }else{
                    
                }
            }
        });
     
        @override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Wallet.WalletOptions walletoptions =
                new Wallet.WalletOptions.Builder()
                .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                .build();
            paymentClient = Wallet.getPaymentsClient(
                this. walletOptions);
        }
    }

    private void initView() {

        Log.d(TAG,"initView: started");
        drawer =(DrawerLayout)findViewById(R.id.drawer);
        navigationView =(NavigationView)findViewById(R.id.navigation_drawer);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.donatefood:
                //Toast.makeText(getApplicationContext(),"Item 1 selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DonateFoodActivity.class);
                //intent.putExtra("noteId",i);
                startActivity(intent);
                break;

            case R.id.fooddonors:
                //Toast.makeText(getApplicationContext(),"Item 2 selected",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(),food_donors.class);
                //intent.putExtra("noteId",i);
                startActivity(intent1);
                break;

            case R.id.moneydonors:
                //Toast.makeText(getApplicationContext(),"Item 3 selected",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),"Item 2 selected",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getApplicationContext(),money_donors.class);
                //intent.putExtra("noteId",i);
                startActivity(intent2);
                break;


            case R.id.moneyspent:
                //Toast.makeText(getApplicationContext(),"Item 4 selected",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getApplicationContext(),money_spent.class);
                //intent.putExtra("noteId",i);
                startActivity(intent3);
                break;

            case R.id.settings:
                Toast.makeText(getApplicationContext(),"Item 5 selected",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
