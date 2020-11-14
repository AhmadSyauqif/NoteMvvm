package com.pesan.note.ui.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pesan.note.R
import com.pesan.note.model.TodoData
import com.pesan.note.viewmodel.ShareViewModel
import com.pesan.note.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_add.edt_description
import kotlinx.android.synthetic.main.fragment_add.edt_title
import kotlinx.android.synthetic.main.fragment_add.spiner_prioritis
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private val todoViewModel: TodoViewModel by viewModels()
    private val shareViewModel: ShareViewModel by viewModels()
    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_add, container, false)
        setHasOptionsMenu(true)


        view.spiner_prioritis.onItemSelectedListener = shareViewModel.listener
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.add_fragment_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add){
            insertDatadb()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDatadb() {
        val mTitle = edt_title.text.toString()
        val mPriority = spiner_prioritis.selectedItem.toString()
        val mDescription = edt_description.text.toString()

        val validation = shareViewModel.verifyDataFromUSER(mTitle, mDescription)
        if (validation){
        val newData = TodoData(
                0,
                mTitle,
                shareViewModel.parsePriority(mPriority),
                mDescription

        )
            todoViewModel.insertData(newData)
            Toast.makeText(requireContext(),"Data Berhasil Dibua", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }
    }
}