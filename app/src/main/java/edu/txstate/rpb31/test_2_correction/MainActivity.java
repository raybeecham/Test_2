package edu.txstate.rpb31.test_2_correction;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    int[] intCustomerIDs = {1, 2, 3, 4, 5};
    String[] firstName = {"Ray", "Michael", "Tony", "Rebecca", "Rolf"};
    String[] lastName = {"Beecham", "Kors", "Adams", "Smith", "Son of a Shepard"};
    int[] age = {30, 40, 20, 12, 27};
    String[] type = {"Residential", "Commercial", "Commercial", "Residential", "Residential"};
    double [] costPerMonth = {11.05, 20.25, 20.25, 11.05, 11.05};
    int[] intCustomerImage = {R.drawable.ray, R.drawable.kors, R.drawable.adams, 0, R.drawable.rolf};
    List<Customer> customers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        customers = new ArrayList<Customer>();

        for (int i = 0; i < firstName.length; i++) {
            Customer cust = new Customer(intCustomerIDs[i], firstName[i],
                    lastName[i], age[i], type[i], costPerMonth[i], intCustomerImage[i]);
            customers.add(cust);
        }
            setListAdapter(new ArrayAdapter<Customer>(MainActivity.this, R.layout.activity_main,
                    R.id.txtCustomer, customers));
       }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {//position = index
        //super.onListItemClick(l, v, position, id);

        Customer selectedCustomer = customers.get(position);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("id", selectedCustomer.getId());
        editor.putString("fName", selectedCustomer.getFirstName());
        editor.putString("lName", selectedCustomer.getLastName());
        editor.putString("type", selectedCustomer.getType());
        editor.putFloat("cost", (float) selectedCustomer.getCost());
        editor.putInt("image", selectedCustomer.getCustomerImage());

        editor.commit();


        int age = selectedCustomer.getAge();

        if (age < 18) {
            Toast.makeText(MainActivity.this,
                    "You cannot sign a service contract! Scram!",
                    Toast.LENGTH_LONG).show();
        } else {

            startActivity(new Intent(MainActivity.this, Customer_Info.class));


        }


    }

    }
