package ir.dunijet.wikipedia

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.snackbar.Snackbar
import ir.dunijet.exploreinstagram.NetworkChecker
import ir.dunijet.wikipedia.databinding.ActivityMainBinding
import ir.dunijet.wikipedia.databinding.DialogLoginBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
  //  lateinit var networkChecker: NetworkChecker
    lateinit var sharedpref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedpref=getSharedPreferences("data2",Context.MODE_PRIVATE)

        setSupportActionBar(binding.toolbar)


        val actionbarDrawerToggl=ActionBarDrawerToggle(this,binding.drawerMain,binding.toolbar,R.string.open,R.string.close)
        binding.drawerMain.addDrawerListener(actionbarDrawerToggl)
        actionbarDrawerToggl.syncState()
        binding.NavMain.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.game->{
                   binding.drawerMain.closeDrawer(GravityCompat.START)
                    val  intent=Intent(this,MainActivityanim::class.java)
                    startActivity(intent)

                }
                R.id.translator->{


                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.add(R.id.Frame_container_Main,FragmentTranslate())
                    transaction.commit()



                }
                R.id.photographer->{
                    binding.drawerMain.closeDrawer(GravityCompat.START)


                }
                R.id.visit->{
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    val dialog=SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE)
                    dialog.titleText="هشدار"
                    dialog.confirmText="روشن کردم"
                    dialog.cancelText="بیخیال"
                    dialog.contentText="لطفا وایفای خود را روشن کنید!"
                    dialog.show()
                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        val wifi:Boolean=NetworkChecker(this).isWifiConnected
                        if (wifi==true) {
                            val url = "https://www.wikipedia.org/"
                            val i = Intent(Intent.ACTION_VIEW)
                            i.data = Uri.parse(url)
                            startActivity(i)

                        }else{
                            Toast.makeText(this, "خودتو گول بزن:)", Toast.LENGTH_SHORT).show()
                        }

                    }


                }
                R.id.visit2->{
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    val dialog=SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE)
                    dialog.titleText="هشدار"
                    dialog.confirmText="خاموش کردم"
                    dialog.cancelText="بیخیال"
                    dialog.contentText="لطفا فیلترشکن خود را خاموش کنید!"
                    dialog.show()

                    dialog.setConfirmClickListener {
                        val isvpnconnected = Vpnchecker.NetworkUtils.isVpnConnected(this)
                        if (isvpnconnected) {
                            Toast.makeText(this, "خودتو گول بزن:)", Toast.LENGTH_SHORT).show()


                        }
                        else  {
                            Toast.makeText(this, "vpn is off", Toast.LENGTH_SHORT).show()
                            val url = "https://www.wikipedia.org/"
                            val i = Intent(Intent.ACTION_VIEW)
                            i.data = Uri.parse(url)
                            startActivity(i)

                        }
                    }
                        dialog.setCancelClickListener {
                            dialog.dismiss()
                        }



                }
                R.id.writer->{
                    binding.drawerMain.closeDrawer(GravityCompat.START)


                }


            }
            true
        }
        //firstRun()
        val list= mutableListOf<Fragment>()
        list.add(FragmentExplore())
        list.add(FragmentTrend())
        list.add(FragmentProfile())

        binding.ViewPager2.adapter=ViewPagerAdapter(this@MainActivity,list)


        binding.botNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.MenuExplore->{
                    binding.ViewPager2.currentItem=0
                    replaceFragment(FragmentExplore())


                }
                R.id.Profile->{
                    binding.ViewPager2.currentItem=2

                    replaceFragment(FragmentProfile())


                }
                R.id.trend->{
                    binding.ViewPager2.currentItem=1

                    replaceFragment(FragmentTrend())


                }



            }
            true
        }
        binding.ViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when(position){
                    0->binding.botNav.menu.findItem(R.id.MenuExplore).setChecked(true)
                    1->binding.botNav.menu.findItem(R.id.trend).setChecked(true)
                   2->binding.botNav.menu.findItem(R.id.Profile).setChecked(true)

                }
            }


        })
        binding.botNav.setOnItemReselectedListener {

        }

    }
    fun replaceFragment(fragment:Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.Frame_container_Main,fragment)
        transaction.commit()

    }
//    fun firstRun(){
//        replaceFragment(FragmentExplore())
//        binding.botNav.selectedItemId=R.id.MenuExplore
//    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.bala_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit->{
                val dialog=SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                dialog.titleText="Allert!"
                dialog.confirmText="Confirm"
                dialog.cancelText="Cancel"
                dialog.contentText="Are you sure that you want to Exit?"
                dialog.show()
                dialog.setCancelClickListener {
                    dialog.dismiss()
                }
                dialog.setConfirmClickListener {
                    finishAffinity()
                }



            }
            R.id.login-> {

                val dialog = AlertDialog.Builder(this).create()
                val dialogbindinglogin = DialogLoginBinding.inflate(layoutInflater)
                dialog.setView(dialogbindinglogin.root)
                dialog.show()
                dialogbindinglogin.btnCancel.setOnClickListener {
                    dialog.dismiss()

                }

                dialogbindinglogin.btnConfirm.setOnClickListener {
                    val username = dialogbindinglogin.edtUsername.text.toString()
                    val pass = dialogbindinglogin.edtPass.text.toString()
                        if (username == "Mahsa" && pass == "1371") {
                            sharedpref.edit().putString("data2", username).apply()
                            sharedpref.edit().putString("data3", pass).apply()
                            Toast.makeText(this, "خوش آمدید", Toast.LENGTH_SHORT).show()
                            dialog.dismiss()


                        }
                        else {
                            Toast.makeText(this, "طلاعات وارد شده اشتباه است", Toast.LENGTH_SHORT).show()
                            dialog.dismiss()

                        }

                    }


                }

            R.id.search->{

            }
        }


        return true
    }
        }

