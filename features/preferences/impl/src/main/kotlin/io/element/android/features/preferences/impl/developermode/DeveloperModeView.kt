/*
 * Copyright (c) 2025 Element Creations Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.developermode

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import io.element.android.features.preferences.impl.R
import io.element.android.libraries.designsystem.components.preferences.PreferenceCategory
import io.element.android.libraries.designsystem.components.preferences.PreferencePage
import io.element.android.libraries.designsystem.components.preferences.PreferenceSwitch
import io.element.android.libraries.designsystem.preview.ElementPreview
import io.element.android.libraries.designsystem.preview.PreviewsDayNight

@Composable
fun DeveloperModeView(
    state: DeveloperModeState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PreferencePage(
        modifier = modifier,
        onBackClick = onBackClick,
        title = stringResource(id = R.string.screen_developer_mode_title)
    ) {
        // Authentication Section
        PreferenceCategory(
            title = stringResource(id = R.string.screen_developer_mode_section_authentication),
        ) {
            PreferenceSwitch(
                title = stringResource(id = R.string.screen_developer_mode_show_custom_homeserver),
                subtitle = stringResource(id = R.string.screen_developer_mode_show_custom_homeserver_description),
                isChecked = state.showCustomHomeserver,
                onCheckedChange = {
                    state.eventSink(DeveloperModeEvents.SetShowCustomHomeserver(it))
                }
            )
            PreferenceSwitch(
                title = stringResource(id = R.string.screen_developer_mode_show_qr_code_login),
                subtitle = stringResource(id = R.string.screen_developer_mode_show_qr_code_login_description),
                isChecked = state.showQRCodeLogin,
                onCheckedChange = {
                    state.eventSink(DeveloperModeEvents.SetShowQRCodeLogin(it))
                }
            )
        }

        // Spaces Section
        PreferenceCategory(
            title = stringResource(id = R.string.screen_developer_mode_section_spaces),
        ) {
            PreferenceSwitch(
                title = stringResource(id = R.string.screen_developer_mode_group_space_rooms),
                subtitle = stringResource(id = R.string.screen_developer_mode_group_space_rooms_description),
                isChecked = state.groupSpaceRooms,
                onCheckedChange = {
                    state.eventSink(DeveloperModeEvents.SetGroupSpaceRooms(it))
                }
            )
            PreferenceSwitch(
                title = stringResource(id = R.string.screen_developer_mode_space_settings_enabled),
                subtitle = stringResource(id = R.string.screen_developer_mode_space_settings_enabled_description),
                isChecked = state.spaceSettingsEnabled,
                onCheckedChange = {
                    state.eventSink(DeveloperModeEvents.SetSpaceSettingsEnabled(it))
                }
            )
        }

        // Settings Section
        PreferenceCategory(
            title = stringResource(id = R.string.screen_developer_mode_section_settings),
        ) {
            PreferenceSwitch(
                title = stringResource(id = R.string.screen_developer_mode_show_developer_settings),
                subtitle = stringResource(id = R.string.screen_developer_mode_show_developer_settings_description),
                isChecked = state.showDeveloperSettings,
                onCheckedChange = {
                    state.eventSink(DeveloperModeEvents.SetShowDeveloperSettings(it))
                }
            )
        }
    }
}

@PreviewsDayNight
@Composable
internal fun DeveloperModeViewPreview(
    @PreviewParameter(DeveloperModeStateProvider::class) state: DeveloperModeState
) = ElementPreview {
    DeveloperModeView(
        state = state,
        onBackClick = {},
    )
}
