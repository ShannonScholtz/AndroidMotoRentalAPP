package rental.example.sscholtz.motorental;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.sscholtz.motorental.R;

import rental.example.sscholtz.motorental.model.EngineTypeEmbeddable;
import rental.example.sscholtz.motorental.model.MotorBikeConditionEmbeddable;
import rental.example.sscholtz.motorental.model.MotorCycle;
import rental.example.sscholtz.motorental.services.Impl.MotorCycleService;
import rental.example.sscholtz.motorental.services.Impl.MotorCycleServiceImpl;

public class motorcycle_rental extends ActionBarActivity {

    private String userExists = "";
    private EditText SerialNumber;
    private EditText Make;
    private EditText Model;
    private EditText year;
    private EditText  OdometreReading;
    private EditText Gas;
    private EditText BikeCondition;
    private EditText EngineSerialNumber;
    private EditText EngineSize;
    private EditText FuelType;
    private Button submit;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorcycle_rental);


        SerialNumber = (EditText) findViewById(R.id.txtSerialNumber);
        Make = (EditText) findViewById(R.id.txtMake);
        Model = (EditText) findViewById(R.id.txtModel);
        year = (EditText) findViewById(R.id.txtYear);
        OdometreReading = (EditText) findViewById(R.id.txtOdometreReading);
        Gas = (EditText) findViewById(R.id.txtGas);
        BikeCondition = (EditText) findViewById(R.id.txtBikeCondition);
        EngineSerialNumber = (EditText) findViewById(R.id.txtEngineSerialNumber);
        EngineSize = (EditText) findViewById(R.id.txtEngineSize);
        FuelType = (EditText) findViewById(R.id.txtFuelType);
        submit = (Button) findViewById(R.id.btnSubmit);
        scrollView = (ScrollView) findViewById(R.id.scrollViewMotorcycle);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SerialNumber.getText().toString().equals("")) {
                    scrollView.scrollTo(0, 0);
                    SerialNumber.requestFocus();
                    SerialNumber.setError("Cannot be empty.");
                } else if (Make.getText().toString().equals("")) {
                    scrollView.scrollTo(0, 0);
                    Make.requestFocus();
                    Make.setError("Cannot be empty.");
                } else if (Model.getText().toString().equals("")) {
                    scrollView.scrollTo(0, 0);
                    Model.requestFocus();
                    Model.setError("Cannot be empty.");
                } else if (year.getText().toString().equals("")) {
                    scrollView.scrollTo(0, 0);
                    year.requestFocus();
                    year.setError("Cannot be empty.");
                } else if (OdometreReading.getText().toString().equals("")) {
                    scrollView.scrollTo(0, 0);
                    OdometreReading.requestFocus();
                    OdometreReading.setError("Cannot be empty.");
                } else {
                    if (Gas.getText().toString().equals("")) {
                        scrollView.scrollTo(0, 0);
                        Gas.requestFocus();
                        Gas.setError("Cannot be empty.");
                    }
                    if (BikeCondition.getText().toString().equals("")) {
                        scrollView.scrollTo(0, 0);
                        BikeCondition.requestFocus();
                        BikeCondition.setError("Cannot be empty.");
                    }
                    if (EngineSerialNumber.getText().toString().equals("")) {
                        scrollView.scrollTo(0, 0);
                        EngineSerialNumber.requestFocus();
                        EngineSerialNumber.setError("Cannot be empty.");
                    }
                    if (EngineSize.getText().toString().equals("")) {
                        scrollView.scrollTo(0, 0);
                        EngineSize.requestFocus();
                        EngineSize.setError("Cannot be empty.");
                    }
                    if (FuelType.getText().toString().equals("")) {
                        scrollView.scrollTo(0, 0);
                        FuelType.requestFocus();
                        FuelType.setError("Cannot be empty.");
                    } else {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                MotorCycleService service = new MotorCycleServiceImpl();

                                MotorCycle user = new MotorCycle();
                                user.setSerialNumber(SerialNumber.getText().toString());
                                user.setMake(Make.getText().toString());
                                user.setModel(Model.getText().toString());
                                user.setYear(year.getText().toString());
                                user.setMotorBikeConditionEmbeddable(new MotorBikeConditionEmbeddable(OdometreReading.getText().toString(), Gas.getText().toString(), BikeCondition.getText().toString()));
                                user.setEngineTypeEmbeddable(new EngineTypeEmbeddable(EngineSerialNumber.getText().toString(), EngineSize.getText().toString(), FuelType.getText().toString()));
                                user.setMotorBikeConditionEmbeddable(new MotorBikeConditionEmbeddable(OdometreReading.getText().toString(), Gas.getText().toString(), BikeCondition.getText().toString()));
                                user.setEngineTypeEmbeddable(new EngineTypeEmbeddable(EngineSerialNumber.getText().toString(), EngineSize.getText().toString(), FuelType.getText().toString()));
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
                        if (userExists == null) {
                            //Go to Login page, send username to txtLoginUsername

                            Intent openStep = new Intent(motorcycle_rental.this, successful_rental.class);
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
        getMenuInflater().inflate(R.menu.menu_motorcycle_rental, menu);
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
