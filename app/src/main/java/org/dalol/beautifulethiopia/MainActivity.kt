package org.dalol.beautifulethiopia

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import org.dalol.beautifulethiopia.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar.apply {
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
            actionBar?.setHomeAsUpIndicator(R.mipmap.ic_logo)
        }

        category_list.setHasFixedSize(true)
        category_list.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        category_list.addItemDecoration(object : RecyclerView.ItemDecoration(){

            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                super.getItemOffsets(outRect, view, parent, state)

                val lm = parent.layoutManager as StaggeredGridLayoutManager
                val lp = view.layoutParams as StaggeredGridLayoutManager.LayoutParams

                val spanCount = lm.spanCount
                val spanIndex = lp.spanIndex
                val position = parent.getChildAdapterPosition(view)

                if (spanIndex == 0) {
                    // left edge
                    // should write left border
                    outRect.left = 48
                }

                if (position < spanCount) {
                    // first row
                    // should write top border
                    outRect.top = 48
                }

                outRect.right = 48
                outRect.bottom = 48
            }
        })
        //category_list.layoutManager = GridLayoutManager(this, 3)
        category_list.adapter = CategoryAdapter()

        //mytext.
    }

    inner class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryViewHolder {
            return CategoryViewHolder(layoutInflater.inflate(R.layout.item_category_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return 65
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        }

        inner class CategoryViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }
    }
}
