package rental.example.sscholtz.motorental;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.sscholtz.motorental.R;

import rental.example.sscholtz.motorental.model.AddressEmbeddable;
import rental.example.sscholtz.motorental.model.Customer;
import rental.example.sscholtz.motorental.services.Impl.CustomerDetailsService;
import rental.example.sscholtz.motorental.services.Impl.CustomerDetailsServiceImpl;


/**
 * Created by sscholtz on 2015/08/25.
 */
public class customer_details extends ActionBarActivity {

    private String userExists = "";
    private EditText firstName;
    private EditText LastName;
    private EditText PhoneNumber;
    private EditText Address;
    private EditText  City;
    private EditText PostalCode;
    private Button  next;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);


        firstName = (EditText)findViewById(R.id.txtFirstName);
        LastName = (EditText)findViewById(R.id.txtLastName);
        PhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
        Address = (EditText)findViewById(R.id.txtAddressCust);
        City = (EditText)findViewById(R.id.txtCityCust);
        PostalCode = (EditText)findViewById(R.id.txtPostalCode);
        next = (Button)findViewById(R.id.btnNext);
        scrollView = (ScrollView)findViewById(R.id.scrollViewCustomer);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(firstName.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    firstName.requestFocus();
                    firstName.setError("Cannot be empty.");
                }else if(LastName.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    LastName.requestFocus();
                    LastName.setError("Cannot be empty.");
                }else if(PhoneNumber.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    PhoneNumber.requestFocus();
                    PhoneNumber.setError("Cannot be empty.");
                }else if(Address.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    Address.requestFocus();
                    Address.setError("Cannot be empty.");
                }else if(City.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    City.requestFocus();
                    City.setError("Cannot be empty.");
                }else {
                    if (PostalCode.getText().toString().equals(""))
                    {
                        scrollView.scrollTo(0, 0);
                        PostalCode.requestFocus();
                        PostalCode.setError("Cannot be empty.");
                    } else {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                CustomerDetailsService service = new CustomerDetailsServiceImpl();

                                Customer user = new Customer();
                                user.setFirstName(firstName.getText().toString());
                                user.setLastName(LastName.getText().toString());
                                user.setPhoneNumber(PhoneNumber.getText().toString());
                                AddressEmbeddable addressStr = new AddressEmbeddable();
                                addressStr.setAddress(Address.getText().toString());
                                addressStr.setCity(City.getText().toString());
                                addressStr.setPostalCode(PostalCode.getText().toString());
                                user.setAddressEmbeddable(addressStr);
                                user.setRentals(null);

                                userExists = service.save(user);
                            }
                        });

                        thread.start();

                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (userExists==null) {
                        //Go to Login page, send username to txtLoginUsername

                            Intent openStep = new Intent(customer_details.this, motorcycle_rental.class);
                            //openStep.putExtra("FirstName", firstName.getText().toString());
                            startActivity(openStep);
                            finish();
                        } else {
                            scrollView.scrollTo(0, 0);
                        }
                    }
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer, menu);
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
}
