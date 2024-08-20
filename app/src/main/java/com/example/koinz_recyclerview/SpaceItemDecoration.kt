import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
class CenteredSpacingItemDecoration(private val spacing: Int, private val spanCount: Int) : RecyclerView.ItemDecoration() {override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
    super.getItemOffsets(outRect, view, parent, state)
    val position = parent.getChildAdapterPosition(view)
    val column = position % spanCount
    val totalItemCount = parent.adapter?.itemCount ?: 0
    val itemsInRow = if (position + spanCount < totalItemCount) spanCount else totalItemCount % spanCount
    val itemSpacing = if (itemsInRow == 1) {
        spacing
    } else {
        spacing / (spanCount - 1)
    }
    outRect.left = spacing - column * itemSpacing
    outRect.right = (column + 1) * itemSpacing - spacing
    outRect.top = spacing
    outRect.bottom = spacing
}
}