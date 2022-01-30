package elnura.kotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import elnura.kotlin.databinding.ActivityMainBinding
import elnura.kotlin.extension.loadRandom
import elnura.kotlin.extension.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val images = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val url = binding.etUrl.text.toString()
            if (url.isEmpty()) {
                showToast(getString(R.string.et_input))
            }else {
                if (Patterns.WEB_URL.matcher(url).matches()) {
                    images.add(url)
                    binding.etUrl.text.clear()
                    showToast(getString(R.string.et_submitted))
                } else {
                    showToast(getString(R.string.wrong_format))
                }
            }
        }

        binding.btnRandom.setOnClickListener {
            binding.ivRandom.loadRandom(images)
        }



    }
}