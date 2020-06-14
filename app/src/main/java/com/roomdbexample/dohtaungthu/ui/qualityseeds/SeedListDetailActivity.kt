package com.roomdbexample.dohtaungthu.ui.qualityseeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.roomdbexample.dohtaungthu.R
import com.roomdbexample.dohtaungthu.model.SeedInfo
import com.roomdbexample.dohtaungthu.model.Seeds
import com.roomdbexample.dohtaungthu.ui.qualityseeds.adapter.SeedListAdapter
import kotlinx.android.synthetic.main.activity_seed_list_detail.*

class SeedListDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seed_list_detail)

        val seedInfoList = mutableListOf<SeedInfo>()
        val reg = intent.getStringExtra("region")
        iconBackSeedListDetail.setOnClickListener {
            onBackPressed()
        }

        val kcSeedList = mutableListOf<Seeds>()
        kcSeedList.add(Seeds("ကချင်စတားကုမ္ပဏီလီမိတက်","ဦးဆိုင်းနော်","ပါရှီးငှက်ပျော","ဝိုင်းမော်မြို့နယ်၊ မိုင်းနားကျေးရွာ၊ ကွင်းအမှတ်-မကောက်ယန်(03)","09 451782575"))
        kcSeedList.add(Seeds("Green Mountain Stream Co.,Ltd","ဦးဆိုင်းနော်","ခရမ်းရောင် နဂါးမောက်","ဝိုင်းမော်မြို့နယ်၊ မိုင်းနားကျေးရွာ၊ ကွင်းအမှတ်-ဝေရောင်ကွင်း၊ ဦးပိုင်အမှတ်-၀၅၅","09 451782575"))

        val ygnSeedList = mutableListOf<Seeds>()
        ygnSeedList.add(Seeds("Aventine Limited","ဒေါ်အေးစန္ဒာလွင်"," ပဲတီစိမ်း","ရေဆင်း-၁၁၊ ရေဆင်း-၁၄\n" +
                "မျိုးစေ့ထုတ်လုပ်မည့်ဒေသ - ခရမ်းမြို့နယ်၊ ညောင်ပင်ကွင်းကျေးရွာအုပ်စု၊ ညောင်ပင်ကွင်းကျေးရွာ၊ ကွင်းအမှတ်(၇၉၇အေ၊ ၇၈၂)၊ဦးပိုင်အမှတ်- ၂၅၊ ၁၀၀/၁၊ ၁၀၀/၂","09 2006494"))
        ygnSeedList.add(Seeds("U-net International Co.,Ltd","ဒေါ်ခင်ထားထား"," ဂျပန်စပါး(Hitomebore)","ထန်းတပင်မြို့နယ်၊ ငှက်သိုက်ကျေးရွာအုပ်စု၊ အပြင်သဲဖြူ၊ သံပုရာကုန်းကျေးရွာ","09 965423555"))

        seedInfoList.add(SeedInfo(1,"ကချင်ပြည်နယ်",kcSeedList))
        seedInfoList.add(SeedInfo(2,"ရန်ကုန်တိုင်း",ygnSeedList))

        when(reg){
            "kachin" -> {
                setUpDataToAdapter(seedInfoList[0])
            }
            "ygn" -> {
                setUpDataToAdapter(seedInfoList[1])
            }
        }

    }

    private fun setUpDataToAdapter(seedInfo: SeedInfo) {
        val seedListAdapter = SeedListAdapter(seedInfo)
        rvSeedList.layoutManager = LinearLayoutManager(this)
        rvSeedList.adapter = seedListAdapter
    }
}