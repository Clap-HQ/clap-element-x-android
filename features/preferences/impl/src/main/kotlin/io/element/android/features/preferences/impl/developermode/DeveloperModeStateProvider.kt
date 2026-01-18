/*
 * Copyright (c) 2025 Element Creations Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.developermode

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class DeveloperModeStateProvider : PreviewParameterProvider<DeveloperModeState> {
    override val values: Sequence<DeveloperModeState>
        get() = sequenceOf(
            aDeveloperModeState(),
            aDeveloperModeState(
                showCustomHomeserver = true,
                showQRCodeLogin = true,
                groupSpaceRooms = false,
                spaceSettingsEnabled = false,
                showDeveloperSettings = true,
            ),
        )
}

fun aDeveloperModeState(
    showCustomHomeserver: Boolean = false,
    showQRCodeLogin: Boolean = false,
    groupSpaceRooms: Boolean = true,
    spaceSettingsEnabled: Boolean = true,
    showDeveloperSettings: Boolean = false,
    eventSink: (DeveloperModeEvents) -> Unit = {},
) = DeveloperModeState(
    showCustomHomeserver = showCustomHomeserver,
    showQRCodeLogin = showQRCodeLogin,
    groupSpaceRooms = groupSpaceRooms,
    spaceSettingsEnabled = spaceSettingsEnabled,
    showDeveloperSettings = showDeveloperSettings,
    eventSink = eventSink,
)
