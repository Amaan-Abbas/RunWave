package com.example.runWave.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.runWave.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    userPath: List<LatLng>,
    currentLocation: LatLng? = null
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation ?: LatLng(0.0, 0.0), 16f)
    }

    val context = LocalContext.current

    // Apply dark map style JSON
    val mapProperties = remember(context) {
        MapProperties(
            mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.dark_map_style)
        )
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = mapProperties,
        uiSettings = MapUiSettings(zoomControlsEnabled = true)
    ) {
        // Render current route path
        if (userPath.isNotEmpty()) {
            Polyline(
                points = userPath,
                color = Color(0xFF3B82F6), // Bright blue route highlight
                width = 12f
            )
        }

        // Current location dot
        currentLocation?.let {
            Marker(
                state = MarkerState(position = it),
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
            )
        }
    }
}

@Preview
@Composable
private fun MapScreenPreview() {
    val coordinates = listOf(
        LatLng(37.7749, -122.4194),
    )
    MapScreen(userPath = coordinates)
}

