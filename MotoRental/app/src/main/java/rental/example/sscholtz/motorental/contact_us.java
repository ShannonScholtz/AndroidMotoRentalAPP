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

import rental.example.sscholtz.motorental.model.SalesPerson;
import rental.example.sscholtz.motorental.services.Impl.SalesPersonServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class contact_us extends AppCompatActivity {


    private List<SalesPerson> hardwareList;
    private ArrayList<String> strHardList;
    private ListView listViewSales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        viewSalespeople();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_us, menu);
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
        Intent openStep = new Intent(contact_us.this, main_page.class);
        startActivity(openStep);
        finish();
    }

    public void viewSalespeople() {

        listViewSales = (ListView) findViewById(R.id.listViewSalesperson);

        Thread thread = new Thread (new Runnable() {

            @Override
            public void run() {

                SalesPersonServiceImpl service = new SalesPersonServiceImpl();

                hardwareList = service.getAllSalespersons();
                strHardList = new ArrayList<>();

                for (SalesPerson hardware : hardwareList) {

                    strHardList.add("Name: " + hardware.getFirstName() + "\nSurname: " + hardware.getLastName());
                }
            }
        });

        thread.start();

        try {

            thread.join();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(contact_us.this, android.R.layout.simple_list_item_1, android.R.id.text1, strHardList);
        listViewSales.setAdapter(adapter);
    }




}
