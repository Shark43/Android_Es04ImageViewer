package palmal.example.es04_visualizzatoreimmagini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected ArrayList<Integer> list;
    protected int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos = 1;
        list = caricaImmagini(); //restituisce le immagini all'interno di un listbox
    }

    protected ArrayList<Integer> caricaImmagini(){
        // non viene deallocata questa lista
        ArrayList<Integer> listInterna = new ArrayList<Integer>();
        int id = 0;
        int i = 0;
        do {
            // restituisce 0 se la ricerca fallisce
            id=this.getResources().getIdentifier("img"+ (++id),"mipmap", this.getPackageName());
            if(id != 0){
                listInterna.add(id);
            }
        } while (i != 0);
        return listInterna;
    }

    public void btnClick(View v){
        Button btn = (Button)v;
        ImageView img = findViewById(R.id.imageView);
        Integer max = list.size();
        if(btn.getId() == R.id.buttonAvanti){
            if (pos < max){
                pos++;
            } else{
                pos = 1;
            }
        } else {
            if(pos>0){
                pos--;
            } else{
                pos = max;
            }
        }
        img.setImageResource(list.get(pos));
    }


}
