package ir.dunijet.wikipedia

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity:FragmentActivity,private val fragments:List<Fragment>):FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
//        when(position){
//            0->{
//                return FragmentExplore()
//            }
//            1->{
//                return FragmentTrend()
//            }
//            2->{
//                return FragmentProfile()
//            }
//            else->{
//               return Fragment()
//            }
//        }
       return fragments.get(position)


    }


}