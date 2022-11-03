package com.example.midasandroid2.main.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color

@Stable
fun Modifier.btnClickable(
    rippleEnabled: Boolean = true,
    rippleColor: Color? = null,
    runIf: Boolean = true,
    onClick: (() -> Unit)?,
) = runIf(onClick != null && runIf) {
    composed {
        clickable(
            onClick = onClick!!,
            indication = rememberRipple(
                color = rippleColor ?: Color.Unspecified,
            ).takeIf {
                rippleEnabled
            },
            interactionSource = remember { MutableInteractionSource() },
        )
    }
}

internal inline fun <T> T.runIf(condition: Boolean, run: T.() -> T) = if (condition) {
    run()
} else this