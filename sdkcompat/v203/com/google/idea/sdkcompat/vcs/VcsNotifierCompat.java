/*
 * Copyright 2021 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.idea.sdkcompat.vcs;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.VcsNotifier;
import org.jetbrains.annotations.NonNls;

/**
 * Compat for {@link VcsNotifier}. Logging methods take an additional displayId starting with
 * 2020.3.
 *
 * <p>#api202
 */
public final class VcsNotifierCompat {
  private VcsNotifierCompat() {}

  public static void logInfo(
      Project project, @NonNls String displayId, String title, String message) {
    VcsNotifier.getInstance(project).logInfo(displayId, title, message);
  }
}
