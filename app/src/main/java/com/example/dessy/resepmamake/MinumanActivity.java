package com.example.dessy.resepmamake;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
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

public class MinumanActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMinuman;
    private AdapterMinuman adapter;
    private List<Constactor> constactorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsinToolbar();

        recyclerViewMinuman = (RecyclerView) findViewById(R.id.recyclerview_minuman);

        constactorList = new ArrayList<>();
        adapter = new AdapterMinuman(this, constactorList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewMinuman.setLayoutManager(mLayoutManager);
        recyclerViewMinuman.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerViewMinuman.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMinuman.setAdapter(adapter);

        prepareMinuman();

        try{
            Glide.with(this).load(R.drawable.minuman).into((ImageView) findViewById(R.id.im_minuman_backdrop));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    Inisialisasi collapsing toolbar
    */

    private void initCollapsinToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.minuman_collapsingtoolbar);
        collapsingToolbar.setTitle(" ");
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.minuman_appbar);
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
                    collapsingToolbar.setTitle("Resep Minuman");
                    isShow = true;
                }else if(isShow){
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void prepareMinuman() {
        int[] gambar = new int[]{
                R.drawable.minuman_tarolatte,
                R.drawable.minuman_esjeruknipis,
                R.drawable.minuman_sopbuah,
                R.drawable.minuman_bluesunkist ,
                R.drawable.minuman_cookiesmilkshake,
                R.drawable.minuman_masalachai,
                R.drawable.minuman_virginpina,
                R.drawable.minuman_blueocean,
                R.drawable.minuman_essarang,
                R.drawable.minuman_jamukulitasam

        };

        Constactor constactor = new Constactor("Taro Latte", gambar[0],
                "Bahan-bahan :\n" +
                        "• 2 sendok teh bubuk taro \n" +
                        "• 240 ml susu putih cair\n" +
                        "• Gula pasir sesuai selera\n" +
                        "• 100 ml air hangat\n" +
                        "• Es batu secukupnya\n\n" +
                        "Cara membuatnya:\n" +
                        "1. Larutkan bubuk taro menggunakan air hangat. Kocok selama 30 detik sampai permukaannya berbuih.\n" +
                        "2. Masukkan susu ke dalam botol atau tempat minum. Tutup rapat dan kocok sekitar 1 menit untuk membuat buih di permukaannya.\n" +
                        "3. Siapkan es batu secukupnya ke dalam gelas. Tuangkan larutan taro, gula pasir, dan susu yang sudah dikocok.\n" +
                        "4. Aduk rata semua bahan di dalam gelas tersebut.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Es Jeruk Nipis", gambar[1],
                "Bahan-bahan\n" +
                        "• 100 ml air jeruk nipis\n" +
                        "• 500 ml air\n" +
                        "• 500 gram gula pasir\n\n" +
                        "Cara membuat\n" +
                        "1. Campur air dengan gula pasir, rebus hingga mendidih dan gula hancur, buang buihnya dan dinginkan.\n" +
                        "2. Saring dan masukkan ke dalam botol.\n" +
                        "3. Hidangkan sebagai minuman penyegar dengan ditambah air.\n" +
                        "4. Dapat disajikan hangat maupun dingin.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Sop Buah", gambar[2],
                "Bahan-bahan:\n" +
                        "• Aneka buah (semangka, melon, pir, apel, dll)\n" +
                        "• Susu kental manis\n" +
                        "• Sirup rasa coco pandan\n" +
                        "• Air mineral\n\n" +
                        "Cara membuat:\n" +
                        "1. Potong-potong kecil semua buah-buahan.\n" +
                        "2. Masukan buah-buahan yang telah di potong-potong kecil ke wadah besar.\n" +
                        "3. Masukan air, susu kental manis, dan sirup coco pandan secukupnya\n" +
                        "4. Masukan es batu.\n" +
                        "5. Aduk rata dan sajikan. Selamat mencoba.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Blue Sunkist Moctail", gambar[3],
                "Bahan-bahan:\n" +
                        "• 150 ml pepsi blue\n" +
                        "• 50 ml jus jeruk (buavita jeruk)\n" +
                        "• 1 buah strawberry\n" +
                        "• Es batu secukupnya\n\n" +
                        "Cara membuat:\n" +
                        "1. Masukan jus jeruk kedalam jus glass.\n" +
                        "2. Masukan es batu hingga penuh. Lalu masukan pepsi blue dengan cara layering.\n" +
                        "3. Beri garnish strawberry, dan blue sunrise mocktail ready to serve.\n" );
        constactorList.add(constactor);

        constactor = new Constactor("Cookies Milkshake", gambar[4],
                " Bahan-bahan :\n" +
                        "• 1 Sachet skm (putih/coklat sesuka hati)\n" +
                        "• 2 Bungkus GoodTime(bisa pake oreo jugaa)\n" +
                        "• Es Batu secukup nya\n" +
                        "• Secukupnya Air\n\n" +
                        "Cara Membuat:\n" +
                        "1. Cairkan susu dengan air, tidak usah terlalu banyak biar lembut\n" +
                        "2. Masukan susu, es batu dan goodtime ke dalam blender\n" +
                        "3. Blender sampai lembut\n" );
        constactorList.add(constactor);

        constactor = new Constactor("Masalachai", gambar[5],
                "Bahan-bahan:\n" +
                        "• 1 liter air\n" +
                        "• 2 kantong teh celup \n" +
                        "• Secukupnya jahe \n" +
                        "• 3 batang kayumanis \n" +
                        "• 3 buah kembang peka \n" +
                        "• 5 biji kapulaga \n" +
                        "• Secukupnya cengkeh \n" +
                        "• 5 sdm gulapasir/ sesuai selera \n" +
                        "• Krimer atau skm (saya pake skm) \n\n" +
                        "Cara membuat :\n" +
                        "1. Panggang bahan kecuali teh dan gula untuk mengeluarkan aromanya \n" +
                        "2. Rebus semua bahannya kurleb 10menit dengan api kecil \n" +
                        "3. Setelah itu biarkan meresap sampai beberapa menit \n" +
                        "4. Saring dulu sebelum disajikan \n" +
                        "5. Lalu tambahkan krimer atau skm \n" +
                        "6. Siap dihidangkan\n" );
        constactorList.add(constactor);

        constactor = new Constactor("Virginpina", gambar[6],
                "Bahan :\n" +
                        "• Pineapple fruit (slice) \n" +
                        "• 3 oz (90 ml) pineapple juice \n" +
                        "• 1 oz orange juice \n" +
                        "• 1 oz lemon juice \n" +
                        "• 1 oz sugar syrup \n" +
                        "• 1 oz coconut cream \n" +
                        "• ice crushed \n\n" +
                        "Cara membuat :\n" +
                        "1. Masukan semua bahan lalu di blender 30 detik \n" +
                        "2. Hiasi gelas dengan potongan buah nanas \n");
        constactorList.add(constactor);

        constactor = new Constactor("Blue Ocean", gambar[7],
                "Bahan-bahan :\n" +
                        "• 500 ml minuman Soda warna biru \n" +
                        "• 2 sdm Syrup Sunquick \n" +
                        "• Buah Potong, saya mangga \n" +
                        "• Secukupnya Es Batu \n\n" +
                        "Cara membuat :\n" +
                        "1. Beri syrup Sunquick masing2 Satu sendok makan \n" +
                        "2. Tuang minuman soda warna biru tambahkan potongan buah segera sajikan \n" +
                        "3. Siap dihidangkan. \n" );
        constactorList.add(constactor);

        constactor = new Constactor("Es Sarang Burung", gambar[8],
                "Bahan-bahan :\n" +
                        "• 1 pak Nata de coco \n" +
                        "• Biji selasih \n" +
                        "• 2 bungkus \n" +
                        "• 100 gr Gula \n" +
                        "• 1 Leci kalengan \n" +
                        "• Spritte \n\n" +
                        "Cara membuat :\n" +
                        "1. Buat ager swallow 2 bungkus dg gula 100gr aja plus air 300ml \n" +
                        "2. Campur semua, nata de coco, leci kaleng, parutan ager, biji selasih \n" +
                        "3. Tata di gelas, tuang spritte dan terakhir kasih es batu\n" +
                        "4. Siap dihidangkan. \n" );
        constactorList.add(constactor);

        constactor = new Constactor("Jamu Kulit Asam", gambar[9],
                "Bahan-bahan :\\n\n" +
                        "• 10 kunyit segar \n" +
                        "• Gula jawa \n" +
                        "• Asam jawa \n\n" +
                        "Cara membuat :\n" +
                        "1. Kupas bersih kunyit, sisir 1 buah gula jawa bulat kecil, siapkan asam jawa kupas \n" +
                        "2. Blender kunyit tambahkan sedikit air supaya lebih mudah diblender \n" +
                        "3. Tuang hasil blenderan kunyit dalam panci berisi air beserta gula jawa dan asam jawa \n" +
                        "4. Aduk-aduk sampai jamu matang.Biarkan dingin dahulu kemudian saring \n" +
                        "5. Masukan kulkas, disajikan dingin lebih segar.\n" );
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

























