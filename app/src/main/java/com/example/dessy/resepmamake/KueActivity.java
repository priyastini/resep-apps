package com.example.dessy.resepmamake;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class KueActivity extends AppCompatActivity {
    private RecyclerView recyclerViewKue;
    private AdapterKue adapter;
    private List<Constactor> constactorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsinToolbar();

        recyclerViewKue = (RecyclerView) findViewById(R.id.recyclerview_kue);

        constactorList = new ArrayList<>();
        adapter = new AdapterKue(this, constactorList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewKue.setLayoutManager(mLayoutManager);
        recyclerViewKue.addItemDecoration(new KueActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerViewKue.setItemAnimator(new DefaultItemAnimator());
        recyclerViewKue.setAdapter(adapter);

        prepareKue();

        try{
            Glide.with(this).load(R.drawable.kue).into((ImageView) findViewById(R.id.im_kue_backdrop));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    Inisialisasi collapsing toolbar
    */

    private void initCollapsinToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.kue_collapsingtoolbar);
        collapsingToolbar.setTitle(" ");
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.kue_appbar);
        appBarLayout.setExpanded(true);

        /*
        menampilkan dan menyembunyikan judul
        */
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(){
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout1, int verticalOffset){
                if (scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0){
                    collapsingToolbar.setTitle("Resep Aneka Kue");
                    isShow = true;
                }else if(isShow){
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void prepareKue() {
        int[] gambar = new int[]{
                R.drawable.kue_klepon,
                R.drawable.kue_lapis,
                R.drawable.kue_lumpur,
                R.drawable.kue_tartbuah,
                R.drawable.kue_pastel,
                R.drawable.kue_putuayu
        };

        Constactor constactor = new Constactor("Kue Klepon", gambar[0], "Bahan-bahan :\n" +
                "• 250 gr tepung ketan\n" +
                "• 50 gr tepung beras \n" +
                "• Secukupnya Air hangat \n" +
                "• Secukupnya Pewarna makanan \n" +
                "• 1/3 Kelapa parut \n" +
                "• Secukupnya Garam \n" +
                "• 2 bulat kecil gula merah \n" +
                "• Secukupnya Air utk rebusan \n\n" +
                "Cara membuat :\n" +
                "1. Sisir gula merah. Sisihkan \n" +
                "2. Campur kelapa parut dgn sedikit garam. Lalu kukus 20 menit \n" +
                "3. Campur tepung ketan dengan tepung beras \n" +
                "4. Tambahkan air hangat sedikit sedikit saja sampai jadi adonan dapat dibentuk \n" +
                "5. Bagi adonan menjadi beberapa kemudian beri pewarna \n" +
                "6. Ambil adonan kemudian pipihkan tengahnya beri isian gula merah kemudian tutup dan bentuk bulatan \n" +
                "7. Rebus di air mendidih. Lakukan sampai adonan habis \n" +
                "8. Angkat jika sudah mengapung. Tiriskan \n" +
                "9. Gulingkan klepon di kelapa yang sudah di kukus \n" +
                "10. Sajikan\n");
        constactorList.add(constactor);

        constactor = new Constactor("Kue Lapis", gambar[1], "Bahan-Bahan: \n" +
                "Bagian Kuning:\n" +
                "• 10 kuning telur \n" +
                "• 115 g gula pasir halus/castor \n" +
                "• 125 g mentega, kocok hingga halus dan memutih\n" +
                "• 50 g tepung (ayak) \n" +
                "• 1/2 sdt vanili bubuk \n" +
                "\n" +
                "Bagian Coklat:\n" +
                "• 10 kuning telur \n" +
                "• 125 g gula pasir halus/castor \n" +
                "• 125 g mentega, kocok hingga halus dan memutih \n" +
                "• 15 g tepung terigu (ayak) \n" +
                "• 20 g coklat bubuk \n" +
                "• 1/4 sdt vanili bubuk \n" +
                "\n" +
                "Olesan:\n" +
                "• Buttercream atau selai stroberi secukupnya, untuk olesan \n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Siapkan oven dengan suhu 180ºC \n" +
                "2. Adonan kuning (buat 2 adonan):\n" +
                "- Kocok kuning telur bersama gula hingga kental dan memutih \n" +
                "- Masukkan mentega yang sudah dikocok halus, aduk rata \n" +
                "- Masukkan tepung sambil diayak dengan vanili sedikit demi sedikit, aduk perlahan \n" +
                "- Tuang adonan ke loyang yang sudah diberi alas kertas roti \n" +
                "- Olesi mentega serta ditaburi tepung \n" +
                "- Panggang selama 20 menit, hingga berwarna kuning kecoklatan dan angkat \n" +
                "3. Adonan coklat: \n" +
                "- Kocok kuning telur bersama gula hingga kental dan memutih \n" +
                "- Masukkan menteffa yang sudah dikocok halus, aduk rata \n" +
                "- Masukkan tepung terigu yang sudah diayak bersama coklat bubuk dan vanilli sedikit demi sedikit \n" +
                "- Aduk perlahan hingga adonan tercampur rata \n" +
                "- Tuang adonan ke dalam loyang 22x22 cm yang sudah dialasi kertas roti \n" +
                "- Oles margarin serta ditaburi tepung \n" +
                "- Panggang selama 20 menit, hingga adonan matang dan angkat \n" +
                "4. Penyelesaian:\n" +
                "- Ambil 1 bagian adonan kuning, beri olesan buttercream atau selai pada permukaannya\n" +
                "- Letakkan adonan coklat di atasnya \n" +
                "- Lapisi permukaan adonan coklat dengan buttercream atau selai \n" +
                "- Letakkan adonan kuning lainnya di atas adonan coklat, tekan perlahan agar kue melekat\n");
        constactorList.add(constactor);

        constactor = new Constactor("Kue Lumpur", gambar[2], "Bahan-Bahan: \n" +
                "Bahan:\n" +
                "• 75 gram tepung terigu \n" +
                "• 1/2 sdt baking powder \n" +
                "• 1/2 sdt vanili bubuk \n" +
                "• 3 sdm margarin \n" +
                "• 150 gram pisang raja matang, haluskan \n" +
                "• 2 butir telur, pisahkan putih dan kuningnya \n" +
                "• 300 ml santan kental dari ½ butir kelapa \n" +
                "• 200 ml air \n" +
                "• 1 sdt garam \n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Ayak tepung terigu dengan baking powder dan vanili bubuk. Sisihkan \n" +
                "2. Masak air dan margarin hingga mencair sambil diaduk-aduk hingga rata \n" +
                "3. Masukkan campuran tepung terigu dan pisang raja yang telah dihaluskan, aduk hingga tercampur rata. Angkat \n" +
                "4. Masukkan telur dan tuang santan sedikit demi sedikit sambil terus diaduk \n" +
                "5. Panaskan cetakan kue lumpur yang sebelumnya telah dioelsi margarin \n" +
                "6. Masukkan 2 sendok adonan ke masing-masing cetakan \n" +
                "7. Panggang dengan api yang sedang sampai matang dan angkat \n" +
                "8. Sajikan \n");
        constactorList.add(constactor);

        constactor = new Constactor("Kue Tart Buah", gambar[3], "Bahan-Bahan: \n" +
                "Kulit :\n" +
                "• 250 gram tepung terigu \n" +
                "• 100 gram margarin \n" +
                "• 1/2 sdt garam \n" +
                "• 10 sdm air \n" +
                "• Mentega secukupnya, untuk mengoles \n" +
                "\n" +
                "Fla :\n" +
                "• 50 gram tepung maizena \n" +
                "• 200 ml susu cair \n" +
                "• 75 gram gula pasir \n" +
                "• 1/2 sdt vanili bubuk \n" +
                "\n" +
                "Topping :\n" +
                "• 200 gram mangga segar matang, potong dadu kecil \n" +
                "• 100 gram strawberry segar, potong dadu kecil \n" +
                "• 1/2 bungkus agar-agar bubuk warna putih \n" +
                "• 150 ml air \n" +
                "• 1 sdm gula pasir \n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Kulit:\n" +
                "- Campur semua bahan kulit menjadi satu, aduk rata dan bagi adonan menjadi 20 bagian \n" +
                "- Isi ke dalam cetakan pie mini yang sduah dioles margarin hingga rata \n" +
                "- Panggang dengan suhu 180ºC selama ± 20 menit hingga matang dan berwarna kuning kecokelatan \n" +
                "- Angkat dan dinginkan \n" +
                "2. Masak semua bahan menjadi satu sambil diaduk-aduk hingga mengental \n" +
                "3. Angkat dan biarkan dingin \n" +
                "4. Isikan flak ke dalam kulit pie, beri atasnya dengan irisan manga dan strawberry \n" +
                "5. Masak agar-agar, gula, dan air hingga mengental \n" +
                "6. Oleskan buah dengan larutan agar-agar hingga rata \n" +
                "7. Biarkan hingga mengeras \n" +
                "8. Sajikan \n");
        constactorList.add(constactor);

        constactor = new Constactor("Kue Pastel", gambar[4], "Bahan-Bahan: \n" +
                "• 300 gr tepung terigu \n" +
                "• 1/2 sdt garam \n" +
                "• 1/2 sdt gula \n" +
                "• Kaldu bubuk \n" +
                "• 100 ml air \n" +
                "• 50 gr mentega\n" +
                "\n" +
                "Cara membuat :\n" +
                "1. Campur semua bahan jadi satu,uleni hingga kalis \n" +
                "2. Diamkan adonan kurleb 30 menit \n" +
                "3. Ambil sedikit adonan gilas lalu isi dengan isian \n" +
                "4. Lalu goreng pastel hingga kecoklatan \n" +
                "5. Hidangkan pastel dengan cabe atau saus sambal \n");
        constactorList.add(constactor);

        constactor = new Constactor("Kue Putu Ayu", gambar[5], "Bahan-Bahan: \n" +
                "• 125 gram Tepung Terigu \n" +
                "• 2 bungkus kecil Santan Kara \n" +
                "• 130 gram Gula \n" +
                "• 3000 Kelapa Parut \n" +
                "• 1/2 sdt Garam \n" +
                "• 1/2 sdt Sp \n" +
                "• 1/2 sdt Vanili \n" +
                "• 2 Telur Ayam \n" +
                "• secukupnya Pasta pandan \n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Kukus terlebih dahulu kelapa parut nya selama 10 menit \n" +
                "2. Setelah kelapa sudah d kukus, masukan kelapa dalam cetakan \n" +
                "3. Di tempat yg berbeda mixer telur, vanili, sp dan gula. Mixer/kocok sampe mengental \n" +
                "4. Setelah adonan mengental, masukan tepung trigu, garam, santan dan pasta pandan secukupnya \n" +
                "5. Setelah adonan sudah di masukan dalam cetakan kukus selama 15 menit\n" +
                "6. Siap dihidangkan \n");
        constactorList.add(constactor);


        adapter.notifyDataSetChanged();

    }

    /*
    Recycler View item decoration
    */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }


    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
