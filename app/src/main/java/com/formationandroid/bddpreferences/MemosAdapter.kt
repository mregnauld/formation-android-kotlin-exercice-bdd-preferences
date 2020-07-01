package com.formationandroid.bddpreferences

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.formationandroid.bddpreferences.MemosAdapter.MemoViewHolder
import com.formationandroid.bddpreferences.bdd.MemoDTO

class MemosAdapter(private var listeMemoDTO: MutableList<MemoDTO>) : RecyclerView.Adapter<MemoViewHolder>()
{

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder
	{
		val viewMemo = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
		return MemoViewHolder(viewMemo)
	}

	override fun onBindViewHolder(holder: MemoViewHolder, position: Int)
	{
		holder.textViewIntitule.text = listeMemoDTO[position].intitule
	}

	override fun getItemCount(): Int
	{
		return listeMemoDTO.size
	}

	/**
	 * Mise à jour de la liste.
	 * @param listeMemoDTO: MutableList<MemoDTO>
	 */
	fun updateMemos(listeMemoDTO: MutableList<MemoDTO>)
	{
		this.listeMemoDTO = listeMemoDTO
		notifyDataSetChanged()
	}

	/**
	 * ViewHolder.
	 */
	inner class MemoViewHolder(itemView: View) : ViewHolder(itemView)
	{

		// Vue intitulé mémo :
		var textViewIntitule: TextView = itemView.findViewById(R.id.memo_intitule)


        /**
		 * Constructeur.
		 */
		init
		{
            // listener :
			itemView.setOnClickListener {

				// enregistrement de la position du dernier item cliqué :
				val preferences = PreferenceManager.getDefaultSharedPreferences(itemView.context)
				val editor = preferences.edit()
				editor.putInt(MainActivity.CLE_DERNIERE_POSITION, adapterPosition)
				editor.apply()
			}
		}
	}

}