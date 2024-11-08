package com.tracking.displayrewards.services.location

import android.app.Activity
import android.content.Context
import com.tracking.displayrewards.services.location.model.LocationInfo
import com.tracking.displayrewards.services.location.model.PermissionStatus

interface LocationManager {
    fun requestLocationPermissions(activity: Activity)
    fun checkPermissions(context: Context): PermissionStatus
    fun getCoarseLocation(
        context: Context,
        listener: (LocationInfo?) -> Unit
    )
}
