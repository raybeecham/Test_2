package edu.txstate.rpb31.test_2_correction;

import android.content.SharedPreferences;
import android.graphics.Paint;
import android.media.Image;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Customer_Info extends AppCompatActivity {
    int intId;
    String strFName;
    String strLName;
    String strType;
    double dblCost;
    int customerImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__info);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        intId = sharedPref2.getInt("id", 0);
        strFName = sharedPref2.getString("fName", "");
        strLName = sharedPref2.getString("lName", "");
        strType = sharedPref2.getString("type", "");
        dblCost = sharedPref2.getFloat("cost", 0);
        customerImage = sharedPref2.getInt("image", 0);

        ImageView customerImages = (ImageView) findViewById(R.id.imgCustomer);
        customerImages.setImageResource(customerImage);

        Button btnCostCalculation = findViewById(R.id.btnCalculate);


        TextView txtFullName = findViewById(R.id.txtFullName);


        TextView txtAccountType = findViewById(R.id.txtAccountType);




        txtFullName.setText(strFName + " " + strLName);
        txtAccountType.setText("You currently possess a\n " + strType + " type account");


        DecimalFormat currency = new DecimalFormat("$###,###.00");
        String convertedCost = currency.format(dblCost);


        final EditText txtNumberOfMonths = findViewById(R.id.txtMonths);
        btnCostCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intMonths = 0;

                try {
                    intMonths = Integer.parseInt(txtNumberOfMonths.getText().toString()); //int, long, float, double, boolean : primitive data type
                } catch (Exception ex) {
                    Toast.makeText(Customer_Info.this, "Please enter a number", Toast.LENGTH_LONG).show();

                    return;

                }
                if (intMonths == 0) {
                    Toast.makeText(Customer_Info.this, "Please enter an integer higher than 0.", Toast.LENGTH_LONG).show();
                }
                else if (intMonths > 0) {
                    double dblTotalCost = dblCost * intMonths;
                    DecimalFormat currency = new DecimalFormat("$###,###.00");
                    TextView txtTotalCost = findViewById(R.id.txtTotalCost);
                    txtTotalCost.setText("Your total cost is: " + currency.format(dblTotalCost));
                }
                else {
                    Toast.makeText(Customer_Info.this, "A Number must be entered ", Toast.LENGTH_LONG).show();
                }



            }
        });


    }
}