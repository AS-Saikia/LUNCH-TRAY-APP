package com.example.lunchtray.DATA

import com.example.lunchtray.R
import com.example.lunchtray.model.item
import com.example.lunchtray.model.item_accomp

class datasource {
    fun loadInfoMain(): List<item> {
        return listOf<item>(
            item(R.string.MainDish, R.string.MainDishDes, R.string.MainDishPrice, R.drawable.m1),
            item(R.string.MainDish2, R.string.MainDishDes2, R.string.MainDishPrice2, R.drawable.m2),
            item(R.string.MainDish3, R.string.MainDishDes3, R.string.MainDishPrice3, R.drawable.m3),
            item(R.string.MainDish4, R.string.MainDishDes4, R.string.MainDishPrice4, R.drawable.m4),
            item(R.string.MainDish5, R.string.MainDishDes5, R.string.MainDishPrice5, R.drawable.m5),
            item(R.string.MainDish6, R.string.MainDishDes6, R.string.MainDishPrice6, R.drawable.m6),
            item(R.string.MainDish7, R.string.MainDishDes7, R.string.MainDishPrice7, R.drawable.m7)
        )
    }

    fun loadInfoSide(): List<item> {
        return listOf<item>(
            item(R.string.SideDish, R.string.SideDishDes, R.string.SideDishPrice, R.drawable.s1),
            item(R.string.SideDish2, R.string.SideDishDes2, R.string.SideDishPrice2, R.drawable.s2),
            item(R.string.SideDish3, R.string.SideDishDes3, R.string.SideDishPrice3, R.drawable.s3),
            item(R.string.SideDish4, R.string.SideDishDes4, R.string.SideDishPrice4, R.drawable.s4),
            item(R.string.SideDish5, R.string.SideDishDes5, R.string.SideDishPrice5, R.drawable.s5),
            item(R.string.SideDish6, R.string.SideDishDes6, R.string.SideDishPrice6, R.drawable.s6),
            item(R.string.SideDish7, R.string.SideDishDes7, R.string.SideDishPrice7, R.drawable.s7),
            item(R.string.SideDish8, R.string.SideDishDes8, R.string.SideDishPrice8, R.drawable.s8),
        )
    }

    fun loadInfoAccompaniment(): List<item_accomp> {
        return listOf<item_accomp>(
            item_accomp(R.string.AccompDish, R.string.AccompDishPrice, R.drawable.a1),
            item_accomp(R.string.AccompDish2, R.string.AccompDishPrice2, R.drawable.a2),
            item_accomp(R.string.AccompDish3, R.string.AccompDishPrice3, R.drawable.a3),
            item_accomp(R.string.AccompDish4, R.string.AccompDishPrice4, R.drawable.a4),
            item_accomp(R.string.AccompDish5, R.string.AccompDishPrice5, R.drawable.a5),
            item_accomp(R.string.AccompDish6, R.string.AccompDishPrice6, R.drawable.a6),
            item_accomp(R.string.AccompDish7, R.string.AccompDishPrice7, R.drawable.a7),
            item_accomp(R.string.AccompDish8, R.string.AccompDishPrice8, R.drawable.a8),
            item_accomp(R.string.AccompDish9, R.string.AccompDishPrice9, R.drawable.a9),




        )
    }
}