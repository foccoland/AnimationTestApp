package it.italiaonline.animationtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import com.plattysoft.leonids.ParticleSystem
import it.italiaonline.animationtestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = LayoutInflater.from(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.root.doOnPreDraw {
            ParticleSystem(this, 80, R.drawable.piano, 10000)
                .setScaleRange(0.2f, 0.2f)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                .setRotationSpeed(144F)
                .setAcceleration(0.00003f, 90)
                .emit(findViewById(R.id.piano_emitter_right), 4);

            ParticleSystem(this, 80, R.drawable.sound_wave, 10000)
                .setScaleRange(0.2f, 0.2f)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144F)
                .setAcceleration(0.00003f, 90)
                .emit(findViewById(R.id.piano_emitter_left), 4);
        }
    }
}