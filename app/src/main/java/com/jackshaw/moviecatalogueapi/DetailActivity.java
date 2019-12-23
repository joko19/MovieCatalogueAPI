package com.jackshaw.moviecatalogueapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jackshaw.moviecatalogueapi.model.Movie;
import com.jackshaw.moviecatalogueapi.model.TVShow;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";
    private TextView tvTitle, tvRating, tvPopularyty, tvRelease, tvOverview;
    private ImageView imgPoster, imgBackdrop;
    private ProgressBar progressBar;
    private Movie pilihFilm;
    private TVShow acara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        progressBar = findViewById(R.id.progressBar);

        pilihFilm = getIntent().getParcelableExtra(EXTRA_MOVIE);
        acara = getIntent().getParcelableExtra(EXTRA_TV);
        if (pilihFilm == null && acara == null){
            showLoading(true);
        }
        else {
            showLoading(false);
            inisialisasi();
            jalankan();
        }
    }


    public void tambahGambar(String data, ImageView letak) {
        Glide.with(DetailActivity.this)
                .load(data)
                .into(letak);
    }
    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void inisialisasi() {
        tvTitle = findViewById(R.id.tv_judul);
        tvRating = findViewById(R.id.tv_rating);
        tvPopularyty = findViewById(R.id.tv_popularity);
        tvRelease = findViewById(R.id.tv_rilis);
        tvOverview = findViewById(R.id.tv_content);
        imgPoster = findViewById(R.id.img_poster);
        imgBackdrop = findViewById(R.id.img_backdrop);
    }
    private void jalankan() {
            if (pilihFilm != null) {
                tvTitle.setText(pilihFilm.getTitle());
                tvRating.setText(pilihFilm.getRating());
                tvRelease.setText(pilihFilm.getRelease());
                tvOverview.setText(pilihFilm.getOverview());

                tambahGambar(pilihFilm.getPoster(), imgPoster);
                tambahGambar(pilihFilm.getBackdrop(), imgBackdrop);
            }
            if (acara != null) {
                tvTitle.setText(acara.getJudul());
                tvRating.setText(acara.getRating());
                tvRelease.setText(acara.getRelease());
                tvOverview.setText(acara.getOverview());
                tambahGambar(acara.getPoster(), imgPoster);
                tambahGambar(acara.getPoster(), imgBackdrop);
            }
        }
}
