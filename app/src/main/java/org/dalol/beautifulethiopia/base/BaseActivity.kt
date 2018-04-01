package org.dalol.beautifulethiopia.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Thursday, 15/03/2018 at 14:17.
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
