package com.roomdbexample.dohtaungthu.ui.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.roomdbexample.dohtaungthu.R
import com.roomdbexample.dohtaungthu.model.FinanceBranch
import com.roomdbexample.dohtaungthu.model.FinanceInfo
import com.roomdbexample.dohtaungthu.ui.finance.adapter.AboutCompanyActivity
import com.roomdbexample.dohtaungthu.ui.finance.adapter.FinanceBranchListAdapter
import kotlinx.android.synthetic.main.activity_finance_detail.*

class FinanceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_detail)

        iconBackFinanceDetail.setOnClickListener {
            onBackPressed()
        }
        val financeInfoList = mutableListOf<FinanceInfo>()

        val mahaBranchList = mutableListOf<FinanceBranch>()
        mahaBranchList.add(FinanceBranch("မဟာ ရွှေဘိုဆိုင်ခွဲ\n" + "အမှတ်(၄/၁၉၀) ရေဦးလမ်း၊ ကြည်တော်စုရပ်ကွက်၊ ရွှေဘိုမြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ ဝက်လက်ဆိုင်ခွဲ\n" + "ခတ္တာလမ်း၊ ဘောကဗလ (၂)ရပ်ကွက်၊ ဝက်လက်မြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ အရာတော်ဆိုင်ခွဲ\n" + "အမှတ်(၂)နယ်မြေ၊ မန်ကျည်းအုန်းရပ်ကွက်၊ အရာတော်မြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ မတ္တရာဆိုင်ခွဲ\n" + "အမှတ်(၂/၁၁၈၈)၊ မြနန္ဒာလမ်း၊ မတ္တရာမြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ မုံရွာဆိုင်ခွဲ\n" + "နေဇာလမ်း၊ ဘုန်းစိုးရပ်ကွက်၊ မုံရွာမြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ ဇလွန်ဆိုင်ခွဲ\n" + "အမှတ်(၇၃၉)၊ သူရာလမ်း၊ လမ်းမတော်မြောက်ရပ်ကွက်၊ ဇလွန်မြို့\n" + "\n"))
        mahaBranchList.add(FinanceBranch("မဟာ နတ်တလင်းဆိုင်ခွဲ\n" + "အမှတ်(၁၁၉)၊ သာစည်လမ်း၊ သာစည်ရပ်ကွက်၊ နတ်တလင်းမြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ ပေါင်းတည်ဆိုင်ခွဲ\n" + "(၉)လမ်းဈေး (၂)ရပ်ကွက်၊ ပေါင်းတည်မြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ ဟင်္သာတဆိုင်ခွဲ\n" + "အမှတ်(၁၄၂)၊ သုံးပင်ခွင်အလယ်လမ်း၊ ဟင်္ဟာတမြို့"))
        mahaBranchList.add(FinanceBranch("မဟာ မြင်းမူဆိုင်ခွဲ\n" + "အမှတ်(၁၅၉၂)၊ မုံရွာ-မန္တလေးလမ်းမကြီးဘေး၊ အနောက်ရပ်ကွက်၊ မြင်းမူမြို့"))

        val proximityBranchList = mutableListOf<FinanceBranch>()
        proximityBranchList.add(FinanceBranch("Proximity Finance Magway Branch\n" +
                "ဆက်သွယ်ရန်- 01 555 270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Kyaukse Branch\n" +
                "ဆက်သွယ်ရန်- 09 975 905169"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Mahlaing Branch\n" +
                "ဆက်သွယ်ရန်- 01 555 270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Myingyan Branch\n" +
                "ဆက်သွယ်ရန်- 09 964 555270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Aungban Branch\n" +
                "ဆက်သွယ်ရန်- 01 555 270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Pokokku Branch\n" +
                "ဆက်သွယ်ရန်- 01 555 270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Lawksawk Branch\n" +
                "ဆက်သွယ်ရန်- 09 964 555270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Taunggyi Branch\n" +
                "ဆက်သွယ်ရန်- 09 975 905167"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Dedaye Branch\n" +
                "ဆက်သွယ်ရန်- 01 555 270"))
        proximityBranchList.add(FinanceBranch("Proximity Finance Kungyangon Branch\n" +
                "ဆက်သွယ်ရန်- 01 555 270"))

        val lolcBranchList = mutableListOf<FinanceBranch>()

        financeInfoList.add(FinanceInfo("MAHA","မဟာ ဆိုတာ ...\n" +
                "\n" +
                "မဟာစိုက်ပျိုးရေးအသေးစားငွေရေးကုမ္ပဏီသည် မြန်မာအသေးစားငွေရေးကြေးရေးလုပ်ငန်းဥပဒေ (၂၀၁၁)အရ စုငွေလက်ခံသည့် အသေးစားငွေရေးကြေးရေးအဖွဲ့အစည်းတစ်ခုဖြစ်ပြီး မြန်မာကုမ္ပဏီများ အက်ဥပဒေအရ ၂၀၁၃ခုနှစ် ဧပြီလ ၂၉ရက်နေ့မှ စတင်ကာ လုပ်ငန်းစတင်လုပ်ကိုင်ခဲ့ပါသည်။ မဟာတွင် လုပ်ငန်းလည်ပတ်လျက်ရှိသော ရုံးခွဲပေါင်း(၃၂)ရုံးရှိပါသည်။ မဟာကို မြန်မာ့ဩဘာလုပ်ငန်းစုနှင့် အပြည်ပြည်ဆိုင်ရာ ဘဏ္ဍာရေးအဖွဲ့အစည် (IFC)တို့မှ ပူးတွဲပိုင်ဆိုင်ပါသည်။\n" +
                "\n" +
                "မျှော်မှန်းချက်\n" +
                "\n" +
                "ကျွန်တော်တို့၏ ကျေးလက်ဒေသရှိ အသင်းသားများ၊ လူမှုအသိုင်းအဝိုင်းများနှင့် သက်ဆိုင်သူများမှ ရွေးချယ်သော ငွေရေးကြေးရေးဝန်ဆောင်မှုပေးသည့် အဖွဲ့အစည်းဖြစ်စေရန်နှင့် စိုက်ပျိုးရေးကို အထူးပြုမှု၊ တီထွင်ဖန်တီးမှုနှင့် မင့်မားသော ကျင့်ဝတ်ပိုင်းဆိုင်ရာ စံနှုန်းများကို အသိအမှတ်ပြု ခံရစေရန်။\n" +
                "\n" +
                "ရည်မှန်းချက်\n" +
                "\n" +
                "မဟာသည် ဝန်ဆောင်မှုတိုင်းအတွက် တီထွင်ဖန်တီးမှုမြှင့်တင်ခြင်းနှင့်အတူ ကျေးလက်ငွေရေးကြေးရေး ဝန်ဆောင်မှုကို အားပြုဆောင်ရွက်သော တာဝန်သိ ငွေရေးကြေးရေးအဖွဲ့အစည်းတစ်ခုဖြစ်ရန် ရည်မှန်းသည်။ အသင်းသားများကို ဦးစားပေးပြီး ၎င်းတို့၏ အခက်အခဲများကို ဖြေရှင်းပေးနိုင်ရန် အမြဲကြိုးစားသည်။ မဟာသည် အသင်းသားများ ဘဝသာယာဝပြောစေရန်၊ မိတ်ဖက်များနှင့် တွဲဖက်လုပ်ကိုင်သူများ အောင်မြင်မှုရရှိစေရန် ယုံကြည်သည်။",mahaBranchList))
        financeInfoList.add(FinanceInfo("Proximity","Proximity Financeသည် မြန်မာနိုင်ငံရှိကျေးလက်နေမိသားစုများအတွက် ဝန်ဆောင်မှုပေးနိုင်ရန် ရည်ရွယ်ဦးတည်ထားသော လူမှုအကျိုးပြုစီးပွားလုပ်ငန်းတစ်ခုဖြစ်သည့် Proximity Design၏ အသေးစားချေးငွေ လုပ်ငန်းခွဲတစ်ခုဖြစ်သည်။\n" +
                "၂၀၁၂ ခုနှစ်တွင် Proximity Finance သည် တနိုင်တပိုင်စပါးစိုက်တောင်သူများအား၎င်းတို့လိုအပ်လျက်ရှိသော၊ပြန်ဆပ်နိုင်ရန်တတ်စွမ်းသော ချေးငွေပမာဏတို့ကို စတင်ချေးငှားခဲ့ပြီး ယနေ့တွင် သီးနှံချေးငွေ၊အသေးစားစီးပွားရေးလုပ်ငန်းချေးငွေ၊မွေးမြူရေးချေးငွေနှင့် ရွှေ့ပြောင်းချေးငွေတို့ကဲ့သို့သော ကျေးလက်နေအိမ်ထောင်စုများ၏ သီးသန့်လိုအပ်ချက်အလိုက် ချေးငွေအမျိုးအစားအမျိုးမျိုးတို့အား အတိုးနှုန်းနည်းနည်းနှင့်ချေးငှားပေးလျက်ရှိသည်။\n" +
                "အဆိုပါ ဆန်းသစ်သော ချေးငွေအမျိုးအစား လေးမျိုးသည် တောင်သူအိမ်ထောင်စုများနှင့်ကျေးလက်နေစွန့်ဦးတီထွင်စီးပွားရေးလုပ်ငန်းရှင်တို့အား ငွေကြေးလည်ပတ်မှု တည်ငြိမ်စေရန်၊အတိုးနှုန်းမြင့်မားသောချေးငွေရယူနေရခြင်းတို့မှ ကင်းဝင်းစေရန်နှင့်ပိုမိုကောင်းမွန်မြင့်မားသော ငွေကြေးဆိုင်ရာအခြေအနေတရပ်သို့ တက်လှမ်းနိုင်စေရန်အတွက် အထောက်အကူပြုပါသည်။\n" +
                "\n" +
                "Proximity Finance သည် ကျေးလက်ဒေသရှိရုံးခွဲများမှတဆင့် တောင်သူတို့၏ စိုက်ပျိုးချိန်၊ရိတ်သိမ်းချိန်များနှင့် ချိန်ကိုက်ပြီး ချေးငွေများထုတ်ချေးပေးလျက်ရှိသည်။လက်ရှိတွင် အိမ်ထောင်စုပေါင်း ၁၀၀,၀၀၀ကျော်တို့၏ ငွေကြေးလိုအပ်ချက်များကို ဖြည့်ဆည်းပေးလျက်ရှိပြီး နိုင်ငံတဝန်း ရုံးခွဲပေါင်း (၁၆)ရုံးဖွင့်လှစ်လျက် လုပ်ငန်းလည်ပတ်လျက်ရှိပါသည်။",proximityBranchList))
        financeInfoList.add(FinanceInfo("LOLC","",lolcBranchList))

        val finance = intent.getStringExtra("finance")
        when(finance){
            "maha" -> {
                tvFinanceCompanyName.text = "MAHA"
                tvAboutCompany.text = financeInfoList[0].aboutCompany
                setUpDataToAdapter(mahaBranchList)

            }

            "proximity" -> {
                tvFinanceCompanyName.text = "Proximity"
                tvAboutCompany.text = financeInfoList[1].aboutCompany
                setUpDataToAdapter(proximityBranchList)
            }

            "lolc" -> {
                tvFinanceCompanyName.text = "LOLC"
            }
        }
        val intent = Intent(this,AboutCompanyActivity::class.java)
        tvSeeMoreAboutCompany.setOnClickListener {
            when(finance){
                "maha" -> {
                    intent.putExtra("about",financeInfoList[0].aboutCompany)
                    intent.putExtra("company","MAHA")
                    startActivity(intent)
                }
                "proximity" -> {
                    intent.putExtra("about",financeInfoList[1].aboutCompany)
                    intent.putExtra("company","Proximity")
                    startActivity(intent)
                }
            }
        }
    }

    private fun setUpDataToAdapter(branchList : List<FinanceBranch>) {
        val adapter = FinanceBranchListAdapter(branchList)
        rvBranchList.layoutManager = LinearLayoutManager(this)
        rvBranchList.adapter = adapter
    }
}
