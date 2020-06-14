package com.roomdbexample.dohtaungthu.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

import com.roomdbexample.dohtaungthu.R
import com.roomdbexample.dohtaungthu.ui.utils.bitmapDescriptorFromVector
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    lateinit var latLng  : LatLng

    companion object{
        fun newInstance() = MapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latLng = LatLng(16.7908254, 96.1321403)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        mapFragment.tvMapType.setOnClickListener {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
        }
        mapFragment.tvSatelliteType.setOnClickListener {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
        }
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!

        map.uiSettings.isZoomControlsEnabled = true //appear in the bottom right hand corner
        map.uiSettings.isZoomGesturesEnabled = true // decrease the zoom level by 1
        map.uiSettings.isCompassEnabled      = true // set compass

        map.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        val zoomLevel = 16.5F
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        map.addMarker(MarkerOptions()
            .position(latLng)
            .title("Orchid Condo")
            .icon(bitmapDescriptorFromVector(
            context!!,R.drawable.ic_marker)).snippet("Ahlone Township"))

        //custom info window
        map.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoWindow(marker : Marker): View? {
                return null
            }

            override fun getInfoContents(marker : Marker): View? {
                val view = LayoutInflater.from(activity).inflate(R.layout.custom_map_info_window,null)
                view.findViewById<TextView>(R.id.tvBranchName).text = marker.title
                view.findViewById<TextView>(R.id.tvAddress).text    = marker.snippet

                view.findViewById<AppCompatImageButton>(R.id.closeMapInfoViewButton).setOnClickListener {
                    marker.hideInfoWindow()
                }
                return view
            }
        })
    }
}
