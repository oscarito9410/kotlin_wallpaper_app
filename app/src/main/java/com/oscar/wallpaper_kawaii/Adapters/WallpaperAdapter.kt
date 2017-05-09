package com.oscar.wallpaper_kawaii.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.oscar.wallpaper_kawaii.Model.Wallpaper
import com.oscar.wallpaper_kawaii.R

class WallpaperAdapter(context: Context,list:MutableList<Wallpaper>): BaseAdapter(){
    private var mInflator: LayoutInflater?=null;
    private var listMutable: MutableList<Wallpaper>?=null;

    init {
                mInflator= LayoutInflater.from(context);
                listMutable=list;
    }

    override fun getCount(): Int {
        return listMutable!!.size;
    }

    override fun getItem(position: Int): Any {
        return listMutable!!.get(position);
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return  convertView!!;
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private class ListRowHolder(row: View?) {
        var imageWallPaper: ImageView?=null;
        init {
            this.imageWallPaper = row?.findViewById(R.id.imageWallpaperItem) as ImageView;
        }
    }

}