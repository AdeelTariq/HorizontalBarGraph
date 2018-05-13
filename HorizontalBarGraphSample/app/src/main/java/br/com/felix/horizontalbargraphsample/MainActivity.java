package br.com.felix.horizontalbargraphsample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.felix.horizontalbargraph.HorizontalBar;
import br.com.felix.horizontalbargraph.model.BarItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final HorizontalBar horizontal = findViewById(R.id.horizontal);
        horizontal.init(this).hasAnimation(true).addAll(itens()).build();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                horizontal.add (new BarItem ("xxx", 2d, "This is good?"));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        horizontal.add (new BarItem ("yyy", 2d));
                    }
                }, 5000);
            }
        }, 5000);

    }

    private List<BarItem> itens() {
        List<BarItem> items = new ArrayList<>();

        int i = 0;
        items.add (new BarItem ("Teste " + i, 14d));
        items.add (new BarItem ("Teste " + i, 7d));
        items.add (new BarItem ("Teste " + i, 1d));
        items.add (new BarItem ("Teste " + i, 0d));
        i++;

        items.add (new BarItem ("Teste " + i, 5d));
        items.add (new BarItem ("Teste " + i, 4d));
        i++;

        items.add (new BarItem ("Teste " + i, 3d, Color.RED, Color.WHITE));
        i++;

        items.add (new BarItem ("Teste " + i, 10d, Color.RED, Color.WHITE));

        return items;
    }
}
