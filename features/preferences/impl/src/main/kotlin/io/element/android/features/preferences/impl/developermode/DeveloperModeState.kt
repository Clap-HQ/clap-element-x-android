/*
 * Copyright (c) 2025 Element Creations Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.developermode

data class DeveloperModeState(
    // Authentication Section
    val showCustomHomeserver: Boolean,
    val showQRCodeLogin: Boolean,
    // Spaces Section
    val groupSpaceRooms: Boolean,
    val spaceSettingsEnabled: Boolean,
    // Settings Section
    val showDeveloperSettings: Boolean,
    val eventSink: (DeveloperModeEvents) -> Unit,
)
