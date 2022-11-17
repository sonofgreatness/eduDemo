package com.example.edudemo.ui.Invite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.edudemo.databinding.FragmentInviteBinding


class InviteFragment : Fragment() {
private lateinit var  _binding:FragmentInviteBinding
val  binding get() =  _binding
lateinit  var rootView : View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInviteBinding.inflate(inflater,container,false)
        rootView = binding.root
        binding.inviteButton.setOnClickListener({
            setUpShareButtonAction()
        })
        return (rootView)
    }

    private fun setUpShareButtonAction() {
        // start share intent to share link project's github repo
        val share = Intent(Intent.ACTION_SEND)
        share.type = "text/plain"
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)

        // Add data to the intent, the receiving app will decide
        // what to do with it.

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "edu Demo repo ")
        share.putExtra(Intent.EXTRA_TEXT, "https://github.com/sonofgreatness/eduDemo.git")

        startActivity(Intent.createChooser(share, "Share link!"))
    }


}