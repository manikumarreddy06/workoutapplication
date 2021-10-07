import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.myproject.myapplication.R
import com.myproject.myapplication.exercisemodel



class exerciseadapter(val context: Context, val items:ArrayList<exercisemodel>):RecyclerView.Adapter<exerciseadapter.ViewHolder>() {


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var tvitem: TextView = itemview.findViewById(R.id.tvitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise_status, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: exercisemodel = items[position]

        holder.tvitem.text = model.getid().toString()
        if (model.getisselected()) {
            holder.tvitem.background =
                ContextCompat.getDrawable(context, R.drawable.thin_colre_display_border)
            holder.tvitem.setTextColor(Color.parseColor("#212121"))
        }
        else if (model.getiscompleted()){
            holder.tvitem.background=
                ContextCompat.getDrawable(context,R.drawable.item_circular_color_accent_background)
            holder.tvitem.setTextColor(Color.parseColor("#FFFFFF"))
        }else {
            holder.tvitem.background=
                ContextCompat.getDrawable(context,R.drawable.item_circular_grey)
            holder.tvitem.setTextColor(Color.parseColor("#212121"))
        }

    }
        override fun getItemCount(): Int {
            return items.size

    }
}


