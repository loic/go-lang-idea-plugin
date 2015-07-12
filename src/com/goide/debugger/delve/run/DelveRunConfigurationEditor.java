/*
 * Copyright 2013-2015 Sergey Ignatov, Alexander Zolotov, Mihai Toader, Florin Patan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.debugger.delve.run;

import com.goide.runconfig.GoRunUtil;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DelveRunConfigurationEditor extends SettingsEditor<DelveRunConfiguration> {
  private JPanel myPanel;
  private TextFieldWithBrowseButton myDelvePath;
  private TextFieldWithBrowseButton myAppPath;
  private JTextArea myStartupCommands;

  public DelveRunConfigurationEditor(Project project) {
    GoRunUtil.installFileChooser(project, myAppPath, false);
    GoRunUtil.installFileChooser(project, myDelvePath, false);
  }

  @Override
  protected void resetEditorFrom(@NotNull DelveRunConfiguration configuration) {
    myDelvePath.setText(configuration.DELVE_PATH);
    myAppPath.setText(configuration.APP_PATH);
    myStartupCommands.setText(configuration.STARTUP_COMMANDS);
  }

  @Override
  protected void applyEditorTo(@NotNull DelveRunConfiguration configuration) throws ConfigurationException {
    configuration.DELVE_PATH = myDelvePath.getText();
    configuration.APP_PATH = myAppPath.getText();
    configuration.STARTUP_COMMANDS = myStartupCommands.getText();
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myPanel;
  }

  @Override
  protected void disposeEditor() {
  }
}
