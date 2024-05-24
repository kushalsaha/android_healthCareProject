package com.example.healthcareproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp:5 yrs","Mobile No.:9898989898","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp:15 yrs","Mobile No.:7898789878","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile No.:88998899889","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6 yrs","Mobile No.:9890008922","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Pimpri","Exp : 7yrs","Mobile No.:9898989898","600"},

            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp:5 yrs","Mobile No.:9898989898","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp:15 yrs","Mobile No.:7898789878","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile No.:88998899889","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6 yrs","Mobile No.:9890008922","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Pimpri","Exp : 7yrs","Mobile No.:9898989898","600"},

            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp:5 yrs","Mobile No.:9898989898","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp:15 yrs","Mobile No.:7898789878","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile No.:88998899889","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6 yrs","Mobile No.:9890008922","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Pimpri","Exp : 7yrs","Mobile No.:9898989898","600"},

            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp:5 yrs","Mobile No.:9898989898","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp:15 yrs","Mobile No.:7898789878","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile No.:88998899889","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6 yrs","Mobile No.:9890008922","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Pimpri","Exp : 7yrs","Mobile No.:9898989898","600"},

            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp:5 yrs","Mobile No.:9898989898","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp:15 yrs","Mobile No.:7898789878","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp : 8yrs","Mobile No.:88998899889","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6 yrs","Mobile No.:9890008922","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Pimpri","Exp : 7yrs","Mobile No.:9898989898","600"},

            };





    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0) {
            doctor_details = doctor_details1;
        }
        else if (title.compareTo("Dietician") == 0) {
            doctor_details = doctor_details2;
        }
        else if (title.compareTo("Dentist") == 0) {
            doctor_details = doctor_details3;
        }
        else if (title.compareTo("Surgeon") == 0) {
            doctor_details = doctor_details4;
        }
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i =0; i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees: "+doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst = findViewById(R.id.listviewDD);
        lst.setAdapter(sa);



    }
}