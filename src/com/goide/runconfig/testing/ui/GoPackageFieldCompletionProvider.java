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

package com.goide.runconfig.testing.ui;

import com.goide.completion.GoImportPathsCompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.openapi.module.Module;
import com.intellij.util.Producer;
import com.intellij.util.TextFieldCompletionProvider;
import org.jetbrains.annotations.NotNull;

public class GoPackageFieldCompletionProvider extends TextFieldCompletionProvider {
  @NotNull private final Producer<Module> myModuleProducer;

  public GoPackageFieldCompletionProvider(@NotNull Producer<Module> moduleProducer) {
    myModuleProducer = moduleProducer;
  }

  @Override
  protected void addCompletionVariants(@NotNull String text,
                                       int offset,
                                       @NotNull String prefix,
                                       @NotNull final CompletionResultSet result) {
    GoImportPathsCompletionProvider.addCompletions(result, myModuleProducer.produce(), null, false);
  }
}
