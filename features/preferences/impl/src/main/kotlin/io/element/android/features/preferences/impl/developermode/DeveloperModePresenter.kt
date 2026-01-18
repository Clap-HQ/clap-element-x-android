/*
 * Copyright (c) 2025 Element Creations Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.developermode

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import dev.zacsweers.metro.Inject
import io.element.android.libraries.architecture.Presenter
import io.element.android.libraries.featureflag.api.FeatureFlagService
import io.element.android.libraries.featureflag.api.FeatureFlags
import io.element.android.libraries.preferences.api.store.AppPreferencesStore
import kotlinx.coroutines.launch

@Inject
class DeveloperModePresenter(
    private val appPreferencesStore: AppPreferencesStore,
    private val featureFlagService: FeatureFlagService,
) : Presenter<DeveloperModeState> {
    @Composable
    override fun present(): DeveloperModeState {
        val coroutineScope = rememberCoroutineScope()

        // Authentication Section
        val showCustomHomeserver by appPreferencesStore
            .isShowCustomHomeserverEnabledFlow()
            .collectAsState(initial = false)

        val showQRCodeLogin by appPreferencesStore
            .isShowQRCodeLoginEnabledFlow()
            .collectAsState(initial = false)

        // Spaces Section
        val groupSpaceRooms by appPreferencesStore
            .isGroupSpaceRoomsEnabledFlow()
            .collectAsState(initial = true)

        // FeatureFlags.SpaceSettings 값 연동
        val spaceSettingsEnabled by featureFlagService
            .isFeatureEnabledFlow(FeatureFlags.SpaceSettings)
            .collectAsState(initial = false)

        // Settings Section
        val showDeveloperSettings by appPreferencesStore
            .isShowDeveloperSettingsEnabledFlow()
            .collectAsState(initial = false)

        fun handleEvent(event: DeveloperModeEvents) {
            when (event) {
                is DeveloperModeEvents.SetShowCustomHomeserver -> coroutineScope.launch {
                    appPreferencesStore.setShowCustomHomeserver(event.enabled)
                }
                is DeveloperModeEvents.SetShowQRCodeLogin -> coroutineScope.launch {
                    appPreferencesStore.setShowQRCodeLogin(event.enabled)
                }
                is DeveloperModeEvents.SetGroupSpaceRooms -> coroutineScope.launch {
                    appPreferencesStore.setGroupSpaceRooms(event.enabled)
                }
                is DeveloperModeEvents.SetSpaceSettingsEnabled -> coroutineScope.launch {
                    featureFlagService.setFeatureEnabled(FeatureFlags.SpaceSettings, event.enabled)
                }
                is DeveloperModeEvents.SetShowDeveloperSettings -> coroutineScope.launch {
                    appPreferencesStore.setShowDeveloperSettings(event.enabled)
                }
            }
        }

        return DeveloperModeState(
            // Authentication Section
            showCustomHomeserver = showCustomHomeserver,
            showQRCodeLogin = showQRCodeLogin,
            // Spaces Section
            groupSpaceRooms = groupSpaceRooms,
            spaceSettingsEnabled = spaceSettingsEnabled,
            // Settings Section
            showDeveloperSettings = showDeveloperSettings,
            eventSink = ::handleEvent,
        )
    }
}
