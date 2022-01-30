package elnura.kotlin.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

fun ImageView.loadRandom(images: ArrayList<String>) {
    val randomNum = Random.nextInt(0, images.size)
    Glide.with(this).
        load(images[randomNum]).
        circleCrop().
        into(this)
}