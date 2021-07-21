package com.tinyit.recyclerclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.tinyit.recyclerclick.databinding.ActivityMainBinding
import dtos.UserProfile

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding:ActivityMainBinding
    private lateinit var userAd:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        var user:List<UserProfile> = listOf(
            UserProfile("Okoh", "Awlas", R.drawable._xin0r2nwsm),
            UserProfile("John", "Terry Orum", R.drawable.bfn_mtz_tru),
            UserProfile("Bil", "Gate", R.drawable.emitt5ykaec),
            UserProfile("Timo", "Fedin", R.drawable.yng9t71m_4w),
            UserProfile("judge", "bemi okigho", R.drawable._hbnvyeulkk),
            UserProfile("Anorld", "Jerry Okonta", R.drawable.emitt5ykaec),
            UserProfile("Musa", "Muhammed", R.drawable._j_qv4buckm),
            UserProfile("Adigwe", "Fred Okoro", R.drawable.yng9t71m_4w),
            UserProfile("James", "Benald", R.drawable.bb8kit6g9l4),
            UserProfile("Efe", "Jenny", R.drawable._xin0r2nwsm),
            UserProfile("Ujiri", "Sonia", R.drawable.dzbtqjavgnw),
            UserProfile("Okonta", "Ujiri okiri", R.drawable.ymtldviqtu0),
            UserProfile("Micheal", "Friday", R.drawable._xin0r2nwsm),
            UserProfile("Atigha", "Jenny", R.drawable.bf68o_1nizs),
            UserProfile("E-Money", "Fat ban", R.drawable.aogwll8ejko),
            UserProfile("Thunde", "Jopro", R.drawable.kyrrd5wrnwc),
            UserProfile("Eunice", "Okigwe", R.drawable._xin0r2nwsm),
            UserProfile("Enoch", "South South", R.drawable.f1bymegz_ao),
            UserProfile("Babel", "Buhari", R.drawable.yng9t71m_4w),
            UserProfile("J-BANY", "Robert", R.drawable.bf68o_1nizs)
        )
        userAd = UserAdapter(this, user)
        mainBinding.userList.setHasFixedSize(true)
        mainBinding.userList.adapter = userAd
    }
}