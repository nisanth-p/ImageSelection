package com.neltech.renthouse.view.base.genericadapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.neltech.renthouse.R
import com.neltech.renthouse.databinding.FragmentHomeBinding
import com.neltech.renthouse.model.data.ImageSelect


private const val TAG = "yyyJavaViewHolderFactory"

object JavaViewHolderFactory {

    fun create(_viewBinding: ViewBinding?, view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.fragment_home -> {
                Log.d(TAG, "create: --->> R.layout.selection_room_list || RoomViewHolder()")
                SelectedRoomDeviceViewHolder(_viewBinding as FragmentHomeBinding?,view)
            }

            else -> {
                SelectedRoomDeviceViewHolder(_viewBinding as FragmentHomeBinding?,view)
            }
        }
    }


    // TODO: 30-12-2021 Room Selection

    class SelectedRoomDeviceViewHolder(viewBinding: FragmentHomeBinding?, itemView: View) :
        RecyclerView.ViewHolder(itemView),
        GenericAdapter.Binder<ImageSelect> {

        override fun bind(
            viewHolder: RecyclerView.ViewHolder,
            data: ImageSelect,
            list: List<ImageSelect>
        ) {
            //  viewHolder as GenericAdapter.Binder<*>

            val index = viewHolder.absoluteAdapterPosition

        }


    }



    private var onItemClickListenerFactory: ((data: Any, list: List<*>, isLiked: Boolean, viewId: Int, position: Int, _viewBinding: ViewBinding?) -> Unit)? =
        null

    fun setOnItemClickListenerFactory(listener: (data: Any, list: List<*>, isLiked: Boolean, viewId: Int, position: Int, _viewBinding: ViewBinding?) -> Unit) {
        onItemClickListenerFactory = listener
    }

    private var onDeviceItemClickListenerFactory: ((data: Any, list: List<*>, isLiked: Boolean, viewId: Int, position: Int, _viewBinding: ViewBinding?) -> Unit)? =
        null

    fun setOnDeviceItemClickListenerFactory(listener: (data: Any, list: List<*>, isLiked: Boolean, viewId: Int, position: Int, _viewBinding: ViewBinding?) -> Unit) {
        onDeviceItemClickListenerFactory = listener
    }

    private var onContainerClickListenerFactory: ((_viewBinding: ViewBinding?, data: Any, list: List<*>) -> Unit)? =
        null

    fun setOnContainerClickListenerFactory(listener: (_viewBinding: ViewBinding?, data: Any, list: List<*>) -> Unit) {
        onContainerClickListenerFactory = listener
    }


}