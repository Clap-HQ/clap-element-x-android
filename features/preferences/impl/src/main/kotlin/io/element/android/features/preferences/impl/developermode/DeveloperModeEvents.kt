/*
 * Copyright (c) 2025 Element Creations Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.developermode

sealed interface DeveloperModeEvents {
    // Authentication Section
    data class SetShowCustomHomeserver(val enabled: Boolean) : DeveloperModeEvents
    data class SetShowQRCodeLogin(val enabled: Boolean) : DeveloperModeEvents
    // Spaces Section
    data class SetGroupSpaceRooms(val enabled: Boolean) : DeveloperModeEvents
    data class SetSpaceSettingsEnabled(val enabled: Boolean) : DeveloperModeEvents
    // Settings Section
    data class SetShowDeveloperSettings(val enabled: Boolean) : DeveloperModeEvents
}
