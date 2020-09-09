package com.example.zerohungerlogin;

/*public class money_donors extends AppCompatActivity {

    ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_donors);


        ListView list_of_donors = findViewById(R.id.list_of_donors);
        notes.add("Example Note1");
        notes.add("Example Note2");
        notes.add("Example Note3");
        notes.add("Example Note4");
        notes.add("Example Note5");
        notes.add("Example Note6");
        notes.add("Example Note7");
        notes.add("Example Note8");
        notes.add("Example Note9");
        notes.add("Example Note10");
        notes.add("Example Note11");
        notes.add("Example Note12");
        notes.add("Example Note13");
        notes.add("Example Note14");
        notes.add("Example Note15");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,notes);
        list_of_donors.setAdapter(arrayAdapter);

        list_of_donors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ListActivity2.class);
                intent.putExtra("noteId",i);
                startActivity(intent);
            }
        });
    }
}  */

public class money_donors {
    String amount;
    String name1;
    String phone;
    String uid1;

    @Override
    public String toString() {
        return "money_donors{" +
                "amount='" + amount + '\'' +
                ", name1='" + name1 + '\'' +
                ", phone='" + phone + '\'' +
                ", uid1='" + uid1 + '\'' +
                '}';
    }

    public money_donors() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid1() {
        return uid1;
    }

    public void setUid1(String uid1) {
        this.uid1 = uid1;
    }
}