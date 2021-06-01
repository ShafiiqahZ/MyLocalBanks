package sg.edu.rp.c346.id20037987.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbsBank;
    TextView ocbcBank;
    TextView uobBank;
    ImageView imgView;
    ImageView imgView2;
    ImageView imgView3;

    String menuSelected = "";
    String bankNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbsBank = findViewById(R.id.dbsBank);
        ocbcBank = findViewById(R.id.ocbcBank);
        uobBank = findViewById(R.id.uobBank);
        imgView = findViewById(R.id.imageView1);
        imgView2 = findViewById(R.id.imageView2);
        imgView3 = findViewById(R.id.imageView3);

        registerForContextMenu(dbsBank);
        registerForContextMenu(ocbcBank);
        registerForContextMenu(uobBank);
        registerForContextMenu(imgView);
        registerForContextMenu(imgView2);
        registerForContextMenu(imgView3);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");

        if (v == imgView || v == dbsBank) {
            menuSelected = "DBS";
        } else if (v == imgView2 || v == ocbcBank) {
            menuSelected = "OCBC";
        } else if (v == imgView3 || v == uobBank) {
            menuSelected = "UOB";
        }

        menu.setHeaderTitle(menuSelected + " is selected");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (menuSelected.equals("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentView);

                return true;
            } else if (item.getItemId() == 1) {
                bankNum = "1800 111 1111";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + bankNum));
                startActivity(intentCall);

                return true;
            }
        }

        if (menuSelected.equals("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(intentView);

                return true;
            } else if (item.getItemId() == 1) {
                bankNum = "1800 363 3333";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + bankNum));
                startActivity(intentCall);
                return true;
            }
        }

        if (menuSelected.equals("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/credit-cards/?ef_id=CjwKCAjwtdeFBhBAEiwAKOIy5zWbYmPJ75y-jRX0SHrY6dKpmcYWKADeIzBy6j209gPC30dyqjafnBoCo_kQAvD_BwE:G:s&s_kwcid=AL!810!3!513099055343!e!!g!!www%20uob&s_cid=pfs:sg:paid:sea:go:na:tx:na:cc:011119-evergreen:na:cvp_cashback:pc-go&vid=purpleclick_google&gclid=CjwKCAjwtdeFBhBAEiwAKOIy5zWbYmPJ75y-jRX0SHrY6dKpmcYWKADeIzBy6j209gPC30dyqjafnBoCo_kQAvD_BwE"));
                startActivity(intentView);

                return true;
            } else if (item.getItemId() == 1) {
                bankNum = "1800 222 2121";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + bankNum));
                startActivity(intentCall);
                return true;
            }
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.selectEnglish) {
            dbsBank.setText("DBS");
            ocbcBank.setText("OCBC");
            uobBank.setText("UOB");
            return true;
        } else if (id == R.id.selectMalay) {
            dbsBank.setText("Bank DBS");
            ocbcBank.setText("Bank OCBC");
            uobBank.setText("Bank UOB");
            return true;
        } else {
            dbsBank.setText("Error translation");
            ocbcBank.setText("Error translation");
            uobBank.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}