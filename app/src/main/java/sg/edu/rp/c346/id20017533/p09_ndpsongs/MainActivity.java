package sg.edu.rp.c346.id20017533.p09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTitle, editSingers, editYear;
    RadioGroup rgroup;
    Button btnInsert,btnList;
    RadioButton rb1, rb2, rb3, rb4, rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.Title);
        editSingers = findViewById(R.id.Singer);
        editYear = findViewById(R.id.Year);
        rgroup = findViewById(R.id.rgroup);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);

                if(editTitle.getText().toString().isEmpty() || editSingers.getText().toString().isEmpty() || editYear.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Missing input", Toast.LENGTH_SHORT).show();
                }
                else{
                    String title = editTitle.getText().toString();
                    String singers = editSingers.getText().toString();
                    int year = Integer.parseInt(editYear.getText().toString());
                    int selectedId = rgroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    int stars = Integer.parseInt(radioButton.getText().toString());

                    dbh.insertSong(title, singers, year, stars);
                    Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}