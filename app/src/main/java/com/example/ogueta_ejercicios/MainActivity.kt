package com.example.ogueta_ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.ogueta_ejercicios.ui.theme.OguetaEjerciciosTheme

import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OguetaEjerciciosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "ogueta-mainmenu") {
                        composable("ogueta-mainmenu") { MainMenu(navController) }
                        composable("ogueta-project5"){ Project5(navController) }
                        composable("ogueta-project6") { Project6(navController) }
                        composable("ogueta-project7"){ Project7(navController) }
                        composable("ogueta-project8"){ Project8(navController) }
                        composable("ogueta-project9"){ Project9(navController) }
                        composable("ogueta-project10"){ Project10(navController) }
                        composable("ogueta-project11") { Project11(navController) }
                        composable("ogueta-project12"){ Project12(navController) }
                        composable("ogueta-project13"){ Project13(navController) }
                        composable("ogueta-project14"){ Project14(navController) }
                        composable("ogueta-project15"){ Project15(navController) }
                        composable("ogueta-project16") { Project16(navController) }
                        composable("ogueta-project17"){ Project17(navController) }
                        composable("ogueta-project18"){ Project18(navController) }
                        composable("ogueta-project19"){ Project19(navController) }
                        composable("ogueta-project20"){ Project20(navController) }
                        composable("ogueta-project21") { Project21(navController) }
                        composable("ogueta-project22"){ Project22(navController) }
                        composable("ogueta-project23"){ Project23(navController) }
                        composable("ogueta-project24"){ Project24(navController) }
                        composable("ogueta-project25"){ Project25(navController) }
                        composable("ogueta-project26") { Project26(navController) }
                        composable("ogueta-project27"){ Project27(navController) }
                        composable("ogueta-project28"){ Project28(navController) }
                        composable("ogueta-project29"){ Project29(navController) }
                        composable("ogueta-project30"){ Project30(navController) }
                        composable("ogueta-project31") { Project31(navController) }
                        composable("ogueta-project32"){ Project32(navController) }
                        composable("ogueta-project33"){ Project33(navController) }
                        composable("ogueta-project34"){ Project34(navController) }
                        composable("ogueta-project35"){ Project35(navController) }
                        composable("ogueta-project36") { Project36(navController) }
                        composable("ogueta-project37"){ Project37(navController) }
                        composable("ogueta-project38"){ Project38(navController) }
                        composable("ogueta-project39"){ Project39(navController) }
                        composable("ogueta-project40"){ Project40(navController) }
                        composable("ogueta-project41") { Project41(navController) }
                        composable("ogueta-project42"){ Project42(navController) }
                        composable("ogueta-project43"){ Project43(navController) }
                        composable("ogueta-project44"){ Project44(navController) }
                        composable("ogueta-project45"){ Project45(navController) }
                        composable("ogueta-project46") { Project46(navController) }
                        composable("ogueta-project47"){ Project47(navController) }
                        composable("ogueta-project48"){ Project48(navController) }
                        composable("ogueta-project49"){ Project49(navController) }
                        composable("ogueta-project50"){ Project50(navController) }
                        composable("ogueta-project51") { Project51(navController) }
                        composable("ogueta-project52"){ Project52(navController) }
                        composable("ogueta-project53"){ Project53(navController) }
                        composable("ogueta-project54"){ Project54(navController) }
                        composable("ogueta-project55"){ Project55(navController) }
                        composable("ogueta-project56") { Project56(navController) }
                        composable("ogueta-project57"){ Project57(navController) }
                        composable("ogueta-project58"){ Project58(navController) }
                        composable("ogueta-project59"){ Project59(navController) }
                        composable("ogueta-project60"){ Project60(navController) }
                        composable("ogueta-project61") { Project61(navController) }
                        composable("ogueta-project62"){ Project62(navController) }
                        composable("ogueta-project63"){ Project63(navController) }
                        composable("ogueta-project64"){ Project64(navController) }
                        composable("ogueta-project65"){ Project65(navController) }
                        composable("ogueta-project66") { Project66(navController) }
                        composable("ogueta-project67"){ Project67(navController) }
                        composable("ogueta-project68"){ Project68(navController) }
                        composable("ogueta-project69"){ Project69(navController) }
                        composable("ogueta-project70"){ Project70(navController) }
                        composable("ogueta-project71") { Project71(navController) }
                        composable("ogueta-project72"){ Project72(navController) }
                        composable("ogueta-project73"){ Project73(navController) }
                        composable("ogueta-project77"){ Project77(navController) }
                        composable("ogueta-project78"){ Project78(navController) }
                        composable("ogueta-project82"){ Project82(navController) }
                        composable("ogueta-project83"){ Project83(navController) }
                        composable("ogueta-project84"){ Project84(navController) }
                        composable("ogueta-project88"){ Project88(navController) }
                        composable("ogueta-project89"){ Project89(navController) }
                        composable("ogueta-project90"){ Project90(navController) }
                        composable("ogueta-project91"){ Project91(navController) }
                        composable("ogueta-project93"){ Project93(navController) }
                        composable("ogueta-project95"){ Project95(navController) }
                        composable("ogueta-project97"){ Project97(navController) }
                        composable("ogueta-project103"){ Project103(navController) }
                        composable("ogueta-project104"){ Project104(navController) }
                        composable("ogueta-project107"){ Project107(navController) }
                        composable("ogueta-project108"){ Project108(navController) }
                        composable("ogueta-project111"){ Project111(navController) }
                        composable("ogueta-project115"){ Project115(navController) }
                        composable("ogueta-project116"){ Project116(navController) }
                        composable("ogueta-project118"){ Project118(navController) }
                        composable("ogueta-project121"){ Project121(navController) }
                        composable("ogueta-project124"){ Project124(navController) }
                        composable("ogueta-project126"){ Project126(navController) }
                        composable("ogueta-project127"){ Project127(navController) }
                        composable("ogueta-project130"){ Project130(navController) }
                        composable("ogueta-project133"){ Project133(navController) }
                        composable("ogueta-project136"){ Project136(navController) }
                        composable("ogueta-project139"){ Project139(navController) }
                        composable("ogueta-project141"){ Project141(navController) }
                        composable("ogueta-project142"){ Project142(navController) }
                        composable("ogueta-project143"){ Project143(navController) }
                        composable("ogueta-project145"){ Project145(navController) }
                        composable("ogueta-project146"){ Project146(navController) }
                        composable("ogueta-project147"){ Project147(navController) }
                        composable("ogueta-project148"){ Project148(navController) }
                        composable("ogueta-project149"){ Project149(navController) }
                        composable("ogueta-project151"){ Project151(navController) }
                        composable("ogueta-project153"){ Project153(navController) }
                        composable("ogueta-project157"){ Project157(navController) }
                        composable("ogueta-project160"){ Project160(navController) }
                        composable("ogueta-project161"){ Project161(navController) }
                        composable("ogueta-project168"){ Project168(navController) }
                        composable("ogueta-project169"){ Project169(navController) }
                        composable("ogueta-project172"){ Project172(navController) }
                        composable("ogueta-project178"){ Project178(navController) }
                        composable("ogueta-project179"){ Project179(navController) }
                        composable("ogueta-project180"){ Project180(navController) }
                        composable("ogueta-project186"){ Project186(navController) }
                        composable("ogueta-project189"){ Project189(navController) }
                        composable("ogueta-project191"){ Project191(navController) }

                    }
                }
            }
        }
    }
}







