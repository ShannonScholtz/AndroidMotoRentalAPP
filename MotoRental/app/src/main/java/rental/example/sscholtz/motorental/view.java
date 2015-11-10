package rental.example.sscholtz.motorental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sscholtz.motorental.R;

import rental.example.sscholtz.motorental.model.Customer;
import rental.example.sscholtz.motorental.services.Impl.CustomerDetailsServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class view extends AppCompatActivity {

    private List<Customer> customers;
    private ArrayList<String> strcustomers;
    private ListView listViewCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewCustomers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        //Go back to Main Menu
        Intent openStep = new Intent(view.this, main_page.class);
        finish();
        startActivity(openStep);

    }

    private void viewCustomers() {
        listViewCustomers = (ListView) findViewById(R.id.viewCustomer);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                CustomerDetailsServiceImpl service = new CustomerDetailsServiceImpl();
                customers = service.findAll();
                strcustomers = new ArrayList<String>();

                for (Customer customer : customers) {
                    strcustomers.add("ID:" + customer.getId() + "\nFirst Name:" + customer.getFirstName() + "\nSurname:" + customer.getLastName());
                }
            }
        });

        thread.start();

        try {

            thread.join();
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.this, android.R.layout.simple_list_item_1, android.R.id.text1, strcustomers);
        listViewCustomers.setAdapter(adapter);

    }
}

























    ///////////////////////////////
  /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
