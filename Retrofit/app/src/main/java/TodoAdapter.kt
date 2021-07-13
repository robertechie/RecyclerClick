import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinyit.retrofit.TodoModel
import com.tinyit.retrofit.databinding.TodoItemBinding

class TodoAdapter(var listitem:List<TodoModel>):RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    inner class ViewHolder(var binding:TodoItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(todomodel: TodoModel){
            binding.todoItem.text = todomodel.title
            if(todomodel.completed){
                binding.imageView.visibility = View.VISIBLE
            }else{
                binding.imageView.visibility = View.GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:TodoItemBinding = TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listitem.get(position))
    }

    override fun getItemCount(): Int {
        return listitem.size
    }
}