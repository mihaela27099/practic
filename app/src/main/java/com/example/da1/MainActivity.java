package com.example.da1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button set;
    EditText nr1, nr2, nr3, nr4;
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private final IntentFilter intentFilter = new IntentFilter();

   // private final MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
//    private static class MessageBroadcastReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.d(Constants.BROADCAST_RECEIVER_TAG, Objects.requireNonNull(intent.getStringExtra(Constants.BROADCAST_RECEIVER_EXTRA)));
//        }
//    }

//    int leftNumber = 0;
//    int rightNumber = 0;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set = findViewById(R.id.set);
        nr1 = findViewById(R.id.nr1);
        nr2 = findViewById(R.id.nr2);
        nr3 = findViewById(R.id.nr3);
        nr4 = findViewById(R.id.nr4);

        nr1.setText("0");
        nr2.setText("0");
        nr3.setText("0");
        nr4.setText("0");

        set.setOnClickListener(v -> {
            int sum = Integer.parseInt(nr1.getText().toString()) + Integer.parseInt(nr2.getText().toString());
            int product = Integer.parseInt(nr3.getText().toString()) * Integer.parseInt(nr4.getText().toString());
            Intent intent = new Intent(this, PracticalTestVar07SecondaryActivity.class);
            intent.putExtra(Constants.SUM, sum);
            intent.putExtra(Constants.PRODUCT, product);
            startActivity(intent);
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                if (result.getData() == null) {
                    return;
                }
                int sum = Objects.requireNonNull(result.getData().getExtras()).getInt(Constants.SUM);
                Toast.makeText(this, "The activity returned with OK  " + sum, Toast.LENGTH_LONG).show();
            } else {
                if (result.getData() == null) {
                    return;
                }
                int prod = Objects.requireNonNull(result.getData().getExtras()).getInt(Constants.PRODUCT);
                Toast.makeText(this, "The activity returned with CANCEL " +prod , Toast.LENGTH_LONG).show();
            }
        });

    }}

//    private void startServiceIfConditionIsMet(int leftNumber, int rightNumber) {
//        if (leftNumber + rightNumber > Constants.NUMBER_OF_CLICKS_THRESHOLD) {
//            Intent intent = new Intent(getApplicationContext(), PracticalTest01Service.class);
//            intent.putExtra(Constants.nr1, leftNumber);
//            intent.putExtra(Constants.nr2, rightNumber);
//            getApplicationContext().startService(intent);
//        }
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            registerReceiver(messageBroadcastReceiver, intentFilter, Context.RECEIVER_EXPORTED);
//        } else {
//            registerReceiver(messageBroadcastReceiver, intentFilter);
//        }
//    }

  //  @Override
//    protected void onPause() {
//        unregisterReceiver(messageBroadcastReceiver);
//        super.onPause();
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        Intent intent = new Intent(this, PracticalTest01Service.class);
//        stopService(intent);
//
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString(Constants.INPUT1, input1.getText().toString());
//        outState.putString(Constants.INPUT2, input2.getText().toString());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        if (savedInstanceState.containsKey(Constants.INPUT1)) {
//            input1.setText(savedInstanceState.getString(Constants.INPUT1));
//        } else {
//            input1.setText("0");
//        }
//
//        if (savedInstanceState.containsKey(Constants.INPUT2)) {
//            input2.setText(savedInstanceState.getString(Constants.INPUT2));
//        } else {
//            input2.setText("0");
//        }
//    }
//}