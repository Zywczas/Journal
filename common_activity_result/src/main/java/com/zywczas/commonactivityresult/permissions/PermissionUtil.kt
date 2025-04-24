package com.zywczas.commonactivityresult.permissions

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object PermissionUtil {

    fun isGranted(permission: Permission, context: Context) =
        ContextCompat.checkSelfPermission(context, permission.value) == PackageManager.PERMISSION_GRANTED
}
