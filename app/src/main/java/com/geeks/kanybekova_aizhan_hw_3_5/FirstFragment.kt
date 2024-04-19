package com.geeks.kanybekova_aizhan_hw_3_5
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FirstFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var count = 0
    private var isIncrementing = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        textView = view.findViewById(R.id.tvCounter)
        button = view.findViewById(R.id.transformBtn)

        button.setOnClickListener {
            if (isIncrementing) {
                count++
                if (count >= 10) {
                    isIncrementing = false
                    button.text = "-1"
                }
            } else {
                count--
                if (count <= 0) {
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.fragment_container, SecondFragment())
                        commit()
                    }
                }
            }
            updateCounterTextView()
        }

        updateCounterTextView()

        return view
    }

    private fun updateCounterTextView() {
        textView.text = count.toString()
    }
}