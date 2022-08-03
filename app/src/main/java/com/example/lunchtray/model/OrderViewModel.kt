package com.example.lunchtray.model


import android.os.Build.VERSION_CODES.P
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import javax.sql.DataSource

class OrderViewModel : ViewModel() {


    // Entree for the order
    private val _entree = MutableLiveData<String>()
    val entree: LiveData<String> = _entree

    // Side for the order
    private val _side = MutableLiveData<String>()
    val side: LiveData<String> = _side

    // Accompaniment for the order.
    private val _accompaniment = MutableLiveData<String>()
    val accompaniment: LiveData<String> = _accompaniment

    // Subtotal for the order
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Total cost of the order
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = Transformations.map(_total) {
        NumberFormat.getCurrencyInstance().format(it)
    }
    private var prevMainPrice = 0.0
    private var prevSidePrice = 0.0
    private var prevAccompPrice = 0.0
    var count = 0
    // Tax for the order


    /**
     * Set the entree for the order.
     */
    fun setEntree(entree: String, price: String) {
        _entree.value = entree
        updateSubtotal(price, 1)
    }

    /**
     * Set the side for the order.
     */
    fun setSide(side: String, price: String) {
        _side.value = side
        updateSubtotal(price, 2)
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String, price: String) {
        _accompaniment.value = accompaniment
        updateSubtotal(price, 3)
    }

    /**
     * Update subtotal value.
     */

    private fun updateSubtotal(itemPrice: String, order: Int) {
        _subtotal.value = (_subtotal.value)?.plus(itemPrice.toDouble())
        if (order == 1) {
            _subtotal.value = (_subtotal.value)?.minus(prevMainPrice)
        } else if (order == 2) {
            _subtotal.value = (_subtotal.value)?.minus(prevSidePrice)
        } else if (order == 3){
            _subtotal.value = (_subtotal.value)?.minus(prevAccompPrice)
        }
        if (order == 1) {
            prevMainPrice = itemPrice.toDouble()
        } else if (order == 2) {
            prevSidePrice = itemPrice.toDouble()
        } else if (order == 3){
            prevAccompPrice = itemPrice.toDouble()
        }
        count++
    }


    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        // TODO: set _tax.value based on the subtotal and the tax rate.
        // TODO: set the total based on the subtotal and _tax.value.
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        _entree.value = ""
        _side.value = ""
        _accompaniment.value = ""
        _subtotal.value = 0.0
        count = 0
        prevMainPrice = 0.0
        prevSidePrice = 0.0
        prevAccompPrice = 0.0

    }
}