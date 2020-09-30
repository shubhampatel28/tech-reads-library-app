package edu.sjsu.android.techreads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter bookItemsadapter;
    private RecyclerView.LayoutManager layoutManager;
    private BookAdapter.onBookClick listener;
    ArrayList<Book> booksList;
    AlertDialog.Builder builder;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_menu:
                Intent intent = new Intent(this, Information.class);
                startActivity(intent);
                return true;

            case R.id.uninstall_menu:
                Uri packageURI = Uri.parse("package:edu.sjsu.android.techreads");
                Intent intentUninstall = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(intentUninstall);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listview_item);
        setOnClickListener();
        bookItemsadapter = new BookAdapter(getBooksList(), listener);
        recyclerView.setAdapter(bookItemsadapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void setOnClickListener() {
        listener = new BookAdapter.onBookClick() {
            @Override
            public void onClick(View view, int position) {
                final Intent intent = new Intent(getApplicationContext(), Book_detail.class);
                intent.putExtra("title", getBooksList().get(position).getBookTitle());
                intent.putExtra("description", getBooksList().get(position).getBookDesc());
                intent.putExtra("image", getBooksList().get(position).getBookImage());
                intent.putExtra("rating", getBooksList().get(position).getNumStars());
                if (position == getBooksList().size() - 1) {
                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("This is a book that might make you paranoid. Do you still want to proceed?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(intent);
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            return;
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    startActivity(intent);
                }
            }
        };
    }

    private ArrayList<Book> getBooksList(){
        booksList = new ArrayList<Book>();
        booksList.add(new Book("The Internet of Money", "Andreas M. Antonopoulos", R.drawable.img_internetofmoney, 4, "While many books explain the how of bitcoin, The Internet of Money delves into the why of bitcoin. Acclaimed information-security expert and author of Mastering Bitcoin, Andreas M. Antonopoulos examines and contextualizes the significance of bitcoin through a series of essays spanning the exhilarating maturation of this technology.Bitcoin, a technological breakthrough quietly introduced to the world in 2008, is transforming much more than finance. Bitcoin is disrupting antiquated industries to bring financial independence to billions worldwide."));
        booksList.add(new Book("Facebook: The Inside Story", "Steven Levy", R.drawable.img_facebook, 1, "In his sophomore year of college, Mark Zuckerberg created a simple website to serve as a campus social network. The site caught on like wildfire, and soon students nationwide were on Facebook.Today, Facebook is nearly unrecognizable from Zuckerberg's first, modest iteration."));
        booksList.add(new Book("Steve Jobs", "Walter Isaacson", R.drawable.img_stevejobs, 4, "Based on more than forty interviews with Jobs conducted over two years—as well as interviews with more than a hundred family members, friends, adversaries, competitors, and colleagues—Walter Isaacson has written a riveting story of the roller-coaster life and searingly intense personality of a creative entrepreneur whose passion for perfection and ferocious drive revolutionized six industries: personal computers, animated movies, music, phones, tablet computing, and digital publishing."));
        booksList.add(new Book("The Industries of the Future", "Alec Ross", R.drawable.img_industriesofthefuture, 3, "Leading innovation expert Alec Ross explains what’s next for the world: the advances and stumbling blocks that will emerge in the next ten years, and how we can navigate them.While Alec Ross was working as Senior Advisor for Innovation to the Secretary of State, he traveled to forty-one countries, exploring the latest advances coming out of every continent."));
        booksList.add(new Book("The Big Nine", "Amy Webb", R.drawable.img_thebignine, 2, "A call-to-arms about the broken nature of artificial intelligence, and the powerful corporations that are turning the human-machine relationship on its head."));
        booksList.add(new Book("New Thiking", "Dagogo Altraide", R.drawable.img_newthinking, 5, "Technology and ScienceWhat can history’s greatest breakthroughs in science and technology teach us about the future?New Thinking: As each new stage technology builds on the previous innovations of the last, advancements begin to increase at an exponential rate. Now, more than ever, it’s important to see how we got here. What hidden stories lie behind much of the technology we use today?"));
        booksList.add(new Book("The History of the Future", "Blake J. Harris", R.drawable.img_historyofthefuture, 4, "A USA Today bestsellerThe dramatic, larger-than-life true story behind the founding of Oculus, its quest for virtual reality, and its founder's contentious battle for political freedom against Facebook, from the bestselling author of Console Wars.In The History of the Future, Harris once again deep-dives into a tech drama for the ages to expertly tell the larger-than-life true story of Oculus, the virtual reality company founded in 2012 that—less than two years later—would catch the attention of Mark Zuckerberg and wind up being bought by Facebook for over $2 billion dollars."));
        booksList.add(new Book("Behemoth", "Joshua B. Freeman", R.drawable.img_behemoth, 5, "A sweeping, global history of the rise of the factory and its effects on society.\n" +
                "We live in a factory-made world: modern life is built on three centuries of advances in factory production, efficiency, and technology. But giant factories have also fueled our fears about the future since their beginnings, when William Blake called them \"dark Satanic mills."));
        booksList.add(new Book("Swipe to Unlock", "Neel Mehta, Aditya Agashe, Parth Detroja", R.drawable.img_swipetounlock, 3, "Authored by 3 Product Managers at Google, Facebook, and Microsoft, Swipe to Unlock is a comprehensive guide on the must-know concepts of technology and business strategy. It is a must-read for anyone pursuing product management, design, marketing, consulting or business strategy roles in the tech industry"));
        booksList.add(new Book("A Human Algorithm", "Flynn Coleman", R.drawable.img_ahumanalgorithm, 4, "A Human Algorithm: How Artificial Intelligence Is Redefining Who We Are is a 2019 non-fiction book by American international human rights attorney Flynn Coleman."));
        booksList.add(new Book("Life 3.0", "Max Tegmark", R.drawable.img_life3, 5, "Life 3.0: Being Human in the Age of Artificial Intelligence is a book by Swedish-American cosmologist Max Tegmark from MIT. Life 3.0 discusses Artificial Intelligence and its impact on the future of life on Earth and beyond."));
        return booksList;
    }
}
