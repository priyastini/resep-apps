package com.example.dessy.resepmamake;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
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

public class MasakanActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMasakan;
    private AdapterMasakan adapter;
    private List<Constactor> constactorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masakan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsinToolbar();

        recyclerViewMasakan = (RecyclerView) findViewById(R.id.recyclerview_masakan);

        constactorList = new ArrayList<>();
        adapter = new AdapterMasakan(this, constactorList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewMasakan.setLayoutManager(mLayoutManager);
        recyclerViewMasakan.addItemDecoration(new MasakanActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerViewMasakan.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMasakan.setAdapter(adapter);

        prepareMasakan();

        try{
            Glide.with(this).load(R.drawable.masakan).into((ImageView) findViewById(R.id.im_masakan_backdrop));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    Inisialisasi collapsing toolbar
    */

    private void initCollapsinToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.masakan_collapsingtoolbar);
        collapsingToolbar.setTitle(" ");
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.masakan_appbar);
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
                    collapsingToolbar.setTitle("Resep Masakan");
                    isShow = true;
                }else if(isShow){
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void prepareMasakan() {
        int[] gambar = new int[]{
                R.drawable.nasigoreng,
                R.drawable.gadogado,
                R.drawable.perkdelkentang,
                R.drawable.perkedelikan,
                R.drawable.sateikan,
                R.drawable.jamurcrispy,
                R.drawable.sayurasem,
                R.drawable.suptomat,
                R.drawable.tempepenyet,
                R.drawable.orektempe
        };

        Constactor constactor = new Constactor("Nasi Goreng", gambar[0], "Bahan : \n" +
                        "• 4 piring nasi putih \n" +
                        "• 200 gram udang goreng \n" +
                        "• 100 gram dada ayam goreng \n" +
                        "• 2 buah cabai merah \n" +
                        "• 2 sendok makan kecap manis \n" +
                        "• 2 sendok makan saos tomat \n" +
                        "• Mentega secukupnya \n\n" +
                        "Bumbu Halus : \n" +
                        "• 5 siung bawang merah \n" +
                        "• 3 siung bawang putih \n" +
                        "• 1 sendok teh garam \n" +
                        "• 1/2 sendok teh gula pasir \n" +
                        "• 1/2 sendok teh terasi\n" +
                        "Bahan Pelengkap : \n" +
                        "• 4 butir telur ceplok \n" +
                        "• Bawang goreng secukupnya \n\n" +
                        "Cara Membuatnya :\n" +
                        "1. Panaskan mentega, lalu masukkan bumbu-bumbu yang telah dihaluskan dan cabai merah, setelah itu masak hingga berbau harum. \n" +
                        "2. Masukkan nasi, ayam dan udang, kemudian aduk-aduk hingga rata dan semua bahan tercampur menjadi satu dengan sempurna. \n" +
                        "3. Angkat dan nasi goreng spesial siap disajikan selagi hangat dengan bahan pelengkapnya. \n");
        constactorList.add(constactor);

        constactor = new Constactor("Gado-Gado", gambar[1], "Bahan-Bahan: \n" +
                        "• Sayuran \n" +
                        "• Kentang 500 gram yang di rebus\n" +
                        "• Ketimun 1 batang kupas tipis\n" +
                        "• Tauge 200 gram lalu direbus \n" +
                        "• Telur ayam rebus \n" +
                        "• Kacang panjang, potong sepanjang 2 cm \n" +
                        "• Tomat 1 buah, iris menjadi 5 bagian\n" +
                        "• Daun Selada \n\n" +
                        "Bumbu Saus:\n" +
                        "• Kacang tanah yang digoreng \n" +
                        "• Cabai merah 4 buah  \n" +
                        "• Bawang putih 6 siung \n" +
                        "• Kencur sekitar 6 cm \n" +
                        "• Terasi secukupnya \n" +
                        "• Asam Jawa secukupnya \n" +
                        "• Garam 1 sdm \n" +
                        "• Daun jeruk \n" +
                        "• Gula merah sebanyak 3 sdm \n\n" +
                        "Cara Memasak: \n" +
                        "1. Pertama-tama haluskan kacang tanah, bawang putih, terasi, daun jeruk, dan gula merah. Tambahkan air agar tidak terasa terlalu kental. Anda bisa menambahkan jumlah cabai bila suka constactor pedas.\n" +
                        "2. Di piring terpisah, Anda bisa menyiapkan sayuran untuk dimakan bersama gado-gado. \n" +
                        "3. Setelah siap, siramkan saus tadi ke atas sayuran dan tambahkan kerupuk sebagai pelengkapannya. \n");
        constactorList.add(constactor);

        constactor = new Constactor("Perkedel Kentang", gambar[2], "Bahan :\n" +
                        "•500ml Minyak untuk menggoreng\n" +
                        "•500 gr kentang, kupas bersih\n" +
                        "•1 batang daun seledri, diiris-iris halus\n" +
                        "•1 butir telur\n" +
                        "•1 buah bawang merah\n" +
                        "•1/4 sdt merica bubuk\n" +
                        "•1/4 sdt pala bubuk\n" +
                        "•1/2 sdt garam\n\n" +
                        "Cara Pembuatannya :\n" +
                        "1.Panaskan minyak goreng kedalam wajan, masukkan kentang.\n" +
                        "2.Masak hingga berubah warna dan empuk. Angkat tiriskan sebentar.\n" +
                        "3.Di dalam cobek yang besar, segera masukkan kentang yang selesai digoreng (masih panas), haluskan.\n" +
                        "4.Setelah kentang halus, tambahkan seledri, merica bubuk, pala, garam, kuning telur, dan bawang merah. Aduk-aduk hingga rata.\n" +
                        "5.Bentuk adonan kentang yang sudah tercampur dengan bumbu menjadi bulatan-bulatan pipih atau bentuk perkedel sampai habis.\n" +
                        "6.Panaskan minyak goreng. Sementara itu kocok lepas telur.\n" +
                        "7.Jika minyak goreng sudah panas, celupkan setiap perkedel kedalam putih telur hingga rata sebelum digoreng.\n" +
                        "8.Goreng perkedel hingga warnanya berubah kuning kecoklatan, jaga dan dibalik agar merata dan jangan sampai gosong. Angkat, tiriskan.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Perkedel Ikan", gambar[3], "Bahan-bahan:\n" +
                        "•Ikan Tuna fillet 500 gram, haluskan.\n" +
                        "•Kentang 5 digoreng dan dihaluskan.\n" +
                        "•Bawang merah 5 siung.\n" +
                        "•Bawang putih 5 siung.\n" +
                        "•Telur 2 butir.\n" +
                        "•Garam secukupnya.\n" +
                        "•Merica secukupnya.\n" +
                        "•Penyedap rasa.\n\n" +
                        "Cara Membuat:\n" +
                        "1.Tumis bawang merah dan bawang putih setengah matang.\n" +
                        "2.Haluskan bawang putih, bawang merah, garam dan lada/merica.\n" +
                        "3.Campurkan kentang yang sudah dihaluskan dengan ikan tuna halus. Setelah itu masukan bumbu. Tambahan telur agar adonan tidak hancur.\n" +
                        "4. Goreng dengan minyak panas. Apabila sudah berwarna kemerahan, angkat dan tiriskan.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Sate Ikan Tenggiri", gambar[4], "Bahan-bahan:\n" +
                        "•Ikan tenggiri fillet.\n" +
                        "•Margarin atau minyak.\n" +
                        "•Bawang merah 4 siung.\n" +
                        "•Bawang putih 5 siung.\n" +
                        "•Kemiri.\n" +
                        "•Jintan 1/2 sendok makan.\n" +
                        "•Jahe 2 cm.\n" +
                        "•Kunyit 3 cm.\n" +
                        "•Merica bubuk.\n\n" +
                        "Cara Membuat:\n" +
                        "1. Potong ikan tengiri kecil-kecil sesuai selera lalu tusuk-tusuk seperti sate.\n" +
                        "2. Tumbuk jadi satu bawang merah, bawang putih, jintan, jahe, kunyit, kemiri, dan merica. Kalau sudah tercampur, beri margarin atau minyak goreng sedikit saja.\n" +
                        "3. Siapkan frying pan atau tempat memanggang barbekyu bila ada. Jangan lupa untuk diolesi margarin. Bakar sate diatasnya sambil diolesi bumbu-bumbu tadi.\n" +
                        "4. Sate ikan tengiri siap dihidangkan dengan anek resep constactor kesukaan Anda yang lain.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Jamur Crispy", gambar[5], "Bahan-bahan:\n" +
                        "•Jamur tiram diiris tipis.\n" +
                        "•Tepung Crispy.\n" +
                        "•Tepung Maizena\n" +
                        "•Garam secukupnya.\n" +
                        "•Bawang putih 3 siung.\n" +
                        "•Gula pasir.\n" +
                        "•Lada bubuk.\n" +
                        "•Minyak goreng.\n\n" +
                        "Cara Membuat:\n" +
                        "1.Cuci jamur sampai bersih. Campur garam, bawang putih,gula pasir dan lada bubuk jadi satu.\n" +
                        "2.Campur tepung maizena dengan air dingin. Masukan bumbu-bumbu constactor tadi. Lalu balurkan pada jamur.\n" +
                        "3.Setelah itu, lapisi jamur dengan tepung Crispy dan jamur siap digoreng. Resep constactor nusantara ini pun siap dihidangkan\n");
        constactorList.add(constactor);

        constactor = new Constactor("Sayur Asem", gambar[6], "Bahan-bahan :\n" +
                        "•150 gr nangka muda\n" +
                        "•2 buah jagung manis dipotong 3 bagian\n" +
                        "•60 gr kacang tanah\n" +
                        "•¼ buah pepaya muda\n" +
                        "•50 gr daun melinjo\n" +
                        "•150 gr kacang panjang\n" +
                        "•1 liter air\n\n" +
                        "Bumbu Halus :\n" +
                        "•2 buah cabai merah\n" +
                        "•3 butir bawang merah\n" +
                        "•1 sdt terasi bakar\n" +
                        "•1 sdm garam\n" +
                        "•1 sdt gula\n" +
                        "•1 cm lengkuas\n" +
                        "•2 lembar daun salam\n" +
                        "•3 buah asam muda\n" +
                        "•2 buah tomat\n\n" +
                        "Cara Membuatnya :\n" +
                        "1.Rebus tetelan dalam air hingga empuk, masukkan nangka muda, melinjo, kacang tanah, lengkuas, asam jawa dan daun salam. Masukkan tomat hingga setengah matang.\n" +
                        "2.Ambil mangkok, angkat tomat dari panci hancurkan tomat dalam mangkok, beri sedikit kuah, saring. Masukkan air tomat ke dalam panci kembali.\n" +
                        "3.Masukkan bumbu yang telah dihaluskan, didihkan kembali, masukkan pepaya muda, jagung manis, terakhir daun melinjo.masak sebentar. Sajikan.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Sup Tomat", gambar[7], "Bahan-Bahan:\n" +
                        "•Tomat 4 buah direbus dan haluskan\n" +
                        "•Wortel 1 buah, potong kecil-kecil.\n" +
                        "•Bawang merah sebanyak 5 siung.\n" +
                        "•Ayam, potong dadu kecil-kecil.\n" +
                        "•Buncis 80 gram, dipotong-potong.\n" +
                        "•Minyak goreng.\n" +
                        "•Garam 1 sendok makan.\n" +
                        "•Gula pasir 1 sendok teh.\n" +
                        "•Merica bubuk secukupnya.\n" +
                        "•Kecap manis 1 sendok makan.\n" +
                        "•Saus tomat 85 gram.\n" +
                        "•Air kaldu ayam 1850 milliliter.\n\n" +
                        "Cara Membuat:\n" +
                        "1.Panaskan minyak setelah itu tumis bawang merah.\n" +
                        "2.Setelah berbau harum, masukan kaldu ayam dan tunggu sampai mendidih\n" +
                        "3.Masukan bumbu-bumbu seperti merica, garam, gula pasir, kecap manis, saos tomat, dan kecap. Aduk-aduk sampai mendidih.\n" +
                        "4.Yang terakhir, masukan buncis, wortel, dan ayam. Aduk sebentar sampai semua tercampur lalu biarkan sampai mendidih.\n" +
                        "5.Sop tomat pun siap disantap.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Tempe Penyet", gambar[8], "Bahan-bahan:\n" +
                        "•Bawang putih 5 siung.\n" +
                        "•Cabe merah 5 buah.\n" +
                        "•Tempe.\n" +
                        "•Gula dan garam.\n\n" +
                        "Cara Membuat:\n" +
                        "1.Iris tipis-tipis tempe dan goreng setengah matang. Tiriskan sejenak.\n" +
                        "2.Goreng bawang dan cabai sampai halus. Apabila suka, bisa ditambahkan terasi kedalamnya.\n" +
                        "3.Untuk membuat sambal, campur bawang dan cabe tadi dengan gula dan garam. Resep constactor Indonesia ini bersifat relatif. Artinya, Anda bisa mengatur pedas dan gurihnya sesuai selera.\n" +
                        "4.Sajikan dengan nasi putih yang masih hangat.\n");
        constactorList.add(constactor);

        constactor = new Constactor("Orek Tempe", gambar[9], "Bahan-bahan:\n" +
                        "•Tempe 500 gram. Potong kecil-kecil berbentuk dadu.\n" +
                        "•Lengkuas 2 siung, kupas kulitnya.\n" +
                        "•Daun salam 1 lembar\n" +
                        "•Kecap manis\n" +
                        "•Gula, garam, minyak\n" +
                        "•Penyedap rasa\n\n" +
                        "Cara Membuat:\n" +
                        "1.Tumis bawang putih dengan minyak sampai berbau harum. Setelah itu, masukan daun salam dan lengkuas lalu tumis kembali sampai berubah warna.\n" +
                        "2.Setelah matang, masukan tempe, gula, garam, penyedap rasa, dan kecap. Tumis hingga tercampur merata.\n" +
                        "3.Tambahkan air secukupnya lalu tunggu sampai matang. Constactor Indonesia yang lezat ini pun siap dihidangkan.\n");
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
