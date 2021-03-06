package aksar.inji.outthecloset;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class ClothesPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CLOTHES_ID =
            "com.aksar.inji.outthecloset.clothes_id";


    private ViewPager mViewPager;
    private List<Clothes> mClothes;

    private static boolean isNew = false;

    public static Intent newIntent(Context packageContext, UUID clothesId) {
        Intent intent = new Intent(packageContext, ClothesPagerActivity.class);
        intent.putExtra(EXTRA_CLOTHES_ID, clothesId);
        return intent;
    }

    public static Intent newClothesIntent(Context context) {
        isNew = true;
        return new Intent(context, ClothesPagerActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_pager);
        mViewPager = (ViewPager) findViewById(R.id.clothes_view_pager);


            UUID clothesId = (UUID) getIntent().getSerializableExtra(EXTRA_CLOTHES_ID);
            mClothes = ClothesLab.get(this).getClothes();
            for (int i = 0; i < mClothes.size(); i++) {
                if (mClothes.get(i).getmId().equals(clothesId)) {
                    mViewPager.setCurrentItem(i);
                    break;
                }
            }




        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Clothes clothes = mClothes.get(position);
                if (!isNew)
                    return ClothesFragment.newInstance(clothes.getmId());
                else
                    return newClothesFragment.newClothesInstance();
            }

            @Override
            public int getCount() {

                    return mClothes.size();

            }
        });


    }
}
